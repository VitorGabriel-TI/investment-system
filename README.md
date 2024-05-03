# Sistema de Investimentos
 

Este projeto é uma construção de API uma para plataforma de investimentos que permite
que usuários consumam os preços das ações da bolsa de valores e comprem ações
disponíveis no mercado usando **Java, Spring, Postgres e Docker**

## Conteúdo

- [Instalação](#instalação)
- [Iniciando o programa](#iniciando-o-programa)

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/VitorGabriel-TI/investment-system.git
```

2. Instale as dependências com o Maven

3. Instale [PostgresSQL](https://www.postgresql.org/)

4.Instale o Docker [Docker](https://docs.docker.com/desktop/install/windows-install/)

5.Instale o Insomnia [Insomnia](https://insomnia.rest/download)

## Iniciando o programa

1. Substitua os campos "POSTGRES_USER: your_user, POSTGRES_PASSWORD: your_password" do arquivo docker-compose.yml e os campos "spring.datasource.username= user, spring.datasource.password= password" do application.properties com seu user e senha do banco de dados.
2. Abra o docker
3. Suba o banco de dados com o docker usando "docker compose up" no terminal
4. Inicie a aplicação 
5. Abra o Insomnia e selecione a opção "Use the local Scratch Pad"
6. Selecione a opção "Scratch Pad"
7. Realize as requisições

