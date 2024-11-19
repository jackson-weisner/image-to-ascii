package weisner;

import java.util.Arrays;
import java.util.List;

public class Pixel {
    private final static List<Character> asciiMap = Arrays.asList('.', '-', '+', ':', ';', 'o', 'O', '8', '#');
    private int r, g, b;
    // unpacks a packedRgb value from a BufferedImage
    public Pixel(int packedRgb) {
        this.b = (packedRgb) & 0xFF;
        this.g = (packedRgb >> 8)  & 0xFF;
        this.r = (packedRgb >> 16) & 0xFF;
    }

    // convert the current rgb values to gray scale and return
    // the current instance
    public Pixel toGrayScale() {
        if (this.r != this.g) {
            int grayScaleValue = (int)((0.299 * this.r) + (0.587 * this.g) + (0.114 * this.b));
            this.r = this.g = this.b = grayScaleValue;
        }
        return this;
    }

    // maps a gray scale rgb value to a value in asciiMap
    public String toAscii() {
        int index = (this.r * (Pixel.asciiMap.size()-1)) / 255;
        return new String(new char[]{Pixel.asciiMap.get(index), Pixel.asciiMap.get(index)});
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%d)", this.r, this.g, this.b);
    }
}
