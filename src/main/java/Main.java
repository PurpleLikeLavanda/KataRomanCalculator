public class Main {
    public static String calc(String input) throws Exception {
        String[] input_arr = input.split(" ");
        if (input_arr.length != 3){
            throw new Exception("не является математической операцией");
        }

        String  x_str = input_arr[0],
                operator = input_arr[1],
                y_str = input_arr[2];
        int x, y;
        boolean roman_input;
        int result;

        if (x_str.matches("\\d+") && y_str.matches("\\d+")) { // ввели арабские цифры
            x = Integer.parseInt(x_str);
            y = Integer.parseInt(y_str);
            roman_input = false;
        }
        else if (x_str.matches("[IVX]+") && y_str.matches("[IVX]+")){ // ввели римские цифры
            x = parseRoman(x_str);
            y = parseRoman(y_str);
            roman_input = true;
        }
        else {
            throw new Exception("некорректные системы счисления");
        }

        if (x < 1 || y < 1 || x > 10 || y > 10){
            throw new Exception("числа вне допустимого диапазона");
        }

        switch (operator){
            case "+":
                result = x+y;
                break;
            case "-":
                result = x-y;
                break;
            case "*":
                result = x*y;
                break;
            case "/":
                result = (int)Math.floor(x/y);
                break;
            default:
                throw new Exception("неверный оператор");
        }

        if (roman_input) {
            return makeRoman(result);
        }
        else {
            return Integer.toString(result);
        }
    }

    private static String makeRoman(int num) throws Exception {
        if (num < 0){
            throw new Exception("в римской системе нет отрицательных чисел");
        }
        int[] arabic = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arabic.length; i++) {
            while (num >= arabic[i]){
                num -= arabic[i];
                result.append(roman[i]);
            }
        }

        return result.toString();
    }
    private static int parseRoman(String str) throws Exception {
        switch (str){
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
            default:
                throw new Exception("недопустимое римское число");
        }
    }
}
