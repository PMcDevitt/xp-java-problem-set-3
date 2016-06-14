import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by localadmin on 14/06/2016.
 */
public class OfficeDetails {


    public static List<Office> getBelfastOffice(List<Office> offices) {
        return offices.stream()
                .filter(s -> s.getLocation() == "Belfast, Northern Ireland")
                .collect(Collectors.toList());
    }

    public static List<Office> smallOffices(List<Office> offices) {
        return offices.stream()
                .filter(s -> s.getNumberOfEmployees() < 10)
                .collect(Collectors.toList());
    }

    public static List<Office> largeOffices(List<Office> offices) {
        return offices.stream()
                .filter(s -> s.getNumberOfEmployees() > 100)
                .collect(Collectors.toList());
    }

    public static List<Office> nameOfNorthland(List<Office> offices) {
        return offices.stream()
                .filter(s -> s.getName() == "Northland")
                .collect(Collectors.toList());
    }

    public static List<Office> beginsWithALetterFromAThruK(List<Office> offices) {
        return offices.stream().filter(s -> Pattern.matches("[a-kA-K].*", s.getName()))
                .collect(Collectors.toList());
    }
}
