package com.company;

import java.io.BufferedWriter;
import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException{
        int n;
        Random r = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of the questions");
        n = input.nextInt();
        File file1 = new File("Exercises.txt");
        if (!file1.exists()) {
            file1.createNewFile();
        }
        File file2 = new File("Answers.txt");
        if (!file2.exists()) {
            file2.createNewFile();
        }
        BufferedWriter out1 = new BufferedWriter(new FileWriter(file1.getAbsoluteFile()));
        BufferedWriter out2 = new BufferedWriter(new FileWriter(file2.getAbsoluteFile()));
        Set<String> st = new HashSet<>();
        int i = 0;
       while(i < n){
            int m = r.nextInt(2);
            int num1 = r.nextInt(100) + 1;
            int answer = num1;
            String ques = Integer.toString(num1);
            for(int j = 0;j <= m ;++j){
                int num2 = r.nextInt(100) + 1;
                int sign = r.nextInt(2);
                if(answer < num2 && sign != 0){
                    sign -= 1;
                }
                if (sign == 0) {
                    answer += num2;
                    ques = ques + '+' + num2;
                }
                if (sign == 1) {
                    answer -= num2;
                    ques = ques + '-' + num2;
                }
            }
            if(st.contains(ques) || answer >= 100 || answer == 0){
                continue;
            }
            st.add(ques);
            out1.write( (i + 1) + "---" +ques + "\n");
            out2.write( (i + 1) + "---" + answer + "\n");
            i++;
        }
        out1.close();
        out2.close();
    }
}