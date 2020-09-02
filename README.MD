# Emprestimos

Prova de conceito para representar o teste enviado pela TQI

# Cenário
Uma empresa de empréstimos precisa atualizar seu sistema de análise de crédito para fornecer aos seus clientes um aplicativo com as seguintes funcionalidades:
i.	Cadastro
ii.	Login
iii.	Solicitação de empréstimo
iv.	Acompanhamento das propostas

# Stack Utilizada
  - API Rest utilizando Spring
  - Spring JPA
  - Spring WEB
  - Banco de dados MySQL

# Modelagem de dados

![Modelagem de dados](der/projeto_TQI.png)

# Motivações

O spring através do spring boot nos permite de forma muito facil de criar um projeto e adicionar suas dependencias. Utilizei o https://start.spring.io para criar o projeto maven e adicionar as dependencias.

Utilizei o design arquitetural MVC para organizar as camadas e os conjuntos de classes.
O pacote resources representando a camada view, o pacote service representando a camada de controller e o pacote model representando a modelagem de dados.

# Problemas não solucionados
Apesar de já ter ouvido que o Spring consegue resolver o problema de Login, eu nunca implementei e não tenho este conhecimento ainda. Mas já estou procurando aprender sobre o Spring Security

# Como testar a aplicação?

Para testar a aplicação iremos utilizar os recursos que foram mapeados para ser acessados pelo protocolo de rede HTTP.

A ferramenta que utilizei para realizar os testes foi o https://www.postman.com/

**1) Para realizar o cadastro será necessário criar os recursos e usuário e cliente**

[POST] http://localhost:8080/usuarios

    {
	    "email": "exemplo@teste.com"
	    "senha": "umasenha"
    }

[POST] http://localhost:8080/clientes

    {
	    "usuario": {"id" : 1},
	    "nome": "Exemplo",
	    "cpf": "000.000.000-88",
	    "dataNascimento": "1999-07-12",
	    "endereco": "Rua Endereço teste, 123"
    }
**2) Solicitação de empréstimo**

[POST] http://localhost:8080/solicitacoes

    {
	    "cliente": {"id": 1},
	    "dataSolicitacao": "2020-09-01",
	    "valor": 200.0,
	    "status": "PENDENTE"
    }

**3) Acompanhamento da solicitação**
  
[GET] http://localhost:8080/solicitacoes/{id}