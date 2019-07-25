package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.entities.NotificacionDTO;

public interface INotificacionDAO {
    NotificacionDTO findByPk(NotificacionDTO entity)throws Exception;
    List<NotificacionDTO> findByCriteria(NotificacionDTO entity)throws Exception;
    void save(NotificacionDTO entity)throws Exception;
    void delete(NotificacionDTO entity)throws Exception;
}
