import javax.swing.*;
import java.awt.*;

/**
 * Created by Dewan Shah on 12/27/2016.
 */
public class PaidClass {
    public PaidClass(){
        JFrame paid=new JFrame("You are DONE");
        paid.setSize(300,200);
        paid.setLayout(null);

        paid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel paidl=new JLabel();
        paidl.setBounds(50,10,200,110);
        paidl.setText("PAID !!");
        paidl.setFont(new Font("Chiller",Font.BOLD,48));
        paidl.setForeground(Color.RED);
        paid.add(paidl);


        paid.setVisible(true);
    }
}
