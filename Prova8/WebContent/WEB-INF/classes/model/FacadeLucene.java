package model;

import lucene.LuceneTester;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import lucene.LuceneTester;

public class FacadeLucene implements Facade {

	@Override
	public List<File> ricerca(String query) throws Exception {
		List<File> a =LuceneTester.searchFile(query);
		return a;
	}

}