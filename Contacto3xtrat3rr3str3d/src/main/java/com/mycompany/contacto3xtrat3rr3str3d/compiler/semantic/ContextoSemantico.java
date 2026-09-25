package com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ErrorCompilacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ErrorCompilacion.TipoError;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Campo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefConstructor;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefFuncion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefMetodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.ModoPaso;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Parametro;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.AccesoCampo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.AccesoIndice;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Identificador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.InicializadorLista;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Leer;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Bloque;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.DeclaracionVariable;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Instruccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoEstructura;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.TablaSimbolos;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Estado compartido del análisis semántico y validaciones que usan varios nodos.
 *
 * Cada nodo del AST se analiza a sí mismo con su método analizar(ctx); este contexto le da
 * acceso a la tabla de símbolos, a la lista de errores y al lugar del recorrido donde está
 * (clase actual, tipo de retorno esperado, si está dentro de un ciclo...).
 */
public class ContextoSemantico {

    private final TablaSimbolos tabla = new TablaSimbolos();
    private final List<ErrorCompilacion> errores = new ArrayList<>();
    private final List<InfoEstructura> estructurasGlobales = new ArrayList<>();
    /** Nombres usados a la vez por una estructura y una clase: ya se reportaron, se ignoran después. */
    private final Set<String> nombresEnConflicto = new HashSet<>();

    // Posición actual del recorrido
    private InfoClase claseActual;
    private Tipo retornoActual;
    private int ciclos;
    private int selecciones;

    // ==================================================================================
    // Estado
    // ==================================================================================

    public TablaSimbolos tabla() {
        return tabla;
    }

    public List<ErrorCompilacion> getErrores() {
        return errores;
    }

    public List<InfoEstructura> getEstructurasGlobales() {
        return estructurasGlobales;
    }

    public void agregarEstructuraGlobal(InfoEstructura estructura) {
        estructurasGlobales.add(estructura);
    }

    public void marcarConflicto(String nombre) {
        nombresEnConflicto.add(nombre);
    }

    public boolean enConflicto(String nombre) {
        return nombresEnConflicto.contains(nombre);
    }

    /** Clase que se está analizando (Zetariano), o null. */
    public InfoClase getClaseActual() {
        return claseActual;
    }

    public void setClaseActual(InfoClase clase) {
        this.claseActual = clase;
    }

    /** Tipo que debe retornar la función actual, o null fuera de una función. */
    public Tipo getRetornoActual() {
        return retornoActual;
    }

    public void setRetornoActual(Tipo tipo) {
        this.retornoActual = tipo;
    }

    public void entrarCiclo() {
        ciclos++;
    }

    public void salirCiclo() {
        ciclos--;
    }

    public boolean enCiclo() {
        return ciclos > 0;
    }

    public void entrarSeleccion() {
        selecciones++;
    }

    public void salirSeleccion() {
        selecciones--;
    }

    public boolean enSeleccion() {
        return selecciones > 0;
    }

    // ==================================================================================
    // Errores y nombres según el lenguaje
    // ==================================================================================

    public void error(Nodo nodo, String mensaje) {
        error(nodo, mensaje, 1);
    }

    public void error(Nodo nodo, String mensaje, int longitud) {
        Ubicacion u = nodo.getUbicacion();
        errores.add(new ErrorCompilacion(TipoError.SEMANTICO, mensaje, u.archivo(), u.linea(), u.columna(), longitud));
    }

    /** Reglas de tipos del lenguaje del nodo. */
    public TablaCompatibilidad compat(Nodo nodo) {
        return TablaCompatibilidad.para(nodo.getLenguaje());
    }

    /** Nombre del tipo como se escribe en el lenguaje del nodo (numerus, int, entero...). */
    public String nombreTipo(Nodo nodo, Tipo tipo) {
        return tipo.nombreEn(nodo.getLenguaje());
    }

    /** Palabra reservada equivalente en el lenguaje del nodo. */
    public String palabra(Nodo nodo, String y, String zetariano, String pigLatin) {
        return switch (nodo.getLenguaje()) {
            case Y -> y;
            case ZETARIANO -> zetariano;
            case PIG_LATIN -> pigLatin;
        };
    }

    // ==================================================================================
    // Tipos
    // ==================================================================================

