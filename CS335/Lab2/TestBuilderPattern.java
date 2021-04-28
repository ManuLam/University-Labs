package CS335;

public class TestBuilderPattern {

	public static void main(String[] args) {
		CarBuilder carBuilder1 = new SedanCarBuilder();
		CarDirector director1 = new CarDirector(carBuilder1);
		director1.build();
		Car car1 = carBuilder1.getCar();
		System.out.println(car1);
		
		CarBuilder carBuilder2 = new SportsCarBuilder();
		CarDirector director2 = new CarDirector(carBuilder2);
		director2.build();
		Car car2 = carBuilder2.getCar();
		System.out.println(car2);
		
	}
	
	
	
	
	

}
