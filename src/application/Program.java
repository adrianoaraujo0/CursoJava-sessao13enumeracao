package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.println("Enter department's name:");
		String departamentName = sc.nextLine();

		System.out.println("Enter worker data:");

		System.out.println("Name: ");
		String workerName = sc.nextLine();

		System.out.println("Level: ");
		String workerLevel = sc.nextLine();

		System.out.println("Base salary:");
		Double baseSalary = sc.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Departament(departamentName));

		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.println("Enter contract #" + (i + 1) + " data:");
			System.out.println("Date (DD/MM/YYYY): ");
			Date contractDate = (Date) sdf.parse(sc.next());

			System.out.println("Value per hour: ");
			Double valuePerHour = sc.nextDouble();

			System.out.println("Duration (hours): ");
			int hours = sc.nextInt();

			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);

		}

		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Departament: " + worker.getDepartament().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

	}

}
