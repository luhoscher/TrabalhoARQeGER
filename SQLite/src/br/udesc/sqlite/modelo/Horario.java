package br.udesc.sqlite.modelo;

import java.util.Date;

public class Horario {

    private int id;
    private Date data;

    public Horario() {
    }

    public Horario(int id, Date data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
