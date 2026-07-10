package day9;

public class MinLenSubStrViaSW {
    public static String minWindow(String s, String t) {
        char[] cht = t.toCharArray();
        int[] map = new int[128];
        for (char c : cht) {
            map[c]++;
        }
        int count = 0;
        int r = 0, l = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        char[] chs = s.toCharArray();
        while (r < chs.length) {
            if (map[chs[r++]]-- > 0) {
                count++;
            }
            while (count == t.length()) {
                if (r - l < minLen) {
                    minLen = r - l;
                    minStart = l;
                }
                if (map[chs[l++]]++ == 0) {
                    count--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : new String(chs, minStart, minLen);
    }
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
        System.out.println(minWindow("a", "a"));               // Output: "a"
        System.out.println(minWindow("a", "aa"));              // Output: ""
        System.out.println(minWindow("bascf", "ac"));
    }
}
