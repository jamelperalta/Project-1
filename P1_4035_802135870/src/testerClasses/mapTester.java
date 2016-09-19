package testerClasses;

import java.util.ArrayList;
import java.util.Map;
import strategiesClasses.MapFD;

/**
 * 
 * @author jamelperaltacoss
 *
 */
public class mapTester {

	public static void main(String[] args){
		//Array for list
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		
		//Putting the info into the arrays
		FileOpener.openIntegerFile(list);
		FileOpener.openStringFile(list2);
		
		//TEST for Integer
		MapFD<Integer> ord = new MapFD<>();
		ArrayList<Map.Entry<Integer, Integer>> entryList = ord.computeFDList(list);
		System.out.println(" Integer Test: (using integerData)");
		for(int i = 0; i < entryList.size(); i++){
			Map.Entry<Integer, Integer> entry = entryList.get(i);
			System.out.println("Key: " + entry.getKey() + "\t\tFrequency: " + entry.getValue());
		}
		
		//TEST for String
		MapFD<String> ord2 = new MapFD<>();
		ArrayList<Map.Entry<String, Integer>> entryList2 = ord2.computeFDList(list2);
		System.out.println(" String Test: (using stringData)");
		for(int i = 0; i < entryList2.size(); i++){
			Map.Entry<String, Integer> entry = entryList2.get(i);
			System.out.println("Key: " + entry.getKey() + "\t\tFrequency: " + entry.getValue());
		}
	}
	
}
