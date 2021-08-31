

public class UsuarioVO 
{
    private String login;
    private String senha;




    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        if(login==null){
            System.out.println("Digite seu usuário");
        }
        else if(login.equals("")){
            System.out.println("Campo em branco");
        }  
        else this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }
    public void setSenha(String senha) {
        if(senha==null){
            System.out.println("Digite sua senha");
        }
        else if(senha.equals("")){
            System.out.println("Campo em branco");
        }  
        else this.senha = senha;
    }
}