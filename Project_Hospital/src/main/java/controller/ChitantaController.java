package controller;

import view.ChitantaExternare;
import view.StartPacient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChitantaController {
    private ChitantaExternare chitantaExternare;
    private StartPacient startPacient;

public ChitantaController(ChitantaExternare chitantaExternare, StartPacient startPacient){
   this.chitantaExternare=chitantaExternare;
   this.startPacient=startPacient;
    this.chitantaExternare.backListenner(new PaginaStartL());
}
    class PaginaStartL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                chitantaExternare.inchideFereastra();
                startPacient.deschideFereastra();
            } catch (Exception ef) {
                System.out.println(ef);
            }
        }
    }


}
