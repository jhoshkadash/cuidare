package Model.VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsultaVO {
    private Integer id, idMedico, idPaciente;
    private Boolean status;
    private Calendar dataConsulta = Calendar.getInstance();

    public void setDataConsulta(String dConsulta) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            this.dataConsulta.setTime(formato.parse(dConsulta));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Calendar getDataConsulta(){
        return this.dataConsulta;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer Id) {
        if (Id == null) {
            System.out.println("Erro. Consulta sem id");
        } else if (Id.equals("")) {
            System.out.println("Erro. Consulta sem id");
        } else
            this.id = Id;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public void setStatus(Boolean Status) {
        this.status = Status;
    }

    public Integer getIdMedico() {
        return this.idMedico;
    }

    public void setIdMedico(Integer IdMedico) {

        if (IdMedico == null) {
            System.out.println("Erro. Campo de medico não preenchido");
        } else if (IdMedico.equals("")) {
            System.out.println("Erro. Campo de Medico vazio");
        } else
            this.idMedico = IdMedico;
    }

    public Integer getIdPaciente() {
        return this.idPaciente;
    }

    public void setIdPaciente(Integer IdPaciente) {

        if (IdPaciente == null) {
            System.out.println("Erro. Campo de Paciente não preenchido");
        } else if (IdPaciente.equals("")) {
            System.out.println("Erro. Campo de Paciente vazio");
        } else
            this.idPaciente = IdPaciente;
    }
}
