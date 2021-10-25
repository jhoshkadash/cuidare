package Model.BO;

import java.sql.SQLException;
import java.util.*;

import javax.swing.text.html.parser.Entity;

import Model.Exception.InsertException;

public interface BaseInterBO <VO> {
    public List<VO> Buscar(VO Entity);
    public void Cadastrar(VO entity);
    public void Editar(VO entity);
    public void Excluir(VO entity);
}