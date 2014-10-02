package turkycat.productions.dangerzone.objects;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;

public class BasicGameObject extends GameObject
{
	private Bitmap bitmap;
	private PointF location;
	private PointF dimensions;
	private boolean isCollidable;
	private boolean isStatic;
	private float velocityX;
	private float velocityY;
	
	public BasicGameObject( PointF location, PointF dimensions, boolean isCollidable, boolean isStatic )
	{
		this( location, dimensions, isCollidable, isStatic, 0.0f, 0.0f );
	}
	
	public BasicGameObject( PointF location, PointF dimensions, boolean isCollidable, boolean isStatic, float velocityX, float velocityY )
	{
		this.bitmap = null;
		this.location = new PointF( location.x, location.y );
		this.dimensions = new PointF( dimensions.x, dimensions.y );
		this.isCollidable = isCollidable;
		this.isStatic = isStatic;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
	}
	
	public BasicGameObject( Bitmap bitmap, boolean isCollidable, boolean isStatic )
	{
		this( bitmap, isCollidable, isStatic, 0.0f, 0.0f );
	}
	
	public BasicGameObject( Bitmap bitmap, boolean isCollidable, boolean isStatic, float velocityX, float velocityY )
	{
		if( bitmap == null ) throw new IllegalArgumentException( "cannot have null bitmap, use a different constructor" );
		
		
	}

	@Override
	public boolean update( float units )
	{
		location = new PointF( location.x * ( velocityX * units ), location.y * ( velocityY * units ) );
		return true;
	}

	@Override
	public PointF getLocation()
	{
		return new PointF( location.x, location.y );
	}

	@Override
	public PointF getDimensions()
	{
		return new PointF( dimensions.x, dimensions.y );
	}

	@Override
	public boolean isCollidable()
	{
		return isCollidable;
	}

	@Override
	public boolean isStatic()
	{
		return isStatic;
	}

	@Override
	public void draw( Canvas canvas )
	{
		if( bitmap == null ) return;
		
	}

}
