package com.mycompany.contacto3xtrat3rr3str3d.compiler.constructores;

import com.mycompany.C3.grammar.ZetarianoParser;
import com.mycompany.C3.grammar.ZetarianoParserBaseVisitor;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.UnidadZetariano;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Atributo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefClase;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefConstructor;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefMetodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Modificador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.ModoPaso;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Parametro;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.AccesoCampo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.AccesoIndice;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Asignacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Binaria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Este;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Identificador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Incremento;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.InicializadorLista;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Leer;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.LlamadaFuncion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.LlamadaMetodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.NuevoArreglo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.NuevoObjeto;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.OperadorBinario;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.OperadorUnario;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Ternario;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Unaria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Bloque;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Caso;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Continuar;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.DeclaracionVariable;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.HacerMientras;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Imprimir;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Instruccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.InstruccionExpresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.InstruccionLeer;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Mientras;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Para;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Retornar;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Romper;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Seleccion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Si;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Convierte el árbol de ANTLR de un archivo .z en el AST común.
 */
public class ConstructorAstZetariano extends ZetarianoParserBaseVisitor<Nodo> {

    private final ContextoConstruccion ctx;

    public ConstructorAstZetariano(ContextoConstruccion ctx) {
        this.ctx = ctx;
    }

    public UnidadZetariano construir(ZetarianoParser.ProgramaContext programa) {
        return new UnidadZetariano(ctx.ubicacion(programa), clase(programa.clase()));
    }

    // ================================================================ clase

    private DefClase clase(ZetarianoParser.ClaseContext c) {
        List<Atributo> atributos = new ArrayList<>();
        List<DefConstructor> constructores = new ArrayList<>();
        List<DefMetodo> metodos = new ArrayList<>();
        for (ZetarianoParser.MiembroContext m : c.miembro()) {
            if (m.atributo() != null) {
                ZetarianoParser.AtributoContext a = m.atributo();
                Modificador mod = modificador(a.modificador());
                Tipo tipo = tipo(a.tipo());
                for (ZetarianoParser.DeclaradorContext d : a.declarador()) {
                    Expresion inicial = d.inicializador() == null ? null : inicializador(d.inicializador());
                    atributos.add(new Atributo(ctx.ubicacion(d), mod, tipo, d.ID().getText(), inicial));
                }
            } else if (m.constructor() != null) {
                ZetarianoParser.ConstructorContext k = m.constructor();
                constructores.add(new DefConstructor(ctx.ubicacion(k), modificador(k.modificador()),
                        k.ID().getText(), parametros(k.parametros()), bloque(k.bloque())));
            } else {
                ZetarianoParser.MetodoContext mt = m.metodo();
                Tipo retorno = mt.tipoRetorno().VOID() != null ? Tipo.VACIO : tipo(mt.tipoRetorno().tipo());
                metodos.add(new DefMetodo(ctx.ubicacion(mt), modificador(mt.modificador()), retorno,
                        mt.ID().getText(), parametros(mt.parametros()), bloque(mt.bloque())));
            }
        }
        return new DefClase(ctx.ubicacion(c), modificador(c.modificador()), c.ID().getText(),
                atributos, constructores, metodos);
    }

    private List<Parametro> parametros(ZetarianoParser.ParametrosContext c) {
        List<Parametro> resultado = new ArrayList<>();
        if (c == null) return resultado;
        for (ZetarianoParser.ParametroContext p : c.parametro()) {
            Tipo tipo = tipo(p.tipo());
            // Como en Java: primitivos por valor, arreglos y objetos por referencia
            ModoPaso modo = tipo.esReferencia() ? ModoPaso.REFERENCIA : ModoPaso.VALOR;
            resultado.add(new Parametro(ctx.ubicacion(p), tipo, p.ID().getText(), modo));
        }
        return resultado;
    }

    private static Modificador modificador(ZetarianoParser.ModificadorContext c) {
        if (c == null) return Modificador.NINGUNO;
        return switch (c.getStart().getType()) {
            case ZetarianoParser.PUBLIC -> Modificador.PUBLICO;
            case ZetarianoParser.PRIVATE -> Modificador.PRIVADO;
            default -> Modificador.PROTEGIDO;
        };
    }

    // ================================================================ sentencias

