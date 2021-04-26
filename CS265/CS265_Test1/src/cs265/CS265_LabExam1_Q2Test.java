package cs265;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CS265_LabExam1_Q2Test {
	
  @Test
  public void test1() {
	  assertEquals("INVALID",CS265_LabExam1_Q2.isIPAddress(null)); // x = null
  }
  
  @Test
  public void test2() {
	  assertEquals("INVALID",CS265_LabExam1_Q2.isIPAddress("")); // x <= 0
  }
  
  @Test
  public void test3() {
	  assertEquals("INVALID",CS265_LabExam1_Q2.isIPAddress("1234"));  //x < 5
  }
  @Test
  public void test4() {
	  assertEquals("LOCAL",CS265_LabExam1_Q2.isIPAddress("192.12.32.65"));
  }
  @Test
  public void test5() {
	  assertEquals("LOCAL",CS265_LabExam1_Q2.isIPAddress("127.0.0.1"));
  }
  @Test
  public void test6() {
	  assertEquals("EXTERNAL",CS265_LabExam1_Q2.isIPAddress("149.157.242.121"));
  }
  @Test
  public void test7() {
	  assertEquals("INVALID",CS265_LabExam1_Q2.isIPAddress("rek123123"));
  }
}