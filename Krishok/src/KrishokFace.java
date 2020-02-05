import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dewan Shah on 1/3/2017.
 */
public class KrishokFace {
    public KrishokFace(){
        JFrame mainFrame=new JFrame("Krishok");
        mainFrame.setSize(600,600);
        mainFrame.setLayout(null);
        try {
            mainFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("front.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon selIcon=new ImageIcon("sellproduct.png");
        JButton mainsellButton=new JButton("Sell Products",selIcon);
        mainsellButton.setBounds(180,350,250,50);
        mainsellButton.setFont(new Font("Colonna MT",Font.BOLD,20));
        mainFrame.add(mainsellButton);
        mainsellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Market();
                mainFrame.dispose();
            }
        });

        ImageIcon buyIcon=new ImageIcon("buyproduct.png");
        JButton mainbuyButton=new JButton("Buy Products",buyIcon);
        mainbuyButton.setBounds(180,450,250,50);
        mainbuyButton.setFont(new Font("Colonna MT",Font.BOLD,20));
        mainFrame.add(mainbuyButton);
        mainbuyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Buyer();
                mainFrame.dispose();
            }
        });

        mainFrame.setVisible(true);

    }
}
