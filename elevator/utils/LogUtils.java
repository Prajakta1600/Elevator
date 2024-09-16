package com.gr.elevator.utils;

public class LogUtils {
public static boolean isLogEnabled = true;

    public static void printLog(String s){
        if(isLogEnabled){
            System.out.printf(s);
        }
    }
}
