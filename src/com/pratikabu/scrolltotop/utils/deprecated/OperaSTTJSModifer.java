package com.pratikabu.scrolltotop.utils.deprecated;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OperaSTTJSModifer {

	public static void processJS(String srcFilePath) throws IOException {
		File destFile = File.createTempFile("opera-stt", null);
		destFile.createNewFile();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFilePath)));
		PrintWriter pw = new PrintWriter(destFile);
		String line;
		String REPLACE_STRING = "TODO REPLACE ";
		while (null != (line = br.readLine())) {
			if(line.trim().contains(REPLACE_STRING)) {
				int startIndex = line.indexOf(REPLACE_STRING) + REPLACE_STRING.length();
				String fileName = line.substring(startIndex);
				loadFileContentInstead(pw, new File(fileName));
				continue;
			}
			pw.println(line);
		}
		
		br.close();
		pw.close();
		
		replaceFileContentAndRemove(new File(srcFilePath), destFile);
	}

	private static void replaceFileContentAndRemove(File destFile, File srcFile) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile)));
		PrintWriter pw = new PrintWriter(destFile);
		String line;
		while (null != (line = br.readLine())) {
			pw.println(line);
		}
		
		br.close();
		pw.close();
		
		srcFile.delete();
	}

	private static void loadFileContentInstead(PrintWriter pw, File file) throws IOException {
		System.out.println("Expanding " + file.getAbsolutePath());
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line;
		while (null != (line = br.readLine())) {
			line = line.replace("jQuery", "pratikabusttjquery");
			line = line.replace("$", "pratikabusttjquery");
			pw.println(line);
		}
		br.close();
	}

}
