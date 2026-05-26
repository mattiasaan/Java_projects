import javax.swing.JFrame;

/**
 * Esercizio: Prima Finestra Swing
 *
 * Consegna: Creare la finestra più semplice possibile con Swing — solo un
 * JFrame vuoto con titolo, dimensioni e listener per la chiusura. È il punto
 * di partenza per familiarizzare con la libreria GUI di Java.
 *
 * Concetti applicati: JFrame, setSize(), addWindowListener(), setVisible().
 */
class Vuota {
  public static void main(String[] args) {
    JFrame f = new JFrame("Finestra vuota");
    f.setSize(200, 200);
    f.addWindowListener(new GestoreFinestra());
    f.setVisible(true);
  }
}
