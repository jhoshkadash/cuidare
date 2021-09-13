package Model.VO;

public class MedicoVO {
    private String nome;
    private String cpf;
    private String endereco;
    private double valorconsulta;
    private String crm;

    public MedicoVO(String nome, String cpf, String endereco, double valorconsulta, String crm) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.valorconsulta = valorconsulta;
        this.crm = crm;
    }


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
        if (cpf.length() != 11)
        {
            System.out.println ("Cpf inválido (não digite pontos e nem linhas)");
        }
        if(cpf.matches("[0-9]*") == false)
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
        if(crm==null)
        {
            System.out.println ("Digite o CRM: ");
        }
        else  if(crm.equals("")) 
        {
            System.out.println ("Digite o CRM: ");
        }
        else this.crm = crm;
    }   
}
