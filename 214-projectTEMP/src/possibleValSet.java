
public class possibleValSet {

	/*
	 * this class will create an object(array which will contain possible
	 * values) for every position in your board array
	 * 
	 * N.B the array should be empty and will be populated in the gameBoard class 
	 */
	
	
	public int[] valueSet;

	possibleValSet() {

		setValueSet(new int[9]);

	}

	public int[] getValueSet() {
		return valueSet;
	}

	public void setValueSet(int[] valueSet) {
		this.valueSet = valueSet;
	}

}
