/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noiseremoving;

/**
 *
 * @author xhu
 * 
 * @student William Wang
 * @id 18017970
 * 
 * @question1 Is the quick sort the best way of finding the median? Why?
 *      No, because the quick sort is not stable, 
 *      which means the order of the elements with the same value may be changed. 
 *      and the time complexity of the quick sort is O(nlogn), it could be O(n^2) in the worst case.
 *      The quick sort is not suitable for finding the median.
 * 
 * @question2 what is another good way of finding the median? provide
 *            explanation.
 *      In this case, sorting the array just for finding the median value.
 *      there is another algorithm which is called median of medians, 
 *      it cuts the array into smaller arrays to find the median of each array,
 *      then find the median of the medians to get the median of the whole array.
 *      This algorithm is more efficient than sorting the whole array.
 *      So, the median of medians algorithm will be more suitable in this case.
 *      
 *      In the other hand, if the sorting is necessary.
 *      the merge sort algorithm will be more suitable than the quick sort.
 *      Because the merge sort is stable and the time complexity is O(nlogn).
 *      it wont be effect by the distribution of data, 
 *      so it would have less difference between the best case and the worst case.
 *      
 * 
 */
public class SortArray<E extends Comparable> {

    E[] array;

    public SortArray(E[] array) {
        this.array = array;
    }

    public void setArray(E[] array) {
        this.array = array;
    }

    public void quickSort() {
        quickSort(0, array.length - 1);
    }

    private void quickSort(int left, int right) {
        // stop the recursion when the left index is greater than or equal to the right
        // index
        // which means there is only one element in the array
        if (left >= right) {
            return;
        }

        int privotIndex = partition(left, right); // get the pivot index

        quickSort(left, privotIndex - 1); // sort the left part
        quickSort(privotIndex + 1, right); // sort the right part
    }

    private int partition(int left, int right) {
        E pivot = this.array[left]; // set the pivot to the first element
        int low = left + 1; // this is the left index, start from the second element.
        int hight = right; // this is the right index

        // loop until the left index is greater than the right index
        // then the left index is the pivot index
        // all the elements on the left side of the pivot are less than the pivot
        // all the elements on the right side of the pivot are greater than the pivot
        while (low <= hight) {
            // find the element which is greater than the pivot
            while (low <= hight && this.array[low].compareTo(pivot) <= 0) {
                low++; // move the left index to the right
            }

            // find the element which is less than the pivot
            while (low <= hight && this.array[hight].compareTo(pivot) >= 0) {
                hight--; // move the right index to the left
            }

            //make sure the left index is less than the right index
            if (low < hight) { 
                swap(low, hight); // swap the value of left index and right index
            } 
        }

        //swap the position of the pivot and the right index
        swap(left, hight);

        return hight;

    }

    private void swap(int index1, int index2) { // swap the value of index1 and index2

        E temp = this.array[index1]; // store the value of index1
        this.array[index1] = this.array[index2]; // assign the value of index2 to index1
        this.array[index2] = temp; // assign the value of index1 to index2
    }
}
