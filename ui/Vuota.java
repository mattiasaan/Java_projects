import javax.swing.*;
import java.awt.*;

class Vuota
{
    public static void main(String args[])
    {
        JFrame f = new JFrame("Finestra vuota");
        f.setSize(200,200);
        f.addWindowListener(new GestoreFinestra());
        f.setVisible(true);
    }
}
