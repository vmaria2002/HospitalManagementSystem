package model;

import java.util.List;
import java.util.Objects;

public class Doctor {
   static int iddoctor=1;
    private String nume;
    private String prenume;
    private String specializare;
    private String pacienti;
    private String spital;
    private String nr_tel;
    private String email;
    private String username;
    private String parola;

    public Doctor( String nume, String prenume, String specializare, String pacienti, String spital, String nr_tel, String email, String username, String parola) {
        this.iddoctor++;
        this.nume = nume;
        this.prenume = prenume;
        this.specializare = specializare;
        this.pacienti = pacienti;
        this.spital = spital;
        this.nr_tel = nr_tel;
        this.email = email;
        this.username = username;
        this.parola = parola;
    }
public Doctor(){

}
    public Doctor(String nume, String prenume, String specializare, String pacienti, String spital, String nr_tel, String email) {
        this.nume = nume;
        this.prenume = prenume;
        this.specializare = specializare;
        this.pacienti = pacienti;
        this.spital = spital;
        this.nr_tel = nr_tel;
        this.email = email;
    }

    public Doctor(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }
    public Doctor(int iddoctor, String username, String parola) {
        this.username = username;
        this.parola = parola;
    }

    public static int getIddoctor() {
        return iddoctor;
    }

    public static void setIddoctor(int iddoctor) {
        Doctor.iddoctor = iddoctor;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public String getPacienti() {
        return pacienti.toString();
    }

    public void setPacienti(String pacienti) {
        this.pacienti = pacienti;
    }

    public String getSpital() {
        return spital;
    }

    public void setSpital(String spital) {
        this.spital = spital;
    }

    public String getNr_tel() {
        return nr_tel;
    }

    public void setNr_tel(String nr_tel) {
        this.nr_tel = nr_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return username.equals(doctor.username) && parola.equals(doctor.parola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, parola);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", specializare='" + specializare + '\'' +
                ", pacienti='" + pacienti + '\'' +
                ", spital='" + spital + '\'' +
                ", nr_tel='" + nr_tel + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
