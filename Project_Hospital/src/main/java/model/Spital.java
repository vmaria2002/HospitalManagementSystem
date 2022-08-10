package model;

import java.util.ArrayList;
import java.util.List;

public class Spital {
    private List<Doctor> doctors;
    private List<Pacient> pacients;

    public Spital(){
        this.doctors=new ArrayList<>();
        this.pacients=new ArrayList<>();
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Pacient> getPacients() {
        return pacients;
    }

    public void setPacients(List<Pacient> pacients) {
        this.pacients = pacients;
    }
    public  void addDoctor(Doctor doctor){
        if(!this.doctors.contains(doctor)) {
            this.getDoctors().add(doctor);
        }
    }
    public  void addPacient(Pacient pacient){
        if(!this.pacients.contains(pacient)) {
            this.getPacients().add(pacient);
        }
    }
}
