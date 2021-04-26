package cs265;


public class CS265_LabExam1_Q2{

	/**
	 * 
	 * @param ipAddress which is a Java string
	 * @return the status of that IP Address
	 * 
	 * We define an IP address as follows. It is a computer address. 
	 * Usually 1- 3 digits followed by a period followed by 1 - 3 digits followed by a period
	 * followed by 1 - 3 digits followed by a period followed by 1 - 3 digits. 
	 * The digits can repeat themselves. 
	 * 
	 * For the sake of argument 
	 * 888.888.999.777 is a valid IP address for this question. 
	 * 
	 * IGNORING the case (upper or lower) of the string
	 * If the IP address is null, empty or length less than 5 then return INVALID
	 * 
	 * If the IP address has the structure 192.(1 - 3 digits).(1 - 3 digits).(1 - 3 digits)
	 * then return LOCAL. 
	 * 
	 * If the IP address is 127.0.0.1 then return LOCAL
	 * 
	 * If the IP address has the structure (1 - 3 digits).(1 - 3 digits).(1 - 3 digits).(1 - 3 digits)
	 * then return EXTERNAL.
	 * 
	 * Any other combination (including those with characters etc) the string INVALID is returned. 
	 * 
	 */
	public static String isIPAddress(String ipAddress)
	{
		String ipStatus = "INVALID";
		
		if (ipAddress == null)
		{
			ipStatus = "INVALID";
		}
		else if (ipAddress.length() <= 0)
		{
			ipStatus = "INVALID";
		}
		else if (ipAddress.length() < 5) 
		{
			ipStatus = "INVALID";
		}
		else if (ipAddress.toLowerCase().matches("^192.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}$") == true)
		{
			ipStatus = "LOCAL";
		}
		else if (ipAddress.toLowerCase().matches("^127.0.0.1$") == true)
		{
			// this is the local host. 
			ipStatus = "LOCAL";
		}		
		
		else if (ipAddress.toLowerCase().matches("^[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}$") == true)
		{
			// This is a full external IP Address 
			ipStatus = "EXTERNAL";
		}
		else
		{
			// this IP Address doesn't have the correct structure for any known address
			ipStatus = "INVALID";
		}
		return ipStatus;
	}
	
	
}