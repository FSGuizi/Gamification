import java.util.List;

public interface AchievementStorage {
	
	void addAchievement(String user, Achievement a);
	
	List<Achievement> getAchievements(String user);
	
	Achievement getAchievementStorage(String user, String achievementName);
	
}
