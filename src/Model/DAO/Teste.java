package Model.DAO;

import java.util.List;

import Model.VO.AtendenteVO;
import Model.VO.GerenteVO;

public class Teste {

    public static void main(String[] args) {
        /*teste atendente*/
       
        // criando atendentes no BD
        AtendenteDAO atendenteDao = new AtendenteDAO();
        AtendenteVO atendenteVo = new AtendenteVO();
        atendenteVo.setCpf("03494372088");
        atendenteVo.setNome("Matheus Cunha de Oliveira");
        atendenteDao.inserir(atendenteVo);
        atendenteVo.setCpf("25600391274");
        atendenteVo.setNome("Matue Silva de Souza");
        atendenteDao.inserir(atendenteVo);

        // listando atendentes existentes no BD
        List<AtendenteVO> atendentes = atendenteDao.listar();
        System.out.println("----------teste atentdentes---------");
        System.out.println("------------atendentes--------------");
        for (AtendenteVO atendenteVO2 : atendentes) {
            System.out.println("Nome: " + atendenteVO2.getNome());
            System.out.println("CPF: " + atendenteVO2.getCpf());
            System.out.println("id: " + atendenteVO2.getId());
            System.out.println("*************************************");

        }

        //editar atendente existente
        atendenteVo.setNome("Chayenne da Silva");
        atendenteVo.setCpf("45381038264");
        atendenteVo.setId(4);
        atendenteDao.editarCpf(atendenteVo);
        atendenteDao.editarNome(atendenteVo);

        //lista atualizada
        List<AtendenteVO> atendentesAtt = atendenteDao.listar();
        System.out.println("----------lista atualizada---------");
        System.out.println("------------atendentes--------------");
        for (AtendenteVO atendenteVO2 : atendentesAtt) {
            System.out.println("Nome: " + atendenteVO2.getNome());
            System.out.println("CPF: " + atendenteVO2.getCpf());
            System.out.println("id: " + atendenteVO2.getId());
            System.out.println("*************************************");

        }

        // criando gerentes no BD
        GerenteDAO grtDao = new GerenteDAO();
        GerenteVO grtVO = new GerenteVO();
        grtVO.setCpf("56784594534");
        grtVO.setNome("Pedro Carlos Da Silva");
        grtDao.inserir(grtVO);

        grtVO.setCpf("74509383422");
        grtVO.setNome("Nilton Santos De Oliveira");
        grtDao.inserir(grtVO);

        // listando gerentes existentes no BD
        List<GerenteVO> gerentes = grtDao.listar();
        System.out.println("------------------------------------");
        System.out.println("--------------Gerentes--------------");
        for (GerenteVO grtVO2 : gerentes) {
            System.out.println("Nome: " + grtVO2.getNome());
            System.out.println("CPF: " + grtVO2.getCpf());
            System.out.println("id: " + grtVO2.getId());
            System.out.println("*************************************");
        }

    }
}