package Model.BO;

import java.sql.SQLException;
import java.util.*;

import Model.Exception.InsertException;

public interface BaseInterBO <vo> {
    public List<vo> Buscar(vo vo) throws SQLException;
    public void Cadastrar(vo vo) throws SQLException;
    public void Editar(vo vo) throws SQLException;
    public void Excluir(vo vo) throws SQLException;
}