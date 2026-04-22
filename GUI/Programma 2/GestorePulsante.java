import java.awt.event.*;
import javax.swing.*;

class GestorePulsante implements ActionListener {
    private final JTextArea a;
    
    public GestorePulsante(JTextArea a) {
        this.a = a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pulsante = e.getActionCommand();

        if (pulsante.equals("Superiore")) {
            a.append("Hai premuto il tasto *superiore*!\n");
        }
        if (pulsante.equals("Inferiore")) {
            a.append("Hai premuto il pulsante *inferiore*!\n");
        }
    }
}