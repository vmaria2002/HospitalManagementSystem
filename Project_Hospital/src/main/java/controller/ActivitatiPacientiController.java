package controller;

import model.Pacient;
import view.ChitantaExternare;
import view.PaginaStart;
import view.StartPacient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ActivitatiPacientiController {
    private PaginaStart paginaStart;
    private StartPacient startPacient;
    private Connection connection;
    private ChitantaExternare chitantaExternare;
    private Pacient pacient;

    public ActivitatiPacientiController(Pacient pacient, ChitantaExternare chitantaExternare, PaginaStart paginaStart, StartPacient startPacient, Connection connection) {
        this.paginaStart = paginaStart;
        this.startPacient = startPacient;
        this.connection = connection;
        this.chitantaExternare = chitantaExternare;
        this.pacient = pacient;

        this.startPacient.PaginaStartListenner(new PaginaStartL());
        this.startPacient.vizualizareChitantaListenner(new ChitantaL());
        this.startPacient.diagnosticaListenner(new DiagnosticL());
        this.startPacient.tratamentListenner(new TratamentL());
        this.startPacient.doctoriiConsultatiListenner(new DoctoriL());
        this.startPacient.dataInternareListenner(new InternareL());
        this.startPacient.dataExternareListenner(new ExternareL());

    }
    class PaginaStartL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                startPacient.inchideFereastra();
                paginaStart.deschideFereastra();
            } catch (Exception ef) {
                System.out.println(ef);
            }
        }
    }
    class TratamentL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String diagnostic = pacient.getTratament();
                startPacient.setRezultateleCautariitextField(diagnostic);
            } catch (Exception ef) {
              //  System.out.println("introduceti numele pacientului si al tratamentului");
            }
        }
    }
    class InternareL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String diagnostic = pacient.getData_inscriere();
                startPacient.setRezultateleCautariitextField(diagnostic);
            } catch (Exception ef) {
                System.out.println(ef);
            }
        }
    }

    class ExternareL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String diagnostic = pacient.getData_externare();
                startPacient.setRezultateleCautariitextField(diagnostic);
            } catch (Exception ef) {
                System.out.println(ef);
            }
        }
    }

    class DiagnosticL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String diagnostic = pacient.getDiagnostic();
               startPacient.setRezultateleCautariitextField(diagnostic);
            } catch (Exception ef) {
                System.out.println(ef);
            }
        }
    }

    class DoctoriL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String diagnostic = pacient.getDoctori();
                startPacient.setRezultateleCautariitextField(diagnostic);
            } catch (Exception ef) {
                System.out.println(ef);
            }
        }
    }

    class ChitantaL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                startPacient.inchideFereastra();

                //se obtin detaliile despre pacient!!
                String nume = pacient.getNumel();
                String prenume = pacient.getPrenume();
                String nrTel = pacient.getNr_tel();
                String email = pacient.getEmail();
                String dataExternarii = pacient.getData_externare();
                String diagnostic = pacient.getDiagnostic();
                float pretConsultatii = pacient.getCheltuieli();
                String tratament = pacient.getTratament();
                String mediciConsultati = pacient.getDoctori();

                chitantaExternare.setNumetextField(nume);
                chitantaExternare.setPrenumetextField(prenume);
                chitantaExternare.setNrTeltextField(nrTel);
                chitantaExternare.setEmailtextField(email);
                chitantaExternare.setDataExternariiTextField(dataExternarii);
                chitantaExternare.setDiagnoaticField(diagnostic);
                chitantaExternare.setPrettextField(pretConsultatii);
                chitantaExternare.setTratamenttextField(tratament);
                chitantaExternare.setMediciConsultatiField(mediciConsultati);

                chitantaExternare.deschideFereastra();
            } catch (Exception ef) {
                System.out.println(ef);
            }
        }
    }
}
