package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.NotificacionDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface INotificacionDAO {
    NotificacionDTO findByPk(NotificacionDTO entity)throws BaseException;
    List<NotificacionDTO> findByCriteria(NotificacionDTO entity)throws BaseException;
    void save(NotificacionDTO entity)throws BaseException;
    void delete(NotificacionDTO entity)throws BaseException;
}
