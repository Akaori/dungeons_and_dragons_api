# API Dangeous & Dragons (AD&D)

API Rest usando Java SpringBoot com banco de dados Postgres.

O jogo, como todo bom RPG (Role Playing Game), será duelado em turnos.
Escolha o seu nome e personagem favorito (herói ou monstro).
O seu oponente sempre será um monstro, você pode escolher ou deixar aleatório.


## Instruções

### 1 - Clonar o repositório

```bash
git clone https://github.com/Akaori/dangeous_and_dragons_api.git
```

### 2 - Subir o banco de dados
> Para subir o banco de dados Postgres, é necessário ter o docker e docker-compose instalados. 

Mudar para o diretório do repositório clonado:

```bash
cd dangeous_and_dragons_api
```


Rodar o seguinte comando:

```bash
docker-compose up
```

Após isso, é possível acessar o banco de dados Postgres (PGAdmin) no seguinte endereço:

http://localhost:89/

Credenciais:

- email: `admin@example.com`
- senha: `admin`

### 3 - Acessar o OpenAPI da API:

http://localhost:8080/swagger-ui/index.html
