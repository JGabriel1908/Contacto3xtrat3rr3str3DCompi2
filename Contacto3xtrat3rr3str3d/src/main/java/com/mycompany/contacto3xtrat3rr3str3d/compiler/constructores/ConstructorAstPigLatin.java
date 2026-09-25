package com.mycompany.contacto3xtrat3rr3str3d.compiler.constructores;

import com.mycompany.C3.grammar.PigLatinParser;
import com.mycompany.C3.grammar.PigLatinParserBaseVisitor;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.UnidadPigLatin;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Import;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.AccesoCampo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.AccesoIndice;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Asignacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Binaria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Identificador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Incremento;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.InicializadorLista;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Literal;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.LlamadaFuncion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.LlamadaMetodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.NuevoObjeto;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.OperadorBinario;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.OperadorUnario;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Unaria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Bloque;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Continuar;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.DeclaracionVariable;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.HacerMientras;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Imprimir;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Instruccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.InstruccionExpresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.InstruccionLeer;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Mientras;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Para;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Romper;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Si;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Convierte el árbol de ANTLR de un archivo .pig en el AST común.
 */
public class ConstructorAstPigLatin extends PigLatinParserBaseVisitor<Nodo> {

    private final ContextoConstruccion ctx;

    public ConstructorAstPigLatin(ContextoConstruccion ctx) {
        this.ctx = ctx;
    }

    public UnidadPigLatin construir(PigLatinParser.ProgramaContext programa) {
        List<Import> imports = new ArrayList<>();
        for (PigLatinParser.ImportacionContext i : programa.importacion()) imports.add(importacion(i));

        List<DeclaracionVariable> globales = new ArrayList<>();
        if (programa.seccionVariables() != null) {
            for (PigLatinParser.DeclaracionContext d : programa.seccionVariables().declaracion()) {
                globales.add(declaracion(d.declaracionSimple()));
            }
        }
        PigLatinParser.SeccionPrincipalContext principal = programa.seccionPrincipal();
        Bloque cuerpo = new Bloque(ctx.ubicacion(principal), sentencias(principal.sentencia()));
        return new UnidadPigLatin(ctx.ubicacion(programa), imports, globales, cuerpo);
    }

    /** import carpeta.sub.Archivo.y  ->  "carpeta/sub/Archivo.y" */
    private Import importacion(PigLatinParser.ImportacionContext c) {
        List<TerminalNode> partes = c.ruta().ID();
        StringBuilder ruta = new StringBuilder();
        for (int i = 0; i < partes.size() - 1; i++) {
            if (i > 0) ruta.append('/');
            ruta.append(partes.get(i).getText());
        }
        ruta.append('.').append(partes.get(partes.size() - 1).getText());
        return new Import(ctx.ubicacion(c), ruta.toString(), Lenguaje.desdeNombre(ruta.toString()));
    }

    // ================================================================ declaraciones

    private DeclaracionVariable declaracion(PigLatinParser.DeclaracionSimpleContext c) {
        return switch (c) {
            case PigLatinParser.DeclVariableContext v -> new DeclaracionVariable(ctx.ubicacion(v), tipo(v.tipo()),
                    v.ID().getText(), List.of(), v.valor() == null ? null : valor(v.valor()));
            case PigLatinParser.DeclInferidaContext i -> {
                // esto x : falsus;  /  esto o : novus Persona();  -> el tipo se toma del valor
                Expresion valor;
                Tipo tipo;
                if (i.valorInferido().objetoNuevo() != null) {
                    NuevoObjeto nuevo = objetoNuevo(i.valorInferido().objetoNuevo());
                    valor = nuevo;
                    tipo = Tipo.nombrado(nuevo.getClase());
                } else {
                    Literal literal = literal(i.valorInferido().literal());
                    valor = literal;
                    tipo = literal.getTipo();
                }
                yield new DeclaracionVariable(ctx.ubicacion(i), tipo, i.ID().getText(), List.of(), valor);
            }
            case PigLatinParser.DeclArregloContext a -> {
                List<Expresion> dimensiones = new ArrayList<>();
                for (PigLatinParser.DimensionContext d : a.dimension()) dimensiones.add(expr(d.expr()));
                Expresion inicial = a.inicializadorLista() == null ? null : inicializadorLista(a.inicializadorLista());
                yield new DeclaracionVariable(ctx.ubicacion(a), tipo(a.tipo()).arreglo(dimensiones.size()),
                        a.ID().getText(), dimensiones, inicial);
            }
            default -> throw new IllegalStateException("Declaración desconocida: " + c.getText());
        };
    }

    private Expresion valor(PigLatinParser.ValorContext c) {
        return c.inicializadorLista() != null ? inicializadorLista(c.inicializadorLista()) : expr(c.expr());
    }

