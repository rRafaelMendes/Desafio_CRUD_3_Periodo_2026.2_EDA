package br.edu.aesa.app;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import br.edu.aesa.model.Tarefa;
import br.edu.aesa.service.TarefaServico;

public class AppToDoList {
    static void main() {
        /*
        * Esse comando evita que
        * acentos e caracteres
        * especiais apareçam cor-
        * rompidas no console do
        *  terminal.
        */
        System.setOut ( new PrintStream(System.out, true, StandardCharsets.UTF_8 ));

        Scanner input = new Scanner(System.in);
        TarefaServico servico = new TarefaServico();

        while(true) {
            System.out.println("\n****** GERENCIADOR DE TAREFAS ******");
            System.out.println("1 - CRIAR TAREFA");
            System.out.println("2 - LISTAR TAREFAS");
            System.out.println("3 - ATUALIZAR TAREFA");
            System.out.println("4 - REMOVER TAREFA");
            System.out.println("5 - SAIR");
            System.out.print("ESCOLHA UMA OPÇÃO \n");

            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {

                case 1 -> {
                    System.out.print("Titulo da Tarefa: ");
                    String titulo = input.nextLine();
                    System.out.print("Descrição da Tarefa: ");
                    String descricao = input.nextLine();
                    Tarefa nova = servico.criarTarefas(titulo, descricao);
                    System.out.println(" Tarefa criada com sucesso! " + nova.getTitulo());
                }
                case 2 -> {
                    List<Tarefa> tarefas = servico.listTarefas();
                    if (tarefas.isEmpty()){
                        System.out.println("Nenhuma tarefa agendada.");
                    }else {
                        System.out.println("****** Lista de Tarefas ******");
                        for(Tarefa t : tarefas){
                            System.out.println("Titulo: " + t.getTitulo());
                            System.out.println("Descrição: " + t.getDescricao());
                            System.out.println("Data da Criação: " + t.getDataAgora());
                            System.out.println("ID: " + t.getId());
                            System.out.println("Concluída: " + (t.isConcluida() ? "Sim" : "Não"));
                            System.out.print("\n");
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Digite o ID da tarefa que deseja atualizar: ");
                    Long id = input.nextLong();
                    input.nextLine();



                    System.out.print("Novo título (Pressione 1Enter para manter o atual): ");
                    String novoTitulo = input.nextLine();
                    System.out.print("Nova descrição (Pressione Enter para manter a atual): ");
                    String novaDescricao = input.nextLine();
                    boolean concluida;

                    while (true) {
                        System.out.print("A tarefa foi concluída? (sim/não): ");
                        String resposta = input.nextLine().trim();

                        if (resposta.equalsIgnoreCase("sim")) {
                            concluida = true;
                            break;
                        } else if (resposta.equalsIgnoreCase("não")
                                || resposta.equalsIgnoreCase("nao")) {
                            concluida = false;
                            break;
                        } else {
                            System.out.println("Resposta inválida. Digite sim ou não.");
                        }
                    }

                    boolean atualizado = servico.atualizarTarefa(id, novoTitulo, novaDescricao, concluida);

                    if (atualizado) {
                        System.out.println("Tarefa Atualizada com sucesso!");
                    }else {
                        System.out.println("Tarefa não encontrada. ");
                    }

                }
                case 4 -> {
                    System.out.print("Digite o ID da tarefa que deseja deletar: ");
                    Long id = input.nextLong();
                    input.nextLine();
                    boolean deletado = servico.deletarTarefa(id);
                    if (deletado) {
                        System.out.println("Tarefa deletada com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                }
                case 5 -> {
                    System.out.print("Encerrando aplicação");
                    input.close();
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
