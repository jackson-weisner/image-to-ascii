package weisner;

public class PixelHelper {
    // this method packs 4 integers into one which is the format expected for
    // the Pixel constructor
    public static int pack(int r, int g, int b) {
        return 0xFF000000 | ((r << 16) & 0x00FF0000) | ((g << 8) & 0x0000FF00) | (b & 0x000000FF);
    }
}
