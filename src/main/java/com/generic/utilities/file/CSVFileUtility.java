package com.generic.utilities.file;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CSVFileUtility {

	public void readDataFromCSVFile() throws IOException, CsvException {

		FileReader file = new FileReader(IConstantUtilities.CSVFILEPATH);
		CSVReader read = new CSVReader(file);

		List<String[]> readAll = read.readAll();
		for (String[] data : readAll) {
			for (String s : data) {
				System.out.println(s);
			}
		}
	}
}
