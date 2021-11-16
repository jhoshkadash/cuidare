package Model.BO;

import java.sql.*;
import java.util.*;
import Model.DAO.*;
import Model.Exception.*;
import Model.VO.*;

public class MedicoBO {

    public void CadastrarLaudo(LaudoVO vo) {
                LaudoDAO dao = new LaudoDAO();
                ResultSet rs;
                try {
                    rs = dao.ListarPorId(vo);
                    if(rs.next()){
                        throw new InsertException("Laudo com mesmo ID já cadastrado");
                    } else{
                        dao.Inserir(vo);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
    }

    public void EditarLaudo(LaudoVO vo) {

    }

    public List<ProntuarioVO> BuscarPronturarioPaciente (ProntuarioVO vo) {
            ResultSet rs;
            List <ProntuarioVO> prontuarios = new ArrayList<ProntuarioVO>();
            ProntuarioDAO dao = new ProntuarioDAO();
            try {
                rs = dao.ListarPorPaciente(vo);
                    while(rs.next()){
                        ProntuarioVO prontuarioVO = new ProntuarioVO();
                        prontuarioVO.setIdPaciente(rs.getLong("id_paciente"));
                        prontuarioVO.setIdProntuario(rs.getLong("id_prontuario"));
                        prontuarioVO.setPeso(rs.getFloat("peso"));
                        prontuarioVO.setAltura(rs.getFloat("altura"));
                        prontuarioVO.setAntenPatologico(rs.getString("ante_patologico"));
                        prontuarioVO.setHistoricoDoenca(rs.getString("historico_doenças"));
                        prontuarioVO.setMediAlergia(rs.getString("medi_alergicos"));
                        prontuarioVO.setMediAtuais(rs.getString("medi_atuais"));
                        prontuarios.add(prontuarioVO);
                    }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return prontuarios;
        }
    }

    public List<ConsultaVO> BuscarConsultasMarcadas (ConsultaVO vo) {
      
    }
}