package com.example.java8.fetures.collections.hashSet;

import java.util.HashSet;

public class HashSet1 {

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("bianca");
        hashSet.add("alex");
        hashSet.add("lara");
        hashSet.add("isabela");
        hashSet.add(null);
        hashSet.add("bianca"); // nao tem duplicado no conjunto. se tentar colocar um repetido, ele nao entra
        hashSet.add("nos");

        // nenhuma garantia de ordem de insercao.. na hora de mostrar pode mostrar em orderm difenente
        //  do que foi inserido
        hashSet.stream().forEach(s -> System.out.println(s));

        System.out.println("\n removendo");
        hashSet.remove("bianca");
        hashSet.stream().forEach(s -> System.out.println(s));

        System.out.println("\n adicionando set em set");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("eu");
        hashSet2.addAll(hashSet);
        hashSet2.stream().forEach(s -> System.out.println(s));

        System.out.println("\n removendo tudo a partir de um outro  set ");
        hashSet2.removeAll(hashSet);
        hashSet2.stream().forEach(s -> System.out.println(s));

        System.out.println("\n removendo com if");
        hashSet.removeIf(s -> {
            if (s != null) {
                return s.contains("a");
            } return Boolean.parseBoolean(null);
        } );
        hashSet.stream().forEach(s -> System.out.println(s));

        System.out.println("\n removendo com filter stream");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("bianca");
        hashSet3.add("alex");
        hashSet.add("lara");
        hashSet3.add("isabela");
        hashSet3.add(null);
        hashSet3.add("bianca"); // nao tem duplicado no conjunto. se tentar colocar um repetido, ele nao entra
        hashSet3.add("nos");

        hashSet3.stream().filter( s -> {
            if (s != null) {
                return !s.contains("a");
            } return true;
        } ).forEach(s -> System.out.println(s));


        System.out.println("\n clear");
        hashSet3.clear();
        hashSet3.stream().forEach(s -> System.out.println(s));
    }
}
