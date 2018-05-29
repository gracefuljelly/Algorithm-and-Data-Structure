package Graph;
/*
* Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
f[i][j]: if s[0...i-1] matches p[0...j-1]
if p[j-1] !='*'
   f[i][j] = f[i-1][j-1] && s[i-1]==p[j-1]
if p[j-1]=='*', we need to look at p[j-2]
f[i][j]is true iif either of the below is true:
p[j-2]* repeats 0 time and matches empty: f[i][j-2]
p[j-2]* repeats >= 1 times and matches "p[j-2]*p[j-2]": s[i-1]='.' matches any single character
* */
public class RegularExpression {
    public boolean isMatch(String text, String pattern){
        if(pattern.isEmpty()) return text.isEmpty();
        boolean firstMatch =(!text.isEmpty()&&(pattern.charAt(0)==text.charAt(0)||pattern.charAt(0)=='.'));
        if(pattern.length()>=2&&pattern.charAt(1)=='*'){
            return (isMatch(text,pattern.substring(2)))
                    ||(firstMatch && isMatch(text.substring(1),pattern));
        } else {
            return firstMatch && isMatch(text.substring(1),pattern.substring(1));
        }
    }
}
