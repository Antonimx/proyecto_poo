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
    private String insert;

    public Alumno(String rut, String nombre, Date fecha_nac, String direccion, String fono, String observaciones) {
        this.rut = rut;
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
        this.fono = fono;
        this.observaciones = observaciones;
        this.insert = "INSERT INTO alumno VALUES('"+rut+"','"+nombre+"','"+fecha_nac+"','"+direccion+"','"+fono+"','"+observaciones+"',"+is_active+")";
    }
    


    public Alumno() {
    }

    public String getInsert() {
        return insert;
    }

    
    
    
    
    
    
    
}
