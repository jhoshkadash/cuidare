public class PacienteVO {
   private String nome;
   private String cpf;
   private String endereco;
   private String bairro;
   
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if(nome==null)
        {

        }
        else  if(nome.equals("")) 
        {

        }
        else this.nome = nome;

    }  
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco)
    {
        if(endereco==null)
        {

        }
        else  if(endereco.equals("")) 
        {

        }
        else  this.endereco = endereco;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

   
}
