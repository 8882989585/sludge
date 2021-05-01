package leetcode.daily010721mar;

import java.util.HashMap;

public class SingleRowKeyboard {

    public int calculateTime(String keyboard, String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0;
        for(char ch:keyboard.toCharArray()) {
            map.put(ch, i);
            i++;
        }
        i = 0;
        int j=0;
        for(char ch:word.toCharArray()) {
            i += Math.abs(map.get(ch) - j);
            j = map.get(ch);
        }
        return i;
    }
}
