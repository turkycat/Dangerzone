package turkycat.productions.dangerzone.objects;

import turkycat.productions.dangerzone.ApplicationResources;
import turkycat.productions.dangerzone.gameloop.Consts;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

public class BackgroundGameObject extends BasicGameObject
{
	private final int viewWidth;
	private final int viewHeight;
	
	public BackgroundGameObject( int viewWidth, int viewHeight )
	{
		super(ApplicationResources.i().getBitmap( "background" ), //the image bitmap of the background
				new PointF( 0f, 0f ), //the location relative to the upper left corner (0,0)
				new PointF( viewWidth, viewHeight ), //the width of the background should be equal to the size of our view
				false, //not collidable
				true, //moves relative to the world only
				0f, //X speed
//				-Consts.INITIAL_GAME_SPEED, //X speed
				0f ); //Y speed
		this.viewWidth = viewWidth;
		this.viewHeight = viewHeight;
	}
	
	@Override
	public boolean update( float units )
	{
		super.update( units );
		velocityX -= 0.01f;
		if( location.x < -viewWidth )
		{
			location = new PointF( location.x + viewWidth, location.y );
		}
		return true;
	}
	
	
	@Override
	public void draw( Canvas canvas )
	{
		synchronized( this )
		{
			if( bitmap == null ) return;
			canvas.drawBitmap( bitmap, null, new Rect( (int) location.x, (int) location.y, (int) ( location.x + dimensions.x ), (int) ( location.y + dimensions.y ) ), new Paint() );
			canvas.drawBitmap( bitmap, null, new Rect( (int) (location.x + viewWidth), (int) location.y, (int) ( location.x + viewWidth + dimensions.x ), (int) ( location.y + dimensions.y ) ), new Paint() );
		}
	}
}
