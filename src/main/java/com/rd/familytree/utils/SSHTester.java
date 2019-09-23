package com.rd.familytree.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.security.Security;
import java.util.concurrent.TimeUnit;

import org.apache.tomcat.jni.File;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;
import net.schmizz.sshj.connection.channel.forwarded.RemotePortForwarder.Forward;
import net.schmizz.sshj.connection.channel.forwarded.SocketForwardingConnectListener;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

public class SSHTester {

	public static void main(String... args){

		SSHClient client = null;
		try {
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

			client = new SSHClient();
			//client.authPublickey("qassp");
			client.loadKnownHosts();
			client.connect("10.50.152.223");
			final Session session = client.startSession();
			final Command cmd = session.exec("whoami");
			String response = IOUtils.readFully(cmd.getInputStream()).toString();
			cmd.join(10, TimeUnit.SECONDS);

			System.out.println(response);  //ubuntu

			session.close();
			client.disconnect();

		} catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				client.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
