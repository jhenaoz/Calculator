import java.util.ArrayList;
import java.util.regex.Pattern;

public class Calculator{
	
	/**
	 * this method get and string with numbers and return their sum, if the input
	 * is empty, the method return 0
	 * @param numbers
	 * @return result, the sum of the numbers
	 * @throws NegativeNumberException, if the input have a negative number
	 */
	public int add (String numbers) throws Exception{
		int result = 0 ;
		String nums[];
		String separator = ",";
		ArrayList<String> separators = new ArrayList<String>();
		String negatives = "";
		if (numbers.length() == 0) {
			return result;
		}
		nums =numbers.split("\n|"+separator);
		//this conditional check for all the separators and conditions
		if (numbers.contains("//")) {
			nums = numbers.split("//|\n");
			String aux[] =nums[1].split(Pattern.quote("["));
			for (String string : aux) {
				if (!string.isEmpty()) {
					string = string.replaceAll(Pattern.quote("]"), "");
					separators.add(string);
				}
			}
			if (!nums[1].endsWith("]")) {
				separators.add(nums[1]);
			}
			numbers =numbers.replaceFirst("//", "");
			numbers =numbers.replaceFirst("\n", "");
			numbers = numbers.replaceAll(Pattern.quote("["), "");
			numbers = numbers.replaceAll(Pattern.quote("]"), "");
			separator ="";
			for (String string : separators) {
				numbers = numbers.replaceFirst(Pattern.quote(string), "");
				separator += "|" + Pattern.quote(string);
			}
			nums =numbers.split("\n"+separator);
		}
		for (String string : nums) {
			int num = Integer.parseInt(string);
			if (num < 0) {
				if (negatives.length() == 0) {
					negatives += num;
				}else{
					negatives += ","+ num;
				}
			}else if(num>1000){
				continue;
			}
			result += num;
		}
		if (negatives.length() > 0) {
			throw new NegativeNumberException("Negatives not allowed: "+ negatives);
		}
		return result;
	}
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		try {
			calc.add("//[*][%]\n1*2%3");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}