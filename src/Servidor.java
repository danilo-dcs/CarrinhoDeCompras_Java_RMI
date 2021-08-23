import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class Servidor extends UnicastRemoteObject implements ServidorInterface {
    
    private Vector<Carrinho> carrinhos;
    private Vector<String> clientes; 

    public Servidor() throws RemoteException {
        System.out.println("Inicializando Servidor");

        carrinhos = new Vector<Carrinho>();         // cada cliente vai ter um carrinho
        clientes = new Vector<String>();
    }

    @Override
    public void newCarrinho(String Nickname) throws RemoteException {

        boolean jaExiste = false;

        for(String cli:clientes){          
            if(cli.equals(Nickname)){
                jaExiste = true;
                break;
            }
        }
        
        if(jaExiste == false){
            Carrinho carrinho = new Carrinho();
            carrinhos.add(carrinho);
            clientes.add(Nickname);
        }else{
            System.out.println("Este cliente ja tem um carrinho");
        }
    }

    @Override
    public Carrinho getCarrinho(String Nickname) throws RemoteException {

        boolean jaExiste = false;

        for(String cli:clientes){          
            if(cli.equals(Nickname)){
                jaExiste = true;
                break;
            }
        }

        if(jaExiste == false){      // se não existe carrinho para este cliente
            return null;
        }

        int index = clientes.indexOf(Nickname);
        return carrinhos.get(index);
    }

    @Override
    public void addProduto(Produto p, String Nickname) throws RemoteException{
        int index = clientes.indexOf(Nickname);
        carrinhos.get(index).addProduto(p);
    }

    @Override
    public void removeProduto(String cod , String Nickname) throws RemoteException{
        int index = clientes.indexOf(Nickname);
        carrinhos.get(index).removerProduto(cod);
    }

    public static void main(String[] args) {

        try {
            ServidorInterface servidor = new Servidor();
            System.out.println("Servidor Inicializado!");

            Naming.rebind("Servidor", servidor);

        } catch (RemoteException re){
            System.out.println("REMOTE EXCEPTION");
            System.out.println(re);
        } catch (MalformedURLException ex){
            System.out.println(ex);
        }

        
    }
}
