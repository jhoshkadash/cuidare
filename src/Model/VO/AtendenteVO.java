package Model.VO;

public class AtendenteVO extends UsuarioVO {
    private String nome;
    private String cpf;

    public AtendenteVO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
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
        else this.cpf = cpf;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null){
            System.out.println("Campo de nome não foi preenchido");
        }
        else if (nome.equals("")){
            System.out.println("Campo de nome está vazio");
        }
        else this.nome = nome;
    }
}
