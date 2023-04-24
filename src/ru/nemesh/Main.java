package ru.nemesh;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите ФИО");
        Scanner scanner = new Scanner(System.in);
        String fio = null;
        
        fio = scanner.nextLine();


        String result = Poisk.poiskfio(fio);

        System.out.println("Найдены сайты" + result);
	// write your code here
    }
}
