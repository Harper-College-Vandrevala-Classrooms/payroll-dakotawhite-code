package com.csc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class TestPayroll {

    @Test
    public void testCalculateGrossPay() {
        assertEquals(671.20, Payroll.calculateGrossPay(40), 0.01);
        assertEquals(797.05, Payroll.calculateGrossPay(45), 0.01);
    }

    @Test
    public void testCalculateInsurance() {
        assertEquals(35.00, Payroll.calculateInsurance(3));
        assertEquals(35.00, Payroll.calculateInsurance(4));
        assertEquals(15.00, Payroll.calculateInsurance(2));
    }

    @Test
    public void testPrintPayrollReport() {
        double HoursWorked = 45;
        double GrossPay = Payroll.calculateGrossPay(HoursWorked);
        double SSTaxRate = 0.06;
        double FedTaxRate = 0.14;
        double StTaxRate = 0.05;
        double UnionDues = 10.00;
        int numDependents = 3;
        double InsuranceCost = Payroll.calculateInsurance(numDependents);
        
        double SSTax = GrossPay * SSTaxRate;
        double FedTax = GrossPay * FedTaxRate;
        double StTax = GrossPay * StTaxRate;
        double TotalExpenses = SSTax + FedTax + StTax + UnionDues + InsuranceCost;
        double NetPay = GrossPay - TotalExpenses;

        assertEquals(797.05, GrossPay, 0.01);
        assertEquals(47.82, SSTax, 0.01);
        assertEquals(111.59, FedTax, 0.01);
        assertEquals(39.85, StTax, 0.01);
        assertEquals(10.00, UnionDues, 0.01);
        assertEquals(35.00, InsuranceCost, 0.01);
        assertEquals(552.79, NetPay, 0.01);
    }
}