    private Bloque bloque(ZetarianoParser.BloqueContext c) {
        List<Instruccion> instrucciones = new ArrayList<>();
        for (ZetarianoParser.SentenciaContext s : c.sentencia()) instrucciones.addAll(sentencia(s));
        return new Bloque(ctx.ubicacion(c), instrucciones);
    }

    /** Cuerpo de if/while/for: si no es un bloque se envuelve en uno. */
    private Instruccion cuerpo(ZetarianoParser.SentenciaContext c) {
        List<Instruccion> lista = sentencia(c);
        if (lista.size() == 1) return lista.get(0);
        return new Bloque(ctx.ubicacion(c), lista);
    }

    /** Una sentencia puede producir varias instrucciones (int a = 1, b = 2;) o ninguna (;). */
    private List<Instruccion> sentencia(ZetarianoParser.SentenciaContext c) {
        return switch (c) {
            case ZetarianoParser.SenBloqueContext b -> List.of(bloque(b.bloque()));
            case ZetarianoParser.SenDeclaracionContext d -> new ArrayList<>(declaracion(d.declaracionLocal()));
            case ZetarianoParser.SenIfContext s -> {
                Instruccion sino = s.sentencia().size() > 1 ? cuerpo(s.sentencia(1)) : null;
                yield List.of(new Si(ctx.ubicacion(s), expr(s.expr()), cuerpo(s.sentencia(0)), sino));
            }
            case ZetarianoParser.SenSwitchContext s -> List.of(seleccion(s));
            case ZetarianoParser.SenWhileContext w ->
                    List.of(new Mientras(ctx.ubicacion(w), expr(w.expr()), cuerpo(w.sentencia())));
            case ZetarianoParser.SenDoWhileContext d ->
                    List.of(new HacerMientras(ctx.ubicacion(d), cuerpo(d.sentencia()), expr(d.expr())));
            case ZetarianoParser.SenForContext f -> List.of(para(f));
            case ZetarianoParser.SenBreakContext b -> List.of(new Romper(ctx.ubicacion(b)));
            case ZetarianoParser.SenContinueContext k -> List.of(new Continuar(ctx.ubicacion(k)));
            case ZetarianoParser.SenReturnContext r ->
                    List.of(new Retornar(ctx.ubicacion(r), r.expr() == null ? null : expr(r.expr())));
            case ZetarianoParser.SenPrintlnContext p -> List.of(new Imprimir(ctx.ubicacion(p),
                    p.expr() == null ? List.of() : List.of(expr(p.expr())), true));
            case ZetarianoParser.SenPrintContext p ->
                    List.of(new Imprimir(ctx.ubicacion(p), List.of(expr(p.expr())), false));
            case ZetarianoParser.SenExpresionContext e -> List.of(instruccionExpresion(e, expr(e.expr())));
            default -> List.of(); // sentencia vacía
        };
    }

    private Instruccion instruccionExpresion(ParserRuleContext c, Expresion e) {
        // readln(); descarta lo leído
        if (e instanceof Leer) return new InstruccionLeer(ctx.ubicacion(c), null);
        return new InstruccionExpresion(ctx.ubicacion(c), e);
    }

    private List<DeclaracionVariable> declaracion(ZetarianoParser.DeclaracionLocalContext c) {
        Tipo tipo = tipo(c.tipo());
        List<DeclaracionVariable> resultado = new ArrayList<>();
        for (ZetarianoParser.DeclaradorContext d : c.declarador()) {
            Expresion inicial = d.inicializador() == null ? null : inicializador(d.inicializador());
            resultado.add(new DeclaracionVariable(ctx.ubicacion(d), tipo, d.ID().getText(), List.of(), inicial));
        }
        return resultado;
    }

    private Seleccion seleccion(ZetarianoParser.SenSwitchContext s) {
        List<Caso> casos = new ArrayList<>();
        for (ZetarianoParser.SeccionSwitchContext seccion : s.seccionSwitch()) {
            List<Instruccion> instrucciones = new ArrayList<>();
            for (ZetarianoParser.SentenciaContext st : seccion.sentencia()) instrucciones.addAll(sentencia(st));
            Expresion valor = seccion.etiquetaSwitch() instanceof ZetarianoParser.EtiquetaCaseContext caso
                    ? expr(caso.expr()) : null;
            casos.add(new Caso(ctx.ubicacion(seccion), valor, instrucciones));
        }
        return new Seleccion(ctx.ubicacion(s), expr(s.expr()), casos);
    }

