package com.sourav;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileAccount{

    public void createFile(String filename){
        File myFile  = new File(filename);
        try {
            if(myFile.createNewFile()){
                System.out.println("File Created Successfully."+myFile.getName());
            }else {
                System.out.println("Not");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File Error");
        }
    }

    public void writeFile(String filename){
        String data ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Data");
        data = sc.nextLine();

        try {
            FileWriter output = new FileWriter(filename);
            output.write(data);
            System.out.println("Data is written successfully");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("This is File write error message....");
        }
    }

    public void readFile(String filename){
        char [] data = new char[100];

        try {
            FileReader input = new FileReader(filename);
            input.read(data);
            System.out.println("data Recive from a file");
            System.out.println(data);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File Read Error...");
        }
    }

    public void deleteFile(String filename){
        File myFile  = new File(filename);

        if (myFile.delete()){
            System.out.println("File Deleted Successfully"+myFile.getName());
        }else {
            System.out.println("Fail to delete");
        }
    }



    void showMenu(String filename) {
        char option = '\0';
        try (Scanner scan = new Scanner(System.in)) {


            do {
                System.out.println("enter your choice");
                System.out.println("A. Create");
                System.out.println("B .Read");
                System.out.println("C . Write");
                System.out.println("D . Delete");
                System.out.println("E . Exit");
                option = scan.next().charAt(0);
                System.out.println("\n");

                switch(option) {
                    case 'A' :
                        FileAccount obj1 = new FileAccount();
                        obj1.createFile(filename);
                        break;
                    case 'B' :
                        FileAccount  obj2 = new FileAccount();
                        obj2.readFile(filename);
                        System.out.println("\n");
                        break;
                    case 'C' :
                        FileAccount obj3 = new FileAccount();
                        obj3.writeFile(filename);
                        System.out.println("\n");
                        break;
                    case 'D' :
                        FileAccount obj4 = new FileAccount ();
                        obj4.deleteFile(filename);
                        break;
                    case 'E' :
                        System.out.println("Bye");
                        System.out.println("\n");
                        break;

                    default :
                        System.out.println("Inavlid option");

                }
            }
            while(option != 'E');
        }

        System.out.println("Thankyou for your service");

    }
}


public class FileApplication {

    public static void main(String[] args) {
        String filename;
        Scanner scan = new Scanner(System.in);
        System.out.println("NOTE!!!!!!!!!!!!");
        System.out.println("Enter File name with .txt extension");
        filename=scan.nextLine();
        FileAccount obj1 = new FileAccount();
        obj1.showMenu(filename);
    }
}
