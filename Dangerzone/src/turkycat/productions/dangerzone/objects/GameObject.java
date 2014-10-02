package turkycat.productions.dangerzone.objects;

import android.graphics.PointF;
import android.util.Log;

public abstract class GameObject implements DrawableItem, Cloneable
{
	public static final String TAG = "GameObject";
	protected PointF location;
	protected PointF dimensions;
	
	/**
	 * sets the current position to a copy of the given point
	 */
	public void setLocation( PointF p )
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
	public PointF getDimensions()
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
	
	@Override
	public Object clone()
	{
		GameObject o = null;
		
		try
		{
		o = (GameObject) super.clone();
		
		o.location = new PointF( this.location.x, this.location.y );
		o.dimensions = new PointF( this.dimensions.x, this.dimensions.y );
		
		}
		catch( CloneNotSupportedException e )
		{
			Log.d( TAG, "threw CloneNotSupportedException" );
		}
		
		return o;
	}
}
