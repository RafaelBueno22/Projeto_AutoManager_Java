package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    public static Connection conectar(){
        Connection conexao = null;
        
        String url = "jdbc:postgresql://localhost/AutoManager_T261T";
        String usuario = "postgres";
        String senha = "root";
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Banco conectado com SUCESSO!");
        } catch (SQLException erro) {
            System.out.println("ERRO ao conectar com o banco - Erro: " + erro);
        }
        return conexao;
    }
        
        
}
