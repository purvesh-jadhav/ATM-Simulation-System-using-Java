package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JButton button_deposit,button_cashwithdrawl,button_fastcash,button_ministat,button_pinchange,button_balanceenqueiry,button_exit;
    String card_no;

    Main(String cardno)
    {

        this.card_no=cardno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("project_images and sounds/atm2.png"));
        Image i2 =i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,1550,830);
        add(i4);

        JLabel label_select = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        label_select.setForeground(Color.WHITE);
        label_select.setFont(new Font("Sogoe UI",Font.BOLD,18));
        label_select.setBounds(450,180,700,35);
        i4.add(label_select);

        button_deposit = new JButton("DEPOSIT");
        button_deposit.setBackground(new Color (9, 125, 131));
        button_deposit.setForeground(Color.WHITE);
        button_deposit.setFocusPainted(false);
        button_deposit.setBounds(420,270,150,35);
        button_deposit.addActionListener(this);
        i4.add(button_deposit);

        button_cashwithdrawl= new JButton("CASH WITHDRAWL");
        button_cashwithdrawl.setBackground(new Color (9, 125, 131));
        button_cashwithdrawl.setForeground(Color.WHITE);
        button_cashwithdrawl.setFocusPainted(false);
        button_cashwithdrawl.setBounds(685,270,150,35);
        button_cashwithdrawl.addActionListener(this);
        i4.add(button_cashwithdrawl);

        button_fastcash= new JButton("FAST CASH");
        button_fastcash.setBackground(new Color (9, 125, 131));
        button_fastcash.setForeground(Color.WHITE);
        button_fastcash.setFocusPainted(false);
        button_fastcash.setBounds(420,318,150,35);
        button_fastcash.addActionListener(this);
        i4.add(button_fastcash);

        button_ministat= new JButton("MINI STATEMENT");
        button_ministat.setBackground(new Color (9, 125, 131));
        button_ministat.setForeground(Color.WHITE);
        button_ministat.setFocusPainted(false);
        button_ministat.setBounds(685,318,150,35);
        button_ministat.addActionListener(this);
        i4.add(button_ministat);

        button_pinchange= new JButton("PIN CHANGE");
        button_pinchange.setBackground(new Color (9, 125, 131));
        button_pinchange.setForeground(Color.WHITE);
        button_pinchange.setFocusPainted(false);
        button_pinchange.setBounds(420,366,150,35);
        button_pinchange.addActionListener(this);
        i4.add(button_pinchange);

        button_balanceenqueiry= new JButton("BALANCE ENQUIRY");
        button_balanceenqueiry.setBackground(new Color (9, 125, 131));
        button_balanceenqueiry.setForeground(Color.WHITE);
        button_balanceenqueiry.setFocusPainted(false);
        button_balanceenqueiry.setBounds(685,366,150,35);
        button_balanceenqueiry.addActionListener(this);
        i4.add(button_balanceenqueiry);

        button_exit= new JButton("EXIT");
        button_exit.setBackground(new Color (9, 125, 131));
        button_exit.setForeground(Color.WHITE);
        button_exit.setFocusPainted(false);
        button_exit.setBounds(685,414,150,35);
        button_exit.addActionListener(this);
        i4.add(button_exit);


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        SoundPlayer.play();

        if(e.getSource()==button_deposit)
        {
            new Deposit(card_no);
            setVisible(false);
        }
        else if(e.getSource()==button_cashwithdrawl)
        {
            new Withdrawl(card_no);
            setVisible(false);
        } else if (e.getSource()==button_balanceenqueiry)
        {
            new BalanceEnquiry(card_no);
            setVisible(false);

        } else if (e.getSource()==button_fastcash) {
            new FastCash(card_no);

        }
        else if(e.getSource()==button_pinchange)
        {
            new ChangePin(card_no);
        }
        else if (e.getSource() == button_ministat)
        {
            // 🧾 receipt printing sound
            SoundPlayer2.play();

            // ⏳ delay + window open (without freezing UI)
            new Thread(() -> {
                try {
                    Thread.sleep(2600); // 2 seconds delay

                    SwingUtilities.invokeLater(() -> {
                        new MiniStatement(card_no);
                    });

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }).start();
        }

        else if (e.getSource()==button_exit)
        {
            System.exit(0);
        }
    }

    static void main(String[] args) {
        new Main("");
    }
}
