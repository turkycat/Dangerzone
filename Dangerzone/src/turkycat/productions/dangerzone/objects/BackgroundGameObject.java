package turkycat.productions.dangerzone.objects;

import turkycat.productions.dangerzone.ApplicationResources;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Shader;

public class BackgroundGameObject extends GameObject
{
	
	private final Paint paint;
	
	private float velocityX;
	
	public BackgroundGameObject( int viewWidth, int viewHeight )
	{
		// Resize the background bitmap to fit the device screen.
		Bitmap b = ApplicationResources.i().getBitmap( "background" );
		b = Bitmap.createScaledBitmap( b, viewWidth, viewHeight, false );
		
		this.dimensions = new PointF( b.getWidth(), b.getHeight() );
		this.location = new PointF( 0, 0 );
		
		/*
		 *  The addition of the shader to the Paint instance simulates
		 *  	a Bitmap of "infinite" width and height where the pixel
		 *  	locations are wrapped around.
		 */
		BitmapShader shader = new BitmapShader( b, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT );
		this.paint = new Paint();
		this.paint.setShader( shader );
		
		this.velocityX = 0.0f;
		
	}
	
	@Override
	public boolean update( float units )
	{	
		// This prevents the matrix from overflowing and doesn't
		//  need to be run every single update. 200 is an arbitrary
		//  number that can be changed. A relatively high number should
		//  be picked to keep us from doing expensive float division.
		if( this.location.x <= -( this.dimensions.x * 200 ) ) {
			this.location.x = this.location.x % this.dimensions.x;
			
		}
		this.location.x += this.velocityX * units;
		this.velocityX -= 0.01f;
		return true;
	}
	
	
	
	@Override
	public void setLocation(PointF p) {
		// The background location can not be changed outside of this class.
		throw new RuntimeException( "Can not set background location." );
	}

	@Override
	public boolean isCollidable() {
		return false;
	}

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public void draw( Canvas canvas )
	{
		// Save the current canvas translation to restore later
		canvas.save();
		
		// Translate to our location
		canvas.translate( this.location.x, 0);
		canvas.drawPaint( this.paint );
		
		// Restore the previous canvas translations
		canvas.restore();
	}
}
