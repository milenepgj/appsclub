Apps Club Service

Um serviço de assinatura, onde o usuário paga um pequeno valor recorrente para utilizar centenas de apps que, se comprados individualmente, custariam milhares e milhares de reais. O assinante paga o valor direto na conta de telefone da operadora, sem precisar de cartão de crédito.

O serviço foi desenvolvido utilizando Spring Boot (e seus pacotes de apoio a formatação do tráfego de dados de serviços REST) e Spring Security, JPA e Hibernate. Para armazenamento dos dados, foi utilizado o banco MySQL.

A base de dados foi construída levando-se em consideração que uma operadora (tabela Operator) pode oferecer vários aplicativos (tabela Application) aos seus clientes, sendo esses aplicativos agrupados em N pacotes (PackTypes). Todos esses dados estão relacionados entre si na tabela OperatorPackApp.

Seguem os endpoints disponibilizados nesta versão:

## Listar todos os aplicativos por país [/rest/apps/country={country}]

## Listar aplicativo pelo nome [/rest/apps/name={name}]

### Buscar aplicativo por nome: GET_APP_BY_NAME = "/rest/apps/name={name}"
### Listar aplicativos por país = "/rest/apps/country={country}"
### Listar aplicativos pelo nome do pacote e país = "/rest/apps/packname={packname}&country={country}"
### Listar todos os aplicativos disponíveis = "/rest/apps"
### Listar todos aplicativos que as operadoras possuem em seus pacotes = "/rest/operatorapppacks"
### Listar os aplicativos que as operadoras possuem em seus pacotes por nome da operadora e nome do pacote = "/rest/operatorapppacks/operator={operator}&pack={pack}"
### Buscar operadora por nome = "/rest/operators/name={name}"
### Listar todas as operadoras cadastradas = "/rest/operators"
### Buscar pacotes por nome = "/rest/packtype/name={name}"
### Listar todos os pacotes cadastrados = "/rest/packtype"
### Listar todos os pacotes por país e nome do pacote = "/rest/packtype/country={country}&packname={packname}"
### Listar todos os aplicativos relacionados a um pacote pelo seu nome = "/rest/packapp/name={name}"
### Listar todos os aplicativos relacionados a um pacote pelo país = "/rest/packapp/country={country}"
### Listar todos os pacotes que possuem aplicativos associados = "/rest/packapp"

##### Dados de conexão e para exemplo

- Login para autenticação a partir do client:

login: appcl2b/app16m1lla

- Segue DDL para criação do esquema:

CREATE DATABASE appsclub

- Segue usuário gerado para acesso à base de dados e instrução de grant:

CREATE USER 'appmilla'@'localhost' IDENTIFIED BY 'appmilla81'
GRANT ALL PRIVILEGES ON *.* TO 'appmilla'@'localhost' WITH GRANT OPTION

- Segue um exemplo enxuto de DML para uma consulta inicial:

insert into application (country, created_date, name, url) values ('Brasil', CURDATE(), 'Duolingo', 'https://pt.duolingo.com/')
insert into application (country, created_date, name, url) values ('Brasil', CURDATE(), 'Keep Yoga', 'https://play.google.com/store/apps/details?id=com.gotokeep.yoga.intl')
insert into application (country, created_date, name, url) values ('Brasil', CURDATE(), 'Bubble Shooter', 'https://play.google.com/store/apps/details?id=com.linkdesks.bubblegames.bubbleshooter')
insert into application (country, created_date, name, url) values ('EUA', CURDATE(), 'Peppa Pig: Paintbox', 'https://play.google.com/store/apps/details?id=air.com.peppapig.paintbox')
insert into packtype (created_date, name) values (CURDATE(), 'app')
insert into packtype (created_date, name) values (CURDATE(), 'games')
insert into packtype (created_date, name) values (CURDATE(), 'kids')
insert into operator (country, name) values ('Brasil', 'Vivo')
insert into operator (country, name) values ('Brasil', 'Tim')
insert into packapp (app_id, pack_id) values (1,1)
insert into packapp (app_id, pack_id) values (2,1)
insert into packapp (app_id, pack_id) values (3,2)
insert into packapp (app_id, pack_id) values (4,3)
insert into operatorpackapp (pack_app_app_id, pack_app_pack_id, operator_id) values (1,1,1)
insert into operatorpackapp (pack_app_app_id, pack_app_pack_id, operator_id) values (2,1,1)
insert into operatorpackapp (pack_app_app_id, pack_app_pack_id, operator_id) values (3,2,2)
insert into operatorpackapp (pack_app_app_id, pack_app_pack_id, operator_id) values (4,3,2)


##### Algumas considerações:

Tentei criar a aplicação de forma ágil, tendo como base a documentação e preocupando com o backend. Incluí vários endpoints de consulta para que possam avaliar a forma que os dados foram persistidos, mas não concentrei esforços em criar endpoints para criação e atualização dos dados.
Não acredito que seja ainda a melhor forma de criar serviços, poderia ter encapsulado algumas informações ou utilizado Java Reactor, já pensando na grande quantidade de acessos, que de forma assincrona, essa tecnologia poderia suprir alguns gargalos, mas levei em consideração ser um projeto que pode ser melhorado com o tempo ou de acordo com a expectativa de uso.
