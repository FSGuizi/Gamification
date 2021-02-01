
public class ForumServiceGamificationProxy implements ForumService {
	 
	private ForumService forumService;
	
	public AchievementStorage userAchievement = null;
	
    public ForumServiceGamificationProxy(ForumService encapsulado, AchievementStorage userAchievement) {
		this.forumService = encapsulado;
		this.userAchievement = userAchievement;
	}

    // Método void addTopic(String user, String topic) 
    // - Deve adicionar 5 pontos do tipo "CREATION". Deve adicionar o bagde "I CAN TALK"
	public void addTopic(String user, String topic) {
		forumService.addTopic(user, topic);
		String achievementName = "CREATION";
		String objective = "I CAN TALK";
		int pointsQtd = 5;
		// Adição de achievements do tipo points
		Achievement ach = userAchievement.getAchievementStorage(user, achievementName, "Points");
		Points.setAchievementStorage((Points)ach);
		Points points = Points.getPointsInstance(achievementName, pointsQtd);
		userAchievement.addAchievement(user, points);
		// Adição de achievements do tipo badge
		ach = userAchievement.getAchievementStorage(user, achievementName, "Badge");
		Badge.setAchievementStorage((Badge)ach);
	    Badge badge =  Badge.getBadgeInstance(achievementName, objective);
		userAchievement.addAchievement(user, badge);
	}

    // Método void addComment(String user, String topic, String comment) 
	// - Deve adicionar 3 pontos do tipo "PARTICIPATION". Deve adicionar o badge "LET ME ADD"
	public void addComment(String user, String topic, String comment) {
		forumService.addComment(user, topic, comment);
		String achievementName = "PARTICIPATION";
		String objective = "LET ME ADD";
		int pointsQtd = 3;
		// Adição de achievements do tipo points
		Achievement ach = userAchievement.getAchievementStorage(user, achievementName, "Points");
		Points.setAchievementStorage((Points)ach);
		Points points =  Points.getPointsInstance(achievementName, pointsQtd);
		userAchievement.addAchievement(user, points);
		// Adição de achievements do tipo badge
		ach = userAchievement.getAchievementStorage(user, achievementName, "Badge");
		Badge.setAchievementStorage((Badge)ach);
	    Badge badge =  Badge.getBadgeInstance(achievementName, objective);
		userAchievement.addAchievement(user, badge);
	}

	// Método void likeTopic(String user, String topic, String topicUser)
	// - Deve adicionar 1 ponto do tipo "CREATION".
	public void likeTopic(String user, String topic, String topicUser) {
		forumService.likeTopic(user, topic, topicUser);
		String achievementName = "CREATION";
		int pointsQtd = 1;
		// Adição de achievements do tipo points
		Achievement ach = userAchievement.getAchievementStorage(user, achievementName, "Points");
		Points.setAchievementStorage((Points)ach);
		Points points = Points.getPointsInstance(achievementName, pointsQtd);
		userAchievement.addAchievement(user, points);
	
	}

	// Método void likeComment(String user, String topic, String comment, String commentUser) 
	// - Deve adicionar 1 ponto do tipo "PARTICIPATION".
	public void likeComment(String user, String topic, String comment, String commentUser) {
		forumService.likeComment(user, topic, comment, commentUser);
		String achievementName = "PARTICIPATION"; 
		int pointsQtd = 1;
		// Adição de achievements do tipo points 
		Achievement ach = userAchievement.getAchievementStorage(user, achievementName, "Points");
		Points.setAchievementStorage((Points)ach);
		Points points = Points.getPointsInstance(achievementName, pointsQtd);
		userAchievement.addAchievement(user, points);
		 
	}

}
