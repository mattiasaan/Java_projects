import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Esercizio: Gioco "Indovina il Numero" con GUI Swing (giocoSigma)
 *
 * Consegna: Creare un gioco grafico in cui l'utente deve indovinare un numero
 * segreto generato casualmente. Il gioco ha tre livelli di difficoltà:
 *   - FACILE:    numero tra 1-10,   max 5 tentativi
 *   - MEDIO:     numero tra 1-50,   max 10 tentativi
 *   - DIFFICILE: numero tra 1-100,  max 15 tentativi
 *
 * Requisiti: opzione "suggerimenti" (troppo alto/basso), contatore tentativi
 * rimasti, log delle guess effettuate, pulsante RESET, abilitazione/
 * disabilitazione dei componenti in base allo stato del gioco.
 *
 * Concetti applicati: JFrame con più pannelli (North/Center/South), JComboBox,
 * JCheckBox, JTextArea con JScrollPane, gestione dello stato del gioco,
 * aggiornamento dinamico della UI, colori per feedback visivo.
 */
public class IndovinaNumero extends JFrame {

  private JComboBox<String> comboLivello;
  private JCheckBox checkSuggerimenti;
  private JButton btnStart;
  private JTextField txtNumero;
  private JButton btnGioca;
  private JTextArea areaLog;
  private JLabel lblStato;
  private JButton btnReset;

  // Stato corrente del gioco
  private int numeroSegreto;
  private int tentativiRimasti;
  private int tentativiTotali;
  private int maxNumero;
  private boolean giocoAttivo = false;
  private Random random = new Random();

  public IndovinaNumero() {
    setTitle("bella gianda - Indovina il numero");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 580);
    setLocationRelativeTo(null);
    setResizable(false);

