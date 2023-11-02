package Anagram;

public class Main {


    public static void main(String[] args) {
        System.out.println(isAnagram("eat", "tan"));
    }

//    public static boolean isAnagram(String s, String t){
//        if(s.length() != t.length()){
//            return false;
//        }
//        int[] count = new int[26];
//        for(int i = 0; i < s.length(); i++){
//            count[s.charAt(i) - 'a']++;
//            count[t.charAt(i) - 'a']--;
//        }
//        for(int i =0; i < s.length(); i++){
//            if(count[i] != 0){
//                return false;
//            }
//        }
//
//        return true;
//    }

    // Alternative method that generates unique key for an anagram
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.length() == 0) {
            return false;
        }
        char[] hashListS = new char[26];
        char[] hashListT = new char[26];
        for (int i = 0; i < s.length(); i++) {
            hashListS[s.charAt(i) - 'a']++;
            hashListT[t.charAt(i) - 'a']++;
        }
        return new String(hashListS).equals(new String(hashListT));
    }

}