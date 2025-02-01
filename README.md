# Spring Open Feign + API Do Spotify

[![Java Version](https://img.shields.io/badge/Java-21+-blue)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen)](https://spring.io/projects/spring-boot)
[![OpenFeign](https://img.shields.io/badge/OpenFeign-12.1-orange.svg)](https://github.com/OpenFeign/feign)


Um projeto simples para praticar os conhecimentos em consumo de APIs REST usando Spring OpenFeign, conectado à API do Spotify.


## ⚙️ Funcionalidades

- `GET /user/{user_id}`: Retorna informações do perfil do usuário
- `GET /albums`: Retorna os últimos lançamentos de álbuns no Spotify

## 📦 Pré-requisitos

- Java 21 
- Maven 3.8+
- Conta de desenvolvedor no [Spotify Developer Dashboard](https://developer.spotify.com/dashboard)
## 🚀 Configuração Rápida

1. Clone o repositório:
```bash
git clone https://github.com/seu-user/spotify-openfeign-demo.git
```
2. Crie um arquivo .env na raiz do projeto:
```bash
SPOTIFY_CLIENT_ID = SEU_CLIENT_ID
SPOTIFY_CLIENT_SECRET = SEU_CLIENT_SECRET
```
3. Execute a aplicação:
```bash
mvn spring-boot:run
```
