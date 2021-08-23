import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarrinhoInterface extends Remote {
    public void addProduto(Produto p) throws RemoteException;
    public void removerProduto(String cod) throws RemoteException;
    public void listarProdutos() throws RemoteException;
    public void mostrarTotal() throws RemoteException;
    public void insereFrete(float valor) throws RemoteException;
    public void mostraFrete() throws RemoteException;
}
