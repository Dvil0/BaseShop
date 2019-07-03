package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.MensajeDTO;

public interface IMensajesDAO {
    MensajeDTO findByPk(MensajeDTO entity)throws Exception;
    List<MensajeDTO> findByCriteria(MensajeDTO entity)throws Exception;
    void save(MensajeDTO entity)throws Exception;
    void delete(MensajeDTO entity)throws Exception;
}
