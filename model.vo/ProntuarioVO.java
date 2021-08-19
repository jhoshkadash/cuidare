public class ProntuarioVO {
    private String[] remedios;
    private String[] observacoes;
    
    public String[] getRemedios() {
        return remedios;
    }
    public void setRemedios(String[] remedios) {
        if(remedios==null)
        {
            System.out.println ("Informação inválida.\n");    
        }
        else this.remedios = remedios;
    }
    
    
    public String[] getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String[] observacoes) {
        if(observacoes==null)
        {
             System.out.println ("Informação inválida.\n");
        }
        else  if(observacoes.equals("")) 
        {
             System.out.println ("Adicionar observações da consulta.\n");
        }
        else  this.observacoes = observacoes;
    }
}
