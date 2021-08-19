
public class UsuarioVO 
{
    private String login;
    private String senha;

    public String getLogin()
    {
        return login;
    }
    public String getSenha()
    {
        return senha;
    }
    public void setLogin(String login)
    {
        if(login==null)
        {

        }
        else  if(login.equals("")) 
        {

        }
        else  this.login = login;
    }
    public void setSenha(String senha)
    {
        if(senha==null)
        {

        }
        else  if(senha.equals("")) 
        {

        }
        else  this.senha = senha;
    }

}