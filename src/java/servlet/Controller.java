/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Adapter.DAOAdapter;
import Adapter.DBAction;
import dao.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import observer.componente.EstadisticaAsignatura;
import observer.componente.EstadisticaTema;
import observer.componente.estadisticaSubTema;
import observer.design.ObservadoEstadistica;
import observer.design.ObservadorEstadistica;
import strategy.StrategyFactory;
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
 * @author kevinMC
 *
 * https://jarroba.com/ajax-con-jsp-y-servelts/ https://github.com/miw-upm
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    Dispacher dispacher;
    DBAction adapter;
    UsuarioTO usuario;
    ObservadoEstadistica subTemaObservado;
    List<AsignaturaTO> listaAsignaturas;
    List<PreguntaTO> listaPreguntaTO;
    int contador = 0;
    boolean fallo;
    int idSubtema;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String instruccion = request.getParameter("instruccion");
        System.out.println("Instruccion " + instruccion);
        switch (instruccion) {
            case "asignaturas":
                getAsignaturas(request, response);
                break;
            case "login":
                isUser(request, response);
                break;
            case "temas":
                getTemas(request, response);
                break;
            case "subtemas":
                getSubtemas(request, response);
                break;
            case "preguntas":
                getPreguntas(request, response);
                break;
            case "tienda":
                getArticulosTienda(request, response);
                break;
            case "formulario":
                setUser(request, response);
                break;
            case "perfil":
                getUser(request, response);
                break;
            case "compras":
                comprarArticulo(request, response);
                break;
            case "getMonedas":
                getMonedas(request, response);
                break;
            case "comprarMonedas":
                comprarMonedas(request, response);
                break;
            case "pagar":
                pagar(request, response);
                break;
            case "respuesta":
                getRespuesta(request, response);
                break;
            case "next":
                next(request, response);
                break;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void getAsignaturas(HttpServletRequest request, HttpServletResponse response) {
        try {
            /**
             * Aca obtenemos las asiganturas desde los daos
             */
            adapter = new DAOAdapter();
            System.out.println("idUser" + usuario.getIdUsuario());
            List<UsuarioAsignaturaTO> lista = adapter.ObtenerAsignaturaPorUsuario(usuario);
            PrintWriter out = response.getWriter();
            System.out.println("esta en el servlet getAsiganturas" + lista);
            out.println("<table>");
            lista.forEach((a) -> {
                out.println("<tr><td><button id='" + a.getIdAsignatura().getNombre() + "' class='w3-bar-item w3-button' onclick='openCourse(" + a.getIdAsignatura().getIdAsignatura() + ", this.id)'>" + a.getIdAsignatura().getNombre() + "</button></td><td>" + "<span style='margin:4.4em;'>" + a.getPorcentaje() + "%</span></td></tr>");
            });
            out.print("</table>");
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getTemas(HttpServletRequest request, HttpServletResponse response) {
        /**
         * aca se obtiene los temas por asignatura desdelos daos recibe como
         * parametro un id =>request.getParametrer("id")
         */
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        adapter = new DAOAdapter();
        try {
            List<TemaTO> lista = adapter.obtenerTemasPorAsignatura(id);
            List<UsuarioTemaTO> listaU = adapter.obtenerTemaPorUsuario(usuario);
            System.out.println("Servlet getTemas : " + lista);
            request.setAttribute("lista", lista);
            request.setAttribute("listaU", listaU);
            RequestDispatcher disp = request.getRequestDispatcher("/views/temas.jsp");
            disp.forward(request, response);
            // PrintWriter out = response.getWriter();
            /* lista.forEach((a) -> {
                out.println(a.getNombre());
                out.println(a.getIdTema());
                out.println(a.getIdAsignatura().getIdAsignatura());
            });*/
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getSubtemas(HttpServletRequest request, HttpServletResponse response) {
        /**
         * aca obtenemos los subtemas por tema desde los daos recibe como
         * parametro un id =>request.getParametrer("id")
         */
        int id = Integer.parseInt(request.getParameter("id"));
        contador = 0;
        fallo = true;
        System.out.println("IdTema : " + id);
        adapter = new DAOAdapter();
        try {
            List<SubtemaTO> lista = adapter.obtenerSubtemasPorTema(id);

            System.out.println("servelt getSubTemas" + lista);
            request.setAttribute("lista", lista);
            RequestDispatcher disp = request.getRequestDispatcher("/views/subTemas.jsp");
            disp.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getPreguntas(HttpServletRequest request, HttpServletResponse response) {
        /**
         * obtiene las preguntas por subtema recibe un id
         * =>request;getParametrer("id")
         */
        int id = Integer.parseInt(request.getParameter("id"));
        idSubtema = id;
        System.out.println("IdSubTema : " + id);
        adapter = new DAOAdapter();
        try {
            listaPreguntaTO = adapter.obtenerPreguntasAleatorias(id, 0);
            System.out.println("servelt getPreguntas" + listaPreguntaTO);
            request.setAttribute("lista", listaPreguntaTO.get(0));
            request.setAttribute("contador", 1);
            RequestDispatcher disp = request.getRequestDispatcher("/views/preguntas.jsp");
            disp.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void isUser(HttpServletRequest request, HttpServletResponse response) {
        dispacher = new Dispacher();
        String view = dispacher.isUser(request);
        subTemaObservado = new estadisticaSubTema();
        ObservadorEstadistica temaObservador = new EstadisticaTema();
        ObservadorEstadistica asignaturaObservador = new EstadisticaAsignatura();
        subTemaObservado.addObservadores(temaObservador);
        subTemaObservado.addObservadores(asignaturaObservador);
        usuario = new UsuarioTO();
        usuario.setUsuario(request.getParameter("uname"));
        usuario.setPassword(request.getParameter("upass"));
        try {

            usuario = DAOFactory.getInstance().getUsuarioDAO().getUser(usuario);
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println("Error en el login" + ex.getMessage());
        }

    }

    private void getArticulosTienda(HttpServletRequest request, HttpServletResponse response) {
        try {
            adapter = new DAOAdapter();
            System.out.println("Esta en getArticulos");
            List<ArticuloTO> lista = adapter.obtenerArticulos();
            System.out.println("servelt articulos" + lista);
            request.setAttribute("lista", lista);
            RequestDispatcher disp = request.getRequestDispatcher("/views/articulos.jsp");
            disp.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setUser(HttpServletRequest request, HttpServletResponse response) {
        adapter = new DAOAdapter();
        usuario = new UsuarioTO();
        UsuarioTO usuarioID = new UsuarioTO();
        UsuarioAsignaturaTO usuAsig;
        try {
            PrintWriter out = response.getWriter();
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String correo = request.getParameter("correo");
            String user = request.getParameter("usuario");
            String password = request.getParameter("password");
            //######################################################
            usuario.setNombres(nombre);
            usuario.setApellido(apellido);
            usuario.setCorreo(correo);
            usuario.setUsuario(user);
            usuario.setPassword(password);
            usuario.setMonedas(0);
            System.out.println(usuario.getApellido());
            //######################################################
            if (adapter.insertarUsuario(usuario)) {
                usuarioID = DAOFactory.getInstance().getUsuarioDAO().getUser(usuario);
                System.out.println("ID_usuario" + usuarioID.getIdUsuario());
                usuario.setIdUsuario(usuarioID.getIdUsuario());
                listaAsignaturas = adapter.obtenerAsignaturas();
                for (AsignaturaTO a : listaAsignaturas) {
                    usuAsig = new UsuarioAsignaturaTO();
                    usuAsig.setIdUsuario(usuario);
                    usuAsig.setIdAsignatura(a);
                    usuAsig.setPorcentaje(0.0);
                    System.out.println("resultadoInser" + adapter.insertarUsuarioAsignatura(usuAsig));
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
                dispatcher.forward(request, response);
            } else {
                out.print("no se pudo crear usuario");
            }
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("lista", usuario);
            RequestDispatcher disp = request.getRequestDispatcher("/views/perfil.jsp");
            disp.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void comprarArticulo(HttpServletRequest request, HttpServletResponse response) {
        try {
            ArticuloTO articulo = new ArticuloTO();
            UsuarioArticuloTO usuarioArt;
            PrintWriter out = response.getWriter();
            UsuarioAsignaturaTO usuarioAsignatura;
            AsignaturaTO asignatura;

            System.out.println("Servlet comprar Articulos");
            int id_articulo = Integer.parseInt(request.getParameter("id"));
            int costo = Integer.parseInt(request.getParameter("costo"));

            articulo.setCosto(costo);
            articulo.setIdArticulo(id_articulo);

            asignatura = new AsignaturaTO();
            asignatura.setIdAsignatura(id_articulo);

            System.out.println("monedas:" + usuario.getMonedas() + " costo es:" + articulo.getCosto());

            if (usuario.getMonedas() >= articulo.getCosto()) {
                adapter = new DAOAdapter();
                usuarioArt = new UsuarioArticuloTO();
                usuarioArt.setIdArticulo(articulo);
                usuarioArt.setIdUsuario(usuario);

                adapter.insertarUsuarioArticulo(usuarioArt);

                usuarioAsignatura = new UsuarioAsignaturaTO();
                usuarioAsignatura.setIdAsignatura(asignatura);
                usuarioAsignatura.setIdUsuario(usuario);
                usuarioAsignatura.setPorcentaje(0.0);
                adapter.insertarUsuarioAsignatura(usuarioAsignatura);

                usuario.setMonedas(usuario.getMonedas() - costo);
                System.out.println(DAOFactory.getInstance().getUsuarioDAO().updateUser(usuario));
                out.print("enhorabuena acabas de adquirir un fantastico modulo");
            } else {
                out.print("no tienes monedas suficientes para adquirir este modulo");
            }
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getMonedas(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            out.print(usuario.getMonedas());
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void comprarMonedas(HttpServletRequest request, HttpServletResponse response) {
        try {

            RequestDispatcher disp = request.getRequestDispatcher("/views/pasarela.jsp");
            disp.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pagar(HttpServletRequest request, HttpServletResponse response) {
        String tipo = request.getParameter("tipo");
        double monto = Double.parseDouble(request.getParameter("monto"));
        System.out.println("monto" + monto);
        StrategyFactory strategy = new StrategyFactory();
        strategy.getStrategy(tipo).pay(monto, usuario);
    }

    private void acertoRespuesta(Integer acerto, String idPregunta) {
        if (contador < 7) {
            RespuestaTO res = new RespuestaTO();
            res.setIdUsuario(usuario);
            res.setIdPregunta(listaPreguntaTO.get(0));
            res.setAcertada(acerto);
            if (adapter.obtenerRespuesta(usuario.getIdUsuario(), Integer.parseInt(idPregunta))) {
                System.out.println("Existe");
                adapter.actualizarRespuesta(res);
                System.out.println("ACTUALIZADO CON EXITO");
            } else {
                System.out.println("No Existe");
                adapter.insertarRespuesta(res);
                System.out.println("INSERTADO CON EXITO");
            }
        }

    }

    private void getRespuesta(HttpServletRequest request, HttpServletResponse response) {
        String idPregunta = request.getParameter("idP");
        String clave = request.getParameter("c");
        int i = 0;
        try {
            PrintWriter out = response.getWriter();
            for (PreguntaTO preguntaTO : listaPreguntaTO) {
                if (preguntaTO.getIdPregunta().toString().equals(idPregunta) && preguntaTO.getCorrectaNum().toString().equals(clave)) {
                    if(listaPreguntaTO.size()==1){
                       acertoRespuesta(1, idPregunta);
                       listaPreguntaTO.remove(0);
                        i = 1;
                       break;
                    }
                    listaPreguntaTO.remove(0);
                    System.out.println("En el if ");
                    out.print("Correcta");
                    System.out.println("Correcta");
                    acertoRespuesta(1, idPregunta);
                    i = 1;
                    break;
                }
            }
            if (i == 0) {
                fallo = false;
                acertoRespuesta(0, idPregunta);
                out.print("Incorrecta");
                System.out.println("en el if i=0");
                System.out.println("La Cagaste");
                listaPreguntaTO.add(listaPreguntaTO.get(0));
                listaPreguntaTO.remove(0);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void next(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            if (listaPreguntaTO.isEmpty()) {
                if(fallo){
                    System.out.println("entro al fallo");
                    UsuarioSubtemaTO Usubtema= new UsuarioSubtemaTO();
                    
                    SubtemaTO subtema= new SubtemaTO();
                    subtema.setIdSubtema(idSubtema);
                    
                    Usubtema.setIdSubtema(subtema);
                    Usubtema.setIdUsuario(usuario);
                    Usubtema.setCompletado(fallo);
                    
                    subTemaObservado.updateEstadistica(Usubtema);
                }
                out.print("fin");
                return;
            }
            System.out.println(listaPreguntaTO.size());
            contador++;
            request.setAttribute("lista", listaPreguntaTO.get(0));
            request.setAttribute("contador", contador + 1);
            RequestDispatcher disp = request.getRequestDispatcher("/views/preguntas.jsp");
            disp.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
