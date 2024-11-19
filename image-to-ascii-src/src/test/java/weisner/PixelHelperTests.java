package weisner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PixelHelperTests {
    // test for PixelHelper.pack method
    @Test
    public void pixelHelperTest() {
        Pixel pixel = new Pixel(PixelHelper.pack(255,255,255));
        assertEquals("(255,255,255)", pixel.toString());
        pixel = new Pixel(PixelHelper.pack(0,0,0));
        assertEquals("(0,0,0)", pixel.toString());
        pixel = new Pixel(PixelHelper.pack(123,55,81));
        assertEquals("(123,55,81)", pixel.toString());
    }
}
