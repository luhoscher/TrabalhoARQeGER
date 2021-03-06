package br.udesc.modulo1.visao;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import br.udesc.sqlite.modelo.Email;

/**
 *
 * @author Nando
 */
public class EmailModelo extends AbstractTableModel {

    private ArrayList<Email> listaEmail = null;

    public EmailModelo() {
        listaEmail = new ArrayList<Email>();

    }

    public void AddEmail(Email Objeto) {
        listaEmail.add(Objeto);
        fireTableRowsInserted(listaEmail.size() - 1, listaEmail.size() - 1);
    }

    public void Limpar() {
        listaEmail.clear();
    }

    public Email GetPosition(int posicao) {
        return listaEmail.get(posicao);

    }

    public void Excluir(int Posicao) {
        listaEmail.remove(Posicao);
        fireTableRowsDeleted(Posicao, Posicao);
    }

    @Override
    public int getRowCount() {
        return listaEmail.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Email email = listaEmail.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return email.getEmail();
            case 1:
                return email.getSenha();
        }

        return null;

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Email";
            case 1:
                return "Senha";
        }

        return "";
    }

}
