package turkycat.productions.dangerzone.gameloop;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import turkycat.productions.dangerzone.views.GameView;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread
{
	private static final String TAG = "GameThread";
	private boolean running;
	private SurfaceHolder surfaceHolder;
	private GameView gamePanel;
	private long lastGameUpdate;
	
	public GameThread(SurfaceHolder surfaceHolder, GameView gamePanel)
	{
	    super();
	    this.surfaceHolder = surfaceHolder;
	    this.gamePanel = gamePanel;
	    
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
		DecimalFormat fmt = new DecimalFormat("##,###,###,###,###,###,#,##0.");
		
		while( running )
		{
			loopcount++;
			long currentTime = System.currentTimeMillis();
			long elapsed = currentTime - lastGameUpdate;
			lastGameUpdate = currentTime;
			Log.i( TAG, String.format( "game loop executing for the %fth time with %d elapsed millis", fmt.format( loopcount ), elapsed ) );
		}
	}
	
	
	public void exit()
	{
		this.running = false;
	}
}
