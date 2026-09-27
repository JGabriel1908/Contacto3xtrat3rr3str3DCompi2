package com.mycompany.contacto3xtrat3rr3str3d.compiler.constructores;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ErrorCompilacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ErrorCompilacion.TipoError;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.Lenguaje;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Tipo;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.Ubicacion;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.expresiones.Literal;
import java.util.List;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class ContextoConstruccion {

    private final String archivo;
    private final Lenguaje lenguaje;
    private final List<ErrorCompilacion> errores;

    public ContextoConstruccion(String archivo, Lenguaje lenguaje, List<ErrorCompilacion> errores) {
        this.archivo = archivo;
        this.lenguaje = lenguaje;
        this.errores = errores;
    }

    public Ubicacion ubicacion(ParserRuleContext ctx) {
        return ubicacion(ctx.getStart());
    }

    public Ubicacion ubicacion(Token token) {
        return new Ubicacion(archivo, lenguaje, token.getLine(), token.getCharPositionInLine());
    }

    public void error(Token token, String mensaje) {
        errores.add(new ErrorCompilacion(TipoError.SEMANTICO, mensaje, archivo,
                token.getLine(), token.getCharPositionInLine(), Math.max(1, token.getText().length())));
    }

    public Literal entero(Token token) {
        int valor = 0;
        try {
            valor = Integer.parseInt(token.getText());
        } catch (NumberFormatException e) {
            error(token, "El entero " + token.getText() + " está fuera de rango");
        }
        return new Literal(ubicacion(token), Tipo.ENTERO, valor);
    }

    public Literal decimal(Token token) {
        return new Literal(ubicacion(token), Tipo.DECIMAL, Double.parseDouble(token.getText()));
    }

    public Literal cadena(Token token) {
        String texto = token.getText();
        return new Literal(ubicacion(token), Tipo.CADENA, procesarEscapes(texto.substring(1, texto.length() - 1)));
    }

    public Literal caracter(Token token) {
        String texto = token.getText();
        String contenido = procesarEscapes(texto.substring(1, texto.length() - 1));
        return new Literal(ubicacion(token), Tipo.CARACTER, contenido.charAt(0));
    }

    public Literal booleano(Token token, boolean valor) {
        return new Literal(ubicacion(token), Tipo.BOOLEANO, valor);
    }

    public Literal nulo(Token token) {
        return new Literal(ubicacion(token), Tipo.NULO, null);
    }

    static String procesarEscapes(String texto) {
        if (texto.indexOf('\\') < 0) return texto;
        StringBuilder sb = new StringBuilder(texto.length());
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c != '\\' || i + 1 == texto.length()) {
                sb.append(c);
                continue;
            }
            char siguiente = texto.charAt(++i);
            sb.append(switch (siguiente) {
                case 'n' -> '\n';
                case 'r' -> '\r';
                case 't' -> '\t';
                case '0' -> '\0';
                default -> siguiente; // \\  \"  \'
            });
        }
        return sb.toString();
    }
}
