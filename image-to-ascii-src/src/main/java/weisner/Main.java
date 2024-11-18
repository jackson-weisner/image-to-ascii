package weisner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 1) throw new IOException();
            BufferedImage image = ImageIO.read(new File("./images/" + args[0]));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("./output/out.txt"));

            // loop over the image and convert each pixel to gray scale then ascii
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    RGB values = new RGB(image.getRGB(j, i));
                    out.write(values.toGrayScale().toAscii().getBytes());
                }
                out.write("\n".getBytes());
            }
            out.close();
        } catch (IOException e) {
            System.out.println("ERROR: Cannot open file.");
        }
    }
}