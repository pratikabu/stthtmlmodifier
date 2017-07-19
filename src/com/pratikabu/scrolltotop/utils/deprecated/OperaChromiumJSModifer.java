package com.pratikabu.scrolltotop.utils.deprecated;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OperaChromiumJSModifer {

	public static void processJS(String srcFilePath, String destFilePath) throws IOException {
		System.out.println("Updating the addon review link in " + srcFilePath);
		
		File destFile = new File(destFilePath);
		destFile.createNewFile();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFilePath)));
		PrintWriter pw = new PrintWriter(destFile);
		String line;
		while (null != (line = br.readLine())) {
			if(line.trim().contains("chrome.google.com")) {
				// update the addon link
				pw.println("\treturn \"http://addons.opera.com/en/extensions/details/scroll-to-top\";");
				continue;
			}
			pw.println(line);
		}
		
		br.close();
		pw.close();
	}

}
