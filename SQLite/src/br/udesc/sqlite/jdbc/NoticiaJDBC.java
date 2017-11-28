package br.udesc.sqlite.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.udesc.sqlite.modelo.Noticia;
import br.udesc.sqlite.util.SQLite;

public class NoticiaJDBC {

    public void inserir(Noticia not) {
        Connection c = null;
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String sql = "INSERT INTO NOTICIA (url, titulo, data) "
                    + "VALUES ('" + not.getUrl() + "', '" + not.getTitulo() + "', " + sdf.format(not.getData()) + "');";
            declaracao.executeUpdate(sql);
            declaracao.close();
            System.out.println("Criado com sucesso");
        } catch (Exception e) {
            System.out.println("Noticia não inserida: ");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }

    }

    public List<Noticia> listar() {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            ResultSet rs = declaracao.executeQuery("SELECT * FROM noticia;");
            List<Noticia> noticia = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String url = rs.getString("url");
                String titulo = rs.getString("titulo");
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date data = df.parse(rs.getString("data"));
                Noticia n = new Noticia();
                n.setId(id);
                n.setUrl(url);
                n.setTitulo(titulo);
                n.setData(data);
                noticia.add(n);
            }
            rs.close();
            declaracao.close();
            return noticia;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    public Noticia ultimaNoticia(int id) {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        Noticia n = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            ResultSet rs = declaracao.executeQuery("SELECT * FROM noticia WHERE id = " + id + " ORDER BY data DESC LIMIT 1;");
            while (rs.next()) {
                int i = rs.getInt("id");
                String url = rs.getString("url");
                String titulo = rs.getString("titulo");
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date data = df.parse(rs.getString("data"));
                n = new Noticia();
                n.setId(i);
                n.setUrl(url);
                n.setTitulo(titulo);
                n.setData(data);
            }
            rs.close();
            declaracao.close();
            return n;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    public boolean noticiaJaExiste(String titulo) {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        Noticia n = null;
        int i = 0;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            ResultSet rs = declaracao.executeQuery("SELECT EXISTS(SELECT 1  FROM noticia   WHERE titulo ='" + titulo + "'  LIMIT 1)");
            while (rs.next()) {
                i = rs.getByte(1);
            }
            rs.close();
            declaracao.close();
            if (i == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

}
