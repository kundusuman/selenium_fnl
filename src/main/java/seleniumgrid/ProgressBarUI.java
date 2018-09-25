package seleniumgrid;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;



	public class ProgressBarUI extends BasicProgressBarUI {

	    private int numFrames = 200;

	    public enum AnimationDirection {
	        UP_TO_DOWN,
	        DOWN_TO_UP
	    }

	    private AnimationDirection direction = AnimationDirection.DOWN_TO_UP;

	    public ProgressBarUI() {
	        startAnimationTimer();
	    }
	    private BufferedImage barImage = createRippleImage(Color.LIGHT_GRAY ,Color.white);

	    // Create an image with alternating light and dark patterns
	    protected BufferedImage createRippleImage(Color darkColor, Color lightColor) {
	        int width = 40;
	        int height = 40;

	        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2 = image.createGraphics();

	        GradientPaint darkToLight = new GradientPaint(new Point2D.Double(0,0), darkColor, new Point2D.Double(height/2, 0), lightColor);
	        GradientPaint lightToDark = new GradientPaint(new Point2D.Double(height/2,0), lightColor, new Point2D.Double(height, 0), darkColor);
	        g2.setPaint(darkToLight);
	        g2.fillRect(0, 0, height/2, width);
	        g2.setPaint(lightToDark);
	        g2.fillRect(width/2, 0, height/2, width);
	        return image;
	    }

	    public AnimationDirection getDirection() {
	        return direction;
	    }

	    public void setDirection(AnimationDirection direction) {
	        this.direction = direction;
	    }

	    @Override
	    protected void incrementAnimationIndex() {
	        int newValue = getAnimationIndex() + 1;
	        if (newValue < numFrames) {
	            setAnimationIndex(newValue);
	        } else {
	            setAnimationIndex(0);
	        }
	    }

	    @Override
	    protected void paintDeterminate(Graphics g, JComponent c) {
	        // We are only going to deal with horizontal painting
	        if (progressBar.getOrientation() != JProgressBar.HORIZONTAL) {
	            super.paintDeterminate(g, c);
	            return;
	        }

	        /*
	         Copied from the BasicProgressBar code - calculates the actual dimensions of
	         the progress bar area, discounting the insets etc
	        */
	        Insets b = progressBar.getInsets(); // area for border
	        int barRectWidth = progressBar.getWidth() - (b.right + b.left);
	        int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);

	        if (barRectWidth <= 0 || barRectHeight <= 0) {
	            return;
	        }

	        // amount of progress to draw; measured in pixels
	        int amountFull = getAmountFull(b, barRectWidth, barRectHeight);


	        // Make sure we only draw in the region of the progress bar.  This allows
	        // us to be sloppy with our drawing (which is impossible to avoid when
	        // dealing with the drawImage commands) and yet still avoid bad artifacts
	        g.setClip(b.left, b.top, amountFull, barRectHeight);


	        // Here we calculate a pixel offset by which to shift all of our tiled images.
	        // If we're moving right to left, then we offset by a decreasing amount each
	        // tick.  If we're moving left to right, we do the opposite.
	        int offset = 0;
	        if (direction == AnimationDirection.UP_TO_DOWN) {
	            offset = (int) (map(getAnimationIndex(), 0, numFrames, barImage.getWidth(), 0));
	        }
	        else {
	            offset = (int) (map(getAnimationIndex(), 0, numFrames, 0, barImage.getWidth()));
	        }

	        // How many repetitions of the image need to be drawn to ensure that
	        // a full progress bar has no gaps in the image?
	        int numRepetitions = progressBar.getWidth() / barImage.getWidth();
	        // ensure both sides have full coverage just to be safe
	        numRepetitions += 2;

	        for (int i = 0; i < numRepetitions; i++) {
	            // The first image we want drawn to the left, even offscreen if
	            // necessary.
	            int xOffset = (i - 1) * barImage.getWidth() + offset;
	            g.drawImage(barImage, xOffset, 0, null);
	        }
	    }


	    public static double map(double value, double low1, double high1, double low2, double high2) {

	        double diff = value - low1;
	        double proportion = diff / (high1 - low1);

	        return lerp(low2, high2, proportion);
	    }
	    public static double lerp(double value1, double value2, double amt) {
	        return ((value2 - value1) * amt) + value1;
	    }
	
}