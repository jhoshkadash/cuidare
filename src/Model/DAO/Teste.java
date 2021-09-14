package Model.DAO;

import Model.VO.AtendenteVO;

public class teste {
    
    public static void main (String[] args){
        BaseDAO dao = new BaseDAO();
        AtendenteDAO atendenteDao = new AtendenteDAO();
        AtendenteVO atendenteVo = new AtendenteVO();
        AtendenteVO atendenteVo2 = new AtendenteVO();

        atendenteVo.setCpf("33344455567");
        atendenteVo.setNome("Matheus Cunha");
        atendenteDao.inserir(atendenteVo);
        atendenteVo2.setCpf("66677788890");
        atendenteVo2.setNome("Matue da Silva");
        atendenteDao.inserir(atendenteVo2);
        atendenteDao.removerByCPF(atendenteVo);} 

    
}
