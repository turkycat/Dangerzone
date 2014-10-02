package turkycat.productions.dangerzone.objects;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;

public class BasicGameObject extends GameObject
{
	public static final String TAG = "BasicGameObject";
	protected Bitmap bitmap;
	protected boolean isCollidable;
	protected boolean isStatic;
	protected float velocityX;
	protected float velocityY;

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

	public BasicGameObject( Bitmap bitmap, PointF location, boolean isCollidable, boolean isStatic )
	{
		this( bitmap, location, isCollidable, isStatic, 0.0f, 0.0f );
	}

	public BasicGameObject( Bitmap bitmap, PointF location, boolean isCollidable, boolean isStatic, float velocityX, float velocityY )
	{
		this( bitmap, location, new PointF( ( bitmap == null ? 1f : bitmap.getWidth() ), ( bitmap == null ? 1f : bitmap.getHeight() ) ), isCollidable, isStatic, velocityX, velocityY );
	}

	public BasicGameObject( Bitmap bitmap, PointF location, PointF dimensions, boolean isCollidable, boolean isStatic, float velocityX, float velocityY )
	{
		if( bitmap == null ) throw new IllegalArgumentException( "cannot have null bitmap, use a different constructor" );

		this.bitmap = bitmap;
		this.location = new PointF( location.x, location.y );
		this.dimensions = new PointF( dimensions.x, dimensions.y );
		this.isCollidable = isCollidable;
		this.isStatic = isStatic;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
	}

	public void setVelocityX( float velocity )
	{
		this.velocityX = velocity;
	}

	public void setVelocityY( float velocity )
	{
		this.velocityX = velocity;
	}

	@Override
	public boolean update( float units )
	{
		location.set( new PointF( location.x + ( velocityX * units ), location.y + ( velocityY * units ) ) );
		//		Log.d( TAG, String.format( "units: %f, velocityX: %f |*|: %f", units, velocityX, (velocityX * units) ) );
		return true;
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
		canvas.drawBitmap( bitmap, null, new Rect( (int) location.x, (int) location.y, (int) ( location.x + dimensions.x ), (int) ( location.y + dimensions.y ) ), new Paint() );
	}

	@Override
	public Object clone()
	{
		BasicGameObject o = (BasicGameObject) super.clone();

		o.bitmap = this.bitmap;
		o.isCollidable = this.isCollidable;
		o.isStatic = this.isStatic;
		o.velocityX = this.velocityX;
		o.velocityY = this.velocityY;

		return o;
	}
}
