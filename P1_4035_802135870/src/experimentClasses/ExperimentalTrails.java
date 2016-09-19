package experimentClasses;

import java.util.ArrayList;
import java.util.Random;

import strategiesClasses.FrequencyCounter;
import strategiesClasses.MapFD;
import strategiesClasses.OrderedFD;
import strategiesClasses.SequentialFD;

/**
 * 
 * @author jamelperaltacoss
 *
 */
public class ExperimentalTrails {
	
	//Main Method
	public static void main(String[] args){
		experiment(new SequentialFD(), "resultsSequential");
		experiment(new MapFD(), "resultsMap");
		experiment(new OrderedFD(), "resultsOrdered");
	}
	
	//Method for counting the frequencies
	public static void experiment(FrequencyCounter<Integer> counter, String experimentalName){
		FileGenerator fileGen = new FileGenerator(experimentalName);
		for(int n = 50; n <= 1000; n += 50){
			long totalTime = 0;
			for(int i = 0; i < 200; i++){
				ArrayList<Integer> randList = new ArrayList<>();
				Random randNum = new Random();
				int high = n/2;
				int low = 1;
				for(int j = 0; j < n; j++)
					randList.add(randNum.nextInt(high - low) + low);
				long startTime = System.nanoTime();
				counter.computeFDList(randList);
				long estimatedTime = System.nanoTime() - startTime;
				totalTime += estimatedTime;
			}
			long averageTime = totalTime / 200;
			fileGen.addTime(n, averageTime);
		}
		fileGen.saveFile();
	}
	
}

