package converter;

public class NumberToTextConverter {

	private static final String[] zeroToTwentyTextArr = {"", "one", "two", "three", "four", "five", 
			"six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", 
			"sixteen", "seventeen", "eighteen", "nineteen" };
	private static final String[] tensTextArr = {"", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", 
			"seventy", "eighty", "ninety"};
	
	public static String convertNumberToText(long number) {
		if (number == 0) { 
			return "zero"; 
		}
		String numText = Long.toString(number);
		String result = "";
		
		// If it is required, it can be supported with the same logic..
		// Just change long parameter type with BigInteger
		if(numText.length() > 12) {
			return "Number is not supported!";
		} 
		if (numText.length() > 9){ 
			result = convertLessThanOneThousand(Integer.parseInt(numText.substring(0, numText.length() - 9)))  + " billion ";
			numText = cutText(numText);
		}
		if(numText.length() > 6){
			if (!numText.substring(0, numText.length() - 6).equals("000"))
				result = result + convertLessThanOneThousand(Integer.parseInt(numText.substring(0, numText.length() - 6)))  + " million ";
			numText = cutText(numText);
		}
		if(numText.length() > 3){
			if (!numText.substring(0, numText.length() - 3).equals("000"))
				result = result + convertLessThanOneThousand(Integer.parseInt(numText.substring(0, numText.length() - 3)))  + " thousand ";
			numText = cutText(numText);
		}
		
		result = result + convertLessThanOneThousand(Integer.parseInt(numText));
		numText = cutText(numText);
		
		return result.replaceAll("\\s+", " ").trim();
	}
	
	private static String convertLessThanOneThousand(int num) {
		String result = "";
		if (num < 20) {
			result = zeroToTwentyTextArr[num];
		} else if (num < 100) {
			result = tensTextArr[num / 10] + ((num % 10 != 0) ? " " : "") + zeroToTwentyTextArr[num % 10];
		} else if (num < 1000) {
			result = zeroToTwentyTextArr[num / 100] + " hundred" + ((num % 100 != 0) ? " " : "") + convertLessThanOneThousand(num % 100);
		} 
		return result;
	}
	
	private static String cutText(String numText) {
		return numText.substring((numText.length() % 3 == 0) ? 3 : (numText.length() % 3),numText.length());
	}
	
}
