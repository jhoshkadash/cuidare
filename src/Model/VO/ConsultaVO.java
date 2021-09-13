package Model.VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConsultaVO {
    private Integer id;
    private Calendar data = Calendar.getInstance();
    private Boolean status;
    private String idMedico;
    private String idPaciente;

    public ConsultaVO(Integer Id, String Data, Calendar Hora, Boolean Status, String IdMedico, String IdPaciente) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            this.data.setTime(formato.parse(Data));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.id = Id;
        this.status = Status;
        this.idMedico = IdMedico;
        this.idPaciente = IdPaciente;
    }

    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer Id) {
        if(Id == null){
            System.out.println("Erro. Consulta sem id");
        }
        else if(Id.equals("")){
            System.out.println("Erro. Consulta sem id");
        }
        else this.id = Id;
    }

    
    public Calendar getData() {
        return this.data;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public void setStatus(Boolean Status) {
        this.status = Status;
    }

    
    public String getIdMedico() {
        return this.idMedico;
    }

    public void setIdMedico(String IdMedico) {

        if(IdMedico == null){
            System.out.println("Erro. Campo de medico não preenchido");
        }
        else if (IdMedico.equals("")){
            System.out.println("Erro. Campo de Medico vazio");
        }
        else this.idMedico = IdMedico;
    }
    

    public String getIdPaciente() {
        return this.idPaciente;
    }

    public void setIdPaciente(String IdPaciente) {
        
        if(IdPaciente == null){
            System.out.println("Erro. Campo de Paciente não preenchido");
        }
        else if (IdPaciente.equals("")){
            System.out.println("Erro. Campo de Paciente vazio");
        }
        else this.idPaciente = IdPaciente;
    }
}
