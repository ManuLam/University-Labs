package cs265;

public class CS265_LabExam1_Q1 {

	/**
	 * 
	 * @param speed in km/h
	 * @return road sign status message 
	 * 
	 * The control board for a roadside sign for speed measurement
	 * is fed by the following method. 
	 * 
	 *  Speed < 0 .... display INVALID
	 *  Speed between 0 and 60KM/H ... .display THANK YOU
	 *  Speed between 61 and 80 ... display SLOW DOWN
	 *  Otherwise display TOO FAST
	 */
	public static String speedMonitor(int speed)
	{
		String status = new String("");
		
		if (speed < 0)
			status = new String("INVALID");
		
		else if ((speed >= 0) && (speed <= 60))
		{
			status = new String("THANK YOU");
		}
		else if ((speed > 60) && (speed <= 80))
		{
			status = new String("SLOW DOWN");
		}
		else
		{
			status = new String("TOO FAST");
		}
		
		return status;
	}
	
}