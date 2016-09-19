package testerClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOpener {
	public static void openIntegerFile(ArrayList<Integer> list){
		try {
			File file = new File("src/inputData/integerData");
	        Scanner scanner = new Scanner(file);
	        while (scanner.hasNextLine()) {
	        	String line = scanner.nextLine();
	        	list.add(Integer.parseInt(line));
	        }
	        scanner.close();
	     } catch (FileNotFoundException e) {
	           e.printStackTrace();
	     }
	}
	
	public static void openStringFile(ArrayList<String> list){
		try {
			File file = new File("src/inputData/stringData");
	        Scanner scanner = new Scanner(file);
	        while (scanner.hasNextLine()) {
	        	String line = scanner.nextLine();
	        	list.add(line);
	        }
	        scanner.close();
	     } catch (FileNotFoundException e) {
	           e.printStackTrace();
	     }
	}
}
