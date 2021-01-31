public class Points extends Achievement {

	/*private static Points pointsInstance = null;
	
	public int qtd;

	public static Points getPointsInstance(String name, int qtd) {
		if(pointsInstance == null)
			pointsInstance = new Points(name, qtd);
		else
			pointsInstance.qtd += qtd;
		return pointsInstance;
	}
	
	private Points(String name, int qtd) {
		super(name);
		this.qtd = qtd;
	}*/
	public int qtd;
	
	public Points(String name, int qtd) {
		super(name);
		this.qtd += qtd;	
	}
	
}
