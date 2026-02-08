package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    String card_no;
    TextField textfield_amount;
    JButton button_withdrawl;
    JButton button_back;

    Withdrawl(String card_no)
    {

        this.card_no=card_no;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("project_images and sounds/atm2.png"));
        Image i2 =i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,1550,830);
        add(i4);

        JLabel label_title= new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAWL");
        label_title.setFont(new Font("Sogoe UI",Font.BOLD,16));
        label_title.setForeground(Color.WHITE);
        label_title.setBounds(450,180,400,35);
        i4.add(label_title);

        textfield_amount = new TextField();
        textfield_amount.setBounds(460,230,320,25);
        textfield_amount.setFont(new Font("Sogoe UI",Font.BOLD,16));
        textfield_amount.setBackground(new Color(9, 125, 131));
        textfield_amount.setForeground(Color.WHITE);
        i4.add(textfield_amount);

        button_withdrawl = new JButton("WITHDRAW");
        button_withdrawl.setBounds(700,362,150,35);
        button_withdrawl.setBackground(new Color (9, 125, 131));
        button_withdrawl.setForeground(Color.WHITE);
        button_withdrawl.setFocusPainted(false);
        button_withdrawl.addActionListener(this);
        i4.add(button_withdrawl);

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
            if (e.getSource() == button_withdrawl) {

                String withdrawl_amount = textfield_amount.getText();

                if (withdrawl_amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount");
                    return;
                }

                int withdrawAmount = Integer.parseInt(withdrawl_amount);
                Date date = new Date();

                Con c = new Con();
                ResultSet rs = c.statement.executeQuery(
                        "SELECT * FROM transactions WHERE card_no = '" + card_no + "'"
                );

                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (balance < withdrawAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }


                c.statement.executeUpdate(
                        "INSERT INTO transactions VALUES('" + card_no + "','" + date + "','Withdraw','" + withdrawAmount + "')"
                );


                button_withdrawl.setEnabled(false);
                button_back.setEnabled(false);


                new Thread(() -> {
                    SoundPlayer3.play();

                    try {
                        Thread.sleep(6400); // sound duration
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(null,
                                "₹. " + withdrawAmount + " Withdrawn Successfully " +
                                        "Please collect your cash");

                        setVisible(false);
                        new Main(card_no);
                    });
                }).start();
            }


            else if (e.getSource() == button_back) {
                setVisible(false);
                new Main(card_no);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    static void main(String[] args) {
        new Withdrawl("");
    }
}
