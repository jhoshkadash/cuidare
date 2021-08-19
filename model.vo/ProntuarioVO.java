public class ProntuarioVO {
    private String[] remedios;
    private String[] observacoes;
    
    public String[] getRemedios() {
        return remedios;
    }
    public void setRemedios(String[] remedios) {
        this.remedios = remedios;
    }
    public String[] getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String[] observacoes) {
        if(observacoes==null)
        {

        }
        else  if(observacoes.equals("")) 
        {

        }
        else  this.observacoes = observacoes;
    }
        

    
}
