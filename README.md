# UltimatePassword
Projeto para a disciplina de Digital Business Enablement, sistema gerenciador de senhas

Api de controle de contas e credenciais

## Endpoints

- Credenciais
    - [cadastrar](#cadastrar-credencial)
    - apagar
    - listar todas
    - alterar
    - [mostrar detalhes](#detalhes-da-credencial)
- Cartão
    - cadastrar
    - apagar
    - listar todas
    - alterar
    - mostrar detalhes  
- Contas
    - [cadastrar](#cadastrar-conta)
    - apagar
    - alterar
    - [mostrar detalhes](#detalhes-da-conta)

---


### Cadastrar Credencial

`POST` /ultimapassword/api/credencial

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|credencial_id | int | sim | id desta credencial previamente cadastrada
|nome_credencial | texto | sim | nome da credencial, serve como um nome descritivo sobre o que significa esta credencial
|nome_usuario | texto | sim | nome de usuario utilizado na credencial
|senha| texto | sim | senha do usuario utilizado na credencial
|url | texto | sim | url especificando a qual site ele pertence esta credencial
|notas | texto | não | texto não obrigatório para adição de informações com relação a esta credencial

**Exemplo de corpo de requisição**

```js
{
    credencial_id: '1',
    nome_credencial: "Conta gmail",
    nome_usuario: "teste@gmail.com",
    senha: "Teste123",
    url: "gmail.com",
    notas: "Esta é a credencial relacionada a conta do gmail teste"
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 201 | credencial cadastrada com sucesso
| 400 | campos inválidos

----

### Detalhes da Credencial

`GET` /ultimatepassword/api/credencial/{id}

**Exemplo de corpo de resposta**

```js
{
    credencial_id: '1',
    nome_credencial: "Conta gmail",
    nome_usuario: "teste@gmail.com",
    senha: "Teste123",
    url: "gmail.com",
    notas: "Esta é a credencial relacionada a conta do gmail teste"
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 200 | dados da credencial retornados
| 404 | não existe credencial com o id informado

----

### Cadastrar conta

`POST` /ultimatepassword/api/conta

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|usuario | texto | sim | nome de usuario para cadastro da conta
|senha | texto | sim | senha de usuario para cadastro da conta
|conta_id | int | sim | o id de uma conta previamente cadastrada


**Exemplo de corpo de requisição**

```js
{
    usuario: "Teste",
    senha: "Teste123",
    conta_id: '1',
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 201 | conta cadastrada com sucesso
| 400 | campos inválidos

----

### Detalhes da Conta

`GET` ultimatepassword/api/conta/{id}

**Exemplo de corpo de resposta**

```js
{
    usuario: "Teste",
    senha: "Teste123",
    conta_id: '1',
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 200 | dados da conta retornados
| 404 | não existe conta cadastrado com o id informado
