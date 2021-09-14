package Model.VO;

public class LaudoVO {
    private String IdMedico;
    private String IdPaciente;
    private String IdConsulta;
    private String Observacoes;

    public LaudoVO(String IdMedico, String IdPaciente, String IdConsulta, String Observacoes) {
        this.IdMedico = IdMedico;
        this.IdPaciente = IdPaciente;
        this.IdConsulta = IdConsulta;
        this.Observacoes = Observacoes;
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

    
    public String getIdConsulta() {
        return this.IdConsulta;
    }

    public void setIdConsulta(String IdConsulta) {
        if(IdConsulta == null){
            System.out.println("Erro. Campo de Consulta não preenchido");
        }
        else if (IdConsulta.equals("")){
            System.out.println("Erro. Campo de Consulta vazio");
        }
        else this.IdConsulta = IdConsulta;
    }

    
    public String getObservacoes() {
        return this.Observacoes;
    }

    public void setObservacoes(String Observacoes) {

        if(Observacoes == null){
            System.out.println("Erro. Campo de Observações não preenchido");
        }
        else if (Observacoes.equals("")){
            System.out.println("Erro. Campo de Observações vazio");
        }
        else this.Observacoes = Observacoes;
    }
}
