import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FifthFrame {
    Container c;
    JFrame frame;
    JLabel appLabel,backgroundLabel;
    JButton generateSyllabusBtn;
    JLabel[] facultyLabel;
    JTextField[] facultyOfSubjects;
    JTextField[] facultyOfSubjects1;
    JTextField[] facultyOfSubjects2;
    JLabel[] appearanceLabel;
    JTextField[] appearanceOfSubjects;
    String[][] storedFaculties;
    int[] storedAppearances;

    FifthFrame(String instituteTextField, String departmentTextField, int noOfClasses, int noOfSubjects, String[] storedSubjects, String[] storedCodes, String[] storedCredits, String[] storedObjectives, String[] storedOutcomes, int storedweek, int storeddays) {
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

        appearanceLabel = new JLabel[noOfSubjects];
        appearanceOfSubjects = new JTextField[noOfSubjects];
        storedAppearances = new int[noOfSubjects];
        for(int i=0; i< noOfSubjects;i++) {
            appearanceLabel[i] = new JLabel("Enter the appearance of "+storedSubjects[i]);
            appearanceLabel[i].setBounds(50 , 80+ i*25, 380, 20);
            f = new Font("Times New Roman", Font.ITALIC, 15);
            appearanceLabel[i].setFont(f);
            backgroundLabel.add(appearanceLabel[i]);

            appearanceOfSubjects[i] = new JTextField();
            appearanceOfSubjects[i].setBounds(400 , 80+ i*25, 80, 20);
            f = new Font("Times New Roman", Font.PLAIN, 15);
            appearanceOfSubjects[i].setFont(f);
            backgroundLabel.add(appearanceOfSubjects[i]);
        }

        facultyLabel = new JLabel[noOfSubjects];
        facultyOfSubjects = new JTextField[noOfSubjects];
        facultyOfSubjects1 = new JTextField[noOfSubjects];
        facultyOfSubjects2 = new JTextField[noOfSubjects];
        storedFaculties = new String[noOfSubjects][3];
        for(int i=0; i< noOfSubjects;i++) {
            facultyLabel[i] = new JLabel("Enter the names of faculties of "+storedSubjects[i]);
            facultyLabel[i].setBounds(50 , 390+ i*25, 380, 20);
            f = new Font("Times New Roman", Font.ITALIC, 15);
            facultyLabel[i].setFont(f);
            backgroundLabel.add(facultyLabel[i]);

            if (noOfClasses == 1) {
                facultyOfSubjects[i] = new JTextField();
                facultyOfSubjects[i].setBounds(400, 390 + i * 25, 200, 20);
                f = new Font("Times New Roman", Font.PLAIN, 15);
                facultyOfSubjects[i].setFont(f);
                backgroundLabel.add(facultyOfSubjects[i]);
            }
            if (noOfClasses == 2 || noOfClasses ==3){
                facultyOfSubjects[i] = new JTextField();
                facultyOfSubjects[i].setBounds(400, 390 + i * 25, 200, 20);
                f = new Font("Times New Roman", Font.PLAIN, 15);
                facultyOfSubjects[i].setFont(f);
                backgroundLabel.add(facultyOfSubjects[i]);
                facultyOfSubjects1[i] = new JTextField();
                facultyOfSubjects1[i].setBounds(600, 390 + i * 25, 200, 20);
                f = new Font("Times New Roman", Font.PLAIN, 15);
                facultyOfSubjects1[i].setFont(f);
                backgroundLabel.add(facultyOfSubjects1[i]);
            }
            if (noOfClasses == 4){
                facultyOfSubjects[i] = new JTextField();
                facultyOfSubjects[i].setBounds(400, 390 + i * 25, 200, 20);
                f = new Font("Times New Roman", Font.PLAIN, 15);
                facultyOfSubjects[i].setFont(f);
                backgroundLabel.add(facultyOfSubjects[i]);
                facultyOfSubjects1[i] = new JTextField();
                facultyOfSubjects1[i].setBounds(600, 390 + i * 25, 200, 20);
                f = new Font("Times New Roman", Font.PLAIN, 15);
                facultyOfSubjects1[i].setFont(f);
                backgroundLabel.add(facultyOfSubjects1[i]);
                facultyOfSubjects2[i] = new JTextField();
                facultyOfSubjects2[i].setBounds(800, 390 + i * 25, 200, 20);
                f = new Font("Times New Roman", Font.PLAIN, 15);
                facultyOfSubjects2[i].setFont(f);
                backgroundLabel.add(facultyOfSubjects2[i]);
            }
        }
        generateSyllabusBtn = new JButton("Show Syllabus");
        generateSyllabusBtn.setBounds(720,650,200,40);
        backgroundLabel.add(generateSyllabusBtn);
        f = new Font("Times New",Font.PLAIN,18);
        generateSyllabusBtn.setFont(f);
        generateSyllabusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateSyllabusAction(e,instituteTextField,departmentTextField,noOfClasses, noOfSubjects,storedSubjects,storedCodes,storedCredits,storedObjectives,storedOutcomes,storedweek,storeddays,storedAppearances,storedFaculties);
            }
        });
    }
    public void generateSyllabusAction(ActionEvent e,String instituteTextField,String departmentTextField,int noOfClasses,int noOfSubjects,String[] storedSubjects,String[] storedCodes,String[] storedCredits,String[] storedObjectives,String[] storedOutcomes, int storedweek, int storeddays,int[] storedAppearances,String[][] storedFaculties){
        for(int i=0; i< noOfSubjects;i++) {
            storedAppearances[i] = Integer.parseInt((String)appearanceOfSubjects[i].getText());
            if (noOfClasses == 1) {
                storedFaculties[i][0] = facultyOfSubjects[i].getText();
            }
            if (noOfClasses == 2 || noOfClasses ==3){
                storedFaculties[i][0] = facultyOfSubjects[i].getText();
                storedFaculties[i][1] = facultyOfSubjects1[i].getText();
            }
            if (noOfClasses == 4){
                storedFaculties[i][0] = facultyOfSubjects[i].getText();
                storedFaculties[i][1] = facultyOfSubjects1[i].getText();
                storedFaculties[i][2] = facultyOfSubjects2[i].getText();
            }
        }
        frame.dispose();
        new SixthFrame(instituteTextField,departmentTextField,noOfClasses,noOfSubjects,storedSubjects,storedCodes,storedCredits,storedObjectives, storedOutcomes, storedweek,storeddays,storedAppearances,storedFaculties);
    }
}