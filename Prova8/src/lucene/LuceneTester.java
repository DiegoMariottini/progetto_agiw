package lucene;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneTester {
	
   static String indexDir = "/home/diegomariottini/git/progetto_agiw/Prova8/Index/";
   String dataDir = "Data/Dati/Alessandro_Cialfi";
   Indexer indexer;
   static Searcher searcher;

     
   //funzione per generare l'indice
   /* private void createIndex() throws IOException{
      indexer = new Indexer(indexDir);
      int numIndexed;
      long startTime = System.currentTimeMillis();	
      numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
      long endTime = System.currentTimeMillis();
      indexer.close();
      System.out.println(numIndexed+" File indexed, time taken: "
         +(endTime-startTime)+" ms");		
   }
*/
   public List<File> search(String searchQuery) throws IOException, ParseException{
	   
	   List<File> lista = new LinkedList<File>();
		searcher = new Searcher(indexDir);
		TopDocs hits = searcher.search(searchQuery);
		
		for(ScoreDoc scoreDoc : hits.scoreDocs) {
			Document doc = searcher.getDocument(scoreDoc);
			File f = new File(doc.get(LuceneConstants.FILE_PATH));
			lista.add(f);
		}
		return lista;
	}
}