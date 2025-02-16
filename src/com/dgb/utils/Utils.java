package com.dgb.utils;

import java.util.Scanner;

public class Utils {
    static Scanner scanner=new Scanner(System.in);
    public static int inputInteger(String introduction){
        do{
            try {
                System.out.print(introduction);
                String option = scanner.nextLine();
                return Integer.parseInt(option);
            }catch (Exception e){
                System.out.println(Constants.INPUT_WRONG_TYPE);
            }
        }while (true);
    }
    public static double inputDouble(String introduction){
        do{
            try {
                System.out.print(introduction);
                String option = scanner.nextLine();
                return Double.parseDouble(option);
            }catch (Exception e){
                System.out.println(Constants.INPUT_WRONG_TYPE);
            }
        }while (true);
    }
    public static void pressKeyEnter(String introduction){
        System.out.println(introduction);
        scanner.nextLine();
    }

    public static String inputString(String instruction) {
        System.out.print(instruction);
        return scanner.nextLine();
    }
}
