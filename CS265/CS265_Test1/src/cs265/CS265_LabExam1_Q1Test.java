package cs265;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CS265_LabExam1_Q1Test {
	
  @Test
  public void test1() {
	  assertEquals("INVALID",CS265_LabExam1_Q1.speedMonitor(-5)); //below 0
  }
  
  @Test
  public void test2() {
	  assertEquals("THANK YOU",CS265_LabExam1_Q1.speedMonitor(45)); //above 0 , below or equal 60
  }
  
  @Test
  public void test3() {
	  assertEquals("SLOW DOWN",CS265_LabExam1_Q1.speedMonitor(75));	//above 60 and below or equal to 80
  }
  
  @Test
  public void test4() {
	  assertEquals("TOO FAST",CS265_LabExam1_Q1.speedMonitor(85)); //above 80
  }
  
}
