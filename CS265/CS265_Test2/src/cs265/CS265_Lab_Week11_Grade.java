package cs265;

public class CS265_Lab_Week11_Grade {
	
	/**
	 * The program getGrade combines an exam and a coursework mark
	 * into a single grade. The values for exam and coursework are 
	 * integers. If the exam or coursework mark is less than 50% then 
	 * the grade returned is a ‘Fail’. To pass the course with a 
	 * ‘Pass, C’, the student must score between 50% and 60% in the 
	 * exam, and at least 50% in the coursework. They will pass the 
	 * course with ‘Pass, B’, if they score over 60% in the exam and 
	 * 50% in the coursework. In addition to this, if the average of 
	 * the exam and the coursework is at least 70%, then they are 
	 * awarded a ‘Pass, A’. Input values that are less than 0 or greater 
	 * than 100 for either the exam or coursework are invalid and the 
	 * program will return a message to say ‘Marks out of range’. 
	 * 
	 * 
	 * @param exam The grade received for the written exam
	 * @param course The grade received for coursework
	 * @return A String that determines the quality of the grade, 
	 * and either 'Marks out of range', 'Fail', 'Pass,C', 'Pass,B'
	 * or 'Pass,A' (based on the description above). 
	 */
	public static String Grade(int exam, int course) {
		String result="null";
		long average;
		average = Math.round((exam + course) / 2);
		if ( (exam < 0) || (exam > 100) || (course < 0) || (course > 100) )
			result="Marks out of range";
		else
			if ( (exam<50) || (course<50))
				result="Fail";
			else if (exam < 60)
				result="Pass,C";
			else if ( average >= 70)
				result="Pass,A";
			else
				result="Pass,B";
		return result;
	}
	
}