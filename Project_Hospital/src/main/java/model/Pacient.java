package model;

import java.util.List;
import java.util.Objects;

public class Pacient {
    static int id=0;
    private String numel;
    private String prenume;
    private float cheltuieli;
    private String diagnostic;
    private String tratament;
    private String doctori;
    private String data_inscriere;
    private String data_externare;
    private int varsta;
    private String nr_tel;
    private String email;
    private String username;
    private String parola;
public Pacient(){
id++;
}
    public Pacient( String numel, String prenume, float cheltuieli, String diagnostic, String tratament, String doctori, String data_inscriere, String data_externare, int varsta, String nr_tel, String email, String username, String parola) {
        id++;
        this.numel = numel;
        this.prenume = prenume;
        this.cheltuieli = cheltuieli;
        this.diagnostic = diagnostic;
        this.tratament = tratament;
        this.doctori = doctori;
        this.data_inscriere = data_inscriere;
        this.data_externare = data_externare;
        this.varsta = varsta;
        this.nr_tel = nr_tel;
        this.email = email;
        this.username = username;
        this.parola = parola;
    }

    public Pacient(String numel, String prenume, float cheltuieli, String diagnostic, String tratament, String doctori, String data_inscriere, String data_externare, int varsta, String nr_tel, String email) {
        this.id++;
        this.numel = numel;
        this.prenume = prenume;
        this.cheltuieli = cheltuieli;
        this.diagnostic = diagnostic;
        this.tratament = tratament;
        this.doctori = doctori;
        this.data_inscriere = data_inscriere;
        this.data_externare = data_externare;
        this.varsta = varsta;
        this.nr_tel = nr_tel;
        this.email = email;
    }

    public Pacient(String numel, String prenume) {
        this.numel = numel;
        this.prenume = prenume;
    }

    public Pacient(int id, String username, String parola) {
        this.id = id;
        this.username = username;
        this.parola = parola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumel() {
        return numel;
    }

    public void setNumel(String numel) {
        this.numel = numel;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public float getCheltuieli() {
        return cheltuieli;
    }

    public void setCheltuieli(float cheltuieli) {
        this.cheltuieli = cheltuieli;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getTratament() {
        return tratament;
    }

    public void setTratament(String tratament) {
        this.tratament = tratament;
    }

    public String getDoctori() {
        return doctori.toString();
    }

    public void setDoctori(String doctori) {
        this.doctori = doctori;
    }

    public String getData_inscriere() {
        return data_inscriere;
    }

    public void setData_inscriere(String data_inscriere) {
        this.data_inscriere = data_inscriere;
    }

    public String getData_externare() {
        return data_externare;
    }

    public void setData_externare(String data_externare) {
        this.data_externare = data_externare;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
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
        Pacient pacient = (Pacient) o;
        return username.equals(pacient.username) && parola.equals(pacient.parola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, parola);
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "numel='" + numel + '\'' +
                ", prenume='" + prenume + '\'' +
                ", cheltuieli=" + cheltuieli +
                ", diagnostic='" + diagnostic + '\'' +
                ", tratament='" + tratament + '\'' +
                ", doctori='" + doctori + '\'' +
                ", data_inscriere='" + data_inscriere + '\'' +
                ", data_externare='" + data_externare + '\'' +
                ", varsta=" + varsta +
                ", nr_tel='" + nr_tel + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
