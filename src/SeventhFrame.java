import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Random;

public class SeventhFrame {
    Container c;
    JFrame frame;
    JLabel appLabel, generalLabel1,backgroundLabel;
    int q;
    String random,classTeacher1,classTeacher2,classTeacher3,classTeacher4;
    JLabel[][] labelClass1,labelClass2,labelClass3,labelClass4;
    JLabel[] labelDayClass1,labelDayClass2,labelDayClass3,labelDayClass4,facultyLabelClass1,facultyLabelClass2,facultyLabelClass3,facultyLabelClass4;
    JLabel[] labelLectureClass1,labelLectureClass2,labelLectureClass3,labelLectureClass4;
    JButton generateAgainBtn,printTimetableBtn,goToBackPageBtn, goToLoginPageBtn;


    SeventhFrame(String instituteTextField, String departmentTextField, int noOfClasses, int noOfSubjects, String[] storedSubjects, String[] storedCodes, String[] storedCredits, String[] storedObjectives, String[] storedOutcomes, int storedweek, int storeddays, int[] storedAppearances, String[][] storedFaculties) {
        frame = new JFrame();
        frame.setBounds(0, 0, 1920, 1080);
        frame.setTitle("Syllabus and Timetable Management System");
        ImageIcon icon = new ImageIcon("tt.jpg");
        frame.setIconImage(icon.getImage());
        c = frame.getContentPane();
        c.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon img = new ImageIcon("a.jpg");
        backgroundLabel = new JLabel("", img, JLabel.CENTER);
        backgroundLabel.setBounds(0,0,1920,1080);
        c.add(backgroundLabel);
        frame.setVisible(true);

        appLabel = new JLabel("Syllabus and Timetable Management System");
        appLabel.setBounds(460, 0, 800, 50);
        Font f = new Font("Times New Roman", Font.PLAIN, 40);
        appLabel.setFont(f);
        backgroundLabel.add(appLabel);

        String[][] S = new String[storedweek][storeddays],S2 = new String[storedweek][storeddays],S3 = new String[storedweek][storeddays],S4 = new String[storedweek][storeddays];
        String[] F1 = new String[noOfSubjects],F2 = new String[noOfSubjects],F3 = new String[noOfSubjects],F4 = new String[noOfSubjects];
        String[][] F ;


        int[] ap1= new int[storedAppearances.length];//  to store appearances permanently
        int[] ap2= new int[storedAppearances.length];//  to store appearances permanently
        System.arraycopy(storedAppearances, 0, ap1, 0, storedAppearances.length);
        System.arraycopy(storedAppearances, 0, ap2, 0, storedAppearances.length);
        GeneratorClass g = new GeneratorClass();
        Random rd = new Random();
        labelDayClass1 = new JLabel[storedweek];
        labelDayClass2 = new JLabel[storedweek];
        labelDayClass3 = new JLabel[storedweek];
        labelDayClass4 = new JLabel[storedweek];

        labelLectureClass1 = new JLabel[storeddays];
        labelLectureClass2 = new JLabel[storeddays];
        labelLectureClass3 = new JLabel[storeddays];
        labelLectureClass4 = new JLabel[storeddays];

        facultyLabelClass1 = new JLabel[noOfSubjects];
        facultyLabelClass2 = new JLabel[noOfSubjects];
        facultyLabelClass3 = new JLabel[noOfSubjects];
        facultyLabelClass4 = new JLabel[noOfSubjects];

        labelClass1 = new JLabel[storedweek][storeddays];
        labelClass2 = new JLabel[storedweek][storeddays];
        labelClass3 = new JLabel[storedweek][storeddays];
        labelClass4 = new JLabel[storedweek][storeddays];

        if(noOfClasses == 1) {
            S = g.class1(storedweek, storeddays, noOfSubjects, ap1, storedSubjects, S, ap2);
            F1 = g.facultyAssignment1(noOfSubjects, storedFaculties);
            q = rd.nextInt(noOfSubjects);
            random = F1[q];
            classTeacher1 = random;

            appLabel = new JLabel("Timetable for class 1:");
            appLabel.setBounds(250, 90, 800, 30);
            f = new Font("Times New Roman", Font.PLAIN, 14);
            appLabel.setFont(f);
            backgroundLabel.add(appLabel);

            for(int i=0;i<storeddays;i++){
                labelLectureClass1[i] = new JLabel("Lecture "+(i+1));
                labelLectureClass1[i].setBounds(120+80*i,130,80,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelLectureClass1[i].setFont(f);
                backgroundLabel.add(labelLectureClass1[i]);
            }

            for (int i=0;i<storedweek;i++){
                labelDayClass1[i] = new JLabel("Day "+(i+1));
                labelDayClass1[i].setBounds(20,160 +30*i,100,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelDayClass1[i].setFont(f);
                backgroundLabel.add(labelDayClass1[i]);

                for(int j=0; j<storeddays;j++){
                    labelClass1[i][j] = new JLabel(S[i][j]);
                    labelClass1[i][j].setBounds(120+80*j,160 +30*i,80,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    labelClass1[i][j].setFont(f);
                    backgroundLabel.add(labelClass1[i][j]);
                }
            }

            for(int i=0;i<noOfSubjects;i++){
                if(i == 0){
                    generalLabel1= new JLabel("Class Teacher: "+ classTeacher1);
                    generalLabel1.setBounds(920,143,400,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    generalLabel1.setFont(f);
                    backgroundLabel.add(generalLabel1);
                }
                facultyLabelClass1[i] = new JLabel("The faculty assigned for "+storedSubjects[i]+" is "+F1[i]);
                facultyLabelClass1[i].setBounds(920,160+17*i,400,30);
                f = new Font("Times New Roman",Font.PLAIN,14);
                facultyLabelClass1[i].setFont(f);
                backgroundLabel.add(facultyLabelClass1[i]);
            }
        }
        if(noOfClasses == 2 ) {
            S = g.class1(storedweek, storeddays, noOfSubjects, ap1, storedSubjects, S, ap2);
            S2 = g.generateclass(storedweek, storeddays, noOfSubjects, ap1, storedSubjects, S2, S, ap2);
            F = g.facultyAssignment2(noOfSubjects, storedFaculties);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < noOfSubjects; j++) {
                    if (i == 0) {
                        F1[j] = F[i][j];
                    }
                    if (i == 1) {
                        F2[j] = F[i][j];                 // to retrieve the faculties
                    }
                }
            }
            q = rd.nextInt(noOfSubjects);
            random = F1[q];
            classTeacher1 = random;
            q = rd.nextInt(noOfSubjects);
            random = F2[q];
            classTeacher2 = random;

            appLabel = new JLabel("Timetable for class 1:");
            appLabel.setBounds(250, 90, 800, 30);
            f = new Font("Times New Roman", Font.PLAIN, 14);
            appLabel.setFont(f);
            backgroundLabel.add(appLabel);

            for(int i=0;i<storeddays;i++){
                labelLectureClass1[i] = new JLabel("Lecture "+(i+1));
                labelLectureClass1[i].setBounds(120+80*i,130,80,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelLectureClass1[i].setFont(f);
                backgroundLabel.add(labelLectureClass1[i]);
            }

            for (int i=0;i<storedweek;i++){
                labelDayClass1[i] = new JLabel("Day "+(i+1));
                labelDayClass1[i].setBounds(20,160 +30*i,100,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelDayClass1[i].setFont(f);
                backgroundLabel.add(labelDayClass1[i]);

                for(int j=0; j<storeddays;j++){
                    labelClass1[i][j] = new JLabel(S[i][j]);
                    labelClass1[i][j].setBounds(120+80*j,160 +30*i,80,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    labelClass1[i][j].setFont(f);
                    backgroundLabel.add(labelClass1[i][j]);
                }
            }

            for(int i=0;i<noOfSubjects;i++){
                if(i == 0){
                    generalLabel1= new JLabel("Class Teacher: "+ classTeacher1);
                    generalLabel1.setBounds(920,143,400,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    generalLabel1.setFont(f);
                    backgroundLabel.add(generalLabel1);
                }
                facultyLabelClass1[i] = new JLabel("The faculty assigned for "+storedSubjects[i]+" is "+F1[i]);
                facultyLabelClass1[i].setBounds(920,160+17*i,400,30);
                f = new Font("Times New Roman",Font.PLAIN,14);
                facultyLabelClass1[i].setFont(f);
                backgroundLabel.add(facultyLabelClass1[i]);
            }
            // second class
            appLabel = new JLabel("Timetable for class 2:");
            appLabel.setBounds(250, 400, 800, 30);
            f = new Font("Times New Roman", Font.PLAIN, 14);
            appLabel.setFont(f);
            backgroundLabel.add(appLabel);

            for(int i=0;i<storeddays;i++){
                labelLectureClass2[i] = new JLabel("Lecture "+(i+1));
                labelLectureClass2[i].setBounds(120+80*i,440,80,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelLectureClass2[i].setFont(f);
                backgroundLabel.add(labelLectureClass2[i]);
            }

            for (int i=0;i<storedweek;i++){
                labelDayClass2[i] = new JLabel("Day "+(i+1));
                labelDayClass2[i].setBounds(20,470 +30*i,100,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelDayClass2[i].setFont(f);
                backgroundLabel.add(labelDayClass2[i]);

                for(int j=0; j<storeddays;j++){
                    labelClass2[i][j] = new JLabel(S2[i][j]);
                    labelClass2[i][j].setBounds(120+80*j,470 +30*i,80,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    labelClass2[i][j].setFont(f);
                    backgroundLabel.add(labelClass2[i][j]);
                }
            }

            for(int i=0;i<noOfSubjects;i++){
                if(i == 0){
                    generalLabel1= new JLabel("Class Teacher: "+ classTeacher2);
                    generalLabel1.setBounds(920,453,400,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    generalLabel1.setFont(f);
                    backgroundLabel.add(generalLabel1);
                }
                facultyLabelClass2[i] = new JLabel("The faculty assigned for "+storedSubjects[i]+" is "+F2[i]);
                facultyLabelClass2[i].setBounds(920,470+17*i,400,30);
                f = new Font("Times New Roman",Font.PLAIN,14);
                facultyLabelClass2[i].setFont(f);
                backgroundLabel.add(facultyLabelClass2[i]);
            }
        }
        if(noOfClasses == 3){
            S = g.class1(storedweek, storeddays, noOfSubjects, ap1, storedSubjects, S, ap2);
            S2 = g.generateclass(storedweek, storeddays, noOfSubjects, ap1, storedSubjects, S2, S, ap2);   // get automated classes
            S3 = g.generateclass(storedweek, storeddays, noOfSubjects, ap1, storedSubjects, S3, S2, ap2);
            F = g.facultyAssignment3(noOfSubjects, storedFaculties);       // to assign faculties
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < noOfSubjects; j++) {
                    if (i == 0) {
                        F1[j] = F[i][j];
                    }
                    if (i == 1) {
                        F2[j] = F[i][j];                 // to retrieve the faculties
                    }
                    if (i == 2) {
                        F3[j] = F[i][j];
                    }
                }
            }
            q = rd.nextInt(noOfSubjects);   // assigning class teacher of class 2 and 3
            random = F1[q];
            classTeacher1 = random;
            while (true) {
                q = rd.nextInt(noOfSubjects);
                random = F2[q];
                if (!random.equals(classTeacher1)) {
                    classTeacher2 = random;
                    break;
                }
            }
            q = rd.nextInt(noOfSubjects);
            random = F3[q];
            classTeacher3 = random;

            appLabel = new JLabel("Timetable for class 1:");
            appLabel.setBounds(200, 90, 200, 30);
            f = new Font("Times New Roman", Font.PLAIN, 14);
            appLabel.setFont(f);
            backgroundLabel.add(appLabel);

            for(int i=0;i<storeddays;i++){
                labelLectureClass1[i] = new JLabel("Lecture"+(i+1));
                labelLectureClass1[i].setBounds(120+60*i,130,60,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelLectureClass1[i].setFont(f);
                backgroundLabel.add(labelLectureClass1[i]);
            }

            for (int i=0;i<storedweek;i++){
                labelDayClass1[i] = new JLabel("Day "+(i+1));
                labelDayClass1[i].setBounds(20,160 +30*i,100,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelDayClass1[i].setFont(f);
                backgroundLabel.add(labelDayClass1[i]);

                for(int j=0; j<storeddays;j++){
                    labelClass1[i][j] = new JLabel(S[i][j]);
                    labelClass1[i][j].setBounds(120+60*j,160 +30*i,60,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    labelClass1[i][j].setFont(f);
                    backgroundLabel.add(labelClass1[i][j]);
                }
            }

            for(int i=0;i<noOfSubjects;i++){
                if(i == 0){
                    generalLabel1= new JLabel("Class Teacher: "+ classTeacher1);
                    generalLabel1.setBounds(630,130,150,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    generalLabel1.setFont(f);
                    backgroundLabel.add(generalLabel1);
                }
                facultyLabelClass1[i] = new JLabel(storedSubjects[i]+":"+F1[i]);
                facultyLabelClass1[i].setBounds(630,147+17*i,150,30);
                f = new Font("Times New Roman",Font.PLAIN,14);
                facultyLabelClass1[i].setFont(f);
                backgroundLabel.add(facultyLabelClass1[i]);
            }
            // second class
            appLabel = new JLabel("Timetable for class 2:");
            appLabel.setBounds(200, 400, 200, 30);
            f = new Font("Times New Roman", Font.PLAIN, 14);
            appLabel.setFont(f);
            backgroundLabel.add(appLabel);

            for(int i=0;i<storeddays;i++){
                labelLectureClass2[i] = new JLabel("Lecture"+(i+1));
                labelLectureClass2[i].setBounds(120+60*i,440,60,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelLectureClass2[i].setFont(f);
                backgroundLabel.add(labelLectureClass2[i]);
            }

            for (int i=0;i<storedweek;i++){
                labelDayClass2[i] = new JLabel("Day "+(i+1));
                labelDayClass2[i].setBounds(20,470 +30*i,100,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelDayClass2[i].setFont(f);
                backgroundLabel.add(labelDayClass2[i]);

                for(int j=0; j<storeddays;j++){
                    labelClass2[i][j] = new JLabel(S2[i][j]);
                    labelClass2[i][j].setBounds(120+60*j,470 +30*i,60,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    labelClass2[i][j].setFont(f);
                    backgroundLabel.add(labelClass2[i][j]);
                }
            }

            for(int i=0;i<noOfSubjects;i++){
                if(i == 0){
                    generalLabel1= new JLabel("Class Teacher: "+ classTeacher2);
                    generalLabel1.setBounds(630,440,150,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    generalLabel1.setFont(f);
                    backgroundLabel.add(generalLabel1);
                }
                facultyLabelClass2[i] = new JLabel(storedSubjects[i]+" : "+F2[i]);
                facultyLabelClass2[i].setBounds(630,457+17*i,150,30);
                f = new Font("Times New Roman",Font.PLAIN,14);
                facultyLabelClass2[i].setFont(f);
                backgroundLabel.add(facultyLabelClass2[i]);
            }

            //third class
            appLabel = new JLabel("Timetable for class 3:");
            appLabel.setBounds(940, 90, 200, 30);
            f = new Font("Times New Roman", Font.PLAIN, 14);
            appLabel.setFont(f);
            backgroundLabel.add(appLabel);

            for(int i=0;i<storeddays;i++){
                labelLectureClass3[i] = new JLabel("Lecture"+(i+1));
                labelLectureClass3[i].setBounds(880+60*i,130,60,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelLectureClass3[i].setFont(f);
                backgroundLabel.add(labelLectureClass3[i]);
            }

            for (int i=0;i<storedweek;i++){
                labelDayClass3[i] = new JLabel("Day "+(i+1));
                labelDayClass3[i].setBounds(780,160 +30*i,100,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelDayClass3[i].setFont(f);
                backgroundLabel.add(labelDayClass3[i]);

                for(int j=0; j<storeddays;j++){
                    labelClass3[i][j] = new JLabel(S3[i][j]);
                    labelClass3[i][j].setBounds(880+60*j,160 +30*i,60,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    labelClass3[i][j].setFont(f);
                    backgroundLabel.add(labelClass3[i][j]);
                }
            }

            for(int i=0;i<noOfSubjects;i++){
                if(i == 0){
                    generalLabel1= new JLabel("Class Teacher: "+ classTeacher3);
                    generalLabel1.setBounds(1390,130,150,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    generalLabel1.setFont(f);
                    backgroundLabel.add(generalLabel1);
                }
                facultyLabelClass3[i] = new JLabel(storedSubjects[i]+" : "+F3[i]);
                facultyLabelClass3[i].setBounds(1390,143+17*i,150,30);
                f = new Font("Times New Roman",Font.PLAIN,14);
                facultyLabelClass3[i].setFont(f);
                backgroundLabel.add(facultyLabelClass3[i]);
            }
        }



        if(noOfClasses == 4){
            S = g.class1(storedweek, storeddays, noOfSubjects, ap1, storedSubjects, S, ap2);
            S2 = g.generateclass(storedweek, storeddays, noOfSubjects, ap1, storedSubjects, S2, S, ap2);   // get automated classes
            S3 = g.generateclass(storedweek, storeddays, noOfSubjects, ap1, storedSubjects, S3, S2, ap2);
            S4 = g.generateclass(storedweek, storeddays, noOfSubjects, ap1, storedSubjects, S4, S3, ap2);

            F = g.facultyAssignment4(noOfSubjects, storedFaculties);       // to assign faculties
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < noOfSubjects; j++) {
                    if (i == 0) {
                        F1[j] = F[i][j];
                    }
                    if (i == 1) {
                        F2[j] = F[i][j];                 // to retrieve the faculties
                    }
                    if (i == 2) {
                        F3[j] = F[i][j];
                    }
                    if (i == 3) {
                        F4[j] = F[i][j];
                    }
                }
            }
            q = rd.nextInt(noOfSubjects);   // assigning class teacher of class 2 and 3
            random = F2[q];
            classTeacher2 = random;
            while (true) {
                q = rd.nextInt(noOfSubjects);
                random = F3[q];
                if (!random.equals(classTeacher2)) {
                    classTeacher3 = random;
                    break;
                }
            }
            q = rd.nextInt(noOfSubjects);  // assigning class teacher of class 2 and 3
            random = F1[q];
            classTeacher1 = random;
            while (true) {
                q = rd.nextInt(noOfSubjects);
                random = F4[q];
                if (!random.equals(classTeacher1) && !random.equals(classTeacher2) && !random.equals(classTeacher3)) {
                    classTeacher4 = random;
                    break;
                }
            }

            appLabel = new JLabel("Timetable for class 1:");
            appLabel.setBounds(230, 90, 200, 30);
            f = new Font("Times New Roman", Font.PLAIN, 14);
            appLabel.setFont(f);
            backgroundLabel.add(appLabel);

            for(int i=0;i<storeddays;i++){
                labelLectureClass1[i] = new JLabel("Lecture"+(i+1));
                labelLectureClass1[i].setBounds(120+60*i,130,60,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelLectureClass1[i].setFont(f);
                backgroundLabel.add(labelLectureClass1[i]);
            }

            for (int i=0;i<storedweek;i++){
                labelDayClass1[i] = new JLabel("Day "+(i+1));
                labelDayClass1[i].setBounds(20,160 +30*i,100,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelDayClass1[i].setFont(f);
                backgroundLabel.add(labelDayClass1[i]);

                for(int j=0; j<storeddays;j++){
                    labelClass1[i][j] = new JLabel(S[i][j]);
                    labelClass1[i][j].setBounds(120+60*j,160 +30*i,60,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    labelClass1[i][j].setFont(f);
                    backgroundLabel.add(labelClass1[i][j]);
                }
            }

            for(int i=0;i<noOfSubjects;i++){
                if(i == 0){
                    generalLabel1= new JLabel("Class Teacher: "+ classTeacher1);
                    generalLabel1.setBounds(630,130,150,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    generalLabel1.setFont(f);
                    backgroundLabel.add(generalLabel1);
                }
                facultyLabelClass1[i] = new JLabel(storedSubjects[i]+":"+F1[i]);
                facultyLabelClass1[i].setBounds(630,147+17*i,150,30);
                f = new Font("Times New Roman",Font.PLAIN,14);
                facultyLabelClass1[i].setFont(f);
                backgroundLabel.add(facultyLabelClass1[i]);
            }
            // second class
            appLabel = new JLabel("Timetable for class 2:");
            appLabel.setBounds(230, 400, 200, 30);
            f = new Font("Times New Roman", Font.PLAIN, 14);
            appLabel.setFont(f);
            backgroundLabel.add(appLabel);

            for(int i=0;i<storeddays;i++){
                labelLectureClass2[i] = new JLabel("Lecture"+(i+1));
                labelLectureClass2[i].setBounds(120+60*i,440,60,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelLectureClass2[i].setFont(f);
                backgroundLabel.add(labelLectureClass2[i]);
            }

            for (int i=0;i<storedweek;i++){
                labelDayClass2[i] = new JLabel("Day "+(i+1));
                labelDayClass2[i].setBounds(20,470 +30*i,100,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelDayClass2[i].setFont(f);
                backgroundLabel.add(labelDayClass2[i]);

                for(int j=0; j<storeddays;j++){
                    labelClass2[i][j] = new JLabel(S2[i][j]);
                    labelClass2[i][j].setBounds(120+60*j,470 +30*i,60,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    labelClass2[i][j].setFont(f);
                    backgroundLabel.add(labelClass2[i][j]);
                }
            }

            for(int i=0;i<noOfSubjects;i++){
                if(i == 0){
                    generalLabel1= new JLabel("Class Teacher: "+ classTeacher2);
                    generalLabel1.setBounds(630,440,150,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    generalLabel1.setFont(f);
                    backgroundLabel.add(generalLabel1);
                }
                facultyLabelClass2[i] = new JLabel(storedSubjects[i]+" : "+F2[i]);
                facultyLabelClass2[i].setBounds(630,457+17*i,150,30);
                f = new Font("Times New Roman",Font.PLAIN,14);
                facultyLabelClass2[i].setFont(f);
                backgroundLabel.add(facultyLabelClass2[i]);
            }

            //third class
            appLabel = new JLabel("Timetable for class 3:");
            appLabel.setBounds(970, 90, 200, 30);
            f = new Font("Times New Roman", Font.PLAIN, 14);
            appLabel.setFont(f);
            backgroundLabel.add(appLabel);

            for(int i=0;i<storeddays;i++){
                labelLectureClass3[i] = new JLabel("Lecture"+(i+1));
                labelLectureClass3[i].setBounds(880+60*i,130,60,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelLectureClass3[i].setFont(f);
                backgroundLabel.add(labelLectureClass3[i]);
            }

            for (int i=0;i<storedweek;i++){
                labelDayClass3[i] = new JLabel("Day "+(i+1));
                labelDayClass3[i].setBounds(780,160 +30*i,100,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelDayClass3[i].setFont(f);
                backgroundLabel.add(labelDayClass3[i]);

                for(int j=0; j<storeddays;j++){
                    labelClass3[i][j] = new JLabel(S3[i][j]);
                    labelClass3[i][j].setBounds(880+60*j,160 +30*i,60,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    labelClass3[i][j].setFont(f);
                    backgroundLabel.add(labelClass3[i][j]);
                }
            }

            for(int i=0;i<noOfSubjects;i++){
                if(i == 0){
                    generalLabel1= new JLabel("Class Teacher: "+ classTeacher3);
                    generalLabel1.setBounds(1390,130,150,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    generalLabel1.setFont(f);
                    backgroundLabel.add(generalLabel1);
                }
                facultyLabelClass3[i] = new JLabel(storedSubjects[i]+" : "+F3[i]);
                facultyLabelClass3[i].setBounds(1390,143+17*i,150,30);
                f = new Font("Times New Roman",Font.PLAIN,14);
                facultyLabelClass3[i].setFont(f);
                backgroundLabel.add(facultyLabelClass3[i]);
            }

            //FOURTH CLASS
            appLabel = new JLabel("Timetable for class 4:");
            appLabel.setBounds(970, 400, 200, 30);
            f = new Font("Times New Roman", Font.PLAIN, 14);
            appLabel.setFont(f);
            backgroundLabel.add(appLabel);

            for(int i=0;i<storeddays;i++){
                labelLectureClass4[i] = new JLabel("Lecture"+(i+1));
                labelLectureClass4[i].setBounds(880+60*i,440,60,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelLectureClass4[i].setFont(f);
                backgroundLabel.add(labelLectureClass4[i]);
            }

            for (int i=0;i<storedweek;i++){
                labelDayClass4[i] = new JLabel("Day "+(i+1));
                labelDayClass4[i].setBounds(780,470 +30*i,100,30);
                f = new Font("Times New Roman",Font.ITALIC,14);
                labelDayClass4[i].setFont(f);
                backgroundLabel.add(labelDayClass4[i]);

                for(int j=0; j<storeddays;j++){
                    labelClass4[i][j] = new JLabel(S4[i][j]);
                    labelClass4[i][j].setBounds(880+60*j,470 +30*i,60,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    labelClass4[i][j].setFont(f);
                    backgroundLabel.add(labelClass4[i][j]);
                }
            }

            for(int i=0;i<noOfSubjects;i++){
                if(i == 0){
                    generalLabel1= new JLabel("Class Teacher: "+ classTeacher4);
                    generalLabel1.setBounds(1390,440,150,30);
                    f = new Font("Times New Roman",Font.PLAIN,14);
                    generalLabel1.setFont(f);
                    backgroundLabel.add(generalLabel1);
                }
                facultyLabelClass4[i] = new JLabel(storedSubjects[i]+" : "+F4[i]);
                facultyLabelClass4[i].setBounds(1390,457+17*i,150,30);
                f = new Font("Times New Roman",Font.PLAIN,14);
                facultyLabelClass4[i].setFont(f);
                backgroundLabel.add(facultyLabelClass4[i]);
            }
        }

        printTimetableBtn = new JButton("Print Timetable");
        printTimetableBtn.setBounds(1050,760,240,30);
        backgroundLabel.add(printTimetableBtn);
        f = new Font("Times New",Font.PLAIN,18);
        printTimetableBtn.setFont(f);
        printTimetableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printTimetableAction(e);
            }
        });

        goToBackPageBtn = new JButton("Go to First Page");
        goToBackPageBtn.setBounds(450,760,240,30);
        backgroundLabel.add(goToBackPageBtn);
        f = new Font("Times New",Font.PLAIN,18);
        goToBackPageBtn.setFont(f);
        goToBackPageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToFirstPage(e);
            }
        });

        goToLoginPageBtn = new JButton("Go to Login Page");
        goToLoginPageBtn.setBounds(150,760,240,30);
        backgroundLabel.add(goToLoginPageBtn);
        f = new Font("Times New",Font.PLAIN,18);
        goToLoginPageBtn.setFont(f);
        goToLoginPageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToLoginPage(e);
            }
        });




        generateAgainBtn = new JButton("Generate Again");
        generateAgainBtn.setBounds(750,760,240,30);
        backgroundLabel.add(generateAgainBtn);
        f = new Font("Times New",Font.PLAIN,18);
        generateAgainBtn.setFont(f);
        generateAgainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateAgainBtnAction(e,instituteTextField,departmentTextField,noOfClasses, noOfSubjects,storedSubjects,storedCodes,storedCredits,storedObjectives,storedOutcomes,storedweek,storeddays,storedAppearances,storedFaculties);
            }
        });
    }
    public void generateAgainBtnAction(ActionEvent e, String instituteTextField, String departmentTextField, int noOfClasses, int noOfSubjects, String[] storedSubjects, String[] storedCodes, String[] storedCredits, String[] storedObjectives, String[] storedOutcomes, int storedweek, int storeddays, int[] storedAppearances,String[][] storedFaculties){
        frame.dispose();
        new SeventhFrame(instituteTextField,departmentTextField,noOfClasses,noOfSubjects,storedSubjects,storedCodes,storedCredits,storedObjectives, storedOutcomes, storedweek,storeddays, storedAppearances, storedFaculties);
    }

    public void printTimetableAction(ActionEvent e){
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Timetable");
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex){
                if (pageIndex > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D)graphics;
                g2.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
                g2.scale(0.5,0.81);
                backgroundLabel.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if(ok){
            try{
                job.print();
            }catch (PrinterException ex){ System.out.println(ex);}
        }
    }

    public void goToFirstPage(ActionEvent e){
        frame.dispose();
        new SecondFrame();
    }

    public void goToLoginPage(ActionEvent e){
        frame.dispose();
        new FirstFrame();
    }
}