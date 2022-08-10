package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartDoctor extends JFrame {
    private JTextField numeTextField;
    private JTextField prenumeTextField_1;
    private JTextField tratamenttextField;
    private JTextField diagnostictextField;

    private JButton istoricPacientButton;
    private JButton externatiButton;
    private JButton consultatiButton;
    private JButton pacientNouButto;
    private JButton tratamentButton_1;
    private JButton backButton;
    private JTextField pretTextField;


    public StartDoctor() {
        this.setBounds(100, 100, 891, 518);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("pret");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_1_1_1.setBounds(569, 327, 100, 21);
        this.getContentPane().add(lblNewLabel_1_1_1_1);

        pretTextField = new JTextField();
        pretTextField.setColumns(10);
        pretTextField.setBounds(636, 324, 156, 25);
        this.getContentPane().add(pretTextField);

        JLabel lblNewLabel = new JLabel("selectati optiunea dorita:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(247, 10, 366, 43);
        this.getContentPane().add(lblNewLabel);

        istoricPacientButton = new JButton("Istoricul Unui Pacient");
        istoricPacientButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        istoricPacientButton.setBounds(26, 195, 198, 36);
        this.getContentPane().add(istoricPacientButton);

        JLabel lblNewLabel_1 = new JLabel("Nume");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(303, 210, 68, 21);
        this.getContentPane().add(lblNewLabel_1);

        numeTextField = new JTextField();
        numeTextField.setBounds(397, 203, 156, 25);
        this.getContentPane().add(numeTextField);
        numeTextField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Prenume");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_1.setBounds(289, 259, 68, 21);
        this.getContentPane().add(lblNewLabel_1_1);

        prenumeTextField_1 = new JTextField();
        prenumeTextField_1.setColumns(10);
        prenumeTextField_1.setBounds(397, 260, 156, 25);
        this.getContentPane().add(prenumeTextField_1);

        externatiButton = new JButton("Externati Pacient");
        externatiButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        externatiButton.setBounds(26, 252, 198, 36);
        this.getContentPane().add(externatiButton);

        consultatiButton = new JButton("Consultati Pacient");
        consultatiButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        consultatiButton.setBounds(26, 313, 198, 36);
        this.getContentPane().add(consultatiButton);

        pacientNouButto = new JButton("Pacient nou");
        pacientNouButto.setFont(new Font("Tahoma", Font.PLAIN, 18));
        pacientNouButto.setBounds(26, 56, 198, 36);
        this.getContentPane().add(pacientNouButto);

        JLabel lblNewLabel_2_1 = new JLabel("Pentru optiunile de mai jos introduceti nume+prenume");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_2_1.setBounds(180, 93, 477, 92);
        this.getContentPane().add(lblNewLabel_2_1);

        tratamentButton_1 = new JButton("Tratament Pacient");
        tratamentButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tratamentButton_1.setBounds(26, 383, 198, 36);
        this.getContentPane().add(tratamentButton_1);

        tratamenttextField = new JTextField();
        tratamenttextField.setBounds(257, 394, 230, 25);
        this.getContentPane().add(tratamenttextField);
        tratamenttextField.setColumns(10);

        backButton = new JButton("Pagina Start");
        backButton.setBackground(Color.RED);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        backButton.setBounds(0, 0, 151, 36);
        this.getContentPane().add(backButton);

        JLabel lblNewLabel_1_1_1 = new JLabel("Diagnostic");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1_1_1.setBounds(285, 320, 100, 21);
        this.getContentPane().add(lblNewLabel_1_1_1);

        diagnostictextField = new JTextField();
        diagnostictextField.setColumns(10);
        diagnostictextField.setBounds(397, 324, 156, 25);
        this.getContentPane().add(diagnostictextField);


    }

    public  void deschideFereastra(){
        this.setVisible(true);
    }
    public  void inchideFereastra(){
        this.setVisible(false);
    }

    public  void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);

    }

    public void refresh() {
        numeTextField.setText(null);
        prenumeTextField_1.setText(null);
        tratamenttextField.setText(null);
    }
    //butoane
    public void istoricPacientListenner( ActionListener action){
        istoricPacientButton.addActionListener(action);
    }

    public void inapoiListenner( ActionListener action){
        backButton.addActionListener(action);
    }

    public void externatiPacientListenner( ActionListener action){
        externatiButton.addActionListener(action);
    }

    public void consultatiiPacientListenner( ActionListener action){
        consultatiButton.addActionListener(action);
    }

    public void newPacientListenner( ActionListener action){
        pacientNouButto.addActionListener(action);
    }
    public void tratamentListenner( ActionListener action){
        tratamentButton_1.addActionListener(action);
    }



    public String getNumeTextField() {
        return numeTextField.getText();
    }

    public void setNumeTextField(String numeTextField) {
        this.numeTextField.setText(numeTextField);
    }

    public String getPrenumeTextField_1() {
        return prenumeTextField_1.getText();
    }

    public void setPrenumeTextField_1(String prenumeTextField_1) {
        this.prenumeTextField_1.setText(prenumeTextField_1);
    }

    public String getTratamenttextField() {
        return tratamenttextField.getText();
    }

    public void setTratamenttextField(String tratamenttextField) {
        this.tratamenttextField.setText(tratamenttextField);
    }

    public String getDiagnostictextField() {
        return diagnostictextField.getText();
    }

    public void setDiagnostictextField(String diagnostictextField) {
        this.diagnostictextField.setText(diagnostictextField);
    }

    public float getPretTextField() {
        return Float.parseFloat(pretTextField.getText());
    }

    public void setPretTextField(float pretTextField) {
        this.pretTextField.setText(String.valueOf(pretTextField));
    }
}
