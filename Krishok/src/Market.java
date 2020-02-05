import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class Market {
	public static String summary;
	public Market(){
		JFrame market = new JFrame();
		market.setTitle("Sell");
		market.setSize(400, 500);
		market.setLayout(null);
		try {
			market.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("mrket.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		market.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel cropname=new JLabel("Crop Name");
		cropname.setBounds(10, 10, 100, 40);
		cropname.setFont(new Font("Eras Bold ITC",Font.BOLD,16));
		cropname.setForeground(Color.BLACK);
		market.add(cropname);
		
		JTextField name=new JTextField("");
		name.setBounds(140, 10, 200, 30);
		market.add(name);
		
		JLabel quantity=new JLabel("Quantity");
		quantity.setBounds(10, 60, 100, 40);
		quantity.setFont(new Font("Eras Bold ITC",Font.BOLD,16));
		quantity.setForeground(Color.BLACK);
		market.add(quantity);
		
		JTextField qnty=new JTextField("");
		qnty.setBounds(140, 60, 200, 30);
		market.add(qnty);

		JLabel kg=new JLabel("kg");
		kg.setBounds(350, 60, 80, 30);
		kg.setFont(new Font("Eras Bold ITC",Font.ITALIC,12));
		kg.setForeground(Color.BLACK);
		market.add(kg);

		JLabel price=new JLabel("Price");
		price.setBounds(10, 110, 80, 30);
		price.setFont(new Font("Eras Bold ITC",Font.BOLD,16));
		price.setForeground(Color.BLACK);
		market.add(price);

		JTextField pricetext=new JTextField("");
		pricetext.setBounds(140, 110, 200, 30);
		market.add(pricetext);

		JLabel taka=new JLabel("taka");
		taka.setBounds(350, 110, 80, 30);
		taka.setFont(new Font("Eras Bold ITC",Font.ITALIC,12));
		taka.setForeground(Color.BLACK);
		market.add(taka);

		JLabel sellerinfo=new JLabel("Seller Information* :");
		sellerinfo.setBounds(10, 150, 150, 30);
		market.add(sellerinfo);

		JLabel sellername=new JLabel("Name");
		sellername.setBounds(30, 180, 80, 30);
		market.add(sellername);

		JTextField sellernamebox=new JTextField("");
		sellernamebox.setBounds(160, 180, 200, 30);
		market.add(sellernamebox);

		JLabel selleraddress=new JLabel("Address");
		selleraddress.setBounds(30, 230, 80, 30);
		market.add(selleraddress);

		JTextField selleraddressbox=new JTextField("");
		selleraddressbox.setBounds(160, 230, 200, 30);
		market.add(selleraddressbox);

		JLabel sellercontact=new JLabel("Contact No.");
		sellercontact.setBounds(30, 280, 80, 30);
		market.add(sellercontact);

		JTextField sellercontactbox=new JTextField("+880");
		sellercontactbox.setBounds(160, 280, 200, 30);
		market.add(sellercontactbox);

		JLabel sellerCode=new JLabel("**Seller Code");
		sellerCode.setBounds(60, 320, 80, 30);
		market.add(sellerCode);

		JTextField sellerCodetext=new JTextField();
		sellerCodetext.setBounds(160, 320, 210, 30);
		market.add(sellerCodetext);

		JButton clear = new JButton("New");
		clear.setBounds(133,420,100,30);
		clear.setFont(new Font("Tahoma",Font.ITALIC,14));
		market.add(clear);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent E) {
				name.setText(null);
				qnty.setText("");
				pricetext.setText("");
				sellernamebox.setText(null);
				selleraddressbox.setText(null);
				sellercontactbox.setText("+880");
				sellerCodetext.setText(null);
			}
		});

		JButton publish = new JButton("Publish");
		publish.setBounds(108,380,150,30);

		publish.setFont(new Font("Comic Sans MS",Font.BOLD,18));
		market.add(publish);
		publish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String cropName=name.getText().trim();
				String quanTity=qnty.getText().trim();
				String prIce=pricetext.getText().trim();
				String sellerName=sellernamebox.getText().trim();
				String sellerAddress=selleraddressbox.getText().trim();
				String sellerContact=sellercontactbox.getText().trim();


				Random rand=new Random();
				String sellCode= String.valueOf(rand.nextInt(999999999));


				sellerCodetext.setText(sellCode);

				summary=(cropName)+(" "+quanTity)+(" "+prIce)+(" "+sellCode)+(" "+sellerName)+(" "+sellerAddress)+(" "+sellerContact);
				String data=summary;
				System.out.println(cropName+" "+quanTity+" "+prIce+" "+sellerName+" "+sellerAddress+" "+sellerContact+" "+sellCode);

				try {
					BufferedWriter bw=new BufferedWriter(new FileWriter("Market Stock.txt",true));
					BufferedWriter bws=new BufferedWriter(new FileWriter("Seller.txt",true));
					bw.write(data);
					bws.write(data);
					bw.flush();
					bws.flush();
					bw.newLine();
					bws.newLine();
					bw.close();
					bws.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
		
		market.setVisible(true);
	}


}
