package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JLabel label_welcome , label_cardno , label_pin;
    JTextField textfield_cardno ;
    JPasswordField passwordfield_pin;
    JButton button_signin,button_signup,button_clear;


    Color btnColor = new Color(0, 64, 128);
    Color textWhite = new Color(245,245,245);
    Color welcomegold = new Color(200,170,80);

    Login()
    {
        super("Bank Management System");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("project_images and sounds/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon i3= new ImageIcon(i2);
        JLabel bank_image =new JLabel(i3);
        bank_image.setBounds(380,10,100,100);
        add(bank_image);

        ImageIcon j1= new ImageIcon(ClassLoader.getSystemResource("project_images and sounds/card.png"));
        Image j2=j1.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon j3= new ImageIcon(j2);
        JLabel card_image = new JLabel(j3);
        card_image.setBounds(630,350,100,100);
        add(card_image);

        label_welcome=new JLabel("WELCOME TO ATM");
        label_welcome.setForeground(welcomegold);
        label_welcome.setFont(new Font("Segoe UI",Font.BOLD,38));
        label_welcome.setBounds(255,125,450,40);
        add(label_welcome);

        label_cardno = new JLabel("Card No :");
        label_cardno.setForeground(textWhite);
        label_cardno.setFont(new Font("Segoe UI",Font.BOLD,26));
        label_cardno.setBounds(150,190,375,30);
        add(label_cardno);

        label_pin = new JLabel("PIN : ");
        label_pin.setForeground(textWhite);
        label_pin.setFont(new Font("Segoe UI",Font.BOLD,26));
        label_pin.setBounds(150,250,375,30);
        add(label_pin);

        textfield_cardno = new JTextField(15);
        textfield_cardno.setFont(new Font("Segoe UI",Font.PLAIN,16));
        textfield_cardno.setBounds(325,190,235,35);
        add(textfield_cardno);

        passwordfield_pin = new JPasswordField(15);
        passwordfield_pin.setFont(new Font ("Segoe UI",Font.PLAIN,16));
        passwordfield_pin.setBounds(325,250,235,35);
        add(passwordfield_pin);

        button_signin=new JButton("SIGN IN");
        button_signin.setForeground(Color.WHITE);
        button_signin.setBackground(btnColor);
        button_signin.setFont(new Font("Segoe UI",Font.BOLD,14));
        button_signin.setBounds(325,300,110,35);
        button_signin.setFocusPainted(false);
        button_signin.addActionListener(this);
        add(button_signin);

        button_clear = new JButton("CLEAR");
        button_clear.setForeground(Color.WHITE);
        button_clear.setBackground(btnColor);
        button_clear.setFont(new Font("Segoe UI",Font.BOLD,14));
        button_clear.setBounds(455,300,110,35);
        button_clear.setFocusPainted(false);
        button_clear.addActionListener(this);
        add(button_clear);

        button_signup = new JButton("SIGN UP");
        button_signup.setForeground(Color.WHITE);
        button_signup.setBackground(btnColor);
        button_signup.setFont(new Font ("Segoe UI",Font.BOLD,14));
        button_signup.setBounds(325,350,240,35);
        button_signup.setFocusPainted(false);
        button_signup.addActionListener(this);
        add(button_signup);

        ImageIcon k1= new ImageIcon(ClassLoader.getSystemResource("project_images and sounds/backbg.png"));
        Image k2=k1.getImage().getScaledInstance(850,480,Image.SCALE_SMOOTH);
        ImageIcon k3= new ImageIcon(k2);
        JLabel  back_bg = new JLabel(k3);
        back_bg.setBounds(0,0,850,480);
        add(back_bg);

        setLayout(null);
        setSize(850,480);
        setLocation(330,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == button_signin) {

                Con c = new Con();
                String cardno = textfield_cardno.getText();
                String pin = new String(passwordfield_pin.getPassword());

                String query = "SELECT * FROM login WHERE card_no='" + cardno + "' AND pin='" + pin + "'";
                ResultSet rs = c.statement.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Main(cardno);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                }

            } else if (e.getSource() == button_clear) {
                textfield_cardno.setText("");
                passwordfield_pin.setText("");

            } else if (e.getSource() == button_signup) {
                setVisible(false);
                new Signup();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Login();
    }
}