package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
		
		Value oldValue = _values.get(_keys.indexOf(key));
		_values.remove(_values.get(_keys.indexOf(key)));
		return oldValue;
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		Key[] typeDefinition = null;
		Key[] newKeys = m.keySet().toArray(typeDefinition);
		for(int i=0; i<newKeys.length; i++) {
			put(newKeys[i], m.get(newKeys[i]));
		}
	}

	@Override
	public void clear() {
		_keys.clear();
		_values.clear();
		
	}

	@Override
	public Set<Key> keySet() {
		return (Set<Key>)_keys;
	}

	@Override
	public Collection<Value> values() {
		// TODO Auto-generated method stub
		return (Collection<Value>) _values;
	}

	@Override
	public Set<Entry<Key, Value>> entrySet() {
		// TODO Auto-generated method stub
		return (Set<Entry<Key, Value>>) this;
	}

}
