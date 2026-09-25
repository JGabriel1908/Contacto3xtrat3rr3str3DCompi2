package com.mycompany.contacto3xtrat3rr3str3d.compiler.constructores;

import com.mycompany.C3.grammar.YParser;
import com.mycompany.C3.grammar.YParserBaseVisitor;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Nodo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.UnidadY;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Campo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefEstructura;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.DefFuncion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.ModoPaso;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Parametro;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.AccesoCampo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.AccesoIndice;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Asignacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Binaria;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Expresion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Identificador;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Incremento;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.InicializadorLista;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Leer;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.LlamadaFuncion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.OperadorBinario;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.OperadorUnario;
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

/**
 * Convierte el árbol de ANTLR de un archivo .y en el AST común.
 */
public class ConstructorAstY extends YParserBaseVisitor<Nodo> {

    private final ContextoConstruccion ctx;

    public ConstructorAstY(ContextoConstruccion ctx) {
        this.ctx = ctx;
    }

    public UnidadY construir(YParser.ProgramaContext programa) {
        List<DefEstructura> estructuras = new ArrayList<>();
        if (programa.seccionEstructuras() != null) {
            for (YParser.DefEstructuraContext d : programa.seccionEstructuras().defEstructura()) {
                estructuras.add(estructura(d));
            }
        }
        List<DefFuncion> funciones = new ArrayList<>();
        for (YParser.DefFuncionContext f : programa.seccionFunciones().defFuncion()) {
            funciones.add(funcion(f));
        }
        return new UnidadY(ctx.ubicacion(programa), estructuras, funciones);
    }

    // ================================================================ declaraciones

    private DefEstructura estructura(YParser.DefEstructuraContext c) {
        List<Campo> campos = new ArrayList<>();
        for (YParser.CampoContext campo : c.campo()) {
            List<Expresion> dimensiones = dimensiones(campo.dimension());
            campos.add(new Campo(ctx.ubicacion(campo), tipo(campo.tipo()).arreglo(dimensiones.size()),
                    campo.ID().getText(), dimensiones));
        }
        return new DefEstructura(ctx.ubicacion(c), c.ID().getText(), campos);
    }

    private DefFuncion funcion(YParser.DefFuncionContext c) {
        List<Parametro> parametros = new ArrayList<>();
        if (c.parametros() != null) {
            for (YParser.ParametroContext p : c.parametros().parametro()) parametros.add(parametro(p));
        }
        Tipo retorno = c.tipo() == null ? Tipo.VACIO : tipo(c.tipo());
        return new DefFuncion(ctx.ubicacion(c), c.ID().getText(), parametros, retorno, bloque(c.bloque()));
    }

    private Parametro parametro(YParser.ParametroContext p) {
        if (p instanceof YParser.ParamArregloContext a) {
            Tipo tipo = tipo(a.tipo()).arreglo(a.COR_IZQ().size());
            return new Parametro(ctx.ubicacion(a), tipo, a.ID().getText(), ModoPaso.REFERENCIA);
        }
        if (p instanceof YParser.ParamEstructuraContext e) {
            return new Parametro(ctx.ubicacion(e), Tipo.estructura(e.ID(0).getText()), e.ID(1).getText(),
                    ModoPaso.REFERENCIA);
        }
        YParser.ParamValorContext v = (YParser.ParamValorContext) p;
        return new Parametro(ctx.ubicacion(v), tipoPrimitivo(v.tipoPrimitivo()), v.ID().getText(), ModoPaso.VALOR);
    }

    // ================================================================ instrucciones

    private Bloque bloque(YParser.BloqueContext c) {
        return new Bloque(ctx.ubicacion(c), instrucciones(c.instruccion()));
    }

    private List<Instruccion> instrucciones(List<YParser.InstruccionContext> lista) {
        List<Instruccion> resultado = new ArrayList<>();
        for (YParser.InstruccionContext i : lista) resultado.add((Instruccion) visit(i));
        return resultado;
    }

    @Override
    public Nodo visitInsDefEstructura(YParser.InsDefEstructuraContext c) {
        return estructura(c.defEstructura());
    }

    @Override
    public Nodo visitInsDeclaracion(YParser.InsDeclaracionContext c) {
        return declaracion(c.declaracion());
    }

    @Override
    public Nodo visitInsAsignacion(YParser.InsAsignacionContext c) {
        return new InstruccionExpresion(ctx.ubicacion(c), asignacion(c.asignacion()));
    }

    @Override
    public Nodo visitInsIncremento(YParser.InsIncrementoContext c) {
        return new InstruccionExpresion(ctx.ubicacion(c), incremento(c.incremento()));
    }

    @Override
    public Nodo visitInsLlamada(YParser.InsLlamadaContext c) {
        return new InstruccionExpresion(ctx.ubicacion(c), llamada(c.llamada()));
    }

