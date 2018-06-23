/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.List;
import to.ArticuloTO;

/**
 *
 * @author isaac
 */
public interface IArticuloDAO {
    public List<ArticuloTO> getArticulos();
    public ArticuloTO getArticuloById(Integer id_articulo);
    public boolean insertArticulo(ArticuloTO articulo);
}
