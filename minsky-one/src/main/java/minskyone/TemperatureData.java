package minskyone;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TemperatureData {

    public static String[] getData(final String filename) throws IOException {
        DataInputStream in;
        in = new DataInputStream(new FileInputStream(filename));
        final String[] f = new String[24 * 32];

        for (int y = 0; y < 24; y++) {
            for (int x = 0; x < 32; x++) {
                final float v = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToIntBits(in.readFloat())));
                f[y * 32 + x] = Float.toString(v);
            }
        }
        in.close();

        return f;
    }
}
