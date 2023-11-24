# SaudeSyncDevops

# Integrantes
Nome: Daniel Tsyuoshi Yamamoto  RM: 95344


Nome: Lucas Sabonaro RM: 95518

### Problema a ser resolvido: 
 
A mortalidade materna e infantil persiste como uma preocupação global, sendo agravada por dificuldades no acesso aos cuidados de saúde adequados, especialmente em comunidades carentes. As doenças transmissíveis continuam a representar ameaças significativas, desafiando os sistemas de saúde e exigindo estratégias eficientes de controle. Além disso, as doenças não transmissíveis, como diabetes e doenças cardiovasculares, estão em ascensão, muitas vezes devido a hábitos de vida inadequados e à falta de intervenções preventivas.

### Solução 
 
Desenvolver um Sistema de Monitoramento de Saúde Pessoal Inteligente baseado em tecnologias emergentes, como Internet das Coisas (IoT), Inteligência Artificial (IA) e Dispositivos Vestíveis. Este sistema terá como foco principal a prevenção e tratamento de doenças não transmissíveis, contribuindo para a melhoria geral da saúde da população.


Funcionalidades
Monitoramento Contínuo: Dispositivos vestíveis, como smartwatches, sensores de saúde e outros dispositivos conectados, serão usados para monitorar continuamente parâmetros de saúde, como batimentos cardíacos, níveis de glicose, pressão arterial, atividade física, entre outros.

Análise Preditiva por IA: Algoritmos de Inteligência Artificial serão empregados para analisar os dados coletados, identificando padrões e tendências que possam indicar riscos de desenvolvimento de doenças não transmissíveis, como diabetes, hipertensão, e problemas cardiovasculares.

Alertas Personalizados: Com base na análise dos dados, o sistema enviará alertas personalizados aos usuários, sugerindo mudanças no estilo de vida, lembretes de medicação, recomendações de atividade física e hábitos alimentares saudáveis.

Integração com Profissionais de Saúde: O sistema permitirá a integração direta com os profissionais de saúde, possibilitando a comunicação eficiente e o compartilhamento de informações relevantes. Isso facilitará a intervenção precoce e a personalização dos planos de tratamento.

Acompanhamento Remoto: Pacientes em risco ou com condições crônicas poderão ser monitorados remotamente pelos 
profissionais de saúde, reduzindo a necessidade de visitas frequentes ao hospital e permitindo uma intervenção rápida em 
caso de emergência.

