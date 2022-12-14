package com.Harsh;

public class Main {
    public static void Permuation(String str,String permutation){
        if(str.length()==0){
            System.out.println(permutation);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currnchar = str.charAt(i);
            String string = str.substring(0,i)+str.substring(i+1);
            Permuation(string,permutation+currnchar);

        }

    }
    public static int countPaths(int i,int j,int m,int n){
        if(i==n||j==m){
            return 0;
        }
        if(i==n-1&&j==m-1){
            return 1;
        }
        int downpaths=countPaths(i+1,j,n,m);
        int rightpaths = countPaths(i,j+1,n,m);
        return downpaths+rightpaths;
    }
    public static int placetiles(int n,int m){
        if(n<m){
            return 1;
        }
        if(n==m){
            return 2;
        }
        int vertical = placetiles(n-m,m);
        int horizontel= placetiles(n-1,m);
        return vertical+horizontel;
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
        String str = "abc";
        Permuation(str,"");
        int m =2, n =4;
        System.out.println(placetiles(n,m));
    }
}
