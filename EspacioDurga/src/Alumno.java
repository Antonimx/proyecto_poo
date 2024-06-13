import java.sql.Connection;
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
    private String insert;
    
    public Alumno(String rut, String nombre, Date fecha_nac, String direccion, String telefono, String observaciones, int plan_mensual_id) {
        this.rut = rut;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
        this.fono = telefono;
        this.observaciones = observaciones;
        this.plan_mensual_id = plan_mensual_id;
        this.insert = "INSERT INTO alumno VALUES('"+rut+"','"+nombre+"','"+fecha_nac+"','"+direccion+"','"+fono+"','"+observaciones+"',"+is_active+","+plan_mensual_id+")";

    }

    public Alumno() {
    }

    public String getInsert() {
        return insert;
    }

    public int getPlan_mensual_id() {
        return plan_mensual_id;
    }
    
    
    
    
    
    
    
}
