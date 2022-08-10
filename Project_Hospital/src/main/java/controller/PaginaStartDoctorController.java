package controller;

import model.Doctor;
import model.Pacient;
import view.DetaliiPacient;
import view.PaginaStart;
import view.StartDoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaginaStartDoctorController {
    private Connection dataBaseConnection;
    private PaginaStart paginaStart;
    private StartDoctor startDoctor;
    private Doctor doctor;
    private Pacient pacient;

    private DetaliiPacient detaliiPacient;


    public PaginaStartDoctorController(Connection dataBaseConnection, StartDoctor startDoctor, PaginaStart paginaStart, Doctor doctor, Pacient pacient, DetaliiPacient detaliiPacient) {
        this.startDoctor = startDoctor;
        this.dataBaseConnection = dataBaseConnection;
        this.paginaStart = paginaStart;
        this.pacient = pacient;
        this.doctor = doctor;
        this.detaliiPacient = detaliiPacient;

        this.startDoctor.istoricPacientListenner(new IstoricP());
        this.startDoctor.inapoiListenner(new BackL());
        this.startDoctor.externatiPacientListenner(new Externati());
        this.startDoctor.consultatiiPacientListenner(new ConsultatiL());
        this.startDoctor.newPacientListenner(new NoulPacientL());
        this.startDoctor.tratamentListenner(new TratamentL());
    }

    class IstoricP implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nume = startDoctor.getNumeTextField();
                String prenume = startDoctor.getPrenumeTextField_1();

                //caut in baza de date pacientul:
                String sql = "select * from" + " pacient " + " where nume =? and prenume =?";
                PreparedStatement statement = dataBaseConnection.prepareStatement(sql);
                statement.setString(1, nume);
                statement.setString(2, prenume);
                ResultSet result = null;
                result = statement.executeQuery();


                boolean nu = true;
                String numel = null;
                String prenumel = null;
                float cheltuieli = 0;
                String diagnostic = null;
                String tratament = null;
                String doctori = null;
                String data_inscriere = null;
                String data_externare = null;
                int varsta = 0;
                String nr_tel = null;
                String email = null;

                while (result.next()) {
                    nu = false;
                    numel = result.getString(2);
                    prenumel = result.getString(3);
                    cheltuieli = result.getFloat(4);
                    diagnostic = result.getString(5);
                    tratament = result.getString(6);
                    doctori = result.getString(7);
                    data_inscriere = result.getString(8);
                    data_externare = result.getString(9);
                    varsta = result.getInt(10);
                    nr_tel = result.getString(11);
                    email = result.getString(12);

                }
                if (nu == true) {
                    startDoctor.showMessage("Nu exista acest pacient!");
                } else {
                    startDoctor.inchideFereastra();
                    detaliiPacient.deschideFereastra();
                    /**
                     * seteaza campurile!!
                     */
                    detaliiPacient.setNumetextField(numel);
                    detaliiPacient.setPrenumetextField(prenumel);
                    detaliiPacient.setNrTeltextField(nr_tel);
                    detaliiPacient.setDataInternariitextField_1(data_inscriere);
                    detaliiPacient.setDataExternariiTextField(data_externare);
                    detaliiPacient.setDiagnoaticField(diagnostic);
                    detaliiPacient.setTratamenttextField_1(tratament);
                    detaliiPacient.setMediciConsultatiField(doctori);


                }
                System.out.println(doctor.toString());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }


    class BackL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                startDoctor.inchideFereastra();
                startDoctor.refresh();
                paginaStart.deschideFereastra();
            } catch (Exception ex) {

            }
        }
    }

    class Externati implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (startDoctor.getPrenumeTextField_1() == null || startDoctor.getNumeTextField() == null) {
                    startDoctor.showMessage("Introduceti numele pacientului");
                } else {
                    String nume = startDoctor.getNumeTextField();
                    String prenume = startDoctor.getPrenumeTextField_1();

                    //caut in baza de date pacientul:
                    String sql = "select * from" + " pacient " + " where nume =? and prenume =?";
                    PreparedStatement statement = dataBaseConnection.prepareStatement(sql);
                    statement.setString(1, nume);
                    statement.setString(2, prenume);
                    ResultSet result = null;
                    result = statement.executeQuery();


                    boolean nu = true;

                    while (result.next()) {
                        nu = false;
                    }


                    if (nu == true) {
                        startDoctor.showMessage("Nu exista acest pacient!");
                    } else {

                        LocalDateTime dataExternarii = LocalDateTime.now();
                        String dataEx = dataExternarii.toString();
                        startDoctor.showMessage("Pacienul: " + nume + " " + prenume + " a fost externat la data de " + dataEx);


                        /**
                         * Update baza de date:
                         */
                        String sql2 = "UPDATE pacient SET data_externare =?  WHERE nume=? and prenume=?";
                        PreparedStatement statement2 = dataBaseConnection.prepareStatement(sql2);
                        statement2.setString(1, dataEx);
                        statement2.setString(2, nume);
                        statement2.setString(3, prenume);
                        statement2.executeUpdate();


                    }

                }


            } catch (Exception ex) {

            }
        }
    }

    class ConsultatiL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nume = startDoctor.getNumeTextField();
                String prenume = startDoctor.getPrenumeTextField_1();
                String diagnostic = startDoctor.getDiagnostictextField();
                float pret = -1;
                pret = startDoctor.getPretTextField();

                if (nume == null || prenume == null) {
                    startDoctor.showMessage("Introduceti numele pacientului!");
                } else if (diagnostic == null) {
                    startDoctor.showMessage("Introduceti diagnosticul!");
                } else if (pret == -1) {
                    startDoctor.showMessage("introduceti pretul consultatiei");
                } else {


                    //caut in baza de date pacientul:
                    String sql = "select * from" + " pacient " + " where nume =? and prenume =?";
                    PreparedStatement statement = dataBaseConnection.prepareStatement(sql);
                    statement.setString(1, nume);
                    statement.setString(2, prenume);
                    ResultSet result = null;
                    result = statement.executeQuery();

                    boolean nu = true;
                    float cheltuieliCurente = 0;
                    String doctori = null;
                    String diagnosti = null;
                    while (result.next()) {
                        nu = false;
                        cheltuieliCurente = result.getFloat(4);
                        doctori = result.getString(7);
                        diagnosti = result.getString(5);


                    }
                    String numeD = doctor.getNume();
                    String prenumeD = doctor.getPrenume();
                    String rezultatNumePrenume = numeD + " " + prenumeD;


                    Pattern patternn2 = Pattern.compile(rezultatNumePrenume);
                    Matcher matcher2 = patternn2.matcher(doctori);

                    int nru2 = 0;
                    while (matcher2.find()) {
                        nru2++;
                    }
                    if (nru2 > 1) {
                        startDoctor.showMessage("Pacientul a mai fost consultat de acest doctor, nu se va mai persepe taxa pentru consultatie la generarea retetei");
                        doctori += ", " + rezultatNumePrenume;
                    }
                    cheltuieliCurente += pret;
                    // doctori += ", " + doctor.getNume() + " " + doctor.getPrenume();
                    diagnosti += ", " + diagnostic;

                    if (nu == true) {
                        startDoctor.showMessage("Nu exista acest pacient!");
                    } else {
                        startDoctor.showMessage("Pacientul: " + nume + " " + prenume + " sufera de:" + diagnostic + " si va plati: " + pret + " pentru consultatie. Cheltuieli totatle: " + cheltuieliCurente);


                        /** facem update la baza de date!! */
                        String sql2 = "UPDATE pacient SET diagnostic =?, cheltuieli=?, doctori=?  WHERE nume=? and prenume=?";
                        PreparedStatement statement2 = dataBaseConnection.prepareStatement(sql2);
                        statement2.setString(1, diagnosti);
                        statement2.setFloat(2, cheltuieliCurente);
                        statement2.setString(4, nume);
                        statement2.setString(5, prenume);
                        statement2.setString(3, doctori);


                        statement2.executeUpdate();


                    }
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    class TratamentL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nume = startDoctor.getNumeTextField();
                String prenume = startDoctor.getPrenumeTextField_1();
                String tratament = startDoctor.getTratamenttextField();
                float consult = -1;
                consult = startDoctor.getPretTextField();

                if (nume == null || prenume == null) {
                    startDoctor.showMessage("Introduceti numele pacientului!");
                } else if (consult == -1) {
                    startDoctor.showMessage("Introduceti pretul consultului!");
                } else if (tratament == null) {
                    startDoctor.showMessage("Introduceti tratamentul!");
                } else {
                    /** verific daca exista doctorul care i-s facut consultatia, daca da, nu se percepe o noua taxare pt. consultati
                     */

                    String sql = "select * from" + " pacient " + " where nume =? and prenume =?";
                    PreparedStatement statement = dataBaseConnection.prepareStatement(sql);
                    statement.setString(1, nume);
                    statement.setString(2, prenume);
                    ResultSet result = null;
                    result = statement.executeQuery();


                    boolean nu = true;
                    String doctoriExistenti = null;
                    String tratamente = null;
                    String doc = null;
                    float pretC = -1;
                    while (result.next()) {
                        nu = false;
                        doctoriExistenti = result.getString(7);
                        tratamente = result.getString(6);
                        pretC = result.getFloat(4);

                    }
                    tratamente += ", " + tratament;
                    pretC += consult;


                    String numeD = doctor.getNume();
                    String prenumeD = doctor.getPrenume();
                    String rezultatNumePrenume = numeD + " " + prenumeD;
                    doctoriExistenti += ", " + rezultatNumePrenume;

                    Pattern patternn2 = Pattern.compile(rezultatNumePrenume);
                    Matcher matcher2 = patternn2.matcher(doctoriExistenti);

                    int nru2 = 0;
                    while (matcher2.find()) {
                        nru2++;
                    }
                    if (nru2 > 1) {
                        startDoctor.showMessage("Pacientul a mai fost consultat de acest doctor, nu se va mai persepe taxa pentru consultatie la generarea retetei");
                        /*** update tratament*/
                        String sql2 = "UPDATE pacient SET tratament=?  WHERE nume=? and prenume=?";
                        PreparedStatement statement2 = dataBaseConnection.prepareStatement(sql2);
                        statement2.setString(1, tratamente);
                        statement2.setString(2, nume);
                        statement2.setString(3, prenume);
                        statement2.executeUpdate();


                    } else {
                        startDoctor.showMessage("Pacientul NU a mai fost consultat de acest doctor,se va mai persepe taxa pentru consultatie la generarea retetei");
                        /*** update tratament +pret*/
                        String sql2 = "UPDATE pacient SET tratament=?, cheltuieli=?, doctori=?   WHERE nume=? and prenume=?";
                        PreparedStatement statement2 = dataBaseConnection.prepareStatement(sql2);
                        statement2.setString(1, tratamente);
                        statement2.setFloat(2, pretC);
                        statement2.setString(3, doctoriExistenti);
                        statement2.setString(4, nume);
                        statement2.setString(5, prenume);
                        statement2.executeUpdate();

                    }

                }
            } catch (Exception ex) {
                //startDoctor.showMessage("Introduceti numele pacientului si al tratamentului");
            }
        }
    }

    class  NoulPacientL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                startDoctor.inchideFereastra();

                detaliiPacient.deschideFereastra();

