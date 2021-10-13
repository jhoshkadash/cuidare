package Model.VO;

public class PacienteVO extends PessoaVO {
    private String endereco;
    private Long idPessoa;
    private Long idPaciente, idProntuario;

    public PacienteVO(String nome, String cpf, String endereco) {
        super(nome, cpf);
        this.endereco = endereco;
    }

    public PacienteVO() {
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

    public Long getIdPessoa() {
        return this.idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdPaciente() {
        return this.idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getIdProntuario() {
        return this.idProntuario;
    }

    public void setIdProntuario(Long idProntuario) {
        this.idProntuario = idProntuario;
    }


}
