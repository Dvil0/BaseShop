package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.VentaDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface IVentaDTO {
    VentaDTO findByPk(VentaDTO entity)throws BaseException;
    List<VentaDTO> findByCriteria(VentaDTO entity)throws BaseException;
    void save(VentaDTO entity)throws BaseException;
    void delete(VentaDTO entity)throws BaseException;
}
