package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.entities.RolDTO;

public interface IRolDAO {
    RolDTO findByPk(RolDTO entity)throws Exception;
    List<RolDTO> findByAll()throws Exception;
}
