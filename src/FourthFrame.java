import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FourthFrame {
    Container c;
    JFrame frame;
    JLabel appLabel,backgroundLabel;
    JTextField[] outcomesOfSubjects;
    String[]  storedOutcomes;
    JLabel[] outcomeslabel;
    JButton nextBtn4;
    JLabel week ;
    JLabel days;
    JComboBox  weekCombo;
    int storedweek;
    JComboBox daysCombo;
    int storeddays;

    FourthFrame(String instituteTextField,String departmentTextField,  int noOfClasses, int noOfSubjects,String[] storedSubjects,String[] storedCodes,String[] storedCredits,String[] storedObjectives) {
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

        outcomeslabel = new JLabel[noOfSubjects];
        outcomesOfSubjects = new JTextField[noOfSubjects];
        storedOutcomes = new String[noOfSubjects];
        for(int i=0; i< noOfSubjects;i++) {
            outcomeslabel[i] = new JLabel("Enter the outcomes of "+storedSubjects[i]);
            outcomeslabel[i].setBounds(50 , 80+ i*40, 350, 30);
            f = new Font("Times New Roman", Font.ITALIC, 15);
            outcomeslabel[i].setFont(f);
            backgroundLabel.add(outcomeslabel[i]);

            outcomesOfSubjects[i] = new JTextField();
            outcomesOfSubjects[i].setBounds(400 , 80+ i*40, 1100, 30);
            f = new Font("Times New Roman", Font.PLAIN, 15);
            outcomesOfSubjects[i].setFont(f);
            backgroundLabel.add(outcomesOfSubjects[i]);
        }

        week = new JLabel("Enter the no. of working days in a week");
        week.setBounds(50,500,500,50);
        f = new Font("Times New Roman",Font.ITALIC,25);
        week.setFont(f);
        backgroundLabel.add(week);

        days = new JLabel("Enter the no. of lectures in a day");
        days.setBounds(50,540,500,50);
        f = new Font("Times New Roman",Font.ITALIC,25);
        days.setFont(f);
        backgroundLabel.add(days);

        String[] weekdays = {"3","4","5","6"};
        weekCombo = new JComboBox(weekdays);
        weekCombo.setBounds(500,510,220,30);
        f = new Font("Times New Roman",Font.PLAIN,18);
        weekCombo.setFont(f);
        weekCombo.setSelectedItem("5");
        backgroundLabel.add(weekCombo);

        String[] day = {"3","4","5","6","7","8"};
        daysCombo = new JComboBox(day);
        daysCombo.setBounds(500,550,220,30);
        f = new Font("Times New Roman",Font.PLAIN,18);
        daysCombo.setFont(f);
        daysCombo.setSelectedItem("6");
        backgroundLabel.add(daysCombo);

        nextBtn4 = new JButton("Next");
        nextBtn4.setBounds(740,650,100,40);
        backgroundLabel.add(nextBtn4);
        f = new Font("Times New",Font.PLAIN,22);
        nextBtn4.setFont(f);
        nextBtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextButton4Action(e,instituteTextField,departmentTextField,noOfClasses, noOfSubjects,storedSubjects,storedCodes,storedCredits,storedObjectives,storedOutcomes,storedweek,storeddays);
            }
        });
    }

    public void nextButton4Action(ActionEvent e,String instituteTextField,String departmentTextField,int noOfClasses,int noOfSubjects,String[] storedSubjects,String[] storedCodes,String[] storedCredits,String[] storedObjectives,String[] storedOutcomes, int storedweek, int storeddays){
        for(int i=0; i< noOfSubjects;i++) {
            storedOutcomes[i] = outcomesOfSubjects[i].getText();
        }
        storedweek = Integer.parseInt((String)weekCombo.getSelectedItem());
        storeddays= Integer.parseInt((String)daysCombo.getSelectedItem());
        frame.dispose();
        new FifthFrame(instituteTextField,departmentTextField,noOfClasses,noOfSubjects,storedSubjects,storedCodes,storedCredits,storedObjectives, storedOutcomes, storedweek,storeddays);
    }
}