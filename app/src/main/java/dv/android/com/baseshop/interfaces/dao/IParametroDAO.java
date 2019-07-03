package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.ParametroDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface IParametroDAO {
    ParametroDTO findByPk(ParametroDTO entity)throws BaseException;
    List<ParametroDTO> findByAll()throws BaseException;
}
