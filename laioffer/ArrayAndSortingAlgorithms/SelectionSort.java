package laioffer.ArrayAndSortingAlgorithms;

public class SelectionSort {
    public int[] selectionSort(int[] array){
        if(array==null||array.length<=1){
            return array;
        }
        for(int i=0;i<array.length;i++){
            int min =i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    min=j;
                }
            }
            swap(array,i,min);
        }
        return array;
    }

    private void swap(int[] array, int left, int right){
        int temp= array[left];
        array[left]=array[right];
        array[right]=array[left];
    }
}
