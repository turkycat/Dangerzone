package turkycat.productions.dangerzone.gameloop;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import turkycat.productions.dangerzone.objects.GameObject;

public class GameUpdater
{
	private List<GameObject> objects;
	private CollisionHandler collisionHandler;

	public GameUpdater()
	{
		objects = new LinkedList<GameObject>();
		collisionHandler = new CollisionHandler();

	}

	public void update( float units )
	{
		synchronized( objects )
		{
			Iterator<GameObject> iterator = objects.iterator();
			while( iterator.hasNext() )
			{
				iterator.next().update( units );
				//TODO collision detection and resolution
			}
		}
	}

	public void addObject( GameObject object )
	{
		synchronized( objects )
		{
			objects.add( object );
		}
	}
}
