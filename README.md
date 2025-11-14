<h1 align="center" style="font-weight: bold;">Projects and Tasks 💻</h1>



<p align="center">
    <b>API que permite gerenciar projetos e tarefas</b>
</p>

<h2 id="technologies">💻 Technologies</h2>

- Java
- Spring Boot
- Spring Security
- PostgreSQL



<h2 id="routes">📍 API Endpoints</h2>


​
| route               | description                                          
|----------------------|-----------------------------------------------------
| <kbd>POST /auth/register</kbd>  | registra um novo usuario.
| <kbd>POST /auth/login</kbd>     | faz o login de um usuario ja cadastrado.
| <kbd>POST /projets</kbd>        | cria um novo projeto.
| <kbd>GET /projects</kbd>         | lista todos os projetos.
| <kbd>POST /tasks</kbd>          | cria uma nova tarefa.
| <kbd>GET /tasks?status=&priority=</kbd>  | lista todas as terefas (filtros personalizados).
| <kbd>PATCH /tasks/{id}/status</kbd>  | atualiza o status de uma tarefa.
| <kbd>DELETE /tasks/{id}</kbd>   | deleta uma tarefa pelo o id.

<h3 id="get-auth-detail">POST /auth/register</h3>

**REQUEST**
```json
{
  "name":"João",  
  "email":"joao@gmail.com",
  "password":"123456"
}
```

**RESPONSE**
```json
{
  "name":"João",  
  "email":"joao@gmail.com"
}
```

<h3 id="post-auth-detail">POST /auth/login</h3>

**REQUEST**
```json
{
   "email":"joao@gmail.com",
   "password":"123456"
}
```

**RESPONSE**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEsInN1YiI6ImpvYW9AZ21haWwuY29tIiwiZXhwIjoxNzYzMTI5MDMxLCJpYXQiOjE3NjMwNDI2MzF9.ABIF595Y3c-32M0myk060KlV6PBm9VOzxodRQhgoZes"
}
```

<h3 id="post-auth-detail">POST /projects</h3>

**REQUEST**
```json
{
   
    "name": "TaperSoft",
    "description": "Desenvolvimento de um software de barbearia",
    "endDate": "2026-02-17"
}
```

**RESPONSE**
```json
{
    "id": 2,
    "name": "TaperSoft",
    "description": "Desenvolvimento de um software de barbearia",
    "startDate": "2025-11-12",
    "endDate": "2026-02-17"
}
```

<h3 id="post-auth-detail">GET /projects</h3>

**RESPONSE**
```json
{
    "id": 1,
    "name": "API ITAU",
    "description": "Desenvolvimento de uma API para o ITAU",
    "startDate": "2025-11-12",
    "endDate": "2025-12-15"
  },
  {
    "id": 2,
    "name": "TaperSoft",
    "description": "Desenvolvimento de um software de barbearia",
    "startDate": "2025-11-12",
    "endDate": "2026-02-17"
  }
```

<h3 id="post-auth-detail">POST /tasks</h3>

**REQUEST**
```json
{
   
    "idProject":2,
    "title":"Requisitos",
    "description":"Levantamento de requisitos",
    "dueDate":"2025-11-17",
    "priority":"HIGH",
    "status":"DOING"
}
```

**RESPONSE**
```json
{
    "idProject": 2,
    "nameProject": "TaperSoft",
    "idTask": 4,
    "title": "Requisitos",
    "description": "Levantamento de requisitos",
    "startDate": "2025-11-13",
    "dueDate": "2025-11-17",
    "priority": "HIGH",
    "status": "DOING"
}
```

<h3 id="post-auth-detail">GET /tasks?status=DOING</h3>

**RESPONSE**
```json
{
    "idProject": 1,
    "nameProject": "API ITAU",
    "idTask": 3,
    "title": "Repository",
    "description": "Craição dos repositorys da API",
    "startDate": "2025-11-13",
    "dueDate": "2025-11-15",
    "priority": "MEDIUM",
    "status": "DOING"
  },
  {
    "idProject": 2,
    "nameProject": "TaperSoft",
    "idTask": 4,
    "title": "Requisitos",
    "description": "Levantamento de requisitos",
    "startDate": "2025-11-13",
    "dueDate": "2025-11-17",
    "priority": "HIGH",
    "status": "DOING"
  }
```

<h3 id="post-auth-detail">PATCH /tasks/4/status</h3>

**REQUEST**
```json
{
   "status":"DOING"
}
```

**RESPONSE**
```json
{
    "idProject": 2,
    "nameProject": "TaperSoft",
    "idTask": 4,
    "title": "Requisitos",
    "description": "Levantamento de requisitos",
    "startDate": "2025-11-13",
    "dueDate": "2025-11-17",
    "priority": "HIGH",
    "status": "DOING"
}
```

<h3 id="post-auth-detail">DELETE /tasks/1</h3>

**RESPONSE**
```json


```


