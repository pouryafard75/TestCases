public class StringTemplate{
    public String interpolationOfJSONBlock(String feelsLike, String temperature, String unit) {
    return STR
      . """
      {
        "feelsLike": "\{ feelsLike }",
        "temperature": "\{ temperature }",
        "unit": "\{ unit }"
      }
      """ ;
    }
}