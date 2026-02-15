package dev.recursion;

public class Recursion5 {

    public static int first = -1;
    public static int last = -1;

    public static void towerOfHanoi(int n, String src , String helper, String dest){

        if(n==1){
            System.out.println("transferred disk " + n + " from "+ src + " to : "+ dest);
            return;
        }

        towerOfHanoi(n-1,src,dest,helper);
        System.out.println("transferred disk " + n + " from "+ src + " to : "+ dest);
        towerOfHanoi(n-1,helper,src,dest);



    }

    public static void getIndices(String str, char el, int idx){
        if(str.length() == idx){
            return;
        }
        if(str.charAt(idx)==el){
            if(first == -1){
                first = idx;

            } else {
                last = idx;

            }

        }
        getIndices(str,el,idx+1);


    }

    public static String addX(int count) {
        String newStr = "x";
        for(int i=1;i<count; i++) {
            newStr += 'x';
        }
        return newStr;
    }
    public static String moveAllX(String str, int idx, int count) {
        if(idx == str.length()) {
            return addX(count);
        }
        if(str.charAt(idx) == 'x') {

            return moveAllX(str, idx+1, count+1);
        } else {
            String nextStr = moveAllX(str, idx+1, count);
            return str.charAt(idx) + nextStr;
        }
    }


    public static void main(String[] args) {
       int n = 3;

  //     towerOfHanoi(n,"A","B","C");
//
//        String str = "tabcdfghijakkk";
//        char el = 'a';
//        getIndices(str, el, 0);
//        System.out.println("First occurence : " + first);
//        System.out.println("Last occurence : " + last);

        String str = "abcdefxghxixjxxxk";
        int count = 0;
        String newStr = moveAllX(str, 0, count);
        System.out.println(newStr);
    }
}
