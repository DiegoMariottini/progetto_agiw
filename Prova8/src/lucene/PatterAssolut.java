package lucene;

public class PatterAssolut {
	static String indexDir= "/home/diegomariottini/git/progetto_agiw_due/Prova8/Index/";
	static String dataDir="/home/diegomariottini/Scrivania/Dati/";
	static String dataDirPrimo=PatterAssolut.getDataDir() + "Alessandro_Cialfi/";
	static String dirDizionario="/home/diegomariottini/git/progetto_agiw_due/Prova8/dizionario/";
	static String dizionario = "/home/diegomariottini/git/progetto_agiw_due/Prova8/dizionario/Dizionario - nomi/";
	static String indexDizionario = "/home/diegomariottini/git/progetto_agiw_due/Prova8/dizionario/IndexDizionario/";

	
	
	public PatterAssolut() {
	}
public static String getDizionario() {
	return dizionario;
}
public static String getIndexDizionario() {
	return indexDizionario;
}
	public static String getDataDir() {
		return dataDir;
	}
	public static String getIndexDir() {
		return indexDir;
	}
	public static String getDataDirPrimo() {
		return dataDirPrimo;
	}
	public static String getDirDizionario() {
		return dirDizionario;
	}
	
}