    /**
     * Verifica que un tipo exista; resuelve los nombres de Pig Latin a estructura o clase.
     * Devuelve Tipo.ERROR si no existe (y reporta el error si {@code reportar}).
     */
    public Tipo resolverTipo(Tipo tipo, Nodo donde, boolean reportar) {
        if (tipo == null) return Tipo.ERROR;
        String nombre = tipo.getNombre();
        if (nombre != null && enConflicto(nombre)) return Tipo.ERROR;
        return switch (tipo.getBase()) {
            case ESTRUCTURA -> {
                if (tabla.buscarEstructura(nombre) != null) yield tipo;
                if (reportar) error(donde, "La estructura '" + nombre + "' no existe");
                yield Tipo.ERROR;
            }
            case CLASE -> {
                if (tabla.buscarClase(nombre) != null) yield tipo;
                if (reportar) error(donde, "La clase '" + nombre + "' no existe");
                yield Tipo.ERROR;
            }
            case NOMBRADO -> {
                if (tabla.buscarEstructura(nombre) != null) yield tipo.resolver(Tipo.Base.ESTRUCTURA);
                if (tabla.buscarClase(nombre) != null) yield tipo.resolver(Tipo.Base.CLASE);
                if (reportar) {
                    error(donde, "El tipo '" + nombre + "' no existe: debe ser una estructura de un .y o una clase de un .z importado");
                }
                yield Tipo.ERROR;
            }
            default -> tipo;
        };
    }

    // ==================================================================================
    // Ámbitos y cuerpos
    // ==================================================================================

    /** Cuerpo de un si o de un ciclo: siempre tiene su propio ámbito, aunque no sea un bloque. */
    public void analizarCuerpo(Instruccion instruccion, String nombreAmbito) {
        tabla.abrir(nombreAmbito);
        if (instruccion instanceof Bloque b) {
            b.getInstrucciones().forEach(i -> i.analizar(this));
        } else if (instruccion != null) {
            instruccion.analizar(this);
        }
        tabla.cerrar();
    }

    /**
     * Función, método o constructor. Parámetros y cuerpo comparten ámbito (no se puede
     * redeclarar un parámetro en el cuerpo). Si tiene tipo de retorno, debe retornar en todos los caminos.
     */
    public void analizarFuncion(String nombre, List<Parametro> parametros, Tipo retorno, Bloque cuerpo,
                                Nodo declaracion, String descripcion) {
        tabla.abrir(nombre);
        retornoActual = retorno;
        ciclos = 0;
        selecciones = 0;
        parametros.forEach(p -> p.declarar(this));
        cuerpo.getInstrucciones().forEach(i -> i.analizar(this));
        boolean conRetorno = retorno.getBase() != Tipo.Base.VACIO && !retorno.esError();
        if (conRetorno && !cuerpo.siempreRetorna()) {
            error(declaracion, descripcion + " debe retornar un valor de tipo " + nombreTipo(declaracion, retorno)
                    + " en todos los caminos");
        }
        retornoActual = null;
        tabla.cerrar();
    }

    // ==================================================================================
    // Valores, listas e inicializadores
    // ==================================================================================

    /**
     * Verifica que {@code valor} pueda guardarse en un destino de tipo {@code destino}.
     * Admite listas {...} y la lectura de consola (que se convierte al tipo del destino).
     */
    public void verificarValor(Tipo destino, Expresion valor, List<Expresion> dimensiones) {
        if (valor instanceof InicializadorLista lista) {
            verificarLista(destino, lista, dimensiones, 0);
            return;
        }
        if (valor instanceof Leer leer) {
            if (!destino.esPrimitivo() && !destino.esError()) {
                error(valor, "No se puede leer un valor de tipo " + nombreTipo(valor, destino));
            } else {
                leer.setTipo(destino); // se convertirá al tipo del destino al generar código
            }
            return;
        }
        Tipo tipo = valor.analizar(this);
        TablaCompatibilidad c = compat(valor);
        if (!c.asignable(destino, tipo)) {
            error(valor, "No se puede asignar un valor de tipo " + c.nombre(tipo) + " a " + c.nombre(destino));
        }
    }

