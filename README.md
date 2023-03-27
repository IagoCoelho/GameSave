# GameSave

Uma API para os sistema de progresso de jogo.

## Endpoints
- Cadastro
    - [Cadastrar](#cadastrar-jogo)
    - Listar todas
    - Apagar
    - Alterar
    - [Mostrar os detalhes](#) 
- Adicionar Metas
    - [Adicionar](#adicionar-metas)
    - Listar todas
    - Apagar
    - Alterar
- Meus Jogos
    - [Listar](#meus-jogos)
    - Apagar
    - Alterar
- Progresso
    - [Listar](#progresso)

---

### Cadastrar Jogo
`POST` /gamesave/api/jogo

|campo | tipo | obrigatório | descrição
|-------|-----|-------------:|----------
| nome_jogo | texto | sim | é o nome do jogo. deve ter no máximo 255 caracteres
| categoria_id | int | sim | é o id de uma categoria do jogo previamente cadastrado
| plataforma_id | int | sim | é o id de uma plataforma previamente cadastrada
| descricao | texto | não | uma descrição da despesa com no máximo 255 caracteres

**Exemplo de corpo do request**

```js
{
    "nome_jogo": "Hogwarts Legacy",
    "categoria_id": 1,
    "plataforma_id": 1,
    "descricao": "jogo de rpg"
}
```

**Códigos de Respostas**

| código | descrição
|--------|----------
| 201 | jogo cadastrado com sucesso
| 400 | erro na validação de dados da requisição

---

### Adicionar Metas
`POST` /gamesave/api/metas

|campo | tipo | obrigatório | descrição
|-------|-----|-------------:|----------
| nome_jogo | texto | sim | é o nome do jogo. deve ter no máximo 255 caracteres
| inicio_jornada | date | sim | é registrado o inicio da jornada do jogo
| meta | date | sim | é registrado a meta para concluir a jornada do jogo
| horas_dias | date | sim | é registrado as horas jogadas por dia do jogo

**Exemplo de corpo do request**

```js
{
    "nome_jogo": "Hogwarts Legacy",
    "inicio_jornada": "2023-02-10",
    "meta": "2023-04-01",
    "horas_dias": "07:00:00"
}
```

**Códigos de Respostas**

| código | descrição
|--------|----------
| 201 | meta cadastrada com sucesso
| 400 | erro na validação de dados da requisição


### Meus Jogos
`GET` /gamesave/api/jogos{id}

**Exemplo de corpo do request**

```js
{
    "nome_jogo": "Hogwarts Legacy",
    "categoria":{
        "categoria_id": 1,
        "tipo": "RPG - Ação"    
    }
    "plataforma":{
        "plataforma_id": 1,
        "nome": "PS5"
    }
    "descricao": "Hogwarts Legacy é um jogo eletrônico de RPG de ação desenvolvido pela Avalanche Software e publicado pela Warner Bros.
    Interactive Games. É ambientado no final do século XIX do Wizarding World de Harry Potter"
}
```


**Códigos de Respostas**

| código | descrição
|--------|----------
| 200 | dados retornados no corpo da resposta
| 404 | não foi encontrado

### Progresso
`GET` /gamesave/api/progresso{id}

**Exemplo de corpo do request**

```js
{
    "nome_jogo": "Hogwarts Legacy",
    "plataforma":{
        "plataforma_id": 1,
        "nome": "PS5"
    }
}
```


**Códigos de Respostas**

| código | descrição
|--------|----------
| 200 | dados retornados no corpo da resposta
| 404 | não foi encontrado
