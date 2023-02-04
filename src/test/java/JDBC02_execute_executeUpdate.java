import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02_execute_executeUpdate {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
    A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet)
       dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC'de 2 alternatif bulunmaktadir.
        1) execute() metodu--boolean dondurur
        2) executeUpdate() metodu.----int deger dondurur
    B) - execute() metodu her tur SQL ifadesiyle kullanibilen genel bir komuttur.
       - execute(), Boolean bir deger dondurur. DDL islemlerinde false dondururken,
         DML islemlerinde true deger dondurur.
       - Ozellikle, hangi tip SQL ifadesine hangi methodun uygun oldugunun bilinemedigi
         durumlarda tercih edilmektedir.
    C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
       - bu islemlerde islemden etkilenen satir sayisini dondurur.
       - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
 */
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "12341234");
        Statement st = con.createStatement();

/*======================================================================
ORNEK1: insanlar tablosunu siliniz.
  ========================================================================*/

    //   String dropQuery= "DROP TABLE cocuk";

      //  System.out.println(st.execute(dropQuery));

        //if(!st.execute(dropQuery)){
        //    System.out.println("ogrenciler tablosu silindi!");
     //   }
/*=======================================================================
          ORNEK2: isciler adinda bir tablo olusturunuz id int,
          birim VARCHAR(10), maas int
        ========================================================================*/

        String createTable = "CREATE TABLE isciler5" +
                "(id INT, " +
                "birim VARCHAR(10), " +
                "maas INT)";

          if (!st.execute(createTable)){
                System.out.println("isciler tablosu olusturuldu");
          }
      //  st.execute(createTable);
        con.close();
        st.close();


    }
}
