import java.util.HashMap;
import java.util.Iterator;

public class ShortestCompletingWord {

    static int compareHashMap(HashMap<Character,Integer> hashMap1 , HashMap<Character,Integer> hashMap2){

        int ans = 0;

        //Iterator it = hashMap1.keySet().iterator();
        int charsFound  = 0;

        for(Character c : hashMap1.keySet()){
            int count1 = hashMap1.get(c);
            int count2 = hashMap2.getOrDefault(c,0);
            if(count2>0) charsFound++;
            if (count2 > count1){
                ans += 0;
            }
            else{
                ans += count1 - count2;
            }
            hashMap2.remove(c);
        }


        //System.out.println(charsFound +"  " + hashMap1.size());
        if(charsFound == hashMap1.size()) return ans;
        else return Integer.MAX_VALUE;
    }

    static HashMap<Character,Integer> convertToHashMap (String s){
        char[] chars = s.toCharArray();

        HashMap<Character,Integer> result = new HashMap<>();

        for(int i = 0 ; i < chars.length ; i++){
            if (Character.isAlphabetic(chars[i])) result.put(chars[i],result.getOrDefault(chars[i],1)+1);
        }

        return result;
    }

    static String shortestCompletingWord(String licensePlate, String[] words){

        HashMap<Character, Integer> hashLicense = convertToHashMap(licensePlate.toLowerCase());

        int minIndex = 0;
        int diff = 0;
        int minDiff = 345234533;
        int minLength = Integer.MAX_VALUE;

        for(int i = 0 ; i < words.length ; i++){
            String currentString = words[i];
            HashMap<Character, Integer> currentMap = convertToHashMap(currentString.toLowerCase());
            diff =  compareHashMap(hashLicense,currentMap);
            System.out.println(currentString + "  " + currentString.length() + "  " + minLength + "  " + diff + "  " + minDiff);
            if(diff < minDiff || (diff == minDiff && currentString.length() < minLength )){
                minIndex = i;
                minDiff = diff;
                minLength = currentString.length();
            }
        }

        return words[minIndex];
    }

    public static void main(String[] args) {

        String licensePlate = "T713264";
        String[] words = {"executive","suffer","product","language","manager","thought","various","attention","how","medical"};


        System.out.println(shortestCompletingWord( licensePlate, words));

    }
}
