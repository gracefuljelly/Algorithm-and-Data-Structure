package laioffer.ArrayAndSortingAlgorithms;

public class RainbowSort {
    public void rainbowSort(int[] array){
        if(array==null || array.length<=1){
            return ;
        }
        int neg=0;
        int zero=0;
        int one = array.length-1;
        while(zero<=one){
            if(array[zero]==-1){
                swap(array,zero++,neg++);
            }else if(array[zero]==0){
                zero++;
            }else{
                swap(array,zero,one--);
            }
        }
    }

    private void swap(int[] array, int left, int right){
        int temp=array[left];
        array[left]=array[right];
        array[right]=array[left];
    }

}
