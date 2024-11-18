package weisner;

import java.util.Arrays;
import java.util.List;

public class RGB {
    private final static List<Character> asciiMap = Arrays.asList('#', '8', 'O', 'o', ';', ':', '+', '-', '.');
    private int a, r, g, b;
    // unpacks a packedRgb value from a BufferedImage
    public RGB(int packedRgb) {
        this.b = (packedRgb) & 0xFF;
        this.g = (packedRgb >> 8)  & 0xFF;
        this.r = (packedRgb >> 16) & 0xFF;
        this.a = (packedRgb >> 24) & 0xFF;
    }

    // convert the current rgb values to gray scale and return
    // the current instance
    public RGB toGrayScale() {
        if (this.r != this.g) {
            int grayScaleValue = (int)((0.299 * this.r) + (0.587 * this.g) + (0.114 * this.b));
            this.r = grayScaleValue;
            this.g = grayScaleValue;
            this.b = grayScaleValue;
        }
        return this;
    }

    // maps a gray scale rgb value to a value in asciiMap
    public String toAscii() {
        int index = (this.r * (RGB.asciiMap.size()-1)) / 255;
        return new String(new char[]{RGB.asciiMap.get(index), RGB.asciiMap.get(index)});
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%d)", this.r, this.g, this.b);
    }
}
