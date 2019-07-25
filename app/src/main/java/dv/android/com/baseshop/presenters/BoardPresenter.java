package dv.android.com.baseshop.presenters;

import android.util.Log;

import java.util.List;

import dv.android.com.baseshop.dto.ProductoDTO;
import dv.android.com.baseshop.exception.BaseException;
import dv.android.com.baseshop.interfaces.listeners.IOnBoardListener;
import dv.android.com.baseshop.interfaces.models.IBoardModel;
import dv.android.com.baseshop.interfaces.presenters.IBoardPresenter;
import dv.android.com.baseshop.interfaces.views.IBoardActivity;
import dv.android.com.baseshop.models.BoardModel;

public class BoardPresenter implements IBoardPresenter, IOnBoardListener {

    private IBoardActivity boardView;

    private IBoardModel boardModel;

    public BoardPresenter(IBoardActivity boardView){
        this.boardView = boardView;
        this.boardModel = new BoardModel();
    }

    @Override
    public List<ProductoDTO> findByAll(){
        List<ProductoDTO> productos = null;
        try {

            if (boardView != null) {
                productos = boardModel.findByAll(this);
            }

        }catch (BaseException e){
            Log.e("ERROR:","BoardPresenter.findByAll.causa: "+e.getMessage());
            boardView.errorMessage(e.getMessage());
        }catch (Exception e){
            Log.e("ERROR:","BoardPresenter.findByAll.causa: "+e.getMessage());
        }

        return productos;
    }


    @Override
    public void sucessMessage(String message) {
        if(boardView!=null){
            boardView.sucessMessage(message);
        }
    }

    @Override
    public void errorMessage(String message) {
        if(boardView!=null){
            boardView.errorMessage(message);
        }
    }

    @Override
    public void setItemsProductsFragment(List<ProductoDTO> productos){
        if(boardView!=null){
            boardView.setItemsProductsFragment(productos);
        }
    }
}
