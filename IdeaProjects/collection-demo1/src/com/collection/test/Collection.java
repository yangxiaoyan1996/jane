//package com.collection.test;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//
///**
// * @Authou YXY
// * @Date 2018/10/18 15:53
// */
//public class Collection {
//
//    public static ArrayList<Character>  getContainer(){
//        ArrayList<Character> array = new ArrayList<>();
//        for (char i='a';i<='z';i++){
//            array.add(i);
//        }
//        for (char i='A';i<='Z';i++){
//            array.add(i);
//        }
//        for (char i='0';i<='9';i++){
//            array.add(i);
//        }
//        return array;
//    }
//    public static String getRandomString(ArrayList<Character> arrayList){
//        HashSet<Character>  characters = new HashSet<>();
//        while (characters.size()<10) {
//            int index = (int) (Math.random()*arrayList.size());
//            characters.add(arrayList.get(index));
//        }
//        //遍历HashSet
//        String string = "";
//        for (int i=0;i<characters.size();i++){
//            string +=  characters;
//        }
//        return string;
//    }
//    public static ArrayList<String> getRandomStrings(ArrayList<Character> arrayList){
//        HashSet<String> hashSet = new HashSet<>();
//        while (hashSet.size()<10){
//            hashSet.add(getRandomString(arrayList));
//        }
//        ArrayList<String> arrayList1 = new ArrayList<>();
//        arrayList1.addAll(hashSet);
//        return arrayList1;
//    }
//
//
//    public static void main(String[] args) {
//        ArrayList<Character> list1 = getContainer();
//        ArrayList<String> list2 = getRandomStrings(arrayList);
//        for (String string:list2) {
//            System.out.println(string);
//        }
//    }
//}
