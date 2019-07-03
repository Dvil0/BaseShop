package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.MensajeDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface IMensajesDAO {
    MensajeDTO findByPk(MensajeDTO entity)throws BaseException;
    List<MensajeDTO> findByCriteria(MensajeDTO entity)throws BaseException;
    void save(MensajeDTO entity)throws BaseException;
    void delete(MensajeDTO entity)throws BaseException;
}