    buildUI();
    aggiornaStato(false); // inizialmente il gioco non è attivo
  }

  private void buildUI() {
    setLayout(new BorderLayout());

    // --- Zona Nord: selezione difficoltà e avvio ---
    JPanel panelNord = new JPanel();
    panelNord.setLayout(new BoxLayout(panelNord, BoxLayout.Y_AXIS));
    panelNord.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));

    JPanel rigaDifficolta = new JPanel(new FlowLayout(FlowLayout.CENTER));
    rigaDifficolta.add(new JLabel("seleziona il livello di difficoltà:"));
    comboLivello = new JComboBox<>(new String[]{"FACILE", "MEDIO", "DIFFICILE"});
    comboLivello.setPreferredSize(new Dimension(100, 24));
    rigaDifficolta.add(comboLivello);
    panelNord.add(rigaDifficolta);

    // Tabella informativa sui livelli
    JPanel gridInfo = new JPanel(new GridLayout(3, 3, 10, 2));
    gridInfo.setBorder(BorderFactory.createEmptyBorder(4, 40, 4, 40));
    gridInfo.add(new JLabel("Livello FACILE"));    gridInfo.add(new JLabel("numero da 1 a 10"));   gridInfo.add(new JLabel("max. 5 tentativi"));
    gridInfo.add(new JLabel("Livello MEDIO"));     gridInfo.add(new JLabel("numero da 1 a 50"));   gridInfo.add(new JLabel("max. 10 tentativi"));
    gridInfo.add(new JLabel("Livello DIFFICILE")); gridInfo.add(new JLabel("numero da 1 a 100")); gridInfo.add(new JLabel("max. 15 tentativi"));
    panelNord.add(gridInfo);

    JPanel rigaStart = new JPanel(new FlowLayout(FlowLayout.CENTER));
    rigaStart.add(new JLabel("Impostazione di gioco aggiuntiva:"));
    checkSuggerimenti = new JCheckBox("suggerimenti");
    rigaStart.add(checkSuggerimenti);
    btnStart = new JButton("START");
    rigaStart.add(btnStart);
    panelNord.add(rigaStart);

    add(panelNord, BorderLayout.NORTH);

    // --- Zona Centro: input guess e log ---
    JPanel panelCentro = new JPanel(new BorderLayout());

    JPanel rigaInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
    rigaInput.add(new JLabel("Inserisci numero:"));
    txtNumero = new JTextField(8);
    rigaInput.add(txtNumero);
    btnGioca = new JButton("Gioca!");
    rigaInput.add(btnGioca);
    panelCentro.add(rigaInput, BorderLayout.NORTH);

    areaLog = new JTextArea();
    areaLog.setEditable(false);
    areaLog.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
    JScrollPane scroll = new JScrollPane(areaLog);
    scroll.setPreferredSize(new Dimension(560, 220));
    panelCentro.add(scroll, BorderLayout.CENTER);

    add(panelCentro, BorderLayout.CENTER);

    // --- Zona Sud: stato e reset ---
    JPanel panelSud = new JPanel();
    panelSud.setLayout(new BoxLayout(panelSud, BoxLayout.Y_AXIS));
    panelSud.setBorder(BorderFactory.createEmptyBorder(6, 10, 10, 10));

    lblStato = new JLabel("Seleziona il livello di difficoltà e premi START per avviare il gioco!");
    lblStato.setAlignmentX(Component.CENTER_ALIGNMENT);
    panelSud.add(lblStato);

    btnReset = new JButton("RESET");
    btnReset.setAlignmentX(Component.CENTER_ALIGNMENT);
    panelSud.add(btnReset);

    add(panelSud, BorderLayout.SOUTH);

    // Collegamento listener
    btnStart.addActionListener(e -> avviaGioco());
    btnGioca.addActionListener(e -> elaboraInput());
    txtNumero.addActionListener(e -> elaboraInput()); // invio da tastiera
    btnReset.addActionListener(e -> resetGioco());
  }

  /** Abilita/disabilita i componenti in base a se il gioco è attivo o no. */
  private void aggiornaStato(boolean attivo) {
    comboLivello.setEnabled(!attivo);
    checkSuggerimenti.setEnabled(!attivo);
    btnStart.setEnabled(!attivo);
    txtNumero.setEnabled(attivo);
    btnGioca.setEnabled(attivo);
  }

  private void avviaGioco() {
    String livello = (String) comboLivello.getSelectedItem();
    switch (livello) {
      case "FACILE":    maxNumero = 10;  tentativiTotali = 5;  break;
      case "MEDIO":     maxNumero = 50;  tentativiTotali = 10; break;
      case "DIFFICILE": maxNumero = 100; tentativiTotali = 15; break;
    }
    numeroSegreto = random.nextInt(maxNumero) + 1;
    tentativiRimasti = tentativiTotali;
    giocoAttivo = true;

    areaLog.setText("");
    lblStato.setForeground(Color.BLACK);
    lblStato.setText("Tentativi rimasti: " + tentativiRimasti);

    aggiornaStato(true);
    txtNumero.requestFocus();
  }

  private void elaboraInput() {
    if (!giocoAttivo) return;

    String input = txtNumero.getText().trim();
    txtNumero.setText("");

    int numero;
    try {
      numero = Integer.parseInt(input);
    } catch (NumberFormatException ex) {
      lblStato.setForeground(Color.RED);
      lblStato.setText("ERRORE: \"" + input + "\" NON è un numero valido!");
      return;
    }

    tentativiRimasti--;

    if (numero == numeroSegreto) {
      // Vittoria
      areaLog.append("Input: " + numero + " - HAI INDOVINATO!\n");
      int tentativiUsati = tentativiTotali - tentativiRimasti;
      lblStato.setForeground(new Color(0, 150, 0));
      lblStato.setText("hai vinto con " + tentativiUsati + " tentativi!");
      giocoAttivo = false;
      aggiornaStato(false);

    } else if (tentativiRimasti == 0) {
      // Sconfitta
      areaLog.append("Input: " + numero + " - NON hai indovinato!\n");
      lblStato.setForeground(Color.RED);
      lblStato.setText("Tentativi esauriti! Il numero era " + numeroSegreto + ". Premi START per giocare di nuovo...");
      giocoAttivo = false;
      aggiornaStato(false);

    } else {
      // Tentativo fallito, eventuale suggerimento
      if (checkSuggerimenti.isSelected()) {
        String suggerimento = (numero < numeroSegreto) ? "troppo basso!" : "troppo alto!";
        areaLog.append("Input: " + numero + " - " + suggerimento + "\n");
      } else {
        areaLog.append("Input: " + numero + " - NON hai indovinato!\n");
      }
      lblStato.setForeground(Color.BLACK);
      lblStato.setText("Tentativi rimasti: " + tentativiRimasti);
    }

    // Scorre automaticamente in fondo al log
    areaLog.setCaretPosition(areaLog.getDocument().getLength());
  }

  private void resetGioco() {
    giocoAttivo = false;
    areaLog.setText("");
    lblStato.setForeground(Color.BLACK);
    lblStato.setText("Seleziona il livello di difficoltà e premi START per avviare il gioco!");
    txtNumero.setText("");
    aggiornaStato(false);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new IndovinaNumero().setVisible(true));
  }
}
