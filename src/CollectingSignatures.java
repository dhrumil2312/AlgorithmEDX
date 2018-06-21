import java.util.*;

class Helper implements Comparator<List<Integer>>{

    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
        if (o1.get(1) > o2.get(1)) return 1;
        return -1;
    }
}

public class CollectingSignatures {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Helper help = new Helper();

        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> segments = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            ArrayList<Integer> current = new ArrayList<>();
            current.add(start);
            current.add(end);

            segments.add(current);
        }

        Stack<Integer> points = new Stack<>();


        segments.sort(help);
        points.push(segments.get(0).get(1));


        for(int i = 1 ; i < segments.size() ; i++){
            System.out.println(points.peek() + "  " + segments.get(i).get(0) + "  " + points.peek() + "  " + segments.get(i).get(1));
            if(points.peek() < segments.get(i).get(0) || points.peek() > segments.get(i).get(1)){
                points.add(segments.get(i).get(1));
            }
        }

        for(int i : points){
            System.out.println(i);
        }

        System.out.println(points.size());

    }
}
