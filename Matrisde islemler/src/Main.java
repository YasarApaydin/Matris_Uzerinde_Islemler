import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    private static float determinant;

    public static void main(String[] args) {
        System.out.println("Yaşar Apaydın Yazılım Mühendisliği 2. Sınıf ");
        System.out.println("Matris oluşturmaya ve üzerinde işlemler Yapmaya Hoş Geldiniz.\n");
        matrisolusturma();
    }

    public static void secim(int row, int column, float arr[][]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Lütfen Matrisler Üzerinde Yapmak istediğiniz işlemi seciniz: ");
        System.out.println("Toplama:1");
        System.out.println("Cıkarma:2");
        System.out.println("Carpma:3");
        System.out.println("Sabit Bir sayı ile carpımı:4");
        System.out.println("Matrisin Determinantı:5");
        System.out.println("Matrisin tersi:6");
        System.out.println("Matrisin involutif olup olmadığı sorgulanma:7");
        System.out.println("Tekrardan Matris oluturmak istermisiniz Yeni Secimleriniz İcin? 8");
        System.out.println("Uygulamayı Kapatma: 9");

        int secim = 0;
        secim = scan.nextInt();

        switch (secim) {
            case 1:
                toplama(row, column, arr);

                break;
            case 2:
                cikarma(row, column, arr);
                break;
            case 3:
                carpma(row, column, arr);
                break;
            case 4:
                sabitcarpma(row, column, arr);
                break;
            case 5:
                determinant(row, column, arr);
                break;
            case 6:
                tersi(row, column, arr);
                break;
            case 7:
                involitif(row, column, arr);
                break;
            case 8:
                matrisolusturma();
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("Lütfen Yukardaki verilen sayılardan birini giriniz");
                secim(row, column, arr);
                break;


        }

    }

    public static void matrisolusturma() {
        int column;
        int row;
        Scanner scan = new Scanner(System.in);

        System.out.print("Matrisinizin satır sayısını seciniz: ");
        row = scan.nextInt();
        System.out.print("Matrisinizin Sütun Sayısını seciniz: ");
        column = scan.nextInt();
        float[][] arr = new float[row][column];
        elemangGiris(row, column, arr);
        bastirma(row, column, arr);
        secim(row, column, arr);

    }

    public static void elemangGiris(int c, int d, float dizi[][]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Matirsin elemanlarını girmeye Hazir mısınız.");

        for (int i = 0; i < c; i++) {
            for (int k = 0; k < d; k++) {
                System.out.print(i + " " + k + " Elemanını giriniz.");
                dizi[i][k] = scan.nextInt();
            }
        }
    }

    public static void bastirma(int a, int b, float[][] dizi) {

        for (int i = 0; i < a; i++) {
            for (int k = 0; k < b; k++) {
                System.out.print(dizi[i][k] + "   ");
            }
            System.out.println();
        }

    }


    public static void toplama(int row, int column, float[][] arr) {
        int a, b;
        Scanner scan = new Scanner(System.in);
        System.out.println("\nToplanacak olan  Matrisinizin Değerlerini Giriniz");
        System.out.print("Matrisinizin satır sayısını seciniz: ");
        a = scan.nextInt();
        System.out.print("Matrisinizin sütun sayısını seciniz: ");
        b = scan.nextInt();

        if (a != row || b != column) {
            while (true) {

                System.out.println(" farklı boyutlarda Matrislerde toplama yapılamaz.");
                System.out.print("Matrisinizin satır sayısını seciniz: ");
                a = scan.nextInt();
                System.out.print("Matrisinizin sütun sayısını seciniz: ");
                b = scan.nextInt();
                if (a == row && b == column) {
                    break;
                }
            }
        }
        float[][] topla = new float[a][b];
        elemangGiris(a, b, topla);
        float[][] toplam = new float[a][b];
        for (int k = 0; k < a; k++) {
            for (int t = 0; t < b; t++) {
                toplam[k][t] = topla[k][t] + arr[k][t];
            }
        }

        bastirma(a, b, toplam);
        System.out.println("\nSecime Dönmek İstermisiniz?\nEvet: 1\nHayır: herhangi bir sayı");

        int d = scan.nextInt();
        if ( d == 1) {
            secim(row, column, arr);
        } else {
            System.exit(0);
        }
    }

    public static void cikarma(int row, int column, float[][] arr) {
        int a, b;
        Scanner scan = new Scanner(System.in);
        System.out.println("\nCıkarılacak olan  Matrisinizin Değerlerini Giriniz");
        System.out.print("Matrisinizin satır sayısını seciniz: ");
        a = scan.nextInt();
        System.out.print("Matrisinizin sütun sayısını seciniz: ");
        b = scan.nextInt();

        if (a != row || b != column) {
            while (true) {

                System.out.println(" farklı boyutlarda Matrislerde cıkarma yapılamaz.");
                System.out.print("Matrisinizin satır sayısını seciniz: ");
                a = scan.nextInt();
                System.out.print("Matrisinizin sütun sayısını seciniz: ");
                b = scan.nextInt();
                if (a == row && b == column) {
                    break;
                }
            }
        }
        float[][] cikar = new float[a][b];
        elemangGiris(a, b, cikar);
        float[][] cikan = new float[a][b];
        for (int k = 0; k < a; k++) {
            for (int t = 0; t < b; t++) {
                cikan[k][t] = arr[k][t] - cikar[k][t];
            }
        }

        bastirma(a, b, cikan);
        System.out.println("\nSecime Dönmek İstermisiniz?\nEvet: 1\nHayır: herhangi bir sayı");

        int d = scan.nextInt();
        if (d == 1) {
            secim(row, column, arr);
        } else {
            System.exit(0);
        }
    }

    public static void carpma(int row, int column, float[][] arr) {

        int a, b, t;


        Scanner scan = new Scanner(System.in);
        System.out.println("\nCarpılacak olan olan  Matrisinizin Değerlerini Giriniz");
        System.out.print("Matrisinizin satır sayısını seciniz: ");
        a = scan.nextInt();
        System.out.print("Matrisinizin sütun sayısını seciniz: ");
        b = scan.nextInt();

        if (a != column) {
            while (true) {

                System.out.println("ilk matrisimizin sütun sayısı ile olusturduğumuz matrisin satır sayısı birbirine eşit olması gerek");
                System.out.print("Matrisinizin satır sayısını seciniz: ");
                a = scan.nextInt();

                if (a == column) {
                    break;
                }
            }
        }
        float[][] carp = new float[a][b];
        elemangGiris(a, b, carp);

        float[][] carpim = new float[row][b];
        for (int k = 0; k < row; k++) {
            for (t = 0; t < b; t++) {
                float deger = 0;
                for (int m = 0; m < column; m++) {
                    float sonuc = arr[m][k] * carp[t][m];
                    deger = deger + sonuc;
                }
                carpim[k][t] = deger;
            }

        }

        bastirma(row, b, carpim);
        System.out.println("\nSecime Dönmek İstermisiniz?\nEvet: 1\nHayır: herhangi bir sayı");

        int d = scan.nextInt();
        if (d == 1) {
            secim(row, column, arr);
        } else {
            System.exit(0);
        }
    }

    public static void sabitcarpma(int row, int column, float[][] arr) {
        int c;
        Scanner scan = new Scanner(System.in);
        System.out.println("Matrisleri sabit bir sayı ile carpma");
        System.out.print("Lütfen carpmak istediğiniz sayıyı giriniz: ");
        c = scan.nextInt();
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                arr[i][k] = arr[i][k] * c;

            }
        }
        bastirma(row, column, arr);
        System.out.println("\nSecime Dönmek İstermisiniz?\nEvet: 1\nHayır: herhangi bir sayı");

        int a = scan.nextInt();
        if (a == 1) {
            secim(row, column, arr);
        } else {
            System.exit(0);
        }
    }

    public static void determinant(int row, int column, float[][] arr) {
        Scanner scan = new Scanner(System.in);
        float a, b, c;


        System.out.println("Determinant Hesaplamaya Hoş Geldiniz");
        System.out.println("Bu sistem Sadece 3x3 lük matrislerin Determintını Hesaplar.");
        if (row != 3 || column != 3) {
            while (true) {

                System.out.println("Lütfen Deterrminant icin 3x3 lük bir matris griniz.");
                System.out.print("Lütfen satırı tekrardan giriniz: ");
                row = scan.nextInt();
                System.out.print("Lütfen Sütunu tekrardan giriniz: ");
                column = scan.nextInt();
                if (row == 3 && column == 3) {
                    break;
                }
            }

        }
        a = (arr[0][0] * arr[1][1] * arr[2][2]) - (arr[0][0] * arr[2][1] * arr[1][2]);
        b = -((arr[0][1] * arr[1][0] * arr[2][2]) - (arr[0][1] * arr[2][0] * arr[1][2]));
        c = (arr[0][2] * arr[1][1] * arr[2][1]) - (arr[0][2] * arr[1][1] * arr[2][0]);
        determinant = a + b + c;
        System.out.println("Matrisimizin Determinantı: " + determinant);
        System.out.println("Secime Dönmek İstermisiniz?\nEvet: 1\nHayır: herhangi bir sayı");

        int d = scan.nextInt();
        if (d == 1) {
            secim(row, column, arr);
        } else {
            System.exit(0);
        }
    }

    public static void tersi(int row, int column, float[][] arr) {

        int t;
        Scanner scan = new Scanner(System.in);
        System.out.println("\nMatrislerde Tersini alma  Metodumuza Hoş Geldiniz.");


        if (row != 3 || column != 3) {
            while (true) {

                System.out.println("Matrisimizin Boyutlarını yeniden oluşturunuz");
                System.out.println(" Sadece 3x3  matrisimizin tersi alınır.");
                System.out.print("Matrisinizin satır sayısını seciniz: ");
                System.out.println("Ama determinantda gerek olduğu icin determinant hesaplama fonksiyonumuza gidicegiz.");
                row = scan.nextInt();
                System.out.print("Matrisinizin sütun sayısını seciniz: ");
                column = scan.nextInt();
                if (row == 3 && column == 3) {
                    elemangGiris(row, column, arr);
                    break;
                }
            }
        }

        for (t = 0; t < row; t++) {
            float i = 1;
            for (int m = 0; m < column; m++) {

                i = (float) (arr[t][m] + i);
                if (i == 1) {
                    System.out.println("Aynı Satırdaki 3 sayıda 0 olursa onun tersi yoktur.");
                    System.out.println("Secime tekrar yönlendiriliyorsunuz.");
                    secim(row, column, arr);
                }

            }
        }
        determinant(row, column, arr);
        float[][] dizi = new float[row][column];
        dizi[0][0] = ((arr[1][1] * arr[2][2]) - (arr[2][1] * arr[1][2])) / determinant;
        dizi[1][0] = -((arr[1][0] * arr[2][2]) - (arr[2][0] * arr[1][2])) / determinant;
        dizi[2][0] = ((arr[1][1] * arr[2][1]) - (arr[1][1] * arr[2][0])) / determinant;
        dizi[0][1] = -((arr[0][1] * arr[2][2]) - (arr[0][2] * arr[2][1])) / determinant;
        dizi[1][1] = ((arr[0][0] * arr[2][2]) - (arr[2][0] * arr[0][2])) / determinant;
        dizi[2][1] = -((arr[0][0] * arr[2][1]) - (arr[0][1] * arr[2][0])) / determinant;
        dizi[0][2] = ((arr[0][1] * arr[1][2]) - (arr[1][1] * arr[0][2])) / determinant;
        dizi[1][2] = -((arr[0][0] * arr[1][2]) - (arr[0][2] * arr[1][0])) / determinant;
        dizi[2][2] = ((arr[0][0] * arr[1][1]) - (arr[1][0] * arr[0][1])) / determinant;
        bastirma(row, column, dizi);
        System.out.println("Secime Dönmek İstermisiniz?\nEvet: 1\nHayır: herhangi bir sayı");

        int a = scan.nextInt();
        if (a == 1) {
            secim(row, column, arr);
        } else {
            System.exit(0);
        }
    }


    public static void involitif(int row, int column, float[][] arr) {
        int t;
        Scanner scan = new Scanner(System.in);
        System.out.println("İnvolutif Matrisler Kare Matrislerdir.");

        System.out.println("\nİnvolutif Olup Olmadığına Baktığımız Fonksiyon ");


        if (row != column) {
            while (true) {

                System.out.println(" farklı boyutlarda Matrislerin İnvolutife bakılamaz.");
                System.out.println("Kare Matrislerin özelliklerini Tekrardam giriniz.");
                System.out.print("Matrisinizin satır sayısını seciniz: ");
                row = scan.nextInt();
                System.out.print("Matrisinizin sütun sayısını seciniz: ");
                column = scan.nextInt();
                if (row == column) {
                    break;
                }
            }
        }
        float[][] dizi1 = new float[row][column];

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                if (i == k) {
                    dizi1[i][k] = 1;
                } else {
                    dizi1[i][k] = 0;
                }
            }
        }
        float[][] carpim1 = new float[row][column];
        for (int k = 0; k < row; k++) {
            for (t = 0; t < column; t++) {
                float deger = 0;
                for (int m = 0; m < column; m++) {
                    float sonuc = arr[m][k] * arr[t][m];
                    deger = deger + sonuc;
                }
                carpim1[k][t] = deger;
            }
        }
        bastirma(row, column, carpim1);



        for (int b = 0; b < row; b++) {
            for (int c = 0; c < column; c++) {
                if (carpim1[b][c] != dizi1[b][c]) {
                    System.out.println("Matrisiniz İnvolutif değildir");

                    System.out.println("Secime Dönmek İstermisiniz?\nEvet: 1\nHayır: herhangi bir sayı");
                    int a = scan.nextInt();
                    if (a == 1) {
                        secim(row, column, arr);
                    } else {
                        System.exit(0);
                    }

                }
                if (dizi1[row - 1][column - 1] == 1 && carpim1[row - 1][column - 1] == 1) {
                    System.out.println("Matrisiniz İnvolutifdir Tebrikler\nBizden Altın Madalya Kazandın:)");
                    System.out.println("Secime Dönmek İstermisiniz?\nEvet: 1\nHayır: herhangi bir sayı");

                    int a = scan.nextInt();
                    if (a == 1) {
                        secim(row, column, arr);
                    } else {
                        System.exit(0);
                    }
                }
            }

        }


    }
}




