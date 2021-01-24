public class Badge extends Achievement{
	
/*	private static Badge badgeInstance = null;
	
	public String objective;
	
	public static Badge getBadgeInstance(String name, String objective)
	{
		if (badgeInstance == null) {
			badgeInstance = new Badge(name, objective);
		}
		return badgeInstance;				
	}
	
	private Badge(String name, String objective) {
		super(name);
		this.objective = objective;		
	}
	*/
	
	
	public String objective;
	
	public Badge(String name, String objective) {
		super(name);
		this.objective = objective;		
	}
}
