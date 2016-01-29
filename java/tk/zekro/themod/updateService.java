package tk.zekro.themod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class updateService {

	public static final String UPDATEURL = "https://www.dropbox.com/s/m4qjlypnklp3lse/themod_version.txt?dl=1";
	public static boolean newVersionAvailable = false;
	
	public static void checkForUpdate() {
		new Thread("checkForUpdate") {
			public void run() {
			
				try {
					URL url = new URL(UPDATEURL);
					Scanner scanner = new Scanner(url.openStream());
					String latestVersion = scanner.nextLine();
					scanner.close();
					
					if (!themod.VERSION.equals(latestVersion)) {
						newVersionAvailable = true;
//						setNewVersionAvailable();
					}
					
				} catch (MalformedURLException e) {
					System.err.println("Wrong Version Source URL");
					e.printStackTrace();
				} catch (IOException e) {
					System.err.println("Network connection fail.");
					e.printStackTrace();
				};
				
			}	
		}.start();
	};	

/*
	private static synchronized void setNewVersionAvailable() {
		newVersionAvailable = true;
	}
	public static synchronized boolean isNewVersionAvailable() {
		return newVersionAvailable;
	}
*/
	
}
	
