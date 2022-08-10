package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PaginaStart extends JFrame {
public  JButton doctorButton;
public  JButton btnPacient;

    public PaginaStart(){

        this.setBounds(100, 100, 781, 557);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("Hospital Management System");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblNewLabel.setBounds(228, 0, 362, 22);
        this.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Selectati tipul de utilizator");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(261, 128, 237, 22);
        this.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon("D:\\Proiecte_Java\\Project_Hospital\\doctor.png"));
        lblNewLabel_2.setBounds(54, 160, 262, 200);
        this.getContentPane().add(lblNewLabel_2);

        doctorButton = new JButton("Doctor");
        doctorButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        doctorButton.setBounds(58, 388, 227, 34);
        this.getContentPane().add(doctorButton);

        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setBounds(-35, 177, 211, 183);
        this.getContentPane().add(lblNewLabel_2_1);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("D:\\Proiecte_Java\\Project_Hospital\\pacient.png"));
        lblNewLabel_3.setBounds(415, 159, 308, 196);
        this.getContentPane().add(lblNewLabel_3);

        btnPacient = new JButton("Pacient");
        btnPacient.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnPacient.setBounds(455, 388, 227, 34);
        this.getContentPane().add(btnPacient);



    }
    public  void deschideFereastra(){
        this.setVisible(true);
    }
    public  void inchideFereastra(){
        this.setVisible(false);
    }

    public void doctorListenner( ActionListener action){
        doctorButton.addActionListener(action);
    }

    public void pacientListenner( ActionListener action){
        btnPacient.addActionListener(action);
    }

}
