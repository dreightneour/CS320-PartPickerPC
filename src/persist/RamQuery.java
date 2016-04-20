package persist;

import java.util.List;
import partPickerPC.PartInterface;

public class RamQuery {
	public static List<PartInterface> main() throws Exception {
		
		//TODO getters for user input go here (or in the findCertainParts, whichever works better)
		final String criteriaTable = "criteriaTable";
		final String criteria = "criteria";
		
		//get the current state of the database
		IDatabase db = DatabaseProvider.getInstance();
		
		//get the RAM parts from the database depending on criteria
		List<PartInterface> ramParts = db.findCertainParts("rams", criteriaTable, criteria);
		
		return ramParts;
	}
}
