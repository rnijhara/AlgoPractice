package javatests;

/*
Regex Character classes
1	[abc]	        a, b, or c (simple class)
2	[^abc]	        Any character except a, b, or c (negation)
3	[a-zA-Z]	a through z or A through Z, inclusive (range)
4	[a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)
5	[a-z&&[def]]	d, e, or f (intersection)
6	[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
7	[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z](subtraction)


Regex Quantifiers
X?	X occurs once or not at all
X+	X occurs once or more times
X*	X occurs zero or more times
X{n}	X occurs n times only
X{n,}	X occurs n or more times
X{y,z}	X occurs at least y times but less than z times


Regex Metacharacters
.	Any character (may or may not match terminator)
\d	Any digits, short of [0-9]
\D	Any non-digit, short for [^0-9]
\s	Any whitespace character, short for [\t\n\x0B\f\r]
\S	Any non-whitespace character, short for [^\s]
\w	Any word character, short for [a-zA-Z_0-9]
\W	Any non-word character, short for [^\w]
\b	A word boundary
\B	A non word boundary
*/

import java.util.regex.*;
public class RegexTest {
    public static void main(String[] args) {
        System.out.println("Check for a phone number of type +91-8869952780");
        Pattern pattern = Pattern.compile("\\+{1}\\d{2}-{1}[0-9]{10}");
        Matcher matcher = pattern.matcher("+91-8869952780");
        System.out.println(matcher.matches());
        
        pattern = Pattern.compile("java");
        matcher = pattern.matcher("this is java, do you know java");
        while(matcher.find()) {
            System.out.println(matcher.group()+" "+matcher.start()+" "+matcher.end());
        }
    }
}