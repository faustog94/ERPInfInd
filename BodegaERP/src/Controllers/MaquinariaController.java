package Controllers;

import Models.Maquinaria;
import erpinfind.DBConnection;
import erpinfind.Queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaquinariaController {

    //IDMAQ, 'CODMAQ', 'DESC', IDCEN, ACT
    public static void altaMaquinaria(String codMaquinaria, String descripcion, int idCentro, boolean activa){
        String sql = Queries.MAQUINARIA_ALTAMAQUINARIA;
        sql = sql.replaceAll("CODMAQ", codMaquinaria);
        sql = sql.replaceAll("DESC", descripcion);
        sql = sql.replaceAll("IDCEN", String.valueOf(idCentro));
        sql = sql.replaceAll("ACT", String.valueOf(activa));

        DBConnection.execSQL(sql);
    }

    public static void modificarMaquinaria(int idMaquinaria, String codMaquinaria, String descripcion, int idCentro, boolean activa){
        String sql = Queries.MAQUINARIA_MODIFICARMAQUINARIA;
        sql = sql.replaceAll("CODMAQ", codMaquinaria);
        sql = sql.replaceAll("DESC", descripcion);
        sql = sql.replaceAll("IDCEN", String.valueOf(idCentro));
        sql = sql.replaceAll("ACT", String.valueOf(activa));
        sql = sql.replaceAll("IDMAQ", String.valueOf(idMaquinaria));

        DBConnection.execSQL(sql);
    }

    public static void bajaMaquinaria(int idMaquinaria){
        String sql = Queries.MAQUINARIA_BAJAMAQUINARIA;
        sql = sql.replaceAll("IDMAQ", String.valueOf(idMaquinaria));

        DBConnection.execSQL(sql);
    }

    public static ArrayList<Maquinaria> getMaquinaria(){
        ArrayList<Maquinaria> maquinarias = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.MAQUINARIA_GETMAQUINARIA);
            while (rs.next()) {
                //int idMaquinaria, String codMaquinaria, String descripcion, int idCentro, boolean activa
                int idMaquinaria = rs.getInt("idMaquinaria");
                String codMaquinaria = rs.getString("codMaquinaria");
                String descripcion = rs.getString("descripcion");
                int idCentro = rs.getInt("idCentro");
                boolean activo = rs.getBoolean("activo");

                Maquinaria temp = new Maquinaria(idMaquinaria, codMaquinaria, descripcion, idCentro, activo);
                maquinarias.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maquinarias;
    }
    public static ArrayList<Maquinaria> getMaquinariaActiva(){
        ArrayList<Maquinaria> maquinarias = new ArrayList();
        try {
            ResultSet rs = DBConnection.execSelectSQL(Queries.MAQUINARIA_GETMAQUINARIAACTIVA);
            while (rs.next()) {
                //int idMaquinaria, String codMaquinaria, String descripcion, int idCentro, boolean activa
                int idMaquinaria = rs.getInt("idMaquinaria");
                String codMaquinaria = rs.getString("codMaquinaria");
                String descripcion = rs.getString("descripcion");
                int idCentro = rs.getInt("idCentro");


                Maquinaria temp = new Maquinaria(idMaquinaria, codMaquinaria, descripcion, idCentro, true);
                maquinarias.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maquinarias;
    }

    public static ArrayList<Maquinaria> getMaquinariaActivaByCentro(int idCentro){
        ArrayList<Maquinaria> maquinarias = new ArrayList();
        String sql = Queries.MAQUINARIA_GETMAQUINARIAACTIVABYCENTRO;
        sql = sql.replaceAll("IDCEN", String.valueOf(idCentro));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idMaquinaria, String codMaquinaria, String descripcion, int idCentro, boolean activa
                int idMaquinaria = rs.getInt("idMaquinaria");
                String codMaquinaria = rs.getString("codMaquinaria");
                String descripcion = rs.getString("descripcion");

                Maquinaria temp = new Maquinaria(idMaquinaria, codMaquinaria, descripcion, idCentro, true);
                maquinarias.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maquinarias;
    }

    public static ArrayList<Maquinaria> getMaquinariaByCentro(int idCentro){
        ArrayList<Maquinaria> maquinarias = new ArrayList();
        String sql = Queries.MAQUINARIA_GETMAQUINARIABYCENTRO;
        sql = sql.replaceAll("IDCEN", String.valueOf(idCentro));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idMaquinaria, String codMaquinaria, String descripcion, int idCentro, boolean activa
                int idMaquinaria = rs.getInt("idMaquinaria");
                String codMaquinaria = rs.getString("codMaquinaria");
                String descripcion = rs.getString("descripcion");
                boolean activo = rs.getBoolean("activo");

                Maquinaria temp = new Maquinaria(idMaquinaria, codMaquinaria, descripcion, idCentro, activo);
                maquinarias.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maquinarias;
    }

    public static Maquinaria getMaquinariaByCod(String codMaquinaria){
        Maquinaria maq = new Maquinaria();
        String sql = Queries.MAQUINARIA_GETMAQUINARIABYCOD;
        sql = sql.replaceAll("CODMAQ", codMaquinaria);
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idMaquinaria, String codMaquinaria, String descripcion, int idCentro, boolean activa
                int idMaquinaria = rs.getInt("idMaquinaria");
                String descripcion = rs.getString("descripcion");
                int idCentro = rs.getInt("idCentro");
                boolean activo = rs.getBoolean("activo");

                maq.setIdMaquinaria(idMaquinaria);
                maq.setCodMaquinaria(codMaquinaria);
                maq.setDescripcion(descripcion);
                maq.setIdCentro(idCentro);
                maq.setActiva(activo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maq;
    }

    public static Maquinaria getMaquinariaById(int idMaquinaria){
        Maquinaria maq = new Maquinaria();
        String sql = Queries.MAQUINARIA_GETMAQUINARIABYID;
        sql = sql.replaceAll("IDCEN", String.valueOf(idMaquinaria));
        try {
            ResultSet rs = DBConnection.execSelectSQL(sql);
            while (rs.next()) {
                //int idMaquinaria, String codMaquinaria, String descripcion, int idCentro, boolean activa
                String codMaquinaria = rs.getString("codMaquinaria");
                String descripcion = rs.getString("descripcion");
                int idCentro = rs.getInt("idCentro");
                boolean activo = rs.getBoolean("activo");

                maq.setIdMaquinaria(idMaquinaria);
                maq.setCodMaquinaria(codMaquinaria);
                maq.setDescripcion(descripcion);
                maq.setIdCentro(idCentro);
                maq.setActiva(activo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maq;
    }
}
