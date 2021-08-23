# CarrinhoDeCompras_Java_RMI

## Objetivo

Escrever um programa Cliente/Servidor, usando java RMI, para controlar as informações de 
um carrinho de compras de um site.

<b>Informações dos carrinhos: </b>
<br>

<ul>
    <li>Código do produto</li>
    <li>Quantidade</li>
    <li>Valor unitário</li>
    <li>Valor total do carrinho</li>
    <li>Frete</li>
</ul>

## Operações sobre o carrinho

<ul>
    <li>Adicionar Produto</li>
    <li>Remover Produto</li>
    <li>Valor unitário</li>
    <li>Listar Produtos</li>
    <li>Pesquisar um produto</li>
    <li>Mostrar total da compra</li>
</ul>


## Executando o Programa

Certifique-se de instalar o JDK na sua máquina. Com o JDK instalado, abrir o terminal no diretório './src' e executar os comandos abaixo:

```
javac *.java           # compilando os arquivos java
start rmiregistry      # Iniciando o registro RMI
java Servidor          # Executando o servidor
java Cliente           # Executando o cliente
```
