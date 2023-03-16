public class test {
    public static void main(String[] args) {
        if(value == y) {
            buffer.append( padWithZeros ? StringUtils.leftPad(""+years, count, "0") : ""+years ); 
        } else
        if(value == M) {
            buffer.append( padWithZeros ? StringUtils.leftPad(""+months, count, "0") : ""+months ); 
        } else
        if(value == d) {
            buffer.append( padWithZeros ? StringUtils.leftPad(""+days, count, "0") : ""+days ); 
        } else
        if(value == H) {
            buffer.append( padWithZeros ? StringUtils.leftPad(""+hours, count, "0") : ""+hours ); 
        } else
        if(value == m) {
            buffer.append( padWithZeros ? StringUtils.leftPad(""+minutes, count, "0") : ""+minutes ); 
        } else
        if(value == s) {
            buffer.append( padWithZeros ? StringUtils.leftPad(""+seconds, count, "0") : ""+seconds ); 
        } else
        if(value == S) {
            buffer.append( padWithZeros ? StringUtils.leftPad(""+milliseconds, count, "0") : ""+milliseconds ); 
        }
    }
}
