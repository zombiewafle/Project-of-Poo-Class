package patterns;

import java.awt.*;

public class DoubleBufferedCanvas extends Canvas {
    public void update(Graphics g){
        Graphics offgc;
        Image offscreen = null;
        Dimension d = size();

        offscreen = createImage(d.width, d.height);
        offgc = offscreen.getGraphics();
        offgc.setColor(getBackground());
        offgc.fillRect(0,0, d.width, d.height);
        offgc.setColor(getForeground());
        paint(offgc);
        g.drawImage(offscreen,0,0, this);
    }
}
