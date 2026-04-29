import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class IndovinaNumeroSigma extends JFrame {
  
    private JComboBox<String> comboLivello;
    private JCheckBox checkSuggerimenti;
    private JButton btnStart;
    private JTextField txtNumero;
    private JButton btnGioca;
    private JTextArea areaLog;
    private JLabel lblStato;
    private JButton btnReset;

    private int numeroSegreto;
    private int tentativiRimasti;
    private int tentativiTotali;
    private int maxNumero;
    private boolean giocoAttivo = false;

  public IndovinaNumeroSigma() {
    setTitle("GIOCO - Indovina il numero");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 580);
    setLocationRelativeTo(null);
    setResizable(false);
    buildUI();
  }

  private void buildUI() {
        setLayout(new BorderLayout());

        // ORD
        JPanel panelNord = new JPanel();
        panelNord.setLayout(new BoxLayout(panelNord, BoxLayout.Y_AXIS));
        panelNord.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));

        // Riga: selezione difficoltà
        JPanel rigaDifficolta = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rigaDifficolta.add(new JLabel("Seleziona il livello di difficoltà:"));
        comboLivello = new JComboBox<>(new String[]{"FACILE", "MEDIO", "DIFFICILE"});
        comboLivello.setPreferredSize(new Dimension(100, 24));
        rigaDifficolta.add(comboLivello);
        panelNord.add(rigaDifficolta);

        // Griglia info livelli
        JPanel gridInfo = new JPanel(new GridLayout(3, 3, 10, 2));
        gridInfo.setBorder(BorderFactory.createEmptyBorder(4, 40, 4, 40));
        gridInfo.add(bold("Livello FACILE"));  gridInfo.add(new JLabel("numero da 1 a 10"));  gridInfo.add(new JLabel("max. 5 tentativi"));
        gridInfo.add(bold("Livello MEDIO"));   gridInfo.add(new JLabel("numero da 1 a 50"));  gridInfo.add(new JLabel("max. 10 tentativi"));
        gridInfo.add(bold("Livello DIFFICILE"));gridInfo.add(new JLabel("numero da 1 a 100"));gridInfo.add(new JLabel("max. 15 tentativi"));
        panelNord.add(gridInfo);

        // Riga: suggerimenti + START
        JPanel rigaStart = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rigaStart.add(new JLabel("Impostazione di gioco aggiuntiva:"));
        checkSuggerimenti = new JCheckBox("suggerimenti");
        rigaStart.add(checkSuggerimenti);
        btnStart = new JButton("START");
        rigaStart.add(btnStart);
        panelNord.add(rigaStart);

        add(panelNord, BorderLayout.NORTH);

        // CENTRO
        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        // Riga input (NORD del centro)
        JPanel rigaInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rigaInput.add(new JLabel("Inserisci numero:"));
        txtNumero = new JTextField(8);
        rigaInput.add(txtNumero);
        btnGioca = new JButton("Gioca!");
        rigaInput.add(btnGioca);
        panelCentro.add(rigaInput, BorderLayout.NORTH);

        // Area log (CENTRO del centro)
        areaLog = new JTextArea();
        areaLog.setEditable(false);
        areaLog.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaLog.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        JScrollPane scroll = new JScrollPane(areaLog);
        scroll.setPreferredSize(new Dimension(560, 220));
        panelCentro.add(scroll, BorderLayout.CENTER);

        add(panelCentro, BorderLayout.CENTER);

        // ===== SUD =====
        JPanel panelSud = new JPanel();
        panelSud.setLayout(new BoxLayout(panelSud, BoxLayout.Y_AXIS));
        panelSud.setBorder(BorderFactory.createEmptyBorder(6, 10, 10, 10));

        lblStato = new JLabel("Seleziona il livello di difficoltà e premi START per avviare il gioco!");
        lblStato.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblStato.setFont(new Font("SansSerif", Font.PLAIN, 12));
        panelSud.add(lblStato);

        panelSud.add(Box.createVerticalStrut(6));

        btnReset = new JButton("RESET");
        btnReset.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelSud.add(btnReset);

        add(panelSud, BorderLayout.SOUTH);

        /*
        btnStart.addActionListener(e -> avviaGioco());
        btnGioca.addActionListener(e -> elaboraInput());
        txtNumero.addActionListener(e -> elaboraInput()); // invio da tastiera
        btnReset.addActionListener(e -> resetGioco());
        */
    }
    private JLabel bold(String testo) {
      JLabel l = new JLabel(testo);
      l.setFont(l.getFont().deriveFont(Font.BOLD));
      return l;
    }

  private int randomNumber(int n) {
    Random random = new Random();
    int numeroCasuale = random.nextInt(n);
    
    System.out.println("Numero casuale: " + numeroCasuale);

    return numeroCasuale;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        new IndovinaNumeroSigma().setVisible(true);
  });
}
}