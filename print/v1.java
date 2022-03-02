public class ConsoleReader
{

private void print(final int c) throws IOException {
    if (c == '\t') {
        char chars[] = new char[TAB_WIDTH];
        Arrays.fill(chars, ' ');
        out.write(chars);
        return;
    }

    out.write(c);
}

/**
 * Output the specified characters to the output stream without manipulating the current buffer.
 */
private void print(final char... buff) throws IOException {
    int len = 0;
    for (char c : buff) {
        if (c == '\t') {
            len += TAB_WIDTH;
        }
        else {
            len++;
        }
    }

    char chars[];
    if (len == buff.length) {
        chars = buff;
    }
    else {
        chars = new char[len];
        int pos = 0;
        for (char c : buff) {
            if (c == '\t') {
                Arrays.fill(chars, pos, pos + TAB_WIDTH, ' ');
                pos += TAB_WIDTH;
            }
            else {
                chars[pos] = c;
                pos++;
            }
        }
    }

    out.write(chars);
}

private void print(final char c, final int num) throws IOException {
    if (num == 1) {
        print(c);
    }
    else {
        char[] chars = new char[num];
        Arrays.fill(chars, c);
        print(chars);
    }
}

/**
 * Output the specified string to the output stream (but not the buffer).
 */
public final void print(final CharSequence s) throws IOException {
    print(checkNotNull(s).toString().toCharArray());
}

public final void println(final CharSequence s) throws IOException {
    print(checkNotNull(s).toString().toCharArray());
    println();
}

/**
 * Output a platform-dependant newline.
 */
public final void println() throws IOException {
    print(CR);
//        flush();
}
}