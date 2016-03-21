package partPickerPC;

public class QuickBuildController {

	private QuickBuildModel model;
	
	
	public void setModel(QuickBuildModel model)
	{
		this.model = model;
	}
	
	public Build giveCheapest()
	{
		Build cheap = model.getCompatibleBuilds().get(0);
		Build current;
		for (int i = 1; i < model.getCompatibleBuilds().size(); i++)
		{
			if (model.getCompatibleBuilds().get(i).getTheParts().size() == 4)
			{
			current = model.getCompatibleBuilds().get(i);
			if (current.getPrice() < cheap.getPrice())
			{
				cheap = current;
			}
			}
		}
		return cheap;
	}
	
	public Build giveExpensive()
	{
		Build expensive = model.getCompatibleBuilds().get(0);
		Build current = new Build();
		for (int i = 1; i < model.getCompatibleBuilds().size(); i++)
		{
			current = model.getCompatibleBuilds().get(i);
			if (current.getPrice() > expensive.getPrice())
			{
				expensive = current;
			}
		}
		return expensive;
	}
	
	public Build giveCompatibleBuild(int counter)
	{
		if (counter < model.getCompatibleBuilds().size())
		{
			return model.getCompatibleBuilds().get(counter);
		}
		return null;
	}
}
