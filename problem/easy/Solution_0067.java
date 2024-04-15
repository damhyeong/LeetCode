package problem.easy;

public class Solution_0067 {
	
	public String addBinary(String a, String b) {
        // maybe using boolean array, it will be solved easier.
        int initLen = (a.length() <= b.length()) ? b.length() : a.length(); // select bigger.

        boolean[] aBinary = new boolean[initLen];
        boolean[] bBinary = new boolean[initLen];
        boolean[] resultBinary = new boolean[initLen + 1];

        for(int i = initLen - 1, j = a.length() - 1; i >= 0 && j >= 0; i--, j--){ // insert value to aBinary
            char ch = a.charAt(j); // ch will be '0' or '1'
            aBinary[i] = (ch == '1') ? true : false;
        } // Finish setting aBinary value

        for(int i = initLen - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--){ // insert value to bBinary
            char ch = b.charAt(j);
            bBinary[i] = (ch == '1') ? true : false;
        } // Finish setting bBinary value

        boolean isUp = false;
        for(int i = initLen - 1; i >= 0; i--){
            boolean A = aBinary[i];
            boolean B = bBinary[i];

            // we must considering about cases.
            if(A && B){ // case 1 => if A and B equals True.
                resultBinary[i + 1] = false;

                resultBinary[i + 1] = (isUp) ? true : false;

                isUp = true;
            } else if (A || B){ // case 2 => at least A or B is True.
                resultBinary[i + 1] = true;

                resultBinary[i + 1] = (isUp) ? false : true;

                isUp = (resultBinary[i + 1]) ? false : true;
            } else { // case 3 => Both of A and B is False.
                resultBinary[i + 1] = (isUp) ? true : false;

                isUp = false;
            }
        }
        
        // value of isUp have true, first element of resultBinary must be true.
        resultBinary[0] = (isUp) ? true : false;

        // lets getting result!
        String result = "";
        
        for(int i = (isUp) ? 0 : 1; i < resultBinary.length; i++){
            result += (resultBinary[i]) ? '1' : '0';
        }

        return result;
    }
	
}

/**
최고 효율 코드 예시 : 

class Solution {
    public String addBinary(String a, String b) {
         StringBuilder result = new StringBuilder();
            int i = a.length() - 1, j = b.length() - 1, carry = 0;

            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (i >= 0) sum += a.charAt(i--) - '0';
                if (j >= 0) sum += b.charAt(j--) - '0';

                result.append(sum % 2);
                carry = sum / 2;
            }

            if (carry != 0) result.append(carry);
            return result.reverse().toString();
    }
}
*/