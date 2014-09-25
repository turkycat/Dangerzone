package turkcat.productions.dangerzone.drawables;

import android.graphics.Point;

public abstract class GameObject
{
	protected Point currentPosition;
	
	/**
	 * sets the current position to a copy of the given point
	 */
	public void setPosition( Point p )
	{
		currentPosition = new Point( p.x, p.y );
	}
	
	/**
	 * retrieves the current position of this item
	 * @return a copy of the current position
	 */
	public Point getPosition()
	{
		return new Point( currentPosition.x, currentPosition.y );
	}
	
}
