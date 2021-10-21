package Model.BO;

import java.sql.*;
import java.util.List;
import Model.DAO.*;
import Model.Exception.InsertException;
import Model.VO.UsuarioVO;

public class UsuarioBO implements BaseInterBO<UsuarioVO>{
    BaseInterDAO<UsuarioVO> dao = new UsuarioDAO();

    @Override
    public void Cadastrar(UsuarioVO vo) throws InsertException {
        try {
            ResultSet rs = dao.ListarPorId(vo);
            if (rs.next()) {
                throw new InsertException("mensagem de erro");
            } else {
                dao.Inserir(vo);
            }
        } catch (SQLException e) {
            throw new InsertException(e.getMessage());
        }
        
    }

    @Override
    public List<UsuarioVO> Buscar(UsuarioVO vo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void Editar(UsuarioVO vo) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Excluir(UsuarioVO vo) {
        // TODO Auto-generated method stub
        
    }


}