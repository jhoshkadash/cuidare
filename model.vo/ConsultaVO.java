public class ConsultaVO {
    private String paciente;
    private String medico;
    private String data;
    private String hora;
    private boolean status;

    public String getPaciente() {
        return paciente;
    }
    public void setPaciente(String paciente)
    {
        if(paciente==null)
        {
             System.out.println ("Digite um nome: ");
        }
        else  if(paciente.equals("")) 
        {
             System.out.println ("Digite um nome: ");
        }
        else  this.paciente = paciente;
    }
    public String getMedico() {
        return medico;
    }
    public void setMedico(String medico)
    {
        if(medico==null)
        {
            System.out.println ("Digite o nome: ");
        }
        else  if(medico.equals("")) 
        {
            System.out.println ("Digite o nome: ");
        }
        else  this.medico = medico;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }   
     
}
