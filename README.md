Trabalho de Implementação
TRABALHO 01: Trabalho do Semestre
Objetivo: Desenvolver aplicações avançadas de manipulação de arquivos usando uma linguagem real (Java).

Sumário
1. COMPONENTES
Integrantes do grupo
Rodrigo Souza Tassoni
Lucas Dolsan

2.DESCRIÇÃO DO TRABALHO

O projeto para interpretar os comandos (udescdb) e o esquema do XML do RNF4 (udescdb.xsd) estão no Moodle. Pela
descrição acima, podemos concluir que o trabalho da dupla é desenvolver uma parte de um BD Relacional utilizando
arquivos de acesso aleatório. O projeto já utiliza a biblioteca AntLR. Existe um exemplo de código na classe Teste que
consegue enviar os três tipos de comandos (create, insert e select) e apresenta na console as informações extraídas
desses comandos. A extração está exemplicada na classe SQLiteBaseListener com impressões para console. A equipe
pode aproveitar esses pontos para armazenar todas as informações necessárias (tipo de comando, nome do banco de
dados, da tabela, etc) para depois executar o comando. Logo, se sugere que a classe SQLiteBaseListener seja utilizada
apenas para extrair os dados. Ainda, sugiro que cada um dos três comandos seja implementado em uma classe distinta.

3.MINI-MUNDO
Descrever o mini-mundo! (Não deve ser maior do que 30 linhas)
Entrevista com o usuário e identificação dos requisitos.
Descrição textual das regras de negócio definidas como um subconjunto do mundo real cujos elementos são propriedades que desejamos incluir, processar, armazenar, gerenciar, atualizar, e que descrevem a proposta/solução a ser desenvolvida.

O sistema proposto para a "Devcom Projetos conterá as informacões aqui detalhadas. Dos Projetos serão armazenados o número, nome e cidade. Dos Departamentos serão armazenados o número e nome. O cliente destacou que cada projeto pode ter vários departamentos auxiliando no seu desenvolvimento, e cada departamento pode estar envolvido em vários projetos. Os dados relativos aos empregados que serão armazenados são: rg, nome, cpf, salário, data inicial do salario e supervisor de cada empregado. É importante destacar que cada empregado pode ser supervisionado por outro empregado, e obrigatoriamente deve estar alocado a um único departamento, mas pode gerenciar vários departamentos ou não gerenciar nenhum. Um empregado também pode participar de vários projetos, caso seja necessário, mas não precisa obrigatoriamente estar alocado em algum projeto. Com relação aos dependentes serão armazenadas as informações de nome do dependente, data de nascimento, sexo e grau de parentesco. Cada empregado pode ter vários dependentes, mas um dependente esta associado apenas a um único empregado. Com relação ao histórico de salário devemos armazenar as informações de valor do salário, data de início do salário no período e data final do salário no período. É importante lembrar que cada funcionario pode ter diversos eventos de histórico de salário associados a ele visto que este dado pode ser alterado várias vezes.

4.RASCUNHOS BÁSICOS DA INTERFACE (MOCKUPS)
Neste ponto a codificação não e necessária, somente as ideias de telas devem ser criadas, o princípio aqui é pensar na criação da interface para identificar possíveis informações a serem armazenadas ou descartadas

Sugestão: https://balsamiq.com/products/mockups/

Alt text Arquivo PDF do Protótipo Balsamiq feito para Empresa Devcom

4.1 QUAIS PERGUNTAS PODEM SER RESPONDIDAS COM O SISTEMA PROPOSTO?
a) O sistema proposto poderá fornecer quais tipos de relatórios e informaçes? 
b) Crie uma lista com os 5 principais relatórios que poderão ser obtidos por meio do sistema proposto!
A Empresa DevCom precisa inicialmente dos seguintes relatórios:

Relatório que informe quais são os gerentes de cada departamento incluindo as seguintes informações: número do departamento, nome do departamento, e nome do gerente.
Relatório de empregados por projeto incluindo as seguintes informações: número do projeto, nome do projeto, rg do empregado, nome do empregado e quantidade de horas de trabalho do empregado alocadas ao projeto.
Relatório de empregados com dependentes incluindo as seguintes informações: rg do empregado, nome do empregado, nome do dependente, tipo de relação, data de nascimento do dependente e sexo do dependente.
Relatório com a quantidade de empregados por cada departamento incluindo as seguintes informações: nome do departamento, supervisor e quantidade de empregados alocados no departamento.
Relatório de supervisores e supervisionados incluindo as seguintes informações: nome do supervisor e nome do supervisionado.
4.2 TABELA DE DADOS DO SISTEMA:
a) Esta tabela deve conter todos os atributos do sistema e um mínimo de 10 linhas/registros de dados.
b) Esta tabela tem a intenção de simular um relatório com todos os dados que serão armazenados 
e deve ser criada antes do modelo conceitual
c) Após criada esta tabela não deve ser modificada, pois será comparada com os resultados finais na conclusão do trabalho
Exemplo de Tabela de dados da Empresa Devcom

