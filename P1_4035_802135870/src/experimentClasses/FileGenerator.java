package experimentClasses;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author jamelperaltacoss
 *
 */
public class FileGenerator {
	//instance variables
	private String experimentalName;
	private ArrayList<Integer> allN;
	private ArrayList<Long> averageTime;
	
	//File var
	public FileOutputStream out = null;
	private String Dir_file;
	
	//Constructor
	public FileGenerator(String name){
		experimentalName = name;
		allN = new ArrayList<>();
		averageTime = new ArrayList<>();
		Dir_file = "src/experimentalResults/" + name + ".txt";
	}
	
	//Methods
	public void addTime(Integer n, long average){
		allN.add(n);
		averageTime.add(average);
	}
	
	public void terminalOutput(){
		System.out.println(experimentalName + ": ");
		for(int i = 0; i < allN.size(); i++){
			System.out.println("n = " + allN.get(i) + "  \tAverage time: " + averageTime.get(i));
		}
	}
	
	public void saveFile(){
		String data = "";
		data = experimentalName + ": \n";
		for(int i = 0; i < allN.size(); i++){
			data += "n = " + allN.get(i) + "  \tAverage time: " + averageTime.get(i) + "\n";
		}
		System.out.println(data);
		createFile(data);
	}
	
	private void createFile(String data){
		try {
			out = new FileOutputStream(Dir_file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
			 String sout = data;
			 char[] stringToCharArray = sout.toCharArray();
			 
			 
			 try {
				 for (char output : stringToCharArray) {
					 out.write((int) output);
				 }
			 } catch (IOException e1) {
				 // TODO Auto-generated catch block
				 e1.printStackTrace();
			 } finally {

				 if (out != null) {
					 try {
						 out.close();
					 } catch (IOException e1) {
						 // TODO Auto-generated catch block
						 e1.printStackTrace();
					 }
				 }
			 }
	}
	
}
