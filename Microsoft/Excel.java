package Microsoft;

public class Excel {
    public static int titleToNumber(String s){
        int result =0;
        for(int i=0; i<s.length();i++){
            result *= 26;
            System.out.println(s.charAt(i));
            result +=((s.charAt(i)-'A')+1);
        }
        return result;
    }

    public String convertToTitle(int n){
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.append((char)('A'+ n%26));
            n/=26;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String input="ABZ";
        System.out.println(Excel.titleToNumber(input));
    }
}
