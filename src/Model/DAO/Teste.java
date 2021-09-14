package Model.DAO;

import Model.VO.AtendenteVO;

public class teste {
    
    public static void main (String[] args){
        BaseDAO dao = new BaseDAO();
        AtendenteDAO atendenteDao = new AtendenteDAO();
        AtendenteVO atendenteVo = new AtendenteVO();

        atendenteVo.setCpf("33344455567");
        atendenteVo.setNome("Matheus Cunha");
        atendenteDao.inserir(atendenteVo);} 
    
}
