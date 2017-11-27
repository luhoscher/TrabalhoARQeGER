package br.udesc.modulo1.controle;

import br.udesc.modulo1.view.TelaInicial;
import java.awt.Window;
import static org.omg.CORBA.ORB.init;

/**
 *
 * @author nando
 */
public class InicialControle {

    public static void main(String[] args) {
        InicialControle ic = new InicialControle();
        ic.run();
    }
    private Window inicial;
    private String scheduler;
    private String unscheduler;

    public InicialControle() {
        inicial = new TelaInicial();
        init();
    }

    public void run() {
        inicial.setVisible(true);
    }

}
