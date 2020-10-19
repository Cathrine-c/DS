package java16_1019.java;


import java.util.Arrays;

public class Sort {

    public static void insert(int[] array) {
        //需要插排的次数，已排序区间[0,bound],待排序区间[bound,size]
        for (int bound=1;bound<array.length;bound++){
            int current=array[bound];//当前要排序的数
            int cur=bound-1;
            for (;cur>=0;cur--){//和已排序区间的数一一比较
                //如果待排序数大于已排好的数
                if (current<array[cur]){
                    //把它放到后面位置
                    array[cur+1]=array[cur];
                    array[cur]=current;
                }else{
                    break;
                }
            }
            //如果两者相等就把要排序的数放在后面位置
            //array[cur+1]=current;
        }
    }


    public static void shellSort(int[] array){
        int gap=array.length/2;
        while (gap>1){
            insertWithGap(array,gap);
            gap=gap/2;
        }
        insertWithGap(array,1);
    }

    private static void insertWithGap(int[] array,int gap) {
        for (int bound=gap;bound<array.length;bound++){
            int current=array[bound];//当前要排序的数
            int cur=bound-gap;
            for (;cur>=0;cur-=gap){//和已排序区间的数一一比较
                //如果待排序数大于已排好的数
                if (current<array[cur]){
                    //把它放到后面位置
                    array[cur+gap]=array[cur];
                    //array[cur]=current;
                }else{
                    break;
                }
            }
            //如果两者相等就把要排序的数放在后面位置
            array[cur+gap]=current;
        }
    }

    public static void selectSort(int[] array){
        for (int i=0;i<array.length-1;i++){
            int maxIndex=0;
            for (int j=1;j<array.length-i;j++){
                if (array[j]>array[maxIndex]){
                    maxIndex=j;
                }
            }
            int t=array[maxIndex];
            array[maxIndex]=array[array.length-i-1];
            array[array.length-i-1]=t;
        }
    }


    public static void bulleSort(int[] array){
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length-i-1;j++){
                if (array[j]>array[j+1]){
                    int t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
    }


    public static void heapSort(int[] array){
        createHeap(array);

        for (int i=0;i<array.length;i++){
            swap(array,0,array.length-1-i);
            shiftDown(array,array.length-i-1,0);
        }
    }


    private static void shiftDown(int[] array,int heapLength,int index){
       int parent=index;
       int left=2*parent+1;
       while (left<heapLength){
           if (left+1<heapLength&&array[left+1]>array[left]){
               left=left+1;
           }
           if (array[left]>array[parent]){
               swap(array,left,parent);
           }else{
               break;
           }
           parent=left;
           left=2*left+1;
       }
    }

    private static void swap(int[] array, int i, int j) {
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }


    private static void createHeap(int[] array) {
        for (int i=(array.length-1-1)/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }
    }

//快速排序
    public static void quickSort(int[] array){
        quickSortHelper(array,0,array.length-1);
    }


    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index=partition(array,left,right);
        quickSortHelper(array,left,index-1);
        quickSortHelper(array,index+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int base=array[right];
        int i=left;
        int j=right;
        while (i<j){
            while (i<j&&array[i]<=base) {
                i++;
            }
            while (i < j && array[j] >= base) {
                j--;
            }
            swap(array,i,j);
        }
        swap(array,i,right);
        return i;
    }


    public static void mergeSort(int[] array){
        mergeSortHelper(array,0,array.length);

    }
    private static void mergeSortHelper(int[] array,int low,int high){
        if (low>=high-1){
            return;
        }
        int mid=(high+low)/2;
        mergeSortHelper(array,low,mid);
        mergeSortHelper(array,mid,high);
        merge(array,low,mid,high);
    }

    private static void merge(int[] array,int low,int mid,int high){
        int i=low;
        int j=mid;
        int length=high-low;
        int[] ret=new int[length];
        int k=0;
        while (i<mid && j<high){
            if (array[i]<=array[j]){
                ret[k++]=array[i++];
            }else{
                ret[k++]=array[j++];
            }
        }
        while (i<mid){
            ret[k++]=array[i++];
        }
        while (j<high){
            ret[k++]=array[j++];
        }
        for (int t=0;t<length;t++){
            array[low+t]=array[t];
        }
    }


    public static void main(String[] args) {
        int[] array={2,1,4,0,6,0,8,3};
        //insert(array);
        //shellSort(array);
        //selectSort(array);
        //bulleSort(array);
        //heapSort(array);
        //quickSort(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}


