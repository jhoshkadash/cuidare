package Model.VO;

public class MedicoVO extends UsuarioVO {
    private String endereco;
    private Double valorconsulta;
    private String crm;

    public MedicoVO(String nome, String cpf, String login, String senha,String endereco, Double valorconsulta, String crm, Long id_pessoa) {
        super(nome, cpf, login, senha, id_pessoa, 2);
        this.endereco = endereco;
        this.valorconsulta = valorconsulta;
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

    public double getValorconsulta() {
        return valorconsulta;
    }

    public void setValorconsulta(double valorconsulta) {
        this.valorconsulta = valorconsulta;
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
}
