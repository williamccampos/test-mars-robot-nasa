
## Robô em Marte

Projeto desenvolvido com o intuito de mostrar alguns padrões com Spring Boot como
MVC (Model, View, Controller), conceitos de HTTP e teste unitário.

## Contexto:

Um time de robôs devem ser colocados pela NASA para explorar um terreno em Marte. Esse terreno, que é retangular, precisa ser navegado pelos robôs de tal forma que suas câmeras acopladas possam obter uma visão completa da região, enviando essas imagens novamente para a Terra.

# Build & Run:

O projeto está simples e fácil de ser utilizado para testes.

O primeiro passo é fazer o clone do projeto:

* `https://github.com/williamccampos/test-mars-robot-nasa.git`

Abra o Spring Tools ou a IDE de sua escolha e rode o `MarsRobotApplication.class`
Após o projeto estar rodando localmente, verifique a porta local do projeto
Abra um terminal e execute os comandos abaixo para teste:

`Movimento de rotação para a direita`
* `curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM`
Saída esperada: `(2, 0, S)`

`Movimento de rotação para a esquerda`
* `curl -s --request POST http://localhost:8080/rest/mars/MML`
Saída esperada: `(0, 2, W)`

`Repetição de rotação para a esquerda`
* `curl -s --request POST http://localhost:8080/rest/mars/MML`
Saída esperada: `(0, 2, W)`

`Comando inválido:`
* `curl -s --request POST http://localhost:8080/rest/mars/AAA` 
Saída esperada: `400 Bad Request`

`Posição inválida:`
* `curl -s --request POST http://localhost:8080/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM`
Saída esperada: `400 Bad Request`

# Teste unitário (Mockito):

Foi criado um teste unitário para uma requisição de sucesso e uma de bad request
Se quiser, pode rodar o `MarsRobotControllerTest.class` diretamente sem compilar o projeto
que ele fará os dois cenários de teste.
