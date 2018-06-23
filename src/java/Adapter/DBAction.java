/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import java.util.List;
import to.ArticuloTO;
import to.AsignaturaTO;
import to.PreguntaTO;
import to.RespuestaTO;
import to.SubtemaTO;
import to.TemaTO;
import to.UsuarioArticuloTO;
import to.UsuarioAsignaturaTO;
import to.UsuarioSubtemaTO;
import to.UsuarioTO;
import to.UsuarioTemaTO;

/**
 *
 * @author isaac
 */
public interface DBAction {
    public List<ArticuloTO> obtenerArticulos();
    public ArticuloTO obtenerArticuloPorID(Integer id_articulo);
    public boolean insertarArticulo(ArticuloTO articulo);
    public AsignaturaTO obtenerAsignaturaPorID(Integer id_asignatura);
    public List<AsignaturaTO> obtenerAsignaturas();
    public List<PreguntaTO> obtenerPreguntas();
    public PreguntaTO obtenerPreguntaPorID(Integer id_pregunta);
    public List<PreguntaTO> obtenerPreguntasPorSubtema(Integer id_subtema);
    public boolean borrarPregunta(Integer id_pregunta);
    public boolean actualizarPregunta(PreguntaTO pregunta);
    public boolean insertarPregunta(PreguntaTO pregunta);
    public List<PreguntaTO> obtenerPreguntasAleatorias(Integer id_subtema, Integer tipo);
    public List<RespuestaTO> obtenerRespuestasPorSubtema(Integer id_subtema, Integer id_usuario);
    public boolean insertarRespuesta(RespuestaTO respuesta);
    public boolean actualizarRespuesta(RespuestaTO respuesta);
    public SubtemaTO obtenerSubtemaPorID(Integer id_subtema);
    public List<SubtemaTO> obtenerSubtemas();
    public List<SubtemaTO> obtenerSubtemasPorTema(Integer id_tema);
    public TemaTO obtenerTemaPorID(Integer id_tema);
    public List<TemaTO> obtenerTemas();
    public List<TemaTO> obtenerTemasPorAsignatura(Integer id_asignatura);
    public List<UsuarioArticuloTO> obtenerUsuarioArticulos(Integer id_usuario);
    public boolean insertarUsuarioArticulo(UsuarioArticuloTO usuarioArticulo);
    public List<UsuarioAsignaturaTO> ObtenerAsignaturaPorUsuario(UsuarioTO usuario);
    public boolean insertarUsuarioAsignatura(UsuarioAsignaturaTO usuarioAsignatura);
    public boolean actualizarUsuarioAsignatura(UsuarioAsignaturaTO usuarioAsignatura);
    public boolean usuarioAuth(UsuarioTO usuario);
    public boolean insertarUsuario(UsuarioTO usuario);
    public List<UsuarioSubtemaTO> obtenerSubtemaPorUsuario(UsuarioTO usuario);
    public boolean insertarUsuarioSubtema(UsuarioSubtemaTO usuarioSubtema);
    public boolean actualizarUsuarioSubtema(UsuarioSubtemaTO usuarioSubtema);
    public List<UsuarioTemaTO> obtenerTemaPorUsuario(UsuarioTO usuario);
    public boolean insertarUsuarioTema(UsuarioTemaTO usuarioTema);
    public boolean actualizarUsuarioTema(UsuarioTemaTO usuarioTema);
}
