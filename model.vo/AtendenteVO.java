public class AtendenteVO {
    private String nome;
    private String cpf;
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
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
}
