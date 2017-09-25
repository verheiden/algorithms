package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class timeConversion
{
    static public void main(String args[])
    {
        Scanner reader = new Scanner(System.in);
        String time = reader.next();
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm:ssaa");
            SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = inputFormat.parse(time);
            String output = outputFormat.format(date);
            System.out.println("24Hour time is " + output);
        } catch (ParseException e)
        {
            System.out.println("There was a parsing exception on the time input");
            System.exit(-1);
        }
    }
}
