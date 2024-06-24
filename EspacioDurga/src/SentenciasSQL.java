import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Date;

public class SentenciasSQL {
    private Statement st;
    private Connection conex;
    
    private static ArrayList<String> listaPlanes = new ArrayList<>();
    private static ArrayList<String> listaIdPlanes = new ArrayList<>();
    private static ArrayList<String> alumnos = new ArrayList<>() ;
    private static ArrayList<String> rutAlumnos = new ArrayList<>();


    public SentenciasSQL(){}
    
    public void conectar(){
        String url = "jdbc:mysql://localhost:3306/proyecto_poo";
        String usuario = "root";
        String pass = "";
        try{
            this.conex=DriverManager.getConnection(url,usuario,pass);
            JOptionPane.showMessageDialog(null,"conectado","coneccion",1);
        }catch(Exception ex){
            System.out.println("error en conexion: "+ex);
        }
        
        try {
            this.st = conex.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public ArrayList<String> getListaPlanes() {
        return listaPlanes;
    }

    public ArrayList<String> getListaIdPlanes() {
        return listaIdPlanes;
    }

    public ArrayList<String> getAlumnos() {
        return alumnos;
    }

    public ArrayList<String> getRutAlumnos() {
        return rutAlumnos;
    }
    
    
    
    public void guardar(String insert){
        try {
            st.executeUpdate(insert);
            JOptionPane.showMessageDialog(null,"datos insertados", "connecion",1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error insert "+ex, "insert",3);
        }
    }
    public void update(String update){
        try {
            st.executeUpdate(update);
            JOptionPane.showMessageDialog(null,"Asistencia tomada correctamente","ASISTENCIA",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public byte getNumClases(int plan_mensual_id){
        byte num_clases = 0;
        try{
            ResultSet rs = st.executeQuery("SELECT n_clases FROM plan_mensual WHERE id = "+ plan_mensual_id);
            if (rs.next()){
                num_clases = rs.getByte("n_clases");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "select "+ex,"coneccion",3);
        }
        return num_clases;
    }
    
    public void conseguirPlanes(){
        try{
            ResultSet lista = st.executeQuery("SELECT id, nombre FROM plan_mensual");
        
            while(lista.next()){
                this.listaPlanes.add(lista.getString("nombre"));
                this.listaIdPlanes.add(lista.getString("id"));

            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "select Planes"+ex,"coneccion",3);
        }
    }//conseguirPlanes()
    
    public void conseguirAlumnos(){
        try{
            ResultSet lista = st.executeQuery("SELECT rut, nombre FROM alumno WHERE is_active = 1");
        
            while(lista.next()){
                this.alumnos.add(lista.getString("rut")+" "+lista.getString("nombre"));
                this.rutAlumnos.add(lista.getString("rut"));

            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "select Alumnos"+ex,"coneccion",3);
        }
    }//conseguirAlumnos()
    
    public ContratoPlan conseguirContrato(String rut,ContratoPlan contrato){
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM contrato_plan WHERE rut_alumno ='"+rut+"' AND is_active=1");
            if (rs.next()){
                contrato.setId(rs.getInt("id"));
                contrato.setRut_alumno(rut);
                contrato.setPlan_mensual_id(rs.getInt("plan_mensual_id"));
                contrato.setInicio_mensualidad(rs.getDate("inicio_mensualidad"));
                contrato.setFin_mensualidad(rs.getDate("fin_mensualidad"));
                contrato.setN_dias(rs.getByte("n_dias"));
            }else{
                JOptionPane.showMessageDialog(null,"Alumno con ese RUT no tiene un plan contratado.","ALUMNO",JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contrato;
    }//conseguirContrato
    
    public boolean validarRut(String rut){
        boolean sw = true;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM alumno WHERE rut ='"+rut+"'");
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Alumno encontrado.","ALUMNO",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"Alumno con ese RUT no encontrado.","ALUMNO",JOptionPane.ERROR_MESSAGE);
                sw = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sw;
    }
}
