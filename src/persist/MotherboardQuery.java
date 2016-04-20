package persist;

import java.util.List;
import partPickerPC.PartInterface;

public class MotherboardQuery {
	public static List<PartInterface> main() throws Exception {
		
		//TODO getters for user input go here (or in the findCertainParts, whichever works better)
		final String criteriaTable = "criteriaTable";
		final String criteria = "criteria";
		
		//get the current state of the database
		IDatabase db = DatabaseProvider.getInstance();
		
		//get the motherboard parts from the database depending on criteria
		List<PartInterface> motherboardParts = db.findCertainParts("motherboards", criteriaTable, criteria);
		
		return motherboardParts;
	}
}
