/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.List;
import to.TemaTO;

/**
 *
 * @author isaac
 */
public interface ITemaDAO {
    public TemaTO getTemaById(Integer id_tema);
    public List<TemaTO> getTemas();
    public List<TemaTO> getTemasByAsignatura(Integer id_asignatura);
}
