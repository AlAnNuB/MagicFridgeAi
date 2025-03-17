# MagicFridgeAi

MagicFridgeAi é uma aplicação Spring Boot que ajuda os usuários a gerenciar seus itens alimentares e gerar receitas com base nos ingredientes disponíveis usando o modelo OpenAI GPT-4.

## Funcionalidades

- **Operações CRUD para Itens Alimentares**: Criar, ler, atualizar e deletar itens alimentares.
- **Geração de Receitas**: Gerar receitas com base nos itens alimentares disponíveis usando o modelo GPT-4 da OpenAI.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Spring WebFlux**
- **Maven**
- **OpenAI GPT-4o**

## Estrutura do Projeto

- `src/main/java/dev/java10x/MagicFridgeAi/controller`: Contém os controladores para lidar com requisições HTTP.
    - `FoodItemController.java`: Gerencia operações CRUD para itens alimentares.
    - `RecipeController.java`: Lida com requisições de geração de receitas.
- `src/main/java/dev/java10x/MagicFridgeAi/service`: Contém as classes de serviço para a lógica de negócios.
    - `FoodItemService.java`: Fornece métodos para gerenciar itens alimentares.
    - `ChatGptService.java`: Interage com a API da OpenAI para gerar receitas.
- `src/main/java/dev/java10x/MagicFridgeAi/config`: Contém classes de configuração.
    - `WebClientConfig.java`: Configura o WebClient para fazer requisições HTTP para a API da OpenAI.

## Endpoints

### FoodItemController

- **POST /food**: Cria um novo item alimentar.
- **GET /food**: Lista todos os itens alimentares.
- **GET /food/{id}**: Obtém um item alimentar pelo ID.
- **PUT /food/{id}**: Atualiza um item alimentar pelo ID.
- **DELETE /food/{id}**: Deleta um item alimentar pelo ID.

### RecipeController

- **GET /generate**: Gera uma receita com base nos itens alimentares disponíveis.

## Configuração

### Variáveis de Ambiente

- `API_KEY`: Sua chave de API da OpenAI.

### Propriedades da Aplicação

- `chatgpt.api.url`: A URL para a API da OpenAI (padrão: `https://api.openai.com/v1/chat/completions`).

## Executando a Aplicação

1. Clone o repositório.
2. Defina a variável de ambiente `API_KEY` com sua chave de API da OpenAI.
3. Construa o projeto usando Maven:
   ```sh
   mvn clean install
   ```
4. Execute a aplicação:
   ```sh
   mvn spring-boot:run
    ```
## Licença

Este projeto está licenciado sob a Licença MIT.