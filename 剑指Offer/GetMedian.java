import java.util.LinkedList;

/**
 * Created by tianze
 * 2019/1/9 15:16
 */
public class GetMedian {

    LinkedList<Integer> data = new LinkedList<>();


    public void Insert(Integer num) {
        for (int i = data.size() - 1; i >= 0 ; i--) {
            if (num >= data.get(i)){
                data.add(i+1,num);
                return;
            }
        }
        data.addFirst(num);
    }

    public Double GetMedian() {
        int mid = data.size();

        if(mid % 2 == 1){
            return (double)data.get(mid / 2);
        }
        else {
            double first = (double) data.get(mid / 2 - 1);
            double second = (double) data.get(mid / 2);

            return (first + second) / 2;
        }
    }

}
