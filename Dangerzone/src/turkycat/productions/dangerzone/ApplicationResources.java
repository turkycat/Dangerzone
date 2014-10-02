package turkycat.productions.dangerzone;

import java.util.HashMap;
import java.util.Map;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class ApplicationResources
{
	public static final String TAG = "ApplicationResources";
	
	private static ApplicationResources instance;
	private Map<String, Bitmap> bitmaps;

	public static ApplicationResources i()
	{
		if( instance == null )
		{
			instance = new ApplicationResources();
		}
		return instance;
	}

	public void loadResources( Resources res )
	{
		synchronized( this )
		{
			Bitmap bitmap = BitmapFactory.decodeResource( res, R.drawable.background );
			Log.d( TAG, "loaded bitmap. null? " + (bitmap == null ? "#t" : "#f" ) );
			bitmaps.put( "background", bitmap );
		}
		
	}

	public Bitmap getBitmap( String key )
	{
		synchronized( this )
		{
			return bitmaps.get( key );
		}
	}

	private ApplicationResources()
	{
		bitmaps = new HashMap<String, Bitmap>();
	}
}
