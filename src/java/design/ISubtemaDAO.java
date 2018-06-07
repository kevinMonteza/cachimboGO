/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.List;
import to.SubtemaTO;

/**
 *
 * @author isaac
 */
public interface ISubtemaDAO {
    public SubtemaTO getSubtemaById(Integer id_subtema);
    public List<SubtemaTO> getSubtemas();
    public List<SubtemaTO> getSubtemasByTema(Integer id_tema);
}
