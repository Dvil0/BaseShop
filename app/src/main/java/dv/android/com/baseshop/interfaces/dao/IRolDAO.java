package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.RolDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface IRolDAO {
    RolDTO findByPk(RolDTO entity)throws BaseException;
    List<RolDTO> findByAll()throws BaseException;
}
