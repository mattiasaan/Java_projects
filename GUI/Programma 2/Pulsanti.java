import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class Pulsanti {
    public static void main(String[] args) {
        JFrame f = new JFrame("Pulsanti");
        JPanel main = new JPanel();

        main.setLayout(new GridLayout(2, 2, 30, 30));

        for(byte i = 0; i < 4; i++) {
            JPanel p = new JPanel();
            JButton sup = new JButton("Superiore");
            JButton inf = new JButton("Inferiore");
            JTextArea a = new JTextArea(10, 30);

            p.setLayout(new BorderLayout());
            p.add(sup, "North");
            p.add(a, "Center");
            p.add(inf, "South");

            main.add(p);

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
