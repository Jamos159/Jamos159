import java.util.ArrayList;

/**
 * This is the interface Policies, it has two constants and one method,
 * the purpose of this class is ensure that classes that implement 
 * Policies make a calculateGpa method and use the constants to calculate
 * a students GPA
 * 
 * @author Jared Amos
 * @version 1.0
 *
 */
public interface Policies {
	/** this constant is used in the calculation of a GPA because this
	 * is the highest grade a student can achieve */
	final int MAX_MARKS = 100;
	/** this constant is used in the calculation of a GPA because this
	 * is the highest GPA a student can achieve */
	final double MAX_GPA = 4.0;
	
	/** this method's purpose is to calculate a GPA when an array of doubles
	 * is passed through it, and to ensure classes that implement it add code
	 * 
	 * @param marks this is the array list that will store the marks of students
	 * */
	void calculateGpa(ArrayList<Double> marks);
}
