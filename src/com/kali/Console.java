package com.kali;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Console {
    private static double balance;
    private final List<Origin> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Little shark accounting system >> ");
        Console con = new Console();
        con.showPanel();
        System.out.println("User " +"");
        System.out.println("Please enter an operation option: for example  1");
        Scanner scan = new Scanner(System.in);
        process(con,scan);
    }

    public static void process(Console con,Scanner scan){
        while (true) {
            int i;

            try {
                /*对i可能出现的输入异常处理，任何初次进入系统的错误指令都将重置为主页信息*/
                i = Integer.parseInt(scan.next());
            }catch (NumberFormatException e){
                i = 4;
            }

            if (i >= 1 && i <= 5) {
                switch (i) {
                    case 1:
                        System.out.println("Accounting details of revenue and expenditure of small shark");
                        con.showBill();
                        System.out.println("———————————————————————————————————————————————");
                        System.out.println("(Enter 2 to register revenue\tEnter 3 to register expenses\tEnter 4 to exit the system)");
                        break;
                    case 2:
                        System.out.println("———————Small shark registration income——————————");
                        try {
                            con.addIncome(scan);
                        }catch (InputMismatchException e){
                            System.out.println("————————————————Please re register————————————————");
                        }
                        System.out.println("—————————————————————————————————————————————————");
                        System.out.println("(Enter 1 to view the details)");
                        break;
                    case 3:
                        System.out.println("—————Small shark registration expenditure—————");
                        con.addOutput(scan);
                        System.out.println("———————————————————————————————————————————");
                        System.out.println("————————Enter 1 to view the details————————");
                        break;
                    case 4:
                        System.out.println("———————————————————Homepage————————————————————");
                        con.showPanel();
                        System.out.println("———————————————————————————————————————————————");
                        break;
                    case 5:
                        System.out.println("—————————————Thank you for using!——————————————");
                        return;
                    default:
                        break;
                }
            }
        }
    }

    public void addOutput(Scanner scan){
        try {
            System.out.println("—————————————————————————————————————————————");
            System.out.println("——————————Register this expenditure——————————");
            double output = Double.parseDouble(scan.next());
            balance -= output;
            System.out.println("——————————Statement of expenditure————————————");
            String description =scan.next();
            list.add(new Output(output,balance,description));
        }catch (Exception e){
            addOutput(scan);
        }

    }

    public void addIncome(Scanner scan){
        try {
            System.out.println("——————————Register this income——————————————————");
            double income = Double.parseDouble(scan.next());
            balance += income;
            System.out.println("——————————Income statement——————————————————————");
            String description =scan.next();
            list.add(new Income(income,balance,description));
        }catch (Exception e){
            System.out.println("——————————Please re register—————————————————————");
            addIncome(scan);
        }
    }

    public void showBill(){
        if(list.size() != 0){
            for(Origin o : list){
                System.out.println(o);
            }
        }else{
            System.out.println("                                           ");
            System.out.println("                 No Record                 ");
            System.out.println("                                           ");
        }

    }

    public void showPanel(){
        System.out.println("——————————Welcome to this billing system——————");
        System.out.println("  1 Income statement");
        System.out.println("  2 Registered income");
        System.out.println("  3 Registered expenditure");
        System.out.println("  4 Homepage");
        System.out.println("  5 Sign out");
        System.out.println("———————————————————————————————————————————————");
    }
}
