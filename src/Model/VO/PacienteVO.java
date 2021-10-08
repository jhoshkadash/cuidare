package Model.VO;

public class PacienteVO extends PessoaVO {
    private String endereco;
    private Long id_pessoa;
    private Long id_paciente;

    public PacienteVO(String nome, String cpf, String endereco) {
        super(nome, cpf);
        this.endereco = endereco;
        this.id_pessoa = super.getIdPessoa();
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

    public Long getId_pessoa() {
        return this.id_pessoa;
    }

    public void setId_pessoa(Long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public Long getId_paciente() {
        return this.id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

}
