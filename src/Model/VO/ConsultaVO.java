
import java.util.Calendar;

public class ConsultaVO {
    private String Id;
    private Calendar Data = Calendar.getInstance();
    private Calendar Hora = Calendar.getInstance();
    private Boolean Status;
    private String IdMedico;
    private String IdPaciente;


    public String getId() {
        return this.Id;
    }

    public void setId(String Id) {
        if(Id == null){
            System.out.println("Erro. Consulta sem id");
        }
        else if(Id.equals("")){
            System.out.println("Erro. Consulta sem id");
        }
        else this.Id = Id;
    }

    public Calendar getData() {
        return this.Data;
    }

    public void setData(Calendar Data) {
        if(Data == null){
            System.out.println("Erro. Campo de data não preenchido");
        }
        else this.Data = Data;
    }

    public Calendar getHora() {
        return this.Hora;
    }

    public void setHora(Calendar Hora) {
        if(Hora == null){
            System.out.println("Erro. Campo de hora não preenchido");
        }
        else this.Hora = Hora;
    }

    public Boolean isStatus() {
        return this.Status;
    }

    public Boolean getStatus() {
        return this.Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    public String getIdMedico() {
        return this.IdMedico;
    }

    public void setIdMedico(String IdMedico) {

        if(IdMedico == null){
            System.out.println("Erro. Campo de medico não preenchido");
        }
        else if (IdMedico.equals("")){
            System.out.println("Erro. Campo de Medico vazio");
        }
        else this.IdMedico = IdMedico;
    }

    public String getIdPaciente() {
        return this.IdPaciente;
    }

    public void setIdPaciente(String IdPaciente) {
        
        if(IdPaciente == null){
            System.out.println("Erro. Campo de Paciente não preenchido");
        }
        else if (IdPaciente.equals("")){
            System.out.println("Erro. Campo de Paciente vazio");
        }
        else this.IdPaciente = IdPaciente;
    }
    
}