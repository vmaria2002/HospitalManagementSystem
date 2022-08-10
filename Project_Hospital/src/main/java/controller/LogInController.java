package controller;

import model.Doctor;
import model.Pacient;
import view.LogIn;
import view.NewAccount;
import view.StartDoctor;
import view.StartPacient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class LogInController {
    private Connection dataBaseConnection;
    private LogIn logIn;
    private PaginaStartController paginaStartController;
    private StartPacient startPacient;
    private StartDoctor startDoctor;
    private NewAccount newAccount;
    private Pacient pacient;
    private Doctor doctor;

    public LogInController(Pacient pacient, Doctor doctor, Connection dataBaseConnection, LogIn logIn, PaginaStartController paginaStartController, StartDoctor startDoctor, StartPacient startPacient, NewAccount newAccount) {
        this.dataBaseConnection = dataBaseConnection;
        this.paginaStartController = paginaStartController;
        this.startDoctor = startDoctor;
        this.startPacient = startPacient;
        this.newAccount = newAccount;
        this.logIn = logIn;
        this.pacient = pacient;
        this.doctor = doctor;

        this.logIn.logareListenner(new LogareL());
        this.logIn.newAccountListenner(new NewAccounL());


    }

    class NewAccounL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                logIn.inchideFereastra();
                newAccount.deschideFereastra();
            } catch (Exception ef) {
                System.out.println(ef);
            }
        }
    }

    class LogareL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String butonApasat = paginaStartController.getButonApasat();
                String user = logIn.getUserNametextField();
                String pass = logIn.getParolatextField();
                System.out.println(user + pass);

                if (butonApasat.equals("pacient")) {
                    String sql = "select * from" + " pacient " + " where username =? and parola =?";
                    PreparedStatement statement = dataBaseConnection.prepareStatement(sql);
                    statement.setString(1, user);
                    statement.setString(2, pass);
                    ResultSet result = statement.executeQuery();


                    boolean nu = true;

                    while (result.next()) {
                        nu = false;
                        int id = result.getInt(1);
                        String numel = result.getString(2);
                        String prenume = result.getString(3);
                        float cheltuieli = result.getFloat(4);
                        String diagnostic = result.getString(5);
                        String tratament = result.getString(6);
                        String doctori = result.getString(7);
                        String data_inscriere = result.getString(8);
                        String data_externare = result.getString(9);
                        int varsta = result.getInt(10);
                        String nr_tel = result.getString(11);
                        String email = result.getString(12);

                        pacient.setId(id);
                        pacient.setNumel(numel);
                        pacient.setPrenume(prenume);
                        pacient.setCheltuieli(cheltuieli);
                        pacient.setDiagnostic(diagnostic);
                        pacient.setTratament(tratament);
                        pacient.setDoctori(doctori);
                        pacient.setData_inscriere(data_inscriere);
                        pacient.setData_externare(data_externare);
                        pacient.setVarsta(varsta);
                        pacient.setNr_tel(nr_tel);
                        pacient.setEmail(email);

                        logIn.inchideFereastra();
                        startPacient.deschideFereastra();

                    }
                    if (nu == true) {
                        logIn.showMessage("Nu exista acest connt!");
                    } else {
                        logIn.inchideFereastra();
                        startPacient.deschideFereastra();
                    }
                    System.out.println(pacient.toString());

                } else {
                    String sql = "select * from" + " doctor " + " where username =? and parola =?";
                    PreparedStatement statement = dataBaseConnection.prepareStatement(sql);
                    statement.setString(1, user);
                    statement.setString(2, pass);
                    ResultSet result = statement.executeQuery();

                    boolean nu = true;

                    while (result.next()) {
                        nu = false;
                        String nume = result.getString(2);
                        String prenume = result.getString(3);
                        String specializare = result.getString(4);
                        String pacienti = result.getString(5);
                        String nr_tel = result.getString(7);
                        String email = result.getString(8);

                        doctor.setNume(nume);
                        doctor.setPrenume(prenume);
                        doctor.setSpecializare(specializare);
                        doctor.setPacienti(pacienti);
                        doctor.setEmail(email);
                        doctor.setNr_tel(nr_tel);


                        System.out.println(nr_tel);


                    }
                    if (nu == true) {
                        logIn.showMessage("Nu exista acest connt!");
                    } else {
                        logIn.inchideFereastra();
                        startDoctor.deschideFereastra();
                    }
                    System.out.println(doctor.toString());
                }

            } catch (Exception ex) {
                System.out.println(ex);
                logIn.showMessage("Datele introduse  sunt invalide");
            }
        }
    }
}
