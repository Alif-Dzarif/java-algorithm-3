/*
 * Buatlah Program Sederhana menggunakan Operator, IF dan Array dengan kasus
 * berikut:
 * 
 * Pada sebuah perusahaan dengan tiga golongan Karyawan, yaitu:
 * 
 * Jika Golongan A: Gaji Rp. 5.000.000
 * Jika Golongan B: Gaji Rp. 6.500.000
 * Jika Golongan C: Gaji Rp. 9.500.000
 * 
 * Gaji setiap golongan disimpan pada Array Gaji,
 * 
 * Jika di Input Goloangan A maka akan mengambil Gaji pada Array 0
 * Jika di Input Goloangan B maka akan mengambil Gaji pada Array 1
 * Jika di Input Goloangan C maka akan mengambil Gaji pada Array 2
 * 
 * Buat Persen Array lembur 30, 32, 34,36,38
 * 
 * Jika karyawan tersebut lembur, maka mereka dibayar per-Jam dengan ketentuan
 * sebagai berikut:
 * 
 * Jika Karyawan lembur 1 Jam maka gaji lemburnya 30% (array lembur) dari Gaji
 * Pokok dari Array Gaji sesuai Golongan
 * Jika Karyawan lembur 2 Jam maka gaji lemburnya 32% (array lembur) dari Gaji
 * Pokok dari Array Gaji sesuai Golongan
 * Jika Karyawan lembur 3 Jam maka gaji lemburnya 34% (array lembur) dari Gaji
 * Pokok dari Array Gaji sesuai Golongan
 * Jika Karyawan lembur 4 Jam maka gaji lemburnya 36% (array lembur) dari Gaji
 * Pokok dari Array Gaji sesuai Golongan
 * Jika Karyawan lembur >= 5 Jam maka gaji lemburnya 38% (array lembur) dari
 * Gaji Pokok dari Array Gaji sesuai Golongan
 */

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class CountSalary {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      String[] category = { "A", "B", "C" };
      int[] salary_per_category = { 5_000_000, 6_500_000, 9_500_000 };
      int[] overtime_percentage = { 30, 32, 34, 36, 38 };

      double base_salary = 0;
      double overtime_pay = 0;

      System.out.println(
          "============================================\nSalary Counter\n============================================\n");
      System.out.println("Input Employee Category (Only allowed A | B | C): ");
      String employee_category = scanner.nextLine().toUpperCase();

      if (!Arrays.asList(category).contains(employee_category)) {
        System.out.println("Category " + employee_category + " is invalid");
        System.exit(0);
      }

      System.out.println("Input Overtime Duration (Minimum 1 hour): ");
      double overtime_duration = scanner.nextDouble();

      if (overtime_duration < 1) {
        System.out.println("Minimum overtime duration is 1 hour");
        System.exit(0);
      }

      System.out.println();

      base_salary = salary_per_category[Arrays.asList(category).indexOf(employee_category)];

      if (overtime_duration >= 5) {
        overtime_pay = base_salary * (overtime_percentage[4] / 100.0);
      } else {
        overtime_pay = base_salary * (overtime_percentage[(int) overtime_duration - 1] / 100.0);
      }

      DecimalFormat df = new DecimalFormat("###,###,###,###");

      System.out.println("Base Salary: Rp " + df.format(base_salary));
      System.out.println("Overtime Salary: Rp " + df.format(overtime_pay));
      System.out.println("Total Salary: Rp " + df.format(base_salary + overtime_pay));
    }
  }
}