package PACKAGENAME;

public class MartianOracle {
    final private int m_totalSize;
	private int curr, k, comp;
	private MinHeap minHeap;
	private MaxHeap maxHeap;

	public MartianOracle(int size) {
		m_totalSize = size;
		comp = 0;
    		curr = 0;
		minHeap = new MinHeap(2*m_totalSize/3 + 1);
		maxHeap = new MaxHeap(m_totalSize/3 + 1);
		k = 0;
	}

	public void process(int value) {
		k ++;
		if(maxHeap.full()){
		    	comp ++;
			if(value < maxHeap.getRoot()){
				minHeap.insert(maxHeap.extractMax());
				maxHeap.insert(value);
			}
			else{
				minHeap.insert(value);
			}
		}
		else{
			if(curr == 0){
                		comp ++;
				if(value > minHeap.getRoot()){
					minHeap.insert(value);
					maxHeap.insert(minHeap.extractMin());
				}
				else{
					maxHeap.insert(value);
				}
				curr ++;
			}
			else{
				maxHeap.insert(value);
				minHeap.insert(maxHeap.extractMax());
				curr ++;
				if(curr == 3){
					curr = 0;
				}
			}
		}
//		System.out.println(" --- insert " + value + " --- " );
//		System.out.println("The Max Heap is ");
//		maxHeap.print();
//		System.out.println("The Min Heap is ");
//		minHeap.print();
	}
	
	public int query() {
		int result;
		int want = (k + 2)/3;
		if(want == maxHeap.getSize()){
			result = maxHeap.getRoot();
		}
		else{
			result = maxHeap.getRoot();
		}
//		System.out.println(" --- k = " + k );
//		System.out.println(" --- Want: (" + k + " + 2) / 3 " );
//		System.out.println(" --- " + (k + 2) + " / 3 = " + want);
//		System.out.println("The Max Heap is ");
//		maxHeap.print();
//		System.out.println("The Min Heap is ");
//		minHeap.print();
		return result;
	}

	public int getTotal(){
	    return (comp + minHeap.getComp() + maxHeap.getComp());
    }
}
