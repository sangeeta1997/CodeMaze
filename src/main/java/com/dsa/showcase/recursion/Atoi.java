package com.dsa.showcase.recursion;
/*8. String to Integer (atoi)
Solved
        Medium
Topics
conpanies icon
Companies
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.



        Example 1:

Input: s = "42"

Output: 42

Explanation:

The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
        ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
        ^
Step 3: "42" ("42" is read in)
        ^
Example 2:

Input: s = " -042"

Output: -42

Explanation:

Step 1: "   -042" (leading whitespace is read and ignored)
        ^
Step 2: "   -042" ('-' is read, so the result should be negative)
        ^
Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
        ^
Example 3:

Input: s = "1337c0d3"

Output: 1337

Explanation:

Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
        ^
Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
        ^
Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
        ^
Example 4:

Input: s = "0-1"

Output: 0

Explanation:

Step 1: "0-1" (no characters read because there is no leading whitespace)
        ^
Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
        ^
Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
        ^
Example 5:

Input: s = "words and 987"

Output: 0

Explanation:

Reading stops at the first non-digit character 'w'.



Constraints:

        0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.*/
public class Atoi {
    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("   -42"));
        System.out.println(atoi.myAtoi("4193 with words"));
        System.out.println(atoi.myAtoi("words and 987"));
        System.out.println(atoi.myAtoi("+-12"));
        System.out.println(atoi.myAtoi("2147483648")); // Overflow case
        System.out.println(atoi.myAtoi("-2147483649")); // Underflow case
    }

    public int myAtoi(String s) {
        char[] c = s.trim().toCharArray();
        int n = c.length;
        int ans = 0;
        int sign = 1;
        int i = 0;
        if (n == 0) {
            return 0;
        }
        if (c[i] == '-') {
            sign = -1;
            i++;
        } else if (c[i] == '+') {
            sign = 1;
            i++;
        }
        while (i < n && c[i] >= '0' && c[i] <= '9') {
            int digit = c[i] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            i++;
        }
        return ans * sign;
    }

    public int myAtoiRecurion(String s) {
        char[] c = s.trim().toCharArray();
        int n = c.length;
        if (n == 0) return 0;
        int i = 0, sign = 1;
        if (c[i] == '-') {
            sign = -1;
            i++;
        } else if (c[i] == '+') {
            i++;
        }

        return atoi(c, sign, 0, i);
    }

    public int atoi(char[] c, int sign, int ans, int i) {
        if (i >= c.length || c[i] < '0' || c[i] > '9') {
            return ans * sign;
        }
        int digit = c[i] - '0';
        if (ans > (Integer.MAX_VALUE - digit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        ans = ans * 10 + digit;
        return atoi(c, sign, ans, i + 1);
    }
}