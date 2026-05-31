// Author: Shahin Naafia S
// College: Sona College of Technology
// Internship: CodSoft Java Development Internship
// Task 2: Student Grade Calculator

import java.util.Scanner;

public class StudentGrade {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        System.out.println("*********************************************");
        System.out.println("     STUDENT GRADE CALCULATOR                ");
        System.out.println("       By Shahin Naafia S                    ");
        System.out.println("*********************************************");

        System.out.print("\nEnter Student Name: ");
        String studentName = inputReader.nextLine();

        System.out.print("How many subjects? : ");
        int subjectCount = inputReader.nextInt();

        int[] marksArray = new int[subjectCount];
        int totalMarks = 0;

        System.out.println("\nEnter marks out of 100 for each subject:");
        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Subject " + (i + 1) + " Marks: ");
            marksArray[i] = inputReader.nextInt();
            totalMarks += marksArray[i];
        }

        double avgPercentage = (double) totalMarks / subjectCount;
        String finalGrade;
        String remark;

        if (avgPercentage >= 90) {
            finalGrade = "A+";
            remark = "Outstanding Performance!";
        } else if (avgPercentage >= 80) {
            finalGrade = "A";
            remark = "Excellent Work!";
        } else if (avgPercentage >= 70) {
            finalGrade = "B";
            remark = "Good Job!";
        } else if (avgPercentage >= 60) {
            finalGrade = "C";
            remark = "Average Performance.";
        } else if (avgPercentage >= 50) {
            finalGrade = "D";
            remark = "You Passed. Work Harder!";
        } else {
            finalGrade = "F";
            remark = "Failed. Please Improve.";
        }

        System.out.println("\n*********************************************");
        System.out.println("  RESULT FOR: " + studentName);
        System.out.println("*********************************************");
        System.out.println("  Total Marks     : " + totalMarks + " / " + (subjectCount * 100));
        System.out.println("  Average         : " + String.format("%.2f", avgPercentage) + "%");
        System.out.println("  Grade           : " + finalGrade);
        System.out.println("  Remark          : " + remark);
        System.out.println("*********************************************");

        inputReader.close();
    }
}