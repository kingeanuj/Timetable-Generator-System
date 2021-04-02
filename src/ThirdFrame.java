import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThirdFrame{
    Container c;
    JFrame frame;
    JLabel appLabel,backgroundLabel;
    JTextField[] tfsofSubjects;
    String[] storedSubjects;
    JTextField[] codesOfSubjects;
    String[] storedCodes;
    JTextField[] creditsOfsubjects;
    String[] storedCredits;
    JTextField[] objectivesOfSubjects;
    String[] storedObjectives;
    JLabel subcountlabel;
    JLabel codelabel;
    JLabel creditslabel;
    JLabel[] objecntiveslabel;
    JButton nextBtn3;

    ThirdFrame(String institute
               TextField,String departmentTextField,  int noOfClasses, int noOfSubjects) {
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

        appLabel = new JLabel("Syllabus and Timetable Management System") ;
        appLabel.setBounds(460,0,800,50);
        Font f = new Font("Times New Roman",Font.PLAIN,40);
        appLabel.setFont(f);
        backgroundLabel.add(appLabel);

        subcountlabel = new JLabel("Enter the names of subjects") ;
        subcountlabel.setBounds(20,80,280,50);
        f = new Font("Times New Roman",Font.ITALIC,25);
        subcountlabel.setFont(f);
        backgroundLabel.add(subcountlabel);

        tfsofSubjects = new JTextField[noOfSubjects];
        storedSubjects = new String[noOfSubjects];
        for (int i = 0; i < noOfSubjects; i++) {
            tfsofSubjects[i] = new JTextField();
            tfsofSubjects[i].setBounds(310 + i*120 ,90,120,30);
            f = new Font("Times New Roman",Font.PLAIN,18);
            tfsofSubjects[i].setFont(f);
            backgroundLabel.add(tfsofSubjects[i]);
        }

        codelabel = new JLabel("Enter the codes of subjects") ;
        codelabel.setBounds(20,150,280,50);
        f = new Font("Times New Roman",Font.ITALIC,25);
        codelabel.setFont(f);
        backgroundLabel.add(codelabel);

        codesOfSubjects = new JTextField[noOfSubjects];
        storedCodes = new String[noOfSubjects];
        for (int i = 0; i < noOfSubjects; i++) {
            codesOfSubjects[i] = new JTextField();
            codesOfSubjects[i].setBounds(310 + i*120 ,160,120,30);
            f = new Font("Times New Roman",Font.PLAIN,18);
            codesOfSubjects[i].setFont(f);
            backgroundLabel.add(codesOfSubjects[i]);
        }

        creditslabel = new JLabel("Enter the credits of subjects") ;
        creditslabel.setBounds(20,220,300,50);
        f = new Font("Times New Roman",Font.ITALIC,25);
        creditslabel.setFont(f);
        backgroundLabel.add(creditslabel);

        creditsOfsubjects = new JTextField[noOfSubjects];
        storedCredits = new String[noOfSubjects];
        for (int i = 0; i < noOfSubjects; i++) {
            creditsOfsubjects[i] = new JTextField();
            creditsOfsubjects[i].setBounds(310 + i*120 ,230,120,30);
            f = new Font("Times New Roman",Font.PLAIN,18);
            creditsOfsubjects[i].setFont(f);
            backgroundLabel.add(creditsOfsubjects[i]);
        }

        objectiveslabel = new JLabel[noOfSubjects];
        objectivesOfSubjects = new JTextField[noOfSubjects];
        storedObjectives = new String[noOfSubjects];
        for(int i=0; i< noOfSubjects;i++) {
            objectiveslabel[i] = new JLabel("Enter the objective of subject" + Integer.toString(i+1));
            objectiveslabel[i].setBounds(50 , 300+ i*40, 800, 30);
            f = new Font("Times New Roman", Font.ITALIC, 18);
            objectiveslabel[i].setFont(f);
            backgroundLabel.add(objectiveslabel[i]);

            objectivesOfSubjects[i] = new JTextField();
            objectivesOfSubjects[i].setBounds(310 , 300+ i*40, 1200, 30);
            f = new Font("Times New Roman", Font.PLAIN, 18);
            objectivesOfSubjects[i].setFont(f);
            backgroundLabel.add(objectivesOfSubjects[i]);
        }
        nextBtn3 = new JButton("Next");
        nextBtn3.setBounds(740,700,100,40);
        backgroundLabel.add(nextBtn3);
        f = new Font("Times New",Font.PLAIN,22);
        nextBtn3.setFont(f);
        nextBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextButton3Action(e,instituteTextField,departmentTextField,noOfClasses, noOfSubjects,storedSubjects,storedCodes,storedCredits,storedObjectives);
            }
        });

    }
    public void nextButton3Action(ActionEvent e,String instituteTextField,String departmentTextField,int noOfClasses,int noOfSubjects,String[] storedSubjects,String[] storedCodes,String[] storedCredits,String[] storedObjectives){
        for (int i = 0; i < noOfSubjects; i++) {
            storedSubjects[i] = tfsofSubjects[i].getText();
            storedCodes[i] = codesOfSubjects[i].getText();
            storedCredits[i] = creditsOfsubjects[i].getText();
            storedObjectives[i] = objectivesOfSubjects[i].getText();
        }
        frame.dispose();
        new FourthFrame(instituteTextField,departmentTextField,noOfClasses,noOfSubjects,storedSubjects,storedCodes,storedCredits,storedObjectives);
    }
}
