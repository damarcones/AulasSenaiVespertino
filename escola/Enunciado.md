# Enunciado

Criar uma aplicação Spring referente a um ambiente escolar, onde acontecerá o cadastro de diversos alunos com as seguintes informações: Nome, idade, sexo, matricula, turma e turno, e, além dessas informações, será necessário armazenar as quatro notas referente a cada bimestre do ano de cinco disciplinas diferentes (Matemática, Português, História, Geografia e Ciências) e apresentar por meio de um request se o aluno foi aprovado, reprovado ou está de recuperação (Média >= 6 aprovado, Média entre 5 e 5.9 de "Recuperação", Média < 5 reprovado). Todas as informações devem ser recuperadas mesmo encerrando o programa.

## Dicas para iniciar
- Pensar nas dependências básicas
- Configurar o arquivo ` application.properties ` para o Hibernate e MySQL (Exemplo de arquivo no projeto API)
- Pensar em como criar os atributos da classe e como ficarão armazenados no banco (É possível expecificar o nome de cada coluna por atributo)
- Como relacionar os alunos com as notas de cada disciplina?
- Quais os tipos de endpoint irão utilizar?
- Como buscar cada informação de retorno do endpoints?
- Como disponibilizar cada informação para um endpoint do tipo `Get`?
