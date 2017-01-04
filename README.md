# xy-inc
Projeto Java do Zup Backend as a Service

O projeto foi construído e testado usando o OS windows 7 Home Premiun

# Descrição da arquitetura
A arquitetura montada tem como objetivo somente a responder às requisições REST.
As respostas às requisições são no formato JSON.
Tecnologias utilizadas:
- Java 1.8.0_111
- Especificação REST JAX-RS 1.1.1
- Implementação REST Jersey 1.8
- Container Java EE Tomcat 8.5.9
- Maven
Para os testes:
- JUnit 4.12
- Rest Assure para rodar os testes de unidade


# Preparação do ambiente de para execução do projeto
- Baixar o tomcat 8.5.9 (zip) em http://tomcat.apache.org/download-80.cgi#8.5.9
- Baixar o eclipse jee-neon disponível em https://eclipse.org/downloads/
  Baixar o eclipse for Java EE developers

Após instalar o eclipse e o tomcat, abra o eclipse, em server, adicione o tomcat.

- Baixe o projeto do github para uma workspace do eclipse; 
- Abra o eclipse e import o projeto "zupbackend" como "Existing Maven Projects";
- Adicone o projeto no tomcat e inicie o tomcat;
- Após o tomcat subir, acesse http://localhost:8080/zup-backend tela inicial da aplicação;

# Passos para testar os serviços REST
- @POST Listar todos os produtos: 
http://localhost:8080/zup-backend/rest/produto/listar

- @GET Buscar produto por id: (ids válidos 1 a 7)
http://localhost:8080/zup-backend/rest/produto/buscar/5

- @POST Adicionar produto
Acesse http://localhost:8080/zup-backend/ e clique em "Cadastrar produto";
Preencha os dados e clique em adicionar

- @PUT Adicione a extensão abaixo no chrome
https://chrome.google.com/webstore/detail/rest-web-service-client/ecjfcmddigpdlehfhdnnnhfgihkmejin
Após instalar, clique no ícone da extensão instalada;
Em "Accept", application/json;
Em "Method", mude para PUT;
Em "URL", insira a url http://localhost:8080/zup-backend/rest/produto/alterar;
Em Body, insira o JSON de um produto, exemplo {"id":7,"descricao":"iPad mini","nome":"iPad","valor":2300.0}
Clique em SEND. Para ver o retorno clique em "Response (Formatted)"

- @DELETE Para testar, utilize a extensão instalada anteriormente
Remove o produto por id
Em "Accept", text/plain;
Em "Method", mude para DELETE;
Em "URL", insira a url http://localhost:8080/zup-backend/rest/produto/remover/3
Clique em SEND. Para ver o retorno clique em "Response (Raw)"

# Passos para rodar os testes de unidade
Para rodar os testes de unidade com JUnit:
- Suba o tomcate no eclipse;
- Execute os testes via JUnit na classe ProdutoWSTest.java

# Observação
Por ser um projeto com maven, após importar o projeto no eclipse, pode ser que seja necessário executar maven clean e maven install, 
para baixar e instalar as dependências