    /** Lista {...} para un arreglo (cada elemento del tipo del elemento) o una estructura (campo por campo). */
    public void verificarLista(Tipo destino, InicializadorLista lista, List<Expresion> dimensiones, int nivel) {
        lista.setTipo(destino);
        List<Expresion> elementos = lista.getElementos();
        if (destino.esError()) {
            elementos.forEach(e -> { if (!(e instanceof InicializadorLista)) e.analizar(this); });
            return;
        }
        if (destino.esArreglo()) {
            Integer tamano = nivel < dimensiones.size() && dimensiones.get(nivel).valorConstante() instanceof Integer i ? i : null;
            if (tamano != null && elementos.size() > tamano) {
                error(lista, "El arreglo tiene tamaño " + tamano + " pero se dieron " + elementos.size() + " valores");
            }
            for (Expresion e : elementos) verificarElemento(destino.elemento(), e, dimensiones, nivel + 1);
            return;
        }
        if (destino.es(Tipo.Base.ESTRUCTURA)) {
            InfoEstructura info = tabla.buscarEstructura(destino.getNombre());
            if (info == null) return;
            List<Simbolo> campos = new ArrayList<>(info.getCampos().values());
            if (campos.size() != elementos.size()) {
                error(lista, "La estructura " + info.getNombre() + " tiene " + campos.size() + " campos pero se dieron "
                        + elementos.size() + " valores");
            }
            for (int i = 0; i < Math.min(campos.size(), elementos.size()); i++) {
                Simbolo campo = campos.get(i);
                List<Expresion> dims = campo.getDeclaracion() instanceof Campo c ? c.getDimensiones() : List.of();
                verificarElemento(campo.getTipo(), elementos.get(i), dims, 0);
            }
            return;
        }
        error(lista, "Un valor de tipo " + nombreTipo(lista, destino) + " no se puede inicializar con una lista {...}");
    }

    private void verificarElemento(Tipo tipo, Expresion elemento, List<Expresion> dimensiones, int nivel) {
        if (elemento instanceof InicializadorLista sub) {
            verificarLista(tipo, sub, dimensiones, nivel);
        } else {
            verificarValor(tipo, elemento, List.of());
        }
    }

    /** Dimensiones declaradas de una variable o campo (para validar el tamaño de las listas). */
    public List<Expresion> dimensionesDe(Expresion destino) {
        if (destino instanceof Identificador id && id.getSimbolo() != null) {
            if (id.getSimbolo().getDeclaracion() instanceof DeclaracionVariable d) return d.getDimensiones();
            if (id.getSimbolo().getDeclaracion() instanceof Campo c) return c.getDimensiones();
        }
        return List.of();
    }

    /** Solo variables, elementos de arreglo y campos/atributos pueden recibir un valor. */
    public boolean verificarAsignable(Expresion e) {
        if (!e.esAsignable()) {
            error(e, "Esta expresión no puede recibir un valor");
            return false;
        }
        return true;
    }

    public void verificarCondicion(Expresion condicion) {
        Tipo t = condicion.analizar(this);
        if (!t.es(Tipo.Base.BOOLEANO) && !t.esError()) {
            error(condicion, "La condición debe ser de tipo " + nombreTipo(condicion, Tipo.BOOLEANO)
                    + " (se obtuvo " + nombreTipo(condicion, t) + ")");
        }
    }

    // ==================================================================================
    // Llamadas y sobrecarga
    // ==================================================================================

    public List<Tipo> tiposArgumentos(List<Expresion> argumentos) {
        List<Tipo> tipos = new ArrayList<>();
        for (Expresion a : argumentos) tipos.add(a.analizar(this));
        return tipos;
    }

    /**
     * Funciones de Y?: los primitivos se pasan por valor; arreglos y estructuras por referencia,
     * así que el argumento debe ser una variable exactamente del mismo tipo.
     */
    public void verificarArgumentosFuncion(DefFuncion f, List<Expresion> argumentos, List<Tipo> tipos, Nodo llamada) {
        List<Parametro> parametros = f.getParametros();
        if (parametros.size() != argumentos.size()) {
            error(llamada, "La función '" + f.getNombre() + "' espera " + parametros.size() + " argumento(s) y recibió "
                    + argumentos.size());
            return;
        }
        TablaCompatibilidad c = compat(llamada);
        for (int i = 0; i < parametros.size(); i++) {
            Parametro p = parametros.get(i);
            Tipo tipoParametro = resolverTipo(p.getTipo(), p, false);
            Tipo tipoArgumento = tipos.get(i);
            Expresion argumento = argumentos.get(i);
            if (tipoArgumento.esError() || tipoParametro.esError()) continue;
            if (p.getModo() == ModoPaso.REFERENCIA) {
                boolean esVariable = argumento instanceof Identificador || argumento instanceof AccesoIndice
                        || argumento instanceof AccesoCampo;
                if (!esVariable) {
                    error(argumento, "El parámetro '" + p.getNombre() + "' se pasa por referencia: el argumento debe ser una variable");
                } else if (!tipoParametro.equals(tipoArgumento)) {
                    error(argumento, "El parámetro '" + p.getNombre() + "' es de tipo " + c.nombre(tipoParametro)
                            + " (por referencia) y se recibió " + c.nombre(tipoArgumento));
                }
            } else if (!c.asignable(tipoParametro, tipoArgumento)) {
                error(argumento, "El parámetro '" + p.getNombre() + "' es de tipo " + c.nombre(tipoParametro)
                        + " y se recibió " + c.nombre(tipoArgumento));
            }
        }
    }

