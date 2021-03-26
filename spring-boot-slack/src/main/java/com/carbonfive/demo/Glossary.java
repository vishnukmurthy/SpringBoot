package com.carbonfive.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Glossary {

    private static Glossary singleton = new Glossary();
    private HashMap<String, String> map;


    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Glossary() {
        map = new HashMap<>();
        map.put("String1", "String2");
    }

    /* Static 'instance' method */
    public static Glossary getInstance( ) {
        return singleton;
    }

    public static String getGlossary(String s1){
        if(!getInstance().map.containsKey(s1)) {
            return "";
        } else {
            return getInstance().map.get(s1);
        }
    }

    public static String setGlossary(String s1, String s2){
        getInstance().map.put(s1, s2);
        return "String " + s1 + "has been added to glossary";
    }

    //TODO maybe move out of glossary class into a parser class
    public static List<String> parseData(String s1){
        List<String> res = new ArrayList<>();
        int index = 0;
        for(int i = 0; i <s1.length(); i++){
            if(s1.charAt(i) == ':'){
                index = i;
            }
        }
        if(index == 0){
            return res;
        }
        String acr = s1.substring(0, index);
        String def = s1.substring(index+1, s1.length());
        res.add(acr);
        res.add(def);

        return res;
    }


    /* Other methods protected by singleton-ness */
    protected static void demoMethod( ) {
        System.out.println("demoMethod for singleton");
    }
}