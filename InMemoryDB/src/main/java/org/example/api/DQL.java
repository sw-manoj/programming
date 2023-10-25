package org.example.api;

import java.util.List;
import java.util.Map;

public interface DQL {

	DQL join(DQL otherTable, String thisColumn, String otherColumn);
	DQL filterData(Map<String, Object> filters);
	List<Map<String, Object>> select();
	List<Map<String, Object>> select(List<String> fields);
}
