
public abstract class AchievementStorageFactory {
	
	private static AchievementStorage achievementStorageInstance = null;
	
	public static AchievementStorage getAchievementStorage() {
		return achievementStorageInstance;
	}
	
	public static void setAchievementStorage(AchievementStorage _achievementStorage)
	{
		achievementStorageInstance = _achievementStorage;
	}
	
}
