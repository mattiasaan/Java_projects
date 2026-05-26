import javax.swing.SwingUtilities;

/**
 * Punto d'ingresso della calcolatrice GUI.
 * Usa SwingUtilities.invokeLater per avviare la GUI sul thread dedicato
 * all'Event Dispatch Thread (EDT), come richiesto da Swing.
 */
public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      App applicazione = new App();
      applicazione.calcolatrice();
    });
  }
}
