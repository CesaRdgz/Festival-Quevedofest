package Practicaddbb;

import org.sqlite.SQLiteDataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Scanner;

public class Conexion {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String url = "jdbc:sqlite:C:\\sqlite\\Quevedofest.db";
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        String crearTabla = "CREATE TABLE anuncios id numeric NOT NULL,tipo varchar(20) NOT NULL,sorteo varchar(2) NOT NULL, idSponsor numeric,idInfluencer numeric, CONSTRAINT anuncios_id_pk PRIMARY KEY (id), CONSTRAINT anuncios_tipo_ck CHECK (tipo IN ('Television','Redes','Radio')), CONSTRAINT anuncios_sorteo_ck CHECK (sorteo IN ('Si','No')); ";
        try (Connection con = dataSource.getConnection();) {

            try (Statement st = con.createStatement()) {
                st.executeUpdate(crearTabla);


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
