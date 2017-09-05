package de.elrobto.MineTheftAuto.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.Bukkit;

/**
 * This is a API Created by elrobtossohn
 */
public class MySQL {

    private String HOST = "";
    private String DATABASE = "";
    private String USER = "";
    private String PORT = "";
    private String PASSWORD = "";

    private Connection con;

    public MySQL(String host, String database, String user, String password, String port){
        this.HOST = host;
        this.DATABASE = database;
        this.USER = user;
        this.PASSWORD = password;
        this.PORT = port;
    }

    public void connect() {
        try{
            con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?autoreconnect=true", USER, PASSWORD);
            Bukkit.getConsoleSender().sendMessage("§8[§eMySQL§8] §7Die Verbindung wurde gestartet");
        }catch(SQLException e){
            Bukkit.getConsoleSender().sendMessage("§8[§eMySQL§8] §cEin Fehler ist aufgetreten, Bitte starte den Server oder phpmyadmin/MySQL neu.");
        }
    }

    public void disconnect(){
        try{
            if(connected()){
                con.close();
                Bukkit.getConsoleSender().sendMessage("§8[§eMySQL§8] §7Die Verbindung wurde beendet");

            }

        }catch(SQLException e){
            Bukkit.getConsoleSender().sendMessage("§8[§eMySQL§8] §cEin Fehler ist aufgetreten, Bitte starte den Server oder phpmyadmin/MySQL neu.");
        }
    }
    public boolean connected(){
        return con == null ? false : true;
    }
    public void update(String qry){
        try {
            Statement st = con.createStatement();
            st.executeUpdate(qry);
            st.close();
        } catch (SQLException e) {
            connect();
            System.err.println(e);
        }
    }
    public ResultSet querry(String qry){
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(qry);
        } catch (SQLException e) {
            connect();
            System.err.println(e);
        }
        return rs;
    }
}