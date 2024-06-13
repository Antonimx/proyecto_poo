import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SentenciasSQL {
    private Statement st;
    private Connection conex;
    
    public SentenciasSQL(){}
    
    public Connection conectar(){
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
    
    public void guardar(String insert){
        try {
            st = conex.createStatement();
            st.executeUpdate(insert);
            JOptionPane.showMessageDialog(null,"datos insertados", "connecion",1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error insert "+ex, "insert",3);
        }
    }
    
    public byte getNumClases(int plan_mensual_id){
        byte num_clases = 0;
        try{
            st=conex.createStatement();
            ResultSet rs = st.executeQuery("SELECT num_clases FROM plan_mensual WHERE id = "+ plan_mensual_id);
            if (rs.next()){
                num_clases = rs.getByte("num_clases");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "select "+ex,"coneccion",3);
        }
        return num_clases;
    }
}
