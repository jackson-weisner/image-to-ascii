package weisner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToAsciiTests {
    // checks if a pixel that is already grayscale returns the correct ascii string
    @Test
    public void alreadyGrayScale() {
        Pixel pixel = new Pixel(PixelHelper.pack(0,0,0));
        assertEquals("..", pixel.toGrayScale().toAscii());
    }

    // checks if the ascii string is correct after converting the pixel to grayscale
    @Test
    public void grayScaleThenAscii() {
        Pixel pixel = new Pixel(PixelHelper.pack(90, 87, 200));
        assertEquals("::", pixel.toGrayScale().toAscii());
    }
}
