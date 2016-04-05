package model;

import java.util.LinkedList;
import java.util.List;

public class FacadeLucene implements Facade {

	@Override
	public List<String> ricerca(String query) {
		List<String> a =new LinkedList<String>();
		a.add("1.jpg");
		
		return a;
	}

}
