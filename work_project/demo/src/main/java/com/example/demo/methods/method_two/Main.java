package com.example.demo.methods.method_two;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.input("homework\\method_two\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("homework\\method_two\\output.txt");
    }
}
