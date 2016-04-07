package action;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.lucene.search.ScoreDoc;

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
			Map<ScoreDoc, List<File>> risultati = sistema.ricerca(query);	
			sessione.setAttribute("risultati", risultati.values().iterator().next());
			sessione.setAttribute("score", risultati.keySet().iterator().next());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "risultati";
	}

}