    /** Método de una clase según los argumentos (con sobrecarga); null si no existe o es ambiguo. */
    public DefMetodo resolverMetodo(InfoClase clase, String nombre, List<Tipo> argumentos, Nodo llamada) {
        List<DefMetodo> candidatos = clase.getMetodos(nombre);
        if (candidatos.isEmpty()) {
            error(llamada, "La clase " + clase.getNombre() + " no tiene un método '" + nombre + "'");
            return null;
        }
        if (argumentos.stream().anyMatch(Tipo::esError)) return null;
        Resolucion<DefMetodo> r = resolverSobrecarga(candidatos, DefMetodo::getParametros, argumentos, llamada);
        if (r.ambigua()) {
            error(llamada, "La llamada a '" + nombre + "' es ambigua: varios métodos aceptan esos argumentos");
            return null;
        }
        if (r.elegido() == null) {
            error(llamada, "No existe un método " + nombre + tiposTexto(argumentos, llamada) + " en la clase " + clase.getNombre());
        }
        return r.elegido();
    }

    /** Constructor de una clase según los argumentos (con sobrecarga); null si no existe o es ambiguo. */
    public DefConstructor resolverConstructor(InfoClase clase, List<Tipo> argumentos, Nodo llamada) {
        if (argumentos.stream().anyMatch(Tipo::esError)) return null;
        Resolucion<DefConstructor> r = resolverSobrecarga(clase.getConstructores(), DefConstructor::getParametros,
                argumentos, llamada);
        if (r.ambigua()) {
            error(llamada, "La creación de " + clase.getNombre() + " es ambigua: varios constructores aceptan esos argumentos");
        } else if (r.elegido() == null) {
            error(llamada, "No existe un constructor " + clase.getNombre() + tiposTexto(argumentos, llamada));
        }
        return r.elegido();
    }

    private record Resolucion<T>(T elegido, boolean ambigua) {
    }

    /**
     * Elige entre sobrecargas: primero la coincidencia exacta; si no, entre las que aceptan los
     * argumentos con conversiones implícitas, la más específica. Si no hay una única, es ambigua.
     */
    private <T> Resolucion<T> resolverSobrecarga(List<T> candidatos, Function<T, List<Parametro>> parametros,
                                                 List<Tipo> argumentos, Nodo llamada) {
        TablaCompatibilidad c = compat(llamada);
        List<T> aplicables = new ArrayList<>();
        for (T candidato : candidatos) {
            List<Tipo> firma = firma(parametros.apply(candidato));
            if (firma.size() != argumentos.size()) continue;
            boolean acepta = true;
            for (int i = 0; i < firma.size() && acepta; i++) acepta = c.asignable(firma.get(i), argumentos.get(i));
            if (acepta) aplicables.add(candidato);
        }
        if (aplicables.isEmpty()) return new Resolucion<>(null, false);
        for (T candidato : aplicables) {
            if (firma(parametros.apply(candidato)).equals(argumentos)) return new Resolucion<>(candidato, false);
        }
        for (T a : aplicables) {
            List<Tipo> fa = firma(parametros.apply(a));
            boolean masEspecifico = aplicables.stream().allMatch(b -> {
                if (b == a) return true;
                List<Tipo> fb = firma(parametros.apply(b));
                for (int i = 0; i < fa.size(); i++) if (!c.asignable(fb.get(i), fa.get(i))) return false;
                return true;
            });
            if (masEspecifico) return new Resolucion<>(a, false);
        }
        return new Resolucion<>(null, true);
    }

    /** Tipos de los parámetros, en orden. */
    public static List<Tipo> firma(List<Parametro> parametros) {
        return parametros.stream().map(Parametro::getTipo).toList();
    }

    /** "(int, String)" con los nombres de tipo del lenguaje del nodo. */
    public String tiposTexto(List<Tipo> tipos, Nodo nodo) {
        return tipos.stream().map(t -> nombreTipo(nodo, t)).collect(Collectors.joining(", ", "(", ")"));
    }
}
