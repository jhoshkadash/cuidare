package Model.VO;

public class UsuarioVO extends PessoaVO {
    private String login;
    private String senha;
    private Integer tipo;// 1-> atendente, 2-> medico, 3-> gerente
    private Long id;

    public UsuarioVO(String nome, String cpf, String login, String senha,  Integer tipo) {
        super(nome, cpf);
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }


    public UsuarioVO() {
        super();
    }


    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        if (login == null) {
            System.out.println("Digite seu usuário");
        } else if (login.equals("")) {
            System.out.println("Campo em branco");
        } else
            this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        if (senha == null) {
            System.out.println("Digite sua senha");
        } else if (senha.equals("")) {
            System.out.println("Campo em branco");
        } else
            this.senha = senha;
    }

    public Integer getTipo() {
        return this.tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Long getIdUser() {
        return this.id;
    }

    public void setIdUser(Long id) {
        this.id = id;
    }
    
}
