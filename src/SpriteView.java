import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteView {
    public static void Window() {
        BufferedImage[] frames = loadFrames();
        SpriteModel spriteModel = new SpriteModel(frames);
        JFrame frame = new JFrame("SpriteMoving");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(256, 256);
        frame.setResizable(false);
        SpriteController spriteController = new SpriteController(spriteModel);
        frame.add(spriteController);
        frame.setVisible(true);
    }

    private static BufferedImage[] loadFrames() {
        BufferedImage[] frames = new BufferedImage[16];
        for (int i = 0; i < 4; i++) {
            String filename = "tip" + (i + 1) + ".png";
            BufferedImage image = loadImage(filename);
            for (int j = 0; j < 4; j++) {
                frames[i * 4 + j] = image.getSubimage(j * 128, 0, 128, 128);
            }
        }
        return frames;
    }

    private static BufferedImage loadImage(String filename) {
        try {
            return ImageIO.read(SpriteView.class.getResourceAsStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}