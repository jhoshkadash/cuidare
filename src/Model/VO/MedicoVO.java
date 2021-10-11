package Model.VO;

public class MedicoVO extends UsuarioVO {
    private String endereco;
    private Double valorConsulta;
    private String crm;
    private Long idPessoa;
    private Long idUser;
    private Long idMedico;

    public MedicoVO(String nome, String cpf, String login, String senha, String endereco, Double valorConsulta, String crm) {
        super(nome, cpf, login, senha, 2);
        this.endereco = endereco;
        this.valorConsulta = valorConsulta;
        this.crm = crm;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null) {
            System.out.println("Digite um endereço: ");
        } else if (endereco.equals("")) {
            System.out.println("Digite um endereço: ");
        } else
            this.endereco = endereco;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        if (crm == null) {
            System.out.println("Digite o CRM: ");
        } else if (crm.equals("")) {
            System.out.println("Digite o CRM: ");
        } else
            this.crm = crm;
    }



    public Long getIdPessoa() {
        return this.idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdMedico() {
        return this.idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }


}
