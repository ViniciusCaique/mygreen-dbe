# MyGreen


Uma API para controle de uma plantação.

### Endpoints

- Clima 
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar

- Clima Adequado
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar

- Planta
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar

- Plantação
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar

- Usuário
    - Cadastrar
    - Atualizar
    - Listar todos
    - Mostrar detalhes
    - Apagar


## Cadastrar Clima
`POST` /api/climas

|Campo|tipo|Obrigatório|descrição
|------ |------|:-----------: |---------
|Nome| text| sim| Nome do clima em que irá ser cadastrado
|descrição| text | sim | Descrição do clima que vai ser cadastrado 
|temperatura| int | sim | Temperatura média do clima 

**Exemplo de corpo de requisição**
```js
{
 "nome":"Nublado"
 "descricao":"Muitas nuvens"
 "temperatura": 17
}

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|404 | os campos enviados sao invalidos 


---

## Atualizar  Clima
`UPDATE` /api/climas/{id}

|Campo|tipo|Obrigatório|descrição
|------ |------|:-----------: |---------
|Nome| text| sim| Nome do clima em que irá ser cadastrado
|descrição| text | sim | Descrição do clima que vai ser cadastrado 
|temperatura| int | sim | Temperatura média do clima 

**Exemplo de corpo de requisição**
```js
{
    "nome":"Calor"
    "descricao":"Ensolarado"
    "temperatura": 25
}

