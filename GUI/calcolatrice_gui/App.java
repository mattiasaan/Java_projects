import java.awt.*;
import javax.swing.*;

/**
 * Esercizio: Calcolatrice Grafica con Swing (pattern MVC)
 *
 * Consegna: Creare una calcolatrice grafica simile a quella di iOS/Android.
 * La GUI deve avere: un display principale con il numero corrente, un'area
 * di cronologia con le operazioni passate, e un tastierino con tutti i tasti
 * (0-9, operatori, AC, del, %). Il pulsante "=" valuta l'espressione e
 * aggiunge il risultato alla cronologia. La logica di calcolo deve essere
 * separata in una classe ModelloCalcolatrice (pattern MVC).
 *
 * Concetti applicati: GridLayout per il tastierino, BoxLayout per lo schermo,
 * lambda come ActionListener, JScrollPane per la cronologia, formattazione
 * condizionale dell'output (intero vs decimale), pattern MVC.
 */
public class App {
  private ModelloCalcolatrice modello = new ModelloCalcolatrice();

  public void calcolatrice() {
    JFrame frame = new JFrame("Calcolatrice");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout(0, 0));

    // --- Schermo (zona nord) ---
    JPanel pannelloSchermo = new JPanel();
    pannelloSchermo.setLayout(new BoxLayout(pannelloSchermo, BoxLayout.Y_AXIS));
    pannelloSchermo.setBackground(new Color(240, 240, 240));
    pannelloSchermo.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

    // Area cronologia: mostra le operazioni passate in grigio
    JTextArea areaCronologia = new JTextArea(8, 20);
    areaCronologia.setEditable(false);
    areaCronologia.setFont(new Font("SansSerif", Font.ITALIC, 16));
    areaCronologia.setForeground(new Color(100, 100, 100));
    areaCronologia.setBackground(new Color(240, 240, 240));
    JScrollPane scrollCronologia = new JScrollPane(areaCronologia);
    scrollCronologia.setBorder(null);

    // Display principale: mostra l'espressione corrente in grande
    JTextField displayInput = new JTextField("");
    displayInput.setFont(new Font("SansSerif", Font.BOLD, 42));
    displayInput.setHorizontalAlignment(JTextField.RIGHT);
    displayInput.setEditable(false);
    displayInput.setBorder(null);
    displayInput.setBackground(new Color(240, 240, 240));

    pannelloSchermo.add(scrollCronologia);
    pannelloSchermo.add(Box.createVerticalStrut(15));
    pannelloSchermo.add(displayInput);

    // --- Tastierino (zona centro) ---
    String[] bottoni = {
      "AC", "()", "%", "/",
      "7",  "8",  "9", "*",
      "4",  "5",  "6", "-",
      "1",  "2",  "3", "+",
      "0",  ".",  "del", "="
    };

    JPanel tastierino = new JPanel(new GridLayout(5, 4, 1, 1));
    tastierino.setBackground(new Color(220, 220, 220));

    for (String testo : bottoni) {
      JButton b = new JButton(testo);
      b.setFont(new Font("SansSerif", Font.PLAIN, 22));
      b.setFocusPainted(false);
      b.setBackground(Color.WHITE);
      b.setBorder(BorderFactory.createEmptyBorder());

      // "=" in blu, operatori in blu testo
      if (testo.equals("=")) {
        b.setBackground(new Color(41, 128, 185));
        b.setForeground(Color.WHITE);
      } else if (testo.matches("[/*-+]")) {
        b.setForeground(new Color(41, 128, 185));
      }

      // Lambda: gestisce ogni tasto in base al suo testo
      b.addActionListener(e -> {
        String attuale = displayInput.getText();
        switch (testo) {
          case "AC":
            displayInput.setText("");
            break;
          case "del":
            if (!attuale.isEmpty()) displayInput.setText(attuale.substring(0, attuale.length() - 1));
            break;
          case "=":
            if (!attuale.isEmpty()) {
              double risultato = modello.risolviEspressione(attuale);
              String risFormattato = formattaRisultato(risultato);
              areaCronologia.append(attuale + " = " + risFormattato + "\n");
              displayInput.setText(risFormattato);
            }
            break;
          default:
            displayInput.setText(attuale + testo);
            break;
        }
      });
      tastierino.add(b);
    }

    frame.add(pannelloSchermo, BorderLayout.NORTH);
    frame.add(tastierino, BorderLayout.CENTER);
    frame.setSize(400, 650);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  /** Formatta il risultato: mostra come intero se non ha decimali, altrimenti con 2 cifre. */
  private String formattaRisultato(double d) {
    if (d == (long) d) return String.format("%d", (long) d);
    return String.format("%.2f", d).replace(",", ".");
  }
}
