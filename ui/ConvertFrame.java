import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ConvertFrame extends JFrame implements ActionListener
{
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JTextField txtCentigradi = new JTextField(15);
    private JTextField txtFahrenheit = new JTextField(15);
    private JButton btnConverti = new JButton("Converti");

    public ConvertFrame()
    {
        super("Convertitore Centigradi->Fahrenheit");
        addWindowListener(new GestoreFinestra());

        p1.add(new JLabel("Gradi Centigradi: "));
        p1.add(txtCentigradi);
        p2.add(new JLabel("Gradi Fahrenheit: "));
        p2.add(txtFahrenheit);

        setLayout(new GridLayout(3,1,5,10));
        add(p1);
        add(btnConverti);
        add(p2);
        btnConverti.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        String pulsante = e.getActionCommand();
        double cent, fahr;

        if (pulsante.equals("Converti"))
        {
            try
            {
                String numeroLetto = txtCentigradi.getText();
                cent = Double.valueOf(numeroLetto).doubleValue();
                fahr = 32+(cent/100)*180;
                txtFahrenheit.setText(""+fahr);
            }
            catch(Exception exc)
            {
                txtFahrenheit.setText("");
            }
        }
    }
}