    private Para para(ZetarianoParser.SenForContext f) {
        List<Instruccion> inicio = new ArrayList<>();
        if (f.forInicio() != null) {
            if (f.forInicio().declaracionLocal() != null) {
                inicio.addAll(declaracion(f.forInicio().declaracionLocal()));
            } else {
                for (ZetarianoParser.ExprContext e : f.forInicio().expr()) inicio.add(instruccionExpresion(e, expr(e)));
            }
        }
        List<Expresion> actualizacion = new ArrayList<>();
        if (f.forActualizacion() != null) {
            for (ZetarianoParser.ExprContext e : f.forActualizacion().expr()) actualizacion.add(expr(e));
        }
        Expresion condicion = f.expr() == null ? null : expr(f.expr());
        return new Para(ctx.ubicacion(f), inicio, condicion, actualizacion, cuerpo(f.sentencia()));
    }

    // ================================================================ expresiones

    private Expresion expr(ZetarianoParser.ExprContext c) {
        return (Expresion) visit(c);
    }

    private List<Expresion> argumentos(ZetarianoParser.ArgumentosContext c) {
        List<Expresion> resultado = new ArrayList<>();
        if (c != null) {
            for (ZetarianoParser.ExprContext e : c.expr()) resultado.add(expr(e));
        }
        return resultado;
    }

    private Expresion inicializador(ZetarianoParser.InicializadorContext c) {
        return c.inicializadorArreglo() != null ? inicializadorArreglo(c.inicializadorArreglo()) : expr(c.expr());
    }

    private InicializadorLista inicializadorArreglo(ZetarianoParser.InicializadorArregloContext c) {
        List<Expresion> elementos = new ArrayList<>();
        for (ZetarianoParser.InicializadorContext i : c.inicializador()) elementos.add(inicializador(i));
        return new InicializadorLista(ctx.ubicacion(c), elementos);
    }

    @Override
    public Nodo visitExprPrimario(ZetarianoParser.ExprPrimarioContext c) {
        return visit(c.primario());
    }

    @Override
    public Nodo visitExprLlamadaMetodo(ZetarianoParser.ExprLlamadaMetodoContext c) {
        return new LlamadaMetodo(ctx.ubicacion(c.ID().getSymbol()), expr(c.expr()), c.ID().getText(),
                argumentos(c.argumentos()));
    }

    @Override
    public Nodo visitExprAtributo(ZetarianoParser.ExprAtributoContext c) {
        return new AccesoCampo(ctx.ubicacion(c.ID().getSymbol()), expr(c.expr()), c.ID().getText());
    }

    @Override
    public Nodo visitExprIndice(ZetarianoParser.ExprIndiceContext c) {
        return new AccesoIndice(ctx.ubicacion(c), expr(c.expr(0)), expr(c.expr(1)));
    }

    @Override
    public Nodo visitExprPostfija(ZetarianoParser.ExprPostfijaContext c) {
        return new Incremento(ctx.ubicacion(c), expr(c.expr()), c.op.getType() == ZetarianoParser.INCREMENTO, false);
    }

    @Override
    public Nodo visitExprPrefija(ZetarianoParser.ExprPrefijaContext c) {
        return switch (c.op.getType()) {
            case ZetarianoParser.INCREMENTO -> new Incremento(ctx.ubicacion(c), expr(c.expr()), true, true);
            case ZetarianoParser.DECREMENTO -> new Incremento(ctx.ubicacion(c), expr(c.expr()), false, true);
            default -> new Unaria(ctx.ubicacion(c), OperadorUnario.desdeSimbolo(c.op.getText()), expr(c.expr()));
        };
    }

