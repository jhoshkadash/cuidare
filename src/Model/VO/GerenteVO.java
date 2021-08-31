
public class GerenteVO {
    private String nome;
    private String id;
    public String getNome() {
        return nome;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
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
