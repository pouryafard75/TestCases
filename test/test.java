public class test {

   public static void main(String[] args) {
      try {
         db();
      } catch (Throwable e) {
         writer.abort();
         throw Throwables.propagate(e);
      }
   }
}