    @Override
    public Nodo visitInsImprimir(YParser.InsImprimirContext c) {
        List<Expresion> valores = c.expr() == null ? List.of() : List.of(expr(c.expr()));
        return new Imprimir(ctx.ubicacion(c), valores, true);
    }

    @Override
    public Nodo visitInsLeer(YParser.InsLeerContext c) {
        return new InstruccionLeer(ctx.ubicacion(c), null);
    }

    @Override
    public Nodo visitInsRetornar(YParser.InsRetornarContext c) {
        return new Retornar(ctx.ubicacion(c), c.expr() == null ? null : expr(c.expr()));
    }

    @Override
    public Nodo visitInsRomper(YParser.InsRomperContext c) {
        return new Romper(ctx.ubicacion(c));
    }

    @Override
    public Nodo visitInsContinuar(YParser.InsContinuarContext c) {
        return new Continuar(ctx.ubicacion(c));
    }

    @Override
    public Nodo visitInsCondicional(YParser.InsCondicionalContext c) {
        YParser.CondicionalContext si = c.condicional();
        // La cadena si / sino / contrario se arma desde el final como condicionales anidados
        Instruccion sino = si.contrario() == null ? null : bloque(si.contrario().bloque());
        List<YParser.SinoSiContext> ramas = si.sinoSi();
        for (int i = ramas.size() - 1; i >= 0; i--) {
            YParser.SinoSiContext rama = ramas.get(i);
            sino = new Si(ctx.ubicacion(rama), expr(rama.expr()), bloque(rama.bloque()), sino);
        }
        return new Si(ctx.ubicacion(si), expr(si.expr()), bloque(si.bloque()), sino);
    }

    @Override
    public Nodo visitInsSeleccion(YParser.InsSeleccionContext c) {
        YParser.SeleccionContext s = c.seleccion();
        List<Caso> casos = new ArrayList<>();
        for (YParser.CasoContext caso : s.caso()) {
            casos.add(new Caso(ctx.ubicacion(caso), expr(caso.expr()), cuerpoCaso(caso.cuerpoCaso())));
        }
        if (s.casoDefecto() != null) {
            casos.add(new Caso(ctx.ubicacion(s.casoDefecto()), null, cuerpoCaso(s.casoDefecto().cuerpoCaso())));
        }
        return new Seleccion(ctx.ubicacion(s), expr(s.expr()), casos);
    }

    private List<Instruccion> cuerpoCaso(YParser.CuerpoCasoContext c) {
        return c.bloque() != null ? instrucciones(c.bloque().instruccion()) : instrucciones(c.instruccion());
    }

    @Override
    public Nodo visitInsPara(YParser.InsParaContext c) {
        YParser.CicloParaContext p = c.cicloPara();
        List<Instruccion> inicio = new ArrayList<>();
        if (p.inicioPara() != null) {
            YParser.InicioParaContext i = p.inicioPara();
            inicio.add(i.declaracion() != null
                    ? declaracion(i.declaracion())
                    : new InstruccionExpresion(ctx.ubicacion(i), asignacion(i.asignacion())));
        }
        List<Expresion> actualizacion = new ArrayList<>();
        if (p.actualizacionPara() != null) {
            YParser.ActualizacionParaContext a = p.actualizacionPara();
            actualizacion.add(a.incremento() != null ? incremento(a.incremento()) : asignacion(a.asignacion()));
        }
        Expresion condicion = p.expr() == null ? null : expr(p.expr());
        return new Para(ctx.ubicacion(p), inicio, condicion, actualizacion, bloque(p.bloque()));
    }

    @Override
    public Nodo visitInsMientras(YParser.InsMientrasContext c) {
        YParser.CicloMientrasContext m = c.cicloMientras();
        return new Mientras(ctx.ubicacion(m), expr(m.expr()), bloque(m.bloque()));
    }

    @Override
    public Nodo visitInsHacer(YParser.InsHacerContext c) {
        YParser.CicloHacerContext h = c.cicloHacer();
        return new HacerMientras(ctx.ubicacion(h), bloque(h.bloque()), expr(h.expr()));
    }

    private DeclaracionVariable declaracion(YParser.DeclaracionContext c) {
        if (c instanceof YParser.DeclArregloContext a) {
            List<Expresion> dimensiones = dimensiones(a.dimension());
            Expresion inicial = a.inicializador() == null ? null : inicializador(a.inicializador());
            return new DeclaracionVariable(ctx.ubicacion(a), tipo(a.tipo()).arreglo(dimensiones.size()),
                    a.ID().getText(), dimensiones, inicial);
        }
        YParser.DeclVariableContext v = (YParser.DeclVariableContext) c;
        Expresion inicial = v.inicializador() == null ? null : inicializador(v.inicializador());
        return new DeclaracionVariable(ctx.ubicacion(v), tipo(v.tipo()), v.ID().getText(), List.of(), inicial);
    }

