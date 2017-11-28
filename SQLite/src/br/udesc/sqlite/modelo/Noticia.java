package br.udesc.sqlite.modelo;

import java.util.Date;

public class Noticia {

    private int id;
    private String url;
    private String titulo;
    private Date data;

    public Noticia() {
    }

    public Noticia(int id, String url, String titulo, Date data) {
        this.id = id;
        this.url = url;
        this.titulo = titulo;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
