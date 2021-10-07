package Model.VO;

public class AtendenteVO extends UsuarioVO {

    public AtendenteVO(String nome, String cpf, String login, String senha, Long id_pessoa) {
        super(nome, cpf, login, senha, id_pessoa, 1);
    }

}
