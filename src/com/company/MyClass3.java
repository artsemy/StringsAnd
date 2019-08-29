package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MyClass3 {

    void function1a(){
        String fileName = "./resources/text";
        String str = readFile(fileName);
        System.out.println(str);
        String[] mass = str.split("\\r\\n\\s+");
        mass[0] = mass[0].trim();
        Arrays.sort(mass, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int l1 = o1.split("[\\.\\?\\!]\\s+").length;
                int l2 = o2.split("[\\.\\?\\!]\\s+").length;
                return Integer.compare(l1, l2);
            }
        });
        System.out.println("------------------------");
        for (String s: mass) {
            System.out.println("\t" + s);
        }
    }

    private String readFile(String name){
        String res = "";
        Path path = Paths.get(name);
        try (Scanner scanner = new Scanner(path)) {
            if (scanner.hasNext()){
                res = res.concat(scanner.nextLine());
            }
            while (scanner.hasNext()) {
                res = res.concat("\r\n" + scanner.nextLine());
            }
        } catch (IOException ignored) {
        }
        return res;
    }

    void function1b(){
        String fileName = "./resources/text";
        String str = readFile(fileName);
        System.out.println(str);
        Pattern pattern = Pattern.compile("\\S+[\\.\\?\\!]");
        Matcher matcher = pattern.matcher(str);
        int start = 0;
        while (matcher.find()){
            int end = matcher.end()-1;
            String str2 = str.substring(start, end);
            String str3 = sortSent(str2);
            str = str.replace(str2.trim(), str3);
            start = matcher.end()+1;
        }
        System.out.println("----------------");
        System.out.println(str);
    }

    private String sortSent(String str){
        String res = "";
        String[] mass = str.split("\\s+");
        Arrays.sort(mass, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int l1 = o1.length();
                int l2 = o2.length();
                return Integer.compare(l1, l2);
            }
        });
        for (String s: mass) {
            res = res + " " + s;
        }
        res = res.trim();
        return res;
    }

    void function1c(){
        char c = 'e';
        String fileName = "./resources/text";
        String str = readFile(fileName);
        System.out.println(str);
        Pattern pattern = Pattern.compile("\\S+[\\.\\?\\!]");
        Matcher matcher = pattern.matcher(str);
        int start = 0;
        while (matcher.find()){
            int end = matcher.end()-1;
            String str2 = str.substring(start, end);
            String str3 = sortSent2(str2, c);
            str = str.replace(str2.trim(), str3);
            start = matcher.end()+1;
        }
        System.out.println("----------------");
        System.out.println(str);
    }

    private String sortSent2(String str, char c){
        String res = "";
        String[] mass = str.split("\\s+");
        Arrays.sort(mass, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int l1 = countLetter(o1, c);
                int l2 = countLetter(o2, c);
                if(l1 != l2){
                    return Integer.compare(l1, l2);
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        for (String s: mass) {
            res = res + " " + s;
        }
        res = res.trim();
        return res;
    }

    private int countLetter(String str, char c){
        int k = 0;
        char[] mass = str.toCharArray();
        for (char l: mass) {
            if (l == c){
                k++;
            }
        }
        return k;
    }

    void function2(){
        String fileName = "./resources/text2.xml";
        String str = readFile(fileName);
//        System.out.println(str);
        str = normalize(str);
//        System.out.println(str);
        Pattern pattern = Pattern.compile("<[^<>/]+>");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            int start = matcher.end();
            String s = matcher.group();
            String s2 = getTagName(s);
            int end = str.indexOf(s2, start) - 2;
            System.out.println(s);
            System.out.println("</" + s2 + ">");
            System.out.println(str.substring(start, end));
        }
    }

    private String normalize(String str){
        Pattern pattern = Pattern.compile("<[^<>]+/>");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            String s = matcher.group();
            String s2 = stringToReplace(s);
            str = str.replace(s, s2);
        }
        return str;
    }

    private String stringToReplace(String str){
        String res, s1;
        s1 = str.substring(1, str.length()-2);
        res = "<" + s1 + ">" + "</" + s1 + ">";
        return res;
    }

    private String getTagName(String str){
        String res;
        res = str.substring(1, str.length()-1);
        res = res.split(" ")[0];
        return res;
    }
}
