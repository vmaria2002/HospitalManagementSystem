import controller.*;
import model.Doctor;
import model.Pacient;
import view.*;

import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) throws Exception {
//        Pattern patternn =Pattern.compile("[A-Z]");
//        String passwordField=new String("MaZia");
//        Matcher matcher = patternn.matcher(passwordField);
//        int nr=0;
//        while (matcher.find()){
//            nr++;
//        }
//        if(nr>1){
//            System.out.println("ok"+nr);
//        }

        Pacient pacient = new Pacient();
        Doctor doctor = new Doctor();
        StartPacient startPacient=new StartPacient();
        StartDoctor startDoctor = new StartDoctor();
        PaginaStart paginaStart = new PaginaStart();
        NewAccount newAccount = new NewAccount();
        ChitantaExternare chitantaExternare = new ChitantaExternare();

        DataBaseConnection db = new DataBaseConnection();
        Connection conn = db.getConnection();
        System.out.println("Database successfully connected!");

        LogIn logIn = new LogIn();
        PaginaStartController paginaStartController = new PaginaStartController(paginaStart, conn, logIn);
        LogInController logInController=new LogInController(pacient, doctor, conn, logIn,paginaStartController, startDoctor,startPacient,newAccount);

        NewAccountController newAccountController = new NewAccountController(pacient, doctor, conn, startDoctor, startPacient, paginaStart, paginaStartController, newAccount);

        DetaliiPacient detaliiPacient = new DetaliiPacient();

        DetaliiPacientController detaliiPacientController = new DetaliiPacientController(startDoctor, paginaStart, detaliiPacient,conn);  //celelalte

        ActivitatiPacientiController activitatiPacientiController = new ActivitatiPacientiController(pacient, chitantaExternare, paginaStart, startPacient, conn);
        ChitantaController chitantaController = new ChitantaController(chitantaExternare, startPacient);

        PaginaStartDoctorController paginaStartDoctorController =new PaginaStartDoctorController(conn, startDoctor, paginaStart, doctor, pacient, detaliiPacient);

        // conn.close();


    }
}
