
public abstract class AchievementStorageFactory {
	
	private static AchievementStorage achievementStorage;
	
	public static AchievementStorage getAchievementStorage() {
		//if(achievementStorage == null) {
			setAchievementStorage(new MemoryAchievementStorage());
		//}		
		return achievementStorage;
	}
	
	static void setAchievementStorage(AchievementStorage _achievementStorage)
	{
		achievementStorage = _achievementStorage;
	}
	
}
