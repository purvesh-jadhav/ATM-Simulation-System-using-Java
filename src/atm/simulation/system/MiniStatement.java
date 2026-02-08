package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    String card_no;
    JButton button_back;

    MiniStatement(String card_no) {

        this.card_no = card_no;

        setLayout(null);
        getContentPane().setBackground(new Color(213, 216, 214));
        setSize(400, 600);
        setLocation(925, 130);

        JLabel label_bank = new JLabel("BANK OF PUNE");
        label_bank.setBounds(120, 20, 200, 25);
        label_bank.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(label_bank);

        JLabel label_line = new JLabel("===================================================");
        label_line.setBounds(10, 45, 380, 20);
        add(label_line);

        JLabel label_card = new JLabel();
        label_card.setBounds(56, 75, 350, 20);
        label_card.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(label_card);

        //  SCROLLAblE STATEMENT
        JLabel label_statement = new JLabel();
        label_statement.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label_statement.setVerticalAlignment(SwingConstants.TOP);

        JScrollPane scrollPane = new JScrollPane(label_statement);
        scrollPane.setBounds(20, 110, 350, 300); // SAME BOUNDS
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        add(scrollPane);

        JLabel label_balance = new JLabel();
        label_balance.setBounds(20, 430, 350, 25);
        label_balance.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(label_balance);

        //  FETCH CARD NUMBER
        try {
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery(
                    "SELECT * FROM login WHERE card_no = '" + card_no + "'");

            if (rs.next()) {
                label_card.setText(
                        "Card No : " +
                                rs.getString("card_no").substring(0, 4) +
                                "XXXXXXXX" +
                                rs.getString("card_no").substring(12)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //  FEtCH TRANSACTIONS
        try {
            int balance = 0;
            Con c1 = new Con();
            ResultSet rs = c1.statement.executeQuery(
                    "SELECT * FROM Transactions WHERE card_no = '" + card_no + "' ORDER BY date DESC");

            StringBuilder data = new StringBuilder("<html>");

            while (rs.next()) {

                data.append(rs.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;₹")
                        .append(rs.getString("amount"))
                        .append("<br><br>");

                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            data.append("</html>");
            label_statement.setText(data.toString());
            label_balance.setText("Your total balance is ₹ " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        button_back = new JButton("BACK");
        button_back.setBounds(250, 500, 100, 30);
        button_back.setBackground(new Color(9, 125, 131));
        button_back.setForeground(Color.WHITE);
        button_back.setFocusPainted(false);
        button_back.addActionListener(this);
        add(button_back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
