# - Portal

- [Sobre](#sobre)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Requisitos](#requisitos)
    - [Dependências](#dependencias-do-projeto)
- [Configurações](#configurações)
    - [Git](#git)
    - [Configuração de parametros do  ](#configuração-de-parametros-do-projeto-)
    - [Instalação Manual](#instalação-manual)

## Sobre o projeto

Esta API foi desenvolvida em Java com SpringBoot e utilizando o banco de dados MySQL, fazendo apenas um CRUD de usuários. A finalidade desse projeto foi para estudo em springboot e aprimoramento das minhas habilidades em java.

## Estrutura do Projeto

O projeto tem uma estrutura composta por *backend*. O *backend* é composto de uma API REST utilizando [Spring MVC](https://sprint.io/) 

Estrutura dos diretórios:    

* **portal**: Diretório com uma solução JAVA contendo o projeto: API para disponilização da infra-estrutura do backend;

## Requisitos

Para desenvolvimento e utilização do projeto são necessárias as seguintes dependências: 

- [Git](https://git-scm.com/): Disponibiliza o Git na máquina, incluindo o utilitário Git Bash, usado para executar os scrips do projeto  
- [Spring MVC](https://spring.io/): Utilitário Java, com ferramentas necessárias para execução, build do *projeto*
- [Maven](https://maven.apache.org/): Controle de dependências para projetos em Java.

### Dependências do Projeto

Dependências necessárias para levantar o projeto:

 ```sh
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<scope>test</scope>
		</dependency>
```
    
## Configurações

Essa seção detalha as configurações necessárias para criar um ambiente de desenvolvimento local.

### Git

Para clonar o projeto acesse a url **http://git.com.br**. Após **autenticação**, utilizando as credenciais de acesso utilize o comando abaixo:

Usando http:

```sh
git clone  http://git.com.br/digital/est-.git
```

Utilizando ssh:

```sh
git clone git@git.com.br:-digitalweb.git
```

*Obs*: Para gerar a chave de ssh, abra o console git bash e execute o seguinte comando:

```sh
ssh-keygen -o -t rsa -b 4096 -C "informeseuemail@example.com"    
```
É possível no momento de gerar a chave, apresente algumas opções de configuração. Tecle **Enter** em todas.

```sh
Enter file in which to save the key (/c/Users/SEU-USUARIO-WINDOWS/.ssh/id_rsa ou c:\Users\SEU-USUARIO-WINDOWS\.ssh\id_rsa):
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
```
Após gerar a chave, acesse a pasta .ssh em seu perfil de usuário (/c/Users/SEU-USUARIO-WINDOWS/.ssh ou c:\Users\SEU-USUARIO-WINDOWS\.ssh) através do proprio console do git bash e execute o comando **cat id_rsa.pub**. selecione toda a chave iniciando de ssh-rsa efetuando em seguida faça a cópia. Retorne ao gitlab e após autenticação, selecione seu perfil e clique em settings. Na opção do menu clique em **SSH Keys**, cole sua chave no textbox **key** e adicione.

```sh
**Exemplo** de chave gerada:

ssh-rsa /kOS32zefv8gH1XsSokAkOG++HnTry3oC0xdeB/zckVyDB4CfFZb0QFKfEVVoR308qofc9nrL6XogkpChrPOrNGRq0T69c3i9YGCkYYcH+r4AGXx9WPKfDHQgay+M25kFtBUDZxaJlp4xn1qDnS4+nEE/1KX8+x3Sr/1/kG+X+fMXSQZo6vzVkCqJT0P5QBzUArwGWyA4iF70cCM1O80fAZlFCZtIiGwr3pZcDqX9Ig6QBYHdlJnubXJJM4PEesu/+phf/XHgfmxDlAXLJAdCe0ibjz7a5KL/L4oORkIVGUDqvxJsrd2kLz/iPVtUlcMUvlmJL1Qy91xNTOoVViteG8wxLpAEJqe7fKP5GY2gm7qtU9LxGwn+8tha9zGoambvGZvGZYkSINSXO1reaVZRmeDvepbEc6C2IFCiNyVSgDLDphVhBAqHLQKFnZSqQ3oOItL+WZe2bMWh3TT4VQJYA8uUwh+TL8HqLXnVMFtq3SCn/olY+viCEJoXT4mCaeIttifAR2Ej647Z8fCzHkB6L5tXTtqb5XBGeqnQojYqcWPW22nmzgkdUtynwBapY9bx5uBRSMpCtbd+nuKVxMQ== informeseuemail@example.com
```


Após clonar o repositório, acesse a pasta do projeto e configure o usuário git com os seguintes comandos: 

```sh
$ git config --local user.name "<nome>"
$ git config --local user.email "<email gitlab>"
```

*Obs*.: Se o usuário git já foi configurado, desconsiderar esse passo.

### Configuração de parametros do projeto

A execução do projeto Portal depende de arquivos com perfis de configuração, de acordo com o ambiente para reprodução do projeto (*application.properties*).  

O perfil de execução do projeto utiliza parametros que devem ser passados para a JVM. Caso utilize A Ide Eclipse, Acesse a opção RUN no Menu da IDE. Logo em seguida, RUN CONFIGURATION, selecione Java Application, aba Arguments  e configure os parametros abaixo em **VM Arguments**.

``` sh 
-Dspring.config.location=C:\Users\SEU-USUARIO-WINDOWS\CAMINHO-DO-PROJETO\portal\properties\application.properties 
```

``` sh 
```

Caso utilize a IDE VSCODE aplique as configurações no launch.json

```sh
 "vmArgs": "-Dspring.config.location=C:\\Users\\SEU-USUARIO-WINDOWS\\CAMINHO-DO-PROJETO\\portal\\properties\\application.properties C:\\Users\\SEU-USUARIO-WINDOWS\\CAMINHO-DO-PROJETO\\portal\\properties" 
```

### Banco de Dados

Todas as informações de acesso aos bancos de dado utilizados no projeto encontram-se nos arquivos **application.yml**, no diretório **resources**. 

Para configuração local do banco, é necessário ter uma instância [MySQL](https://downloads.mysql.com/archives/c-net/) instalada na máquina.  

### Instalação Manual

Essa seção detalha como o projeto pode ser configurado manualmente, sem uso do Docker. Para instalação manual é necessário que as dependências básicas listadas na seção [Requisitos](#requisitos) | [Dependências](#dependencias-do-projeto) estejam instaladas. 

#### Projeto (API)

Se estiver usando a IDE do Eclipse, simplesmente importe o projeto através do menu | File | Import | Maven | Existing Maven Projects e crie uma configuração para executar a aplicação. 

Após isso, instale as demais dependências locais do projeto usando: 

`$ mvn install` 

Para levantar o projeto execute o comando abaixo:

`$ mvn spring-boot:run` 

*Obs*.:  É possível executar o projeto através da IDE usando a opção RUN AS | Java Application.

A API estará em execução no endereço [http://localhost:8080](http://localhost:8080).
