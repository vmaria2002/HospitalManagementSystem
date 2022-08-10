package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;



public class LogIn extends JFrame {
    private JTextField userNametextField;
    private JPasswordField parolatextField;

    private  JButton logareButton;
    private  JButton btnNewButton;
    public LogIn(){
        this.setBounds(100, 100, 970, 544);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Logare in aplicatie");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(364, 35, 389, 42);
        this.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(47, 123, 137, 36);
        this.getContentPane().add(lblNewLabel_1);

        userNametextField = new JTextField();
        userNametextField.setBounds(153, 126, 225, 27);
        this.getContentPane().add(userNametextField);
        userNametextField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Parola");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(47, 178, 137, 36);
        this.getContentPane().add(lblNewLabel_1_1);

        parolatextField = new JPasswordField();
        parolatextField.setColumns(10);
        parolatextField.setBounds(153, 181, 225, 27);
        this.getContentPane().add(parolatextField);

        logareButton = new JButton("Logare");
        logareButton.setBackground(new Color(0, 255, 0));
        logareButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        logareButton.setBounds(185, 257, 130, 27);
        this.getContentPane().add(logareButton);

        JLabel lblNewLabel_2 = new JLabel("Nu aveti cont?");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblNewLabel_2.setForeground(Color.BLUE);
        lblNewLabel_2.setBounds(546, 126, 233, 27);
        this.getContentPane().add(lblNewLabel_2);

        btnNewButton = new JButton("Cont nou");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnNewButton.setForeground(Color.black);
        btnNewButton.setBackground(Color.BLUE);
        btnNewButton.setBounds(535, 169, 154, 42);
        this.getContentPane().add(btnNewButton);
    }

    public  void deschideFereastra(){
        this.setVisible(true);
    }
    public  void inchideFereastra(){
        this.setVisible(false);
    }

    public void logareListenner( ActionListener action){
        logareButton.addActionListener(action);
    }
    public void newAccountListenner( ActionListener action){
        btnNewButton.addActionListener(action);
    }
    public  void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
        refresh();
    }
    //seteaza tot pe null, goleste casutele

    public void refresh(){
        userNametextField.setText(null);
        parolatextField.setText(null);
    }

    public String getUserNametextField() {
        return userNametextField.getText();
    }

    public void setUserNametextField(String userNametextField) {
        this.userNametextField.setText(userNametextField);
    }

    public String getParolatextField() {
        return new String(parolatextField.getPassword());
    }

}
