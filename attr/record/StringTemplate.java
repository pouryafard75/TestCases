public class StringTemplate{
    public static String interpolationOfJSONBlock(String feelsLike, String temperature, String unit) {
        return STR
                . """
      {
        "feelsLike": "\{ feelsLike }",
        "temperature": "\{ temperature }",
        "unit": "\{ unit }"
      }
      """ ;
    }

    public static void main(String[] args) {
        interpolationOfJSONBlock("a","b","c");
    }
}