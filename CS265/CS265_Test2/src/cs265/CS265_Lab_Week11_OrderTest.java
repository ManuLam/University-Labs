package cs265;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CS265_Lab_Week11_OrderTest {

	  @Test
	  public void test1() {
		  assertEquals("Accept order",CS265_Lab_Week11_Order.orderProcess(500,true,550)); //below 0
	  }
	  @Test
	  public void test2() {
		  assertEquals("Defer order",CS265_Lab_Week11_Order.orderProcess(500,true,450)); //below 0
	  }
	  @Test
	  public void test3() {
		  assertEquals("Reject order",CS265_Lab_Week11_Order.orderProcess(1200,false,50)); //below 0
	  }
}
