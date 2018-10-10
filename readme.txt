Apps Club

Um serviço de assinatura, onde o usuário paga um pequeno valor recorrente para utilizar centenas de apps que, se comprados individualmente, custariam milhares e milhares de reais. O assinante paga o valor direto na conta de telefone da operadora, sem precisar de cartão de crédito.

O serviço foi desenvolvido utilizando Spring Boot (e seus pacotes de apoio a formatação do tráfego de dados de serviços REST) e Spring Security, JPA e Hibernate. Para armazenamento dos dados, foi utilizado o banco MySQL.

A base de dados foi construída levando-se em consideração que uma operadora (tabela Operator) pode oferecer vários aplicativos (tabela Application) aos seus clientes, sendo esses aplicativos agrupados em N pacotes (PackTypes). Todos esses dados estão relacionados entre si na tabela OperatorPackApp.

Seguem os endpoints disponibilizados nesta versão:

## Listar todos os aplicativos por país [/rest/apps/country={country}]

## Listar aplicativo pelo nome [/rest/apps/name={name}]

## Listar todos os aplicativos pelo nome do pacote e país [/rest/apps/packname={packname}&country={country}]
        
## Listar todos os aplicativos [/rest/apps]

## Listar todos pacotes por operadora e nome do pacote [/rest/apppack/operator={operator}&pack={pack}]
        
## Listar todos pacotes por país [/rest/apppack/country={country}]
    
## Listar operadora por identificador [/rest/operators/name={name}]

## Listar todas as operadoras [/rest/operators]

## Listar pacote por identificador [/rest/packtype/name={name}]

## Listar todos os pacotes [/rest/packtype]

## Listar todos os pacotes por país e nome do pacote [/rest/packtype/country={country}&packname={packname}]

##### Dados para exemplo

Segue um exemplo de DML para uma consulta inicial ;)

insert into appsclub.application (country, created_date, name, url) values ('Brasil', CURDATE(), 'Duolingo', 'http://duolingo.br');
insert into appsclub.application (country, created_date, name, url) values ('EUA', CURDATE(), 'CopoDagua', 'http://copodagua.br');
insert into appsclub.packtype (created_date, name) values (CURDATE(), 'app');
insert into appsclub.operator (country, name) values ('Brasil', 'Vivo');
insert into appsclub.operatorpackapp (app_id, pack_id, operator_id) values (1,1,1);
insert into appsclub.operatorpackapp (app_id, pack_id, operator_id) values (2,1,1);

##### Algumas considerações

Tentei criar 
