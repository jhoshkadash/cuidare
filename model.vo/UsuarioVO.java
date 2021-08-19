
public class UsuarioVO 
{
    private String login;
    private String senha;

    public String getLogin()
    {
        return login;
    }
    
    public void setLogin(String login)
    {
        if(login==null)
        {
            System.out.println ("Digite um login: ");
        }
        else  if(login.equals("")) 
        {
            System.out.println ("Digite um login: ");
        }
        else  this.login = login;
    }
    
    public String getSenha()
    {
        return senha;
    }
    
    public void setSenha(String senha)
    {
        if(senha==null)
        {
            System.out.println ("Digite uma senha: ");
        }
        else  if(senha.equals("")) 
        {
            System.out.println ("Digite uma senha: ");
        }
        else  this.senha = senha;
    }

}
