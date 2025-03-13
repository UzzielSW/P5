// dbrowset.java
import sun.jdbc.rowset.JdbcRowSet;
public class JdbcRS {
   public static void main(String[] args){
        try {
              //Instantiate a JdbcRowSet object
              JdbcRowSet jrs = new JdbcRowSet();
              //Load driver and set connection parameters                                          
               Class.forName("oracle.jdbc.driver.OracleDriver");
              jrs.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
              jrs.setUsername("username");
              jrs.setPassword("mypwd");
              //Set and execute the command
              String sql;
              sql = "SELECT SSN, Name, Salary, Hiredate FROM Employees";
              jrs.setCommand(sql);
              jrs.execute();
              //Display values
              while(jrs.next()){
                            System.out.print("SSN: " + jrs.getInt("ssn"));
                            System.out.print(", Name: " + jrs.getString("name"));
                            System.out.print(", Salary: $" + jrs.getDouble("salary"));
                            System.out.print(", HireDate: " + jrs.getDate("hiredate"));
                            System.out.println();
              }
              //Close the resource
                            jrs.close();
              }catch (SQLException se){
                          System.out.println(se);
              }catch (Exception ex) {
                          System.out.println(ex);
              }
                            //Say goodbye
                            System.out.println("Goodbye!");
}//end main
}// end JdbcRs
