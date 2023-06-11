package Dao;

import java.sql.SQLException;

import pojo.IplPlayer;

public interface Playerdao {
	
	boolean InsertPlayer(IplPlayer p)throws SQLException;

}
