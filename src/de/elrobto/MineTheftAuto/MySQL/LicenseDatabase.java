package de.elrobto.MineTheftAuto.MySQL;

import de.elrobto.MineTheftAuto.Main;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LicenseDatabase {
    
    public boolean playerExists(String uuid) {
        try {
            ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_LICENSE WHERE UUID= '" + uuid + "'");
            if (rs.next()) {
                return rs.getString("UUID") != null;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createPlayer(String uuid) {
        if (!playerExists(uuid)) {
        	Main.mysql.update("INSERT INTO GTA_LICENSE(UUID, PERSO, WAFFEN, AUTO, JOB, MARKT) VALUES ('" + uuid + "', 'NEIN', 'NEIN', 'NEIN', 'NEIN', 'NEIN');");
        }
    }
    
    public String get(String uuid, String license) {
        ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_LICENSE WHERE UUID='" + uuid + "'");
        if(playerExists(uuid)) {
        	try {
                if (rs.next()) {
                    return rs.getString(license);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
        	createPlayer(uuid);
        	get(uuid, license);
        }
        return null;
    }
    
    public void set(String uuid, String license, String janein) {
        if (playerExists(uuid)) {
            Main.mysql.update("UPDATE GTA_LICENSE SET " + license + "= '" + janein + "' WHERE UUID= '" + uuid + "';");
        } else {
            createPlayer(uuid);
            set(uuid, license, janein);
        }
    }
}