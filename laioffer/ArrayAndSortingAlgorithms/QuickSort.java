package laioffer.ArrayAndSortingAlgorithms;
/*
* inside partition use leftBound and rightBound左挡板和右挡板
* never ever forget termination condition left<=right
* When you swap which one do you swap, leftBound or rightBound?
* */

public class QuickSort {
   public int[] quickSort(int[] array){
       if(array==null||array.length==0){
           return array;
       }
       quickSort(array,0,array.length-1);
       return array;
   }

   private void quickSort(int[] array, int left, int right){
       if(left>=right){
           return;
       }
       int pivotPos= partition(array,left,right);
       quickSort(array,0,pivotPos-1);
       quickSort(array,pivotPos+1,right);
   }

   private int partition(int[] array, int left, int right){
       int pivotIndex= pivotIndex(left,right);
       int pivot = array[pivotIndex];
       swap(array,pivot,right);
       int leftBound= left;
       int rightBound=right;
       while(leftBound<=rightBound) {
           if (array[leftBound] < pivot) {
               leftBound++;
           } else if (array[rightBound] >= pivot) {
               rightBound--;
           } else {
               swap(array, leftBound++, rightBound--);
           }
       }
       /*
       *the pivot value is already swap to right index
       * what is on the leftBound and not include leftBound are value smaller than pivot
       * if we do array[leftBound]<=pivot then array[rightBound]>pivot
       * then we can return rightBound becuase from rightBound
        */
       swap(array,right,leftBound);
       return leftBound;
   }

   private int pivotIndex(int left, int right){
       return left+(int)(Math.random()*(right-left+1));
   }

   private void swap(int[] array, int left, int right){
       int temp= array[left];
       array[left]=array[right];
       array[right]=temp;
   }

}
