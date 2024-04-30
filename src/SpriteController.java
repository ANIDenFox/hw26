import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpriteController extends JPanel implements ActionListener, KeyListener {
    private final SpriteModel spriteModel;
    private final Timer timer;

    public SpriteController(SpriteModel spriteModel) {
        this.spriteModel = spriteModel;
        timer = new Timer(100, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(spriteModel.getFrame(), 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        spriteModel.updateFrame();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_D:
                spriteModel.setAnimation(3);
                break;
            case KeyEvent.VK_A:
                spriteModel.setAnimation(2);
                break;
            case KeyEvent.VK_S:
                spriteModel.setAnimation(0);
                break;
            case KeyEvent.VK_W:
                spriteModel.setAnimation(1);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}