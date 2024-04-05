package daily;

import java.util.*;
import java.io.*;
import java.math.*;

public class Solution_1544 {
    public String makeGood(String s) {
        // if for loop go to end, define keepGo is false. for escaping loop.
        Boolean keepGo = true;

        while(keepGo == true){
            // if just left one letter or nothing
            if(s.length() == 1 || s.length() == 0)
                break;

            // for checking diffrence
            char c1 = s.charAt(0);
            

            for(int i = 1; i < s.length(); i++){
                char c2 = s.charAt(i);
                if(isViceVersa(c1, c2)){ // if two char in vice versa, remove two character and go to while loop.
                    s = s.substring(0, i - 1) + s.substring(i + 1, s.length());
                    break;
                } else if(i == s.length() - 1){ // if theres nothing to remove in letters.
                    // checking All Letters, and nothing to remove.
                    keepGo = false;
                } else { // index is not in end
                    c1 = s.charAt(i);
                }
            }
        }
        return s;
    }

    public boolean isViceVersa(char c1, char c2){
        int diff = (int) Math.abs((int)'a' - (int)'A');
        if(Math.abs(((int)c1 - (int)c2)) ==  diff){
            return true;
        } else {
            return false;
        }
    }

}