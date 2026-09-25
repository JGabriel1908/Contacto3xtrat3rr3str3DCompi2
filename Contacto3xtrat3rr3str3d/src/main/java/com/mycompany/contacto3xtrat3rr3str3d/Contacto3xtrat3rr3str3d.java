package com.mycompany.contacto3xtrat3rr3str3d;

import com.mycompany.contacto3xtrat3rr3str3d.gui.Ide;
import com.mycompany.contacto3xtrat3rr3str3d.gui.resaltado.Tema;
import javax.swing.SwingUtilities;


public class Contacto3xtrat3rr3str3d {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tema.instalarLookAndFeel();
            new Ide().setVisible(true);
        });
    }
}
