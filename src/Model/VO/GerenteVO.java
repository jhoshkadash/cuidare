package Model.VO;


public class GerenteVO extends UsuarioVO {
    private String nome;
    private Integer id;


    public GerenteVO(String nome, Integer id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        if(id == null){
            System.out.println("Erro. Gerente sem ID");
        }
        else if(id.equals("")){
            System.out.println("Erro. ID vazio");
        }
        else this.id = id;
    }
    public void setNome(String nome) {
        if(nome == null){
            System.out.println("Erro. Gerente sem nome");
        }
        else if(nome.equals("")){
            System.out.println("Erro. Nome do gerente vazio");
        }
        else this.nome = nome;
    }
}
