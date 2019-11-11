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

4.REQUISITOS
