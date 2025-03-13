/*========================================================================
//  Public Class MoveImage
//  Author:     Charles Kann
//  Date:       Sept. 3, 1999
//  Purpose:    This class moves two objects (a ball and a rectangle) up/down on the screen
======================================================================== */
import java.awt.*;
import animator.*;

/**========================================================================
    This is the main class.  Create the animator, and then create the
    objects to animate.  The objects add themselves to the animator.  This
    is in case they do not want to be drawn immediately.
======================================================================== */
public class MoveImage implements DrawListener {

    public static void main(String args[]) {
        Animator animator = new Animator();
        new MoveImage(animator, MoveImage.UP, 1);
    }


    static final int UP = 1;
    static final int DOWN = 0;
    private int direction = DOWN;

    private Path myPath;
    private Point myPosition = new Point(10,10);
    private int myNumber;
    Animator animator;
    Image rider1;


    /** Constructor - Simply register myself with the animator.
    */
    public MoveImage(Animator anim, int direction, int myNumber) {
        this.direction = direction;
	this.animator = anim;
        anim.addDrawListener(this);
        this.myNumber = myNumber;
        Toolkit TK = Toolkit.getDefaultToolkit();
        rider1 = TK.getImage("Rider1.gif");

    }

    /** Draw is called each time through the animator loop to draw the
    *   object. It simply
    *   uses the path to calculate the position of this object, and then
    *   draws itself at that position.
    */
    public void draw(DrawEvent de) {
        Graphics g = de.getGraphics();
        if (myPath != null && myPath.hasMoreSteps())
            myPosition = myPath.nextPosition();
        else {
            // Get a random number of steps to make the image move
            // at different speeds.  Note there has to be at least
            // 1 step in each path, but for appearances we used at least
            // 10 steps.
            int numberOfSteps = (int) (10.0 + (Math.random() * 100.0));

            if (direction == DOWN) {
                myPath = new Path(410, 410, 10, 10, numberOfSteps);
                myPosition = myPath.nextPosition();
                direction = UP;
            }
            else {
                myPath = new Path(10, 10, 410, 410, numberOfSteps);
                myPosition = myPath.nextPosition();
                direction = DOWN;
            }
        }
        g.drawImage(rider1, myPosition.x, myPosition.y, animator);
    }
}
