import javax.swing.*;
import java.awt.*;

/**
 * Created by Dewan Shah on 12/29/2016.
 */
public class Notpaid {
    public Notpaid(){
        JFrame paid=new JFrame("You are not DONE");
        paid.setSize(400,200);
        paid.setLayout(null);

        paid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel paidl=new JLabel();
        paidl.setBounds(50,10,300,110);
        paidl.setText("Not PAID !!");
        paidl.setFont(new Font("Chiller",Font.BOLD,48));
        paidl.setForeground(Color.RED);
        paid.add(paidl);


        paid.setVisible(true);

    }
}
