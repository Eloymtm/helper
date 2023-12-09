package org.trying;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextToImage {

    public static void main(String[] args) {
        String text = "Hello, World!";
        String imagePath = "/home/eloymtm/Desktop/LDTS/trying/src/main/resources/images/WIZARD.jpg"; // Replace with your image file path
        String outputImagePath = "WIZARD.jpg"; // Output image file path

        convertTextToImage(text, imagePath, outputImagePath);
    }

    public static void convertTextToImage(String text, String imagePath, String outputImagePath) {
        try {
            BufferedImage charImage = ImageIO.read(new File(imagePath));
            int charWidth = charImage.getWidth();
            int charHeight = charImage.getHeight();

            int textWidth = text.length() * charWidth;
            int textHeight = charHeight;

            BufferedImage compositeImage = new BufferedImage(textWidth, textHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = compositeImage.createGraphics();

            int x = 0;
            for (char c : text.toCharArray()) {
                BufferedImage letterImage = createImageForCharacter(c);
                g2d.drawImage(letterImage, x, 0, null);
                x += charWidth;
            }

            g2d.dispose();

            // Save the composite image
            ImageIO.write(compositeImage, "JPG", new File(outputImagePath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage createImageForCharacter(char c) {
        // You can implement your own logic to map characters to images here
        // For simplicity, we'll use the same image for all characters
        return loadImage("/home/eloymtm/Desktop/LDTS/trying/src/main/resources/images/WIZARD.jpg"); // Replace with your character image path
    }

    private static BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
