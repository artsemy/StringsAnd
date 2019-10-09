package com.company;

public class Main {

    public static void main(String[] args) {
        //char array
//        part1();
        //work with 'String'
//        part2();
        //regular expressions
//        part3();
    }

    private static void part1(){
        MyClass1 myClass1 = new MyClass1();
        //convert from 'camelCase' to 'snake_case'
        myClass1.function1();
        //replace 'word' with 'letter'
        myClass1.function2();
        //count digits in array
        myClass1.function3();
        //count numbers in array
        myClass1.function4();
        //delete useless spaces
        myClass1.function5();
    }

    private static void part2(){
        MyClass2 myClass2 = new MyClass2();
        //find the longest sequence of spaces
        myClass2.function1();
        //add symbol 'b' after all symbols 'a'
        myClass2.function2();
        //check if the word palindrome
        myClass2.function3();
        //coping and concat, create a word from another
        myClass2.function4();
        //count symbol 'a'
        myClass2.function5();
        //make new string with duplicating each symbol
        myClass2.function6();
        //delete all spaces and duplicated symbols of string
        myClass2.function7();
        //find the longest word
        myClass2.function8();
        //count english upper and lower case letters
        myClass2.function9();
        //count sentences ended with '!' '?' '.'
        myClass2.function10();
    }

    private static void part3(){
        MyClass3 myClass3 = new MyClass3();
        //sort paragraphs by number of sentences
        myClass3.function1a();
        //sort words in sentences by length
        myClass3.function1b();
        //sort word by number of chosen symbol, with same number sort by alphabet
        myClass3.function1c();
        //parse xml: open tag, close tag, tag content
        myClass3.function2();
    }
    
}
