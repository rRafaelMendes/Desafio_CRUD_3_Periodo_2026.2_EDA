# Gerenciador de Tarefas — CRUD em Java

Projeto acadêmico do 3º período (2026.2), com uma aplicação de terminal para gerenciar tarefas. Implementa as quatro operações de um CRUD: criar, listar, atualizar e remover registros.

## Características

- Interface de terminal com menu em português.
- Cadastro de tarefas com título e descrição.
- IDs numéricos gerados automaticamente a partir de 1.
- Registro automático da data de criação.
- Listagem com título, descrição, data, ID e situação de conclusão.
- Atualização de título, descrição e situação de conclusão pelo ID.
- Remoção de tarefas pelo ID.
- Armazenamento em memória usando `ArrayList`, sem banco de dados ou dependências externas.

As tarefas começam como não concluídas. Os dados existem somente durante a execução: ao encerrar o programa, as tarefas são perdidas e a contagem de IDs reinicia na próxima execução.

## Estrutura do projeto

```text
src/br/edu/aesa/
├── app/
│   └── AppToDoList.java    # Menu e interação com o usuário
├── model/
│   └── Tarefa.java         # Dados de uma tarefa
└── service/
    └── TarefaServico.java  # Operações de criação, listagem, atualização e remoção
```

## Requisitos

- JDK 26, versão usada para validar os comandos abaixo.
- Terminal com suporte a UTF-8 para exibir os acentos corretamente.
- Git, caso queira clonar o repositório.

A classe principal utiliza `static void main()` sem parâmetros. Use o JDK indicado para executar o código como está.

## Como executar

### Pelo terminal

Clone o repositório e acesse a pasta do projeto:

```bash
git clone https://github.com/rRafaelMendes/Desafio_CRUD_3_Periodo_2026.2_EDA.git
cd Desafio_CRUD_3_Periodo_2026.2_EDA
```

Se já possui o projeto, abra o terminal na pasta raiz. Confira se o JDK está disponível:

```bash
java -version
javac -version
```

Compile os três arquivos e execute a aplicação:

```bash
javac -encoding UTF-8 -d out src/br/edu/aesa/model/Tarefa.java src/br/edu/aesa/service/TarefaServico.java src/br/edu/aesa/app/AppToDoList.java
java -cp out br.edu.aesa.app.AppToDoList
```

### Pelo IntelliJ IDEA

1. Abra a pasta do projeto no IntelliJ IDEA.
2. Configure o SDK do projeto para o JDK 26 e o nível da linguagem compatível.
3. Se necessário, marque a pasta `src` como **Sources Root**.
4. Abra `src/br/edu/aesa/app/AppToDoList.java` e execute o método `main`.
5. Utilize o menu no console de execução da IDE.

## Como utilizar

Ao iniciar, o programa apresenta este menu:

```text
****** GERENCIADOR DE TAREFAS ******
1 - CRIAR TAREFA
2 - LISTAR TAREFAS
3 - ATUALIZAR TAREFA
4 - REMOVER TAREFA
5 - SAIR
```

| Opção | Uso |
| --- | --- |
| `1` | Informe o título e a descrição para cadastrar uma tarefa. |
| `2` | Veja todas as tarefas e seus IDs. Se a lista estiver vazia, o programa informa que não há tarefas agendadas. |
| `3` | Informe o ID, o novo título, a nova descrição e se a tarefa foi concluída. Pressione apenas Enter no título ou na descrição para manter o valor atual. |
| `4` | Informe o ID da tarefa que deseja remover. A remoção ocorre imediatamente. |
| `5` | Encerre a aplicação. |

Na atualização, responda `sim`, `não` ou `nao` para definir a conclusão. A resposta aceita letras maiúsculas ou minúsculas; respostas diferentes fazem o programa perguntar novamente. Se o ID não existir, a atualização ou remoção informa que a tarefa não foi encontrada.

### Exemplo de uso

1. Escolha `1`, digite o título `Estudar Java` e a descrição `Revisar listas e classes`.
2. Escolha `2` para consultar a tarefa e seu ID, que será `1` se for o primeiro cadastro da execução.
3. Escolha `3` e informe o ID `1`. Pressione Enter nos campos de título e descrição e responda `sim` para marcar a tarefa como concluída.
4. Escolha `2` para conferir a alteração.
5. Escolha `4` e informe o ID `1` para remover a tarefa, ou `5` para sair.

## Limitações atuais

- Não há persistência em arquivos ou banco de dados.
- O cadastro não valida título e descrição vazios.
- Digite números nas opções do menu e nos IDs: entradas não numéricas nesses campos podem encerrar o programa com erro.
- Não há confirmação antes da remoção nem opção para desfazê-la.
