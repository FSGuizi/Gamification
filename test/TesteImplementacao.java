import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

class TesteImplementacao {

	@Test
	void testAddTopic() {
		String user = "FABIANA";
		String topic = "Topic_01";
		GamificationMock forumMocky = new GamificationMock();
		AchievementStorage achStorage = AchievementStorageFactory.getAchievementStorage();
		AchievementStorageFactory.setAchievementStorage(new MemoryAchievementStorage());
		achStorage = AchievementStorageFactory.getAchievementStorage();
		ForumService forumProxy = new ForumServiceGamificationProxy(forumMocky, achStorage);
		try {
			forumProxy.addTopic(user, topic);
			assertTrue(forumMocky.operationRun());
		} catch (Exception e) {
			assertFalse(forumMocky.operationRun());
		}
		List<Achievement> achList = achStorage.getAchievements(user);
		assertEquals((achList).get(0).name, "CREATION");
		assertEquals(((Points) (achList).get(0)).qtd, 5);
		assertEquals((achList).get(0).name, "CREATION");
		assertEquals(((Badge)(achList).get(1)).objective, "I CAN TALK");
	}

	@Test
	void testAddComment() {
		String user 	= "Fabiana";
		String topic 	= "Topic_02";
		String comment  = "Comment";
		GamificationMock forumMocky = new GamificationMock();
		AchievementStorage achStorage = AchievementStorageFactory.getAchievementStorage();
		AchievementStorageFactory.setAchievementStorage(new MemoryAchievementStorage());
		achStorage = AchievementStorageFactory.getAchievementStorage();
		ForumService forumProxy = new ForumServiceGamificationProxy(forumMocky, achStorage);
		try {
			forumProxy.addComment(user, topic, comment);
		} catch (Exception e) {
			assertFalse(forumMocky.operationRun());
		}
        List<Achievement> achList = achStorage.getAchievements(user);
		assertEquals((achList).get(0).name, "PARTICIPATION");
		assertEquals(((Points)(achList).get(0)).qtd, 3);
		assertEquals((achList).get(1).name, "PARTICIPATION");
		assertEquals(((Badge)(achList).get(1)).objective, "LET ME ADD");
	}

	@Test
	void testLikeTopic() { 
		String user = "Fabiana"; String topic = "Topic_03";
		String topicUser = "Topic_02";
		GamificationMock forumMocky = new GamificationMock();
		AchievementStorage achStorage = AchievementStorageFactory.getAchievementStorage();
		AchievementStorageFactory.setAchievementStorage(new MemoryAchievementStorage());
		achStorage = AchievementStorageFactory.getAchievementStorage();
		ForumService forumProxy = new ForumServiceGamificationProxy(forumMocky, achStorage);
		try {
			forumProxy.likeTopic(user, topic, topicUser);
		} catch (Exception e)
		{
			assertFalse(forumMocky.operationRun()); 
		}
		List<Achievement> achList =  achStorage.getAchievements(user); 
		assertEquals((achList).get(0).name, "CREATION");
		assertEquals(((Points)(achList).get(0)).qtd, 1); 
		}
	@Test
	void testLikeComment()	{ 
		String user 			= "Fabiana";
		String topic 			= "Topic_03"; 
		String comment		= "Comment";
		String commentUser 	= "Topic_02";
		GamificationMock forumMocky = new GamificationMock();
		AchievementStorage achStorage = AchievementStorageFactory.getAchievementStorage();
		AchievementStorageFactory.setAchievementStorage(new MemoryAchievementStorage());
		achStorage = AchievementStorageFactory.getAchievementStorage();
		ForumService forumProxy = new ForumServiceGamificationProxy(forumMocky, achStorage);
		try {
		  forumProxy.likeComment(user, topic, comment, commentUser); 
		} catch (Exception e) 
		{
		  assertFalse(forumMocky.operationRun());
		} 
		List<Achievement> achList = achStorage.getAchievements(user);
		assertEquals((achList).get(0).name, "PARTICIPATION");
		assertEquals(((Points)(achList).get(0)).qtd, 1);
	  }
	 
	@Test
	void testAddTopic2Vezes() {
		String user = "FABIANA";
		String topic_01 = "Topic_01";
		String topic_02 = "Topic_02";
		GamificationMock forumMocky = new GamificationMock();
		AchievementStorage achStorage = AchievementStorageFactory.getAchievementStorage();
		AchievementStorageFactory.setAchievementStorage(new MemoryAchievementStorage());
		achStorage = AchievementStorageFactory.getAchievementStorage();
		ForumService forumProxy = new ForumServiceGamificationProxy(forumMocky, achStorage);
		// Adiciona o primeiro tópico
		try {
			forumProxy.addTopic(user, topic_01);
		} catch (Exception e) {
			assertFalse(forumMocky.operationRun());
		}
		// Adicionam o segundo tópico
		try { 
			 forumProxy.addTopic(user, topic_02); 
		} catch (Exception e) {
			 assertFalse(forumMocky.operationRun()); 
		}
		List<Achievement> achList = achStorage.getAchievements(user);
		assertEquals((achList).get(0).name, "CREATION");
		assertEquals(((Points) (achList).get(0)).qtd, 10);
		assertEquals((achList).get(1).name, "CREATION");
		assertEquals(((Badge)  (achList).get(1)).objective, "I CAN TALK");
		 
	}

}
