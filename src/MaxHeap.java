import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private final List<Item> heap;
    public MaxHeap(Item[] items){
        heap = new ArrayList<>();
        for(Item i:items){
            add(i);
        }
        makeHeap();
    }

    private void makeHeap(){
        for (int i = (heap.size()/2)-1; i >=0 ; i--) {
            downwardHeapify(i);
        }
    }
    public void add(Item item){
        heap.add(item);
        upwardHeapify(heap.size()-1);
    }

    public Item deleteMax(){
        if (heap.isEmpty()){
            return null;
        }
        Item max = heap.get(0);
        if(heap.size()>1){
            Item tail = heap.get(heap.size()-1);
            heap.set(0,tail);
            heap.remove(heap.size()-1);
            downwardHeapify(0);
        }else{
            heap.remove(0);
        }
        return max;
    }
    private void upwardHeapify(int i){
        if(i==0){
            return;
        }
        int parent = (i -1)/2;
        if(heap.get(i).getFactor() > heap.get(parent).getFactor()){
            swap(i, parent);
            upwardHeapify(parent);
        }
    }
    private void downwardHeapify(int i){
        int size = heap.size();
        int max = i;
        int lc = 2*i + 1;
        int rc = 2*i +2;
        if(lc<size && heap.get(lc).getFactor() > heap.get(max).getFactor()){
            max = lc;
        }
        if(rc<size && heap.get(rc).getFactor() > heap.get(max).getFactor()){
            max = rc;
        }
        if(max != i){
            swap(i, max);
            downwardHeapify(max);
        }
    }
    private void swap(int a, int b){
        Item temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }
}
