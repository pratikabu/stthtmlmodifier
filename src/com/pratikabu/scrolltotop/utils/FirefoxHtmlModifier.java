package com.pratikabu.scrolltotop.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FirefoxHtmlModifier {
	
	public static void processHtml(String srcFilePath, String destFilePath) throws IOException {
		System.out.println("Removing script tags from " + srcFilePath);
		
		File destFile = new File(destFilePath);
		destFile.createNewFile();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFilePath)));
		PrintWriter pw = new PrintWriter(destFile);
		String line;
		while (null != (line = br.readLine())) {
			if(line.trim().startsWith("<script ")) {
				continue;// skip writing the line
			}
			pw.println(line);
		}
		
		br.close();
		pw.close();
	}
}
