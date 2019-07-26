package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.entities.CompraDTO;
import dv.android.com.baseshop.interfaces.listeners.IOnBoardListener;
import dv.android.com.baseshop.interfaces.listeners.IOnCompraListener;

public interface ICompraDAO {
    void save(CompraDTO entity)throws Exception;
    void delete(CompraDTO entity)throws Exception;
    List<CompraDTO> findByCriteria(CompraDTO entity) throws Exception;
    List<CompraDTO> findByAll(final IOnCompraListener listener) throws Exception;
    void findCarritoOnBoardByImei(CompraDTO entity, final IOnBoardListener listener) throws Exception;
    void findComprasOnComprasByImei(CompraDTO entity, IOnCompraListener listener) throws Exception;
}
