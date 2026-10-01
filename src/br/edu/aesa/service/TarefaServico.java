package br.edu.aesa.service;


import java.util.List;
import br.edu.aesa.model.Tarefa;
import java.util.ArrayList;

public class TarefaServico {
    private List<Tarefa> tarefas = new ArrayList<>();
    private Long contadorId = 1L;

    //Criar Tarefas
    public Tarefa criarTarefas(String Titulo, String Descricao){

        //Método Contrutor da classe tarefa

        Tarefa tarefa = new Tarefa(contadorId++, Titulo, Descricao, false);
        tarefas.add(tarefa);
        return tarefa;
    }
    //Listar todas as Tarefas
    public List<Tarefa> listTarefas(){
        return tarefas;
    }

    public boolean atualizarTarefa(Long id, String novoTitulo, String novaDescricao, boolean concluida) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {

                // Atualiza o título somente se algo foi informado.
                if (novoTitulo != null && !novoTitulo.isBlank()) {
                    tarefa.setTitulo(novoTitulo);
                }

                // Atualiza a descrição somente se algo foi informado.
                if (novaDescricao != null && !novaDescricao.isBlank()) {
                    tarefa.setDescricao(novaDescricao);
                }

                tarefa.setConcluida(concluida);
                return true;
            }
        }

        return false;
    }
    public boolean deletarTarefa(Long Id){
        for (int i = 0; i < tarefas.size(); i++){
            Tarefa tarefa = tarefas.get(i);
            if(tarefa.getId().equals(Id)){
                tarefas.remove(i);
                return true;
            }
        }
        return false;
    }

}

