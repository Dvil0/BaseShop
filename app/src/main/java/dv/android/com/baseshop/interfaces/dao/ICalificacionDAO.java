package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.CalificacionDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface ICalificacionDAO {
    CalificacionDTO findByPk(CalificacionDTO entity)throws BaseException;
    List<CalificacionDTO> findByCriteria(CalificacionDTO entity)throws BaseException;
    void save(CalificacionDTO entity)throws BaseException;
    void delete(CalificacionDTO entity)throws BaseException;
}
