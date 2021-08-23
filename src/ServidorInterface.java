import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidorInterface extends Remote {
    public void newCarrinho(String Nickname) throws RemoteException;
    public Carrinho getCarrinho(String Nickname) throws RemoteException;
    public void addProduto(Produto p, String Nickname) throws RemoteException;
    public void removeProduto(String cod, String Nickname) throws RemoteException;
}
