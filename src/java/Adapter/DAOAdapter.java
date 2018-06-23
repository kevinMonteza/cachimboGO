/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import dao.DAOFactory;
import design.IArticuloDAO;
import design.IAsignaturaDAO;
import design.IPreguntaDAO;
import design.IRespuestaDAO;
import design.ISubtemaDAO;
import design.ITemaDAO;
import design.IUsuarioArticuloDAO;
import design.IUsuarioAsignaturaDAO;
import design.IUsuarioDAO;
import design.IUsuarioSubtemaDAO;
import design.IUsuarioTemaDAO;
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
public class DAOAdapter implements DBAction{

    @Override
    public List<ArticuloTO> obtenerArticulos() {
        IArticuloDAO articuloDAO = DAOFactory.getInstance().getArticuloDAO();
        return articuloDAO.getArticulos();
    }

    @Override
    public ArticuloTO obtenerArticuloPorID(Integer id_articulo) {
        IArticuloDAO articuloDAO = DAOFactory.getInstance().getArticuloDAO();
        return articuloDAO.getArticuloById(id_articulo);
    }

    @Override
    public boolean insertarArticulo(ArticuloTO articulo) {
        IArticuloDAO articuloDAO = DAOFactory.getInstance().getArticuloDAO();
        return articuloDAO.insertArticulo(articulo);
    }

    @Override
    public AsignaturaTO obtenerAsignaturaPorID(Integer id_asignatura) {
        IAsignaturaDAO asignaturaDAO = DAOFactory.getInstance().getAsignaturaDAO();
        return asignaturaDAO.getAsignaturaById(id_asignatura);
    }

    @Override
    public List<AsignaturaTO> obtenerAsignaturas() {
        IAsignaturaDAO asignaturaDAO = DAOFactory.getInstance().getAsignaturaDAO();
        return asignaturaDAO.getAsignaturas();
    }

    @Override
    public List<PreguntaTO> obtenerPreguntas() {
        IPreguntaDAO preguntaDAO = DAOFactory.getInstance().getPreguntaDAO();
        return preguntaDAO.getPreguntas();
    }

    @Override
    public PreguntaTO obtenerPreguntaPorID(Integer id_pregunta) {
        IPreguntaDAO preguntaDAO = DAOFactory.getInstance().getPreguntaDAO();
        return preguntaDAO.getPreguntaById(id_pregunta);
    }

    @Override
    public List<PreguntaTO> obtenerPreguntasPorSubtema(Integer id_subtema) {
        IPreguntaDAO preguntaDAO = DAOFactory.getInstance().getPreguntaDAO();
        return preguntaDAO.getPreguntasBySubtema(id_subtema);
    }

    @Override
    public boolean borrarPregunta(Integer id_pregunta) {
        IPreguntaDAO preguntaDAO = DAOFactory.getInstance().getPreguntaDAO();
        return preguntaDAO.deletePregunta(id_pregunta);
    }

    @Override
    public boolean actualizarPregunta(PreguntaTO pregunta) {
        IPreguntaDAO preguntaDAO = DAOFactory.getInstance().getPreguntaDAO();
        return preguntaDAO.updatePregunta(pregunta);
    }

    @Override
    public boolean insertarPregunta(PreguntaTO pregunta) {
        IPreguntaDAO preguntaDAO = DAOFactory.getInstance().getPreguntaDAO();
        return preguntaDAO.insertPregunta(pregunta);
    }

    @Override
    public List<PreguntaTO> obtenerPreguntasAleatorias(Integer id_subtema, Integer tipo) {
        IPreguntaDAO preguntaDAO = DAOFactory.getInstance().getPreguntaDAO();
        return preguntaDAO.getPreguntasRandom(id_subtema, tipo);
    }

    @Override
    public List<RespuestaTO> obtenerRespuestasPorSubtema(Integer id_subtema, Integer id_usuario) {
        IRespuestaDAO respuestaDAO = DAOFactory.getInstance().getRespuestaDAO();
        return respuestaDAO.getRespuestasBySubtema(id_subtema, id_usuario);
    }

    @Override
    public boolean insertarRespuesta(RespuestaTO respuesta) {
        IRespuestaDAO respuestaDAO = DAOFactory.getInstance().getRespuestaDAO();
        return respuestaDAO.insertRespuesta(respuesta);
    }

    @Override
    public boolean actualizarRespuesta(RespuestaTO respuesta) {
        IRespuestaDAO respuestaDAO = DAOFactory.getInstance().getRespuestaDAO();
        return respuestaDAO.updateRespuesta(respuesta);
    }

    @Override
    public SubtemaTO obtenerSubtemaPorID(Integer id_subtema) {
        ISubtemaDAO subtemaDAO = DAOFactory.getInstance().getSubtemaDAO();
        return subtemaDAO.getSubtemaById(id_subtema);
    }

    @Override
    public List<SubtemaTO> obtenerSubtemas() {
        ISubtemaDAO subtemaDAO = DAOFactory.getInstance().getSubtemaDAO();
        return subtemaDAO.getSubtemas();
    }

