package Model.VO;

public class GerenteVO extends UsuarioVO {
    Long idUser;
    Long idPessoa;
    Long idGerente;

    public GerenteVO(String nome, String cpf, String login, String senha) {
        super(nome, cpf, login, senha, 3);
    }


    

    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdPessoa() {
        return this.idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdGerente() {
        return this.idGerente;
    }

    public void setIdGerente(Long idGerente) {
        this.idGerente = idGerente;
    }
    

}
