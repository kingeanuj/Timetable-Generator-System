import java.util.Random;
public class GeneratorClass {
    String[][] class1(int w, int d, int noOfSubjects, int[] ap1, String[] subjects, String[][] S, int[] ap2) {//TO GET FIRST CLASS
        System.arraycopy(ap2, 0, ap1, 0, ap2.length);
        int k,x;
        String y;
        Random rd = new Random();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < d; j++) {
                while(S[i][j] == null){
                    x = rd.nextInt(subjects.length);
                    y = subjects[x];
                    for (k = 0; k < noOfSubjects; k++) {
                        if (y.equals(subjects[k]) && ap1[k] != 0) {
                           S[i][j] = y;
                            ap1[k]--;
                            break;
                        }
                    }
                }
            }
        }
        return S;
    }

    String[][] generateclass(int w,int d, int noOfSubjects,int[] ap1, String[] subjects, String[][] Sn, String[][] S, int[] ap2){ // TO GET 2ND AND 3RD CLASS
        int x,k;
        String y;
        System.arraycopy(ap2, 0, ap1, 0, ap2.length);
        for(int i=0;i< w;i++){
            for(int j=0;j< d;j++){
                Sn[i][j]=null;
            }
        }
        Random rd = new Random();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < d; j++) {
                while (Sn[i][j] == null) {
                    x = rd.nextInt(subjects.length);
                    y = subjects[x];
                    for (k = 0; k < noOfSubjects; k++) {
                        if (y.equals(subjects[k]) && ap1[k] != 0) {
                            Sn[i][j] = y;
                            ap1[k]--;
                            break;
                        }
                    }
                }
            }
        }
        for(int i=0;i< w;i++){
            for(int j=0;j< d;j++){
                if(S[i][j].equals(Sn[i][j])){
                    generateclass(w,d,noOfSubjects,ap1,subjects,Sn,S,ap2);
                }
            }
        }
        return Sn;
    }

    String[] facultyAssignment1(int noOfSubjects, String[][] f){
        Random rd = new Random();
        // for assigning faculties to the subjects
        String[] F1 = new String[noOfSubjects];
        for (int i = 0; i < noOfSubjects; i++) {
            F1[i] = f[i][0];
        }
        return F1;
    }

    String[][] facultyAssignment2(int noOfSubjects, String[][] f){
        Random rd = new Random();
        String[][] F = new String[2][noOfSubjects];// for assigning faculties to the subjects
        String[] F1 = new String[noOfSubjects], F2 = new String[noOfSubjects];
        for (int i = 0; i < noOfSubjects; i++) {
            while (true) {
                int x = rd.nextInt(2);
                if (x == 0) {
                    F2[i] = f[i][0];
                    F1[i] = f[i][1];
                    break;
                }
                if (x == 1) {
                    F2[i] = f[i][1];
                    F1[i] = f[i][0];
                    break;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < noOfSubjects; j++) {
                if (i == 0) {
                    F[i][j] = F1[j];
                }
                if (i == 1) {
                    F[i][j] = F2[j];
                }
            }
        }
        return  F;
    }

    String[][] facultyAssignment3(int noOfSubjects, String[][] f) {
        Random rd = new Random();
        String[][] F = new String[3][noOfSubjects];// for assigning faculties to the subjects
        String[] F1 = new String[noOfSubjects], F2 = new String[noOfSubjects], F3 = new String[noOfSubjects];
        for (int i = 0; i < noOfSubjects; i++) {
            while (true) {
                int x = rd.nextInt(2);
                if (x == 0) {
                    F3[i] = f[i][0];
                    F1[i] = f[i][1];
                    F2[i] = f[i][1];
                    break;
                }
                if (x == 1) {
                    F3[i] = f[i][1];
                    F1[i] = f[i][0];
                    F2[i] = f[i][0];
                    break;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < noOfSubjects; j++) {
                if (i == 0) {
                    F[i][j] = F1[j];
                }
                if (i == 1) {
                    F[i][j] = F2[j];
                }
                if (i == 2) {
                    F[i][j] = F3[j];
                }
            }
        }
        return  F;
    }

    String[][] facultyAssignment4(int noOfSubjects, String[][] f) {
        Random rd = new Random();
        String[][] F = new String[4][noOfSubjects];// for assigning faculties to the subjects
        // to store respective faculties of classses
        String[] F1 = new String[noOfSubjects],F2 = new String[noOfSubjects],F3 = new String[noOfSubjects],F4 = new String[noOfSubjects];
        for (int i = 0; i < noOfSubjects; i++) {
            String y, z,z1;
            int b, c;
            while (true) {
                int x = rd.nextInt(3);
                if (x == 0 ) {
                    y = f[i][x];
                    F2[i] = y;
                    F3[i] = y;
                    b = rd.nextInt(2);
                    if (b == 0) {
                        c = rd.nextInt(2);
                        if (c == 0) {
                            z = f[i][1];
                            z1=f[i][2];
                            F1[i] = z;
                            F4[i] = z1;
                        }
                        if (c == 1) {
                            z = f[i][1];
                            z1=f[i][2];
                            F4[i] = z;
                            F1[i] = z1;
                        }
                    }
                    if (b == 1) {
                        c = rd.nextInt(2);
                        if (c == 0) {
                            z = f[i][2];
                            z1= f[i][1];
                            F1[i] = z;
                            F4[i] = z1;
                        }
                        if (c == 1) {
                            z = f[i][2];
                            z1= f[i][1];
                            F4[i] = z;
                            F1[i] = z1;
                        }
                    }
                    break;
                }
                if (x == 1 ) {
                    y = f[i][x];
                    F2[i] = y;
                    F3[i] = y;
                    b = rd.nextInt(2);
                    if (b == 0) {
                        c = rd.nextInt(2);
                        if (c == 0) {
                            z = f[i][0];
                            z1= f[i][2];
                            F1[i] = z;
                            F4[i] = z1;
                        }
                        if (c == 1) {
                            z = f[i][0];
                            z1= f[i][2];
                            F4[i] = z;
                            F1[i] = z1;
                        }
                    }
                    if (b == 1) {
                        c = rd.nextInt(2);
                        if (c == 0) {
                            z = f[i][2];
                            z1 = f[i][0];
                            F1[i] = z;
                            F4[i] = z1;
                        }
                        if (c == 1) {
                            z = f[i][2];
                            z1 =f[i][0];
                            F4[i] = z;
                            F1[i] = z1;
                        }
                    }
                    break;
                }
                if (x == 2 ) {
                    y = f[i][x];
                    F2[i] = y;
                    F3[i] = y;
                    b = rd.nextInt(2);
                    if (b == 0) {
                        c = rd.nextInt(2);
                        if (c == 0) {
                            z = f[i][0];
                            z1 =f[i][1];
                            F1[i] = z;
                            F4[i] = z1;
                        }
                        if (c == 1) {
                            z = f[i][0];
                            z1 =f[i][1];
                            F4[i] = z;
                            F1[i] = z1;
                        }
                    }
                    if (b == 1) {
                        c = rd.nextInt(2);
                        if (c == 0) {
                            z = f[i][1];
                            z1 = f[i][0];
                            F1[i] = z;
                            F4[i] =z1;
                        }
                        if (c == 1) {
                            z = f[i][1];
                            z1 = f[i][0];
                            F4[i] = z;
                            F1[i] = z1;
                        }
                    }
                    break;
                }
            }
        }
        for (int i=0; i<4 ; i++){
            for (int j=0; j<noOfSubjects ;j++){
                if(i==0) {
                    F[i][j] = F1[j];
                }
                if(i==1) {
                    F[i][j] = F2[j];
                }
                if(i==2) {
                    F[i][j] = F3[j];
                }
                if(i==3) {
                    F[i][j] = F4[j];
                }
            }
        }
        return F;
    }
}