    private InicializadorLista inicializadorLista(PigLatinParser.InicializadorListaContext c) {
        List<Expresion> elementos = new ArrayList<>();
        for (PigLatinParser.ValorContext v : c.valor()) elementos.add(valor(v));
        return new InicializadorLista(ctx.ubicacion(c), elementos);
    }

    // ================================================================ sentencias

    private Bloque bloque(PigLatinParser.BloqueContext c) {
        return new Bloque(ctx.ubicacion(c), sentencias(c.sentencia()));
    }

    private List<Instruccion> sentencias(List<PigLatinParser.SentenciaContext> lista) {
        List<Instruccion> resultado = new ArrayList<>();
        for (PigLatinParser.SentenciaContext s : lista) resultado.add(sentencia(s));
        return resultado;
    }

    private Instruccion sentencia(PigLatinParser.SentenciaContext c) {
        return switch (c) {
            case PigLatinParser.SenDeclaracionContext d -> declaracion(d.declaracion().declaracionSimple());
            case PigLatinParser.SenAsignacionContext a -> new InstruccionExpresion(ctx.ubicacion(a), asignacion(a.asignacion()));
            case PigLatinParser.SenIncrementoContext i -> new InstruccionExpresion(ctx.ubicacion(i),
                    new Incremento(ctx.ubicacion(i), acceso(i.acceso()), i.op.getType() == PigLatinParser.INCREMENTO, false));
            case PigLatinParser.SenImprimirContext p -> {
                List<Expresion> valores = new ArrayList<>();
                for (PigLatinParser.ExprContext e : p.expr()) valores.add(expr(e));
                // >> no agrega salto de línea: el programa escribe \n donde lo necesita
                yield new Imprimir(ctx.ubicacion(p), valores, false);
            }
            case PigLatinParser.SenLeerContext l ->
                    new InstruccionLeer(ctx.ubicacion(l), l.acceso() == null ? null : acceso(l.acceso()));
            case PigLatinParser.SenLlamadaContext l -> new InstruccionExpresion(ctx.ubicacion(l), acceso(l.acceso()));
            case PigLatinParser.SenSiContext s -> si(s);
            case PigLatinParser.SenDumContext d -> new Mientras(ctx.ubicacion(d), expr(d.expr()), bloque(d.bloque()));
            case PigLatinParser.SenFacereContext f -> new HacerMientras(ctx.ubicacion(f), bloque(f.bloque()), expr(f.expr()));
            case PigLatinParser.SenPerContext p -> per(p);
            case PigLatinParser.SenPergeContext p -> new Continuar(ctx.ubicacion(p));
            case PigLatinParser.SenInterrumpeContext i -> new Romper(ctx.ubicacion(i));
            default -> throw new IllegalStateException("Sentencia desconocida: " + c.getText());
        };
    }

    private Si si(PigLatinParser.SenSiContext s) {
        // si / aliter (cond) / aliter  ->  condicionales anidados
        Instruccion sino = s.aliter() == null ? null : bloque(s.aliter().bloque());
        List<PigLatinParser.AliterSiContext> ramas = s.aliterSi();
        for (int i = ramas.size() - 1; i >= 0; i--) {
            PigLatinParser.AliterSiContext rama = ramas.get(i);
            sino = new Si(ctx.ubicacion(rama), expr(rama.expr()), bloque(rama.bloque()), sino);
        }
        return new Si(ctx.ubicacion(s), expr(s.expr()), bloque(s.bloque()), sino);
    }

    private Para per(PigLatinParser.SenPerContext p) {
        List<Instruccion> inicio = new ArrayList<>();
        if (p.perInicio() != null) {
            PigLatinParser.PerInicioContext i = p.perInicio();
            inicio.add(i.declaracionSimple() != null
                    ? declaracion(i.declaracionSimple())
                    : new InstruccionExpresion(ctx.ubicacion(i), asignacion(i.asignacion())));
        }
        List<Expresion> actualizacion = new ArrayList<>();
        if (p.perActualizacion() != null) {
            PigLatinParser.PerActualizacionContext a = p.perActualizacion();
            actualizacion.add(a.asignacion() != null
                    ? asignacion(a.asignacion())
                    : new Incremento(ctx.ubicacion(a), acceso(a.acceso()), a.op.getType() == PigLatinParser.INCREMENTO, false));
        }
        Expresion condicion = p.expr() == null ? null : expr(p.expr());
        return new Para(ctx.ubicacion(p), inicio, condicion, actualizacion, bloque(p.bloque()));
    }

    private Asignacion asignacion(PigLatinParser.AsignacionContext c) {
        return new Asignacion(ctx.ubicacion(c), acceso(c.acceso()), null, valor(c.valor()));
    }

