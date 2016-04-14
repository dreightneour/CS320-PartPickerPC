package CreateBuild;

import partPickerPC.PartInterface;

public class CreateBuildController {
	
	private CreateBuildModel model;

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
	
	
	
	

}
