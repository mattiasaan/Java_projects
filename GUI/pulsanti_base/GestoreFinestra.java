import java.awt.event.*;

/**
 * Listener per la chiusura della finestra.
 * Implementa WindowListener e gestisce solo windowClosing()
 * per terminare il programma correttamente.
 */
class GestoreFinestra implements WindowListener {
  @Override public void windowIconified(WindowEvent e) {}
  @Override public void windowDeiconified(WindowEvent e) {}
  @Override public void windowActivated(WindowEvent e) {}
  @Override public void windowDeactivated(WindowEvent e) {}
  @Override public void windowOpened(WindowEvent e) {}
  @Override public void windowClosed(WindowEvent e) {}

  @Override
  public void windowClosing(WindowEvent e) {
    System.out.println("Programma terminato");
    System.exit(0);
  }
}
