package b;

public class MyHeapSort {
	
	
	public void sort(int [] inputArray) {
		int [] heap=	buildHeap(inputArray);
		for (int i = heap.length-1,j=0; i>0; i--) {
			
			inputArray[j]=heap[1];
			j++;
			heap[1]=heap[i];
			siftDown(heap, 1, i);
		}
	}
	public int [] buildHeap(int [] inputArray) {
		int [] heapToBuild=new int [inputArray.length+1];
		int n=1;
		
		for (; n < heapToBuild.length; n++) {
			heapToBuild[n]=inputArray[n-1];
			siftUp(heapToBuild,n);
		}
		return heapToBuild;
	}
	public void siftUp(int [] heap,int n) {
		if (n==1) {
			return;
		}
		
		while (n>1&&heap[n]>heap[n/2]) {
			swap(heap,n,n/2);
			n=n/2;
		}
	}
	public void siftDown(int [] heap,int n,int maxElementPosition) {
		while(n*2<=maxElementPosition) {
			if (heap[n]<heap[n*2]||heap[n]<heap[n*2+1]) {
				int leftChild=heap[n*2];
				int rightChild;
				if (n*2+1>maxElementPosition) {
					rightChild=Integer.MIN_VALUE;
				} else {
					rightChild=heap[n*2+1];
				}
				if (leftChild>rightChild) {
					swap(heap, n, n*2);
					n=n*2;
				}  else {
					swap(heap, n, n*2+1);
					n=n*2+1;
				}
			} else {
				break;
			}
		}
 	
	}
	
	public  void swap(int [] heap,int a,int b) {
		int temp=heap[a];
		heap[a]=heap[b];
		heap[b]=temp;
	}

}
