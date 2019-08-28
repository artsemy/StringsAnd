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
//        System.out.println(str);
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
        String fileName = "./resources/text";
        String str = readFile(fileName);
        System.out.println(str);
    }
}
