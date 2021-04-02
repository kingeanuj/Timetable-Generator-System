import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class SixthFrame {
    Container c;
    JFrame frame;
    JLabel appLabel,generalLabel1,backgroundLabel;
    JLabel[] generalLabel2,generalLabel3,generalLabel4;
    JButton generateTimetableBtn,printSyllabusBtn;

    SixthFrame(String instituteTextField, String departmentTextField, int noOfClasses, int noOfSubjects, String[] storedSubjects, String[] storedCodes, String[] storedCredits, String[] storedObjectives, String[] storedOutcomes, int storedweek, int storeddays,int[] storedAppearances,String[][] storedFaculties) {
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

        generalLabel1 = new JLabel("        Institute name :     "+instituteTextField ) ;
        generalLabel1.setBounds(20,90,300,18);
        f = new Font("Times New Roman",Font.ITALIC,15);
        generalLabel1.setFont(f);
        backgroundLabel.add(generalLabel1);
        generalLabel1 = new JLabel("        Department name :     " + departmentTextField) ;
        generalLabel1.setBounds(20,110,300,18);
        f = new Font("Times New Roman",Font.ITALIC,15);
        generalLabel1.setFont(f);
        backgroundLabel.add(generalLabel1);
        generalLabel1 = new JLabel("        Following is the Syllabus for " + departmentTextField+":") ;
        generalLabel1.setBounds(20,130,300,18);
        f = new Font("Times New Roman",Font.ITALIC,15);
        generalLabel1.setFont(f);
        backgroundLabel.add(generalLabel1);

        generalLabel2 = new JLabel[noOfSubjects];
        generalLabel3 = new JLabel[noOfSubjects];
        generalLabel4 = new JLabel[noOfSubjects];

        for(int i=0 ; i<noOfSubjects;i++){
            generalLabel2[i] = new JLabel("        "+(i+1)+"."+"Subject :    "+storedSubjects[i]+"            "+ "Code :    "+storedCodes[i]+"            "+ "Credits/Marks :     "+ storedCredits[i]);
            generalLabel2[i].setBounds(20,150+ i*60,1200,18);
            f = new Font("Times New Roman",Font.ITALIC,15);
            generalLabel2[i].setFont(f);
            backgroundLabel.add(generalLabel2[i]);

            generalLabel3[i]= new JLabel("        Objective :     "+storedObjectives[i]);
            generalLabel3[i].setBounds(20,170+ i*60,1200,18);
            f = new Font("Times New Roman",Font.ITALIC,15);
            generalLabel3[i].setFont(f);
            backgroundLabel.add(generalLabel3[i]);

            generalLabel4[i]= new JLabel("        Outcome :     "+storedOutcomes[i]);
            generalLabel4[i].setBounds(20,190+ i*60,1200,18);
            f = new Font("Times New Roman",Font.ITALIC,15);
            generalLabel4[i].setFont(f);
            backgroundLabel.add(generalLabel4[i]);
        }

        printSyllabusBtn = new JButton("Print Syllabus");
        printSyllabusBtn.setBounds(500,760,240,30);
        backgroundLabel.add(printSyllabusBtn);
        f = new Font("Times New",Font.PLAIN,18);
        printSyllabusBtn.setFont(f);
        printSyllabusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printSyllabusAction(e);
            }
        });


        generateTimetableBtn = new JButton("Generate Timetable");
        generateTimetableBtn.setBounds(1000,760,240,30);
        backgroundLabel.add(generateTimetableBtn);
        f = new Font("Times New",Font.PLAIN,18);
        generateTimetableBtn.setFont(f);
        generateTimetableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateTimetableAction(e,instituteTextField,departmentTextField,noOfClasses, noOfSubjects,storedSubjects,storedCodes,storedCredits,storedObjectives,storedOutcomes,storedweek,storeddays,storedAppearances,storedFaculties);
            }
        });


    }
    public void generateTimetableAction(ActionEvent e, String instituteTextField, String departmentTextField, int noOfClasses, int noOfSubjects, String[] storedSubjects, String[] storedCodes, String[] storedCredits, String[] storedObjectives, String[] storedOutcomes, int storedweek, int storeddays, int[] storedAppearances,String[][] storedFaculties){
        frame.dispose();
        new SeventhFrame(instituteTextField,departmentTextField,noOfClasses,noOfSubjects,storedSubjects,storedCodes,storedCredits,storedObjectives, storedOutcomes, storedweek,storeddays, storedAppearances, storedFaculties);
    }
    public void printSyllabusAction(ActionEvent e){
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Syllabus");
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
}