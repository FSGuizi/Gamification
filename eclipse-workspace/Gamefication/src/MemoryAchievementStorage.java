import java.util.*;

public class MemoryAchievementStorage implements AchievementStorage {
	
	public Map<String, List<Achievement>> usersStorageData = new HashMap<String, List<Achievement>>();

	@Override
	public void addAchievement(String user, Achievement a) {
			if (usersStorageData.containsKey(user)) {
				usersStorageData.get(user).add(a); 
				// TODO: Verificar como garantir que exista apenas 1 badge de um determ tipo para um usuário 
			}
			else {
				usersStorageData.put(user, new ArrayList<>());
				// TODO: Talvez utilizar setup aqui
				usersStorageData.get(user).add(a);
			}
	}

	@Override
	public List<Achievement> getAchievements(String user) {
		return usersStorageData.get(user);
	}

	@Override
	public Achievement getAchievementStorage(String user, String achievementName) {
		for(Achievement ach: usersStorageData.get(user))
			if(ach.name.equals(achievementName))
				return ach;
		return null;
	}

}
