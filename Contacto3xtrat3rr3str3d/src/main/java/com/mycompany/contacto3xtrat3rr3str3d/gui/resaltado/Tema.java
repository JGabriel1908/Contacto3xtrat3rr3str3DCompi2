package com.mycompany.contacto3xtrat3rr3str3d.gui.resaltado;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javax.swing.UIManager;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * Colores y fuentes de la IDE (tema oscuro).
 */
public final class Tema {

    public static final Color FONDO = new Color(0x1E1F22);
    public static final Color FONDO_PANEL = new Color(0x2B2D30);
    public static final Color LINEA_ACTUAL = new Color(0x26282E);
    public static final Color SELECCION = new Color(0x214283);
    public static final Color TEXTO = new Color(0xBCBEC4);
    public static final Color NUMERO_LINEA = new Color(0x5F636B);
    public static final Color NUMERO_LINEA_ACTUAL = new Color(0xA1A3AB);
    public static final Color ERROR = new Color(0xF75464);
    public static final Color ACENTO = new Color(0x3574F0);

    private static final Map<Categoria, Color> COLORES = new EnumMap<>(Categoria.class);

    static {
        COLORES.put(Categoria.PALABRA_RESERVADA, new Color(0xCF8E6D));
        COLORES.put(Categoria.TIPO, new Color(0xF2C55C));
        COLORES.put(Categoria.SECCION, new Color(0xFF6BAA));
        COLORES.put(Categoria.FUNCION_NATIVA, new Color(0x3DD6C9));
        COLORES.put(Categoria.LLAMADA, new Color(0x56A8F5));
        COLORES.put(Categoria.CONSTANTE, new Color(0xC77DBB));
        COLORES.put(Categoria.CADENA, new Color(0x6AAB73));
        COLORES.put(Categoria.NUMERO, new Color(0x2AACB8));
        COLORES.put(Categoria.COMENTARIO, new Color(0x7A7E85));
        COLORES.put(Categoria.OPERADOR, new Color(0xD5D8DE));
        COLORES.put(Categoria.IDENTIFICADOR, TEXTO);
        COLORES.put(Categoria.ERROR, ERROR);
        COLORES.put(Categoria.NORMAL, TEXTO);
    }

    private static final List<String> FUENTES_PREFERIDAS = List.of(
            "JetBrains Mono", "Cascadia Code", "Fira Code", "Consolas",
            "DejaVu Sans Mono", "Liberation Mono", "Noto Sans Mono");

    private static String familiaMonoespaciada;

    private Tema() {
    }

    public static Color color(Categoria categoria) {
        return COLORES.get(categoria);
    }

    public static AttributeSet estilo(Categoria categoria, Font fuente) {
        SimpleAttributeSet a = new SimpleAttributeSet();
        StyleConstants.setFontFamily(a, fuente.getFamily());
        StyleConstants.setFontSize(a, fuente.getSize());
        StyleConstants.setForeground(a, color(categoria));
        switch (categoria) {
            case PALABRA_RESERVADA, SECCION, FUNCION_NATIVA, CONSTANTE -> StyleConstants.setBold(a, true);
            case COMENTARIO -> StyleConstants.setItalic(a, true);
            case ERROR -> {
                StyleConstants.setUnderline(a, true);
                StyleConstants.setBackground(a, new Color(0x5C1E24));
            }
            default -> {
            }
        }
        return a;
    }

    public static synchronized Font fuenteEditor(int tamano) {
        if (familiaMonoespaciada == null) {
            List<String> disponibles = Arrays.asList(
                    GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
            familiaMonoespaciada = FUENTES_PREFERIDAS.stream()
                    .filter(disponibles::contains)
                    .findFirst()
                    .orElse(Font.MONOSPACED);
        }
        return new Font(familiaMonoespaciada, Font.PLAIN, tamano);
    }

    /** Nimbus con una paleta oscura. Si no está disponible se usa el look and feel por defecto. */
    public static void instalarLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.put("control", FONDO_PANEL);
                    UIManager.put("info", FONDO_PANEL);
                    UIManager.put("nimbusBase", new Color(0x1C2433));
                    UIManager.put("nimbusAlertYellow", new Color(0xF8BB00));
                    UIManager.put("nimbusDisabledText", new Color(0x6E6E6E));
                    UIManager.put("nimbusFocus", ACENTO);
                    UIManager.put("nimbusGreen", new Color(0x6AAB73));
                    UIManager.put("nimbusInfoBlue", ACENTO);
                    UIManager.put("nimbusLightBackground", FONDO);
                    UIManager.put("nimbusOrange", new Color(0xBF6204));
                    UIManager.put("nimbusRed", new Color(0xA92E22));
                    UIManager.put("nimbusSelectedText", Color.WHITE);
                    UIManager.put("nimbusSelectionBackground", SELECCION);
                    UIManager.put("text", TEXTO);
                    UIManager.setLookAndFeel(info.getClassName());
                    return;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException e) {
            // Se conserva el look and feel por defecto
        }
    }
}
