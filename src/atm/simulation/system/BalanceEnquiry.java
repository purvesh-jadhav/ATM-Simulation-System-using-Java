package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry  extends JFrame implements ActionListener {

    String card_no;
    JLabel label_totalamount;
    Button button_back;
    BalanceEnquiry(String card_no)
    {

        this.card_no = card_no;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("project_images and sounds/atm2.png"));
        Image i2 =i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,1550,830);
        add(i4);

        JLabel label_title= new JLabel("YOUR CURRENT BALANCE IS Rs. :");
        label_title.setFont(new Font("Sogoe UI",Font.BOLD,16));
        label_title.setForeground(Color.WHITE);
        label_title.setBounds(450,180,400,35);
        i4.add(label_title);

        JLabel label_totalamount= new JLabel();
        label_totalamount.setFont(new Font("Sogoe UI",Font.BOLD,16));
        label_totalamount.setForeground(Color.GREEN);
        label_totalamount.setBounds(450,220,400,35);
        i4.add(label_totalamount);

        button_back = new Button("BACK");
        button_back.setBounds(700,406,150,35);
        button_back.setBackground(new Color (9, 125, 131));
        button_back.setForeground(Color.WHITE);
        button_back.setFocusable(false);
        button_back.addActionListener(this);
        i4.add(button_back);


        int balance =0;
        try
        {
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM Transactions WHERE card_no = '"+card_no+"'");
            while (resultSet.next())
            {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        label_totalamount.setText("₹ "+balance);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SoundPlayer.play();

        setVisible(false);
        new Main(card_no);

    }

    static void main(String[] args) {

        new BalanceEnquiry("");
    }
}