    @Override
    public Nodo visitExprMultiplicativa(ZetarianoParser.ExprMultiplicativaContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprAditiva(ZetarianoParser.ExprAditivaContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprRelacional(ZetarianoParser.ExprRelacionalContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprIgualdad(ZetarianoParser.ExprIgualdadContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprAnd(ZetarianoParser.ExprAndContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprOr(ZetarianoParser.ExprOrContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprTernaria(ZetarianoParser.ExprTernariaContext c) {
        return new Ternario(ctx.ubicacion(c), expr(c.cond), expr(c.siVerdadero), expr(c.siFalso));
    }

    @Override
    public Nodo visitExprAsignacion(ZetarianoParser.ExprAsignacionContext c) {
        OperadorBinario compuesto = c.op.getType() == ZetarianoParser.IGUAL
                ? null : OperadorBinario.desdeAsignacionCompuesta(c.op.getText());
        return new Asignacion(ctx.ubicacion(c), expr(c.izq), compuesto, expr(c.der));
    }

    private Binaria binaria(ZetarianoParser.ExprContext c, String operador,
                            ZetarianoParser.ExprContext izq, ZetarianoParser.ExprContext der) {
        return new Binaria(ctx.ubicacion(c), OperadorBinario.desdeSimbolo(operador), expr(izq), expr(der));
    }

    // --- primarios

    @Override
    public Nodo visitPrimParentesis(ZetarianoParser.PrimParentesisContext c) {
        return expr(c.expr());
    }

    @Override
    public Nodo visitPrimLiteral(ZetarianoParser.PrimLiteralContext c) {
        var t = c.literal().getStart();
        return switch (t.getType()) {
            case ZetarianoParser.ENTERO_LIT -> ctx.entero(t);
            case ZetarianoParser.DECIMAL_LIT -> ctx.decimal(t);
            case ZetarianoParser.CADENA_LIT -> ctx.cadena(t);
            case ZetarianoParser.CARACTER_LIT -> ctx.caracter(t);
            case ZetarianoParser.TRUE -> ctx.booleano(t, true);
            case ZetarianoParser.FALSE -> ctx.booleano(t, false);
            default -> ctx.nulo(t);
        };
    }

    @Override
    public Nodo visitPrimThis(ZetarianoParser.PrimThisContext c) {
        return new Este(ctx.ubicacion(c));
    }

    @Override
    public Nodo visitPrimLlamada(ZetarianoParser.PrimLlamadaContext c) {
        return new LlamadaFuncion(ctx.ubicacion(c), c.ID().getText(), argumentos(c.argumentos()));
    }

    @Override
    public Nodo visitPrimId(ZetarianoParser.PrimIdContext c) {
        return new Identificador(ctx.ubicacion(c), c.ID().getText());
    }

    @Override
    public Nodo visitPrimReadln(ZetarianoParser.PrimReadlnContext c) {
        return new Leer(ctx.ubicacion(c));
    }

    @Override
    public Nodo visitPrimNuevoObjeto(ZetarianoParser.PrimNuevoObjetoContext c) {
        return new NuevoObjeto(ctx.ubicacion(c), c.ID().getText(), argumentos(c.argumentos()));
    }

    @Override
    public Nodo visitPrimNuevoArreglo(ZetarianoParser.PrimNuevoArregloContext c) {
        List<Expresion> tamanos = new ArrayList<>();
        for (ZetarianoParser.ExprContext e : c.expr()) tamanos.add(expr(e));
        return new NuevoArreglo(ctx.ubicacion(c), tipoBase(c.tipoBase()), tamanos, c.COR_IZQ().size(), null);
    }

    @Override
    public Nodo visitPrimNuevoArregloInit(ZetarianoParser.PrimNuevoArregloInitContext c) {
        return new NuevoArreglo(ctx.ubicacion(c), tipoBase(c.tipoBase()), List.of(), c.COR_IZQ().size(),
                inicializadorArreglo(c.inicializadorArreglo()));
    }

    // ================================================================ tipos

    private Tipo tipo(ZetarianoParser.TipoContext c) {
        return tipoBase(c.tipoBase()).arreglo(c.COR_IZQ().size());
    }

    private Tipo tipoBase(ZetarianoParser.TipoBaseContext c) {
        return switch (c.getStart().getType()) {
            case ZetarianoParser.INT -> Tipo.ENTERO;
            case ZetarianoParser.DOUBLE -> Tipo.DECIMAL;
            case ZetarianoParser.CHAR -> Tipo.CARACTER;
            case ZetarianoParser.BOOLEAN -> Tipo.BOOLEANO;
            case ZetarianoParser.STRING -> Tipo.CADENA;
            default -> Tipo.clase(c.ID().getText());
        };
    }
}
