
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class ContratoPlan {
    private int id;
    private String rut_alumno;
    private int plan_mensual_id;
    private Date inicio_mensualidad;
    private Date fin_mensualidad;
    private byte n_dias;
    private boolean is_active = true;
    private String insert;
    private String update;

    public ContratoPlan(String rut_alumno, int plan_mensual_id, Date inicio_mensualidad, Date fin_mensualidad, byte n_dias) {
        this.rut_alumno = rut_alumno;
        this.plan_mensual_id = plan_mensual_id;
        this.inicio_mensualidad = inicio_mensualidad;
        this.fin_mensualidad = fin_mensualidad;
        this.n_dias = n_dias;
        this.insert = "INSERT INTO contrato_plan VALUES("+null+",'"+rut_alumno+"',"+plan_mensual_id+",'"+inicio_mensualidad+"','"+fin_mensualidad+"',"+n_dias+","+is_active+")";
    }

    public ContratoPlan() {  
    }

    public Date getFin_mensualidad() {
        return fin_mensualidad;
    }
    
    public String getInsert() {
        return insert;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRut_alumno(String rut_alumno) {
        this.rut_alumno = rut_alumno;
    }

    public void setPlan_mensual_id(int plan_mensual_id) {
        this.plan_mensual_id = plan_mensual_id;
    }

    public void setInicio_mensualidad(Date inicio_mensualidad) {
        this.inicio_mensualidad = inicio_mensualidad;
    }

    public void setFin_mensualidad(Date fin_mensualidad) {
        this.fin_mensualidad = fin_mensualidad;
    }

    public void setN_dias(byte n_dias) {
        this.n_dias = n_dias;
        
    }

    public String getUpdate() {
        return update;
    }
    
    public void tomarAsistencia(){
        if ((LocalDate.now()).isAfter(fin_mensualidad.toLocalDate())){ //Si se venció la mensualidad porque se paso de los dias 
            JOptionPane.showMessageDialog(null,"El último día de mensualidad disponible fue el "+fin_mensualidad,"MENSUALIDAD VENCIDA",JOptionPane.WARNING_MESSAGE);
            this.is_active=false;
        }else{
            if(n_dias>0){
                n_dias--;
                if(n_dias==0){
                    JOptionPane.showMessageDialog(null,"Esta es su última clase.\nSi desea venir a otra clase debe renovar mensualidad.","ÚLTIMA CLASE DISPONIBLE",JOptionPane.INFORMATION_MESSAGE);
                    this.is_active=false;
                }  
            }
        }
        if(this.is_active){
            JOptionPane.showMessageDialog(null,"Días disponibles: "+n_dias+"\nFecha de término de la mensualidad: "+fin_mensualidad,"ASISTENCIA",JOptionPane.INFORMATION_MESSAGE);
        }
        this.update = "UPDATE contrato_plan SET n_dias="+n_dias+", is_active="+is_active+" WHERE id="+id;
    }

    
    
}
