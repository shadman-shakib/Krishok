import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dewan Shah on 1/3/2017.
 */
public class Login {
    private static String loginName;
    private static String loginPass;
    public Login(){
        JFrame loginFrame=new JFrame("Log in");
        loginFrame.setSize(400,220);
        loginFrame.getContentPane().setBackground(Color.ORANGE);
        loginFrame.setLayout(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userName=new JLabel("Name: ");
        userName.setBounds(80,20,60,30);
        loginFrame.add(userName);

        JTextField userNameText=new JTextField("");
        userNameText.setBounds(160,20,140,30);
        loginFrame.add(userNameText);

        JLabel userPassword=new JLabel("Password: ");
        userPassword.setBounds(80,80,80,30);
        loginFrame.add(userPassword);

        JPasswordField passtext=new JPasswordField();
        passtext.setBounds(160,80,140,30);
        loginFrame.add(passtext);

        JButton loginButton=new JButton("Log in");
        loginButton.setBounds(130,130,120,30);
        loginFrame.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginName=userNameText.getText();
                char[] passy=passtext.getPassword();
                loginPass=new String(passy);

                boolean b=check();

                if(b==true)
                {
                    new KrishokFace();
                    loginFrame.dispose();
                }
                else {
                    JFrame wrong =new JFrame("Wrong");
                    wrong.setSize(100,80);
                    wrong.setLayout(null);
                    wrong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JLabel Wrong =new JLabel("Incorrect");
                    Wrong.setBounds(40,10,60,30);
                    wrong.add(Wrong);

                    JButton tryagain=new JButton("Try Ahain");
                    tryagain.setBounds(30,50,60,30);
                    wrong.add(tryagain);
                    tryagain.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            wrong.dispose();
                        }
                    });

                    wrong.setVisible(true);
                }
            }
        });

        loginFrame.setVisible(true);
    }
    public static boolean check(){
        try {
            BufferedReader br =new BufferedReader(new FileReader("login.txt"));
            String s=br.readLine();
            while(s!=null)
            {
                String[] str=s.split(" ");
                if(str[0].equals(loginName))
                {
                    if(str[1].equals(loginPass))
                    {
                        return true;
                    }
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
