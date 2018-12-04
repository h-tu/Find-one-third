package cmsc351f18;

// Java program to implement Max Heap
public class MaxHeap {
    private int[] Heap;
    private int size;
    private int compare;
    private int maxsize;

    // Constructor to initialize an
    // empty max heap with given maximum
    // capacity.
    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        this.compare = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // A recursive function to max heapify the given
    // subtree. This function assumes that the left and
    // right subtrees are already heapified, we only need
    // to fix the root.
    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            compare ++;
            if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
                compare ++;
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public boolean full(){
        return !(size < maxsize) ;
    }

    // Inserts a new element to max heap
    public void insert(int element) {
        Heap[++size] = element;
        // Traverse up and fix violated property
        update();
    }

    public void print() {
        if(size == 1){
            System.out.print(" ROOT : " + Heap[1] + " \n");
        }
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " ");
            if(size > (2*i) && Heap[2 * i] !=  0){
                System.out.print(" LEFT CHILD : " + Heap[2 * i] + " ");
            }
            if(size > (2*i + 1) && (Heap[2 * i + 1] !=  0) && size >= 3){
                System.out.print(" RIGHT CHILD : " + Heap[2 * i + 1] + " ");
            }
            System.out.println();
        }
    }

    private void update(){
        int current = size;
        while (current > 1) {
            if(Heap[current] > Heap[parent(current)]){
                swap(current, parent(current));
            }
            current --;
        }
        maxHeapify(1);
    }

    // Remove an element from max heap
    public int extractMax() {
        int popped = Heap[1];
        Heap[1] = Heap[size];
        Heap[size] = 0;
        size --;
        update();
        return popped;
    }

    public int getRoot(){
        return Heap[1];
    }
    public int getComp() { return this.compare; }
    public int getSize(){
        return size;
    }

    public static void main(String[] arg) {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(500);
        maxHeap.insert(300);
        maxHeap.insert(100);

        maxHeap.print();

        maxHeap.insert(200);

        System.out.println("\nThe Max Heap is ");
        maxHeap.print();

        maxHeap.extractMax();
        System.out.println("\nThe Max Heap is ");
        maxHeap.print();

    }
}