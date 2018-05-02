import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ValueSet {
	
	// creating values set as object so it will always remain updated
	//This is how you will eliminate values to find the correct one. 

	private  Set<Integer> valuesSet = new HashSet<Integer>();
	

	ValueSet() {
		//constructor
		//adding values to your set so they remain constant

		valuesSet.add(1);
		valuesSet.add(2);
		valuesSet.add(3);
		valuesSet.add(4);
		valuesSet.add(5);
		valuesSet.add(6);
		valuesSet.add(7);
		valuesSet.add(8);
		valuesSet.add(9);

	}
	
	public Set<Integer> valueSet(){
		
		return valuesSet; 
		
	}
	
	public boolean contains(int i ){
		//checking whether you value set contains a particular number 
		if (valuesSet.contains(i)){
			return true;
		}
		
		
		return false; 
	}
	
	public void  removeElement(int a ){
		//if you find a common value in a group as in your set use this method to remove that value.
		
		
		if(valuesSet.contains(a) ){
			valuesSet.remove(a);
			
			//checking if method is working
			System.out.println("Element removed from set");
		}
		
	}

}
