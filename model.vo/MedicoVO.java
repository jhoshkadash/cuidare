public class MedicoVO {
    private String nome;
    private String cpf;
    private String endereco;
    private double valorconsulta;
    private String crm;

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

        }
        else  if(endereco.equals("")) 
        {

        }
        else  this.endereco = endereco;
    }
    public double getValorconsulta() {
        return valorconsulta;
    }
    public void setValorconsulta(double valorconsulta) {
        this.valorconsulta = valorconsulta;
    }
    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

    
}
