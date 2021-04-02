import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SecondFrame {
    Container c;
    JFrame frame;
    JLabel appLabel, backgroundLabel;
    JLabel institute;
    JLabel department;
    JLabel classCount;
    JLabel subjectCount;
    JTextField instituteText;
    JTextField departmentText;
    JComboBox classCountCombo;
    JComboBox subjectCountCombo;
    JButton nextBtn2;
    int noOfClasses;
    int noOfSubjects;
    String instituteTextField;
    String departmentTextField;

    SecondFrame(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(0,0,1920,1080) ;
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

        appLabel = new JLabel("Syllabus and Timetable Management System") ;
        appLabel.setBounds(460,0,800,50);
        Font f = new Font("Times New Roman",Font.PLAIN,40);
        appLabel.setFont(f);
        backgroundLabel.add(appLabel);

        ImageIcon icon1 = new ImageIcon("tt.jpg");
        JLabel icon1Label = new JLabel("", icon1, JLabel.CENTER);
        icon1Label.setBounds(0,0,300,300);
        backgroundLabel.add(icon1Label);

        institute = new JLabel("Enter the name of your Institute") ;
        institute.setBounds(400,150,600,50);
        f = new Font("Times New Roman",Font.ITALIC,25);
        institute.setFont(f);
        backgroundLabel.add(institute);

        department = new JLabel("Enter the department/Standard") ;
        department.setBounds(400,230,600,50);
        f = new Font("Times New Roman",Font.ITALIC,25);
        department.setFont(f);
        backgroundLabel.add(department);

        classCount = new JLabel("Enter the no. of classes") ;
        classCount.setBounds(400,310,600,50);
        f = new Font("Times New Roman",Font.ITALIC,25);
        classCount.setFont(f);
        backgroundLabel.add(classCount);

        subjectCount = new JLabel("Enter the no. of subjects") ;
        subjectCount.setBounds(400,390,600,50);
        f = new Font("Times New Roman",Font.ITALIC,25);
        subjectCount.setFont(f);
        backgroundLabel.add(subjectCount);

        // text fields and combo boxes
        instituteText = new JTextField();
        instituteText.setBounds(800,150,400,40);
        f = new Font("Times New Roman",Font.PLAIN,22);
        instituteText.setFont(f);
        backgroundLabel.add(instituteText);
        instituteTextField = instituteText.getText();

        departmentText = new JTextField();
        departmentText.setBounds(800,230,400,40);
        f = new Font("Times New Roman",Font.PLAIN,22);
        departmentText.setFont(f);
        backgroundLabel.add(departmentText);
        departmentTextField = departmentText.getText();

        String[] classes = {"1","2","3","4"};
        classCountCombo = new JComboBox(classes);
        classCountCombo.setBounds(800,310,400,40);
        f = new Font("Times New Roman",Font.PLAIN,22);
        classCountCombo.setFont(f);
        classCountCombo.setSelectedItem("1");
        backgroundLabel.add(classCountCombo);

        String[] subjects = {"4","5","6","7","8","9","10"};
        subjectCountCombo = new JComboBox(subjects);
        subjectCountCombo.setBounds(800,390,400,40);
        f = new Font("Times New Roman",Font.PLAIN,22);
        subjectCountCombo.setFont(f);
        subjectCountCombo.setSelectedItem("4");
        backgroundLabel.add(subjectCountCombo);

        nextBtn2 = new JButton("Next");                // to create button
        nextBtn2.setBounds(740,520,100,40);
        backgroundLabel.add(nextBtn2);
        f = new Font("Times New",Font.PLAIN,22);
        nextBtn2.setFont(f);
        nextBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextButton2Action(e,frame);
            }
        });
    }
    public void nextButton2Action(ActionEvent e, JFrame frame){
        instituteTextField = instituteText.getText();
        departmentTextField = departmentText.getText();
        noOfClasses = Integer.parseInt((String)classCountCombo.getSelectedItem());
        noOfSubjects = Integer.parseInt((String)subjectCountCombo.getSelectedItem());
        frame.dispose();
        new ThirdFrame(instituteTextField,departmentTextField,noOfClasses,noOfSubjects);
    }
}
