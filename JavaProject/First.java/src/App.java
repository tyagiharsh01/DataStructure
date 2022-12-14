import java.util.TreeSet;

public class App{
        public static boolean[] map = new boolean[26];
        public static String[] keymap = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};


        public static void printCombination(String str, int idx, String newString) {
            if (str.length() == idx) {
                System.out.println(newString);
                return;
            }
            char currchar = str.charAt(idx);
            String mapping = keymap[currchar - '0'];
            for (int i = 0; i < mapping.length(); i++) {
                printCombination(str, idx + 1, newString + mapping.charAt(i));
            }
        }

        public static void moveAllX(String str, int idx, int count, String newString) {
            if (idx == str.length()) {
                for (int i = 0; i < count; i++) {
                    newString += 'x';
                }
                System.out.println(newString);
                return;
            }
            if (str.charAt(idx) == 'a') {
                count++;
                moveAllX(str, idx + 1, count, newString);
            } else {
                newString += str.charAt(idx);
                moveAllX(str, idx + 1, count, newString);
            }
        }

        public static boolean isSorted(int[] arr, int idx) {
            if (idx == arr.length - 1) {
                return true;
            }
            if (arr[idx] < arr[idx + 1]) {
                return isSorted(arr, idx + 1);
            } else {
                return false;
            }
        }

        public static void subSequences(String str, int idx, String newString, TreeSet<String> stringTreeSet) {
            if (idx == str.length()) {
                if (stringTreeSet.contains(newString)) {
                    return;
                } else {
                    System.out.println(newString);
                    stringTreeSet.add(newString);
                    return;
                }
            }
            char currentChar = str.charAt(idx);
            subSequences(str, idx + 1, newString + currentChar, stringTreeSet);
            subSequences(str, idx + 1, newString, stringTreeSet);
        }

        public static void remove(String str,int idx,String newString) {
            if(idx==str.length()) {
                System.out.println(newString);
                return;
            }
            char currchar = str.charAt(idx);
            if(map[currchar-'a']) {
                remove(str,  idx + 1,newString);
            }
            else {
                newString +=currchar;
                map[currchar-'a']=true;
                remove(str,idx+1,newString);
            }
    
        }
        public static void main(String[] args) {
            int arr[] = {1, 2, 3, 4, 5};
            System.out.println(isSorted(arr, 0));
            String str = "46";
            TreeSet<String> stringTreeSet= new TreeSet<>();
            printCombination(str, 0, "");
            
  }
 }
    

