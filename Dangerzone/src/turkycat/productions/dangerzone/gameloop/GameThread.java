package turkycat.productions.dangerzone.gameloop;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import turkycat.productions.dangerzone.ApplicationResources;
import turkycat.productions.dangerzone.objects.BasicGameObject;
import turkycat.productions.dangerzone.objects.DrawableItem;
import turkycat.productions.dangerzone.objects.GameObject;
import turkycat.productions.dangerzone.views.GameView;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread
{
	private static final String TAG = "GameThread";

	private GameUpdater updater;
	private boolean running;
	private SurfaceHolder surfaceHolder;
	private GameView gameView;
	private long lastGameUpdate;
	private List<DrawableItem> drawables;

	public GameThread( SurfaceHolder surfaceHolder, GameView gameView )
	{
		super();
		this.running = true;
		this.updater = new GameUpdater();
		this.surfaceHolder = surfaceHolder;
		this.gameView = gameView;
		this.drawables = new LinkedList<DrawableItem>();
		
		GameObject background = new BasicGameObject(
				ApplicationResources.i().getBitmap( "background" ),	//the image bitmap of the background
				new PointF( 0f, 0f ),								//the location relative to the upper left corner (0,0)
				new PointF( gameView.getWidth(), gameView.getHeight() ),	//the width of the background should be equal to the size of our view
						false,										//not collidable
						true,										//moves relative to the world only
						Consts.INITIAL_GAME_SPEED,					//X speed
						0f );										//Y speed
		updater.addObject( background );
		drawables.add( background );
		Log.d( TAG, "finished thread constructor" );
	}

	@Override
	public void run()
	{
		lastGameUpdate = System.currentTimeMillis();
		double loopcount = 0.0;
		DecimalFormat fmt = new DecimalFormat( "##,###,###,###,###,###,###,##0" );

		while( running )
		{
			loopcount++;
			long currentTime = System.currentTimeMillis();
			long elapsed = currentTime - lastGameUpdate;
			lastGameUpdate = currentTime;
			Log.i( TAG, String.format( "game loop executing for the %sth time with %d elapsed millis", fmt.format( loopcount ), elapsed ) );
			updater.update( elapsed / Consts.MILLIS_PER_TIME_UNIT );
			paint();
		}
	}

	public void paint()
	{
		Canvas canvas = null;

		canvas = surfaceHolder.lockCanvas();
		Iterator<DrawableItem> iterator = drawables.iterator();
		while( iterator.hasNext() )
		{
			DrawableItem item = iterator.next();
			item.draw( canvas );
		}
		surfaceHolder.unlockCanvasAndPost( canvas );
	}

	public void exit()
	{
		this.running = false;
	}
}
