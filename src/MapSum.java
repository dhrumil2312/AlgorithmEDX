import java.util.HashMap;

public class MapSum {

    HashMap<String,Integer> hashMap;

        /** Initialize your data structure here. */
        public MapSum() {
            hashMap = new HashMap<>();
        }

        public void insert(String key, int val) {
            hashMap.put(key,hashMap.getOrDefault(key,0)+val);
        }

        public int sum(String prefix) {
            int ans = 0;
            for(String s: hashMap.keySet() ){
                if(s.startsWith(prefix)){
                    ans+= hashMap.get(s);
                }
            }
            return ans;
        }

}
