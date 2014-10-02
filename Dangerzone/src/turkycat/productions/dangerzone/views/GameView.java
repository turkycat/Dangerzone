package turkycat.productions.dangerzone.views;

import turkycat.productions.dangerzone.gameloop.GameThread;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback
{
	public static final String TAG = "GameView";
	private GameThread thread;

	public GameView( Context context, AttributeSet attrSet)
	{
		super( context );

		getHolder().addCallback( this );
		setFocusable( true );
	}

	@Override
	public void surfaceCreated( SurfaceHolder holder )
	{
		thread = new GameThread( holder, this );
		thread.start();
		Log.d( TAG, "thread started" );
	}

	@Override
	public void surfaceChanged( SurfaceHolder holder, int format, int width, int height )
	{
		
	}

	@Override
	public void surfaceDestroyed( SurfaceHolder holder )
	{
		boolean retry = true;
		thread.exit();
		while( retry )
		{
			try
			{
				thread.join();
				retry = false;
			}
			catch( InterruptedException e )
			{
				//do nothing
			}
		}
	}

	@Override
	public boolean onTouchEvent( MotionEvent event )
	{
		return super.onTouchEvent( event );
	}

	@Override
	protected void onDraw( Canvas canvas )
	{
		super.onDraw( canvas );
	}

}
