package PACKAGENAME;

public class MinHeap {
    private int[] Heap;
    private int size;
    private int compare;
    private int maxsize;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        this.compare = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >=  (size / 2)  &&  pos <= size) {
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

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            compare ++;
            if ( Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
                compare ++;
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        Heap[++size] = element;
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

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1 ; pos--) {
            minHeapify(pos);
        }
    }

    private void update(){
        int current = size;
        while (current > 1) {
            if(Heap[current] < Heap[parent(current)]){
                swap(current, parent(current));
            }
            current --;
        }
        minHeapify(1);
    }

    public int extractMin() {
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

    public static void main(String...arg) {
        System.out.println("Add your test here");
//         System.out.println("The Min Heap is ");
//         MinHeap minHeap = new MinHeap(15);
//         minHeap.insert(600);
//         minHeap.insert(1000);
//         minHeap.insert(1100);
//         minHeap.insert(800);
//         minHeap.insert(900);
//         minHeap.insert(1200);

//         minHeap.print();

//         minHeap.insert(500);

//         System.out.println("\nThe Min Heap is ");
//         minHeap.print();
    }
}
