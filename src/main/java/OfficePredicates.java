import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class OfficePredicates {
    static Predicate<Office> inLocation(final String locationName) {
        return office -> locationName.equals(office.getLocation());
    }

    static Predicate<Office> employeesGreaterThan(final int max) {
        return office -> office.getEmployees() > max;
    }

    static Predicate<Office> nameInitialLetterCheck(String a, String b){
        String matchingPattern = "["+ a.toLowerCase()+"-"+b.toLowerCase() + a.toUpperCase()+"-"+b.toUpperCase() + "].*";
        return office -> Pattern.matches(matchingPattern, office.getName());
    }
}