package Model.VO;

public class GerenteVO extends UsuarioVO {


    public GerenteVO(String nome, String cpf, String login, String senha, Double id) {
        super(nome, cpf, login, senha, id, 3);
    }


}
