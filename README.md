📚 Sistema de Gestão Acadêmica






📖 Sobre o projeto

O Sistema de Gestão Acadêmica é uma aplicação desenvolvida em Java com interface via terminal (CLI), voltada para o gerenciamento de instituições de ensino.

O sistema permite o controle de alunos e turmas, incluindo operações de cadastro, atualização, remoção e consulta, além da visualização de alunos por turma.

O projeto foi desenvolvido utilizando o arquétipo maven-archetype-quickstart e segue o padrão arquitetural DAO (Data Access Object), garantindo uma separação clara entre lógica de negócio e acesso a dados.

🚀 Funcionalidades
👨‍🎓 Alunos
Cadastrar aluno
Atualizar dados do aluno
Remover aluno
Listar todos os alunos
Buscar aluno por ID
🏫 Turmas
Listar todas as turmas cadastradas
Visualizar alunos matriculados por turma
🧱 Tecnologias utilizadas
Java (17+)
Maven
JDBC
Banco de dados relacional
Padrão de projeto DAO
Aplicação via console (CLI)
🏗️ Arquitetura do projeto

O sistema foi estruturado em camadas para melhor organização e manutenção:

model → Entidades do sistema (Aluno, Turma)
daoImplements → Implementação do acesso ao banco de dados
database → Configuração e conexão com o banco (sqlConn)
App → Interface principal via menu no terminal
📁 Estrutura do projeto
src/
 └── main/
     └── java/
         └── org/example/
             ├── App.java
             ├── model/
             │    ├── Aluno.java
             │    ├── Turma.java
             │
             ├── daoImplements/
             │    ├── AlunoDAOImplements.java
             │    ├── TurmaDAOImplements.java
             │
             ├── database/
             │    ├── sqlConn.java
▶️ Como executar o projeto
1. Clonar o repositório
git clone <url-do-repositorio>
2. Acessar o diretório
cd nome-do-projeto
3. Compilar o projeto com Maven
mvn clean install
4. Executar a aplicação
mvn exec:java -Dexec.mainClass="org.example.App"
🖥️ Funcionamento da aplicação

A aplicação é baseada em um menu interativo via terminal, permitindo a navegação entre as funcionalidades:

======= MENU ========
1. Cadastrar Aluno
2. Atualizar Aluno
3. Excluir Aluno
4. Listar Alunos
5. Listar Aluno por ID
6. Listar Turmas e Alunos
0. Sair do programa
🗄️ Banco de dados

A conexão com o banco é gerenciada pela classe:

database.sqlConn
Configurações necessárias:
URL do banco de dados
Usuário
Senha
Driver JDBC
📌 Conceitos aplicados
Programação Orientada a Objetos (POO)
Padrão de projeto DAO
Separação de responsabilidades (arquitetura em camadas)
Manipulação de banco de dados com JDBC
Validação de entrada de dados
Menu interativo via console
⚠️ Observações
A aplicação roda em modo console (CLI)
É necessário banco de dados configurado para funcionamento completo
Datas seguem o padrão dd/MM/yyyy

👨‍💻 Autor : Vinicius de Melo Silva

Projeto desenvolvido para fins acadêmicos, com foco em:

Java
Banco de dados relacional
Arquitetura DAO
Boas práticas de programação orientada a objetos
⭐ Possíveis melhorias futuras
Interface gráfica (JavaFX ou Swing)
Migração para Spring Boot
API REST
Autenticação de usuários
Paginação e filtros avançados
Testes unitários
