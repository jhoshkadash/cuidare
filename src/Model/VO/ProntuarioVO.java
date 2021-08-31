
import java.util.Calendar;

public class ProntuarioVO {
    private Calendar DataNascimento = Calendar.getInstance();
    private String AntenPatologico;
    private String MediAtuais;
    private String MediAlergia;
    private Float Peso;
    private Float Altura;
    private String HistoricoDoenca;
    private String IdPaciente;


    public Calendar getDataNascimento() {
        return this.DataNascimento;
    }

    public void setDataNascimento(Calendar DataNascimento) {
        if(DataNascimento == null){
        System.out.println("Data de nascimento vazia");
        }
        else this.DataNascimento = DataNascimento;
    }

    public String getAntenPatologico() {
        return this.AntenPatologico;
    }

    public void setAntenPatologico(String AntenPatologico) {
        this.AntenPatologico = AntenPatologico;
    }

    public String getMediAtuais() {
        return this.MediAtuais;
    }

    public void setMediAtuais(String MediAtuais) {
        this.MediAtuais = MediAtuais;
    }

    public String getMediAlergia() {
        return this.MediAlergia;
    }

    public void setMediAlergia(String MediAlergia) {
        this.MediAlergia = MediAlergia;
    }

    public Float getPeso() {
        return this.Peso;
    }

    public void setPeso(Float Peso) {
        if(Peso == null){
            System.out.println("o campo Peso está vazio");
        }
        else this.Peso = Peso;
    }

    public Float getAltura() {
        return this.Altura;
    }

    public void setAltura(Float Altura) {
         if(Altura == null){
            System.out.println("o campo Altura está vazio");
        }
        else this.Altura = Altura;
    }

    public String getHistoricoDoenca() {
        return this.HistoricoDoenca;
    }

    public void setHistoricoDoenca(String HistoricoDoenca) {
        this.HistoricoDoenca = HistoricoDoenca;
    }

    public String getIdPaciente() {
        return this.IdPaciente;
    }

    public void setIdPaciente(String IdPaciente) {
        if(IdPaciente == null){
            System.out.println("Erro. Paciente sem id");
        }
        else if(IdPaciente.equals("")){
            System.out.println("Erro. Paciente sem id");
        }
        else this.IdPaciente = IdPaciente;
    }}
