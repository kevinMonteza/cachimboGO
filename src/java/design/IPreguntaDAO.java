/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.List;
import to.PreguntaTO;
import to.SubtemaTO;

/**
 *
 * @author isaac
 */
public interface IPreguntaDAO {
    public List<PreguntaTO> getPreguntasRandom(Integer id_subtema, Integer tipo);
    public List<PreguntaTO> getPreguntas();
    public PreguntaTO getPreguntaById(Integer id_pregunta);
    public List<PreguntaTO> getPreguntasBySubtema(Integer id_subtema);
    public boolean deletePregunta(Integer id_pregunta);
    public boolean updatePregunta(PreguntaTO id_pregunta);
    public boolean insertPregunta(PreguntaTO id_pregunta);
}
