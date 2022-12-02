package com.example.java8.fetures.functionalInterfaces.staticmethod;

public class MyDataImpl implements MyData {

//    public boolean isNull(String str) {
//        System.out.println("Impl Null Check");
//
//        return str == null ? true : false;
//    }

    public static void main(String args[]){
        MyDataImpl obj = new MyDataImpl();
        obj.print("");
        //obj.isNull("abc");
        MyData.isNull("abc");
    }

    @Override
    public void accept(String texto) {
        
    }
}
