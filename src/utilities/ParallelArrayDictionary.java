package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{
	
	protected ArrayList<Key> _keys;
	protected ArraySet<Value> _values;
	
	public ParallelArrayDictionary()
	{
		_values = new ArraySet<Value>();
		_keys = new ArrayList<Key>();
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
		if(_keys.indexOf(key) < 0)
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
			return _values.set(_values.indexOf(value), value);
		}
		else
		{
			_keys.add(key);
			_values.add(value);
			return null;
		}
	}

	@Override
	public Value remove(Object key)
	{
		if(!_keys.contains(key))
		{
			return null;
		}
		return _values.remove(_keys.indexOf(key));
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> m)
	{
		_keys.addAll(m.keySet());
		_values.addAll(m.values());	
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
