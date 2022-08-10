package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartPacient extends JFrame {
    private JTextField rezultateleCautariitextField;

    private JButton chitantaButton;
    private JButton diagnosticButton;
    private JButton tratamentButton;
    private  JButton doctoriButton;
    private  JButton internareButton;
    private JButton externareButton;
    private JButton paginaStartButton;

    public StartPacient(){
        this.setBounds(100, 100, 887, 565);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Activitati pacienti");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(268, 10, 282, 26);
        this.getContentPane().add(lblNewLabel);

        chitantaButton = new JButton("Chitanta");
        chitantaButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        chitantaButton.setBounds(127, 134, 169, 40);
        this.getContentPane().add(chitantaButton);

        diagnosticButton = new JButton("Diagnostic");
        diagnosticButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        diagnosticButton.setBounds(127, 197, 169, 40);
        this.getContentPane().add(diagnosticButton);

        tratamentButton = new JButton("Tratament");
        tratamentButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tratamentButton.setBounds(127, 260, 169, 40);
        this.getContentPane().add(tratamentButton);

        doctoriButton = new JButton("Doctori");
        doctoriButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        doctoriButton.setBounds(127, 325, 169, 40);
        this.getContentPane().add(doctoriButton);

        internareButton = new JButton("Data Internare");
        internareButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        internareButton.setBounds(127, 382, 169, 40);
        this.getContentPane().add(internareButton);

        externareButton = new JButton("Data Externare");
        externareButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        externareButton.setBounds(127, 438, 169, 40);
        this.getContentPane().add(externareButton);

        rezultateleCautariitextField = new JTextField();
        rezultateleCautariitextField.setBounds(416, 165, 330, 285);
        this.getContentPane().add(rezultateleCautariitextField);
        rezultateleCautariitextField.setColumns(10);

        paginaStartButton = new JButton("Pagina Start");
        paginaStartButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        paginaStartButton.setBounds(10, 10, 165, 29);
        this.getContentPane().add(paginaStartButton);

        JLabel rezultatLabe = new JLabel("Rezultatul cautarii dumeavoastra:");
        rezultatLabe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rezultatLabe.setBounds(416, 107, 330, 48);
        this.getContentPane().add(rezultatLabe);

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
    public void refresh(){
        rezultateleCautariitextField.setText(null);
    }

    public String getRezultateleCautariitextField() {
        return rezultateleCautariitextField.getText();
    }

    public void setRezultateleCautariitextField(String rezultateleCautariitextField) {
        this.rezultateleCautariitextField.setText(rezultateleCautariitextField);
    }

    public void vizualizareChitantaListenner( ActionListener action){
        chitantaButton.addActionListener(action);
    }
    public void PaginaStartListenner( ActionListener action){
        paginaStartButton.addActionListener(action);
    }

    public void diagnosticaListenner( ActionListener action){
        diagnosticButton.addActionListener(action);
    }
    public void tratamentListenner( ActionListener action){
        tratamentButton.addActionListener(action);
    }
    public void doctoriiConsultatiListenner( ActionListener action){
        doctoriButton.addActionListener(action);
    }
    public void  dataInternareListenner( ActionListener action){
        internareButton.addActionListener(action);
    }
    public void dataExternareListenner( ActionListener action){
        externareButton.addActionListener(action);
    }
}
