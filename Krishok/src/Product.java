import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Dewan Shah on 12/25/2016.
 */
public class Product {
    public static String deldata;
    public static int sum =0;
    public static String editdata;
    public static String finder;

    public Product(){
        JFrame products=new JFrame("Products");
        products.setSize(900,650);
        products.setLayout(null);
        products.setLocationRelativeTo(null);
        products.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable jt=new JTable();
        Object[] columns={"Product Name","Quantity","Price","Product Code","Product Seller","Seller Address","Seller Contact"};
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        jt.setModel(model);

        jt.setBackground(Color.GREEN);
        jt.setForeground(Color.RED);
        jt.setRowHeight(30);

        JLabel totalDamlebel=new JLabel("Cost :");
        totalDamlebel.setBounds(50,415,100,30);
        totalDamlebel.setFont(new Font("Tahoma",Font.BOLD,16));
        products.add(totalDamlebel);

        JTextField totaldam=new JTextField();
        totaldam.setBounds(160,420,120,30);
        products.add(totaldam);

        JLabel cost2=new JLabel();
        cost2.setBounds(50,520,300,40);
        cost2.setText("Total Cost :  ");
        products.add(cost2);

        JTextField grandTotal=new JTextField();
        grandTotal.setBounds(160,520,120,40);
        products.add(grandTotal);


        JLabel cost1=new JLabel();
        cost1.setBounds(50,460,300,40);
        cost1.setText("Vat : 10 taka");
        products.add(cost1);


        JLabel Acconut=new JLabel();
        Acconut.setBounds(400,420,100,30);
        Acconut.setText("Account No.");
        products.add(Acconut);

        JTextField accountText=new JTextField("");
        accountText.setBounds(520,420,140,30);
        products.add(accountText);

        JLabel password=new JLabel();
        password.setBounds(400,470,100,30);
        password.setText("Password");
        products.add(password);

        JPasswordField passwordText =new JPasswordField();
        passwordText.setBounds(520,470,140,30);
        products.add(passwordText);


        JScrollPane pane=new JScrollPane(jt);
        pane.setBounds(0,0,880,400);
        //products.add(jt);
        products.add(pane);

        Object[] row=new Object[7];
        try {
            BufferedReader br=new BufferedReader(new FileReader("Market Stock.txt"));
            String s=br.readLine();
            while (s!=null)
            {
                String[] str=s.split(" ");
                    if(str[0].equals(Buyer.st))
                    {
                        row [0]=str[0];
                        row [1]=str[1];
                        row [2]=str[2];
                        row [3]=str[3];
                        row [4]=str[4];
                        row [5]=str[5];
                        row [6]=str[6];

                        model.addRow(row);
                                System.out.println(s);
                    }
                    s=br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        jt.setVisible(true);
        products.setVisible(true);



        ImageIcon buyIcon=new ImageIcon("buyicon.png");
        JButton buyButton=new JButton("  Add to Cart",buyIcon);
        buyButton.setBounds(400,520,220,50);
        buyButton.setFont(new Font("Jokerman",Font.BOLD,18));
        products.add(buyButton);
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int j = jt.getSelectedRow();
                if (j >= 0) {
                    JFrame amount=new JFrame("Select Amount");
                    amount.setSize(300,270);
                    amount.setLayout(null);
                    amount.getContentPane().setBackground(Color.CYAN);
                    amount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JButton buyB=new JButton("Buy Package");
                    buyB.setBounds(60,20,130,35);
                    buyB.setFont(new Font("Comic Sans MS",Font.BOLD,14));
                    amount.add(buyB);
                    buyB.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String dam = (String) model.getValueAt(jt.getSelectedRow(), 2);
                            sum += Integer.parseInt(dam);


                            totaldam.setText(String.valueOf(sum));
                            grandTotal.setText(String.valueOf(sum + 10));

                            deldata = (String) model.getValueAt(jt.getSelectedRow(), 3);
                            readFromFile(deldata);

                            model.removeRow(j);
                            amount.dispose();
                        }
                    });
                    JLabel or=new JLabel("Or,");
                    or.setBounds(120,60,40,40);
                    amount.add(or);

                    JLabel qanti=new JLabel("Write Amount: ");
                    qanti.setBounds(45,110,100,30);
                    amount.add(qanti);

                    JTextField qantiText=new JTextField("");
                    qantiText.setBounds(150,110,100,30);
                    amount.add(qantiText);

                    JButton buyqan=new JButton("Buy");
                    buyqan.setBounds(60,160,130,35);
                    buyqan.setFont(new Font("Comic Sans MS",Font.BOLD,14));
                    amount.add(buyqan);
                    buyqan.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String dam = (String) model.getValueAt(jt.getSelectedRow(), 2);
                            String qantiti= (String) model.getValueAt(jt.getSelectedRow(),1);
                            int Dam=Integer.parseInt(dam);
                            int Qantiti=Integer.parseInt(qantiti);
                            int perUnit=Dam/Qantiti;
                            String r=qantiText.getText().trim();
                            int desiredQuantiti=Integer.parseInt(r);
                            sum+=perUnit*desiredQuantiti;
                            totaldam.setText(String.valueOf(sum));
                            grandTotal.setText(String.valueOf(sum + 10));
                            int reamainQ=Qantiti-desiredQuantiti;
                            int reamainD=Dam-(perUnit*desiredQuantiti);

                            String remainCropName= (String) model.getValueAt(jt.getSelectedRow(),0);
                            String remainQantiti=String.valueOf(reamainQ);
                            String remainDam=String.valueOf(reamainD);
                            String remainCode= (String) model.getValueAt(jt.getSelectedRow(),3);
                            String remainSellerName= (String) model.getValueAt(jt.getSelectedRow(),4);
                            String remainAddress= (String) model.getValueAt(jt.getSelectedRow(),5);
                            String remainContact= (String) model.getValueAt(jt.getSelectedRow(),6);

                            editdata=(remainCropName)+(" "+remainQantiti)+(" "+remainDam)+(" "+remainCode)+(" "+remainSellerName)+(" "+remainAddress)+(" "+remainContact);
                            finder=remainCode;

                            readFromFileEdit(finder,editdata);
                            model.setValueAt(remainQantiti,jt.getSelectedRow(),1);
                            model.setValueAt(remainDam,jt.getSelectedRow(),2);

                            amount.dispose();

                        }
                    });

                    amount.setVisible(true);

                }
            }
        });
        ImageIcon doneIcon=new ImageIcon("done.png");
        JButton done=new JButton("  Done",doneIcon);
        done.setBounds(650,520,220,50);
        done.setFont(new Font("Segoe UI Black",Font.BOLD,18));
        products.add(done);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!accountText.getText().equals(null) )
                {
                    if(!passwordText.getPassword().equals(null))
                    {
                        new PaidClass();
                    }
                }
                else {
                    new Notpaid();
                }

                products.dispose();
            }
        });

    }

    private void readFromFileEdit(String finder, String editdata) {
        ArrayList<String> list=new ArrayList<>();
        try {
            BufferedReader fileread=new BufferedReader(new FileReader("Market Stock.txt"));
            String fileString="";
            while ((fileString=fileread.readLine()) != null)
            {
                list.add(fileString);
            }
            System.out.println(list.toString());
            System.out.println("Readed");
            fileread.close();
            EditData(list,finder,editdata);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void EditData(ArrayList<String> list, String finder, String editdata) {
        System.out.println(list.toString());
        System.out.println("Received");
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(0));
            String[] tukra=list.get(i).split(" ");
            for(int k=0;k<tukra.length;k++)
            {
                if(tukra[k].equals(finder))
                {
                   list.set(i,editdata);
                    writetoFile(list);
                    break;
                }
            }

        }
        System.out.println("deleted");
        System.out.println(list.toString());

    }

    public static void readFromFile(String datadel) {

        ArrayList<String> list=new ArrayList<>();
        try {
            BufferedReader fileread=new BufferedReader(new FileReader("Market Stock.txt"));
            String fileString="";
            while ((fileString=fileread.readLine()) != null)
            {
                list.add(fileString);
            }
            System.out.println(list.toString());
            System.out.println("Readed");
            fileread.close();
            deleleteData(list,datadel);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    private static void deleleteData(ArrayList<String> list, String datadel) {
        System.out.println(list.toString());
        System.out.println("Received");
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(0));
            String[] tukra=list.get(i).split(" ");
            for(int k=0;k<tukra.length;k++)
            {
                    if(tukra[k].equals(datadel))
                    {
                        list.remove(i);
                        writetoFile(list);
                        break;
                    }
            }

        }
        System.out.println("deleted");
        System.out.println(list.toString());



    }

    private static void writetoFile(ArrayList<String> list) {
        try {
            BufferedWriter filewrite=new BufferedWriter(new FileWriter("Market Stock.txt"));
            for (String x:list)
            {
                filewrite.write(x);
                filewrite.newLine();

            }
            System.out.println("writed");
            filewrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
