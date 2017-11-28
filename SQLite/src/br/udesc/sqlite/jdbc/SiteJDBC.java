package br.udesc.sqlite.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.udesc.sqlite.modelo.Site;
import br.udesc.sqlite.util.SQLite;

public class SiteJDBC {

    public void inserir(Site site) {
        Connection c = null;
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            String sql = "INSERT INTO site (url) "
                    + "VALUES ('" + site.getUrl() + "');";
            System.out.println(sql);
            declaracao.executeUpdate(sql);
            declaracao.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Criado com sucesso");
    }

    public boolean deletar(int id) {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            return declaracao.executeUpdate("DELETE FROM site WHERE id = " + id + ";") > 0;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    public Site encontrar(int id) {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            ResultSet rs = declaracao.executeQuery("SELECT * FROM site WHERE id = " + id + ";");
            Site e = null;
            while (rs.next()) {
                int i = rs.getInt("id");
                String url = rs.getString("url");
                e = new Site();
                e.getId();
                e.getUrl();
            }
            rs.close();
            declaracao.close();
            return e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    public List<Site> listar() {
        Connection c = SQLite.iniciarConexao();
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            ResultSet rs = declaracao.executeQuery("SELECT * FROM site;");
            List<Site> sites = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String url = rs.getString("email");
                Site e = new Site();
                e.setId(id);
                e.setUrl(url);
                sites.add(e);
            }
            rs.close();
            declaracao.close();
            return sites;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    public boolean atualizar(Site site) {
        Connection c = null;
        Statement declaracao = null;
        try {
            c = SQLite.iniciarConexao();
            declaracao = c.createStatement();
            String sql = "UPDATE SCHEDULE SET "
                    + "url = '" + site.getUrl() + "'"
                    + "WHERE id = " + site.getId() + ";";
            return declaracao.executeUpdate(sql) > 0;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }
}
