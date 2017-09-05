package de.elrobto.MineTheftAuto.MySQL;

import de.elrobto.MineTheftAuto.Main;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactDatabase {
    
    public List<String> getAllContacts(final String player) {
        final List<String> contacts = new ArrayList<String>();
        try {
            final ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_Contacts WHERE PLAYER = '" + player + "'");
            while (rs.next()) {
                contacts.add(rs.getString("CONTACT"));
            }
        }
        catch (Exception ex) {
            Main.mysql.connect();
            return getAllContacts(player);
        }
        return contacts;
    }
    
    public void addContact(final String player, final String friend) {
        try {
            Main.mysql.update("INSERT INTO GTA_Contacts (PLAYER, CONTACT) VALUES ('" + player + "', '" + friend + "')");
        }
        catch (Exception ex) {
            Main.mysql.connect();
            addContact(player, friend);
        }
    }
    
    public void removeContact(final String player, final String friend) {
        try {
            Main.mysql.update("DELETE FROM GTA_Contacts WHERE PLAYER = '" + player + "' AND CONTACT = '" + friend + "'");
        }
        catch (Exception ex) {
            Main.mysql.connect();
            removeContact(player, friend);
        }
    }
    
    public boolean isContact(final String player, final String player2) {
        try {
            final ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_Contacts WHERE PLAYER = '" + player + "'");
            while (rs.next()) {
                final String friendname = rs.getString("CONTACT");
                if (player2.equalsIgnoreCase(friendname)) {
                    return true;
                }
            }
        }
        catch (Exception ex) {
            Main.mysql.connect();
            return isContact(player, player2);
        }
        return false;
    }
    
    public int getContats(final String player) {
        return getAllContacts(player).size();
    }
}