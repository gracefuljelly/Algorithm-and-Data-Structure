package String;



public class RemoveAdjacentRepeatedCharacters {
    public String deDupKeep2(String input) {
        if(input==null) return null;
        if(input.length()<3) return input;
        char[] inputArray = input.toCharArray();
        int end =1;
        for(int i=2; i<inputArray.length;i++){
            if(inputArray[i]!=inputArray[end]){
                inputArray[end+1]=inputArray[i];
                end++;
            } else if(inputArray[i]==inputArray[end]&&inputArray[end]!=inputArray[end-1]){
                inputArray[end+1]=inputArray[i];
                end++;
            } else continue;
        }
        System.out.println(new String(inputArray, 0, end));
        return new String(inputArray, 0, end);
    }



    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharacters solution = new RemoveAdjacentRepeatedCharacters();
        String input ="aaaaabbbc";
        solution.deDupKeep2(input);
    }

}