    private Expresion inicializador(YParser.InicializadorContext c) {
        if (c instanceof YParser.IniListaContext lista) {
            List<Expresion> elementos = new ArrayList<>();
            for (YParser.InicializadorContext e : lista.inicializador()) elementos.add(inicializador(e));
            return new InicializadorLista(ctx.ubicacion(lista), elementos);
        }
        return expr(((YParser.IniExprContext) c).expr());
    }

    private Asignacion asignacion(YParser.AsignacionContext c) {
        return new Asignacion(ctx.ubicacion(c), acceso(c.acceso()), null, inicializador(c.inicializador()));
    }

    private Incremento incremento(YParser.IncrementoContext c) {
        return new Incremento(ctx.ubicacion(c), acceso(c.acceso()), c.op.getType() == YParser.INCREMENTO, false);
    }

    private List<Expresion> dimensiones(List<YParser.DimensionContext> lista) {
        List<Expresion> resultado = new ArrayList<>();
        for (YParser.DimensionContext d : lista) resultado.add(expr(d.expr()));
        return resultado;
    }

    // ================================================================ expresiones

    private Expresion expr(YParser.ExprContext c) {
        return (Expresion) visit(c);
    }

    private Expresion acceso(YParser.AccesoContext c) {
        Expresion actual = new Identificador(ctx.ubicacion(c), c.ID().getText());
        for (YParser.SufijoContext s : c.sufijo()) {
            if (s instanceof YParser.SufIndiceContext i) {
                actual = new AccesoIndice(ctx.ubicacion(i), actual, expr(i.expr()));
            } else {
                actual = new AccesoCampo(ctx.ubicacion(s), actual, ((YParser.SufCampoContext) s).ID().getText());
            }
        }
        return actual;
    }

    private LlamadaFuncion llamada(YParser.LlamadaContext c) {
        List<Expresion> argumentos = new ArrayList<>();
        if (c.argumentos() != null) {
            for (YParser.ExprContext e : c.argumentos().expr()) argumentos.add(expr(e));
        }
        return new LlamadaFuncion(ctx.ubicacion(c), c.ID().getText(), argumentos);
    }

    @Override
    public Nodo visitExprParentesis(YParser.ExprParentesisContext c) {
        return expr(c.expr());
    }

    @Override
    public Nodo visitExprLlamada(YParser.ExprLlamadaContext c) {
        return llamada(c.llamada());
    }

    @Override
    public Nodo visitExprLeer(YParser.ExprLeerContext c) {
        return new Leer(ctx.ubicacion(c));
    }

    @Override
    public Nodo visitExprAcceso(YParser.ExprAccesoContext c) {
        return acceso(c.acceso());
    }

    @Override
    public Nodo visitExprLiteral(YParser.ExprLiteralContext c) {
        var t = c.literal().getStart();
        return switch (t.getType()) {
            case YParser.ENTERO_LIT -> ctx.entero(t);
            case YParser.DECIMAL_LIT -> ctx.decimal(t);
            case YParser.CADENA_LIT -> ctx.cadena(t);
            case YParser.CARACTER_LIT -> ctx.caracter(t);
            case YParser.VERDADERO -> ctx.booleano(t, true);
            default -> ctx.booleano(t, false);
        };
    }

    @Override
    public Nodo visitExprUnaria(YParser.ExprUnariaContext c) {
        return new Unaria(ctx.ubicacion(c), OperadorUnario.desdeSimbolo(c.op.getText()), expr(c.expr()));
    }

    @Override
    public Nodo visitExprMultiplicativa(YParser.ExprMultiplicativaContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprAditiva(YParser.ExprAditivaContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprRelacional(YParser.ExprRelacionalContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprIgualdad(YParser.ExprIgualdadContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprAnd(YParser.ExprAndContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    @Override
    public Nodo visitExprOr(YParser.ExprOrContext c) {
        return binaria(c, c.op.getText(), c.izq, c.der);
    }

    private Binaria binaria(YParser.ExprContext c, String operador, YParser.ExprContext izq, YParser.ExprContext der) {
        return new Binaria(ctx.ubicacion(c), OperadorBinario.desdeSimbolo(operador), expr(izq), expr(der));
    }

    // ================================================================ tipos

    private Tipo tipo(YParser.TipoContext c) {
        return c.tipoPrimitivo() != null ? tipoPrimitivo(c.tipoPrimitivo()) : Tipo.estructura(c.ID().getText());
    }

    private Tipo tipoPrimitivo(YParser.TipoPrimitivoContext c) {
        return switch (c.getStart().getType()) {
            case YParser.ENTERO -> Tipo.ENTERO;
            case YParser.FLOTANTE -> Tipo.DECIMAL;
            case YParser.CADENA -> Tipo.CADENA;
            case YParser.CARACTER -> Tipo.CARACTER;
            default -> Tipo.BOOLEANO;
        };
    }
}
