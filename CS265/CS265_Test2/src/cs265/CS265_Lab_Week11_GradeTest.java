package cs265;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CS265_Lab_Week11_GradeTest {

	  @Test
	  public void test1() {
		  assertEquals("Marks out of range",CS265_Lab_Week11_Grade.Grade(150,50)); //below 0
	  }
	  @Test
	  public void test2() {
		  assertEquals("Fail",CS265_Lab_Week11_Grade.Grade(20,70)); //below 0
	  }
	  @Test
	  public void test3() {
		  assertEquals("Pass,C",CS265_Lab_Week11_Grade.Grade(55,70)); //below 0
	  }
	  @Test
	  public void test4() {
		  assertEquals("Pass,A",CS265_Lab_Week11_Grade.Grade(95,95)); //below 0
	  }
	  @Test
	  public void test5() {
		  assertEquals("Pass,B",CS265_Lab_Week11_Grade.Grade(65,65)); //below 0
	  }
}
