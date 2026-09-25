package com.mycompany.contacto3xtrat3rr3str3d.gui;

import com.mycompany.contacto3xtrat3rr3str3d.gui.resaltado.Tema;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Rectangle2D;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;

/**
 * Margen izquierdo del editor con los números de línea.
 * Resalta la línea del cursor y marca en rojo las líneas con errores.
 */
public class NumerosLinea extends JComponent {

    private static final int RELLENO = 12;

    private final JTextPane texto;
    private Set<Integer> lineasError = Set.of();

    public NumerosLinea(JTextPane texto) {
        this.texto = texto;
        setFont(texto.getFont());
        texto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        texto.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                actualizar();
            }
        });
        texto.addCaretListener(e -> repaint());
    }

    public void setLineasError(Set<Integer> lineas) {
        this.lineasError = lineas;
        repaint();
    }

    private void actualizar() {
        SwingUtilities.invokeLater(() -> {
            revalidate();
            repaint();
        });
    }

    @Override
    public Dimension getPreferredSize() {
        int lineas = texto.getDocument().getDefaultRootElement().getElementCount();
        int digitos = Math.max(3, String.valueOf(lineas).length());
        FontMetrics fm = getFontMetrics(getFont());
        return new Dimension(fm.charWidth('0') * digitos + RELLENO * 2, texto.getPreferredSize().height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Rectangle clip = g.getClipBounds();
        g.setColor(Tema.FONDO);
        g.fillRect(clip.x, clip.y, clip.width, clip.height);

        FontMetrics fm = g.getFontMetrics(getFont());
        g.setFont(getFont());
        Element raiz = texto.getDocument().getDefaultRootElement();
        int inicio = texto.viewToModel2D(new Point(0, clip.y));
        int fin = texto.viewToModel2D(new Point(0, clip.y + clip.height));
        int lineaCursor = raiz.getElementIndex(texto.getCaretPosition());

        for (int i = raiz.getElementIndex(inicio); i <= raiz.getElementIndex(fin); i++) {
            try {
                Rectangle2D r = texto.modelToView2D(raiz.getElement(i).getStartOffset());
                if (r == null) continue;
                int y = (int) (r.getY() + r.getHeight()) - fm.getDescent();
                String numero = String.valueOf(i + 1);
                if (lineasError.contains(i + 1)) {
                    g.setColor(Tema.ERROR);
                    int alto = fm.getAscent() / 2;
                    g.fillOval(3, y - alto - 1, 6, 6);
                } else if (i == lineaCursor) {
                    g.setColor(Tema.NUMERO_LINEA_ACTUAL);
                } else {
                    g.setColor(Tema.NUMERO_LINEA);
                }
                g.drawString(numero, getWidth() - RELLENO - fm.stringWidth(numero), y);
            } catch (BadLocationException e) {
                break;
            }
        }
    }
}
