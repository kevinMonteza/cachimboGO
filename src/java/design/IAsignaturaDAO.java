/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.List;
import to.AsignaturaTO;

/**
 *
 * @author isaac
 */
public interface IAsignaturaDAO {
    public AsignaturaTO getAsignaturaById(Integer id_subtema);
    public List<AsignaturaTO> getAsignaturas();
}
