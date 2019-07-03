package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.EmpresaDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface IEmpresaDAO {
    EmpresaDTO findByPk(EmpresaDTO entity)throws BaseException;
    List<EmpresaDTO> findByAll()throws BaseException;
}
