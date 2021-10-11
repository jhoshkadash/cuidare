package Model.VO;

public class AtendenteVO extends UsuarioVO {

    public AtendenteVO(String nome, String cpf, String login, String senha) {
        super(nome, cpf, login, senha, 1);
    }

}