### Desenho da Arquitetura 
![image](https://github.com/DanielTsuyoshi/NutriAiDevops/assets/110398603/045befd2-3a2f-4d42-b105-9c1769e809a6)

Serviço de Aplicativos (ou API): Para hospedar a aplicação web ou API que permitirá aos usuários interagir com o sistema e criar planos de saude, na qual poderão ver como está sua saúde dia a dia. 
 
Banco de Dados em Nuvem: Utilizaremos um banco de dados em nuvem compatível, como PostgreSQL, para armazenar informações dos clientes, planos de saude e históricos de interações. 
 
Inteligência Artificial (ChatGPT): A integração com o ChatGPT será feita por meio de API para geração de recomendações personalizadas. 


## Endpoints
 - Cliente
   - [Cadastrar Cliente](#cadastrar-cliente)
   - [Listar Clientes](#listar-clientes)
   - [Detalhar Cliente](#detalhar-cliente)
   - [Editar Cliente](#editar-cliente)
   - [Deletar Cliente](#deletar-cliente)
     
 - Movimentação
   - [Fazer Movimentação](#fazer-movimentação)
   - [Listar todas Movimentações](#listar-todas-movimentações)
   - [Listar Movimentações pelo Cliente que fez](#listar-movimentações-pelo-cliente-que-fez)
   - [Listar Movimentações pelo Cliente que recebeu](#listar-movimentações-pelo-cliente-que-recebeu)

## Cliente
### Cadastrar Cliente

`POST` /saudesync/api/cliente

*Campos de requisição*

| campo | tipo   | obrigatório | descrição        |
| ----- | ------ | :---------: | ---------------- |
| nome  | String |     sim     | Nome do Cliente  |
| cpf   | String |     sim     | CPF do Cliente   |
| saldo | Double |     sim     | Saldo do Cliente |

*Exemplo de requisição*
```
{
  "nome": "Arthur Edson Joaquim Ramos",
  "cpf": "861.067.339-10",
  "saldo": 200.0
}
```

*Resposta*

| código | descrição                            |
| ------ | ------------------------------------ |
| 201    | o cliente foi cadastrado com sucesso |
| 400    | dados inválidos                      |

### Listar Clientes

`GET` /saudesync/api/cliente

```
[
	{
		"id": 1,
		"nome": "Antonio Pietro Mateus Lopes",
		"cpf": "490.098.832-48",
		"saldo": 100.0,
		"movimentacoesFez": [],
		"movimentacoesRecebe": []
	},
	{
		"id": 2,
		"nome": "Stefany Marina Lopes",
		"cpf": "242.139.909-23",
		"saldo": 150.0,
		"movimentacoesFez": [],
		"movimentacoesRecebe": []
	},
	{
		"id": 3,
		"nome": "Roberto Osvaldo Barros",
		"cpf": "328.916.505-14",
		"saldo": 200.0,
		"movimentacoesFez": [],
		"movimentacoesRecebe": []
	},
	{
		"id": 4,
		"nome": "Enrico Geraldo Manoel da Mota",
		"cpf": "317.488.066-10",
		"saldo": 60.5,
		"movimentacoesFez": [],
		"movimentacoesRecebe": []
	},
	{
		"id": 5,
		"nome": "Arthur Edson Joaquim Ramos",
		"cpf": "861.067.339-10",
		"saldo": 200.0,
		"movimentacoesFez": [],
		"movimentacoesRecebe": []
	}
]
```

*Resposta*

| código | descrição                             |
| ------ | ------------------------------------- |
| 200    | os dados foram retornados com sucesso |

### Detalhar Cliente

`GET` /saudesync/api/cliente/{id}

```
{
	"id": 5,
	"nome": "Arthur Edson Joaquim Ramos",
	"cpf": "861.067.339-10",
	"saldo": 200.0,
	"movimentacoesFez": [],
	"movimentacoesRecebe": []
}
```

### Editar Cliente

`PUT` /saudesync/api/cliente/{id}

*Campos de requisição*

| campo | tipo   | obrigatório | descrição        |
| ----- | ------ | :---------: | ---------------- |
| nome  | String |     sim     | Nome do Cliente  |
| cpf   | String |     sim     | CPF do Cliente   |
| saldo | Double |     sim     | Saldo do Cliente |

*Exemplo de requisição*
```
{
  "nome": "Arthur Edson da Silva",
  "cpf": "071.320.068-51",
  "saldo": 1000.0
}
```

*Resposta*

| código | descrição                            |
| ------ | ------------------------------------ |
| 201    | o cliente foi atualizado com sucesso |
| 400    | dados inválidos                      |

### Deletar Cliente

`DELETE` /saudesync/api/cliente/{id}

*Resposta*

| código | descrição                                     |
| ------ | --------------------------------------------- |
| 200    | o cliente foi removido com sucesso            |
| 404    | não foi possível achar um cliente com esse id |

## Movimentação
### Fazer Movimentação

`POST` /saudesync/api/movimentacao/{idFaz}/{idRecebe}/{valor}

*Resposta*

| código | descrição                                     |
| ------ | --------------------------------------------- |
| 200    | movimentação feita com sucesso                |
| 403    | saldo do cliente insuficiente                 |
| 404    | não foi possível achar um cliente com esse id |

### Listar todas Movimentações

`GET` /saudesync/api/movimentacao

```
[
	{
		"id": 1,
		"valor": 50.0
	},
	{
		"id": 2,
		"valor": 20.0
	},
	{
		"id": 3,
		"valor": 100.0
	},
	{
		"id": 4,
		"valor": 5.0
	}
]
```

*Resposta*

| código | descrição                             |
| ------ | ------------------------------------- |
| 200    | os dados foram retornados com sucesso |

### Listar Movimentações pelo Cliente que fez

`GET` /saudesync/api/movimentacao/fez/{idFez}

```
[
	{
		"id": 1,
		"valor": 50.0
	},
	{
		"id": 2,
		"valor": 20.0
	}
]
```

*Resposta*

| código | descrição                             |
| ------ | ------------------------------------- |
| 200    | os dados foram retornados com sucesso |

### Listar Movimentações pelo Cliente que recebeu

`GET` /saudesync/api/movimentacao/recebeu/{idRecebeu}

```
[
	{
		"id": 1,
		"valor": 50.0
	},
	{
		"id": 3,
		"valor": 100.0
	}
]
```

*Resposta*

| código | descrição                             |
| ------ | ------------------------------------- |
| 200    | os dados foram retornados com sucesso |
