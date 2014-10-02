package turkycat.productions.dangerzone.objects;

import android.graphics.Canvas;
import android.graphics.Point;

public interface DrawableItem
{
	/**
	 * tells the object to draw itself on the provided canvas
	 */
	public abstract void draw( Canvas canvas );
}
