package Model.VO;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProntuarioVO  {
    private Calendar dataNascimento = Calendar.getInstance();
    private String antenPatologico, mediAtuais, mediAlergia, historicoDoenca;
    private Float altura, peso;
    private Long idProntuario, idPaciente;

    public ProntuarioVO(String dNascimento, String antenPatologico, String mediAtuais, String mediAlergia,
                        Float peso, Float altura, String historicoDoenca, Long idPaciente) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.dataNascimento.setTime(formato.parse(dNascimento));
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

    public ProntuarioVO() {
    }
    public String getDataNascimento() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dNascimento = formato.format(this.dataNascimento.getTime());
        return dNascimento;
    }

    public Date getDataNascimentoDao() {
        java.util.Date data = new java.util.Date();
        data = this.dataNascimento.getTime();
        java.sql.Date dataSQL = new java.sql.Date(data.getTime());
        return dataSQL;
    }

    public void setDataNascimento(String dNascimento) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.dataNascimento.setTime(formato.parse(dNascimento));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setDataNascimentoDao(Timestamp dNascimento) {
            this.dataNascimento.setTime(dNascimento);
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
            this.peso = Peso;
    }

    public Float getAltura() {
        return this.altura;
    }

    public void setAltura(Float Altura) {
        if (Altura == null) {
            System.out.println("o campo Altura está vazio");
        } else
            this.altura = Altura;
    }

    public String getHistoricoDoenca() {
        return this.historicoDoenca;
    }

    public void setHistoricoDoenca(String HistoricoDoenca) {
        this.historicoDoenca = HistoricoDoenca;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }


    public Long getIdProntuario() {
        return this.idProntuario;
    }

    public void setIdProntuario(Long idProntuario) {
        this.idProntuario = idProntuario;
    }
    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    
}
