package com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Campo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.InicializadorLista;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.OperadorBinario;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Instruccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.c3d.Cuarteta.Operador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.InfoEstructura;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.Simbolo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.enviroment.TablaSimbolos;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class ContextoC3D {

    static final String MARCO = "@MARCO@";

    private final TablaSimbolos tabla;
    private final Map<Nodo, String> nombres = new HashMap<>();
    private final Map<String, List<Cuarteta>> funciones = new LinkedHashMap<>();
    private final Set<String> nativasUsadas = new LinkedHashSet<>();
    private final Map<String, Boolean> requiereInicio = new HashMap<>();
    private List<Cuarteta> actual = new ArrayList<>();
    private List<Cuarteta> principal = new ArrayList<>();
    private int desplazamiento;
    private int temporales;
    private int etiquetas;
    private final Set<String> pendientes = new LinkedHashSet<>();
    private final Deque<String> salidas = new ArrayDeque<>();
    private final Deque<String> continuaciones = new ArrayDeque<>();

    public ContextoC3D(TablaSimbolos tabla) {
        this.tabla = tabla;
    }

    public TablaSimbolos tabla() {
        return tabla;
    }


    public void nombrar(Nodo declaracion, String nombre) {
        nombres.put(declaracion, identificadorC(nombre));
    }

    public String nombre(Nodo declaracion) {
        return nombres.get(declaracion);
    }

    private static String identificadorC(String texto) {
        String sinAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        return sinAcentos.replaceAll("[^A-Za-z0-9_]", "_");
    }

    public void iniciarFuncion(int reservadas) {
        actual = new ArrayList<>();
        desplazamiento = reservadas;
        pendientes.clear();
        salidas.clear();
        continuaciones.clear();
    }

    public void terminarFuncion(String nombre) {
        funciones.put(nombre, cerrarMarco());
    }

    public void terminarPrincipal() {
        principal = cerrarMarco();
    }

    private List<Cuarteta> cerrarMarco() {
        String tamano = String.valueOf(desplazamiento);
        Set<String> destinos = new LinkedHashSet<>();
        for (Cuarteta c : actual) {
            if (c.operador() == Operador.SALTO || c.operador().name().startsWith("SI_")) destinos.add(c.resultado());
        }
        List<Cuarteta> resultado = new ArrayList<>();
        for (Cuarteta c : actual) {
            if (c.operador() == Operador.ETIQUETA && !destinos.contains(c.resultado())) continue;
            resultado.add(c.reemplazar(MARCO, tamano));
        }
        return resultado;
    }

    public int reservar() {
        return desplazamiento++;
    }

    Map<String, List<Cuarteta>> getFunciones() {
        return funciones;
    }

    List<Cuarteta> getPrincipal() {
        return principal;
    }

    Set<String> getNativasUsadas() {
        return nativasUsadas;
    }

    int getTemporales() {
        return temporales;
    }

    public String temporal() {
        String t = "t" + (++temporales);
        pendientes.add(t);
        return t;
    }

    private String interno() {
        return "t" + (++temporales);
    }

    public String etiqueta() {
        return "L" + (++etiquetas);
    }

    public void emitir(Operador operador, String arg1, String arg2, String resultado) {
        actual.add(new Cuarteta(operador, arg1, arg2, resultado));
    }

    public void usar(String... valores) {
        for (String v : valores) pendientes.remove(v);
    }

    public void usar(List<String> valores) {
        valores.forEach(pendientes::remove);
    }

    public void mantener(String valor) {
        if (valor.startsWith("t")) pendientes.add(valor);
    }

    public void colocar(String etiqueta) {
        emitir(Operador.ETIQUETA, null, null, etiqueta);
    }

    public void saltar(String etiqueta) {
        emitir(Operador.SALTO, null, null, etiqueta);
    }

    public void saltarSi(Operador relacion, String a, String b, String etiqueta) {
        usar(a, b);
        emitir(relacion, a, b, etiqueta);
    }

    public void saltarSiFalso(String condicion, String etiqueta) {
        saltarSi(Operador.SI_IGUAL, condicion, "0", etiqueta);
    }

    public void generar(Instruccion instruccion) {
        instruccion.generar(this);
        finInstruccion();
    }

    public void finInstruccion() {
        pendientes.clear();
    }
    
    public String operar(Operador operador, String a, String b) {
        usar(a, b);
        String t = temporal();
        emitir(operador, a, b, t);
        return t;
    }

    public String unaria(Operador operador, String a) {
        usar(a);
        String t = temporal();
        emitir(operador, a, null, t);
        return t;
    }

    public String copia(String valor) {
        String t = temporal();
        emitir(Operador.ASIGNACION, valor, null, t);
        return t;
    }

    public String asignar(String valor) {
        usar(valor);
        return copia(valor);
    }

    public String binaria(OperadorBinario operador, String a, Tipo tipoA, String b, Tipo tipoB, Tipo resultado,
                          Lenguaje lenguaje) {
        if (operador == OperadorBinario.SUMA && resultado.es(Tipo.Base.CADENA)) {
            String cadenaA = aCadena(a, tipoA, lenguaje);
            String cadenaB = aCadena(b, tipoB, lenguaje);
            return llamar(Nativas.CONCATENAR, List.of(cadenaA, cadenaB));
        }
        boolean igualdad = operador == OperadorBinario.IGUAL || operador == OperadorBinario.DIFERENTE;
        if (igualdad && tipoA.es(Tipo.Base.CADENA) && tipoB.es(Tipo.Base.CADENA)) {
            String iguales = llamar(Nativas.COMPARAR_CADENAS, List.of(a, b));
            return operador == OperadorBinario.IGUAL ? iguales : operar(Operador.IGUAL, iguales, "0");
        }
        String r = operar(operadorC3D(operador), a, b);
        if (operador == OperadorBinario.DIVISION && resultado.es(Tipo.Base.ENTERO)) r = unaria(Operador.TRUNCAR, r);
        return r;
    }

    private static Operador operadorC3D(OperadorBinario operador) {
        return switch (operador) {
            case SUMA -> Operador.SUMA;
            case RESTA -> Operador.RESTA;
            case MULTIPLICACION -> Operador.MULTIPLICACION;
            case DIVISION -> Operador.DIVISION;
            case MODULO -> Operador.MODULO;
            case MENOR -> Operador.MENOR;
            case MAYOR -> Operador.MAYOR;
            case MENOR_IGUAL -> Operador.MENOR_IGUAL;
            case MAYOR_IGUAL -> Operador.MAYOR_IGUAL;
            case IGUAL -> Operador.IGUAL;
            case DIFERENTE -> Operador.DIFERENTE;
            default -> throw new IllegalArgumentException(operador.toString());
        };
    }

    public String cargar(String memoria, String indice) {
        usar(indice);
        String t = temporal();
        emitir(Direccion.STACK.equals(memoria) ? Operador.CARGAR_STACK : Operador.CARGAR_HEAP, indice, null, t);
        return t;
    }

    public String cargar(Direccion direccion) {
        return cargar(direccion.memoria(), direccion.indice());
    }

    public String leer(Direccion direccion) {
        String t = temporal();
        Operador op = Direccion.STACK.equals(direccion.memoria()) ? Operador.CARGAR_STACK : Operador.CARGAR_HEAP;
        emitir(op, direccion.indice(), null, t);
        return t;
    }

    public void guardar(String memoria, String indice, String valor) {
        usar(indice, valor);
        emitir(Direccion.STACK.equals(memoria) ? Operador.GUARDAR_STACK : Operador.GUARDAR_HEAP, valor, null, indice);
    }

    public void guardar(Direccion direccion, String valor) {
        guardar(direccion.memoria(), direccion.indice(), valor);
    }

    public Direccion local(int desplazamiento) {
        return new Direccion(Direccion.STACK, operar(Operador.SUMA, "P", String.valueOf(desplazamiento)));
    }

    public String cargarLocal(int desplazamiento) {
        return cargar(local(desplazamiento));
    }

    public void guardarLocal(int desplazamiento, String valor) {
        guardar(local(desplazamiento), valor);
    }

    public String este() {
        return cargarLocal(1);
    }

    public String heap(String tamano) {
        usar(tamano);
        String t = temporal();
        emitir(Operador.ASIGNACION, "H", null, t);
        emitir(Operador.SUMA, "H", tamano, "H");
        return t;
    }

    public void copiar(String destino, String origen, int tamano) {
        String r = llamar(Nativas.COPIAR, List.of(copia(destino), origen, String.valueOf(tamano)));
        usar(r);
    }

    public String llamar(String funcion, List<String> argumentos) {
        if (Nativas.esNativa(funcion)) nativasUsadas.add(funcion);
        usar(argumentos);
        List<String> vivos = new ArrayList<>(pendientes);

        String base = interno();
        emitir(Operador.SUMA, "P", MARCO, base);
        for (int i = 0; i < vivos.size(); i++) {
            String posicion = interno();
            emitir(Operador.SUMA, base, String.valueOf(i), posicion);
            emitir(Operador.GUARDAR_STACK, vivos.get(i), null, posicion);
        }
        String marco = interno();
        emitir(Operador.SUMA, base, String.valueOf(vivos.size()), marco);
        for (int i = 0; i < argumentos.size(); i++) {
            String posicion = interno();
            emitir(Operador.SUMA, marco, String.valueOf(i + 1), posicion);
            emitir(Operador.GUARDAR_STACK, argumentos.get(i), null, posicion);
        }
        emitir(Operador.ASIGNACION, marco, null, "P");
        emitir(Operador.LLAMADA, funcion, null, null);
        String resultado = interno();
        emitir(Operador.CARGAR_STACK, "P", null, resultado);
        emitir(Operador.RESTA, "P", MARCO, "P");
        if (!vivos.isEmpty()) emitir(Operador.RESTA, "P", String.valueOf(vivos.size()), "P");
        for (int i = 0; i < vivos.size(); i++) {
            String posicion = interno();
            emitir(Operador.SUMA, "P", MARCO, posicion);
            emitir(Operador.SUMA, posicion, String.valueOf(i), posicion);
            emitir(Operador.CARGAR_STACK, posicion, null, vivos.get(i));
        }
        pendientes.add(resultado);
        return resultado;
    }

    public String cadena(String texto) {
        String t = temporal();
        emitir(Operador.ASIGNACION, "H", null, t);
        for (byte b : texto.getBytes(StandardCharsets.UTF_8)) {
            emitir(Operador.GUARDAR_HEAP, String.valueOf(b & 0xFF), null, "H");
            emitir(Operador.SUMA, "H", "1", "H");
        }
        emitir(Operador.GUARDAR_HEAP, "0", null, "H");
        emitir(Operador.SUMA, "H", "1", "H");
        return t;
    }

    public String aCadena(String valor, Tipo tipo, Lenguaje lenguaje) {
        return switch (tipo.getBase()) {
            case CADENA -> valor;
            case ENTERO -> llamar(Nativas.ENTERO_A_CADENA, List.of(valor));
            case DECIMAL -> llamar(Nativas.DECIMAL_A_CADENA, List.of(valor));
            case CARACTER -> {
                usar(valor);
                String t = temporal();
                emitir(Operador.ASIGNACION, "H", null, t);
                emitir(Operador.GUARDAR_HEAP, valor, null, "H");
                emitir(Operador.SUMA, "H", "1", "H");
                emitir(Operador.GUARDAR_HEAP, "0", null, "H");
                emitir(Operador.SUMA, "H", "1", "H");
                yield t;
            }
            case BOOLEANO -> {
                String r = temporal();
                String falso = etiqueta();
                String fin = etiqueta();
                saltarSiFalso(valor, falso);
                String verdadero = cadena(palabraBooleana(lenguaje, true));
                usar(verdadero);
                emitir(Operador.ASIGNACION, verdadero, null, r);
                saltar(fin);
                colocar(falso);
                String textoFalso = cadena(palabraBooleana(lenguaje, false));
                usar(textoFalso);
                emitir(Operador.ASIGNACION, textoFalso, null, r);
                colocar(fin);
                yield r;
            }
            default -> {
                usar(valor);
                yield cadena("null");
            }
        };
    }

    public void imprimir(String valor, Tipo tipo, Lenguaje lenguaje) {
        switch (tipo.getBase()) {
            case ENTERO -> {
                usar(valor);
                emitir(Operador.IMPRIMIR_ENTERO, valor, null, null);
            }
            case CARACTER -> {
                usar(valor);
                emitir(Operador.IMPRIMIR_CARACTER, valor, null, null);
            }
            default -> usar(llamar(Nativas.IMPRIMIR_CADENA, List.of(aCadena(valor, tipo, lenguaje))));
        }
    }

    public void saltoDeLinea() {
        emitir(Operador.IMPRIMIR_CARACTER, "10", null, null);
    }

    public String convertirLectura(String cadena, Tipo destino) {
        return switch (destino.getBase()) {
            case ENTERO -> llamar(Nativas.CADENA_A_ENTERO, List.of(cadena));
            case DECIMAL -> llamar(Nativas.CADENA_A_DECIMAL, List.of(cadena));
            case CARACTER -> cargar(Direccion.HEAP, cadena);
            case BOOLEANO -> {
                // verdadero si empieza con t (true), v (verdadero, verum) o 1
                String primera = cargar(Direccion.HEAP, cadena);
                String r = temporal();
                String si = etiqueta();
                String fin = etiqueta();
                emitir(Operador.ASIGNACION, "0", null, r);
                emitir(Operador.SI_IGUAL, primera, "116", si);
                emitir(Operador.SI_IGUAL, primera, "118", si);
                emitir(Operador.SI_IGUAL, primera, "49", si);
                usar(primera);
                saltar(fin);
                colocar(si);
                emitir(Operador.ASIGNACION, "1", null, r);
                colocar(fin);
                yield r;
            }
            default -> cadena;
        };
    }

    private static String palabraBooleana(Lenguaje lenguaje, boolean valor) {
        return switch (lenguaje) {
            case Y -> valor ? "verdadero" : "falso";
            case ZETARIANO -> valor ? "true" : "false";
            case PIG_LATIN -> valor ? "verum" : "falsus";
        };
    }

    public void entrarCiclo(String salida, String continuacion) {
        salidas.push(salida);
        continuaciones.push(continuacion);
    }

    public void salirCiclo() {
        salidas.pop();
        continuaciones.pop();
    }

    public void entrarSeleccion(String salida) {
        salidas.push(salida);
    }

    public void salirSeleccion() {
        salidas.pop();
    }

    public String salidaActual() {
        return salidas.peek();
    }

    public String continuacionActual() {
        return continuaciones.peek();
    }

    public InfoEstructura estructura(Tipo tipo) {
        return tabla.estructura(tipo.getNombre());
    }

    public int tamanoElemento(Tipo base) {
        return base.es(Tipo.Base.ESTRUCTURA) ? tamanoEstructura(estructura(base)) : 1;
    }

    public int tamanoEstructura(InfoEstructura estructura) {
        int total = 0;
        for (Simbolo campo : estructura.getCampos().values()) total += tamanoCampo(campo);
        return Math.max(total, 1);
    }

    public int tamanoCampo(Simbolo campo) {
        Tipo tipo = campo.getTipo();
        if (!tipo.esArreglo()) return tamanoElemento(tipo);
        List<Integer> dimensiones = dimensionesCampo(campo);
        return dimensiones.size() + producto(dimensiones) * tamanoElemento(tipo.tipoBase());
    }

    public List<Integer> dimensionesCampo(Simbolo campo) {
        List<Integer> resultado = new ArrayList<>();
        if (campo.getDeclaracion() instanceof Campo c) {
            for (Expresion d : c.getDimensiones()) resultado.add(d.valorConstante() instanceof Integer i ? i : 0);
        }
        return resultado;
    }

    public int desplazamientoCampo(InfoEstructura estructura, String nombre) {
        int desplazamiento = 0;
        for (Simbolo campo : estructura.getCampos().values()) {
            if (campo.getNombre().equals(nombre)) return desplazamiento;
            desplazamiento += tamanoCampo(campo);
        }
        throw new IllegalArgumentException("Campo inexistente: " + nombre);
    }

    private static int producto(List<Integer> valores) {
        int p = 1;
        for (int v : valores) p *= v;
        return p;
    }

    private boolean requiereInicio(Tipo base) {
        if (!base.es(Tipo.Base.ESTRUCTURA)) return false;
        return requiereInicio.computeIfAbsent(base.getNombre(), n -> {
            for (Simbolo campo : estructura(base).getCampos().values()) {
                if (campo.getTipo().esArreglo() || requiereInicio(campo.getTipo())) return true;
            }
            return false;
        });
    }
    
    public String nuevaEstructura(Tipo tipo) {
        InfoEstructura info = estructura(tipo);
        String bloque = heap(String.valueOf(tamanoEstructura(info)));
        if (requiereInicio(tipo)) inicializarEstructura(info, bloque);
        return bloque;
    }

    private void inicializarEstructura(InfoEstructura info, String bloque) {
        for (Simbolo campo : info.getCampos().values()) {
            Tipo tipo = campo.getTipo();
            if (!tipo.esArreglo() && !requiereInicio(tipo)) continue;
            String posicion = interno();
            emitir(Operador.SUMA, bloque, String.valueOf(desplazamientoCampo(info, campo.getNombre())), posicion);
            if (!tipo.esArreglo()) {
                inicializarEstructura(estructura(tipo), posicion);
                continue;
            }
            List<Integer> dimensiones = dimensionesCampo(campo);
            escribirCabecera(posicion, dimensiones.stream().map(String::valueOf).toList());
            Tipo base = tipo.tipoBase();
            if (requiereInicio(base)) {
                recorrerElementos(posicion, dimensiones.size(), String.valueOf(producto(dimensiones)),
                        tamanoElemento(base), elemento -> inicializarEstructura(estructura(base), elemento));
            }
        }
    }

    private void escribirCabecera(String arreglo, List<String> tamanos) {
        for (int k = 0; k < tamanos.size(); k++) {
            String posicion = interno();
            emitir(Operador.SUMA, arreglo, String.valueOf(k), posicion);
            emitir(Operador.GUARDAR_HEAP, tamanos.get(k), null, posicion);
        }
    }

    private void recorrerElementos(String arreglo, int dimensiones, String total, int tamano, Consumer<String> accion) {
        String i = interno();
        String inicio = etiqueta();
        String fin = etiqueta();
        emitir(Operador.ASIGNACION, "0", null, i);
        colocar(inicio);
        emitir(Operador.SI_MAYOR_IGUAL, i, total, fin);
        String desplazamientoElemento = interno();
        emitir(Operador.MULTIPLICACION, i, String.valueOf(tamano), desplazamientoElemento);
        String elemento = interno();
        emitir(Operador.SUMA, arreglo, String.valueOf(dimensiones), elemento);
        emitir(Operador.SUMA, elemento, desplazamientoElemento, elemento);
        accion.accept(elemento);
        emitir(Operador.SUMA, i, "1", i);
        saltar(inicio);
        colocar(fin);
    }

    public String nuevoArreglo(Tipo tipo, List<String> tamanos) {
        int dimensiones = tipo.getDimensiones();
        List<String> completos = new ArrayList<>(tamanos);
        while (completos.size() < dimensiones) completos.add("0");
        Tipo base = tipo.tipoBase();
        int tamanoBase = tamanoElemento(base);

        String total = interno();
        emitir(Operador.ASIGNACION, completos.get(0), null, total);
        for (int k = 1; k < dimensiones; k++) emitir(Operador.MULTIPLICACION, total, completos.get(k), total);
        String espacio = interno();
        emitir(Operador.MULTIPLICACION, total, String.valueOf(tamanoBase), espacio);
        emitir(Operador.SUMA, espacio, String.valueOf(dimensiones), espacio);
        String arreglo = heap(espacio);
        escribirCabecera(arreglo, completos);
        if (requiereInicio(base)) {
            recorrerElementos(arreglo, dimensiones, total, tamanoBase,
                    elemento -> inicializarEstructura(estructura(base), elemento));
        }
        usar(tamanos);
        return arreglo;
    }

    public String elemento(String arreglo, List<String> indices, Tipo tipoArreglo) {
        String lineal = interno();
        emitir(Operador.ASIGNACION, indices.get(0), null, lineal);
        for (int k = 1; k < indices.size(); k++) {
            String posicion = interno();
            emitir(Operador.SUMA, arreglo, String.valueOf(k), posicion);
            String tamano = interno();
            emitir(Operador.CARGAR_HEAP, posicion, null, tamano);
            emitir(Operador.MULTIPLICACION, lineal, tamano, lineal);
            emitir(Operador.SUMA, lineal, indices.get(k), lineal);
        }
        int tamanoBase = tamanoElemento(tipoArreglo.tipoBase());
        if (tamanoBase != 1) emitir(Operador.MULTIPLICACION, lineal, String.valueOf(tamanoBase), lineal);
        usar(indices);
        usar(arreglo);
        String direccion = temporal();
        emitir(Operador.SUMA, arreglo, String.valueOf(tipoArreglo.getDimensiones()), direccion);
        emitir(Operador.SUMA, direccion, lineal, direccion);
        return direccion;
    }

    public String crearDesdeLista(Tipo tipo, InicializadorLista lista, List<Expresion> dimensiones) {
        int d = tipo.getDimensiones();
        List<Integer> forma = forma(lista, d);
        List<String> tamanos = new ArrayList<>();
        List<Integer> constantes = new ArrayList<>();
        for (int k = 0; k < d; k++) {
            if (k < dimensiones.size() && dimensiones.get(k).valorConstante() instanceof Integer c) {
                tamanos.add(String.valueOf(c));
                constantes.add(c);
            } else if (k < dimensiones.size()) {
                tamanos.add(dimensiones.get(k).generar(this));
                constantes.add(forma.get(k));
            } else {
                tamanos.add(String.valueOf(forma.get(k)));
                constantes.add(forma.get(k));
            }
        }
        String arreglo = nuevoArreglo(tipo, tamanos);
        llenar(tipo, lista, arreglo, constantes);
        return arreglo;
    }

    private static List<Integer> forma(InicializadorLista lista, int dimensiones) {
        List<Integer> forma = new ArrayList<>();
        for (int k = 0; k < dimensiones; k++) forma.add(0);
        medir(lista, 0, forma);
        return forma;
    }

    private static void medir(InicializadorLista lista, int nivel, List<Integer> forma) {
        if (nivel >= forma.size()) return;
        forma.set(nivel, Math.max(forma.get(nivel), lista.getElementos().size()));
        for (Expresion e : lista.getElementos()) {
            if (e instanceof InicializadorLista sub) medir(sub, nivel + 1, forma);
        }
    }

    public void llenar(Tipo tipo, InicializadorLista lista, String bloque, List<Integer> tamanos) {
        if (tipo.esArreglo()) {
            llenarArreglo(tipo, lista, bloque, tamanos, 0, 0);
            return;
        }
        InfoEstructura info = estructura(tipo);
        List<Simbolo> campos = new ArrayList<>(info.getCampos().values());
        List<Expresion> elementos = lista.getElementos();
        for (int i = 0; i < Math.min(campos.size(), elementos.size()); i++) {
            Simbolo campo = campos.get(i);
            Tipo tipoCampo = campo.getTipo();
            List<Integer> dimensiones = tipoCampo.esArreglo() ? dimensionesCampo(campo) : List.of();
            asignarEnBloque(tipoCampo, elementos.get(i), bloque, desplazamientoCampo(info, campo.getNombre()),
                    dimensiones, tamanoCampo(campo));
        }
    }

    private void llenarArreglo(Tipo tipo, InicializadorLista lista, String arreglo, List<Integer> tamanos,
                               int nivel, int prefijo) {
        int d = tipo.getDimensiones();
        Tipo base = tipo.tipoBase();
        int tamanoBase = tamanoElemento(base);
        List<Expresion> elementos = lista.getElementos();
        for (int j = 0; j < elementos.size(); j++) {
            int lineal = prefijo * (nivel < tamanos.size() ? tamanos.get(nivel) : elementos.size()) + j;
            Expresion e = elementos.get(j);
            if (nivel < d - 1 && e instanceof InicializadorLista sub) {
                llenarArreglo(tipo, sub, arreglo, tamanos, nivel + 1, lineal);
            } else {
                asignarEnBloque(base, e, arreglo, d + lineal * tamanoBase, List.of(), tamanoBase);
            }
        }
    }

    private void asignarEnBloque(Tipo tipo, Expresion valor, String bloque, int desplazamiento,
                                 List<Integer> dimensiones, int tamano) {
        boolean enLinea = tipo.esArreglo() || tipo.es(Tipo.Base.ESTRUCTURA);
        if (enLinea && valor instanceof InicializadorLista sub) {
            String posicion = temporal();
            emitir(Operador.SUMA, bloque, String.valueOf(desplazamiento), posicion);
            llenar(tipo, sub, posicion, dimensiones);
            usar(posicion);
            return;
        }
        String v = valor.generar(this);
        if (enLinea) {
            String posicion = temporal();
            emitir(Operador.SUMA, bloque, String.valueOf(desplazamiento), posicion);
            copiar(posicion, v, tamano);
            usar(posicion);
            return;
        }
        String posicion = interno();
        emitir(Operador.SUMA, bloque, String.valueOf(desplazamiento), posicion);
        guardar(Direccion.HEAP, posicion, v);
    }
}
