/**
 * File class represents an individual file that contains information regarding a given dataset
 *
 * @author Jason Yau
 * @version 1
 * @since Mar-10-24
 */

import java.lang.reflect.Array;
import java.util.*;

public class Field {
    private Map<String, List<Object>> fields;

    /**
     * default constructor
     */
    public Field() {
        this.fields = new HashMap<>();
    }

    /**
     * Adds a new field along with its associated values to the map.
     * If the field already exists, this method will replace the existing values with the new list provided.
     * @param fieldName The name of the field to be added. This acts as a key in the map.
     * @param values The list of objects/values to be associated with the field. This list is stored against the field name in the map.
     */

    public void addField(String fieldName, List<Object> values) {
        fields.put(fieldName, new ArrayList<>(values));
    }

    /**
     * Removes a field and its associated values from the map.
     * If the field does not exist, the method does nothing, preventing any errors or exceptions.
     * @param fieldName The name of the field to be removed from the map.
     */

    public void removeField(String fieldName) {
        fields.remove(fieldName);
    }

    /**
     * Adds a single value to an existing field's list of values. If the field does not exist, it is created,
     * and the value is added to the newly created list. This ensures the method is safe to use even with new fields.
     * @param fieldName The name of the field to which the value will be added. If it doesn't exist, it's created.
     * @param value The value to be added to the field's list of values.
     */

    public void addValueToField(String fieldName, Object value) {
        // If the specified key is not already associated with a value (or mapped to null),
        // attempts to compute its value using the given mapping function and enters it into the map unless null.
        fields.computeIfAbsent(fieldName, k -> new ArrayList<>()).add(value);
    }

    /**
     * Removes a single value from a field's list of values. If the field or the value does not exist,
     * the method performs no operation, making it safe from exceptions related to non-existent keys or values. 
     * @param fieldName The name of the field from which the value will be removed.
     * @param value The value to be removed from the field's list of values.
     */

    public void removeValueFromField(String fieldName, Object value) {
        if (fields.containsKey(fieldName)) {
            fields.get(fieldName).remove(value);
        }
    }

    /**
     * Updates a specific value within a field's list of values, identified by its index. If the field does not exist,
     * or the index is out of bounds (either negative or greater than the size of the list), an IndexOutOfBoundsException is thrown.
     * @param fieldName The name of the field whose value needs to be updated.
     * @param index The index within the list of values that needs to be updated. Must be within the list's bounds.
     * @param newValue The new value that will replace the existing value at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds for the field's value list.
     */

    public void updateValueInField(String fieldName, int index, Object newValue) {
        List<Object> values = fields.get(fieldName);
        if (values != null && index >= 0 && index < values.size()) {
            values.set(index, newValue);
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for field '" + fieldName + "'.");
        }
    }

    /**
     * Retrieves the list of values associated with a specific field. If the field does not exist,
     * an empty list is returned, ensuring that the method call remains safe without causing NullPointerExceptions.
     * @param fieldName The name of the field whose values are to be retrieved.
     * @return A list of objects/values associated with the field. Returns an empty list if the field does not exist.
     */

    public List<Object> getValues(String fieldName) {
        // getORDefault: Returns the value to which the specified key is mapped,
        // or defaultValue if the map contains no mapping for the key.
        //Collections.emptyList() Returns the empty list (immutable).
        // This list is serializable, type-safe, and consumes less memory than an empty instance of ArrayList
        return fields.getOrDefault(fieldName, Collections.emptyList());
    }

    /**
     * Returns a set of all field names currently stored in the map. This can be used to enumerate all fields present.
     * The returned set is a view of the keys in the map, meaning any changes to the map will be reflected in the set.
     * @return A Set<String> containing all field names (keys) present in the map.
     */

    public Set<String> getFieldNames() {
        // Returns a Set view of the keys contained in the map.
        // The set is backed by the map, changes to the map are reflected in the set.
        return fields.keySet();
    }

    /**
     * Returns the number of fields stored in the map.
     * This method provides a direct means to ascertain the quantity of field entries currently maintained.
     * @return An integer representing the total number of fields (key-value pairs) present in the map.
     */
    public int getFieldSize() {
        return fields.size();
    }

    /**
     * Retrieves the number of values associated with each field in the map.
     * This method returns a map where the keys are the field names and the values are the counts
     * of objects/values associated with each field.
     * @return A Map<String, Integer> representing the number of values associated with each field.
     */
    public int getValuesCountPerField() {
        return getValues("FID").size();
    }

    /**
     * Retrieves the list of columns
     * @return An ArrayList<String> representing the list of columns or fields
     */
    public ArrayList<String> getColumns(){
        ArrayList<String> columns = new ArrayList<>();
        for(Map.Entry<String, List<Object>> entry : fields.entrySet()){
            columns.add(entry.getKey());
        }
        return columns;
    }

}
