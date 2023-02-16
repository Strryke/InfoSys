package pset;
import java.util.HashMap;
import java.util.HashSet;


public class StringPset1 {
    public static void main(String[] args) {
        isAllCharacterUnique("asdfasssa");
    }
    public static boolean isAllCharacterUnique(String sIn) {
        HashSet<Character> set = new HashSet<>()	;

        for (int i = 0; i < sIn.length() ; i++) {
            set.add(sIn.charAt(i));
        }
        System.out.println(set);
        return set.size() == sIn.length() ;
    }


//    public static boolean isPermutation(String sIn1, String sIn2) {
//        HashMap<Character,Integer> map1 = new HashMap<>();
//        HashMap<Character,Integer> map2 = new HashMap<>();
//
//
//    }
}
