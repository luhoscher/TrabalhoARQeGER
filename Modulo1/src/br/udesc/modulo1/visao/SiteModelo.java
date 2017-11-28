
package br.udesc.modulo1.visao;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import br.udesc.sqlite.modelo.Site;

/**
 *
 * @author Nando
 */
public class SiteModelo extends AbstractTableModel {

    private ArrayList<Site> listaSites = null;

    public SiteModelo() {
        listaSites = new ArrayList<Site>();

    }

    public void AddSite(Site Objeto) {
        listaSites.add(Objeto);
        fireTableRowsInserted(listaSites.size() - 1, listaSites.size() - 1);
    }

    public void Limpar() {
        listaSites.clear();
    }

    public Site GetPosition(int posicao) {
        return listaSites.get(posicao);

    }

    public void Excluir(int Posicao) {
        listaSites.remove(Posicao);
        fireTableRowsDeleted(Posicao, Posicao);
    }

    @Override
    public int getRowCount() {
        return listaSites.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Site site = listaSites.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return site.getUrl();
        }

        return null;

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Url";
        }

        return "";
    }

}
