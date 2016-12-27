Aplicação utiliza java 8

Estando dentre da pasta do projeto.

Para rodar a teste, basta executar o mars-rovers.jar que se encontra na raiz do projeto
Exemplo:
java -jar mars-rovers.jar

1) Iria solicitar para que "Informe a cordenada maxima de X e Y:"
Exemplo:
5 5 
Obs. Tem de ser separados por espaço.

2) Após isso ira solicitar que "Informe o posicionamento de X e Y e a orietanção do rover"
Exemplo:
1 2 N
Obs. Estes campos também deveram esta separados por espaço

3) Após o posicionamento será solicitado para que "Informe a movimentação do rover"
Exemplo:
LMLMLMLMM
Obs. Estes campos não deveram conter espaço.

4) Para filizar irá perguntar se "Cadastrar novo rover (s/n)"
Caso "S" ira cadastrar um novo Rover seguindo novamente para o passo 2, 3 e 4.
Caso "N" finaliza o processo de cadastro e mostra o posicionamento final dos rovers cadastrados.

Para fazer os testes unitários basta execultar o mars-rovers-teste.jar
Exemplo:
java -jar mars-rovers-teste.jar