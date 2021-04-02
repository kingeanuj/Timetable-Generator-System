import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame {
    Container c;
    JFrame frame;
    JLabel welcomeLabel, backgroundLabel;

    JButton nextButton;
    FirstFrame(){
        frame = new JFrame();
        frame.setSize(1920,1080); ;
        frame.setTitle("Timetable Management System");
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

        ImageIcon icon1 = new ImageIcon("tt.jpg");
        JLabel icon1Label = new JLabel("", icon1, JLabel.CENTER);
        icon1Label.setBounds(0,0,300,300);
        backgroundLabel.add(icon1Label);

        welcomeLabel = new JLabel();
        welcomeLabel.setText("SYLLABUS & TIMETABLE MANAGEMENT SYSTEM");
        welcomeLabel.setBounds(360,40,1000,90);
        backgroundLabel.add(welcomeLabel);
        Font f = new Font("Times New Roman", Font.ITALIC,40);
        welcomeLabel.setFont(f);

        JLabel userID = new JLabel();
        userID.setText("User ID : ");
        userID.setBounds(580,250,800,40);
        backgroundLabel.add(userID);
        f = new Font("Times New Roman", Font.ITALIC,25);
        userID.setFont(f);

        JLabel passLabel = new JLabel();
        passLabel.setText("User Password : ");
        passLabel.setBounds(580,350,800,40);
        backgroundLabel.add(passLabel);
        f = new Font("Times New Roman", Font.ITALIC,25);
        passLabel.setFont(f);


        JTextField idText = new JTextField();                       // to create text field
        idText.setBounds(800,250,200,40);
        backgroundLabel.add(idText);
        f = new Font("Times New",Font.PLAIN,14);
        idText.setFont(f);

        JPasswordField pass = new JPasswordField();                   // to create password field
        pass.setBounds(800,350,200,40);
        backgroundLabel.add(pass);
        f = new Font("Times New",Font.PLAIN,18);
        pass.setFont(f);



        nextButton = new JButton("Let's go");
        nextButton.setBounds(700,480,160,34);
        backgroundLabel.add(nextButton);
        f = new Font("Times New",Font.PLAIN,18);
        nextButton.setFont(f);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextButtonAction(e, idText, pass);
            }
        });
    }
    public void nextButtonAction(ActionEvent e,JTextField idText, JPasswordField pass){
        String username = idText.getText();
        String password = pass.getText();
        if (username.equals("kingeanuj@gmail.com") && password.equals("12345678")){
            new SecondFrame();
            frame.dispose();
        }
        else if (username.equals("patilatharva@gmail.com") && password.equals("12345678")){
            new SecondFrame();
            frame.dispose();
        }
        else if (username.equals("ahluwaliaarti@gmail.com") && password.equals("12345678")){
            new SecondFrame();
            frame.dispose();
        }
        else if (username.equals("deshmukhashutosh@gmail.com") && password.equals("12345678")){
            new SecondFrame();
            frame.dispose();
        }
        else if (username.equals("sarodesambhaji@gmail.com") && password.equals("12345678")){
            new SecondFrame();
            frame.dispose();
        }
        else{
            JFrame f =new JFrame();
            JOptionPane.showMessageDialog(f,"Please enter valid UserID and password");
        }
    }
}
