package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import pojo.IplPlayer;
import utils.dbutils;

public class Playerdaoimpl implements Playerdao {
	private Connection cn;
	private PreparedStatement pst1;

	public Playerdaoimpl() throws SQLException {
		cn = dbutils.getconnection();
		pst1 = cn.prepareStatement("insert into Player value(default,?,?,?,?,?,?)");
	}

	@Override
	public boolean InsertPlayer(IplPlayer p) throws SQLException {
		pst1.setString(1, p.getPlayer_Name());
		pst1.setDate(2, p.getDob());
		pst1.setString(3, p.getAddress());
		pst1.setDouble(4, p.getBatingAvg());
		pst1.setInt(5, p.getWicket());
		pst1.setInt(6, p.getTeam());
	
		if (pst1.executeUpdate() == 1) {
			return true;
		} else {
			return false;
		}

	}

	public void closeconnection() throws SQLException {
		if (pst1 != null) {
			pst1.close();
		}
	}

}

//-------------+-------------+------+-----+---------+----------------+
//| Player_id   | int         | NO   | PRI | NULL    | auto_increment |
//| Player_Name | varchar(20) | YES  |     | NULL    |                |
//| Dob         | date        | YES  |     | NULL    |                |
//| Address     | varchar(20) | YES  |     | NULL    |                |
//| BatingAvg   | double(9,2) | YES  |     | NULL    |                |
//| Wicket      | int         | YES  |     | NULL    |                |
//| tid
