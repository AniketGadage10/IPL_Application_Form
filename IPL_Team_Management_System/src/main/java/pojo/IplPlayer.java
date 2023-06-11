package pojo;

import java.sql.*;

public class IplPlayer {
	private int Player_id;
	private String Player_Name;
	private int Team;
	private Date Dob;
	private String Address;
	private double BatingAvg;
	private int Wicket;
	
	public IplPlayer() {
		// TODO Auto-generated constructor stub
	}

	public int getPlayer_id() {
		return Player_id;
	}

	public void setPlayer_id(int player_id) {
		Player_id = player_id;
	}

	public String getPlayer_Name() {
		return Player_Name;
	}

	public void setPlayer_Name(String player_Name) {
		Player_Name = player_Name;
	}

	public int getTeam() {
		return Team;
	}

	public void setTeam(int team) {
		Team = team;
	}

	public Date getDob() {
		return Dob;
	}

	public void setDob(Date dob) {
		Dob = dob;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public double getBatingAvg() {
		return BatingAvg;
	}

	public void setBatingAvg(double batingAvg) {
		BatingAvg = batingAvg;
	}

	public int getWicket() {
		return Wicket;
	}

	public void setWicket(int wicket) {
		Wicket = wicket;
	}

	@Override
	public String toString() {
		return "IplPlayer [Player_id=" + Player_id + ", Player_Name=" + Player_Name + ", Team=" + Team + ", Dob=" + Dob
				+ ", Address=" + Address + ", BatingAvg=" + BatingAvg + ", Wicket=" + Wicket + "]";
	}

	public IplPlayer(int player_id, String player_Name, int team, Date dob, String address, double batingAvg,
			int wicket) {
		super();
		Player_id = player_id;
		Player_Name = player_Name;
		Team = team;
		Dob = dob;
		Address = address;
		BatingAvg = batingAvg;
		Wicket = wicket;
	}
}