```


**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados atualizados com sucesso
|400 | os campos enviados sao invalidos

--- 

## Listar todos

`GET` /api/climas

**Exemplo de corpo de requisição**
```js
{
    "nome":"Nublado"
    "descricao":"Muitas nuvens"
    "temperatura": 17
},
{
    "nome":"Calor"
    "descricao":"Ensolarado"
    "temperatura": 25
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe clima cadastrado

--- 

## Detalhar Clima
`GET` /api/climas/{id} 


**Exemplo de corpo de requisição**

```js
{
    "id": 1
    "nome":"Nublado"
    "descricao":"Muitas nuvens"
    "temperatura": 17
}
```
**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe clima cadastrado

--- 
## Apagar Clima


`DELETE` /api/climas/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado

---

## Cadastrar Clima Adequado

`POST` /api/climaAdequado

|Campo|tipo|Obrigatório|descrição
|------ |------|:-----------: |---------
|turno| text| sim | Turno do dia em que deve ser regado
|duracao| date| sim | Tempo estimado que a plantação dura


**Exemplo de corpo de requisição**
```js
{
    "turno": "manhã",
    "duracao": "2023-05-31"
}

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|404 | os campos enviados sao invalidos 

---

## Atualizar  Clima Adequado
`UPDATE` /api/climaAdequado/{id}

|Campo|tipo|Obrigatório|descrição
|------ |------|:-----------: |---------
|turno| text| sim | Turno do dia em que deve ser regado
|duracao| date| sim | Tempo estimado que a plantação dura


**Exemplo de corpo de requisição**
```js
{
    "turno": "tarde",
    "duracao": "2022-03-25"
}

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados atualizados com sucesso
|400 | os campos enviados sao invalidos 

--- 

## Listar todos

`GET` /api/climaAdequado

**Exemplo de corpo de requisição**
```js
{
    "turno": "manhã",
    "duracao": "2023-05-31"
},
{
    "turno": "tarde",
    "duracao": "2022-03-25"
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe clima adequado cadastrado


--- 
## Detalhar Clima Adequado
`GET` /api/climaAdequado/{id} 


**Exemplo de corpo de requisição**

```js
{
    "id": 2
    "turno": "tarde",
    "duracao": "2022-03-25"
}
```
**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe clima cadastrado

--- 

## Apagar Clima


`DELETE` /api/climaAdequado/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado

---

## Cadastrar Planta
`POST` /api/plantas

|Campo|tipo|Obrigatório|descrição
|------ |------|:-----------: |---------
|Nome| text| sim| Nome da planta em que irá ser cadastrado
|descrição| text | sim | Descrição da planta que vai ser cadastrado 
|Tipo| text | sim | Tipo da planta que está sendo cadastrada

**Exemplo de corpo de requisição**
```js
{
    "nome": "alface",
    "descricao": "A alface é uma planta herbácea, com um caule diminuto ao qual se prendem as folhas",
    "tipo": "comestível"
}

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|404 | os campos enviados sao invalidos 



## Cadastrar Planta
`UPDATE` /api/plantas

|Campo|tipo|Obrigatório|descrição
|------ |------|:-----------: |---------
|Nome| text| sim| Nome da planta em que irá ser cadastrado
|descrição| text | sim | Descrição da planta que vai ser cadastrado 
|Tipo| text | sim | Tipo da planta que está sendo cadastrada


**Exemplo de corpo de requisição**
```js
{
    "nome": "limoeiro",
    "descricao": "O limoeiro, Citrus limon, é uma planta relativamente pequena e de copa arredondada",
    "tipo": "comestível"
}

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados atualizados com sucesso
|400 | os campos enviados sao invalidos

--- 



## Listar todos

`GET` /api/plantas

**Exemplo de corpo de requisição**
```js
{
    "nome": "alface",
    "descricao": "A alface é uma planta herbácea, com um caule diminuto ao qual se prendem as folhas",
    "tipo": "comestível"
},
{
    "nome": "limoeiro",
    "descricao": "O limoeiro, Citrus limon, é uma planta relativamente pequena e de copa arredondada",
    "tipo": "comestível"
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe planta cadastrada 

--- 


## Detalhar Planta
`GET` /api/plantas/{id} 


**Exemplo de corpo de requisição**

```js
{
    "id": 1
    "nome": "alface",
    "descricao": "A alface é uma planta herbácea, com um caule diminuto ao qual se prendem as folhas",
    "tipo": "comestível"
}
```
**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe planta cadastrada

--- 

## Apagar Plana


`DELETE` /api/plantas/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado

---


## Cadastrar Plantacao
`POST` /api/plantacao

|Campo|tipo|Obrigatório|descrição
|------ |------|:-----------: |---------
|dataPlantacao| date| sim| data em qua a plantacao foi iniciada
|quantidadeAgua| int | sim |quantidade média de água utilizada na plantacao
|fertilizando| boolean | sim | Campo que serve para informar se irá utilizar fertilizante ou não    

**Exemplo de corpo de requisição**
```js
{
	"dataPlantacao": "2022-03-28",
	"quantidadeAgua": 10,
	"fertilizante": true
}

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|404 | os campos enviados sao invalidos 


## Atualizar  Plantacao
`UPDATE` /api/plantacao/{id}
|Campo|tipo|Obrigatório|descrição
|------ |------|:-----------: |---------
|dataPlantacao| date| sim| data em qua a plantacao foi iniciada
|quantidadeAgua| int | sim |quantidade média de água utilizada na plantacao
|fertilizando| boolean | sim | Campo que serve para informar se irá utilizar fertilizante ou não    

**Exemplo de corpo de requisição**
```js
{
	"dataPlantacao": "2023-01-09",
	"quantidadeAgua": 100,
	"fertilizante": true
}

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados atualizados com sucesso
|400 | os campos enviados sao invalidos

--- 

## Listar todos

`GET` /api/plantacao


**Exemplo de corpo de requisição**
```js
{
	"dataPlantacao": "2022-03-28",
	"quantidadeAgua": 10,
	"fertilizante": true
},
{
	"dataPlantacao": "2023-01-09",
	"quantidadeAgua": 100,
	"fertilizante": true
}
```
**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe plantacao cadastrado

--- 

## Detalhar Plantacao
`GET` /api/plantacao/{id} 


**Exemplo de corpo de requisição**

```js
{
    "id": 2
	"dataPlantacao": "2023-01-09",
	"quantidadeAgua": 100,
	"fertilizante": true
}
```
**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe plantacao cadastrado

--- 

## Apagar Plantacao


`DELETE` /api/plantacao/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado

---


## Cadastrar Usuario
`POST` /api/usuario

|Campo|tipo|Obrigatório|descrição
|------ |------|:-----------: |---------
|nome|text|sim| Nome de usuário dentro do aplicativo
|email|text|sim| Email do usuario para poder logar
|senha|text|sim| Senha do usuário


**Exemplo de corpo de requisição**
```js
{
    "nome": "FernandoCesxr",
    "email": "rm95628@fiap.com",
    "senha": "l1F8D2*eIr&"
}

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados cadastrado com sucesso
|404 | os campos enviados sao invalidos 


## Atualizar  Usuario
`UPDATE` /api/usuario/{id}

|Campo|tipo|Obrigatório|descrição
|------ |------|:-----------: |---------
|nome|text|sim| Nome de usuário dentro do aplicativo
|email|text|sim| Email do usuario para poder logar
|senha|text|sim| Senha do usuário

**Exemplo de corpo de requisição**
```js
{
    "nome": "Cesar",
    "email": "cesar@gmail.com",
    "senha": "Ij321WW%&D5h"
}

```

**Exemplo de corpo da respota**

**Cógigos de respota**

|código| descrição
| - | -
|201 | dados atualizados com sucesso
|400 | os campos enviados sao invalidos

--- 


## Listar todos

`GET` /api/usuario

**Exemplo de corpo de requisição**

```js
{
    "nome": "Cesar",
    "email": "cesar@gmail.com",
    "senha": "Ij321WW%&D5h"
},
{
    "nome": "FernandoCesxr",
    "email": "rm95628@fiap.com",
    "senha": "l1F8D2*eIr&"
}


```
**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe usuario cadastrado

--- 


## Detalhar Usuario
`GET` /api/usuario/{id} 

**Exemplo de corpo de requisição**

```js
{
    "id": 1
    "nome": "FernandoCesxr",
    "email": "rm95628@fiap.com",
    "senha": "l1F8D2*eIr&"
}
```

**Cógigos de respota**

|código| descrição
| - | -
|200 | dados retornados com sucesso
|404 | não existe usuario cadastrado

--- 

## Apagar Usuario


`DELETE` /api/usuario/{id}

|código| descrição
| - | -
|204 | dado apagado com sucesso
|401 | não existe dado com o id informado
