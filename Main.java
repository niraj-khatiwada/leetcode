
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    private static class BooleanHashHash{
        boolean isAnagram;
        int hash1;
        int hash2;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("ab", "ba").isAnagram);
        System.out.println(isAnagram("ab", "ba").hash1);
        System.out.println(isAnagram("ab", "ba").hash2);
    }

    public static BooleanHashHash isAnagram(String s, String t){
        BooleanHashHash booleanHashHash = new BooleanHashHash();

        int[] count = new int[26];

        char[] hashListS = new char[26];
        char[] hashListT = new char[26];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;

            hashListS[s.charAt(i) - 'a']++;
            hashListT[t.charAt(i) - 'a']++;
        }
        booleanHashHash.hash1 = new String(hashListS).hashCode();
        booleanHashHash.hash2 = new String(hashListT).hashCode();
        if(s.length() != t.length()){
            booleanHashHash.isAnagram=false;
            return booleanHashHash;
        }

        for(int i =0; i < s.length(); i++){
            if(count[i] != 0){
                booleanHashHash.isAnagram=false;
                return booleanHashHash;
            }
        }

        booleanHashHash.isAnagram= true;
        return booleanHashHash;
    }

}