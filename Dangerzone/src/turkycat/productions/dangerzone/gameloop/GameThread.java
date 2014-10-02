package turkycat.productions.dangerzone.gameloop;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import turkycat.productions.dangerzone.objects.DrawableItem;
import turkycat.productions.dangerzone.views.GameView;
import android.graphics.Canvas;
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

	public GameThread( SurfaceHolder surfaceHolder, GameView gamePanel )
	{
		super();
		this.updater = new GameUpdater();
		this.surfaceHolder = surfaceHolder;
		this.gameView = gamePanel;
		this.drawables = new LinkedList<DrawableItem>();
	}

	public GameThread()
	{
		this.running = true;
	}

	@Override
	public void run()
	{
		lastGameUpdate = System.currentTimeMillis();
		double loopcount = 0.0;
		DecimalFormat fmt = new DecimalFormat( "##,###,###,###,###,###,#,##0." );

		while( running )
		{
			loopcount++;
			long currentTime = System.currentTimeMillis();
			long elapsed = currentTime - lastGameUpdate;
			lastGameUpdate = currentTime;
			Log.i( TAG, String.format( "game loop executing for the %fth time with %d elapsed millis", fmt.format( loopcount ), elapsed ) );

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
