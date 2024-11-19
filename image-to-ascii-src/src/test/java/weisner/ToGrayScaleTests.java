package weisner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToGrayScaleTests {
    private static String expected(int r, int g, int b) {
        int value = (int)((0.299 * r) + (0.587 * g) + (0.114 * b));
        return String.format("(%d,%d,%d)",value,value,value);
    }

    // test to see if a pixel will be properly converted to gray scale
    @Test
    public void basicTest() {
        Pixel pixel = new Pixel(PixelHelper.pack(100,200,90));
        assertEquals(ToGrayScaleTests.expected(100,200,90), pixel.toGrayScale().toString());
    }

    // tests if RGB values remain the same after gray scale conversion
    // if they are all the same value
    @Test
    public void sameRgbValues() {
        Pixel pixel = new Pixel(PixelHelper.pack(255,255,255));
        String expected = String.format("(%d,%d,%d)",255,255,255);
        assertEquals(expected, pixel.toGrayScale().toString());
    }

    @Test
    public void falseGrayScale() {
        Pixel pixel = new Pixel(PixelHelper.pack(100,100,90));
        assertEquals(ToGrayScaleTests.expected(100,100,90), pixel.toGrayScale().toString());

        pixel = new Pixel(PixelHelper.pack(100,90,100));
        assertEquals(ToGrayScaleTests.expected(100,90,100), pixel.toGrayScale().toString());

        pixel = new Pixel(PixelHelper.pack(90,100,100));
        assertEquals(ToGrayScaleTests.expected(90,100,100), pixel.toGrayScale().toString());
    }
}
