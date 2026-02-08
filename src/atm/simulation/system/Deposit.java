package atm.simulation.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    String card_no;
    TextField textfield_amount;
    JButton button_deposit;
    JButton button_back;

    Deposit(String card_no)
    {
        this.card_no=card_no;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("project_images and sounds/atm2.png"));
        Image i2 =i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,1550,830);
        add(i4);

        JLabel label_title= new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label_title.setFont(new Font("Sogoe UI",Font.BOLD,16));
        label_title.setForeground(Color.WHITE);
        label_title.setBounds(460,180,400,35);
        i4.add(label_title);

        textfield_amount = new TextField();
        textfield_amount.setBounds(460,230,320,25);
        textfield_amount.setFont(new Font("Sogoe UI",Font.BOLD,16));
        textfield_amount.setBackground(new Color(9, 125, 131));
        textfield_amount.setForeground(Color.WHITE);
        i4.add(textfield_amount);

        button_deposit = new JButton("DEPOSIT");
        button_deposit.setBounds(700,362,150,35);
        button_deposit.setBackground(new Color (9, 125, 131));
        button_deposit.setForeground(Color.WHITE);
        button_deposit.setFocusPainted(false);
        button_deposit.addActionListener(this);
        i4.add(button_deposit);

        button_back = new JButton("BACK");
        button_back.setBounds(700,406,150,35);
        button_back.setBackground(new Color (9, 125, 131));
        button_back.setForeground(Color.WHITE);
        button_back.setFocusPainted(false);
        button_back.addActionListener(this);
        i4.add(button_back);


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SoundPlayer.play();

        try {
            String amount = textfield_amount.getText();
            Date date = new Date();
            if (e.getSource()==button_deposit)
            {
                if(textfield_amount.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter valid amount");
                }
                else {
                    Con c = new Con();
                    c.statement.executeUpdate("INSERT INTO Transactions VALUES ('"+card_no+"' , '"+date+"' , 'Deposit' , '"+amount+"')");
                    SoundPlayer4.play();
                    JOptionPane.showMessageDialog(null,"Rs."+amount+" deposited succesfully !!");
                    setVisible(false);
                    new Main(card_no);
                }
            }
            else if(e.getSource()==button_back)
            {
                setVisible(false);
                new Main(card_no);
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
