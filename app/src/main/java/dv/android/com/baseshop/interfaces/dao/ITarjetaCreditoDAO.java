package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.TarjetaCreditoDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface ITarjetaCreditoDAO {
    TarjetaCreditoDTO findByPk(TarjetaCreditoDTO entity)throws BaseException;
    List<TarjetaCreditoDTO> findByCriteria(TarjetaCreditoDTO entity)throws BaseException;
    void save(TarjetaCreditoDTO entity)throws BaseException;
    void delete(TarjetaCreditoDTO entity)throws BaseException;
}
