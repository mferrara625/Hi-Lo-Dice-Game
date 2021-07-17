package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        Die die1 = new Die();
        Die die2 = new Die();
        int highScore = 0;
        int winNum;
        System.out.println("Welcome to HI-LO Dice,\nPlay until you lose!\n");
        for (winNum = 0; true;) {
            die1.roll();
            die2.roll();
            int total = die1.faceUpValue + die2.faceUpValue;

            System.out.println(die1.faceUpValue + " + " + die2.faceUpValue + " = " + (total));
            System.out.println("Will the next number be (h)igher or (l)ower?");
            String input = scanner.next();

            die1.roll();
            die2.roll();
            int newTotal = die1.faceUpValue + die2.faceUpValue;
            if (total == newTotal) {
                System.out.println("same number you lose");
                break;
            }

            boolean isLarger = newTotal > total;
            System.out.println(die1.faceUpValue + " + " + die2.faceUpValue + " = " + (newTotal));
            System.out.println(isLarger ? "Number is higher" : "Number is lower");
            boolean didWin = false;
            if (input.equals("h")) { //guessed higher
                if (isLarger) {
                    didWin = true;
                }
            } else { //guessed lower
                if (!isLarger) {
                    didWin = true;
                }
            }
            System.out.println(didWin ? "you WIN" : "You LOSE");
            if(didWin)
                winNum++;
            System.out.println("Total Wins: " + winNum);
            if (!didWin)
                break;
        }
        if (winNum > highScore){
            highScore = winNum;
            System.out.println("New HighScore!!!  HighScore: " + highScore);
        }
        else {
            System.out.println("HighScore: " + highScore);
        }

            scanner.close();

    }
}