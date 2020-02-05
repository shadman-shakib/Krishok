import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


/**
 * Created by Dewan Shah on 12/24/2016.
 */
public class Buyer {
    public static String st;

    public Buyer(){
        JFrame buy=new JFrame("Buy");
        buy.setSize(400,350);
        buy.setLayout(null);
        try {
            buy.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("search.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        buy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ins=new JLabel("What you want to Buy ?");
        ins.setBounds(110, 50, 180, 30);
        ins.setFont(new Font("Curlz MT", Font.BOLD,16));
        buy.add(ins);

        JLabel searchCropName=new JLabel("Crop Name");
        searchCropName.setBounds(20, 120, 80, 30);
        buy.add(searchCropName);

        JTextField searchCropNameText=new JTextField("");
        searchCropNameText.setBounds(110, 120, 200, 30);
        buy.add(searchCropNameText);

        ImageIcon searchIcon=new ImageIcon("searchcon.png");
        JButton search = new JButton(" Search",searchIcon);
        search.setBounds(135,200,130,40);
        search.setFont(new Font("Cooper Black",Font.ITALIC,14));
        buy.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent p) {
                st=searchCropNameText.getText();
                new Product();
                buy.dispose();

            }
        });

        buy.setVisible(true);
    }


}
