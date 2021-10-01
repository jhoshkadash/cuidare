package Model.VO;

public class PessoaVO {
    private String nome;
    private String cpf;
    private Double id;

    public PessoaVO(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        if(nome == null){
            System.out.println("Preencha o campo de nome");
        } else if (nome.equals("")){
            System.out.println("Nome em branco");
        } else 
            this.nome = nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        if(cpf.length() != 11){
            System.out.println("Cpf inválido (não digite pontos e nem linhas)");
        }
        if(cpf.substring(0).matches("[0-9]") == false){
            System.out.println("Cpf inválido (existe letras no cpf)");
        } else
            this.cpf = cpf;
    }

    public Double getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }
}
