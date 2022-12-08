

# Diagrama de Classe

## Versão
| Data | Versão | Descrição | Autor |
|:----:|:------:|:---------:|:---------:|
| 07/12/2022 | 0.1 | Criação do Documento | [Lucas Sales](https://github.com/LucasPetruci) |
| 08/12/2022 | 0.2 | Adição do Diagrama de classe | [Lucas Sales](https://github.com/LucasPetruci) |

## mini-mundo
Requisitos 

1.Os seguintes perfis podem usar o sistema: cliente, funcionário e gerente.

2.O sistema consiste em manter os produtos cadastrados e informações, além dos de algumas especificidades enumeradas abaixo.

3.O gerente deve cadastrar seus funcionários, de acordo com o horário de trabalho, para permitir que o funcionário tenha acesso para permitir cadastrar o usuário.

4.Os funcionários devem cadastrar os produtos contendo as informações especificadas enumeradas abaixo.

5.Os tipos de produtos são cadastrados a priori, tendo sua descrição, foto, preço, nome do fabricante, princípio ativo e outras observações.

6.Cada produto é cadastrado com uma identificação.

7.Para consultar os produtos o usuário não precisa estar cadastrado.

8.Para se tornar cliente o usuário deve realizar um cadastro. Os seus principais dados são: email, senha, nome, telefone, cpf, e endereço completo.
  
9.O pedido deve conter os seguintes dados: identificação, hora, data, valor e quantidade.

10.No momento da realização do pedido o cliente deve estar logado no sistema. O funcionário deve registrar o pedido subtraindo do estoque, anotando o produto escolhido, preço e quantidade, após o pagamento do pedido.

11.No encerramento da compra, o sistema deve verificar se consta o pagamento do produto.

12.Após a compra, o funcionário deve entregar o produto ao entregador, e atualizar no sistema sobre a entrega. 

13.Após o encerramento da compra, o cliente pode verificar a entrega do produto através do sistema. 


Requisitos não funcionais

O sistema deverá rodar em ambiente web.

A consulta de disponibilidade não exige o cadastro prévio para uso.

Os dados do cliente devem ser criptografados. 

Os pagamentos devem ser realizados por um Gateway de Pagamento cujo processamento não cabe ao sistema.



## Diagrama de Classe

![diagrama de classe drogaria](https://user-images.githubusercontent.com/99514230/206350525-4d891ee1-92a5-46f2-861c-3680cc1078e4.png)