    @Override
    public List<SubtemaTO> obtenerSubtemasPorTema(Integer id_tema) {
        ISubtemaDAO subtemaDAO = DAOFactory.getInstance().getSubtemaDAO();
        return subtemaDAO.getSubtemasByTema(id_tema);
    }

    @Override
    public TemaTO obtenerTemaPorID(Integer id_tema) {
        ITemaDAO temaDAO = DAOFactory.getInstance().getTemaDAO();
        return temaDAO.getTemaById(id_tema);
    }

    @Override
    public List<TemaTO> obtenerTemas() {
        ITemaDAO temaDAO = DAOFactory.getInstance().getTemaDAO();
        return temaDAO.getTemas();
    }

    @Override
    public List<TemaTO> obtenerTemasPorAsignatura(Integer id_asignatura) {
        ITemaDAO temaDAO = DAOFactory.getInstance().getTemaDAO();
        return temaDAO.getTemasByAsignatura(id_asignatura);
    }

    @Override
    public List<UsuarioArticuloTO> obtenerUsuarioArticulos(Integer id_usuario) {
        IUsuarioArticuloDAO usuarioArticuloDAO = DAOFactory.getInstance().getUsuarioArticuloDAO();
        return usuarioArticuloDAO.getUsuarioArticulos(id_usuario);
    }

    @Override
    public boolean insertarUsuarioArticulo(UsuarioArticuloTO usuarioArticulo) {
        IUsuarioArticuloDAO usuarioArticuloDAO = DAOFactory.getInstance().getUsuarioArticuloDAO();
        return usuarioArticuloDAO.insertUsuarioArticulo(usuarioArticulo);
    }

    @Override
    public List<UsuarioAsignaturaTO> ObtenerAsignaturaPorUsuario(UsuarioTO usuario) {
        IUsuarioAsignaturaDAO usuarioAsignaturaDAO = DAOFactory.getInstance().getUsuarioAsignaturaDAO();
        return usuarioAsignaturaDAO.getAsignaturaByUsuario(usuario);
    }

    @Override
    public boolean insertarUsuarioAsignatura(UsuarioAsignaturaTO usuarioAsignatura) {
        IUsuarioAsignaturaDAO usuarioAsignaturaDAO = DAOFactory.getInstance().getUsuarioAsignaturaDAO();
        return usuarioAsignaturaDAO.insertUsuarioAsignatura(usuarioAsignatura);
    }

    @Override
    public boolean actualizarUsuarioAsignatura(UsuarioAsignaturaTO usuarioAsignatura) {
        IUsuarioAsignaturaDAO usuarioAsignaturaDAO = DAOFactory.getInstance().getUsuarioAsignaturaDAO();
        return usuarioAsignaturaDAO.updateUsuarioAsignatura(usuarioAsignatura);
    }

    @Override
    public boolean usuarioAuth(UsuarioTO usuario) {
        IUsuarioDAO usuarioDAO = DAOFactory.getInstance().getUsuarioDAO();
        return usuarioDAO.usuarioAuth(usuario);
    }

    @Override
    public boolean insertarUsuario(UsuarioTO usuario) {
        IUsuarioDAO usuarioDAO = DAOFactory.getInstance().getUsuarioDAO();
        return usuarioDAO.insertUsuario(usuario);
    }

    @Override
    public List<UsuarioSubtemaTO> obtenerSubtemaPorUsuario(UsuarioTO usuario) {
        IUsuarioSubtemaDAO usuarioSubtemaDAO = DAOFactory.getInstance().getUsuarioSubtemaDAO();
        return usuarioSubtemaDAO.getSubtemaByUsuario(usuario);
    }

    @Override
    public boolean insertarUsuarioSubtema(UsuarioSubtemaTO usuarioSubtema) {
        IUsuarioSubtemaDAO usuarioSubtemaDAO = DAOFactory.getInstance().getUsuarioSubtemaDAO();
        return usuarioSubtemaDAO.insertUsuarioSubtema(usuarioSubtema);
    }

    @Override
    public boolean actualizarUsuarioSubtema(UsuarioSubtemaTO usuarioSubtema) {
        IUsuarioSubtemaDAO usuarioSubtemaDAO = DAOFactory.getInstance().getUsuarioSubtemaDAO();
        return usuarioSubtemaDAO.updateUsuarioSubtema(usuarioSubtema);
    }

    @Override
    public List<UsuarioTemaTO> obtenerTemaPorUsuario(UsuarioTO usuario) {
        IUsuarioTemaDAO usuarioTemaDAO = DAOFactory.getInstance().getUsuarioTemaDAO();
        return usuarioTemaDAO.getTemaByUsuario(usuario);
    }

    @Override
    public boolean insertarUsuarioTema(UsuarioTemaTO usuarioTema) {
        IUsuarioTemaDAO usuarioTemaDAO = DAOFactory.getInstance().getUsuarioTemaDAO();
        return usuarioTemaDAO.insertUsuarioTema(usuarioTema);
    }

    @Override
    public boolean actualizarUsuarioTema(UsuarioTemaTO usuarioTema) {
        IUsuarioTemaDAO usuarioTemaDAO = DAOFactory.getInstance().getUsuarioTemaDAO();
        return usuarioTemaDAO.updateUsuarioTema(usuarioTema);
    }
    
}
