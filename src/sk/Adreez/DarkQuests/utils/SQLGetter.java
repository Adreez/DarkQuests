package sk.Adreez.DarkQuests.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sk.Adreez.DarkQuests.*;
import org.bukkit.entity.Player;

public class SQLGetter {
	
	String table = Main.config.getString("MySQL.table");

	public void createTable() {
		PreparedStatement ps;
		try {
			ps = Main.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS " + table + " (NICK VARCHAR(100),UUID VARCHAR(100),COMPLETEDQUESTS INT(100),ACTIVEQUEST INT(100),PROGRESS INT(100),NEEDEDPROGRESS INT(100),PRIMARY KEY (NICK))");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createPlayer(Player player) {
		try {
			if (!exists(player)) {
				PreparedStatement ps2 = Main.SQL.getConnection().prepareStatement("INSERT IGNORE INTO " + table + " (NICK,UUID,COMPLETEDQUESTS) VALUES (?,?,?)");
				ps2.setString(1, player.getName());
				ps2.setString(2, player.getUniqueId().toString());
				ps2.setInt(3, 0);
				ps2.executeUpdate();
				
				return;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean exists(Player nick) {
		try {
			PreparedStatement ps = Main.SQL.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE NICK=?");
			ps.setString(1, nick.getName());
			ResultSet results = ps.executeQuery();
			if (results.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	

	public void setActiveQuest(Player nick, int quest) {
		try {
			PreparedStatement ps = Main.SQL.getConnection().prepareStatement("UPDATE " + table + " SET ACTIVEQUEST=? WHERE NICK=?");
			ps.setInt(1, quest);
			ps.setString(2, nick.getName());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getActiveQuest(Player nick) {
		try {
			PreparedStatement ps = Main.SQL.getConnection().prepareStatement("SELECT ACTIVEQUEST FROM " + table + " WHERE NICK=?");
			ps.setString(1, nick.getName());
			ResultSet rs = ps.executeQuery();
			int activeQuest = 0;
			
			if (rs.next()) {
				activeQuest = rs.getInt("ACTIVEQUEST");
				return activeQuest;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getCompletedQuests(Player nick) {
		try {
			PreparedStatement ps = Main.SQL.getConnection().prepareStatement("SELECT COMPLETEDQUESTS FROM " + table + " WHERE NICK=?");
			ps.setString(1, nick.getName());
			ResultSet rs = ps.executeQuery();
			int completedQuests = 0;
			
			if (rs.next()) {
				completedQuests = rs.getInt("COMPLETEDQUESTS");
				return completedQuests;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void addCompletedQuest(Player nick) {
		try {
			PreparedStatement ps = Main.SQL.getConnection().prepareStatement("UPDATE " + table + " SET COMPLETEDQUESTS=? WHERE NICK=?");
			ps.setInt(1, (getCompletedQuests(nick) + 1));
			ps.setString(2, nick.getName());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getProgress(Player nick) {
		try {
			PreparedStatement ps = Main.SQL.getConnection().prepareStatement("SELECT PROGRESS FROM " + table + " WHERE NICK=?");
			ps.setString(1, nick.getName());
			ResultSet rs = ps.executeQuery();
			int progress = 0;
			
			if (rs.next()) {
				progress = rs.getInt("PROGRESS");
				return progress;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void addToProgress(Player nick) {
		try {
			PreparedStatement ps = Main.SQL.getConnection().prepareStatement("UPDATE " + table + " SET PROGRESS=? WHERE NICK=?");
			ps.setInt(1, getProgress(nick) + 1);
			ps.setString(2, nick.getName());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void resetProgress(Player nick) {
		try {
			PreparedStatement ps = Main.SQL.getConnection().prepareStatement("UPDATE " + table + " SET PROGRESS=? WHERE NICK=?");
			ps.setInt(1, 0);
			ps.setString(2, nick.getName());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setNeededProgress(Player nick, int neededProgressInt) {
		try {
			PreparedStatement ps = Main.SQL.getConnection().prepareStatement("UPDATE " + table + " SET NEEDEDPROGRESS=? WHERE NICK=?");
			ps.setInt(1, neededProgressInt);
			ps.setString(2, nick.getName());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getNeededProgress(Player nick) {
		try {
			PreparedStatement ps = Main.SQL.getConnection().prepareStatement("SELECT NEEDEDPROGRESS FROM " + table + " WHERE NICK=?");
			ps.setString(1, nick.getName());
			ResultSet rs = ps.executeQuery();
			int neededProgress = 0;
			
			if (rs.next()) {
				neededProgress = rs.getInt("NEEDEDPROGRESS");
				return neededProgress;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
