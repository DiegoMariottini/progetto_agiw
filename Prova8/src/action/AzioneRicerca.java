package action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Facade;
import model.FacadeLucene;

public class AzioneRicerca extends Azione {

	@Override
	public String esegui(HttpServletRequest request) throws ServletException {
		HttpSession sessione = request.getSession();
		String query=request.getParameter("query");
		Facade sistema =new FacadeLucene();
		sessione.setAttribute("querySessione", query);
		try {
			sessione.setAttribute("risultati", sistema.ricerca(query));
			System.out.println("entrato");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "risultati";
	}

}
