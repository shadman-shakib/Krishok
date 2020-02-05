import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by shadm on 02-Jan-17.
 */
public class Signup {

    public static String alldata;

    public Signup()

    {
        JFrame frameSign = new JFrame();
        frameSign.setTitle("Sign Up");
        frameSign.setSize(600, 600);
        frameSign.setLayout(null);
        frameSign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userName = new JLabel("Name*");
        userName.setBounds(5, 0, 100, 100);
        userName.setFont(new Font("Ears Bold ITC", Font.BOLD, 14));
        userName.setForeground(Color.black);
        frameSign.add(userName);

        JTextField username = new JTextField("");
        username.setBounds(95, 37, 400, 30);
        frameSign.add(username);

        JLabel userAge = new JLabel("Age*");
        userAge.setBounds(5, 60, 100, 100);
        userAge.setFont(new Font("Ears Bold ITC", Font.BOLD, 14));
        userAge.setForeground(Color.black);
        frameSign.add(userAge);

        JTextField age = new JTextField("");
        age.setBounds(95, 97, 400, 30);
        frameSign.add(age);


        JLabel year = new JLabel("Years");
        year.setBounds(495, 60, 100, 100);
        year.setFont(new Font("Ears Bold ITC", Font.BOLD, 14));
        year.setForeground(Color.black);
        frameSign.add(year);

        JLabel userGender = new JLabel("Gender*");
        userGender.setBounds(5, 120, 100, 100);
        userGender.setFont(new Font("Ears Bold ITC", Font.BOLD, 14));
        userGender.setForeground(Color.black);
        frameSign.add(userGender);

        JCheckBox genderselect = new JCheckBox("Male");
        genderselect.setBounds(95, 157, 60, 30);
        frameSign.add(genderselect);

        JCheckBox femaleselect = new JCheckBox("Female");
        femaleselect.setBounds(165, 157, 160, 30);
        frameSign.add(femaleselect);

        /*JTextField gender = new JTextField("");
        gender.setBounds(95,157,400,30);
        frameSign.add(gender);*/

        JLabel userEmail = new JLabel("email*");
        userEmail.setBounds(5, 180, 100, 100);
        userEmail.setFont(new Font("Ears Bold ITC", Font.BOLD, 14));
        userEmail.setForeground(Color.black);
        frameSign.add(userEmail);

        JTextField email = new JTextField("");
        email.setBounds(95, 218, 400, 30);
        frameSign.add(email);

        JLabel userPhone = new JLabel("Phone No*");
        userPhone.setBounds(5, 240, 100, 100);
        userPhone.setFont(new Font("Ears Bold ITC", Font.BOLD, 14));
        userPhone.setForeground(Color.black);
        frameSign.add(userPhone);

        JTextField phoneNo = new JTextField("+088");
        phoneNo.setBounds(95, 277, 400, 30);
        frameSign.add(phoneNo);

        JLabel userPassword = new JLabel("Password*");
        userPassword.setBounds(5, 300, 100, 100);
        userPassword.setFont(new Font("Eras Bold ITC", Font.BOLD, 14));
        userPassword.setForeground(Color.BLACK);
        frameSign.add(userPassword);

        JPasswordField userpassword = new JPasswordField();
        userpassword.setBounds(95, 334, 400, 30);
        frameSign.add(userpassword);


        JButton creatAnother = new JButton("<<Back");
        creatAnother.setBounds(100, 450, 100, 30);
        creatAnother.setFont(new Font("Tahoma", Font.BOLD, 14));
        creatAnother.setForeground(Color.RED);
        frameSign.add(creatAnother);
        creatAnother.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameSign.dispose();
            }
        });

        JButton save = new JButton("Save");
        save.setBounds(400, 450, 100, 30);
        save.setFont(new Font("Tahoma", Font.BOLD, 17));
        save.setForeground(Color.blue);
        frameSign.add(save);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameUser = username.getText().trim();
                String userage = age.getText().trim();
                String usergenger = null;
                if (genderselect.isSelected() == true) {
                    usergenger = genderselect.getText().trim();
                } else if (femaleselect.isSelected() == true) {
                    usergenger = femaleselect.getText().trim();
                }
                String useremail = email.getText().trim();
                String userphone = phoneNo.getText().trim();
                char[] pass = userpassword.getPassword();
                String userpass = new String(pass);

                alldata = (nameUser) + (" " + userpass) + (" " + userage) + (" " + usergenger) + (" " + useremail) + (" " + userphone);

                String allData = alldata;

                System.out.println("Name: " + nameUser + " " + " " + "Password: " + userpass + " " + "Age: " + userage + " " + "Gender: " + usergenger + " " + "E-mail: " + useremail + " " + "Phone no: " + userphone);

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("login.txt", true));
                    writer.write(allData);
                    writer.flush();
                    writer.newLine();
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                frameSign.dispose();
            }
        });


        frameSign.setVisible(true);

    }

}