//                PreparedStatement preparedStatement = dataBaseConnection.prepareStatement("insert into pacient ( nume, prenume, parola, username, nr_tel, email, data_inscriere, id)" + "values (?, ?, ?, ?, ?, ?, ?, ?)");
//
//                Pacient pacientu = new Pacient();
//                preparedStatement.setString(1, detaliiPacient.getNumetextField());
//                preparedStatement.setString(2, detaliiPacient.getPrenumetextField());
//                preparedStatement.setString(3, "1234");
//                preparedStatement.setString(4, detaliiPacient.getNumetextField());
//                preparedStatement.setString(5, detaliiPacient.getNrTeltextField());
//                preparedStatement.setString(6, detaliiPacient.getDataInternariitextField_1());
//                preparedStatement.setString(7, LocalDateTime.now().toString());
//
//                //pt a da numerele in ordine crescatoare!!=primary key:
//
//                String sql2 = "select * from" + " pacient ";
//                Statement statement2 = dataBaseConnection.createStatement();
//
//                ResultSet result2 = statement2.executeQuery(sql2);
//                int nr = 0;
//                while (result2.next()) {
//                    nr++;
//                }
//
//                preparedStatement.setInt(8, nr);
//                preparedStatement.executeUpdate();

            } catch (Exception ex) {

            }
        }
    }


}
