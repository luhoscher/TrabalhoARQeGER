
package br.udesc.modulo1.controle;


import br.udesc.argc.persistence.model.News;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nandoborguesan
 */
public class NovasTabelas extends AbstractTableModel {

    private List<News> news;
    private NewsDAO dao;

    public NovasTabelas() {
        dao = FactoryDAO.getPersistence().getNewsDAO();
        news = dao.list();
    }

    @Override
    public int getRowCount() {
        return news.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        News s = news.get(rowIndex);
        switch (columnIndex) {
            case 0: {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
                return sdf.format(s.getDate());
            }
            case 1: {
                return s.getTitle();
            }
            case 2: {
                return s.getUrl();
            }

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: {
                return "Date";
            }
            case 1: {
                return "Title";
            }
            case 2: {
                return "URL";
            }

        }
        return null;
    }

    public News getNews(int index) {
        return news.get(index);
    }

    public void update() {
        news = dao.list();
        fireTableDataChanged();
    }

}
