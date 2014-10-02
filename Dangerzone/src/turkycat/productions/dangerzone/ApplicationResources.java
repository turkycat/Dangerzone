package turkycat.productions.dangerzone;

import java.util.HashMap;
import java.util.Map;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ApplicationResources
{
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
		Bitmap bitmap = BitmapFactory.decodeResource( res, R.drawable.background );
		synchronized( this )
		{
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
