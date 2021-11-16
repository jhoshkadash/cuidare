package Model.BO;

import java.sql.*;
import java.util.*;
import Model.Exception.*;
import Model.VO.ConsultaVO;

public class PacienteBO {
    public void verConsultas(){ 

    }

    public void desmarcarConsulta (ConsultaVO vo) throws Exception {
        if(vo.getStatus() == false){
            throw new Exception("Esta consulta não está mais ativa");
        } 
        else {
            vo.setStatus(false);
        }
    }

    public void imprimirLaudo () {
        
    }

}