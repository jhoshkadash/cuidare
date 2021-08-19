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
            System.out.println ("Digite o nome: ");
        }
        else  if(usuario.equals("")) 
        {
            System.out.println ("Digite o nome: ");
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
            System.out.println ("Digite uma senha: ");
        }
        else  if(senha.equals("")) 
        {
            System.out.println ("Digite uma senha: ");
        }
        else  this.senha = senha;
    }
    
}
