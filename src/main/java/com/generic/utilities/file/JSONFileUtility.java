package com.generic.utilities.file;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONFileUtility {

	public JsonElement readDataFromJSONFile(String Key) throws FileNotFoundException {
		FileReader file = new FileReader(IConstantUtilities.JSONFILEPATH);
		JsonParser parser = new JsonParser();
		JsonObject json = (JsonObject) parser.parse(file);
		JsonElement value = json.get(Key);
		return value;
	}

}
