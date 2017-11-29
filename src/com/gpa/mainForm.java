/*
    Created By: Elliot J Scribner on 11/24/17
 */

package com.gpa;

import sun.nio.cs.ext.MacThai;

import javax.swing.*;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm {
    private JPanel mainPanel;
    private JButton submit;
    private JTextField grade1;
    private JTextField grade2;
    private JTextField grade3;
    private JTextField grade4;
    private JTextField grade5;
    private JTextField grade6;
    private JTextField grade7;
    private JTextField cred1;
    private JTextField cred2;
    private JTextField cred3;
    private JTextField cred4;
    private JTextField cred5;
    private JTextField cred6;
    private JTextField cred7;


    public mainForm() {
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] grades = {grade1.getText(), grade2.getText(), grade3.getText(), grade4.getText(), grade5.getText(), grade6.getText(), grade7.getText()};
                String[] credits = {cred1.getText(), cred2.getText(), cred3.getText(), cred4.getText(), cred5.getText(), cred6.getText(), cred7.getText()};
                double myGPA = avgGPA(grades, credits);
                myGPA = Math.round(myGPA*100.00);
                myGPA = myGPA/100.00;
                JOptionPane.showMessageDialog(null, "Your GPA is: " + myGPA);
            }
        });
    }

    public static double avgGPA(String[] grades, String[] credits) {
        double points = 0;
        double totalCredits = 0;
        double avg;
        for(int j = 0; j < grades.length; j++) {
            String currGrade = grades[j];
            Double currGradeNum = letToNum(currGrade);
            credits = creditErrors(credits);
            int currCreds = Integer.parseInt(credits[j]);
            if(currGradeNum != -40.0) {
                for (int i = 0; i < grades.length; i++) {
                    points += currGradeNum*currCreds;
                    totalCredits = totalCredits+currCreds;
                }
            }
        }
        avg = points/totalCredits;
        return avg;
    }

    public static String[] creditErrors(String[] credits) {
        for(int i = 0; i < credits.length; i++) {
            try {
                int val = Integer.parseInt(credits[i]);
            } catch (NumberFormatException e) {
                credits[i] = "0";
            }
        }
        return credits;
    }



    public static double letToNum(String grade) {
        double numGrade = 0;
        if(grade.equalsIgnoreCase("A")) {
            numGrade = 4.0;
        }else if(grade.equalsIgnoreCase("A-")) {
            numGrade = 3.7;
        }else if(grade.equalsIgnoreCase("B+")) {
            numGrade = 3.3;
        }else if(grade.equalsIgnoreCase("B")) {
            numGrade = 3.0;
        }else if(grade.equalsIgnoreCase("B-")) {
            numGrade = 2.7;
        }else if(grade.equalsIgnoreCase("C+")) {
            numGrade = 2.3;
        }else if(grade.equalsIgnoreCase("C")) {
            numGrade = 2.0;
        }else if(grade.equalsIgnoreCase("C-")) {
            numGrade = 1.7;
        }else if(grade.equalsIgnoreCase("D+")) {
            numGrade = 1.3;
        }else if(grade.equalsIgnoreCase("D")) {
            numGrade = 1.0;
        }else if(grade.equalsIgnoreCase("D-")) {
            numGrade = 0.7;
        }else if(grade.equalsIgnoreCase("F")) {
            numGrade = 0.0;
        }else {
            numGrade = -40.0;
        }

        return numGrade;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("frame");
        frame.setContentPane(new mainForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
