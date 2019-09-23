package com.rd.familytree.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindNoOfCores {

	public static void main(String[] args) {
		
		System.out.println("1");

		
		String userName = "qassp";
		String hostName ="or1010050161036.corp.adobe.com";
		ProcessBuilder pd;
		String result = null;
        try {
            //check system is accessible
            System.out.println("before whoami");
            pd = new ProcessBuilder("ssh", userName + "@" + hostName, "whoami");
            result = executeBuilder(pd);
			System.out.println("resultt 1 : "+result);
            if (!userName.equals(result)) {
                System.out.println("Cannot communicate with the target. Reinstall the agent");
            }

            //check stress ng
            pd = new ProcessBuilder("ssh", userName + "@" + hostName, "rpm", "-q", "stress-ng");
            result = executeBuilder(pd);
            if (null == result || result.contains("not")) {
                System.out.println("Dependencies not installed properly. Run command \"sudo yum install stress-ng -y\" on host machine");
            }

            //IP table available ?
            pd = new ProcessBuilder("ssh", userName + "@" + hostName, "rpm", "-q", "iptables");
            result = executeBuilder(pd);
            if (null == result || result.contains("not")) {
                System.out.println("Dependencies not installed properly. Run command \"sudo yum install iptables -y\" on host machine");
            }
			
			

        } catch (Exception e) {
            System.out.println("Agent is not active"+e);
            
        }
        System.out.println("AVAILABLE");
        
      //find number of cores
        try {
            System.out.println("core");
			String[] findCores = new String[]{"ssh", userName + "@" + hostName,  "cat", "/proc/cpuinfo", "|", "awk", "'/^processor/{print $3}'", "|", "wc", "-l"};
            pd = new ProcessBuilder(findCores);
            result = executeBuilder(pd);
            System.out.println(result);
            if (null == result || result.contains("not")) {
                System.out.println("Dependencies not installed properly. Run command \"sudo yum install iptables -y\" on host machine");
            }
        }catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to fetch cores");
		}
		
       
        
	}
	
	private static String executeBuilder(ProcessBuilder pd) throws IOException, InterruptedException {
        Process process;
        BufferedReader reader;
        StringBuilder builder;
        String line;
        process = pd.start();
        process.waitFor();
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        builder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

}
