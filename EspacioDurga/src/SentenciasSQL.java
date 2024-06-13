import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class SentenciasSQL {
    
    public Connection conectar(Connection conex,Statement st){
        String url = "jdbc:mysql://localhost:3306/proyecto_poo";
        String usuario = "root";
        String pass = "";
        try{
            conex=DriverManager.getConnection(url,usuario,pass);
            JOptionPane.showMessageDialog(null,"conectado","coneccion",1);
        }catch(Exception ex){
            System.out.println("error en conexion: "+ex);
        }
        return conex;
    }
    
    
}
