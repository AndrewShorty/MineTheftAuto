package de.elrobto.MineTheftAuto.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.elrobto.MineTheftAuto.Main;

public class PlayerDatabase {
    public boolean playerExists(String uuid) {
        try {
            ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE UUID= '" + uuid + "'");
            if (rs.next()) {
                return rs.getString("UUID") != null;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean playerExists(String name, String exist) {
        try {
            ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE UUID= '" + name + "'");
            if (rs.next()) {
                return rs.getString("NAME") != null;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean numberExists(String number) {
        try {
            ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE NUMBER= '" + number + "'");
            if (rs.next()) {
                return rs.getString("NUMBER") != null;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createPlayer(String uuid, String name) {
        if (!playerExists(uuid)) {
        	Main.mysql.update("INSERT INTO GTA_PLAYER(UUID, NAME, RANK, NUMBER, LANGUAGE, RANG, WANTED, LEVEL, MONEY, CASH) VALUES ('" + uuid + "', '" + name + "', 'PLAYER', 'UNKNOW', 'UNKNOW', 'UNKNOW', '0', '1', '10000', '0');");
        }
    }
    
    //GET
    
    public String getUUID(String name) {
        if(playerExists(name)) {
        	ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE NAME='" + name + "'");
            try {
                if (rs.next()) {
                    return rs.getString("UUID");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            createPlayer("null", name);
            getUUID(name);
        }
        return null;
    }
    
    public String getName(String uuid) {
        if(playerExists(uuid)) {
        	ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE UUID='" + uuid + "'");
            try {
                if (rs.next()) {
                    return rs.getString("NAME");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            createPlayer(uuid, "null");
            getName(uuid);
        }
        return null;
    }
    
    public String getRank(String uuid) {
        if(playerExists(uuid)) {
        	ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE UUID='" + uuid + "'");
            try {
                if (rs.next()) {
                    return rs.getString("RANK");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            createPlayer(uuid, "null");
            getRank(uuid);
        }
        return null;
    }

    public String getNumber(String uuid) {
        if(playerExists(uuid)) {
            ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE UUID='" + uuid + "'");
            try {
                if (rs.next()) {
                    return rs.getString("NUMBER");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            createPlayer(uuid, "null");
            getRank(uuid);
        }
        return null;
    }
    
    public String getLanguage(String uuid) {
        if(playerExists(uuid)) {
        	ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE UUID='" + uuid + "'");
            try {
                if (rs.next()) {
                    return rs.getString("LANGUAGE");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            createPlayer(uuid, "null");
            getLanguage(uuid);
        }
        return null;
    }
    
    public String getRang(String uuid) {
        ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE UUID='" + uuid + "'");
        if(playerExists(uuid)) {
        	try {
                if (rs.next()) {
                    return rs.getString("RANG");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
        	createPlayer(uuid, "null");
        	getRang(uuid);
        }
        return null;
    }
    
    public Integer getWanted(String uuid) {
        Integer i = Integer.valueOf(0);
        if (playerExists(uuid)) {
            try {
                ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE UUID= '" + uuid + "'");
                if ((rs.next()) && (Integer.valueOf(rs.getInt("WANTED")) == null)) {}
                i = Integer.valueOf(rs.getInt("WANTED"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            createPlayer(uuid, "null");
            getWanted(uuid);
        }
        return i;
    }
    
    public Integer getLevel(String uuid) {
        Integer i = Integer.valueOf(0);
        if (playerExists(uuid)) {
            try {
                ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE UUID= '" + uuid + "'");
                if ((rs.next()) && (Integer.valueOf(rs.getInt("LEVEL")) == null)) {}
                i = Integer.valueOf(rs.getInt("LEVEL"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            createPlayer(uuid, "null");
            getLevel(uuid);
        }
        return i;
    }

    public Integer getMoney(String uuid) {
        Integer i = Integer.valueOf(0);
        if (playerExists(uuid)) {
            try {
                ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE UUID= '" + uuid + "'");
                if ((rs.next()) && (Integer.valueOf(rs.getInt("MONEY")) == null)) {}
                i = Integer.valueOf(rs.getInt("MONEY"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            createPlayer(uuid, "null");
            getMoney(uuid);
        }
        return i;
    }
    
    public Integer getCash(String uuid) {
        Integer i = Integer.valueOf(0);
        if (playerExists(uuid)) {
            try {
                ResultSet rs = Main.mysql.querry("SELECT * FROM GTA_PLAYER WHERE UUID= '" + uuid + "'");
                if ((rs.next()) && (Integer.valueOf(rs.getInt("CASH")) == null)) {}
                i = Integer.valueOf(rs.getInt("CASH"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            createPlayer(uuid, "null");
            getCash(uuid);
        }
        return i;
    }
    
    //SET
    
    public void setName(String uuid, String name) {
        if (playerExists(uuid)) {
            Main.mysql.update("UPDATE GTA_PLAYER SET NAME= '" + name + "' WHERE UUID= '" + uuid + "';");
        } else {
            createPlayer(uuid, "null");
            setRang(uuid, name);
        }
    }
    
    public void setRank(String uuid, String rank) {
        if (playerExists(uuid)) {
            Main.mysql.update("UPDATE GTA_PLAYER SET RANK= '" + rank + "' WHERE UUID= '" + uuid + "';");
        } else {
            createPlayer(uuid, "null");
            setRank(uuid, rank);
        }
    }
    
    public void setNumber(String uuid, String number) {
        if (playerExists(uuid)) {
            Main.mysql.update("UPDATE GTA_PLAYER SET NUMBER= '" + number + "' WHERE UUID= '" + uuid + "';");
        } else {
            createPlayer(uuid, "null");
            setNumber(uuid, number);
        }
    }
    
    public void setLanguage(String uuid, String language) {
        if (playerExists(uuid)) {
            Main.mysql.update("UPDATE GTA_PLAYER SET LANGUAGE= '" + language + "' WHERE UUID= '" + uuid + "';");
        } else {
            createPlayer(uuid, "null");
            setRang(uuid, language);
        }
    }
    
    public void setRang(String uuid, String rang) {
        if (playerExists(uuid)) {
            Main.mysql.update("UPDATE GTA_PLAYER SET RANG= '" + rang + "' WHERE UUID= '" + uuid + "';");
        } else {
            createPlayer(uuid, "null");
            setRang(uuid, rang);
        }
    }

    public void setWanted(String uuid, Integer level) {
        if (playerExists(uuid)) {
            Main.mysql.update("UPDATE GTA_PLAYER SET WANTED= '" + level + "' WHERE UUID= '" + uuid + "';");
        } else {
            createPlayer(uuid, "null");
            setWanted(uuid, level);
        }
    }
    
    public void setLevel(String uuid, Integer level) {
        if (playerExists(uuid)) {
            Main.mysql.update("UPDATE GTA_PLAYER SET LEVEL= '" + level + "' WHERE UUID= '" + uuid + "';");
        } else {
            createPlayer(uuid, "null");
            setLevel(uuid, level);
        }
    }
    
    public void setMoney(String uuid, Integer money) {
        if (playerExists(uuid)) {
            Main.mysql.update("UPDATE GTA_PLAYER SET MONEY= '" + money + "' WHERE UUID= '" + uuid + "';");
        } else {
            createPlayer(uuid, "null");
            setMoney(uuid, money);
        }
    }
    
    public void setCash(String uuid, Integer money) {
        if (playerExists(uuid)) {
            Main.mysql.update("UPDATE GTA_PLAYER SET CASH= '" + money + "' WHERE UUID= '" + uuid + "';");
        } else {
            createPlayer(uuid, "null");
            setCash(uuid, money);
        }
    }
    
    //ADD

    public void addWanted(String uuid, Integer level) {
        if (playerExists(uuid)) {
            setWanted(uuid, Integer.valueOf(getWanted(uuid).intValue() + level.intValue()));
        } else {
            createPlayer(uuid, "null");
            addWanted(uuid, level);
        }
    }
    
    public void addLevel(String uuid, Integer level) {
        if (playerExists(uuid)) {
            setLevel(uuid, Integer.valueOf(getLevel(uuid).intValue() + level.intValue()));
        } else {
            createPlayer(uuid, "null");
            addLevel(uuid, level);
        }
    }
    
    public void addMoney(String uuid, Integer money) {
        if (playerExists(uuid)) {
            setMoney(uuid, Integer.valueOf(getMoney(uuid).intValue() + money.intValue()));
        } else {
            createPlayer(uuid, "null");
            addMoney(uuid, money);
        }
    }
    
    public void addCash(String uuid, Integer money) {
        if (playerExists(uuid)) {
            setCash(uuid, Integer.valueOf(getCash(uuid).intValue() + money.intValue()));
        } else {
            createPlayer(uuid, "null");
            addCash(uuid, money);
        }
    }
    
    //REMOVE
    
    public void removeWanted(String uuid, Integer level) {
        if (playerExists(uuid)) {
            setWanted(uuid, Integer.valueOf(getWanted(uuid).intValue() - level.intValue()));
        } else {
            createPlayer(uuid, "null");
            removeWanted(uuid, level);
        }
    }
    
    public void removeLevel(String uuid, Integer level) {
        if (playerExists(uuid)) {
            setLevel(uuid, Integer.valueOf(getLevel(uuid).intValue() - level.intValue()));
        } else {
            createPlayer(uuid, "null");
            removeLevel(uuid, level);
        }
    }
    
    public void removeMoney(String uuid, Integer money) {
        if (playerExists(uuid)) {
            setMoney(uuid, Integer.valueOf(getMoney(uuid).intValue() - money.intValue()));
        } else {
            createPlayer(uuid, "null");
            removeMoney(uuid, money);
        }
    }
    
    public void removeCash(String uuid, Integer money) {
        if (playerExists(uuid)) {
            setCash(uuid, Integer.valueOf(getCash(uuid).intValue() - money.intValue()));
        } else {
            createPlayer(uuid, "null");
            removeCash(uuid, money);
        }
    }
}