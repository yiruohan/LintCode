import java.util.HashSet;
import java.util.HashMap;

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

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbb";
        String s3 = "aab";
        String s4 = "abcabcdceba";
        String s5 = "an++--viaj";
        System.out.println(lengthOfLongestSubstring2(s1));
        System.out.println(lengthOfLongestSubstring2(s2));
        System.out.println(lengthOfLongestSubstring2(s3));
        System.out.println(lengthOfLongestSubstring2(s4));
        System.out.println(lengthOfLongestSubstring2(s5));
    }
}

