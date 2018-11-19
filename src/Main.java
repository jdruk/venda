
import java.math.BigDecimal;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//  w ww.  j av  a2  s .  co m

public class Main {

    public static void main(String[] args) {
        BigDecimal d = new BigDecimal("20");
        System.out.println(d);
        d = d.subtract(BigDecimal.ONE);
        System.out.println(d);
    }
}
