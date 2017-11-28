
package br.udesc.modulo1.visao;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import br.udesc.sqlite.modelo.Horario;

/**
 *
 * @author Nando
 */
public class HorarioModelo extends AbstractTableModel{
    
     private ArrayList<Horario> listaHorario = null;

    public HorarioModelo() {
        listaHorario = new ArrayList<Horario>();

    }

    public void AddHorario(Horario Objeto) {
        listaHorario.add(Objeto);
        fireTableRowsInserted(listaHorario.size() - 1, listaHorario.size() - 1);
    }

    public void Limpar() {
        listaHorario.clear();
    }

    public Horario GetPosition(int posicao) {
        return listaHorario.get(posicao);

    }

    public void Excluir(int Posicao) {
        listaHorario.remove(Posicao);
        fireTableRowsDeleted(Posicao, Posicao);
    }

    @Override
    public int getRowCount() {
        return listaHorario.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Horario horario = listaHorario.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return horario.getData();
        }

        return null;

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Horário";
        }

        return "";
    }
    
}
