#Sistema Bancário com Threads em Java

Este projeto representa um sistema bancário que utiliza threads e os conceitos estudados em sala de aula. O sistema é composto por diferentes entidades, como banco, loja, funcionário, cliente e conta. O objetivo é simular transações bancárias entre essas entidades de forma coordenada, garantindo a consistência dos saldos das contas.

Entidades do Sistema

Banco
Responsável por intermediar as transações de forma síncrona e coordenada.
Garante a consistência dos saldos das contas.
Loja
Possui uma conta para receber os pagamentos dos clientes.
Paga os funcionários assim que possui o valor dos seus salários.
Funcionário
Cada funcionário é uma thread.
Possui duas contas: uma para receber o salário da loja e outra de investimentos.
Investe 20% do salário na conta de investimentos logo após o recebimento.
Cliente
Cada cliente é uma thread.
Possui uma conta com um saldo inicial de R$ 1.000,00.
Realiza compras de R$ 100,00 ou R$ 200,00, alternando entre as lojas, até que o saldo da conta esteja vazio.
Conta
Representa a conta bancária de cada entidade.
Mantém o saldo e registra as transações.
Configuração do Sistema

O sistema é configurado com as seguintes entidades:

1 banco
2 lojas
4 funcionários (2 por loja)
5 clientes
Funcionamento do Sistema

As transações ocorrem da seguinte forma:

Os clientes realizam compras nas lojas, alternando entre elas, até que o saldo da conta esteja vazio.
As lojas recebem os pagamentos dos clientes e pagam os salários dos funcionários.
Os funcionários recebem seus salários e investem 20% do valor na conta de investimentos.
O banco garante a consistência das transações e dos saldos das contas.
Ao final da execução, o sistema exibe o valor das transferências e o saldo final de cada conta, garantindo que os saldos estejam consistentes, independentemente da ordem em que as transações foram realizadas.

Requisitos do Projeto

Linguagem: Java 17
Utilização de threads para representar as entidades do sistema
Garantia da consistência dos saldos das contas através da coordenação pelo banco
Execução do Projeto

Para executar o projeto, basta compilar e rodar o arquivo principal. Certifique-se de ter o ambiente de desenvolvimento configurado corretamente para Java 17.

bash
Copy code
javac Main.java
java Main
Autor

Este projeto foi desenvolvido por [Seu Nome].

Copyright © 2024. Todos os direitos reservados.
