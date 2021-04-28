package cs335;
/*
 * Test different brands of plugs.
 */
public final class TestPlugs{

	public static void main (String args[]){
		testGermanToUKAdapter();
		testUKToGermanAdapter();
	}


	/*	
	 *	Test Method for testing GermanToUK Adapter.
	 */
	public static void testGermanToUKAdapter(){
		/* create a germany plug connector (brand: zest) */
		GermanPlugConnector plug = new ZestPlug();
		/* create a UK socket */
		UKElectricalSocket socket = new UKElectricalSocket();
		/* create an adapter */
		UKPlugConnector ukAdapter = new GermanToUKPlugConnectorAdapter(plug);
		/* use this adapter in a UK socket */
		socket.plugIn(ukAdapter);
	}

	/*	
	 *	Test Method for testing UKToGerman Adapter.
	 */
	public static void testUKToGermanAdapter(){
		/* create a UK plug connector (brand: furutech) */
		UKPlugConnector plug = new FurutechPlug();
		/* create a German socket */
		GermanElectricalSocket socket = new GermanElectricalSocket();
		/* create an adapter */
		GermanPlugConnector germanAdapter = new UKToGermanPlugConnectorAdapter(plug);
		/* use this adapter in a German socket */
		socket.plugIn(germanAdapter);
	}
}
