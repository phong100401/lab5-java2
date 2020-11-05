package L5j2;

import java.sql.*;

public class VD {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/ebookshop","root","");

                Statement stmt = conn.createStatement();
        ){
//delete records with id >= 3000 and id <= 4000
            String sqlDelete = "delete from books where id >= 3000 and id <= 4000";
            System.out.println("the SQL statement is: " + sqlDelete + "\n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted.\n");

//insert a record
            String sqlInsert = "Insert into books values(3001,'Gone Fishing','kumar',11.1,1)";
            System.out.println("the SQL statement is " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "records inserted.\n");

//insert multiple records
            sqlInsert = "insert into books value" + "(3002,'Gone Fishing 2','kumar',22.2,22)," + "(3303,'Gome Fishing 3' ,'kumar',33.3,33)";
            System.out.println("the SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "records inserted.\n");

//insert a partial record
            sqlInsert = "INSERT into books(id,title,author) values (3004,'fishing 101','kumar')";
            System.out.println("the SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "record inserted.\n");

//issue a select to check the changes
            String strSelect = "select * from books";
            System.out.println("the SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                System.out.println(rset.getInt("id") + ","
                        + rset.getString("author") + ","
                        + rset.getString("title") + ","
                        + rset.getDouble("price") + ","
                        + rset.getInt("qty"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
