package strategiesClasses;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author jamelperaltacoss
 *
 */
public class MapFD<E extends Comparable<E>> extends FrequencyCounter<E> {
	
	public MapFD() {
		super("Map");
    }

    @Override
    public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
	
    	Hashtable<E, Integer> table = new Hashtable<>();
    	for(int i = 0; i < dataSet.size(); i++){
    		E num = dataSet.get(i);
    		Integer key = table.get(num);
    		if(key == null)
    			table.put(num, 1);
    		else
    			table.put(num, key + 1);
    	}
    	
    	Set<Map.Entry<E, Integer>> entrySets = table.entrySet();
    	ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>(entrySets);
    	
    	return results;
	}
    
}
