package turkycat.productions.dangerzone.activities;

import turkycat.productions.dangerzone.views.GameView;
import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity
{
	private GameView gameView;
	
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		
		super.onCreate( savedInstanceState );
		
		gameView = new GameView( this );
		setContentView( gameView );
	}
	
	

}
