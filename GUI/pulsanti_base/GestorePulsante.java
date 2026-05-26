import java.awt.event.*;
import javax.swing.*;

/**
 * Listener per i pulsanti Superiore e Inferiore.
 * Riceve il riferimento alla JTextArea di competenza nel costruttore
 * e vi appende il messaggio corrispondente al pulsante premuto.
 */
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
