package lucene;

public class PatterAssolut {

	//lanciare le pagine in localhost:3000
	static String home="/home/diegomariottini/"; 
	static String indexDir= home+"git/progetto_agiw_due/Prova8/Index/";
	static String doveSiTrovaIlFileNomiCartelle="";
	static String dataDir=home+"Scrivania/Dati/";
	//static String dataDirPrimo=PatterAssolut.getDataDir() + "Alessandro_Cialfi/";
	static String dirDizionario=home+"git/progetto_agiw_due/Prova8/dizionario/";
	static String dizionario =home+"git/progetto_agiw_due/Prova8/dizionario/Dizionario - nomi/";
	static String indexDizionario = home+"git/progetto_agiw_due/Prova8/dizionario/IndexDizionario/";

	
	
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
/*	public static String getDataDirPrimo() {
		return dataDirPrimo;
	}
	*/
	public static String getDoveSiTrovaIlFileNomiCartelle() {
		return doveSiTrovaIlFileNomiCartelle;
	}
	public static String getDirDizionario() {
		return dirDizionario;
	}
	
}
