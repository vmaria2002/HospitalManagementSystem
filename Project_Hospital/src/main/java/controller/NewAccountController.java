package controller;

import model.Doctor;
import model.Pacient;
import view.NewAccount;
import view.PaginaStart;
import view.StartDoctor;
import view.StartPacient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewAccountController {
    private StartDoctor startDoctor;
    private StartPacient startPacient;
    private PaginaStart paginaStart;
    private PaginaStartController paginaStartController;
    private NewAccount newAccount;
    private Connection connection;
    private Pacient pacient;
    private Doctor doctor;

    public NewAccountController(Pacient pacient, Doctor doctor, Connection connection, StartDoctor startDoctor, StartPacient startPacient, PaginaStart paginaStart, PaginaStartController paginaStartController, NewAccount newAccount) {
        this.pacient = pacient;
        this.doctor = doctor;
        this.startDoctor = startDoctor;
        this.startPacient = startPacient;
        this.paginaStart = paginaStart;
        this.paginaStartController = paginaStartController;
        this.newAccount = newAccount;
        this.connection = connection;
        this.newAccount.logareListenner(new CreateAxxount());
    }


    class CreateAxxount implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                String numeTextField = newAccount.getNumeTextField();
                String prenumetextField = newAccount.getPrenumetextField();
                String passwordField = newAccount.getPasswordField();
                String usernametextField = newAccount.getUsernametextField();
                String nrTeltextField = newAccount.getNrTeltextField();
                String emailtextField = newAccount.getEmailtextField();


                if (paginaStartController.getButonApasat().equals("pacient")) {

                    String sql = "select * from" + " pacient " + " where username =?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, usernametextField);
                    ResultSet result = statement.executeQuery();

                    boolean ok = true;
                    if (result.next() == true) {
                        ok = false;
                        newAccount.showMessage("Exista acest utilizaror");
                    }
                    if (ok == true) {
                        //setwz noile info
                        pacient.setNumel(numeTextField);
                        pacient.setPrenume(prenumetextField);
                        pacient.setParola(passwordField);
                        pacient.setUsername(usernametextField);
                        pacient.setNr_tel(nrTeltextField);
                        pacient.setEmail(emailtextField);


                        //inserez in baza de date:
                        if (passwordField.length() < 3) {
                            newAccount.showMessage2("Parola trebuie sa contina cel putin 3 caractere!!");
                        } else {
                            Pattern patternn = Pattern.compile("[A-Z]");
                            Matcher matcher = patternn.matcher(passwordField);
                            int nru = 0;
                            while (matcher.find()) {
                                nru++;
                            }


                            if (nru < 1) {
                                newAccount.showMessage2("Parola trebuie sa contina cel putin o majuscula!");
                            } else {

                                Pattern patternn2 = Pattern.compile("[0-9]");

                                Matcher matcher2 = patternn2.matcher(passwordField);
                                int nru2 = 0;
                                while (matcher2.find()) {
                                    nru2++;
                                }


                                if (nru2 < 1) {
                                    newAccount.showMessage2("Parola trebuie sa contina cel putin o cifra!");
                                } else {
//

                                    PreparedStatement preparedStatement = connection.prepareStatement("insert into pacient ( nume, prenume, parola, username, nr_tel, email, data_inscriere, id)" + "values (?, ?, ?, ?, ?, ?, ?, ?)");

                                    Pacient pacientu = new Pacient();
                                    preparedStatement.setString(1, numeTextField);
                                    preparedStatement.setString(2, prenumetextField);
                                    preparedStatement.setString(3, passwordField);
                                    preparedStatement.setString(4, usernametextField);
                                    preparedStatement.setString(5, nrTeltextField);
                                    preparedStatement.setString(6, emailtextField);
                                    preparedStatement.setString(7, LocalDateTime.now().toString());

                                    //pt a da numerele in ordine crescatoare!!=primary key:

                                    String sql2 = "select * from" + " pacient ";
                                    Statement statement2 = connection.createStatement();

                                    ResultSet result2 = statement2.executeQuery(sql2);
                                    int nr = 1;
                                    while (result2.next()) {
                                        nr++;
                                    }

                                    preparedStatement.setInt(8, nr);
                                    preparedStatement.executeUpdate();

                                    newAccount.inchideFereastra();
                                    startPacient.deschideFereastra();
                                }
                            }
                        }
                    }


                } else if (paginaStartController.getButonApasat().equals("doctor")) {

                    String sql = "select * from" + " doctor " + " where username =?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, usernametextField);
                    ResultSet result = statement.executeQuery();

                    boolean ok = true;
                    if (result.next() == true) {
                        ok = false;
                        newAccount.showMessage("Exista acest utilizaror");
                    }
                    if (ok == true) {
                        //setwz noile info
                        doctor.setNume(numeTextField);
                        doctor.setPrenume(prenumetextField);
                        doctor.setParola(passwordField);

                        if (passwordField.length() < 3) {
                            newAccount.showMessage2("Parola trebuie sa contina cel putin 3 caractere!!");
                        } else {
                            Pattern patternn = Pattern.compile("[A-Z]");

                            Matcher matcher = patternn.matcher(passwordField);
                            int nru = 0;
                            while (matcher.find()) {
                                nru++;
                            }


                            if (nru < 1) {
                                newAccount.showMessage2("Parola trebuie sa contina cel putin o majuscula!");
                            } else {

                                Pattern patternn2 = Pattern.compile("[0-9]");

                                Matcher matcher2 = patternn2.matcher(passwordField);
                                int nru2 = 0;
                                while (matcher2.find()) {
                                    nru2++;
                                }


                                if (nru2 < 1) {
                                    newAccount.showMessage2("Parola trebuie sa contina cel putin o cifra!");
                                } else {
                                    //
                                    doctor.setUsername(usernametextField);
                                    doctor.setNr_tel(nrTeltextField);
                                    doctor.setEmail(emailtextField);

                                    //inserez in baza de date:

                                    PreparedStatement preparedStatement = connection.prepareStatement("insert into doctor ( nume, prenume, parola, username, nr_tel, email, iddoctor)" + "values (?, ?, ?, ?, ?, ?, ?)");


                                    preparedStatement.setString(1, numeTextField);
                                    preparedStatement.setString(2, prenumetextField);
                                    preparedStatement.setString(3, passwordField);
                                    preparedStatement.setString(4, usernametextField);
                                    preparedStatement.setString(5, nrTeltextField);
                                    preparedStatement.setString(6, emailtextField);

                                    //pt a da numerele in ordine crescatoare!!=primary key:

                                    String sql2 = "select * from" + " doctor ";
                                    Statement statement2 = connection.createStatement();

                                    ResultSet result2 = statement2.executeQuery(sql2);
                                    int nr = 1;
                                    while (result2.next()) {
                                        nr++;
                                    }

                                    preparedStatement.setInt(7, nr);
                                    preparedStatement.executeUpdate();

                                    newAccount.inchideFereastra();
                                    startDoctor.deschideFereastra();

                                }
                            }

                        }

                    }


                }
            } catch (SQLException sqlException) {
                newAccount.showMessage(sqlException.toString());
                sqlException.printStackTrace();
            }
        }
    }
}
