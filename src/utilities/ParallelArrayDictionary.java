/**
  * Implements the Map interface
  * Maps pairs keys and values such that every key is unique.  Data is inserted in pairs
  * and accessed and removed using the key.
  *
  *<p>Bugs: 
  *
  * @author Abby Dumke, Jake Shore
  * @date <date of completion>
  */

package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{
	
	protected ArraySet<Key> _keys;
	protected ArrayList<Value> _values;
	
	public ParallelArrayDictionary()
	{
		_values = new ArrayList<Value>();
		_keys = new ArraySet<Key>();
	}
	
	@Override
	public int size()
	{
		return _keys.size();
	}

	@Override
	public boolean isEmpty()
	{
		return _keys.isEmpty();
	}

	@Override
	public boolean containsKey(Object key)
	{
		return _keys.contains(key);
	}

	@Override
	public boolean containsValue(Object value)
	{
		return _values.contains(value);
	}

	@Override
	public Value get(Object key)
	{
		if(!containsKey(key))
		{
			return null;
		}
		
		return _values.get(_keys.indexOf(key));
	}

	@Override
	public Value put(Key key, Value value)
	{
		if(containsKey(key))
		{
			return _values.set(_keys.indexOf(key), value);
		}
		
		// adds a new associated key and value to the dictionary
		_keys.add(key);
		_values.add(value);
		return null;
	}

	@Override
	public Value remove(Object key)
	{
		if(!_keys.contains(key))
		{
			return null;
		}
		
		// removes the associated key and value from the dictionary
		int index = _keys.indexOf(key);
		_keys.remove(index);
		return _values.remove(index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void putAll(Map<? extends Key, ? extends Value> m)
	{
		Set<?> map = m.entrySet();
		
		for(int i=0; i<map.size(); i++) {
			put((Key)((Entry<Key, Value>) map.toArray()[i]).getKey(), (Value)((Entry<Key,Value>) map.toArray()[i]).getValue());
		}
	}

	@Override
	public void clear() {
		_keys.clear();
		_values.clear();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Key> keySet() {
		return (Set<Key>)_keys;
	}

	@Override
	public Collection<Value> values() {
		return (Collection<Value>) _values;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Entry<Key, Value>> entrySet() {
		return (Set<Entry<Key, Value>>)this;
	}

}
