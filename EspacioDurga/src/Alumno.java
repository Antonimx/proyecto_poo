import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Date;


public class Alumno {
    private String rut;
    private String nombre;
    private Date fecha_nac;
    private String direccion;
    private String fono;
    private String observaciones;
    private boolean is_active = true;
    private int plan_mensual_id;

    private Connection conex;
    private Statement st;
    public Alumno(String rut, String nombre, Date fecha_nac, String direccion, String telefono, String observaciones, int plan_mensual_id, Connection conex) {
        this.rut = rut;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
        this.fono = telefono;
        this.observaciones = observaciones;
        this.plan_mensual_id = plan_mensual_id;
        
        this.conex = conex;
    }

    public Alumno() {
    }
    
    public void guardar(){
        String insert = "INSERT INTO alumno VALUES('"+rut+"','"+nombre+"','"+fecha_nac+"','"+direccion+"','"+fono+"','"+observaciones+"',"+is_active+","+plan_mensual_id+")";
        try {
            st = conex.createStatement();
            st.executeUpdate(insert);
            JOptionPane.showMessageDialog(null,"datos insertados", "connecion",1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error insert "+ex, "insert",3);
        }
    }
    
    
    
}
