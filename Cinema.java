package cinema;

import java.util.*;
public class Cinema {

    final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Enter the number of rows:");
        int nRows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int nSeats = scan.nextInt();
        char[][] arr = new char[nRows][nSeats];

        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= nSeats; i++) System.out.print(" " + i);
        System.out.println();
        for (int i = 0; i < nRows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < nSeats; j++) {
                arr[i][j] = 'S';
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }

        int nMenu = 5;
        while (nMenu != 0) {
            nMenu = cinemaMenu();
            if (nMenu == 1) {
                showTheSeats(nRows, nSeats, arr);
            } else if (nMenu == 2) {
                buyATicket(nRows, nSeats, arr);
            } else if (nMenu == 3) {
                showStat(nRows, nSeats, arr);
            }
        }

    }

    public static int cinemaMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int choice = new Scanner(System.in).nextInt();
        return choice;

    }

    public static void showTheSeats(int pRows, int pSeats, char[][] array) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= pSeats; i++) System.out.print(" " + i);
        System.out.println();
        for (int i = 0; i < pRows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < pSeats; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }

    public static void buyATicket(int pRows, int pSeats, char[][] array) {
        int placeRow;
        int placeSeat;
        int count;
        do {
            count = 0;
            System.out.println("Enter a row number:");
            placeRow = scan.nextInt();
            System.out.println("Enter a seat number in that row:");
            placeSeat = scan.nextInt();
            if (placeRow < 0 || placeRow > pRows) {
                System.out.println("Wrong input!");
            } else if (placeSeat < 0 || placeSeat > pSeats) {
                System.out.println("Wrong input!");
            } else if (array[placeRow - 1][placeSeat - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
            } else {
                count = 1;
            }
        } while (count == 0);

        array[placeRow - 1][placeSeat - 1] = 'B';

        int price = 0;
        if (pRows * pSeats <= 60) {
            price = 10;
        } else if (placeRow <= pRows / 2) {
            price = 10;
        } else {
            price = 8;
        }
        System.out.println("Ticket price: $" + price);
    }

    public static void showStat(int pRows, int pSeats, char[][] array) {
        int ticketN = 0;
        int currentIncome = 0;
        int totalIn = 0;
        if (pRows * pSeats <= 60) {
            totalIn = 10 * pRows * pSeats;
        } else {
            totalIn = pSeats * ((pRows / 2) * 10 + (pRows - pRows / 2) * 8);
        }
        for (int i = 0; i < pRows; i++) {
            for (int j = 0; j < pSeats; j++) {
                if (array[i][j] =='B') {
                    ++ticketN;
                    currentIncome += getPrice(i + 1, j + 1, pRows, pSeats);
                }
            }
        }
        double allSeats = pRows * pSeats;
        double percentage = ticketN * 100 / allSeats;
        System.out.println("Number of purchased tickets: " + ticketN);
        System.out.printf("Percentage: % .2f%%\n", percentage);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIn);
    }

    public static int getPrice(int cRow, int cSeat, int cRows, int cSeats) {
        int price = 0;
        if (cRows * cSeats <= 60) {
            price = 10;
        } else if (cRow <= cRows / 2) {
            price = 10;
        } else {
            price = 8;
        }
        return price;
    }

}