package com.company;

class MyClass2 {

    //find the longest sequence of spaces
    void function1(){
        String str = "a df  dfef   dsfdf fsdf  sfd f";
        String str2 = " ";
        int k = 0;
        for (int i = 1; i < str.length(); i++) {
            if(str.contains(str2)){
                k = i;
            }
            str2 = str2 + " ";
        }
        System.out.println(str);
        System.out.println("the biggest sequence " + k);
    }

    //add symbol 'b' after all symbols 'a'
    void function2(){
        String str = "asabtrareatfdaafa";
        System.out.println("was " + str);
        str = str.replaceAll("a", "ab");
        System.out.println("now " + str);
    }

    //check if the word palindrome
    void function3(){
        String str = "absba";
        String str2 = new StringBuffer(str).reverse().toString();
        if (str.equals(str2)){
            System.out.println(str + " is palindrome");
        } else {
            System.out.println(str + " is not palindrome");
        }
    }

    //coping and concat, create a word from another
    void function4(){
        String str = "информатика";
        String str2 = "";
        str2 = str2.concat(str.substring(7,8));
        str2 = str2.concat(str.substring(3,5));
        str2 = str2.concat(str.substring(7,8));
        System.out.println(str2);
    }

    //count symbol 'a'
    void function5(){
        String str = "asabtrareatfdaafa";
        System.out.print(str);
        int count = 0;
        while (str.contains("a")){
            count++;
            str = str.replaceFirst("a", "b");
        }
        System.out.println(" contains 'a' " + count + " times");
    }

    //make new string with duplicating each symbol
    void function6(){
        String str = "arty";
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            str2 = str2.concat(str.substring(i,i+1));
            str2 = str2.concat(str.substring(i,i+1));
        }
        System.out.println(str);
        System.out.println(str2);
    }

    //delete all spaces and duplicated symbols of string
    void function7(){
        String str = "aa bc dgbas ewq  ioppoik";
        System.out.println("was: " + str);
        String str2 = "";
        str = str.replaceAll(" ", "");
        while (str.length() > 0){
            str2 = str2.concat(str.substring(0,1));
            str = str.replaceAll(str.substring(0,1), "");
        }
        System.out.println("now: " + str2);
    }

    //find the longest word
    void function8(){
        String str = "1 22 333 4444 22 55555 333";
        System.out.println(str);
        String[] mass = str.split(" ");
        int max = mass[0].length();
        str = mass[0];
        for (int i = 1; i < mass.length; i++) {
            if (mass[i].length() > max){
                str = mass[i];
                max = mass[i].length();
            }
        }
        System.out.println("the longest is " + str);
    }

    //count english upper and lower case letters
    void function9(){
        String str = "en_aaaABCDe_ru_ЯЯЯАААааа";
        System.out.println(str);
        int countLower = 0;
        int countUpper = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 96 && str.charAt(i) < 123){
                countLower++;
            }
            if (str.charAt(i) > 64 && str.charAt(i) < 91){
                countUpper++;
            }
        }
        System.out.println("Upper " + countUpper + " Lower " + countLower);
    }

    //count sentences ended with '!' '?' '.'
    void function10(){
        String str = "aaa?bbb?cc?d.f.r.t!yy!u!" ;
        System.out.println(str);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 33 || ch == 63 || ch == 46){
                count++;
            }
        }
        System.out.println(count);
    }

}
