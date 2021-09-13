package Model.VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ProntuarioVO {
    private Calendar dataNascimento = Calendar.getInstance();
    private String antenPatologico;
    private String mediAtuais;
    private String mediAlergia;
    private Float peso;
    private Float altura;
    private String historicoDoenca;
    private String idPaciente;





    public ProntuarioVO(String dataNascimento, String antenPatologico, String mediAtuais, String mediAlergia, Float peso, Float altura, String historicoDoenca, String idPaciente) 
    {
        
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.dataNascimento.setTime(formato.parse(dataNascimento));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.antenPatologico = antenPatologico;
        this.mediAtuais = mediAtuais;
        this.mediAlergia = mediAlergia;
        this.peso = peso;
        this.altura = altura;
        this.historicoDoenca = historicoDoenca;
        this.idPaciente = idPaciente;
    }
  

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getAntenPatologico() {
        return this.antenPatologico;
    }

    public void setAntenPatologico(String AntenPatologico) {
        this.antenPatologico = AntenPatologico;
    }

    public String getMediAtuais() {
        return this.mediAtuais;
    }

    public void setMediAtuais(String MediAtuais) {
        this.mediAtuais = MediAtuais;
    }

    public String getMediAlergia() {
        return this.mediAlergia;
    }

    public void setMediAlergia(String MediAlergia) {
        this.mediAlergia = MediAlergia;
    }

    public Float getPeso() {
        return this.peso;
    }

    public void setPeso(Float Peso) {
        if(Peso == null){
            System.out.println("o campo Peso está vazio");
        }
        else this.peso = Peso;
    }

    public Float getAltura() {
        return this.altura;
    }

    public void setAltura(Float Altura) {
         if(Altura == null){
            System.out.println("o campo Altura está vazio");
        }
        else this.altura = Altura;
    }

    public String getHistoricoDoenca() {
        return this.historicoDoenca;
    }

    public void setHistoricoDoenca(String HistoricoDoenca) {
        this.historicoDoenca = HistoricoDoenca;
    }

    public String getIdPaciente() {
        return this.idPaciente;
    }

    public void setIdPaciente(String IdPaciente) {
        if(IdPaciente == null){
            System.out.println("Erro. Paciente sem id");
        }
        else if(IdPaciente.equals("")){
            System.out.println("Erro. Paciente sem id");
        }
        else this.idPaciente = IdPaciente;
    }}
