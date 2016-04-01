package QuickBuild;

import partPickerPC.Build;

public class QuickBuildController {

	private QuickBuildModel model;
	
	
	public void setModel(QuickBuildModel model)
	{
		this.model = model;
	}
	
	public Build giveCheapest()			// gives the cheapest build from compatible builds
	{
		Build cheap = model.getCompatibleBuilds().get(0);
		Build current;
		for (int i = 1; i < model.getCompatibleBuilds().size(); i++)
		{

			current = model.getCompatibleBuilds().get(i);
			if (current.getPrice() < cheap.getPrice())
			{
				cheap = current;
			}
		}
		return cheap;
	}
	
	public Build giveExpensive()  // gives expensive
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
	
	public Build giveCompatibleBuild(int counter)  // gives any build that works
	{
		if (counter < model.getCompatibleBuilds().size())
		{
			return model.getCompatibleBuilds().get(counter);
		}
		return null;
	}
}
