package strategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

/**
 * 
 * @author jamelperaltacoss
 *
 */
public class OrderedFD<E extends Comparable<E>> extends FrequencyCounter<E> {
	
	public OrderedFD() {
		super("Ordered");
    }

    @Override
    public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
    	ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
	
    	sortData(dataSet);
    	Map.Entry<E, Integer> firstEntry = new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(0), 1);
    	results.add(firstEntry);
    	
    	for(int i = 1; i < dataSet.size(); i++){
    		Map.Entry<E, Integer> entry = results.get(results.size() - 1);
    		if(entry.getKey().equals(dataSet.get(i))){
    			entry.setValue(entry.getValue() + 1);
    		}
    		else{
    			Map.Entry<E, Integer> newEntry = new AbstractMap.SimpleEntry<E, Integer>(dataSet.get(i), 1);
    	    	results.add(newEntry);
    		}
    	}
    	
    	return results;
	}
    
    private void sortData(ArrayList<E> dataSet){
    	//Using Insertion Sort
    	for(int i = 1; i < dataSet.size(); i++){
			E cur = dataSet.get(i);
			int j = i;
			while(j > 0 && dataSet.get(j-1).compareTo(cur) > 0){
				dataSet.set(j, dataSet.get(j-1));
				j--;
			}
			dataSet.set(j, cur);
		}
    }
    
}