Marco de Entrega 01 em:
5.MODELO CONCEITUAL
A) NOTACAO ENTIDADE RELACIONAMENTO 
    * Para nosso prótótipo limitaremos o modelo conceitual nas 6 principais entidades do escopo
    * O protótipo deve possui no mínimo duas relações N para N
    * o mínimo de entidades do modelo conceitual será igual a 5
Alt text

B) NOTACAO UML (Caso esteja fazendo a disciplina de analise)
C) QUALIDADE 
    Garantir que a semântica dos atributos seja clara no esquema
    Criar o esquema de forma a garantir a redução de informação redundante, possibilidade de valores null, 
    e tuplas falsas
5.1 Validação do Modelo Conceitual
[Grupo01]: [Nomes dos que participaram na avaliação]
[Grupo02]: [Nomes dos que participaram na avaliação]
5.2 DECISÕES DE PROJETO
[atributo]: [descrição da decisão]

EXEMPLO:
a) Campo endereço: em nosso projeto optamos por um campo multivalorado e composto, pois a empresa 
pode possuir para cada departamento mais de uma localização... 
b) justifique!
Marco de Entrega 02 em: (30/04/2019)
5.3 DESCRIÇÃO DOS DADOS
[objeto]: [descrição do objeto]

EXEMPLO:
CLIENTE: Tabela que armazena as informações relativas ao cliente<br>
CPF: campo que armazena o número de Cadastro de Pessoa Física para cada cliente da empresa.<br>
6 MODELO LÓGICO
    a) inclusão do modelo lógico do banco de dados
    b) verificação de correspondencia com o modelo conceitual 
    (não serão aceitos modelos que não estejam em conformidade)
7 MODELO FÍSICO
    a) inclusão das instruções de criacão das estruturas DDL 
    (criação de tabelas, alterações, etc..) 
Marco de Entrega 03 em: (06/05/2019)
8 INSERT APLICADO NAS TABELAS DO BANCO DE DADOS
8.1 DETALHAMENTO DAS INFORMAÇÕES
    a) inclusão das instruções de inserção dos dados nas tabelas criadas pelo script de modelo físico 
    b) formato .SQL
Marco de Entrega 04 em: (07/05/2019)
8.2 INCLUSÃO DO SCRIPT PARA CRIAÇÃO DE TABELAS E INSERÇÃO DOS DADOS
    a) Junção dos scripts anteriores em um único script 
    (create para tabelas e estruturas de dados + dados a serem inseridos)
    b) Criar um novo banco de dados para testar a restauracao 
    (em caso de falha na restauração o grupo não pontuará neste quesito)
    c) formato .SQL
8.3 INCLUSÃO DO SCRIPT PARA EXCLUSÃO DE TABELAS EXISTENTES, CRIAÇÃO DE TABELA NOVAS E INSERÇÃO DOS DADOS
    a) Junção dos scripts anteriores em um único script
    (Drop para exclusão de tabelas + create para tabelas e estruturas de dados + dados a serem inseridos)
    b) Criar um novo banco de dados para testar a restauracao 
    (em caso de falha na restauração o grupo não pontuará neste quesito)
    c) formato .SQL
8.4 Principais fluxos de informação e principais tabelas do sistema
    a) Quais os principais fluxos de dados de informação no sistema em densenvolvimento (mínimo 3)
    b) Quais as tabelas que conterão mais dados no sistema em densenvolvimento (mínimo 3)
    c) informe quais as 5 principais tabelas do sistema em densenvolvimento.
