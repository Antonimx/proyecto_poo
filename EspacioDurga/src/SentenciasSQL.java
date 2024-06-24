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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class SentenciasSQL {
    private Statement st;
    private Connection conex;
    
    private static DefaultComboBoxModel<String> planes = new DefaultComboBoxModel<>();
    private static DefaultComboBoxModel<String> idPlanes = new DefaultComboBoxModel<>();
    private static DefaultListModel<String> alumnos = new DefaultListModel<>();
    private static DefaultComboBoxModel<String> rutAlumnos = new DefaultComboBoxModel<>();
    private static DefaultListModel<String> activos = new DefaultListModel<>();
    private static DefaultListModel<String> finalizados = new DefaultListModel<>();



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

    public static DefaultComboBoxModel<String> getPlanes() {
        return planes;
    }

    public static DefaultComboBoxModel<String> getIdPlanes() {
        return idPlanes;
    }

    public static DefaultListModel<String> getAlumnos() {
        return alumnos;
    }

    public static DefaultComboBoxModel<String> getRutAlumnos() {
        return rutAlumnos;
    }

    public DefaultListModel<String> getActivos() {
        return activos;
    }

    public DefaultListModel<String> getFinalizados() {
        return finalizados;
    }
    
    public void actualizarBD(){
        planes.removeAllElements();
        idPlanes.removeAllElements();
        alumnos.removeAllElements();
        rutAlumnos.removeAllElements();
        activos.removeAllElements();
        finalizados.removeAllElements();
        conseguirPlanes();
        conseguirAlumnos();
        conseguirContratos();
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

        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(String delete){
        try {
            st.executeUpdate(delete);
            JOptionPane.showMessageDialog(null,"Plan borrado con éxito.","HISTORIAL PLANES CONTRATADOS",JOptionPane.INFORMATION_MESSAGE);

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
                this.planes.addElement(lista.getString("nombre"));
                this.idPlanes.addElement(lista.getString("id"));

            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "select Planes"+ex,"coneccion",3);
        }
    }//conseguirPlanes()
    
    public void conseguirAlumnos(){
        try{
            ResultSet lista = st.executeQuery("SELECT rut, nombre FROM alumno WHERE is_active = 1");
        
            while(lista.next()){
                this.alumnos.addElement(lista.getString("rut")+" "+lista.getString("nombre"));
                this.rutAlumnos.addElement(lista.getString("rut"));

            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "select Alumnos"+ex,"coneccion",3);
        }
    }//conseguirAlumnos()
    
    public void conseguirContratos(){
        try{
            ResultSet lista = st.executeQuery("SELECT * FROM contrato_plan");
        
            while(lista.next()){
                if (lista.getBoolean("is_active")){
                    this.activos.addElement(lista.getString("id")+ " "+lista.getString("rut_alumno")+ " " +lista.getString("inicio_mensualidad"));
                }else{
                    this.finalizados.addElement(lista.getString("id")+ " "+lista.getString("rut_alumno")+ " " + lista.getString("inicio_mensualidad"));
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "select Contratos"+ex,"coneccion",3);
        }
    }
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
                JOptionPane.showMessageDialog(null,"Alumno con ese RUT no encontrado.","ALUMNO",JOptionPane.INFORMATION_MESSAGE);
                sw = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sw;
    }
    
    public boolean validarContratoAlumno(String rut){
        boolean sw = true; //si true == ya hay contrato else no hay contrato
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM contrato_plan WHERE rut_alumno ='"+rut+"' AND is_active=1");
            if (rs.next()){
                JOptionPane.showMessageDialog(null,"El Alumno ya tiene un contrato activo.","Contrato Plan",JOptionPane.ERROR_MESSAGE);

            }else{
                sw = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sw;
    }
}
