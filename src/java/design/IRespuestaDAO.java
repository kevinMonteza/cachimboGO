/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.util.List;
import to.RespuestaTO;
import to.SubtemaTO;

/**
 *
 * @author isaac
 */
public interface IRespuestaDAO {
    public List<RespuestaTO> getRespuestasBySubtema(Integer id_subtema, Integer id_usuario);
    public boolean insertRespuesta(RespuestaTO respuesta);
    public boolean updateRespuesta(RespuestaTO respuesta);
}
