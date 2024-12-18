package MatrimonialSys;

public class ValidationReq {
	
	    public static void gender(String gender) throws InvalidInputException {
	        if (!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
	            throw new InvalidInputException("Invalid gender. Please enter 'male' or 'female'.");
	        }
	    }

	    public static void age(String gender, int age) throws InvalidInputException {
	        int minimumAge = gender.equalsIgnoreCase("male") ? 21 : 18;
	        if (age < minimumAge) {
	            throw new InvalidInputException("Minimum age requirement not met. "
	                    + (gender.equalsIgnoreCase("male") ? "Males must be at least 21." : "Females must be at least 18."));
	        }
	    }
}
