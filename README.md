# Challenge III - PB Springboot Dez 2023

-------------------------------------------------------------------------------------------------------

O projeto consiste em um microsserviço desenvolvido em Spring Boot para armazenar notificações vindas
do [msuser](https://github.com/raphael-araujo/ms-user)

-------------------------------------------------------------------------------------------------------

### Tecnologias Utilizadas

<table>
  <tr>
    <td>Java</td>
    <td>Spring</td>
    <td>MongoDB</td>
    <td>RabbitMQ</td>
  </tr>
  <tr>
    <td>17.*</td>
    <td>3.2</td>
    <td>latest</td>
    <td>3.12</td>
  </tr>
</table>

-------------------------------------------------------------------------------------------------------

### Setup

<br>
1 - Clone o repositório

```
git clone https://github.com/raphael-araujo/ms-notification.git
```

<br>

2 - Crie e Configure o banco de dados de acordo com o arquivo `application.yml`

<br>
3 - Suba o MongoDB para o docker

````
docker-compose up
````

4 - Execute a aplicação

```
mvn spring-boot:run
```

<br>

##### OBS:

- É necessário que o [msaddress](https://github.com/raphael-araujo/ms-address) e
  o [msuser](https://github.com/raphael-araujo/ms-user) estejam em execução, junto com o rabbitMQ via
  docker.

-------------------------------------------------------------------------------------------------------
