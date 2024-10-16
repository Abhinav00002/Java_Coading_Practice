package HashMaps;

import java.util.HashMap;

public class CharacterFrequency {
    public static void main(String[] args) {
        String str="Hello World";
        HashMap<Character, Integer> frequencyMap=new HashMap<>();
        for (char s : str.toCharArray()) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s,0)+1);
        }
        System.out.println(frequencyMap);
    }
}
