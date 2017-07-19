package com.pratikabu.scrolltotop.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ContentReplacer {
	
	private static final String ENCODING = "UTF8";

	public static void process(String srcFilePath, String destFilePath, String oldString, String newString) throws IOException {
		System.out.println("Replacing \"" + oldString + "\" with \"" + newString + "\" in file: " + srcFilePath);
		
		File destFile = new File(destFilePath);
		destFile.createNewFile();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFilePath), ENCODING));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(destFile), ENCODING));
		String line;
		while (null != (line = br.readLine())) {
			if(line.trim().contains(oldString)) {
				line = line.replace(oldString, newString);
			}
			pw.println(line);
		}
		
		br.close();
		pw.close();
	}

}
