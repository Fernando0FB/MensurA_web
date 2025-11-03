# MensurA - Sistema de Mensuração de Articulações

## 📋 Sobre o Projeto

O **MensurA** é uma aplicação web desenvolvida em Spring Boot para gerenciamento e mensuração de articulações corporais. O sistema permite que profissionais da saúde registrem e acompanhem medições de amplitude de movimento em pacientes, fornecendo dados precisos para avaliações fisioterapêuticas e acompanhamento de tratamentos.

## 🎯 Funcionalidades Principais

### 👥 Gestão de Pacientes
- Cadastro completo de pacientes com dados pessoais
- Informações como nome, CPF, data de nascimento, email e sexo
- Sistema de observações para anotações relevantes
- Histórico de mensurações por paciente

### 📊 Sistema de Mensurações
- **Articulações Suportadas**: Cotovelo e Joelho
- **Lados**: Esquerdo e Direito
- **Movimentos**: Flexão, Extensão, Pronação e Supinação
- Registro de posição específica para cada medição
- Histórico completo de mensurações por paciente
- **Dados Registrados**:
  - Ângulo inicial (0° a 360°)
  - Ângulo final (0° a 360°)
  - Excursão (0° a 360°)
  - Escala de dor (0 a 10)
  - Observações detalhadas
  - Data e hora automática da mensuração

### 🔐 Sistema de Autenticação
- Autenticação JWT (JSON Web Token)
- Gerenciamento seguro de usuários
- Controle de acesso baseado em tokens

### 🏢 Multi-tenancy
- Suporte a múltiplos inquilinos (tenants)
- Isolamento completo de dados entre diferentes organizações
- Filtros automáticos por tenant

### 📈 Análises e Relatórios
- Análise de dados de mensurações
- Dados estruturados para relatórios

## 🛠️ Tecnologias Utilizadas

- **Java 21** com Spring Boot 3.5.5
- **Spring Security** para autenticação e autorização
- **Spring Data JPA** para persistência de dados
- **PostgreSQL** como banco de dados
- **JWT** para autenticação stateless
- **Lombok** para redução de boilerplate
- **Maven** para gerenciamento de dependências
- **Docker** para containerização

## 🚀 Como Executar com Docker

### Pré-requisitos
- Docker instalado
- Docker Compose instalado

### 1. Configuração do Ambiente

Primeiro, crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:

```env
# Configurações do Banco de Dados PostgreSQL
URL_BANCO_SUPA=jdbc:postgresql://localhost:5432/mensura_db
USUARIO_BANCO_SUPA=mensura_user
SENHA_BANCO_SUPA=sua_senha_aqui

# Configurações JWT
JWT_SECRET=seu_jwt_secret_super_seguro_aqui
```

### 2. Build da Aplicação

Antes de executar o Docker, você precisa fazer o build da aplicação:

```bash
# Compilar o projeto
./mvnw clean package -DskipTests
```

### 3. Execução com Docker Compose

```bash
# Iniciar a aplicação
docker-compose up --build

# Para executar em background
docker-compose up -d --build
```

### 4. Verificação

A aplicação estará disponível em: `http://localhost:8080`

### 5. Comandos Úteis

```bash
# Parar a aplicação
docker-compose down

# Ver logs da aplicação
docker-compose logs -f app

# Rebuild e restart
docker-compose down && docker-compose up --build
```

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/MensurA/web/
│   │   ├── commom/           # Configurações comuns
│   │   │   ├── config/       # Configurações do Spring
│   │   │   ├── enums/        # Enums do sistema
│   │   │   ├── exception/    # Tratamento de exceções
│   │   │   ├── security/     # Configurações de segurança
│   │   │   └── tenancy/      # Sistema multi-tenant
│   │   └── features/         # Funcionalidades do sistema
│   │       ├── mensuracoes/  # Gestão de mensurações
│   │       ├── pacientes/    # Gestão de pacientes
│   │       └── usuarios/     # Gestão de usuários
│   └── resources/
│       ├── application.properties
│       ├── static/
│       └── templates/
└── test/                     # Testes unitários
```

## 🔧 Configurações Importantes

### Banco de Dados
- **Driver**: PostgreSQL
- **Hibernate**: Configurado para `update` (cria/atualiza tabelas automaticamente)
- **Logs SQL**: Habilitados para desenvolvimento

### JWT
- **Expiração**: 30 minutos (1800000ms)
- **Algoritmo**: Configurado via `JwtUtil`

### Logs
- **Nível SQL**: DEBUG habilitado
- **Binding Parameters**: TRACE habilitado

## 📝 API Endpoints

A aplicação expõe uma API REST com os seguintes endpoints principais:

- **Autenticação**: `auth/*`
- **Pacientes**: `api/pacientes/*`
- **Mensurações**: `api/mensuracoes/*`
- **Usuários**: `api/usuarios/*`

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👨‍💻 Desenvolvedor

Desenvolvido por Fernando Bonetti.

---

**Nota**: Certifique-se de configurar corretamente as variáveis de ambiente no arquivo `.env` antes de executar a aplicação.
