public class StringCalculator {
    public int add(String input) {
        String[] numbers = input.split(",|\n");

        if (input.isEmpty()) {
            return 0;
        } else if (numbers.length > 1) {
            return getSum(numbers);
        }
        return stringToInt(input);
    }

    private int getSum(String[] numbers) {
        int sum = 0;
        if(numbers[0].startsWith("E")==true)
        {
        	for (String currentNumber:numbers) {
                if (stringToInt(currentNumber) %2!=0 && stringToInt(currentNumber) > 1000) {
                    continue;
                }
                sum += stringToInt(currentNumber);
            }
        	return sum;
        }
        else if(numbers[0].startsWith("O")==true)
        {
        	for (String currentNumber:numbers) {
                if (stringToInt(currentNumber) %2==0 && stringToInt(currentNumber) > 1000) {
                    continue;
                }
                sum += stringToInt(currentNumber);
            }
        	return sum;
        }else {
        for (String currentNumber:numbers) {
            if (stringToInt(currentNumber) > 1000) {
                continue;
            }
            sum += stringToInt(currentNumber);
        }
        return sum;
        }
    }

    private int stringToInt(String number) {
        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException("Negative input!");
        } else {
            return num;
        }
    }

}
