package atm.simulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupTwo extends JFrame implements ActionListener {

    JComboBox comboBox_religion , comboBox_category , comboBox_income , comboBox_qualification;
    JComboBox comboBox_occupation;
    JTextField textField_panno , textField_aadharno;
    JRadioButton ButtonYes,ButtonNo;
    JRadioButton ButtonYes2,ButtonNo2;
    JButton button_next;

    String formno;
    SignupTwo(String first)
    {


        super("APPLICATION FORM : PAGE 2");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("project_images and sounds/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon i3= new ImageIcon(i2);
        JLabel bank_image =new JLabel(i3);
        bank_image.setBounds(25,10,100,100);
        add(bank_image);

        this.formno=first;

        JLabel label_appno= new JLabel("APPLICATION FORM NO: "+ first);
        label_appno.setBounds(180,20,600,40);
        label_appno.setFont(new Font("Sezgoe UI",Font.TYPE1_FONT,35));
        add(label_appno);


        JLabel label_page2= new JLabel("Page 2/3");
        label_page2.setFont(new Font("Segoe UI",Font.LAYOUT_NO_LIMIT_CONTEXT,22));
        label_page2.setBounds(382,70,600,30);
        add(label_page2);

        JLabel label_additionaldet=new JLabel("Additional Details :");
        label_additionaldet.setFont(new Font("Segoe UI",Font.ITALIC,26));
        label_additionaldet.setBounds(340,115,600,35);
        add(label_additionaldet);

        JLabel label_religion = new JLabel("Religion :");
        label_religion.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_religion.setBounds(100,190,100,30);
        add(label_religion);

        String religion[]={"Hindu","Muslim","Sikh","Cristian","Other"};
        comboBox_religion = new JComboBox(religion);
        comboBox_religion.setBackground(new Color(189,221,252));
        comboBox_religion.setFont(new Font("Segoe UI",Font.PLAIN,16));
        comboBox_religion.setBounds(300,193,400,30);
        add(comboBox_religion);

        JLabel label_category = new JLabel("Category :");
        label_category.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_category.setBounds(100,240,200,30);
        add(label_category);

        String category[]={"General","OBC","SC","ST","Other"};
        comboBox_category = new JComboBox(category);
        comboBox_category.setBackground(new Color(189,221,252));
        comboBox_category.setFont(new Font("Segoe UI",Font.PLAIN,16));
        comboBox_category.setBounds(300,243,400,30);
        add(comboBox_category);

        JLabel label_income = new JLabel("Income :");
        label_income.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_income.setBounds(100,290,200,30);
        add(label_income);

        String income[]={"No Income","<₹1,50,000","<₹2,50,000","<₹5,00,000","Upto ₹10,00,000","Above 10,00,000"};
        comboBox_income = new JComboBox(income);
        comboBox_income.setBackground(new Color(189,221,252));
        comboBox_income.setFont(new Font("Segoe UI",Font.PLAIN,16));
        comboBox_income.setBounds(300,293,400,30);
        add(comboBox_income);

        JLabel label_qualification = new JLabel("Qualification :");
        label_qualification.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_qualification.setBounds(100,340,200,30);
        add(label_qualification);

        String qualification[]={"SSC(10th Pass)","HSC(12th Pass)","ITI","Diploma","Graduate","Post Graduate","Doctorate(PhD)"};
        comboBox_qualification = new JComboBox(qualification);
        comboBox_qualification.setBackground(new Color(189,221,252));
        comboBox_qualification.setFont(new Font("Segoe UI",Font.PLAIN,16));
        comboBox_qualification.setBounds(300,343,400,30);
        add(comboBox_qualification);

        JLabel label_occupation = new JLabel("Occupation :");
        label_occupation.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_occupation.setBounds(100,390,200,30);
        add(label_occupation);

        String occupation[]={"Salaried","Self-Employee","Business Owner","Student","Retired / Pensioner","Others"};
        comboBox_occupation = new JComboBox(occupation);
        comboBox_occupation.setBackground(new Color(189,221,252));
        comboBox_occupation.setFont(new Font("Segoe UI",Font.PLAIN,16));
        comboBox_occupation.setBounds(300,393,400,30);
        add(comboBox_occupation);

        JLabel label_panno = new JLabel("PAN No :");
        label_panno.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_panno.setBounds(100,440,200,30);
        add(label_panno);

        textField_panno = new JTextField();
        textField_panno.setFont(new Font("Segoe UI",Font.PLAIN,16));
        textField_panno.setBounds(300,443,400,30);
        add(textField_panno);

        JLabel label_aadharno = new JLabel("Aadhar No :");
        label_aadharno.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_aadharno.setBounds(100,490,200,30);
        add(label_aadharno);

        textField_aadharno = new JTextField();
        textField_aadharno.setFont(new Font("Segoe UI",Font.PLAIN,16));
        textField_aadharno.setBounds(300,493,400,30);
        add(textField_aadharno);

        JLabel label_isSenior = new JLabel("Is Senior Citizen ? :");
        label_isSenior.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_isSenior.setBounds(100,540,200,30);
        add(label_isSenior);

        ButtonYes = new JRadioButton("Yes");
        ButtonYes.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonYes.setBackground(new Color(189, 221, 252));
//        ButtonYes.setBounds(350,500,100,30);
        ButtonYes.setBounds(300,543,100,30);
        ButtonYes.setFocusPainted(false);
        add(ButtonYes);

        ButtonNo = new JRadioButton("No");
        ButtonNo.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonNo.setBackground(new Color(189, 221, 252));
        ButtonNo.setBounds(460,543,100,30);
        ButtonNo.setFocusPainted(false);
        add(ButtonNo);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(ButtonYes);
        buttonGroup.add(ButtonNo);


        JLabel label_existac = new JLabel("Existing Account ? :");
        label_existac.setFont(new Font("Segoe UI",Font.TYPE1_FONT,20));
        label_existac.setBounds(100,590,200,30);
        add(label_existac);

        ButtonYes2 = new JRadioButton("Yes");
        ButtonYes2.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonYes2.setBackground(new Color(189, 221, 252));
        ButtonYes2.setBounds(300,593,100,30);
        ButtonYes2.setFocusPainted(false);
        add(ButtonYes2);

        ButtonNo2 = new JRadioButton("No");
        ButtonNo2.setFont(new Font("Segoe UI",Font.PLAIN,17));
        ButtonNo2.setBackground(new Color(189, 221, 252));
        ButtonNo2.setBounds(460,593,100,30);
        ButtonNo2.setFocusPainted(false);
        add(ButtonNo2);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(ButtonYes2);
        buttonGroup2.add(ButtonNo2);

        button_next = new JButton("Next");
        button_next.setFont(new Font("Segoe UI",Font.PLAIN,14));
        button_next.setBackground(new Color (0, 64, 128));
        button_next.setForeground(Color.WHITE);
        button_next.setFocusPainted(false);
        button_next.setBounds(620,700,80,30);
        button_next.addActionListener(this);
        add(button_next);


        setLayout(null);
        setSize(850,800);
        setLocation(360,18);
        getContentPane().setBackground(new Color(189, 221, 252));
        setVisible(true);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String)comboBox_religion.getSelectedItem();
        String category = (String)comboBox_category.getSelectedItem();
        String income = (String)comboBox_income.getSelectedItem();
        String qualification=(String)comboBox_qualification.getSelectedItem();
        String occupation =(String)comboBox_occupation.getSelectedItem();
        String pan_no=textField_panno.getText();
        String aadhar_no=textField_aadharno.getText();
        String senior_citizen=null;
        if(ButtonYes.isSelected())
        {
            senior_citizen="Yes";
        }
        else if(ButtonNo.isSelected()){
            senior_citizen="No";
        }

        String existing_account=null;
        if(ButtonYes2.isSelected())
        {
            existing_account="Yes";
        }
        else if(ButtonNo2.isSelected()){
            existing_account="No";
        }

        try
        {
            if(textField_panno.getText().equals("") || textField_aadharno.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter all fields..");
            }

            else{

                Con c1= new Con();
                String q = "INSERT INTO Customer_Additional_Deatils VALUES ('"+formno+"' , '"+religion+"' ,'"+category+"' , '"+income+"' , '"+qualification+"' , '"+occupation+"' ,'"+pan_no+"' , '"+aadhar_no+"' ,'"+senior_citizen+"' , '"+existing_account+"')";
                c1.statement.executeUpdate(q);
                new SignupThree(formno);
                setVisible(false);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    static void main(String[] args) {
        new SignupTwo("");
    }

}
