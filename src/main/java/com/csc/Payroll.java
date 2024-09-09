package com.csc;
import java.util.Scanner;

public class Payroll {

    public static double calculateGrossPay(double HoursWorked) {
        double HourlyRate = 16.78;
        double Overtime = 1.5;
        double RegularHours = 40.0;

        if (HoursWorked <= RegularHours) {
            return HoursWorked * HourlyRate;
        } else {
            double RegularPay = RegularHours * HourlyRate;
            double OverHours = HoursWorked - RegularHours;
            double OvertimePay = OverHours * HourlyRate * Overtime;
            return RegularPay + OvertimePay;
        }
    }

    public static double calculateInsurance(int numDependents) {
        double insuranceWith3MoreDependents = 35.00;
        double insuranceWithLess3Dependents = 15.00;

        if (numDependents >= 3) {
            return insuranceWith3MoreDependents;
        } else {
            return insuranceWithLess3Dependents;
        }
    }

    public static void printPayrollReport(double HoursWorked, double GrossPay, double SSTax, double FedTax,
                                           double StTax, double UnionDues, double InsuranceCost, double NetPay) {
        System.out.println("\nPayroll:\n");
        System.out.printf("   Hours: %6.2f\n", HoursWorked);
        System.out.printf("    Rate: %6.2f $/hr\n", 16.78);
        System.out.printf("   Gross: $%7.2f\n", GrossPay);
        System.out.printf("\n  SocSec: $%6.2f\n", SSTax);
        System.out.printf("  FedTax: $%6.2f\n", FedTax);
        System.out.printf("   StTax: $%6.2f\n", StTax);
        System.out.printf("   Union: $%6.2f\n", UnionDues);
        System.out.printf("     Ins: $%6.2f\n", InsuranceCost);
        System.out.printf("\n     Net: $%7.2f\n", NetPay);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Payroll Calculator!");

        System.out.print("How many hours did you work this week? ");
        double HoursWorked = scan.nextDouble();
        System.out.print("How many dependents do you have? ");
        int numDependents = scan.nextInt();

        double SSTaxRate = 0.06;
        double FedTaxRate = 0.14;
        double StTaxRate = 0.05;
        double UnionDues = 10.00;

        double GrossPay = calculateGrossPay(HoursWorked);
        double SSTax = GrossPay * SSTaxRate;
        double FedTax = GrossPay * FedTaxRate;
        double StTax = GrossPay * StTaxRate;
        double InsuranceCost = calculateInsurance(numDependents);
        double TotalExpenses = SSTax + FedTax + StTax + UnionDues + InsuranceCost;
        double NetPay = GrossPay - TotalExpenses;

        printPayrollReport(HoursWorked, GrossPay, SSTax, FedTax, StTax, UnionDues, InsuranceCost, NetPay);
        System.out.println("Thank you for using the Payroll Calculator!");

        scan.close();
    }
}
