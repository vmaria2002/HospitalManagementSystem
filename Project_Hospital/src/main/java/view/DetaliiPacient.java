package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class DetaliiPacient extends JFrame {
    private JTextField numetextField;
    private JTextField prenumetextField;
    private JTextField nrTeltextField;
    private JTextField dataInternariitextField_1;
    private JTextField dataExternariiTextField;
    private JTextField diagnoaticField;
    private JTextField tratamenttextField_1;
    private JTextField mediciConsultatiField;

    private JButton paginaStartButton;
    private JButton okStartButton_1;


    public DetaliiPacient(){
        this.setBounds(100, 100, 855, 533);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Detalii pacient");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(246, 23, 309, 29);
        this.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nume");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(39, 105, 110, 29);
        this.getContentPane().add(lblNewLabel_1);

        numetextField = new JTextField();
        numetextField.setBounds(173, 105, 177, 35);
        this.getContentPane().add(numetextField);
        numetextField.setColumns(10);

        JLabel prenumeLabel_ = new JLabel("Prenume");
        prenumeLabel_.setHorizontalAlignment(SwingConstants.TRAILING);
        prenumeLabel_.setFont(new Font("Tahoma", Font.PLAIN, 18));
        prenumeLabel_.setBounds(26, 162, 72, 29);
        this.getContentPane().add(prenumeLabel_);

        prenumetextField = new JTextField();
        prenumetextField.setColumns(10);
        prenumetextField.setBounds(173, 150, 177, 35);
        this.getContentPane().add(prenumetextField);

        JLabel prenumeLabel = new JLabel("Nr. tel.");
        prenumeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
        prenumeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        prenumeLabel.setBounds(26, 225, 72, 29);
        this.getContentPane().add(prenumeLabel);

        nrTeltextField = new JTextField();
        nrTeltextField.setColumns(10);
        nrTeltextField.setBounds(173, 219, 177, 35);
        this.getContentPane().add(nrTeltextField);

        JLabel dataInternariiLabel = new JLabel("data Internarii");
        dataInternariiLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dataInternariiLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        dataInternariiLabel.setBounds(4, 288, 145, 29);
        this.getContentPane().add(dataInternariiLabel);

        dataInternariitextField_1 = new JTextField();
        dataInternariitextField_1.setColumns(10);
        dataInternariitextField_1.setBounds(173, 276, 177, 35);
        this.getContentPane().add(dataInternariitextField_1);

        JLabel dataExternariiLabel = new JLabel("data Externarii");
        dataExternariiLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dataExternariiLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        dataExternariiLabel.setBounds(10, 344, 145, 29);
        this.getContentPane().add(dataExternariiLabel);

        dataExternariiTextField = new JTextField();
        dataExternariiTextField.setColumns(10);
        dataExternariiTextField.setBounds(173, 344, 177, 35);
        this.getContentPane().add(dataExternariiTextField);

        JLabel diagnosticLabel = new JLabel("Diagnostic");
        diagnosticLabel.setHorizontalAlignment(SwingConstants.CENTER);
        diagnosticLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        diagnosticLabel.setBounds(10, 410, 145, 29);
        this.getContentPane().add(diagnosticLabel);

        diagnoaticField = new JTextField();
        diagnoaticField.setColumns(10);
        diagnoaticField.setBounds(173, 404, 177, 35);
        this.getContentPane().add(diagnoaticField);

        JLabel tratamentLabel = new JLabel("Tratament");
        tratamentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tratamentLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tratamentLabel.setBounds(493, 105, 145, 29);
        this.getContentPane().add(tratamentLabel);

        tratamenttextField_1 = new JTextField();
        tratamenttextField_1.setColumns(10);
        tratamenttextField_1.setBounds(503, 150, 328, 121);
        this.getContentPane().add(tratamenttextField_1);

        JLabel mediciiConsultatiLabel = new JLabel("Medicii Consultati");
        mediciiConsultatiLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mediciiConsultatiLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        mediciiConsultatiLabel.setBounds(503, 299, 145, 29);
        this.getContentPane().add(mediciiConsultatiLabel);

        mediciConsultatiField = new JTextField();
        mediciConsultatiField.setColumns(10);
        mediciConsultatiField.setBounds(503, 339, 328, 121);
        this.getContentPane().add(mediciConsultatiField);

        paginaStartButton = new JButton("Pagina Start");
        paginaStartButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        paginaStartButton.setBounds(10, 10, 165, 29);
        this.getContentPane().add(paginaStartButton);

        okStartButton_1 = new JButton("ok");
        okStartButton_1.setBackground(Color.CYAN);
        okStartButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        okStartButton_1.setBounds(10, 457, 165, 29);
        this.getContentPane().add(okStartButton_1);
    }

    public  void deschideFereastra(){
        this.setVisible(true);
    }
    public  void inchideFereastra(){
        this.setVisible(false);
    }

    public void paginaStartListenner( ActionListener action){
        paginaStartButton.addActionListener(action);
    }

    public void createListenner( ActionListener action){
        okStartButton_1.addActionListener(action);
    }

    public  void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    //seteaza tot pe null, goleste casutele

    public void refresh(){
        numetextField.setText(null);
        prenumetextField.setText(null);
        nrTeltextField.setText(null);
        dataExternariiTextField.setText(null);
        dataInternariitextField_1.setText(null);
        tratamenttextField_1.setText(null);
        mediciConsultatiField.setText(null);
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

    public String getDataInternariitextField_1() {
        return dataInternariitextField_1.getText();
    }

    public void setDataInternariitextField_1(String dataInternariitextField_1) {
        this.dataInternariitextField_1.setText(dataInternariitextField_1);
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

    public String getTratamenttextField_1() {
        return tratamenttextField_1.getText();
    }

    public void setTratamenttextField_1(String tratamenttextField_1) {
        this.tratamenttextField_1.setText(tratamenttextField_1);
    }

    public String getMediciConsultatiField() {
        return mediciConsultatiField.getText();
    }

    public void setMediciConsultatiField(String mediciConsultatiField) {
        this.mediciConsultatiField.setText(mediciConsultatiField);
    }
}
