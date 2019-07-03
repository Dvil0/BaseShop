package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.VentaDTO;

public interface IVentaDTO {
    VentaDTO findByPk(VentaDTO entity)throws Exception;
    List<VentaDTO> findByCriteria(VentaDTO entity)throws Exception;
    void save(VentaDTO entity)throws Exception;
    void delete(VentaDTO entity)throws Exception;
}
