package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Checker implements Comparator<List<Float>>{

    @Override
    public int compare(List<Float> o1, List<Float> o2) {
        if (o1.get(2) > o2.get(2)) return -1;
        return 1;
    }
}

public class fractionalKnapsack  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Checker checker = new Checker();

        int n = sc.nextInt();
        ArrayList<ArrayList<Float>> items = new ArrayList<>();
        int m = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            ArrayList<Float> current = new ArrayList<>();
            float value = sc.nextInt();
            float weight = sc.nextInt();
            current.add(value);
            current.add(weight);
            current.add(value/weight);
            items.add(current);
        }
        for(ArrayList<Float> i : items){
            System.out.println(i);
        }

        items.sort(checker);

        for(ArrayList<Float> i : items){
            System.out.println(i);
        }
        int i = 0;
        float ans = 0;

        while(m>0 && i <items.size()){
            float current_value = items.get(i).get(0);
            float current_weight = items.get(i).get(1);
            float perWeightValue = items.get(i).get(2);

            if (m < current_weight){
                ans += perWeightValue*m;
                m =0;
            }
            else{
                ans += current_value;
                m -= current_weight;
            }
            i += 1;
            System.out.println(ans);

        }
        System.out.println(ans);

    }


}
