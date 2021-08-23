import java.io.Serializable;
// import java.rmi.RemoteException;
import java.util.Vector;

public class Carrinho implements Serializable{

    Vector<Produto> produtos;
    private float frete;
    private float total;

    public Carrinho(){
        produtos = new Vector<Produto>();
        this.frete = 0;
        this.total = 0;
    }

    public void insereFrete(float valor) {
        this.frete = valor;
    }

    public void mostraFrete(){
        System.out.println("\nO frete e : R$" + this.frete);
    }

    public void addProduto(Produto p){
        produtos.add(p);
    }

    public void removerProduto(String cod){

        int removeIndex = -1;               // busca o elemento no vetor

        for(int i=0; i < produtos.size(); i++){
            if(cod.equals(produtos.get(i).getCodigo())){            // se encontou o código 
                removeIndex = i;
                break;
            }
        }

        if(removeIndex != -1){          // se encontrou o produto para remover
            produtos.remove(removeIndex);
        }else{
            System.out.println("Este item nao se encontra na lista de prosutos");
        }

    }

    public void listarProdutos(){
        if(produtos.size() > 0){
            System.out.println("\n");
            for(Produto p:produtos){
                System.out.println("Codigo: " + p.getCodigo() + " - Valor: " + p.getValorUnitario() + " - Qtd: " + p.getQuantidade());
            }
            System.out.println("\n");
        } else{
            System.out.println("\nNao tem produtos cadastrados\n" );
        }
    }

    public void mostrarTotal(){

        this.total = 0;

        if(produtos.size() > 0){            // calcula total
            for(Produto p:produtos){
                this.total += p.getValorUnitario()*p.getQuantidade(); 
            }
        }else{
            System.out.println("\nTotal da compra: R$0.00\n" );
        }

        System.out.println("\nTotal da compra: R$" + this.total + "\n");
    }

}