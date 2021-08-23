import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Cliente {

    private static String host = "Servidor";
    public static void main(String[] args) {
        
        System.out.println("Inicializando cliente ...");
        System.out.println("Srvidor: " + host);

        try {
            Scanner entrada = new Scanner(System.in);
            ServidorInterface servidor = (ServidorInterface) Naming.lookup(host);
            System.out.println("Cliente Conectado!\n\n");

            System.out.println("Digite o nome de usuario para iniciar sessao: ");
            String userName = entrada.nextLine();

            boolean sair = false; 

            
            while(sair == false){

                int op;

                do{
                    System.out.println("\n-- Menu -- ");
                    System.out.println("1. Iniciar carrinho ");
                    System.out.println("2. Consultar carrinho/listar produtos ");
                    System.out.println("3. Cadastrar Produto ");
                    System.out.println("4. Remover Produto ");
                    System.out.println("5. Consultar valor total ");
                    System.out.println("6. Sair ");
                    op = Integer.parseInt(entrada.nextLine());
                }while(op!=1 && op!=2 && op!=3 && op!=4 && op!=5 && op!=6 );

            
                if(op==1){

                    servidor.newCarrinho(userName);
                    System.out.println("Carrinho iniciado");

                }else if(op==2){

                    Carrinho carrinho = servidor.getCarrinho(userName);

                    if(carrinho == null){
                        System.out.println("Nao existe carrinho para este cliente! ");
                    }else{
                        carrinho.listarProdutos();
                    }

                }else if(op==3){

                    System.out.println("Digite o codigo do produto: ");
                    String cod = entrada.nextLine();
                    System.out.println("Digite a quanidade do produto: ");
                    int qtd = Integer.parseInt(entrada.nextLine());
                    System.out.println("Digite o valor unitario do produto: (usar ponto para casas decimais) ");
                    float valU =  Float.parseFloat(entrada.nextLine());

                    Produto p = new Produto(cod, qtd, valU);            // cria novo produto
                    servidor.addProduto(p, userName);

                }else if(op==4){

                    System.out.println("Digite o codigo do produto a ser removido: ");
                    String cod = entrada.nextLine();
                    servidor.removeProduto(cod, userName);

                }else if(op == 5){
                    Carrinho carrinho = servidor.getCarrinho(userName);

                    
                    if(carrinho == null){
                        System.out.println("Nao existe carrinho para este cliente! ");
                    }else{
                        carrinho.mostrarTotal();
                    }
                }else{
                    sair = true;
                }
            }

            entrada.close();

        } catch (RemoteException e) {
            System.out.println(e);
        } catch (NotBoundException ne){
            System.out.println(ne);
        } catch (MalformedURLException me){
            System.out.println(me);
        }



    }
    
}
