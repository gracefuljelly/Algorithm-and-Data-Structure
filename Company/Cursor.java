package Company;
/*Toast*/

import java.util.ArrayList;
import java.util.List;

class DPT{
    public int docId;
    public int position;
}

public class Cursor {
     public Cursor(String str){

     }

     public DPT get(){
        return new DPT();
     }

     public void advance(){

     }

     public boolean isValid(){
        return true;
     }

     public boolean seek(DPT dpt){
        return true;
     }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> res= new ArrayList<>();
        String input = "cat";
        Cursor cursor = new Cursor(input);

        while(cursor.isValid()){
            cursor.wait();

           DPT dpt = cursor.get();
            if(cursor.seek(dpt)){
                res.add(dpt.docId);
            }
            cursor.advance();
        }
    }

}

