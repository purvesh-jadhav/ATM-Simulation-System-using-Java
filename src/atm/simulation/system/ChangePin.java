package atm.simulation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePin extends JFrame implements ActionListener {

    JButton buttonChangePin, buttonBack;
    JPasswordField passwordFieldPin, passwordFieldRePin;
    String cardNo;

    public ChangePin(String cardNo) {
        this.cardNo = cardNo;

        // ATM Background Image
        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("project_images and sounds/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(0, 0, 1550, 830);
        add(background);

        // Title
        JLabel title = new JLabel("CHANGE YOUR PIN");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setBounds(525, 180, 400, 35);
        background.add(title);

        // New PIN
        JLabel lblNewPin = new JLabel("New PIN");
        lblNewPin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNewPin.setForeground(Color.WHITE);
        lblNewPin.setBounds(430, 220, 200, 35);
        background.add(lblNewPin);

        passwordFieldPin = new JPasswordField();
        passwordFieldPin.setBounds(430, 260, 200, 35);
        passwordFieldPin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        passwordFieldPin.setBackground(new Color(9, 125, 131));
        passwordFieldPin.setForeground(Color.WHITE);
        background.add(passwordFieldPin);

        // Re-enter PIN
        JLabel lblRePin = new JLabel("Re-Enter New PIN");
        lblRePin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblRePin.setForeground(Color.WHITE);
        lblRePin.setBounds(430, 300, 200, 35);
        background.add(lblRePin);

        passwordFieldRePin = new JPasswordField();
        passwordFieldRePin.setBounds(430, 340, 200, 35);
        passwordFieldRePin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        passwordFieldRePin.setBackground(new Color(9, 125, 131));
        passwordFieldRePin.setForeground(Color.WHITE);
        background.add(passwordFieldRePin);

        // Change Button
        buttonChangePin = new JButton("CHANGE");
        buttonChangePin.setBounds(700, 362, 150, 35);
        buttonChangePin.setBackground(new Color(9, 125, 131));
        buttonChangePin.setForeground(Color.WHITE);
        buttonChangePin.addActionListener(this);
        background.add(buttonChangePin);

        // Back Button
        buttonBack = new JButton("BACK");
        buttonBack.setBounds(700, 406, 150, 35);
        buttonBack.setBackground(new Color(9, 125, 131));
        buttonBack.setForeground(Color.WHITE);
        buttonBack.addActionListener(this);
        background.add(buttonBack);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SoundPlayer.play();

        if (e.getSource() == buttonChangePin) {

            String pin1 = new String(passwordFieldPin.getPassword());
            String pin2 = new String(passwordFieldRePin.getPassword());

            if (pin1.isEmpty() || pin2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "PIN fields cannot be empty");
                return;
            }

            if (!pin1.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits");
                return;
            }

            if (!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            try {
                Con c = new Con();
                String query =
                        "UPDATE login SET pin='" + pin1 + "' WHERE card_no='" + cardNo + "'";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "PIN changed successfully!");
                setVisible(false);
                new Main(cardNo);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == buttonBack) {
            setVisible(false);
            new Main(cardNo);
        }
    }

    public static void main(String[] args) {
        new ChangePin("");
    }
}
