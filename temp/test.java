public class test {
    public static void main(String[] args) {
        if (value == y) {
            buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(years), count, '0') : Integer.toString(years));
            lastOutputSeconds = false;
        } else if (value == M) {
            buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(months), count, '0') : Integer.toString(months));
            lastOutputSeconds = false;
        } else if (value == d) {
            buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(days), count, '0') : Integer.toString(days));
            lastOutputSeconds = false;
        } else if (value == H) {
            buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(hours), count, '0') : Integer.toString(hours));
            lastOutputSeconds = false;
        } else if (value == m) {
            buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(minutes), count, '0') : Integer.toString(minutes));
            lastOutputSeconds = false;
        } else if (value == s) {
            buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(seconds), count, '0') : Integer.toString(seconds));
            lastOutputSeconds = true;
        } else if (value == S) {
            if (lastOutputSeconds) {
                milliseconds += 1000;
                String str = padWithZeros ? StringUtils.leftPad(Integer.toString(milliseconds), count, '0') : Integer.toString(milliseconds);
                buffer.append(str.substring(1));
            } else {
                buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(milliseconds), count, '0') : Integer.toString(milliseconds));
            }
            lastOutputSeconds = false;
        }
    }
}
