package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {


    JRadioButton ButtonAT1,ButtonAT2,ButtonAT3,ButtonAT4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton button_submit,button_cancel;

    String formno;

    SignupThree(String first)
    {

        super("APPLICATION FORM : PAGE 3");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("project_images and sounds/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon i3= new ImageIcon(i2);
        JLabel bank_image =new JLabel(i3);
        bank_image.setBounds(25,10,100,100);
        add(bank_image);
        this.formno=first;

        JLabel label_appno= new JLabel("APPLICATION FORM NO: "+ formno);
        label_appno.setBounds(180,20,600,40);
        label_appno.setFont(new Font("Sezgoe UI",Font.TYPE1_FONT,35));
        add(label_appno);

        JLabel label_pageno3 = new JLabel("Page 3/3");
        label_pageno3.setFont(new Font("Segoe UI",Font.LAYOUT_NO_LIMIT_CONTEXT,22));
        label_pageno3.setBounds(382,70,600,30);
        add(label_pageno3);

        JLabel label_accountdet = new JLabel("Account Details:");
        label_accountdet.setFont(new Font("Segoe UI",Font.ITALIC,26));
        label_accountdet.setBounds(340,115,600,35);
        add(label_accountdet);

        JLabel label_accounttype = new JLabel("Account Type :");
        label_accounttype.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_accounttype.setBounds(100,190,300,30);
        add(label_accounttype);

        ButtonAT1=new JRadioButton("Saving Account");
        ButtonAT1.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonAT1.setBackground(new Color(189, 221, 252));
        ButtonAT1.setBounds(100,230,150,30);
        ButtonAT1.setFocusPainted(false);
        add(ButtonAT1);

        ButtonAT2=new JRadioButton("Current Account");
        ButtonAT2.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonAT2.setBackground(new Color(189, 221, 252));
        ButtonAT2.setBounds(350,230,150,30);
        ButtonAT2.setFocusPainted(false);
        add(ButtonAT2);

        ButtonAT3=new JRadioButton("Fixed Deposit Account");
        ButtonAT3.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonAT3.setBackground(new Color(189, 221, 252));
        ButtonAT3.setBounds(100,270,250,30);
        ButtonAT3.setFocusPainted(false);
        add(ButtonAT3);

        ButtonAT4=new JRadioButton("Recurring Deposit Account");
        ButtonAT4.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonAT4.setBackground(new Color(189, 221, 252));
        ButtonAT4.setBounds(350,270,250,30);
        ButtonAT4.setFocusPainted(false);
        add(ButtonAT4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(ButtonAT1);
        buttonGroup.add(ButtonAT2);
        buttonGroup.add(ButtonAT3);
        buttonGroup.add(ButtonAT4);


        JLabel label_card = new JLabel("Card No :");
        label_card.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_card.setBounds(100,320,200,30);
        add(label_card);

        JLabel label_16digit = new JLabel("(Your 16-digit Card Number)");
        label_16digit.setFont(new Font("Segoe UI",Font.ITALIC,14));
        label_16digit.setBounds(100,350,200,20);
        add(label_16digit);

        JLabel label_cardno = new JLabel("XXXX-XXXX-XXXX-4841");
        label_cardno.setFont(new Font("Segoe UI",Font.TYPE1_FONT,18));
        label_cardno.setBounds(350,320,250,30);
        add(label_cardno);

        JLabel label_appear = new JLabel("(real ATM card number will be appear when you submit application) ");
        label_appear.setFont(new Font("Segoe UI",Font.ITALIC,14));
        label_appear.setBounds(350,350,550,20);
        add(label_appear);

        JLabel label_cardpinname = new JLabel("PIN :");
        label_cardpinname.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_cardpinname.setBounds(100,390,200,20);
        add(label_cardpinname);

        JLabel label_pinx = new JLabel("XXXX");
        label_pinx.setFont(new Font("Segoe UI",Font.TYPE1_FONT,18));
        label_pinx.setBounds(350,390,200,20);
        add(label_pinx);

        JLabel label_pin = new JLabel("(4-digit Password)");
        label_pin.setFont(new Font("Segoe UI",Font.ITALIC,14));
        label_pin.setBounds(100,415,200,20);
        add(label_pin);

        JLabel label_question = new JLabel("Services Required :");
        label_question.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_question.setBounds(100,460,200,25);
        add(label_question);

        c1=new JCheckBox("ATM Card");
        c1.setFont(new Font("Segoe UI",Font.PLAIN,17));
        c1.setBackground(new Color(189, 221, 252));
        c1.setBounds(100,500,200,30);
        c1.setFocusPainted(false);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Segoe UI",Font.PLAIN,17));
        c2.setBackground(new Color(189, 221, 252));
        c2.setBounds(350,500,200,30);
        c2.setFocusPainted(false);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Segoe UI",Font.PLAIN,17));
        c3.setBackground(new Color(189, 221, 252));
        c3.setBounds(100,550,200,30);
        c3.setFocusPainted(false);
        add(c3);

        c4=new JCheckBox("Email-Alerts");
        c4.setFont(new Font("Segoe UI",Font.PLAIN,17));
        c4.setBackground(new Color(189, 221, 252));
        c4.setBounds(350,550,200,30);
        c4.setFocusPainted(false);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Segoe UI",Font.PLAIN,17));
        c5.setBackground(new Color(189, 221, 252));
        c5.setBounds(100,600,200,30);
        c5.setFocusPainted(false);
        add(c5);

        c6=new JCheckBox("E-Statements");
        c6.setFont(new Font("Segoe UI",Font.PLAIN,17));
        c6.setBackground(new Color(189, 221, 252));
        c6.setBounds(350,600,200,30);
        c6.setFocusPainted(false);
        add(c6);

        JCheckBox c7 = new JCheckBox("I here by declares that the above entered details correct to the best of my knwoledge", true);
        c7.setFont(new Font("Segoe UI",Font.PLAIN,14));
        c7.setBackground(new Color(189, 221, 252));
        c7.setBounds(100,660,600,20);
        c7.setFocusPainted(false);
        add(c7);

        button_submit = new JButton("Submit");
        button_submit.setFont(new Font("Segoe UI",Font.PLAIN,14));
        button_submit.setBackground(new Color (0, 64, 128));
        button_submit.setForeground(Color.WHITE);
        button_submit.setFocusPainted(false);
        button_submit.setBounds(420,700,80,30);
        button_submit.addActionListener(this);
        add(button_submit);

        button_cancel = new JButton("Cancel");
        button_cancel.setFont(new Font("Segoe UI",Font.PLAIN,14));
        button_cancel.setBackground(new Color (0, 64, 128));
        button_cancel.setForeground(Color.WHITE);
        button_cancel.setFocusPainted(false);
        button_cancel.setBounds(250,700,80,30);
        button_cancel.addActionListener(this);
        add(button_cancel);


        setLayout(null);
        getContentPane().setBackground(new Color(189, 221, 252));
        setSize(850,800);
        setLocation(360,18);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String account_type=null;
        if(ButtonAT1.isSelected())
        {
            account_type="Saving Account";
        }
        else if (ButtonAT2.isSelected())
        {
            account_type="Current Account";
        }
        else if(ButtonAT3.isSelected())
        {
            account_type="Fixed Deposit Account";
        }
        else if(ButtonAT4.isSelected())
        {
            account_type="Recurring Deposit Account";
        }

        Random random = new Random();
        long first_seven = (random.nextLong() % 90000000L) + 4127807000000000L;
        String card_no = "" +Math.abs(first_seven);

        long first_4 = ( random.nextLong() % 9000L) +1000L;
        String pin =""+ Math.abs(first_4);

        String facilities = "";
        if(c1.isSelected())
        {
            facilities +="ATM CARD, ";
        }
        if(c2.isSelected())
        {
            facilities +="Internet Banking, ";
        }
        if(c3.isSelected())
        {
            facilities +="Mobile Banking, ";
        }
        if(c4.isSelected())
        {
            facilities +="Email-Alert, ";
        }
        if(c5.isSelected())
        {
            facilities +="Cheque Book, ";
        }
        if(c6.isSelected())
        {
            facilities +="E-Statement, ";
        }

        try{

            if(e.getSource()==button_submit)
            {
                if (account_type == null) {
                    JOptionPane.showMessageDialog(null, "Please select account type");
                    return;
                }

                else {

                    Con c1 = new Con();
                    String query1 = "INSERT INTO Customer_Account_Deatils VALUES ('"+formno+"' , '"+account_type+"' , '"+facilities+"')";
                    String query2= "INSERT INTO login VALUES ('"+formno+"' , '"+card_no+"' , '"+pin+"')";
                    c1.statement.executeUpdate(query1);
                    c1.statement.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card No : "+card_no+"\n Pin :"+pin);
                    new Deposit(card_no);
                    setVisible(false);
                }
            }

            else if (e.getSource()==button_cancel)
            {
                System.exit(0);
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    static void main(String[] args) {
        new SignupThree("");
    }
}
