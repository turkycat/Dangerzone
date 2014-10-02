package turkycat.productions.dangerzone.objects;

import android.graphics.Canvas;
import android.graphics.PointF;

public abstract class GameObject
{
	protected PointF currentPosition;
	
	/**
	 * sets the current position to a copy of the given point
	 */
	public void setPosition( PointF p )
	{
		currentPosition = new PointF( p.x, p.y );
	}
	
	
	/**
	 * retrieves the current position of this item
	 * @return a copy of the current position
	 */
	public PointF getPosition()
	{
		return new PointF( currentPosition.x, currentPosition.y );
	}
	
	
	/**
	 * tells the object to update itself based on a number of units
	 */
	public abstract boolean update( float units );
	
	/**
	 * returns the objects upper-left based coordinates relative to the upper left corner (0,0)
	 */
	public abstract PointF getLocation();
	
	/**
	 * returns the object's height and width
	 */
	public abstract PointF getDimensions();
	
	/**
	 * returns true if the object can collide with other objects
	 */
	public abstract boolean isCollidable();
	
	/**
	 * returns true if the object will never move
	 */
	public abstract boolean isStatic();
	
	/**
	 * tells the object to draw itself on the provided canvas
	 */
	public abstract void draw( Canvas canvas );
}
