package main;

import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in);

	int choose = 0;
	String name = "";
	int age = 0;
	String flightType = "";
	String departure = "";
	String destination = "";
	String classTicket = "";
	int basePrice = 0;
	double priceMultiplier = 0;
	double totalPrice = 0;

	public Main() {

		Menu();

	}

	public void Menu() {

		do {
			System.out.println("traFleX Airline");
			System.out.println("1. Let's travel");
			System.out.println("2. Exit");
			System.out.print("Choose : ");
			choose = scan.nextInt();
			scan.nextLine();
		} while (choose > 2 || choose < 1);

		if (choose == 1) {
			FirstChoice();
		} else if (choose == 2) {
			System.exit(0);
		}

	}

	public void FirstChoice() {

		do {
			System.out.print("Input customer name: ");
			name = scan.nextLine();
		} while (name.length() < 1 || name.length() > 50);

		do {
			System.out.print("Input age [min. 1]: ");
			try {
				age = scan.nextInt();
			} catch (Exception e) {
				age = -1;
			}
			scan.nextLine();
		} while (age < 1);

		do {
			System.out.print("Input flight type [Domestic | International]: ");
			flightType = scan.nextLine();
		} while (!(flightType.equals("Domestic") || flightType.equals("International")));

		do {
			System.out.print("Input departure city [4..20]: ");
			departure = scan.nextLine();
		} while (departure.length() < 4 || departure.length() > 20);

		do {
			System.out.print("Input desrination city [4..20]: ");
			destination = scan.nextLine();
		} while (destination.length() < 4 || destination.length() > 20 || destination.equals(departure));

		do {
			System.out.print("Select flight class ticket [Eco | Silver | Prime]: ");
			classTicket = scan.nextLine();
		} while (!(classTicket.equals("Eco") || classTicket.equals("Silver") || classTicket.equals("Prime")));

		if (classTicket.equals("Eco")) {
			basePrice = 150000;
		} else if (classTicket.equals("Silver")) {
			basePrice = 275000;
		} else if (classTicket.equals("Prime")) {
			basePrice = 600000;
		}

		if (flightType.equals("Domestic")) {
			priceMultiplier = 1;
		} else if (flightType.equals("International")) {
			priceMultiplier = 1.75;
		}
		
		if (age < 12 || age > 60) {
			totalPrice = ((departure.length() + destination.length()) * (double) basePrice * priceMultiplier)
					* ((double)(100 - 5) / 100);
		} else {
			totalPrice = (departure.length() + destination.length()) * (double) basePrice * priceMultiplier;
		}
		
		System.out.println("");
		System.out.println("traFleX Airlines");
		System.out.println("================");
		System.out.println("");

		System.out.println("Customer Name: " + name);
		System.out.println("Age          : " + age);
		System.out.println("Depatrute    : " + departure);
		System.out.println("Destination  : " + destination);
		System.out.println("Ticket Class : " + classTicket);
		System.out.println("Total Price  : " + totalPrice);

		System.out.println("");

		System.out.println("-Bon Voyage-");
		System.out.println("Have a nice trip!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		Menu();

	}

	public static void main(String[] args) {
		new Main();

	}

}
