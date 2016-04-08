package infoSistema;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import lucene.LuceneConstants;
import lucene.LuceneTester;
import lucene.PatterAssolut;
import lucene.Searcher;
import java.util.ArrayList;

public class ValutazioneSistema {
	
	static String fileValutazione=PatterAssolut.getDirValutazione()+"valutazione.txt";
	static String fileNomiCaretelle=PatterAssolut.getDoveSiTrovaIlFileNomiCartelle();
	
	
public static void main(String[] args) {
		String dataDir=PatterAssolut.getDataDir();
		
		try {
			PrintWriter writerValutazione = new PrintWriter(fileValutazione, "UTF-8");
			writerValutazione.println("nome e cognome \t  positivi totali  \t  file totali restituiti \t Doc.restituiti  \t  precision  \t  recall ");
			
			//writerValutazione.println("");
			List<String> nomi=new ArrayList<String>(creaListaCartelle());
				for(String nome:nomi){
					String nomeCartella=nome.replaceAll(" ","_");
					nomeCartella = nomeCartella.replace("\"", "");
					char asc27=27;
					nomeCartella = nomeCartella.replace(""+asc27, "");
					nomeCartella=nomeCartella.substring(0,(nomeCartella.length()));
					File f = new File (dataDir+nomeCartella);
					if(f.exists()){
						double relevantElement=f.listFiles().length;
						double selectedElements=searchForValuation(nome);
						double truePositiv= positiviRestituiti(nome, nomeCartella);
							
						double precision= truePositiv/selectedElements;
						double recall=truePositiv/relevantElement;
						
						
						String frase=nome+"\t"+relevantElement+"\t"+selectedElements+"\t"+truePositiv+"\t"+precision+"\t"+recall;
						writerValutazione.println(frase);
						System.out.println(frase);
						
					
					}
				}
		
		writerValutazione.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

	
	
	public static int positiviRestituiti(String nome,String nomeCartella){
		int positivi=0;
		try {
			List<File> filePositiviLucene= fileTotali(nome);
			for(File file :filePositiviLucene){
				if(isPositive(file,nomeCartella)){
					positivi=positivi+1;
				}
			}
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return positivi;
		
	}
	
	public static boolean isPositive(File file,String nomeCartella){
		String path="/home/diegomariottini/Scrivania/Dati/";
		String stringaDaConsiderare=file.getPath().substring(path.length());
		return stringaDaConsiderare.contains(nomeCartella);
	}
	
	


		
	
	public static List<File> fileTotali(String nome) throws ParseException, IOException{
		LuceneTester tester=new LuceneTester();
		Map<ScoreDoc, List<File>> mappaScoreToListaFile = tester.search(nome);
		LinkedList<File> files = (LinkedList<File>) mappaScoreToListaFile.values().iterator().next();
		ScoreDoc score=(ScoreDoc) mappaScoreToListaFile.keySet().iterator().next();
		
		LinkedList<File> nuoviDaAggiungere = (LinkedList<File>)tester.searchAfter(score, nome).values().iterator().next();
		
		while(!(nuoviDaAggiungere.isEmpty())){
			files.addAll(nuoviDaAggiungere);
			mappaScoreToListaFile=tester.searchAfter(score, nome);

			score=(ScoreDoc) mappaScoreToListaFile.keySet().iterator().next();
			nuoviDaAggiungere =(LinkedList<File>)mappaScoreToListaFile.values().iterator().next();
				
		}
		
		return files;
		
	}
	 
	
	private static int searchForValuation(String searchQuery) throws IOException, ParseException{
	      Searcher searcher = new Searcher(PatterAssolut.getIndexDir());
	      TopDocs hits = searcher.search(searchQuery);
	      return hits.totalHits;
	}

	 public static List<String> creaListaCartelle(){

		LinkedList<String> listaNomi = new LinkedList<String>();
		
		//String fileNomiCaretelle=PatterAssolut.getDoveSiTrovaIlFileNomiCartelle();
		
		Scanner readerNomiCartelle;
		try {
			readerNomiCartelle = new Scanner(new FileReader(fileNomiCaretelle));
			while(readerNomiCartelle.hasNext())	{
				String persona= readerNomiCartelle.nextLine();
				listaNomi.add(persona);
			}
			readerNomiCartelle.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return listaNomi;
	}
	
	
}
