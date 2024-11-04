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
<p>Este projeto é um sistema de gestão de clientes e compras, com funcionalidades de chat, assistência virtual e monitoramento de métricas com o Spring Actuator. Ele permite criar, visualizar, editar e excluir dados de clientes e suas compras, além de oferecer:</p>
<ul>
  <li>Autenticação com Spring Security</li>
  <li>Envio de e-mail de boas-vindas para novos clientes</li>
  <li>Sistema de chat, onde clientes podem fazer perguntas e obter respostas de outros clientes ou funcionários</li>
  <li>Assistente virtual com IA para prever a probabilidade de um novo cliente se tornar cliente da Plusoft</li>
  <li>Monitoramento e métricas com Spring Actuator</li>
</ul>

<h2>🚀 Tecnologias Utilizadas</h2>
<ul>
  <li>Java 17</li>
  <li>Spring Boot 3.3.2</li>
  <li>Spring Security</li>
  <li>Spring Actuator</li>
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
  <li><strong>Monitoramento de métricas com Spring Actuator</strong>: Acompanhe o status e a saúde da aplicação através dos endpoints do Actuator.</li>
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
  <li><strong>Clientes:</strong></li>
  <ul>
    <li><code>GET /clientes</code>: Retorna a lista de clientes.</li>
    <li><code>POST /clientes</code>: Cadastra um novo cliente.</li>
    <li><code>GET /clientes/{id}</code>: Retorna os dados de um cliente específico.</li>
    <li><code>PUT /clientes/{id}</code>: Atualiza os dados de um cliente.</li>
    <li><code>DELETE /clientes/{id}</code>: Remove um cliente.</li>
  </ul>

  <li><strong>Compras:</strong></li>
  <ul>
    <li><code>GET /compras</code>: Retorna a lista de compras.</li>
    <li><code>POST /compras</code>: Cadastra uma nova compra.</li>
    <li><code>GET /compras/{id}</code>: Retorna os dados de uma compra específica.</li>
    <li><code>PUT /compras/{id}</code>: Atualiza os dados de uma compra.</li>
    <li><code>DELETE /compras/{id}</code>: Remove uma compra.</li>
  </ul>

  <li><strong>Produtos:</strong></li>
  <ul>
    <li><code>GET /produtos</code>: Retorna a lista de produtos.</li>
    <li><code>POST /produtos</code>: Cadastra um novo produto.</li>
    <li><code>GET /produtos/{id}</code>: Retorna os dados de um produto específico.</li>
    <li><code>PUT /produtos/{id}</code>: Atualiza os dados de um produto.</li>
    <li><code>DELETE /produtos/{id}</code>: Remove um produto.</li>
  </ul>

  <li><strong>Chat:</strong></li>
  <ul>
    <li><code>POST /chat</code>: Envia uma mensagem no chat.</li>
    <li><code>GET /chat/messages</code>: Retorna as mensagens do chat.</li>
  </ul>
</ul>

<h2>📊 Monitoramento com Spring Actuator</h2>
<p>O projeto utiliza o <strong>Spring Actuator</strong> para monitoramento de métricas e informações do sistema em tempo real. Com as configurações feitas, todos os endpoints do Actuator estão disponíveis, fornecendo detalhes sobre o status e desempenho da aplicação.</p>

<h3>🔧 Configurações</h3>
<pre><code>
management.endpoint.health.show-details=ALWAYS
management.endpoints.web.exposure.include=*
</code></pre>
<p>Essas configurações garantem que todos os endpoints do Actuator estejam expostos e que o endpoint de saúde (<code>/actuator/health</code>) exiba detalhes completos.</p>

<h3>📍 Endpoints Disponíveis</h3>
<ul>
  <li><code>/actuator/health</code>: Mostra o status de saúde da aplicação com detalhes dos componentes.</li>
  <li><code>/actuator/metrics</code>: Exibe diversas métricas, como uso de CPU, memória e tempo de resposta.</li>
  <li><code>/actuator/loggers</code>: Permite visualizar e ajustar os níveis de loggers da aplicação.</li>
  <li><code>/actuator/info</code>: Exibe informações adicionais sobre o projeto, como versão e descrição, se configuradas.</li>
</ul>

<p>Esses endpoints podem ser acessados diretamente no navegador ou integrados com ferramentas de monitoramento para uma visualização mais prática do desempenho e status do sistema.</p>

<h2>🆕 Diferenças da Sprint 3 para a 4</h2>
<p>As principais mudanças incluem:</p>
<ul>
  <li><strong>Reformulação do código</strong> para maior padronização</li>
  <li><strong>Melhorias no sistema de cadastro</strong> de clientes, produtos e compras</li>
  <li><strong>Novo sistema de Chat</strong> com RabbitMQ para troca de mensagens entre clientes e funcionários</li>
  <li><strong>IA com Groq</strong> integrada para análise de potencial de clientes</li>
  <li><strong>Spring Actuator</strong> para monitoramento do sistema em tempo real</li>
</ul>

  <h2>🗨 Diagrama final da solução</h2>
  <p><img src="https://github.com/user-attachments/assets/53e91924-3f84-4aee-8ef5-7dc40e5432d2" alt="Diagrama do projeto"></p>

  <h2>🎥 Link para o Vídeo</h2>
  <p><a href="https://youtu.be/2KBVmzaax78">Veja a demonstração no YouTube</a></p>

  <p><em>Nota</em>: O código está na branch <code>master</code>.</p>

</body>
</html>
