package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{
	
	protected ArraySet<Value> _values;
	protected ArrayList<Key> _keys;

	public ParallelArrayDictionary()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public int size() {
		return _keys.size();
	}

	@Override
	public boolean isEmpty() {
		return _keys.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return _keys.contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return _values.contains(value);
	}

	@Override
	public Value get(Object key) {
		if(_keys.indexOf(key) < 0) return null;
		
		return _values.get(_keys.indexOf(key));
	}

	@Override
	public Value put(Key key, Value value) {
		if(containsKey(key)) {
			Value oldValue = _values.get(_keys.indexOf(key));
			return _values.set(_keys.indexOf(key), value);
		}
		else {
			_keys.add(key);
			_values.add(value);
			return null;
		}
	}

	@Override
	public Value remove(Object key) {
		if(!_keys.contains(key)) return null; 
		
		_values.remove(_values.get(_keys.indexOf(key)));
		
		return null;
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Key> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Value> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<Key, Value>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
