package br.udesc.modulo1.controle;

import br.udesc.modulo1.view.TabelaNoticia;
import br.udesc.modulo1.view.TelaInicial;
import br.udesc.modulo1.view.TabelaSite;
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
    private Window site;
    private Window noticia;
    private String scheduler;
    private String unscheduler;

    public InicialControle() {
      //  inicial = new TelaInicial();
        site = new TabelaSite();
        noticia = new TabelaNoticia();
        init();
    }

    public void run() {
      //  inicial.setVisible(true);
        noticia.setVisible(true);
    }

}
