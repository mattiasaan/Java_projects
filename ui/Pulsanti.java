import javax.swing.*;
import java.awt.*;

class Pulsanti
{
    public static void main(String args[])
    {
        JFrame f = new JFrame("Pulsanti");
        JPanel p = new JPanel();
        JButton sup = new JButton("Superiore");
        JButton inf = new JButton("Inferiore");
        JTextArea a = new JTextArea(50,10);

        p.setLayout(new BorderLayout());
        p.add(sup, "North");
        p.add(a, "Center");
        p.add(inf, "South");

        f.addWindowListener(new GestoreFinestra());
        sup.addActionListener(new GestorePulsante(a));
        inf.addActionListener(new GestorePulsante(a));

        a.setEditable(false);

        f.getContentPane().add(p);
        f.setSize(450,300);
        f.setVisible(true);
    }
}
