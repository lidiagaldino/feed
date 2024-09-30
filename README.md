# Quarkus Reactive Application with Azure Translator

This is a reactive application built with Quarkus that integrates the Azure Translator. The application has three main endpoints:

- **Create a Post** (POST) - Creates a new post.
- **Get All Posts** (GET) - Returns all posts.
- **Get by Author** (GET) - Returns posts filtered by author.

## Technologies used

- Quarkus
- Reactive Panache
- Azure Translator API

## Prerequisites

- JDK 11+
- Maven
- Azure account with access to Translator API

## How to run

1. Clone:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd <NOME_DA_PASTA>
   ```

2. Configure environment variables by creating a .env:
   ```.env
   TRANSLATOR_API_KEY=yourapikey
   ```
3. Run
   ```bash
   ./mvnw compile quarkus:dev
   ```

## Endpoints

Create post:
   ```http
   POST http://localhost:8081/posts
   ```
   ```json
   {
    "content": "My post",
    "author": "author"
   }
   ```

Fetch all posts:


   ```http
   GET http://localhost:8081/posts?targetLang=pt
   ```

Fetch posts by its author:

   ```http
   GET http://localhost:8081/posts/author/{name}?targetLang=pt
   ```