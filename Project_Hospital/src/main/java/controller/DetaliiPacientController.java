package controller;

import model.Pacient;
import view.DetaliiPacient;
import view.PaginaStart;
import view.StartDoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

public class DetaliiPacientController {
    private PaginaStart paginaStart;
    private DetaliiPacient detaliiPacient;
    private StartDoctor paginaStartDoctor;
    private Connection connection;

    public DetaliiPacientController(StartDoctor paginaStartDoctor, PaginaStart paginaStart, DetaliiPacient detaliiPacient, Connection connection){
        this.paginaStart=paginaStart;
        this.detaliiPacient=detaliiPacient;
        this.connection=connection;
        this.paginaStartDoctor=paginaStartDoctor;
        this.detaliiPacient.paginaStartListenner(new PaginaStartL());
        this.detaliiPacient.createListenner(new CreateL());

    }

    class PaginaStartL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
               detaliiPacient.inchideFereastra();
               paginaStart.deschideFereastra();
            } catch (Exception ef) {
                System.out.println(ef);
            }
        }
    }

    class CreateL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                detaliiPacient.inchideFereastra();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into pacient ( nume, prenume, parola, username, nr_tel, email, data_inscriere, id)" + "values (?, ?, ?, ?, ?, ?, ?, ?)");

                Pacient pacientu = new Pacient();
                preparedStatement.setString(1, detaliiPacient.getNumetextField());
                preparedStatement.setString(2, detaliiPacient.getPrenumetextField());
                preparedStatement.setString(3, "1234");
                preparedStatement.setString(4, detaliiPacient.getNumetextField());
                preparedStatement.setString(5, detaliiPacient.getNrTeltextField());
                preparedStatement.setString(6, detaliiPacient.getDataInternariitextField_1());
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

                paginaStartDoctor.deschideFereastra();
            } catch (Exception ef) {
                System.out.println(ef);
            }
        }
    }
}
