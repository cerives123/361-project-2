public class Knapsack {
    private static final double MAX_WEIGHT = 67.0;
    private static final double[][] DATA = {
            {0,23,505},
            {1,26,352},
            {2,20,458},
            {3,18,220},
            {4,32,354},
            {5,27,414},
            {6,29,498},
            {7,26,545},
            {8,30,473},
            {9,27,543}
    };

    public static void greedyValue(){
        int dataSize = DATA.length;
        Item[] itemList = new Item[dataSize];
        for (int i = 0; i < dataSize; i++) {
            int id = (int)  DATA[i][0];
            double weight = DATA[i][1];
            double value = DATA[i][2];
            itemList[i]= new Item(id,value,weight,value);
        }
        StringBuilder sb = new StringBuilder();
        MaxHeap itemHeap = new MaxHeap(itemList);
        sb.append("Value Based Greedy Algorithm\n").append("Selected Items:\n");
        double currentWeight=0.0;
        double currentValue=0.0;
        while(!itemHeap.isEmpty()){
            Item temp = itemHeap.deleteMax();
            if(currentWeight+ temp.getWeight()<=MAX_WEIGHT){
                sb.append(temp.toString()).append("\n");
                currentValue+=temp.getValue();
                currentWeight+=temp.getWeight();
            }
        }
        sb.append("Total Weight: ").append(currentWeight).append("\n").append("Total Value: ").append(currentValue).append("\n");
        System.out.println(sb);
    }
    public static void greedyWeight(){
        int dataSize = DATA.length;
        Item[] itemList = new Item[dataSize];
        for (int i = 0; i < dataSize; i++) {
            int id = (int)  DATA[i][0];
            double weight = DATA[i][1];
            double value = DATA[i][2];
            itemList[i]= new Item(id,value,weight,-weight);
        }
        StringBuilder sb = new StringBuilder();
        MaxHeap itemHeap = new MaxHeap(itemList);
        sb.append("Weight Based Greedy Algorithm\n").append("Selected Items:\n");
        double currentWeight=0.0;
        double currentValue=0.0;
        while(!itemHeap.isEmpty()){
            Item temp = itemHeap.deleteMax();
            if(currentWeight+ temp.getWeight()<=MAX_WEIGHT){
                sb.append(temp.toString()).append("\n");
                currentValue+=temp.getValue();
                currentWeight+=temp.getWeight();
            }
        }
        sb.append("Total Weight: ").append(currentWeight).append("\n").append("Total Value: ").append(currentValue).append("\n");
        System.out.println(sb);
    }
    public static void greedyRatio(){
        int dataSize = DATA.length;
        Item[] itemList = new Item[dataSize];
        for (int i = 0; i < dataSize; i++) {
            int id = (int)  DATA[i][0];
            double weight = DATA[i][1];
            double value = DATA[i][2];
            double ratio = value/weight;
            itemList[i]= new Item(id,value,weight,ratio);
        }
        StringBuilder sb = new StringBuilder();
        MaxHeap itemHeap = new MaxHeap(itemList);
        sb.append("Ratio Based Greedy Algorithm\n").append("Selected Items:\n");
        double currentWeight=0.0;
        double currentValue=0.0;
        while(!itemHeap.isEmpty()){
            Item temp = itemHeap.deleteMax();
            if(currentWeight+ temp.getWeight()<=MAX_WEIGHT){
                sb.append(temp.toString()).append("\n");
                currentValue+=temp.getValue();
                currentWeight+=temp.getWeight();
            }
        }
        sb.append("Total Weight: ").append(currentWeight).append("\n").append("Total Value: ").append(currentValue).append("\n");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        greedyValue();
        greedyWeight();
        greedyRatio();
    }

}
