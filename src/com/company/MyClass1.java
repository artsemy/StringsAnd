package com.company;

class MyClass1 {

    //convert from 'camelCase' to 'snake_case'
    void function1(){
        char[][] mass = {{'i', 'n', 't', 'I', 'n', 't'}, {'c', 'h', 'a', 'r', 'C', 'h', 'S', 'h'}};
        char[] mass2;
        for (char[] ch: mass) {
            printChars(ch);
            mass2 = toSnakeCase(ch);
            printChars(mass2);
        }
    }

    //convert to 'snake_case'
    private char[] toSnakeCase(char[] ch){
        char[] res;
        int count = countUpper(ch);
        res = new char[ch.length + count];
        int index = 0;
        res[index++] = ch[0];
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] > 64 && ch[i] < 91){
                res[index++] = '_';
                res[index++] = (char) (ch[i] + 32);
            } else {
                res[index++] = ch[i];
            }
        }
        return res;
    }

    //count added array size
    private int countUpper(char[] ch){
        int res = 0;
        for (char c: ch) {
            if (c > 64 && c < 91){
                res++;
            }
        }
        return res;
    }

    //print array
    private void printChars(char[] chars){
        for (char c: chars) {
            System.out.print(c);
        }
        System.out.println();
    }

    //replace 'word' with 'letter'
    void function2(){
        char[] mass = {'A', 'w', 'o', 'r', 'd', 'A', 'n', 'd', 'w', 'o', 'r', 'L', 'w', 'o', 'r', 'd'};
        printChars(mass);
        char[] res = replaceWord(mass);
        printChars(res);
    }

    //new array with 'letter'
    private char[] replaceWord(char[] chars){
        int count = countReplaces(chars);
        char[] res = new char[chars.length + count*2];
        int index = 0;
        for (int i = 0; i < chars.length-3; i++) {
            if(chars[i] == 'w' && chars[i+1] == 'o' && chars[i+2] == 'r' && chars[i+3] == 'd'){
                res[index++] = 'l';
                res[index++] = 'e';
                res[index++] = 't';
                res[index++] = 't';
                res[index++] = 'e';
                res[index++] = 'r';
                i += 3;
            } else {
                res[index++] = chars[i];
            }
        }
        return res;
    }

    //count replaces for array size
    private int countReplaces(char[] chars){
        int res = 0;
        for (int i = 0; i < chars.length-3; i++) {
            if(chars[i] == 'w' && chars[i+1] == 'o' && chars[i+2] == 'r' && chars[i+3] == 'd'){
                res++;
            }
        }
        return res;
    }

    //count digits in array
    void function3(){
        char[] chars = {'1', 's', '2', '4', 'a', 'o', 'p', '7'};
        printChars(chars);
        int count = 0;
        for (char c: chars) {
            if (c > 47 && c < 58){
                count++;
            }
        }
        System.out.println("number of digits " + count);
    }

    //count numbers in array
    void function4(){
        char[] chars = {'1', 's', '2', '4', 'a', 'o', 'p', '7'};
        printChars(chars);
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 47 && chars[i] < 58){
                count++;
                while (i < chars.length-1 && chars[i+1] > 47 && chars[i+1] < 58){
                    i++;
                }
            }
        }
        System.out.println("number of numbers " + count);
    }

    //delete useless spaces
    void function5(){
        char[] chars = {' ', ' ', 's', '2', ' ' , '4', ' ', ' ', ' ', 'a', ' ', ' ', 'o', ' ', 'p', ' '};
        printChars(chars);
        char[] res = cleanRedundant(chars);
        res = cleanBorder(res);
        printChars(res);
    }

    //clean spaces in center
    private char[] cleanRedundant(char[] chars){
        int count = countSpaces(chars);
        char[] res = new char[chars.length-count];
        count = 0;
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] != ' '){
                res[count++] = chars[i];
            } else if (chars[i+1] != ' '){
                res[count++] = chars[i];
            }
        }
        res[count] = chars[chars.length-1];
        return res;
    }

    //count spaces in line
    private int countSpaces(char[] chars){
        int count = 0;
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] == ' ' && chars[i+1] == ' '){
                count++;
            }
        }
        return count;
    }

    //clean spaces at the beginning and the end
    private char[] cleanBorder(char[] chars){
        char[] res;
        if (chars[0] != ' ' && chars[chars.length-1] != ' '){
            return chars;
        } else if(chars[0] == ' ' && chars[chars.length-1] == ' ') {
            res = new char[chars.length-2];
            for (int i = 1; i < chars.length-1; i++) {
                res[i - 1] = chars[i];
            }
        } else if(chars[0] == ' ' && chars[chars.length-1] != ' ') {
            res = new char[chars.length-1];
            for (int i = 1; i < chars.length; i++) {
                res[i-1] = chars[i];
            }
        } else {
            res = new char[chars.length-1];
            for (int i = 0; i < chars.length-1; i++) {
                res[i] = chars[i];
            }
        }
        return res;
    }

}
