public class GerenteVO {
    String nome;
    private String usuario;
    private String senha;
    
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        if(usuario==null)
        {

        }
        else  if(usuario.equals("")) 
        {

        }
        else this.usuario = usuario;

    }
    public String getSenha() {
        return senha;
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
