package com.rd.familytree.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PBTester {

	public static void main(String[] args) {

		ProcessBuilder pd = new ProcessBuilder("ssh", "-q", "-o", "\"StrictHostKeyChecking no\"", "qassp@10.50.152.223", "whoami");
		Process process = null;
		 String result = null;
        try {
        	process = pd.start();
			process.waitFor();
			 BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		        StringBuilder builder = new StringBuilder();
		        String line = null;
		        while ((line = reader.readLine()) != null) {
		            builder.append(line);
		        }
		        result = builder.toString();
		} catch (InterruptedException | IOException e) {
			System.out.println("failed");
			e.printStackTrace();
			
		}
       
        System.out.println("result : "+result);
	}

}
