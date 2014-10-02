package turkycat.productions.dangerzone.activities;

import turkycat.productions.dangerzone.R;
import turkycat.productions.dangerzone.R.id;
import turkycat.productions.dangerzone.R.layout;
import turkycat.productions.dangerzone.R.menu;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Typeface titleFont = Typeface.createFromAsset( getAssets(), "fonts/game.ttf" );
		TextView title = (TextView) findViewById( R.id.game_title );
		title.setTypeface( titleFont );
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