Marco de Entrega 05 em: (13/05/2019)
9 TABELAS E PRINCIPAIS CONSULTAS
OBS: Incluir para cada tópico as instruções SQL + imagens (print da tela) mostrando os resultados.<br>
9.1 CONSULTAS DAS TABELAS COM TODOS OS DADOS INSERIDOS (Todas)
9.2 CONSULTAS DAS TABELAS COM FILTROS WHERE (Mínimo 4)
Marco de Entrega 06 em: (14/05/2019)
9.3 CONSULTAS QUE USAM OPERADORES LÓGICOS, ARITMÉTICOS E TABELAS OU CAMPOS RENOMEADOS (Mínimo 11)
a) Criar 5 consultas que envolvam os operadores lógicos AND, OR e Not
b) Criar no mínimo 3 consultas com operadores aritméticos 
c) Criar no mínimo 3 consultas com operação de renomear nomes de campos ou tabelas
9.4 CONSULTAS QUE USAM OPERADORES LIKE E DATAS (Mínimo 12)
a) Criar outras 5 consultas que envolvam like ou ilike
b) Criar uma consulta para cada tipo de função data apresentada.
9.5 ATUALIZAÇÃO E EXCLUSÃO DE DADOS (Mínimo 6)
Marco de Entrega 07 em: (20/05/2019)
9.6 CONSULTAS COM JUNÇÃO E ORDENAÇÃO (Mínimo 6)
    a) Uma junção que envolva todas as tabelas possuindo no mínimo 3 registros no resultado
    b) Outras junções que o grupo considere como sendo as de principal importância para o trabalho
Marco de Entrega 08 em: (21/05/2019)
9.7 CONSULTAS COM GROUP BY E FUNÇÕES DE AGRUPAMENTO (Mínimo 6)
9.8 CONSULTAS COM LEFT E RIGHT JOIN (Mínimo 4)
9.9 CONSULTAS COM SELF JOIN E VIEW (Mínimo 6)
    a) Uma junção que envolva Self Join
    b) Outras junções com views que o grupo considere como sendo de relevante importância para o trabalho
Marco de Entrega 09 em: (27/05/2019)
9.10 SUBCONSULTAS (Mínimo 3)
Marco de Entrega 10 em: (28/05/2019)
9.11 Relatórios e Gráficos
a)análises e resultados provenientes do banco de dados
Marco de Entrega 11 em: (04/06/2019)
10 ATUALIZAÇÃO DA DOCUMENTAÇÃO DOS SLIDES PARA APRESENTAÇAO FINAL (Mínimo 6 e Máximo 10)
a) Pontos Chave do MINI-MUNDO
b) 5 principais tabelas/fluxos do sistema
c) Perguntas que podem ser respondidads com o sistema proposto
d) Modelo Conceitual
e) Modelo Lógico
f) Relatórios e Gráficos mais importantes para o sistema (mínimo 5)
--> Tempo de apresentação 10 minutos
11 Backup completo do banco de dados postgres
a) deve ser realizado no formato "backup" 
    (Em Dump Options #1 Habilitar opções Don't Save Owner e Privilege)
b) antes de postar o arquivo no git o mesmo deve ser testado/restaurado por outro grupo de alunos/dupla
c) informar aqui o grupo de alunos/dupla que realizou o teste.
12 TUTORIAL COMPLETO DE PASSOS PARA RESTAURACAO DO BANCO E EXECUCAO DE PROCEDIMENTOS ENVOLVIDOS NO TRABALHO PARA OBTENÇÃO DOS RESULTADOS
    a) Outros grupos deverão ser capazes de restaurar o banco 
    b) executar todas as consultas presentes no trabalho
    c) executar códigos que tenham sido construídos para o trabalho 
    d) realizar qualquer procedimento executado pelo grupo que desenvolveu o trabalho
13 DIFICULDADES ENCONTRADAS PELO GRUPO
Marco de Entrega Final em: 11/06/2019
14 FORMATACAO NO GIT: https://help.github.com/articles/basic-writing-and-formatting-syntax/
About Formatting
https://help.github.com/articles/about-writing-and-formatting-on-github/
Basic Formatting in Git
https://help.github.com/articles/basic-writing-and-formatting-syntax/#referencing-issues-and-pull-requests
Working with advanced formatting
https://help.github.com/articles/working-with-advanced-formatting/
Mastering Markdown
https://guides.github.com/features/mastering-markdown/
OBSERVAÇÕES IMPORTANTES
Todos os arquivos que fazem parte do projeto (Imagens, pdfs, arquivos fonte, etc..), devem estar presentes no GIT. Os arquivos do projeto vigente não devem ser armazenados em quaisquer outras plataformas.
Caso existam arquivos com conteúdos sigilosos, comunicar o professor que definirá em conjunto com o grupo a melhor forma de armazenamento do arquivo.
Todos os grupos deverão fazer Fork deste repositório e dar permissões administrativas ao usuário do git "profmoisesomena", para acompanhamento do trabalho.
Os usuários criados no GIT devem possuir o nome de identificação do aluno (não serão aceitos nomes como Eu123, meuprojeto, pro456, etc). Em caso de dúvida comunicar o professor.
Link para BrModelo:
http://www.sis4.com/brModelo/download.html

Link para curso de GIT
https://www.youtube.com/curso_git
