package models;

import java.io.Serializable;

public class Ato implements Serializable {

    public Integer id_ato;
    public String title;
    public String description;

    public Ato() {
    }

    public Ato(Integer id_ato, String title, String description) {
        this.id_ato = id_ato;
        this.title = title;
        this.description = description;
    }

    public Integer getId_ato() {
        return id_ato;
    }

    public void setId_ato(Integer id_ato) {
        this.id_ato = id_ato;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ato "+id_ato+" - Título: "+title+" - Descrição: "+description;
    }
}
