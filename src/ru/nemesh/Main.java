package ru.nemesh;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("������� ���");
        Scanner scanner = new Scanner(System.in);
        String fio = null;
        
        fio = scanner.nextLine();


        String result = Poisk.poiskfio(fio);

        System.out.println("������� �����" + result);
	// write your code here
    }
}
