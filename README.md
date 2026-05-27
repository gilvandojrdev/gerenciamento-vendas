# Gerenciamento de vendas

Um sistema responsável por gerenciar as vendas de uma determinada loja, permitindo o cadastro de clientes com informações pessoais, como:

- Nome
- Idade
- Salário

Além disso, o sistema também armazenará informações financeiras relacionadas à loja, como:

- Valores pendentes
- Valores pagos
- Identificação do cliente por ID (numeração única)

## Regras de negócio da loja

- Caso o cliente possua salário de até **R$ 600,00**, ele terá um limite de crédito de apenas **R$ 300,00** na loja.
- O sistema deverá realizar automaticamente a verificação salarial no momento do cadastro do cliente.
- A cada venda realizada, será adicionada uma taxa de **R$ 1,00** sobre o valor da compra.