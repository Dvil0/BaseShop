package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.EmpresaDTO;

public interface IEmpresaDAO {
    EmpresaDTO findByPk(EmpresaDTO entity)throws Exception;
    List<EmpresaDTO> findByAll()throws Exception;
}
