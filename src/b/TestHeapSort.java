package b;

import java.util.Arrays;

public class TestHeapSort {

	public static void main(String[] args) {
		MyHeapSort aHeapSort=new MyHeapSort();
		
		
		int [] randomArray={1,0,5,7,6};
		aHeapSort.sort(randomArray);
		
//		int [] heap=aHeapSort.buildHeap(randomArray);
//		heap[1]=0;
//		aHeapSort.siftDown(heap, 1, 5);
		System.out.println(Arrays.toString(randomArray));
	}
}
