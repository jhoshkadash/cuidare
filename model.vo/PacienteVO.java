public class PacienteVO {
   private String nome;
   private String cpf;
   private String endereco;
  
    public String getNome() {
        return nome;
    }
   
    public void setNome(String nome) {
        if(nome==null)
        {
           System.out.println ("Digite um nome: ");
        }
        else  if(nome.equals("")) 
        {
           System.out.println ("Digite um nome: "); 
        }
        else this.nome = nome;
    } 
   
   
    public String getCpf() {
        return cpf;
    }
   
    public void setCpf(String cpf) {
        if (cpf.length() != 11){
            System.out.println ("Cpf inválido (não digite pontos e nem linhas)");
        }

        if(cpf.substring(0).matches("[0-9]*") == false)
        {
            System.out.println ("Cpf inválido (existe letras no cpf)");
        }

        else
        {
            this.cpf = cpf;
        }
    }
   
   
    public String getEndereco() {
        return endereco;
    }
   
    public void setEndereco(String endereco)
    {
        if(endereco==null)
        {
            System.out.println ("Digite um endereço: ");
        }
        else  if(endereco.equals("")) 
        {
            System.out.println ("Digite um endereço: ");
        }
        else  this.endereco = endereco;
    }
}
