package turkycat.productions.dangerzone.activities;

import turkycat.productions.dangerzone.ApplicationResources;
import turkycat.productions.dangerzone.R;
import turkycat.productions.dangerzone.views.GameView;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class GameActivity extends Activity
{
	private static final String TAG = "GameActivity";
	private GameView gameView;
	
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );

		ApplicationResources.i().loadResources( getResources() );
		setContentView( R.layout.activity_game );
	}
	
	

}
