package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Playerdao;
import Dao.Playerdaoimpl;
import pojo.IplPlayer;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Playerdaoimpl Pdao;
	private IplPlayer Player;

	public void init(ServletConfig config) throws ServletException {
		try {
			Pdao = new Playerdaoimpl();

		} catch (Exception e) {
			throw new ServletException("Connection error ", e);
		}
	}

	public void destroy() {
		try {
			Pdao.closeconnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		int team = Integer.parseInt(request.getParameter("team"));
		System.out.println(team);
		String name = request.getParameter("name");
		Date dob = Date.valueOf(request.getParameter("dob"));
		String Add = request.getParameter("add");
		double Batavg = Double.parseDouble(request.getParameter("avg"));
		int wicket = Integer.parseInt(request.getParameter("wicket"));
		Player = new IplPlayer(0, name, team, dob, Add, Batavg, wicket);
		HttpSession hs = request.getSession();
		hs.setAttribute("Player", Player);
		hs.setAttribute("playerdao", Pdao);
		if (Player.getTeam()==1) {
			response.sendRedirect("MI");
		} else {
			if (Player.getTeam()==2) {
				response.sendRedirect("CSK");
			}
			else
			{
				response.sendRedirect("GT");
			}
		}
}

}
