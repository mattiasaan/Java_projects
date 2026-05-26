import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Esercizio: Finestra con Pulsanti e Area di Testo
 *
 * Consegna: Creare una finestra Swing con una griglia 2×2 di pannelli.
 * Ogni pannello contiene due pulsanti (Superiore e Inferiore) e un'area
 * di testo non modificabile. Premendo un pulsante, il testo corrispondente
 * viene aggiunto nell'area di testo del pannello. La logica dei click è
 * separata in GestorePulsante (pattern Observer/Listener).
 *
 * Concetti applicati: JFrame, JPanel, JButton, JTextArea, BorderLayout,
 * GridLayout, ActionListener, separazione logica in classi listener.
 */
class Pulsanti {
  public static void main(String[] args) {
    JFrame f = new JFrame("Pulsanti");
    JPanel main = new JPanel();

    // Griglia 2x2 con spaziatura
    main.setLayout(new GridLayout(2, 2, 30, 30));

    // Crea 4 pannelli identici, ognuno con i propri pulsanti e area di testo
    for (byte i = 0; i < 4; i++) {
      JPanel p = new JPanel();
      JButton sup = new JButton("Superiore");
      JButton inf = new JButton("Inferiore");
      JTextArea a = new JTextArea(10, 30);

      p.setLayout(new BorderLayout());
      p.add(sup, "North");
      p.add(a, "Center");
      p.add(inf, "South");

      main.add(p);

      // Ogni area di testo riceve i click solo dei suoi pulsanti
      sup.addActionListener(new GestorePulsante(a));
      inf.addActionListener(new GestorePulsante(a));

      a.setEditable(false);
    }

    f.getContentPane().add(main);
    f.addWindowListener(new GestoreFinestra());
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}
