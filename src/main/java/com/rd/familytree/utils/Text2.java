package com.rd.familytree.utils;



import java.io.BufferedInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Text2 {
	public static void main(String... arguments) throws IOException, InterruptedException {
		Process pb = new ProcessBuilder().command("/bin/sh", "-c", "(stty raw; cat | buffer -s 82 -b 2) < /dev/ttyAMA0").start();
		final Scanner scanner = new Scanner(new InputStreamReader(new BufferedInputStream(pb.getInputStream())));

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (scanner.hasNextLine()) {
					System.out.println(scanner.nextLine());
				}
			}
		});

		t.start();
		pb.waitFor();
	}
}

