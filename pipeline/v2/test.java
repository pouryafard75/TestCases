public class test
{
    public List<String> TwitterHandles(List<Author> authors, String company) {
        return authors.stream()
                .filter(a -> a.getCompany().equals(company))
                .map(a -> a.getTwitterHandle())
                .filter(h -> null != h)
                .collect(toList());
      }
}
