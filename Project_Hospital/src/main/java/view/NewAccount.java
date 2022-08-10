package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewAccount extends JFrame{
    private JTextField numeTextField;
    private JTextField prenumetextField;
    private JPasswordField passwordField;
    private JTextField usernametextField;
    private JTextField nrTeltextField;
    private JTextField emailtextField;

    private  JButton createButton;


    public NewAccount(){
        this.setBounds(100, 100, 961, 586);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Creare cont nou");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(342, 10, 265, 26);
        this.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nume");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(78, 68, 121, 31);
        this.getContentPane().add(lblNewLabel_1);

        numeTextField = new JTextField();
        numeTextField.setBounds(191, 74, 176, 26);
        this.getContentPane().add(numeTextField);
        numeTextField.setColumns(10);

        createButton = new JButton("Create");
        createButton.setBackground(Color.CYAN);
        createButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        createButton.setBounds(342, 440, 201, 43);
        this.getContentPane().add(createButton);

        JLabel lblNewLabel_1_1 = new JLabel("Preume");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_1.setBounds(78, 121, 121, 31);
        this.getContentPane().add(lblNewLabel_1_1);

        prenumetextField = new JTextField();
        prenumetextField.setColumns(10);
        prenumetextField.setBounds(191, 127, 176, 26);
        this.getContentPane().add(prenumetextField);

        JLabel lblNewLabel_1_2 = new JLabel("Username");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_2.setBounds(78, 179, 121, 31);
        this.getContentPane().add(lblNewLabel_1_2);

        passwordField = new JPasswordField();
        passwordField.setBounds(191, 229, 176, 26);
        this.getContentPane().add(passwordField);

        usernametextField = new JTextField();
        usernametextField.setColumns(10);
        usernametextField.setBounds(191, 188, 176, 26);
        this.getContentPane().add(usernametextField);

        JLabel lblNewLabel_1_3 = new JLabel("Parola");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_3.setBounds(78, 223, 121, 31);
        this.getContentPane().add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_3_1 = new JLabel("Nr. tel");
        lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_3_1.setBounds(78, 287, 121, 31);
        this.getContentPane().add(lblNewLabel_1_3_1);

        nrTeltextField = new JTextField();
        nrTeltextField.setColumns(10);
        nrTeltextField.setBounds(191, 292, 176, 26);
        this.getContentPane().add(nrTeltextField);

        JLabel lblNewLabel_1_3_1_1 = new JLabel("Email");
        lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_3_1_1.setBounds(78, 343, 121, 31);
        this.getContentPane().add(lblNewLabel_1_3_1_1);

        emailtextField = new JTextField();
        emailtextField.setColumns(10);
        emailtextField.setBounds(191, 349, 176, 26);
        this.getContentPane().add(emailtextField);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("D:\\Proiecte_Java\\Project_Hospital\\cont_nou.png"));
        lblNewLabel_2.setBounds(536, 52, 385, 438);
        this.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Parola va avea o lungime minima de 3 caractere si va contine cel putin o litera mare, o cifra");
        lblNewLabel_3.setForeground(Color.RED);
        lblNewLabel_3.setBounds(10, 252, 433, 31);
        this.getContentPane().add(lblNewLabel_3);
    }
    public  void deschideFereastra(){
        this.setVisible(true);
    }
    public  void inchideFereastra(){
        this.setVisible(false);
    }

    public void logareListenner( ActionListener action){
        createButton.addActionListener(action);
    }
    public  void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
        refresh();
    }
    //seteaza tot pe null, goleste casutele
    public  void showMessage2(String message){
        JOptionPane.showMessageDialog(this, message);
        passwordField.setText(null);

    }
    public void refresh(){
        numeTextField.setText(null);
        prenumetextField.setText(null);
        passwordField.setText(null);
        usernametextField.setText(null);
        nrTeltextField.setText(null);
        emailtextField.setText(null);
    }


    public String getNumeTextField() {
        return numeTextField.getText();
    }

    public void setNumeTextField(String numeTextField) {
        this.numeTextField.setText(numeTextField);
    }

    public String getPrenumetextField() {
        return prenumetextField.getText();
    }

    public void setPrenumetextField(String prenumetextField) {
        this.prenumetextField.setText(prenumetextField);
    }

    public String getPasswordField() {
        return new String(passwordField.getPassword());
    }


    public String getUsernametextField() {
        return usernametextField.getText();
    }

    public void setUsernametextField(String usernametextField) {
        this.usernametextField.setText(usernametextField);
    }

    public String  getNrTeltextField() {
        return nrTeltextField.getText();
    }

    public void setNrTeltextField(String nrTeltextField) {
        this.nrTeltextField.setText(nrTeltextField);
    }

    public String getEmailtextField() {
        return emailtextField.getText();
    }

    public void setEmailtextField(String  emailtextField) {
        this.emailtextField.setText(emailtextField);
    }
}
