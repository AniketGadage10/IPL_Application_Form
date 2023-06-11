package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Playerdaoimpl;
import pojo.IplPlayer;


@WebServlet("/GT")
public class GTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GTServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}


	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter pw =response.getWriter()){
			HttpSession hs=request.getSession();
			IplPlayer player=(IplPlayer)hs.getAttribute("Player");
			Playerdaoimpl pdao=(Playerdaoimpl)hs.getAttribute("playerdao");
			if(player.getWicket()>=20 && player.getBatingAvg()>=30)
			{
				if(pdao.InsertPlayer(player))
				{
					pw.print("<h1 align='center'><b> Welcome "+player.getPlayer_Name()+" YOU SELECTED IN  GT </b></h1>");
				}
				else
				{
					pw.print("<h1 align='center'>INSERT ERROR</h1>");
				}
			}else
			{
				pw.print("<h1 align='center'>SORRY NO VACANCY AVAILABLE IN GT</h1>");
			}
		} catch (Exception e) {
			throw new ServletException(" ERROR ",e);
		}
	}

}
