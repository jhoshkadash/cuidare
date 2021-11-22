package Model.BO;

import java.sql.*;
import java.util.*;

import Model.DAO.BaseDAO;
import Model.DAO.BaseInterDAO;
import Model.DAO.UsuarioDAO;
import Model.Exception.ListException;
import Model.VO.GerenteVO;
import Model.VO.UsuarioVO;

public class UsuarioBO {

    public UsuarioVO autenticar(String login, String senha) throws ListException {
        UsuarioVO usuario = new UsuarioVO();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        try {
            UsuarioDAO dao = new UsuarioDAO<>();
            ResultSet rs = dao.ListarPorLoginSenha(usuario);
            if(rs.next()){
                usuario.setIdPessoa(rs.getLong("id_user_pessoa"));
                usuario.setIdUser(rs.getLong("id_user"));
                usuario.setNome(rs.getString("nome"));
                usuario.setTipo(rs.getInt("tipo"));
            }else{
                throw new ListException("Nenhu usuário com as informações passadas encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
}}