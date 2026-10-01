package br.edu.aesa.model;

import java.time.LocalDate;


public class Tarefa {
    private Long Id;
    private String Titulo;
    private String Descricao;
    private boolean Concluida;
    private final LocalDate DataAgora;

    public Tarefa(Long Id, String Titulo, String Descricao, boolean Concluida){
        this.Id = Id;
        this.Titulo = Titulo;
        this.Descricao = Descricao;
        this.Concluida = Concluida;
        this.DataAgora = LocalDate.now();
    }
    //Getters e Setters

    //Get Id;
    public Long getId () {
        return Id;
    }

    //Get Titulo
    public String getTitulo() {
        return Titulo;
    }
    //Set Titulo
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    //Get Descrição
    public String getDescricao() {
        return Descricao;
    }
    //Set Descrição
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    //Get DataAgora
    public LocalDate getDataAgora() {
        return DataAgora;
    }
    
    //Get Concluída
    public boolean isConcluida() {
        return Concluida;
    }
    //Set Concluída
    public void setConcluida(boolean Concluida) {
        this.Concluida = Concluida;
    }


    @Override
    public String toString(){return (Concluida ? "[X] " : "[ ] ") + Titulo;
    }
}
