# Desafio Validação e Segurança
Implemente as funcionalidades necessárias para que os testes do projeto abaixo passem (assista o vídeo explicativo e baixe o projeto no conteúdo anexo ao vídeo).

Este é um sistema de eventos e cidades com uma relação N-1 entre eles:

![domain](/assets/domain.png) 

## Regras de controle de acesso:
*	Somente rotas de leitura (GET) de eventos e cidades são públicas (não requer login).
*	Usuários CLIENT e/ou ADMIN podem inserir novos eventos (POST).
*	Os demais acessos são permitidos apenas a usuários ADMIN.

## Regras de validação de City:
*	Nome não pode ser vazio

## Regras de validação de Event:
*	Nome não pode ser vazio
*	Data não pode ser passada
*	Cidade não pode ser nula

## Mínimo para aprovação: 10/12
- [x] POST /events deve retornar 401 Unauthorized para usuário não logado
- [x] POST /events deve retornar 201 Created para CLIENT logado e dados corretos
- [x] POST /events deve retornar 201 Created para ADMIN logado e dados corretos
- [x] POST /events deve retornar 422 Unproccessable Entity para ADMIN logado e nome em branco
- [x] POST /events deve retornar 422 Unproccessable Entity para ADMIN logado e data no passado
- [x] POST /events deve retornar 422 Unproccessable Entity para ADMIN logado e cidade nula
- [x] GET /events deve retornar 200 Ok com página de recursos
- [x] POST /cities deve retornar 401 Unauthorized para usuário não logado
- [x] POST /cities deve retornar 403 Forbidden para CLIENT logado
- [x] POST /cities deve retornar 201 Created para ADMIN logado e dados corretos
- [x] POST /cities deve retornar 422 Unprocessable Entity para ADMIN logado e nome em branco
- [x] GET /cities deve retornar 200 Ok com todos recursos ordenados por nome

## Competências avaliadas:
- Desenvolvimento TDD de API Rest com Java e Spring Boot
- Implementação de segurança com Spring Security e OAuth2
- Controle de acesso por rotas e perfis de usuário
- Validação de dados com Bean Validation

## Checklist to resolve 
 ###	Modelo de dados User-Role
   - [x] Entidades 
   - [x] Seed da base de dados 

###	Incluir infraestrutura de exceções e validação
   - [x] Dependências Bean Validation 
   - [x] Exceções de serviço customizadas 
   - [x] Handler de exceções dos controladores 

###	Incluir infraestrutura de segurança ao projeto
  - [x] Dependências Spring Security e OAuth2 
  - [x] Variáveis de ambiente 
  - [x] Checklist do Spring Security     
  - [x] Implementação customizada password grant
  - [x]	Classes de configuração Authorization Server e Resource Server

###	Implementar as funcionalidades
  - [x] Post Login
  - [x] Get Cities
  - [x] Post City
  - [x] Get Events Paged
  - [x] Post Event