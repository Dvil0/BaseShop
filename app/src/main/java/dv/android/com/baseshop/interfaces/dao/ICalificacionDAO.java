package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.entities.CalificacionDTO;

public interface ICalificacionDAO {
    CalificacionDTO findByPk(CalificacionDTO entity)throws Exception;
    List<CalificacionDTO> findByCriteria(CalificacionDTO entity)throws Exception;
    void save(CalificacionDTO entity)throws Exception;
    void delete(CalificacionDTO entity)throws Exception;
}