    // ================================================================ expresiones

    private Expresion expr(PigLatinParser.ExprContext c) {
        return (Expresion) visit(c);
    }

    private List<Expresion> argumentos(PigLatinParser.ArgumentosContext c) {
        List<Expresion> resultado = new ArrayList<>();
        if (c != null) {
            for (PigLatinParser.ExprContext e : c.expr()) resultado.add(expr(e));
        }
        return resultado;
    }

    /** funcion(...), variable, a[0].b.metodo(...) ... */
    private Expresion acceso(PigLatinParser.AccesoContext c) {
        Expresion actual = switch (c.inicioAcceso()) {
            case PigLatinParser.AccLlamadaContext l ->
                    new LlamadaFuncion(ctx.ubicacion(l), l.ID().getText(), argumentos(l.argumentos()));
            case PigLatinParser.AccIdContext i -> new Identificador(ctx.ubicacion(i), i.ID().getText());
            default -> throw new IllegalStateException();
        };
        for (PigLatinParser.SufijoContext s : c.sufijo()) {
            actual = switch (s) {
                case PigLatinParser.SufMetodoContext m ->
                        new LlamadaMetodo(ctx.ubicacion(m.ID().getSymbol()), actual, m.ID().getText(), argumentos(m.argumentos()));
                case PigLatinParser.SufAtributoContext a ->
                        new AccesoCampo(ctx.ubicacion(a.ID().getSymbol()), actual, a.ID().getText());
                case PigLatinParser.SufIndiceContext i -> new AccesoIndice(ctx.ubicacion(i), actual, expr(i.expr()));
                default -> throw new IllegalStateException();
            };
        }
        return actual;
    }

    private NuevoObjeto objetoNuevo(PigLatinParser.ObjetoNuevoContext c) {
        return new NuevoObjeto(ctx.ubicacion(c), c.ID().getText(), argumentos(c.argumentos()));
    }

    private Literal literal(PigLatinParser.LiteralContext c) {
        var t = c.getStart();
        return switch (t.getType()) {
            case PigLatinParser.ENTERO_LIT -> ctx.entero(t);
            case PigLatinParser.DECIMAL_LIT -> ctx.decimal(t);
            case PigLatinParser.CADENA_LIT -> ctx.cadena(t);
            case PigLatinParser.CARACTER_LIT -> ctx.caracter(t);
            case PigLatinParser.VERUM -> ctx.booleano(t, true);
            default -> ctx.booleano(t, false);
        };
    }

    @Override
    public Nodo visitExprParentesis(PigLatinParser.ExprParentesisContext c) {
        return expr(c.expr());
    }

    @Override
    public Nodo visitExprLiteral(PigLatinParser.ExprLiteralContext c) {
        return literal(c.literal());
    }

    @Override
    public Nodo visitExprNuevo(PigLatinParser.ExprNuevoContext c) {
        return objetoNuevo(c.objetoNuevo());
    }

    @Override
    public Nodo visitExprAcceso(PigLatinParser.ExprAccesoContext c) {
        return acceso(c.acceso());
    }

    @Override
    public Nodo visitExprUnaria(PigLatinParser.ExprUnariaContext c) {
        return new Unaria(ctx.ubicacion(c), OperadorUnario.desdeSimbolo(c.op.getText()), expr(c.expr()));
    }

    @Override
    public Nodo visitExprMultiplicativa(PigLatinParser.ExprMultiplicativaContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprAditiva(PigLatinParser.ExprAditivaContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprRelacional(PigLatinParser.ExprRelacionalContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprIgualdad(PigLatinParser.ExprIgualdadContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprAnd(PigLatinParser.ExprAndContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprOr(PigLatinParser.ExprOrContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    private Binaria binaria(PigLatinParser.ExprContext c, String operador,
                            PigLatinParser.ExprContext izq, PigLatinParser.ExprContext der) {
        return new Binaria(ctx.ubicacion(c), OperadorBinario.desdeSimbolo(operador), expr(izq), expr(der));
    }

    // ================================================================ tipos

    private Tipo tipo(PigLatinParser.TipoContext c) {
        return switch (c.getStart().getType()) {
            case PigLatinParser.NUMERUS -> Tipo.ENTERO;
            case PigLatinParser.TEXTUM -> Tipo.CADENA;
            case PigLatinParser.DECIMALIS -> Tipo.DECIMAL;
            case PigLatinParser.LITTERA -> Tipo.CARACTER;
            case PigLatinParser.BOOL -> Tipo.BOOLEANO;
            // En Pig Latin un nombre puede ser una estructura (.y) o una clase (.z): se resuelve en el semántico
            default -> Tipo.nombrado(c.ID().getText());
        };
    }
}
