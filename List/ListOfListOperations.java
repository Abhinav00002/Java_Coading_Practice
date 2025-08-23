package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfListOperations {
    public static final List<List<String>> records = new ArrayList<>();
    static {
    // Each inner list = [Date, Salary, Name, Age, Designation]
    records.add(Arrays.asList("2025-08-01", "50000", "Alice", "30", "Developer"));
    records.add(Arrays.asList("2025-08-01", "50000", "alice", "30", "developer"));  // duplicate with case difference
    records.add(Arrays.asList("2025-08-02", "60000", "Bob", "35", "Manager"));
    records.add(Arrays.asList("2025-08-03", "70000", "CHARLIE", "28", "Analyst"));
    records.add(Arrays.asList("2025-08-04", "80000", "D@vid", "40", "Sr. Developer")); // special character in name
    records.add(Arrays.asList("2025-08-04", "80000", "D@vid", "40", "Sr. Developer")); // exact duplicate
    records.add(Arrays.asList("2025-08-05", "55000", "Eve", "27", "Developer"));
    records.add(Arrays.asList("2025-08-05", "55000", "Eve", "27", "developer")); // case difference in designation
    records.add(Arrays.asList("2025-08-06", "60000", "Frank", "32", "QA Tester"));
    records.add(Arrays.asList("2025-08-06", "60000", "frank", "32", "QA Tester")); // case difference in name
    }

    public static void main(String[] args) {
        records.forEach(s-> System.out.println(s));
    }
}
