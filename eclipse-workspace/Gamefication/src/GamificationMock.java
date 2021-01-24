
public class GamificationMock implements ForumService {
	
	public boolean operationRun = false;
	
	@Override
	public void addTopic(String user, String topic) {
		operationRun = true;

	}

	@Override
	public void addComment(String user, String topic, String comment) {
		operationRun = true;

	}

	@Override
	public void likeTopic(String user, String topic, String topicUser) {
		operationRun = true;

	}

	@Override
	public void likeComment(String user, String topic, String comment, String commentUser) {
		operationRun = true;

	}
	
	public boolean operationRun() {
		return operationRun;
	}
}
