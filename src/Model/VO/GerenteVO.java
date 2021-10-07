package Model.VO;

public class GerenteVO extends UsuarioVO {


    public GerenteVO(String nome, String cpf, String login, String senha, Long id_pessoa) {
        super(nome, cpf, login, senha, id_pessoa, 3);
    }


}
