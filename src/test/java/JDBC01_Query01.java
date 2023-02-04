import java.sql.*;

public class JDBC01_Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1- ilgili driveri yuklemeliyiz. MySQL kullandigimizi bildiriyoruz

        // driveri bulamama ihtimaline karsi bizden forname methdu icin
        // ClassNotFoundException method signature imiza exception olarak
        //firlatmamizi istiyor
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2- baglantiyi olusturmak icin username ve password girmeliyiz
        // burada bu username ve pasword un yanlis olma ihtimaline karsi bir SQLException firlatmamizi istiyor
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "12341234");


        //3- SQL queryleri icin bir statement objesi olusturup, javada SQL sorugularimiz icin bir alan acacagiz

        Statement st = con.createStatement();

        //4- SQL querylerimizi yazip calistirabilirz

        ResultSet veri=st.executeQuery("SELECT * FROM personel");

        //5- sonuclari gormek icin iterator ile set iceersindeki elemanlari while dongusu ile yazdiriyoruz

        while (veri.next()){
            System.out.println(veri.getInt(1)+" "+veri.getString(2)+" "+ veri.getString(3)+" "+
                    veri.getInt(4)+ " "+ veri.getString(5));
        }

        //6- olusturulan baglantilari kapatiyoruz

        con.close();
        st.close();
        veri.close();

/*
123456789 Ali Seker Istanbul 2500 Honda
234567890 Ayse Gul Istanbul 1500 Toyota
345678901 Veli Yilmaz Ankara 3000 Honda
456789012 Veli Yilmaz Izmir 1000 Ford
567890123 Veli Yilmaz Ankara 7000 Hyundai
456789012 Ayse Gul Ankara 1500 Ford
123456710 Fatma Yasa Bursa 2500 Honda
 */







    }

}
