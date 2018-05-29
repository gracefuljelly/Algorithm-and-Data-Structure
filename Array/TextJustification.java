package Array;
import java.util.List;
import java.util.ArrayList;

public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<String>();

        int curr = 0;
        while (curr < words.length) {
            int count = words[curr].length();
            int last = curr + 1;//last word of each line
            while (last < words.length) {//extend until it is over the L. Don't forget the 1 as the space
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - curr - 1;//use this value to calculate space between word.
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = curr; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = curr; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - curr) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            curr = last;
        }


        return lines;
    }

    public static void main(String[] args) {
        TextJustification tj= new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        tj.fullJustify(words,16);
    }
}
