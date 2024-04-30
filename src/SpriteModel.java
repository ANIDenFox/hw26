import java.awt.image.BufferedImage;

public class SpriteModel {
    private int animationIndex;
    private int frameIndex;
    private final BufferedImage[] frames;

    public SpriteModel(BufferedImage[] frames) {
        this.frames = frames;
        this.frameIndex = 0;
        this.animationIndex = 0;
    }

    public void setAnimation(int animationIndex) {
        this.animationIndex = animationIndex;
        this.frameIndex = 0;
    }

    public BufferedImage getFrame() {
        return frames[animationIndex * 4 + frameIndex];
    }

    public void updateFrame() {
        frameIndex = (frameIndex + 1) % 4;
    }
}