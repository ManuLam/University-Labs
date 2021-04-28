package CS335;
public class SportsCarBuilder implements CarBuilder{
	
	private final Car car = new Car("SportsCar");
	
	@Override
	public void buildBodyStyle() {
		car.setBodyStyle("External dimensions: overall length (inches): 301.2, " +
				"overall width (inches): 76.2, overall height (inches): 72.1, wheelbase (inches): 113.7," +
				" front track (inches): 62.3, rear track (inches): 63.5 and curb to curb turning circle (feet): 31.5");
	}
	
	@Override
	public void buildPower(){
		car.setPower("300 hp @ 7,000 rpm; 260 ft lb of torque @ 5,000 rpm");
	}

	@Override
	public void buildEngine() {
		car.setEngine("3.5L Duramax V 6 DOHC");
	}

	@Override
	public void buildBreaks() {
		car.setBreaks("Four-wheel disc brakes: two ventilated. Electronic brake distribution");
	}

	@Override
	public void buildSeats() {
		car.setSeats("Front seat center armrest.Rear seat center armrest.Split-folding rear seats");
	}

	@Override
	public void buildWindows() {
		car.setWindows("Laminated side windows.Fixed rear window with defroster");
		
	}

	@Override
	public void buildFuelType() {
		car.setFuelType("Gasoline 19 MPG city, 29 MPG highway, 23 MPG combined and 437 mi. range");
		
	}
	
	@Override
	public Car getCar(){
		return car;
	}
	
}
