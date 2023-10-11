import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departiment;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	System.out.print("Entre department´s name:");
	String departmentName = sc.nextLine();
	System.out.println("Enter worker data:");
	System.out.println("Name: ");
	String workerName = sc.nextLine();
	System.out.println("Level: ");
	String workerLevel = sc.nextLine();
	System.out.println("base salary: ");
	double baseSalary = sc.nextDouble();
	Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departiment(departmentName)); 
	

	System.out.println("How many contracts to this worker?");
	int n = sc.nextInt();
	for (int i = 0; i < n; i++) {
		System.out.println("Enter worker contract #" + i + "data");
		System.out.print("Date DD/MM/YYYY): ");
		Date contracDate = sdf.parse(sc.next());
		System.out.println("value per hour: ");
		double valuePerHour = sc.nextDouble();
		System.out.print("Duration (hours): ");
		int hours = sc.nextInt();
		HourContract contract = new HourContract(contracDate, valuePerHour, hours);
		worker.addContract(contract);
	}
	
	
	System.out.println("");
	System.out.print("Enter month and year to cauculate income (MM/YYYY): ");
	String monthAndYear = sc.next();
	int month = Integer.parseInt(monthAndYear.substring(0, 2));
	int year = Integer.parseInt(monthAndYear.substring(3));
	System.out.println("Name: " + worker.getName());
	System.out.println("Departament: " + worker.getDepartment().getName() );
	System.out.println("Income for: " + monthAndYear + ":" + String.format("%.2f", worker.income(year, month)));
	
	
	sc.close();

	}

}
