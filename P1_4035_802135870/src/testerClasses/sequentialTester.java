package testerClasses;

import java.util.ArrayList;
import java.util.Map;

import strategiesClasses.SequentialFD;

/**
 * 
 * @author jamelperaltacoss
 *
 */
public class sequentialTester {
	
	public static void main(String[] args){
		//Array for list
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		
		//Putting the info into the arrays
		FileOpener.openIntegerFile(list);
		FileOpener.openStringFile(list2);
		
		//TEST for Integer
		SequentialFD<Integer> ord = new SequentialFD<>();
		ArrayList<Map.Entry<Integer, Integer>> entryList = ord.computeFDList(list);
		System.out.println(" Integer Test: (using integerData)");
		for(int i = 0; i < entryList.size(); i++){
			Map.Entry<Integer, Integer> entry = entryList.get(i);
			System.out.println("Key: " + entry.getKey() + "\t\tFrequency: " + entry.getValue());
		}
		
		//TEST for String
		SequentialFD<String> ord2 = new SequentialFD<>();
		ArrayList<Map.Entry<String, Integer>> entryList2 = ord2.computeFDList(list2);
		System.out.println(" String Test: (using stringData)");
		for(int i = 0; i < entryList2.size(); i++){
			Map.Entry<String, Integer> entry = entryList2.get(i);
			System.out.println("Key: " + entry.getKey() + "\t\tFrequency: " + entry.getValue());
		}
	}
}
