import java.sql.*;

public class JDBC02_Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "12341234");
        Statement st = con.createStatement();

        /*=======================================================================
         ORNEK1: Id'si 1'den buyuk firmalarin ismini ve iletisim_isim'ini isim
         ters sirali yazdirin.
        ========================================================================*/
        /*
        CREATE TABLE firmalar
        (
        id INT,
        isim VARCHAR(20),
        iletisim_isim VARCHAR(20),
        CONSTRAINT firmalar_pk PRIMARY KEY (id, isim)
        );

        INSERT INTO firmalar VALUES
        (1, 'ACB', 'Ali Can'),
        (2, 'RDB', 'Veli Gul'),
        (3, 'KMN', 'Ayse Gulmez');
         */

        String selectquery="SELECT isim, iletisim_isim "+
                            "FROM firmalar "+
                            "WHERE id>1 "+
                            "ORDER BY isim DESC";
        String selectquery1="SELECT isim iletisim_isim FROM firmalar WHERE id>1 ORDER BY isim DESC";

        ResultSet data=st.executeQuery(selectquery);

        while (data.next()){
            System.out.println(data.getString("isim")+ " "+ data.getString("iletisim_isim"));
        }
        System.out.println("====================ORNEK 2=========================");
/*=======================================================================
         ORNEK2: Iletisim isminde 'li' iceren firmalarin id'lerini ve isim'ini
          id sirali yazdirin.
        ========================================================================*/


        String selectquery3="SELECT id, isim FROM firmalar WHERE iletisim_isim LIKE '%li%' ORDER BY id";

        ResultSet data2=st.executeQuery(selectquery3);

        while (data2.next()){
            System.out.println(data2.getInt("id")+" "+ data2.getString("isim"));
        }

/*
KRM Ayse Gulmez
FDS Veli Gul
====================ORNEK 2=========================
4 FDS
 */
// NOT1 : Sorgulama icin get ile istenirse sütun (field) ismini yazabilecegimiz gibi sutun index
        // (field olusturulma sirasina gore) yazilabilir.
        // NOT2 : Sorgumuzda SELECT'ten sonra sadece belli fieldlari dondurmesini istiyorsak
        // get ile cagirdigimiz field indexleri sorguda belirttigimiz sirayla ifade etmemiz gerekiyor

con.close();
st.close();
data2.close();
data.close();
    }
}
    git init
    git add README.md
        git commit -m "first commit"
        git branch -M main
        git remote add origin https://github.com/yusufk06/JDBC.git
        git push -u origin main