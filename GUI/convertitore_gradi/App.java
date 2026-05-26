import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Esercizio: Convertitore di Temperature con GUI Swing
 *
 * Consegna: Creare un'applicazione grafica che permetta di convertire
 * temperature tra Celsius, Fahrenheit e Kelvin. L'utente inserisce il valore,
 * sceglie l'unità di partenza e quella di destinazione tramite JComboBox,
 * poi preme il pulsante per ottenere il risultato in un dialogo.
 * La logica di conversione deve essere separata in una classe dedicata
 * (Convertitore.java).
 *
 * Concetti applicati: JFrame, JPanel con layout annidati (BorderLayout +
 * GridLayout), JComboBox, JTextField, JButton, ActionListener anonimo,
 * JOptionPane, separazione GUI/logica.
 */
public class App {
  private JComboBox<String> combo1;
  private JComboBox<String> combo2;
  private JTextField inputTemperatura;
  private String[] temperature = {"°C Celsius", "°F Fahrenheit", "°K Kelvin"};

  public void convertitore() {
    JFrame frame = new JFrame("Convertitore");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    // Titolo nella zona nord
    JPanel titlePanel = new JPanel();
    JLabel t = new JLabel("Convertitore di temperature:");
    t.setFont(new Font("Serif", Font.BOLD, 30));
    titlePanel.add(t);

    // Centro: 3 righe (input + unità di partenza, unità di destinazione, pulsante)
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(3, 1));

    JPanel riga1 = new JPanel();
    inputTemperatura = new JTextField(10);
    combo1 = new JComboBox<>(temperature);
    riga1.add(new JLabel("Valore:"));
    riga1.add(inputTemperatura);
    riga1.add(combo1);

    JPanel riga2 = new JPanel();
    combo2 = new JComboBox<>(temperature);
    riga2.add(new JLabel("Converti in:"));
    riga2.add(combo2);

    JPanel riga3 = new JPanel();
    JButton submit = new JButton("Converti");
    riga3.add(submit);

    centerPanel.add(riga1);
    centerPanel.add(riga2);
    centerPanel.add(riga3);

    // Listener del pulsante: delega la conversione alla classe Convertitore
    submit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          String testo = inputTemperatura.getText();
          double valore = Double.parseDouble(testo);

          String u1 = (String) combo1.getSelectedItem();
          String u2 = (String) combo2.getSelectedItem();

          Convertitore c = new Convertitore(u1, u2, valore);
          double risultato = c.convertFromTo();

          JOptionPane.showMessageDialog(
            frame,
            valore + " " + u1 + " in " + u2 + " risulta: " + risultato + "!",
            "Risultato",
            JOptionPane.INFORMATION_MESSAGE
          );
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(frame, "Inserisci un numero valido!", "Errore", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    frame.add(titlePanel, BorderLayout.NORTH);
    frame.add(centerPanel, BorderLayout.CENTER);
    frame.setSize(500, 350);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
