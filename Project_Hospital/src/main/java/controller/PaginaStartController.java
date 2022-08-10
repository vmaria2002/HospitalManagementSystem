package controller;


import view.LogIn;
import view.PaginaStart;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;


public class PaginaStartController {
private PaginaStart paginaStart;
private Connection dataBaseConnection;
private String butonApasat;
private LogIn logIn;
public PaginaStartController(PaginaStart paginaStart, Connection dataBaseConnection, LogIn logIn){
    this.paginaStart=paginaStart;
    this.dataBaseConnection=dataBaseConnection;
    this.logIn=logIn;
    this.paginaStart.deschideFereastra();
    this.butonApasat="";
    this.paginaStart.doctorListenner(new DoctoriL());
    this.paginaStart.pacientListenner(new PacientL());


}
    class DoctoriL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                logIn.deschideFereastra();
                butonApasat="doctor";
                paginaStart.inchideFereastra();
            } catch (Exception ex) {

            }
        }
    }

    class PacientL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                logIn.deschideFereastra();
                butonApasat="pacient";
                paginaStart.inchideFereastra();
            } catch (Exception ex) {

            }
        }
    }

    public String getButonApasat() {
        return butonApasat;
    }

    public void setButonApasat(String butonApasat) {
        this.butonApasat = butonApasat;
    }
}
