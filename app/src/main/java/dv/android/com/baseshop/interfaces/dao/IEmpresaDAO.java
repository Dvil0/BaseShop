package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.entities.EmpresaDTO;

public interface IEmpresaDAO {
    EmpresaDTO findByPk(EmpresaDTO entity)throws Exception;
    List<EmpresaDTO> findByAll()throws Exception;
}
