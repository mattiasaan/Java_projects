import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class IndovinaNumero extends JFrame {

    // Componenti spastici
    private JComboBox<String> comboLivello;
    private JCheckBox checkSuggerimenti;
    private JButton btnStart;
    private JTextField txtNumero;
    private JButton btnGioca;
    private JTextArea areaLog;
    private JLabel lblStato;
    private JButton btnReset;

    // stato gioco
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
        aggiornaStato(false);
    }

    private void buildUI() {
        setLayout(new BorderLayout());

        //n
        JPanel panelNord = new JPanel();
        panelNord.setLayout(new BoxLayout(panelNord, BoxLayout.Y_AXIS));
        panelNord.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));


        JPanel rigaDifficolta = new JPanel(new FlowLayout(FlowLayout.CENTER));

        rigaDifficolta.add(new JLabel("seleziona il livello di difficoltà:"));
        comboLivello = new JComboBox<>(new String[]{"FACILE", "MEDIO", "DIFFICILE"});
        comboLivello.setPreferredSize(new Dimension(100, 24));
        rigaDifficolta.add(comboLivello);
        panelNord.add(rigaDifficolta);

        // griglia info level
        JPanel gridInfo = new JPanel(new GridLayout(3, 3, 10, 2));
        gridInfo.setBorder(BorderFactory.createEmptyBorder(4, 40, 4, 40));//-----------------------------
        gridInfo.add(gridInfo.add(new JLabel("Livello FACILE")));  gridInfo.add(new JLabel("numero da 1 a 10"));  gridInfo.add(new JLabel("max. 5 tentativi"));
        gridInfo.add(gridInfo.add(new JLabel("Livello MEDIO")));   gridInfo.add(new JLabel("numero da 1 a 50"));  gridInfo.add(new JLabel("max. 10 tentativi"));
        gridInfo.add(gridInfo.add(new JLabel("Livello DIFFICILE")));gridInfo.add(new JLabel("numero da 1 a 100"));gridInfo.add(new JLabel("max. 15 tentativi"));
        panelNord.add(gridInfo);

        //sugg e start
        JPanel rigaStart = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rigaStart.add(new JLabel("Impostazione di gioco aggiuntiva:"));
        checkSuggerimenti = new JCheckBox("suggerimenti");
        rigaStart.add(checkSuggerimenti);
        btnStart = new JButton("START");
        rigaStart.add(btnStart);
        panelNord.add(rigaStart);

        add(panelNord, BorderLayout.NORTH);

        //centro
        JPanel panelCentro = new JPanel(new BorderLayout());


        JPanel rigaInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
        rigaInput.add(new JLabel("Inserisci numero:"));
        txtNumero = new JTextField(8);
        rigaInput.add(txtNumero);
        btnGioca = new JButton("Gioca!");
        rigaInput.add(btnGioca);
        panelCentro.add(rigaInput, BorderLayout.NORTH);

        // log
        areaLog = new JTextArea();
        areaLog.setEditable(false);
        areaLog.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        JScrollPane scroll = new JScrollPane(areaLog);
        scroll.setPreferredSize(new Dimension(560, 220));
        panelCentro.add(scroll, BorderLayout.CENTER);

        add(panelCentro, BorderLayout.CENTER);

        //sus
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

        //listener
        btnStart.addActionListener(e -> avviaGioco());
        btnGioca.addActionListener(e -> elaboraInput());
        txtNumero.addActionListener(e -> elaboraInput()); // invio da tastiera
        btnReset.addActionListener(e -> resetGioco());
    }

    // Ab/disb comp state
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
            case "FACILE":
                maxNumero = 10;
                tentativiTotali = 5;
            break;
            
            case "MEDIO":
                maxNumero = 50;
                tentativiTotali = 10;
            break;

            case "DIFFICILE":
                maxNumero = 100;
                tentativiTotali = 15;
            break;
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

        // deve essere int
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
            //win
            areaLog.append("Input: " + numero + " - HAI INDOVINATO!\n");
            int tentativiUsati = tentativiTotali - tentativiRimasti;
            lblStato.setForeground(new Color(0, 150, 0));
            lblStato.setText("hai vinto con " + tentativiUsati + " tentativi!");
            giocoAttivo = false;
            aggiornaStato(false);

        } else if (tentativiRimasti == 0) {
            //f
            areaLog.append("Input: " + numero + " - NON hai indovinato!\n");
            lblStato.setForeground(Color.RED);
            lblStato.setText("Tentativi esauriti! Il numero era " + numeroSegreto + ". Premi START per giocare di nuovo...");
            giocoAttivo = false;
            aggiornaStato(false);

        } else {
            // f con hint
            if (checkSuggerimenti.isSelected()) {
                String suggerimento = (numero < numeroSegreto) ? "troppo basso!" : "troppo alto!";
                areaLog.append("Input: " + numero + " - " + suggerimento + "\n");
            } else {
                areaLog.append("Input: " + numero + " - NON hai indovinato!\n");
            }
            lblStato.setForeground(Color.BLACK);
            lblStato.setText("Tentativi rimasti: " + tentativiRimasti);
        }

        // scroll in fondo
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
        SwingUtilities.invokeLater(() -> {
            new IndovinaNumero().setVisible(true);
        });
    }
}
