import java.util.Scanner;

public class StudentResultSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input student details
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        int subjects = 5;           // fixed number of subjects
        int totalMarks = 0;
        boolean isFail = false;

        // Loop to accept marks
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = sc.nextInt();

            // Input validation
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Enter marks between 0 and 100.");
                i--; // repeat same subject
                continue;
            }

            // Fail condition
            if (marks < 35) {
                isFail = true;
            }

            totalMarks += marks;
        }

        // Calculate percentage
        double percentage = totalMarks / (double) subjects;

        // Determine grade using if-else
        char grade;
        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 75) {
            grade = 'B';
        } else if (percentage >= 60) {
            grade = 'C';
        } else if (percentage >= 35) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Result
        String result = (isFail || grade == 'F') ? "FAIL" : "PASS";

        // Grade description using switch
        String gradeMessage;
        switch (grade) {
            case 'A':
                gradeMessage = "Excellent";
                break;
            case 'B':
                gradeMessage = "Very Good";
                break;
            case 'C':
                gradeMessage = "Good";
                break;
            case 'D':
                gradeMessage = "Needs Improvement";
                break;
            default:
                gradeMessage = "Fail";
        }

        // Formatted output
        System.out.println("\n----- STUDENT RESULT -----");
        System.out.printf("Name        : %s%n", name);
        System.out.printf("Roll No     : %d%n", roll);
        System.out.printf("Total Marks : %d / 500%n", totalMarks);
        System.out.printf("Percentage  : %.2f%%%n", percentage);
        System.out.printf("Grade       : %c (%s)%n", grade, gradeMessage);
        System.out.printf("Result      : %s%n", result);

        sc.close();
    }
}
