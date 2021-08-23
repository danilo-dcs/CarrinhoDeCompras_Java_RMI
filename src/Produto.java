import java.io.Serializable;

public class Produto implements Serializable {
    private String codigo;
    private int quantidade;
    private float valorUnitario;

    public Produto(String cod, int qtd, float valU){
        this.codigo = cod;
        this.quantidade = qtd;
        this.valorUnitario = valU;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
