package CreateBuild;

import java.util.List;

import partPickerPC.PartInterface;
import persist.DatabaseProvider;
import persist.DerbyDatabase;
import persist.IDatabase;

public class CreateBuildController {
	
	private CreateBuildModel model;
	private IDatabase db;
	
	public CreateBuildController()
	{
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}

	public CreateBuildModel getModel() {
		return model;

	}



	public void setModel(CreateBuildModel model) {
		this.model = model;
	}
	
	public String addPartToParts(PartInterface part)
	{
		model.getTheBuild().addPart(part);
		if (model.getTheBuild().didPartGetAdded(part))
		{
			return "Part successfully added!";
		}
		else
		{
			return model.getTheBuild().getError();
		}
	}
	
	public String removePart(String part)
	{
		model.getTheBuild().removePart(part);
		return "Part Successfully removed";
	}
	
	public List<PartInterface> getPartInPriceRange(int low, int high, String part)
	{
		return db.findPriceRange(part, ""+low, ""+high); // gets low / high or selected part
	}
	
	
	
	
	
	
	

}
