package Model.BO;

import java.util.*;

public interface BaseInterBO <vo> {
    public List<vo> Buscar(vo entity);
    public void Cadastrar(vo entity);
    public void Editar(vo entity);
    public void Excluir(vo entity);
}