import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    // Método para cadastrar produto no banco de dados
    public void cadastrarProduto(ProdutosDTO produto) throws SQLException {
        conn = conectaDAO.getConnection(); // Abre a conexão

        try {
            // Prepara o comando SQL de inserção
            String sql = "INSERT INTO Produto (nome, valor, status) VALUES (?, ?, ?)";
            prep = conn.prepareStatement(sql);
            
            // Define os valores nos campos do banco de dados
            prep.setString(1, produto.getNome());
            prep.setDouble(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            
            // Executa a inserção
            int resultado = prep.executeUpdate();

            if (resultado > 0) {
                // Exibe mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            } else {
                // Exibe mensagem de falha
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto.");
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ProdutosDAO cadastrarProduto: " + erro.getMessage());
        } finally {
            try {
                // Fecha a conexão
                if (prep != null) prep.close();
                if (conn != null) conn.close();
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + erro.getMessage());
            }
        }
    }

    // Método para listar todos os produtos do banco de dados
    public ArrayList<ProdutosDTO> listarProdutos() throws SQLException {
        conn = conectaDAO.getConnection(); // Abre a conexão
        String sql = "SELECT * FROM Produto";
        
        try {
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();

            while (resultset.next()) {
                // Criar objeto ProdutoDTO para cada registro no banco
                ProdutosDTO produto = new ProdutosDTO();
                produto.setIdProduto(resultset.getInt("idproduto"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getDouble("valor"));
                produto.setStatus(resultset.getString("status"));

                // Adiciona o produto à lista de produtos
                listagem.add(produto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ProdutosDAO listarProdutos: " + erro.getMessage());
        } finally {
            try {
                // Fecha a conexão
                if (resultset != null) resultset.close();
                if (prep != null) prep.close();
                if (conn != null) conn.close();
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + erro.getMessage());
            }
        }

        // Retorna a lista de produtos
        return listagem;
    }
}
