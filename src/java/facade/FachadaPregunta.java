package facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import to.DificultadTO;
import to.PreguntaTO;
import to.SubtemaTO;
import to.TipoPreguntaTO;

public class FachadaPregunta {

    PreguntaTO pregunta = new PreguntaTO();
    SubtemaTO subtema = new SubtemaTO();
    TipoPreguntaTO tp = new TipoPreguntaTO();
    DificultadTO dificultad = new DificultadTO();
    ResultSet rs;

    public FachadaPregunta(ResultSet rs) {
        this.rs = rs;
    }

    public PreguntaTO getPregunta() throws SQLException {

        pregunta.setIdPregunta(rs.getInt(1));
        pregunta.setEnunciado(rs.getString(2));
        pregunta.setClave1(rs.getString(3));
        pregunta.setClave2(rs.getString(4));
        pregunta.setClave3(rs.getString(5));
        pregunta.setClave4(rs.getString(6));
        pregunta.setClave5(rs.getString(7));
        pregunta.setEstado(rs.getInt(8));
        subtema.setIdSubtema(rs.getInt(9));
        tp.setIdTipopregunta(rs.getInt(10));
        dificultad.setIdDificultad(rs.getInt(11));
        dificultad.setNivel(rs.getString(12));
        pregunta.setIdDificultad(dificultad);
        pregunta.setIdSubtema(subtema);
        pregunta.setIdTipopregunta(tp);
        pregunta.setCorrectaNum(rs.getInt(13));
        pregunta.setInformacion(rs.getString(14));

        return pregunta;
    }

    public PreguntaTO getPreguntaBySubtema(int id_subtema) throws SQLException {

        pregunta.setIdPregunta(rs.getInt(1));
        pregunta.setEnunciado(rs.getString(2));
        pregunta.setClave1(rs.getString(3));
        pregunta.setClave2(rs.getString(4));
        pregunta.setClave3(rs.getString(5));
        pregunta.setClave4(rs.getString(6));
        pregunta.setClave5(rs.getString(7));
        pregunta.setEstado(rs.getInt(8));
        subtema.setIdSubtema(id_subtema);
        tp.setIdTipopregunta(rs.getInt(9));
        dificultad.setIdDificultad(rs.getInt(10));
        dificultad.setNivel(rs.getString(11));
        pregunta.setIdDificultad(dificultad);
        pregunta.setIdSubtema(subtema);
        pregunta.setIdTipopregunta(tp);
        pregunta.setCorrectaNum(rs.getInt(12));
        pregunta.setInformacion(rs.getString(13));
        return pregunta;
    }

}
