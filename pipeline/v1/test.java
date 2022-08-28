public class test
{
    static public IEnumerable<String> TwitterHandles(IEnumerable<Author> authors, string company) {
        var result = new List<String> ();
        foreach (Author a in authors) {
          if (a.Company == company) {
            var handle = a.TwitterHandle;
            if (handle != null)
              result.Add(handle);
          }
        }
        return result;
      }
}
