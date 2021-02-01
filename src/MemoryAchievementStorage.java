import java.util.*;

public class MemoryAchievementStorage implements AchievementStorage {
	
	public Map<String, List<Achievement>> usersStorageData = new HashMap<String, List<Achievement>>();

	@Override
	public void addAchievement(String user, Achievement a) {
			if (usersStorageData.containsKey(user)) {
				String achievementClass = a.getClass().toString().substring(6);
				if(getAchievementStorage(user, a.name, achievementClass) == null)
					usersStorageData.get(user).add(a); 
				else {
					usersStorageData.get(user).set(usersStorageData.get(user).indexOf(a), a);
				}
			}
			else {
				usersStorageData.put(user, new ArrayList<Achievement>());
				usersStorageData.get(user).add(a);
			}
	}

	@Override
	public List<Achievement> getAchievements(String user) {
		return usersStorageData.get(user);
	}

	@Override
	public Achievement getAchievementStorage(String user, String achievementName, String achievmentClass) {
	 if (usersStorageData.containsKey(user))
		 for(Achievement aux: this.getAchievements(user))
			 if(aux.name.equals(achievementName)) 
				 if((aux.getClass()).toString().equals("class "+achievmentClass))
				 	return aux;
     return null; 
	}
}
