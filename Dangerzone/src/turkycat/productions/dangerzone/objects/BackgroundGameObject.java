package turkycat.productions.dangerzone.objects;

import turkycat.productions.dangerzone.ApplicationResources;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Shader;

public class BackgroundGameObject extends GameObject
{
	
	private final Paint paint;
	
	// New matrices require a native allocation. We cache ours
	//  to reduce the amount of GC pressure.
	//
	//  NOTE: Might want to replace this with some sort of matrix
	//		cache for the entire application, but works for now.
	private final Matrix matrix;
	
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
		
		this.matrix = new Matrix();
		
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
		this.matrix.setTranslate( this.location.x, this.location.y );
		
		// Update the shader's local matrix to represent the new position.
		this.paint.getShader().setLocalMatrix( this.matrix );
		// This draws the entire clip region of the canvas using the given paint.
		canvas.drawPaint( this.paint );
	}
}
