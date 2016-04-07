package init;

import java.io.IOException;

import lucene.Indexer;
import lucene.IndexerSpell;
import lucene.PatterAssolut;
import lucene.TextFileFilter;

public class InitIndex {

	static String dizionario = PatterAssolut.getDizionario();
	static String indexDir = PatterAssolut.getIndexDir();
	static String indexDizionario = PatterAssolut.getIndexDizionario();
	static String dataDir = PatterAssolut.getDataDirPrimo();

	public static void main(String[] args) throws IOException {

		try{
			IndexerSpell indexerSpell = new IndexerSpell(indexDizionario);
			indexerSpell.createIndex(dizionario, new TextFileFilter());
			indexerSpell.close();


			Indexer indexer = new Indexer(indexDir);
			int numIndexed;
			long startTime = System.currentTimeMillis();	
			numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
			long endTime = System.currentTimeMillis();
			indexer.close();
			System.out.println(numIndexed+" File indexed, time taken: "
					+(endTime-startTime)+" ms");	
		}catch(IOException e)	{
			e.printStackTrace();
		}

	}

}
