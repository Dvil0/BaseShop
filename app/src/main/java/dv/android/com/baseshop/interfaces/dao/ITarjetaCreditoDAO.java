package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.entities.TarjetaCreditoDTO;

public interface ITarjetaCreditoDAO {
    TarjetaCreditoDTO findByPk(TarjetaCreditoDTO entity)throws Exception;
    List<TarjetaCreditoDTO> findByCriteria(TarjetaCreditoDTO entity)throws Exception;
    void save(TarjetaCreditoDTO entity)throws Exception;
    void delete(TarjetaCreditoDTO entity)throws Exception;
}
