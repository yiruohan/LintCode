import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;

public class Solution384 {
    public static int lengthOfLongestSubstring(String s) {
        // write your code here
        char[] chars = s.toCharArray();
        if(chars.length<=1) {
            return chars.length;
        }
        int max = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int min = 0;
        for(int i=0; i<chars.length; i++) {
            if(hashMap.containsKey(chars[i])) {
                if(hashMap.size()>max) {
                    max = hashMap.size();
                }
                for(int j=min; j<hashMap.get(chars[i]); j++) {
                    hashMap.remove(chars[j]);
                }
                min = hashMap.get(chars[i])+1;
                hashMap.remove(chars[i]);
            }
            hashMap.put(chars[i],i);
        }
        if(hashMap.size()>max) {
            max = hashMap.size();
        }
        return max;
    }

    public static int lengthOfLongestSubstring1(String s) {
        // write your code here
        char[] chars = s.toCharArray();
        if(chars.length<=1) {
            return chars.length;
        }
        int max = 1;
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add(chars[0]);
        int start = 0;
        int end = 1;
        char c = chars[0];
        boolean isRepeat = false;
        int maxLen = 1;
        while(end<chars.length && start<=end) {
            if(isRepeat) {
                if(chars[start]!=c) {
                    hashSet.remove(chars[start]);
                }else{
                    isRepeat = false;
                    maxLen = end-start-1;
                }
                start++;
            }else{
                if(hashSet.contains(chars[end])) {
                    if(maxLen>max) {
                        max = maxLen;
                    }
                    c = chars[end];
                    isRepeat = true;
                }else{
                    hashSet.add(chars[end]);
                    maxLen++;
                }
                end++;
            }
        }
        if(maxLen>max) {
            max = maxLen;
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // write your code here
        char[] chars = s.toCharArray();
        if(chars.length<=1) {
            return chars.length;
        }

        HashMap<Character,Integer> hashMap = new HashMap<>();
        int max = 1;
        int begin = 0;
        int end = 0;
        for(char c : chars) {
            if(hashMap.containsKey(c) && hashMap.get(c)==1) {
                while(chars[begin]!=c) {
                    hashMap.put(chars[begin++],0);
                }
                begin++;
            }else{
                hashMap.put(c,1);
            }
            end++;
            if(end-begin>max) {
                max = end-begin;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {
        // write your code here
        char[] chars = s.toCharArray();
        if(chars.length<=1) {
            return chars.length;
        }

        HashMap<Character,Integer> hashMap = new HashMap<>();
        int max = 1;
        int begin = 0;
        for(int i=0; i<chars.length;i++) {
            if(hashMap.containsKey(chars[i])) {
                begin = Math.max(begin,hashMap.get(chars[i])+1);
            }
            max  = Math.max(max,i-begin+1);
            hashMap.put(chars[i],i);
        }
        return max;
    }

    public static int lengthOfLongestSubstring4(String s) {
        // write your code here
        if(s.length()<=1) {
            return s.length();
        }

        HashMap<Character,Integer> hashMap = new HashMap<>();
        int max = 1;
        int begin = 0;
        for(int i=0; i<s.length();i++) {
            if(hashMap.containsKey(s.charAt(i))) {
                begin = Math.max(begin,hashMap.get(s.charAt(i))+1);
            }
            max  = Math.max(max,i-begin+1);
            hashMap.put(s.charAt(i),i);
        }
        return max;
    }

    public int lengthOfLongestSubstring5(String s) {
        // write your code here
        int[] count = new int[256];
        Arrays.fill(count, -1);

        int start = 0;
        int lenMax = 0;

        for(int i=0; i<s.length(); i++) {
            if(count[s.charAt(i)] >= start) {
                lenMax = Math.max(lenMax, i - start);
                start = count[s.charAt(i)] + 1;
            }
            count[s.charAt(i)] = i;
        }

        return Math.max(lenMax, s.length() - start);

