public class IOC {

   public static void main(String args[]){
      IoC container = new IoC();
      User user = container.new User(container.new MySqlDatabase());
      user.add("I have some data.Please persist");
   }
   
   
   /** Business Layer Logic **/
   public class User {
     Database database;
     
     public User(Database database){
        this.database = database;
     }
     
     public void add(String data){
       database.persist(data);
     }
   }
   
   
   /** Database Layer Logic**/
   public interface Database{
      void persist(String data);
   }
   
   public MySqlDatabase implements Database{
       void persist(String data){
         System.out.println("Mysql persisted data "+ data);
       }
   }
   
   public OracleDatabase implements Database{
       void persist(String data){
         System.out.println("Oracle persisted data "+ data);
       }
   }
   
   
