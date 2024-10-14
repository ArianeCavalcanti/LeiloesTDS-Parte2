package dto;


/**
 * @author Ariane
 * @version 1.0
 * @since Primeira versão
 */
public class ProdutosDTO {

    private Integer id;
    private String nome;
    private Double valor;
    private String status;

    // Getters e Setters para os atributos
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIdProduto(int id) {
        this.id = id;
    }
}
