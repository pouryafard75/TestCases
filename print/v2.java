public class ConsoleReader
{

private int print(final CharSequence buff, int cursorPos) throws IOException {
    return print(buff, 0, buff.length(), cursorPos);
}

private int print(final CharSequence buff, int start, int end) throws IOException {
    return print(buff, start, end, getCursorPosition());
}

private int print(final CharSequence buff, int start, int end, int cursorPos) throws IOException {
    checkNotNull(buff);
    for (int i = start; i < end; i++) {
        char c = buff.charAt(i);
        if (c == '\t') {
            int nb = nextTabStop(cursorPos);
            cursorPos += nb;
            while (nb-- > 0) {
                out.write(' ');
            }
        } else if (c < 32) {
            out.write('^');
            out.write((char) (c + '@'));
            cursorPos += 2;
        } else {
            int w = WCWidth.wcwidth(c);
            if (w > 0) {
                out.write(c);
                cursorPos += w;
            }
        }
    }
    return cursorPos;
}

/**
 * Output the specified string to the output stream (but not the buffer).
 */
public final void print(final CharSequence s) throws IOException {
    print(s, getCursorPosition());
}

public final void println(final CharSequence s) throws IOException {
    print(s);
    println();
}

/**
 * Output a platform-dependant newline.
 */
public final void println() throws IOException {
    rawPrint(CR);
//        flush();
}
}