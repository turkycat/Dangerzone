package turkycat.productions.dangerzone.objects;

import android.graphics.Canvas;
import android.graphics.PointF;

public abstract class GameObject implements DrawableItem
{
	protected PointF location;
	protected PointF dimensions;
	
	/**
	 * sets the current position to a copy of the given point
	 */
	public void setPosition( PointF p )
	{
		location = new PointF( p.x, p.y );
	}
	
	
	/**
	 * retrieves the current position of this item
	 * @return a copy of the current position
	 */
	public PointF getLocation()
	{
		return new PointF( location.x, location.y );
	}
	
	/**
	 * returns the object's height and width
	 */
	public abstract PointF getDimensions()
	{
		return new PointF( dimensions.x, dimensions.y );
	}
	
	
	/**
	 * tells the object to update itself based on a number of units
	 */
	public abstract boolean update( float units );
	
	/**
	 * returns true if the object can collide with other objects
	 */
	public abstract boolean isCollidable();
	
	/**
	 * returns true if the object will never move
	 */
	public abstract boolean isStatic();
}
