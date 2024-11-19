package weisner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Enter a image file name:");
            Scanner scanner = new Scanner(System.in);
            BufferedImage image = ImageIO.read(new File("./images/" + scanner.nextLine()));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("./output/out.txt"));

            // loop over the image and convert each pixel to gray scale then ascii
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    Pixel pixel = new Pixel(image.getRGB(j, i));
                    out.write(pixel.toGrayScale().toAscii().getBytes());
                }
                out.write("\n".getBytes());
            }
            out.close();
        } catch (IOException e) {
            System.out.println("ERROR: Cannot open file.");
        }
    }
}