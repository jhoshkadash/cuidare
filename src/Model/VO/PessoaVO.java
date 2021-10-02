package Model.VO;

public class PessoaVO {
    private String nome;
    private String senha;
    private Double id;

    public PessoaVO(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
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

    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String senha){
          if(senha == null){
            System.out.println("Preencha o campo de senha");
        } else if (senha.equals("")){
            System.out.println("Senha em branco");
        } else 
            this.senha = senha;
    }
    
    public Double getId(){
        return this.id;
    }

    public void setId(Double id){
        this.id = id;
    }
}
