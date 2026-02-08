package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {


    JButton button_rs100,button_rs500,button_rs1000,button_rs2000,button_rs5000,button_rs10000,button_back;

    String card_no;

    FastCash(String card_no)
    {
        this.card_no = card_no;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("project_images and sounds/atm2.png"));
        Image i2 =i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,1550,830);
        add(i4);

        JLabel label_select = new JLabel("PLEASE SELECT WITHDRAWL AMOUNT");
        label_select.setForeground(Color.WHITE);
        label_select.setFont(new Font("Sogoe UI",Font.BOLD,18));
        label_select.setBounds(450,180,700,35);
        i4.add(label_select);

        button_rs100 = new JButton("₹ 100");
        button_rs100.setBackground(new Color (9, 125, 131));
        button_rs100.setForeground(Color.WHITE);
        button_rs100.setFont(new Font("Sogoe UI",Font.BOLD,18));
        button_rs100.setFocusPainted(false);
        button_rs100.setBounds(420,270,150,35);
        button_rs100.addActionListener(this);
        i4.add(button_rs100);

        button_rs500= new JButton("₹ 500");
        button_rs500.setBackground(new Color (9, 125, 131));
        button_rs500.setForeground(Color.WHITE);
        button_rs500.setFont(new Font("Sogoe UI",Font.BOLD,18));
        button_rs500.setFocusPainted(false);
        button_rs500.setBounds(685,270,150,35);
        button_rs500.addActionListener(this);
        i4.add(button_rs500);

        button_rs1000= new JButton("₹ 1000");
        button_rs1000.setBackground(new Color (9, 125, 131));
        button_rs1000.setForeground(Color.WHITE);
        button_rs1000.setFont(new Font("Sogoe UI",Font.BOLD,18));
        button_rs1000.setFocusPainted(false);
        button_rs1000.setBounds(420,318,150,35);
        button_rs1000.addActionListener(this);
        i4.add(button_rs1000);

        button_rs2000= new JButton("₹ 2000");
        button_rs2000.setBackground(new Color (9, 125, 131));
        button_rs2000.setForeground(Color.WHITE);
        button_rs2000.setFont(new Font("Sogoe UI",Font.BOLD,18));
        button_rs2000.setFocusPainted(false);
        button_rs2000.setBounds(685,318,150,35);
        button_rs2000.addActionListener(this);
        i4.add(button_rs2000);

        button_rs5000= new JButton("₹ 5000");
        button_rs5000.setBackground(new Color (9, 125, 131));
        button_rs5000.setForeground(Color.WHITE);
        button_rs5000.setFont(new Font("Sogoe UI",Font.BOLD,18));
        button_rs5000.setFocusPainted(false);
        button_rs5000.setBounds(420,366,150,35);
        button_rs5000.addActionListener(this);
        i4.add(button_rs5000);

        button_rs10000= new JButton("₹ 10000");
        button_rs10000.setBackground(new Color (9, 125, 131));
        button_rs10000.setForeground(Color.WHITE);
        button_rs10000.setFont(new Font("Sogoe UI",Font.BOLD,18));
        button_rs10000.setFocusPainted(false);
        button_rs10000.setBounds(685,366,150,35);
        button_rs10000.addActionListener(this);
        i4.add(button_rs10000);

        button_back= new JButton("BACK");
        button_back.setBackground(new Color (9, 125, 131));
        button_back.setForeground(Color.WHITE);
        button_back.setFocusPainted(false);
        button_back.setBounds(685,414,150,35);
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

        if (e.getSource() == button_back) {
            setVisible(false);
            new Main(card_no);
            return;
        }


        String amount = ((JButton) e.getSource()).getText().substring(2);
        int withdrawAmount = Integer.parseInt(amount);

        try {
            Con c = new Con();
            Date date = new Date();

            ResultSet rs = c.statement.executeQuery(
                    "SELECT * FROM Transactions WHERE card_no = '" + card_no + "'"
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
                    "INSERT INTO Transactions VALUES ('" + card_no + "','" + date + "','Withdraw','" + withdrawAmount + "')"
            );


            button_rs100.setEnabled(false);
            button_rs500.setEnabled(false);
            button_rs1000.setEnabled(false);
            button_rs2000.setEnabled(false);
            button_rs5000.setEnabled(false);
            button_rs10000.setEnabled(false);
            button_back.setEnabled(false);


            new Thread(() -> {
                SoundPlayer3.play(); // cash withdraw sound

                try {
                    Thread.sleep(6000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(
                            null,
                            "Please collect your cash\n₹ " + withdrawAmount
                    );

                    setVisible(false);
                    new Main(card_no);
                });
            }).start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void main(String[] args) {
        new FastCash("");
    }
}
