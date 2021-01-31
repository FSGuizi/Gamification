
public class ForumServiceGamificationProxy implements ForumService {
	 
	private ForumService forumService;
	
	public AchievementStorage userAchievement;
	
	
	// public ForumServiceGamificationProxy(ForumService encapsulado, Achievement userAchievement) {
    public ForumServiceGamificationProxy(ForumService encapsulado, AchievementStorage userAchievement) {
		this.forumService = encapsulado;
		this.userAchievement = userAchievement;
	}

    // Método void addTopic(String user, String topic) 
    // - Deve adicionar 5 pontos do tipo "CREATION". Deve adicionar o bagde "I CAN TALK"
	public void addTopic(String user, String topic) {
		forumService.addTopic(user, topic);
		//Points points =  Points.getPointsInstance("CREATION", 5);
		Points points = new Points("CREATION", 5);
		userAchievement.addAchievement(user, points);
		Badge badge =  new Badge("CREATION", "I CAN TALK");
		userAchievement.addAchievement(user, badge);
	}

    // Método void addComment(String user, String topic, String comment) 
	// - Deve adicionar 3 pontos do tipo "PARTICIPATION". Deve adicionar o badge "LET ME ADD"
	public void addComment(String user, String topic, String comment) {
		forumService.addComment(user, topic, comment);
		// Points points =  Points.getPointsInstance("PARTICIPATION", 3);
		Points points =  new Points("PARTICIPATION", 3);
		userAchievement.addAchievement(user, points);
		Badge badge =  new Badge("PARTICIPATION", "LET ME ADD");
		userAchievement.addAchievement(user, badge);
	}

	// Método void likeTopic(String user, String topic, String topicUser)
	// - Deve adicionar 1 ponto do tipo "CREATION".
	public void likeTopic(String user, String topic, String topicUser) {
		forumService.likeTopic(user, topic, topicUser);
		Points points =  new Points("CREATION", 1);
		userAchievement.addAchievement(user, points);
	
	}

	// Método void likeComment(String user, String topic, String comment, String commentUser) 
	// - Deve adicionar 1 ponto do tipo "PARTICIPATION".
	public void likeComment(String user, String topic, String comment, String commentUser) {
		forumService.likeComment(user, topic, comment, commentUser);
		Points points =  new Points("PARTICIPATION", 1);
		userAchievement.addAchievement(user, points);
	}

}
