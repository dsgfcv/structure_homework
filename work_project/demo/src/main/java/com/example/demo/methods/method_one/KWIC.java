package com.example.demo.methods.method_one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;

import com.example.demo.result.Result;

public class KWIC {
    private static ArrayList<String> kwicList = new ArrayList<String>();
    private static ArrayList<String> lineTxt = new ArrayList<String>();
    private static BufferedReader inputFile;

    public static Result<String> process(){
        System.out.println("start processing......");
        input("work_project\\demo\\src\\main\\java\\com\\example\\demo\\methods\\method_one\\input.txt");
        shift();
        alphabetizer();
        Result<String> res = output();
        System.out.println("result is: \n" + res);
        return res;
    }

    public static void input(String fileName) {
        try {
            inputFile = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = inputFile.readLine()) != null) {
                lineTxt.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Result<String> output(){
        // Iterator<String> it = kwicList.iterator();
        // try {
        //     outputFile = new BufferedWriter(new FileWriter(filename));
        //     while (it.hasNext()) {
        //         outputFile.write(it.next()+"\n");
        //     }
        // }catch (IOException e){
        //     e.printStackTrace();
        // }finally {
        //     try {
        //         if (outputFile!=null) {
        //             outputFile.close();
        //         }
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // }
        String res = "";
        Iterator<String> it = kwicList.iterator();
        while (it.hasNext()) {
            res += it.next() + "\n";
        }
        return Result.success(res);
    }

    public static void shift() {
        Iterator<String> it = lineTxt.iterator();
        while (it.hasNext()) {
            StringTokenizer token = new StringTokenizer(it.next());
            ArrayList<String> tokens = new ArrayList<String>();
            int i = 0;
  
            int count = token.countTokens();
            while (i < count) {
                tokens.add(token.nextToken());
                i++;
            }

            for (i = 0; i < count; i++) {
                StringBuffer lineBuffer = new StringBuffer();
                int index = i;
                for (int f = 0; f < count; f++) {
               
                    if (index >= count)
                        index = 0;
                    lineBuffer.append(tokens.get(index));
                    lineBuffer.append(" ");
                    index++;
                }
                String tmp = lineBuffer.toString();
                kwicList.add(tmp);
            }
        }

    }


    public static void alphabetizer() {
        Collections.sort(kwicList, new AlphabetizerComparator());
    }

    private static class AlphabetizerComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null && o2 == null) {
                throw new NullPointerException();
            }
            int compareValue = 0;
            char o1c = o1.toLowerCase().charAt(0); 
            char o2c = o2.toLowerCase().charAt(0); 
            compareValue = o1c - o2c;
            return compareValue;
        }

    }
}
