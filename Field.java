package filemanagement;
import java.util.*;

import com.google.gson.Gson;

public class Field {
    private Map<String, List<Object>> fields;

    public Field() {
        this.fields = new HashMap<>();
    }

    public void addField(String fieldName, List<Object> values) {
        fields.put(fieldName, new ArrayList<>(values));
    }

    public void removeField(String fieldName) {
        fields.remove(fieldName);
    }

    public void addValueToField(String fieldName, Object value) {
        // If the specified key is not already associated with a value (or mapped to null),
        // attempts to compute its value using the given mapping function and enters it into the map unless null.
        fields.computeIfAbsent(fieldName, k -> new ArrayList<>()).add(value);
    }

    public void removeValueFromField(String fieldName, Object value) {
        if (fields.containsKey(fieldName)) {
            fields.get(fieldName).remove(value);
        }
    }

    // Method to update a field value by index
    public void updateValueInField(String fieldName, int index, Object newValue) {
        List<Object> values = fields.get(fieldName);
        if (values != null && index >= 0 && index < values.size()) {
            values.set(index, newValue);
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for field '" + fieldName + "'.");
        }
    }

    public List<Object> getValues(String fieldName) {
        // getORDefault: Returns the value to which the specified key is mapped,
            // or defaultValue if the map contains no mapping for the key.
        //Collections.emptyList() Returns the empty list (immutable).
            // This list is serializable, type-safe, and consumes less memory than an empty instance of ArrayList
        return fields.getOrDefault(fieldName, Collections.emptyList());
    }

    public Set<String> getFieldNames() {
        // Returns a Set view of the keys contained in the map.
        // The set is backed by the map, changes to the map are reflected in the set.
        return fields.keySet();
    }


}
