import java.sql.Connection;
import java.sql.Date;

public class ContratoPlan {
    private String rut_alumno;
    private Date inicio_mensualidad;
    private Date fin_mensualidad;
    private byte n_dias;
    private boolean is_active = true;
    private String insert;
    
    public ContratoPlan(String rut_alumno, Date inicio_mensualidad, Date fin_mensualidad, byte n_dias) {
        this.rut_alumno = rut_alumno;
        this.inicio_mensualidad = inicio_mensualidad;
        this.fin_mensualidad = fin_mensualidad;
        this.n_dias = n_dias;
        this.insert = "INSERT INTO contrato_plan VALUES("+null+",'"+rut_alumno+"','"+inicio_mensualidad+"','"+fin_mensualidad+"',"+n_dias+","+is_active+")";
    }
    
    public String getInsert() {
        return insert;
    }
    
    
    /*public void definirAsistencia(String fecha_hoy){
        Alumno alumno = new Alumno(); //esto representa cuando se busca el alumno en la bd segun el rut.
        if (alumno.getIs_active() == false){
            System.out.println("El alumno tiene la mensualidad vencida. Debe renovar plan");
        } else if(fecha_hoy.equals(fin_mensualidad)){ //esto en verdad seria si la fecha de hoy es mayor a la del fin de la mensualidad.
            System.out.println("El alumno tiene la mensualidad vencida. Debe renovar plan");
            alumno.setIs_active(false);

        } else{
            if (fecha_hoy.equals(fin_mensualidad)){ //este SI representa que hoy es el ultimo dia de mensualidad
                System.out.println("Este es el ultimo día de mensualidad. Si quiere continuar en próximos días debe renovar plan.");
                alumno.setIs_active(false);
            }
            
            if (es_libre == false){
                if (n_dias > 0){
                    n_dias--;
                    if (n_dias==0) {
                       System.out.println("Esta es su última clase. Si quiere continuar en próximos días debe renovar plan.");
                       alumno.setIs_active(false);
                    }
                }
            }
        }
    }*/

    
    
}
