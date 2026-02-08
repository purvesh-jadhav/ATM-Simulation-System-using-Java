package atm.simulation.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton ButtonMale,ButtonFemale;
    JRadioButton ButtonMarried , ButtonUnmarried , ButtonOther;
    JButton button_next;

    JTextField textfield_name , textfield_Fname , textfield_email ;
    JTextField textfield_address , textfield_city , textfield_pin , textfield_state;
    JDateChooser dateChooser;


    Random ran =new Random();
    long firstfour =(ran.nextLong() %9000L) +1000L;
    String first=" " +Math.abs(firstfour);


    Signup()
    {
        super("APPLICATION FORM : PAGE 1");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("project_images and sounds/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon i3= new ImageIcon(i2);
        JLabel bank_image =new JLabel(i3);
        bank_image.setBounds(25,10,100,100);
        add(bank_image);

        JLabel label_appno= new JLabel("APPLICATION FORM NO: "+ first);
        label_appno.setBounds(180,20,600,40);
        label_appno.setFont(new Font("Sezgoe UI",Font.TYPE1_FONT,35));
        add(label_appno);

        JLabel label_pageno1 = new JLabel("Page 1/3");
        label_pageno1.setFont(new Font("Segoe UI",Font.LAYOUT_NO_LIMIT_CONTEXT,22));
        label_pageno1.setBounds(382,70,600,30);
        add(label_pageno1);

        JLabel label_personaldet = new JLabel("Personal Details:");
        label_personaldet.setFont(new Font("Segoe UI",Font.ITALIC,26));
        label_personaldet.setBounds(340,115,600,35);
        add(label_personaldet);

        JLabel label_name=new JLabel("Name :");
        label_name.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_name.setBounds(100,190,100,30);
        add(label_name);

        textfield_name = new JTextField();
        textfield_name.setFont(new Font("Segoe UI",Font.PLAIN,16));
        textfield_name.setBounds(300,193,400,30);
        add(textfield_name);

        JLabel label_Fname=new JLabel("Father's Name :");
        label_Fname.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_Fname.setBounds(100,240,200,30);
        add(label_Fname);

        textfield_Fname = new JTextField();
        textfield_Fname.setFont(new Font("Segoe UI",Font.PLAIN,16));
        textfield_Fname.setBounds(300,243,400,30);
        add(textfield_Fname);

        JLabel label_DOB=new JLabel("Date of Birth :");
        label_DOB.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_DOB.setBounds(100,290,200,30);
        add(label_DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,293,400,30);
        dateChooser.setFont(new Font("Segoe UI",Font.PLAIN,16));
        add(dateChooser);

        JLabel label_gender = new JLabel("Gender :");
        label_gender.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_gender.setBounds(100,340,200,30);
        add(label_gender);

        ButtonMale = new JRadioButton("Male");
        ButtonMale.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonMale.setBackground(new Color(189, 221, 252));
        ButtonMale.setBounds(300,343,90,30);
        ButtonMale.setFocusPainted(false);
        add(ButtonMale);

        ButtonFemale = new JRadioButton("Female");
        ButtonFemale.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonFemale.setBackground(new Color(189, 221, 252));
        ButtonFemale.setBounds(450,343,90,30);
        ButtonFemale.setFocusPainted(false);
        add(ButtonFemale);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(ButtonMale);
        buttonGroup.add(ButtonFemale);

        JLabel label_email =new JLabel( "Email Address :");
        label_email.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_email.setBounds(100,390,200,30);
        add(label_email);

        textfield_email = new JTextField();
        textfield_email.setFont(new Font("Segoe UI",Font.PLAIN,16));
        textfield_email.setBounds(300,393,400,30);
        add(textfield_email);

        JLabel label_maritalsta =new JLabel( "Marital Status :");
        label_maritalsta.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_maritalsta.setBounds(100,440,200,30);
        add(label_maritalsta);

        ButtonMarried = new JRadioButton("Married");
        ButtonMarried.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonMarried.setBackground(new Color(189, 221, 252));
        ButtonMarried.setBounds(300,443,90,30);
        ButtonMarried.setFocusPainted(false);
        add(ButtonMarried);

        ButtonUnmarried = new JRadioButton("Unmarried");
        ButtonUnmarried.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonUnmarried.setBackground(new Color(189, 221, 252));
        ButtonUnmarried.setBounds(450,443,120,30);
        ButtonUnmarried.setFocusPainted(false);
        add(ButtonUnmarried);

        ButtonOther = new JRadioButton("Other");
        ButtonOther.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonOther.setBackground(new Color(189, 221, 252));
        ButtonOther.setBounds(600,443,120,30);
        ButtonOther.setFocusPainted(false);
        add(ButtonOther);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(ButtonMarried);
        buttonGroup2.add(ButtonUnmarried);
        buttonGroup2.add(ButtonOther);

        JLabel label_address =new JLabel( "Permenant Address :");
        label_address.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_address.setBounds(100,490,200,30);
        add(label_address);

        textfield_address = new JTextField();
        textfield_address.setFont(new Font("Segoe UI",Font.PLAIN,16));
        textfield_address.setBounds(300,493,400,30);
        add(textfield_address);

        JLabel label_city =new JLabel( "City :");
        label_city.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_city.setBounds(100,540,200,30);
        add(label_city);

        textfield_city = new JTextField();
        textfield_city.setFont(new Font("Segoe UI",Font.PLAIN,16));
        textfield_city.setBounds(300,543,400,30);
        add(textfield_city);

        JLabel label_pin =new JLabel( "PIN Code :");
        label_pin.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_pin.setBounds(100,590,200,30);
        add(label_pin);

        textfield_pin = new JTextField();
        textfield_pin.setFont(new Font("Segoe UI",Font.PLAIN,16));
        textfield_pin.setBounds(300,593,400,30);
        add(textfield_pin);

        JLabel label_state =new JLabel( "State :");
        label_state.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_state.setBounds(100,640,200,30);
        add(label_state);

        textfield_state = new JTextField();
        textfield_state.setFont(new Font("Segoe UI",Font.PLAIN,16));
        textfield_state.setBounds(300,643,400,30);
        add(textfield_state);

        button_next = new JButton("Next");
        button_next.setFont(new Font("Segoe UI",Font.PLAIN,14));
        button_next.setBackground(new Color (0, 64, 128));
        button_next.setForeground(Color.WHITE);
        button_next.setFocusPainted(false);
        button_next.setBounds(620,700,80,30);
        button_next.addActionListener(this);
        add(button_next);

        setLayout(null);
        getContentPane().setBackground(new Color(189, 221, 252));
        setSize(850,800);
        setLocation(360,18);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name=textfield_name.getText();
        String fname=textfield_Fname.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(ButtonMale.isSelected())
        {
            gender="Male";
        }else if(ButtonFemale.isSelected())
        {
            gender="Female";
        }
        String email=textfield_email.getText();
        String marital =null;
        if(ButtonMarried.isSelected())
        {
            marital="Married";
        } else if (ButtonUnmarried.isSelected()) {
            marital="Unmarried";
        } else if (ButtonOther.isSelected()) {
            marital="Other";
        }

        String address=textfield_address.getText();
        String city= textfield_city.getText();
        String pincode= textfield_pin.getText();
        String state=textfield_state.getText();

        try
        {
            if(textfield_name.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name is Mandotory");
            }


            else {
                Con con1 = new Con();
                String q="INSERT INTO Customer_Personal_Deatils VALUES('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"' ,'"+gender+"','"+email+"', '"+marital+"', '"+address+"' , '"+city+"' , '"+pincode+"' , '"+state+"')";
                con1.statement.executeUpdate(q);
                new SignupTwo(first);
                setVisible(false);
            }
        }
        catch (Exception E1)
        {
            E1.printStackTrace();
        }


    }

    static void main(String[] args) {
        new Signup();
    }
}
