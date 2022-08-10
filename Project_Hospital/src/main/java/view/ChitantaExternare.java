package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChitantaExternare extends JFrame {
    private JTextField numetextField;
    private JTextField prenumetextField;
    private JTextField nrTeltextField;
    private JTextField dataExternariiTextField;
    private JTextField diagnoaticField;
    private JTextField tratamenttextField;
    private JTextField mediciConsultatiField;
    private JTextField prettextField;
    private JTextField emailtextField;

    private JButton startButton;

    public ChitantaExternare() {

        this.setBounds(100, 100, 855, 533);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Chitanta");
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(363, 28, 309, 29);
        this.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nume");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(39, 81, 110, 29);
        this.getContentPane().add(lblNewLabel_1);

        numetextField = new JTextField();
        numetextField.setBounds(173, 81, 177, 35);
        this.getContentPane().add(numetextField);
        numetextField.setColumns(10);

        JLabel prenumeLabel_ = new JLabel("Prenume");
        prenumeLabel_.setHorizontalAlignment(SwingConstants.TRAILING);
        prenumeLabel_.setFont(new Font("Tahoma", Font.PLAIN, 18));
        prenumeLabel_.setBounds(26, 138, 72, 29);
        this.getContentPane().add(prenumeLabel_);

        prenumetextField = new JTextField();
        prenumetextField.setColumns(10);
        prenumetextField.setBounds(173, 138, 177, 35);
        this.getContentPane().add(prenumetextField);

        JLabel prenumeLabel = new JLabel("nr. tel");
        prenumeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        prenumeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        prenumeLabel.setBounds(26, 193, 72, 29);
        this.getContentPane().add(prenumeLabel);

        nrTeltextField = new JTextField();
        nrTeltextField.setColumns(10);
        nrTeltextField.setBounds(173, 193, 177, 35);
        this.getContentPane().add(nrTeltextField);

        JLabel dataExternariiLabel = new JLabel("data Externarii");
        dataExternariiLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dataExternariiLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        dataExternariiLabel.setBounds(4, 311, 145, 29);
        this.getContentPane().add(dataExternariiLabel);

        dataExternariiTextField = new JTextField();
        dataExternariiTextField.setColumns(10);
        dataExternariiTextField.setBounds(173, 311, 177, 35);
        this.getContentPane().add(dataExternariiTextField);

        JLabel diagnosticLabel = new JLabel("Diagnostic");
        diagnosticLabel.setHorizontalAlignment(SwingConstants.CENTER);
        diagnosticLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        diagnosticLabel.setBounds(10, 364, 145, 29);
        this.getContentPane().add(diagnosticLabel);

        diagnoaticField = new JTextField();
        diagnoaticField.setColumns(10);
        diagnoaticField.setBounds(173, 364, 177, 35);
        this.getContentPane().add(diagnoaticField);

        JLabel tratamentLabel = new JLabel("Tratament");
        tratamentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tratamentLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tratamentLabel.setBounds(493, 105, 145, 29);
        this.getContentPane().add(tratamentLabel);

        tratamenttextField = new JTextField();
        tratamenttextField.setColumns(10);
        tratamenttextField.setBounds(503, 150, 328, 121);
        this.getContentPane().add(tratamenttextField);

        JLabel mediciiConsultatiLabel = new JLabel("Medicii Consultati");
        mediciiConsultatiLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mediciiConsultatiLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        mediciiConsultatiLabel.setBounds(503, 299, 145, 29);
        this.getContentPane().add(mediciiConsultatiLabel);

        mediciConsultatiField = new JTextField();
        mediciConsultatiField.setColumns(10);
        mediciConsultatiField.setBounds(503, 339, 328, 121);
        this.getContentPane().add(mediciConsultatiField);

        JLabel consultatiiPretLabel_1 = new JLabel("Pret consultatii");
        consultatiiPretLabel_1.setForeground(Color.RED);
        consultatiiPretLabel_1.setBackground(Color.RED);
        consultatiiPretLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        consultatiiPretLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        consultatiiPretLabel_1.setBounds(4, 431, 145, 29);
        this.getContentPane().add(consultatiiPretLabel_1);

        prettextField = new JTextField();
        prettextField.setBackground(Color.CYAN);
        prettextField.setBounds(173, 425, 276, 35);
        this.getContentPane().add(prettextField);
        prettextField.setColumns(10);

        JLabel lblEmail = new JLabel("email");
        lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmail.setBounds(26, 246, 72, 29);
        this.getContentPane().add(lblEmail);

        emailtextField = new JTextField();
        emailtextField.setColumns(10);
        emailtextField.setBounds(173, 246, 177, 35);
        this.getContentPane().add(emailtextField);

        startButton = new JButton("Pagina Start");
        startButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        startButton.setBounds(0, 0, 131, 29);
        this.getContentPane().add(startButton);

    }
    public  void deschideFereastra(){
        this.setVisible(true);
    }
    public  void inchideFereastra(){
        this.setVisible(false);
    }

    public  void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
        refresh();
    }

    public void refresh(){
        numetextField.setText(null);
        prenumetextField.setText(null);
        nrTeltextField.setText(null);
        dataExternariiTextField.setText(null);
        diagnoaticField.setText(null);
        tratamenttextField.setText(null);
        mediciConsultatiField.setText(null);
        prettextField.setText(null);
        emailtextField.setText(null);
    }

    public String getNumetextField() {
        return numetextField.getText();
    }

    public void setNumetextField(String numetextField) {
        this.numetextField.setText(numetextField);
    }

    public String getPrenumetextField() {
        return prenumetextField.getText();
    }

    public void setPrenumetextField(String prenumetextField) {
        this.prenumetextField.setText(prenumetextField);
    }

    public String getNrTeltextField() {
        return nrTeltextField.getText();
    }

    public void setNrTeltextField(String nrTeltextField) {
        this.nrTeltextField.setText(nrTeltextField);
    }

    public String getDataExternariiTextField() {
        return dataExternariiTextField.getText();
    }

    public void setDataExternariiTextField(String dataExternariiTextField) {
        this.dataExternariiTextField.setText(dataExternariiTextField);
    }

    public String getDiagnoaticField() {
        return diagnoaticField.getText();
    }

    public void setDiagnoaticField(String diagnoaticField) {
        this.diagnoaticField.setText(diagnoaticField);
    }

    public String getTratamenttextField() {
        return tratamenttextField.getText();
    }

    public void setTratamenttextField(String tratamenttextField) {
        this.tratamenttextField.setText(tratamenttextField);
    }

    public String getMediciConsultatiField() {
        return mediciConsultatiField.getText();
    }

    public void setMediciConsultatiField(String mediciConsultatiField) {
        this.mediciConsultatiField.setText(mediciConsultatiField);
    }

    public float getPrettextField() {
        return Float.parseFloat(prettextField.getText());
    }

    public void setPrettextField(float prettextField) {
        this.prettextField.setText(String.valueOf(prettextField));
    }

    public String getEmailtextField() {
        return emailtextField.getText();
    }

    public void setEmailtextField(String emailtextField) {
        this.emailtextField.setText(emailtextField);
    }
    public void backListenner( ActionListener action){
        startButton.addActionListener(action);
    }
}
