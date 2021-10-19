package Model.VO;

public class AtendenteVO extends UsuarioVO {
    private Long idPessoa;
    private Long idUser;
    private Long idAtendente;

    public AtendenteVO(String nome, String cpf, String login, String senha) {
        super(nome, cpf, login, senha, 1);
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

    public void setIdUser() {
        this.idUser = super.getIdUser();
    }

    public Long getIdAtendente() {
        return this.idAtendente;
    }

    public void setIdAtendente(Long idAtendente) {
        this.idAtendente = idAtendente;
    }

}
