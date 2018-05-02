import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class hashSet {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Integer> valuesSet = new HashSet<Integer>();
		Integer row[] = { 0,3,7,5,6,9,8,1,2,};
		Integer vals[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		valuesSet.add(1);valuesSet.add(2);valuesSet.add(3);
		valuesSet.add(4);valuesSet.add(5);valuesSet.add(6);
		valuesSet.add(7);valuesSet.add(8);valuesSet.add(9);

		for (int i = 0; i < row.length; i++) {
			if (valuesSet.contains(row[i])) {
				valuesSet.remove(row[i]);
			}
		}

		System.out.println(valuesSet);

		

	}

}
