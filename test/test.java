public class test {

   public static synchronized void loadNewSSTables(String ksName, String cfName) {
      /** ks/cf existence checks will be done by open and getCFS methods for us */
      Keyspace keyspace = Keyspace.open(ksName);
      keyspace.getColumnFamilyStore(cfName).loadNewSSTables();
   }
}
