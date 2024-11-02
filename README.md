  <h1>JavaAdvancedChallenge</h1>

  <h2>Nomes dos Integrantes</h2>
  <ul>
    <li><strong>Pedro Duarte Farias</strong>: Responsável pela criação do projeto Java</li>
    <li><strong>Henrique Baptista</strong>: Responsável pela criação do projeto IoT e DevOps</li>
    <li><strong>Leonardo Dourado</strong>: Responsável pelo projeto de QA</li>
    <li><strong>Gabriel Caverzan</strong>: Responsável pelo projeto de Mobile e Banco de Dados</li>
    <li><strong>Matheus</strong>: Responsável pelo projeto de C#</li>
  </ul>

  <h1>Projeto de Gestão de Clientes</h1>
  <p>Este projeto é um sistema de gestão de clientes e compras, com funcionalidades de chat e assistência virtual. Ele permite criar, visualizar, editar e excluir dados de clientes e suas compras, além de oferecer:</p>
  <ul>
    <li>Autenticação com Spring Security</li>
    <li>Envio de e-mail de boas-vindas para novos clientes</li>
    <li>Sistema de chat, onde clientes podem fazer perguntas e obter respostas de outros clientes ou funcionários</li>
    <li>Assistente virtual com IA para prever a probabilidade de um novo cliente se tornar cliente da Plusoft</li>
  </ul>

  <h2>🚀 Tecnologias Utilizadas</h2>
  <ul>
    <li>Java 17</li>
    <li>Spring Boot 3.3.2</li>
    <li>Spring Security</li>
    <li>JPA com Hibernate</li>
    <li>Banco de Dados Oracle (com SQL Developer)</li>
    <li>RabbitMQ para chat entre clientes e funcionários</li>
    <li>Groq para IA de assistente virtual</li>
  </ul>

  <h2>🛠️ Funcionalidades</h2>
  <ul>
    <li>Autenticação e Autorização de Usuário com Spring Security</li>
    <li>CRUD de Clientes</li>
    <li>CRUD de Compras</li>
    <li>CRUD de Produtos</li>
    <li>Persistência com Banco de Dados Oracle</li>
    <li>Envio de e-mail de boas-vindas via MailSender</li>
    <li><strong>Sistema de Chat com RabbitMQ</strong>: Comunicação em tempo real onde clientes podem fazer perguntas e obter respostas de outros clientes ou funcionários da Plusoft.</li>
    <li><strong>Assistente Virtual com IA (Groq)</strong>: Previsão da probabilidade de conversão de clientes. A IA analisa dados e fornece uma chance de conversão em percentual com uma resposta clara e objetiva.</li>
  </ul>

  <h2>🔐 Configuração de Segurança</h2>
  <p>O projeto utiliza autenticação baseada em JWT. Para acessar as rotas protegidas, é necessário obter um token JWT.</p>

  <h3>Obtendo o Token JWT</h3>
  <p>Para obter um token JWT, faça uma requisição <code>POST</code> para <code>/login</code> com um JSON contendo o <code>email</code> e <code>password</code>:</p>
  <pre>
    <code>
POST /login
{
  "email": "user@example.com",
  "password": "sua-senha"
}
    </code>
  </pre>
  <p>O retorno será o token JWT, que deve ser utilizado no cabeçalho das requisições às rotas protegidas:</p>
  <pre><code>Authorization: Bearer seu-token-jwt</code></pre>

  <h2>📄 JSON para Testes</h2>
  <p><strong>Exemplo de JSON para cadastrar um cliente:</strong></p>
  <pre>
    <code>
POST /clientes
{
  "name": "João da Silva",
  "genero": "Masculino",
  "email": "joao.silva@example.com",
  "password": "senha123",
  "idade": "30"
}
    </code>
  </pre>

  <p><strong>Exemplo de JSON para cadastrar uma compra:</strong></p>
  <pre>
    <code>
POST /compras
{
  "clienteId": 1,
  "produto": "Notebook",
  "valor": 3500.00,
  "quantidade": 1
}
    </code>
  </pre>

  <p><strong>Exemplo de JSON para cadastrar um produto:</strong></p>
  <pre>
    <code>
POST /produtos
{
  "nome": "Cadeira",
  "descricao": "Cadeira de massagem",
  "preco": 4000,
  "quantidade": 1
}
    </code>
  </pre>

  <h2>📋 Requisições</h2>
  <ul>
    <li>GET /clientes: Retorna a lista de clientes</li>
    <li>POST /clientes: Cadastra um novo cliente</li>
    <li>GET /clientes/{id}: Retorna os dados de um cliente</li>
    <li>PUT /clientes/{id}: Atualiza os dados de um cliente</li>
    <li>DELETE /clientes/{id}: Remove um cliente</li>
    <li>GET /compras: Retorna a lista de compras</li>
    <li>POST /compras: Cadastra uma nova compra</li>
    <li>GET /compras/{id}: Retorna os dados de uma compra</li>
    <li>PUT /compras/{id}: Atualiza os dados de uma compra</li>
    <li>DELETE /compras/{id}: Remove uma compra</li>
    <li>GET /produtos: Retorna a lista de produtos</li>
    <li>POST /produtos: Cadastra um novo produto</li>
    <li>GET /produtos/{id}: Retorna os dados de um produto</li>
    <li>PUT /produtos/{id}: Atualiza os dados de um produto</li>
    <li>DELETE /produtos/{id}: Remove um produto</li>
    <li>POST /chat: Envia uma mensagem no chat</li>
    <li>GET /chat/messages: Retorna as mensagens do chat</li>
  </ul>

  <h2>🆕 Diferenças da Sprint 3 para a 4</h2>
  <p>As principais mudanças incluem:</p>
  <ul>
    <li><strong>Reformulação do código para maior padronização</li>
    <li><strong>Melhorias no sistema de cadastro de clientes, produtos e compras</li>
    <li><strong>Novo sistema de Chat</strong> com RabbitMQ para troca de mensagens entre clientes e funcionários</li>
    <li><strong>IA com Groq</strong> para prever a conversão de novos clientes</li>
  </ul>
  
  <p><em>Nota</em>: O código está na branch <code>master</code>.</p>

  <h2>🎥 Link para o Vídeo</h2>
  <p><a href="https://youtu.be/2KBVmzaax78">Veja a demonstração no YouTube</a></p>

</body>
</html>
