import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;

public class OfficePredicatesTest {
    @Test
    public void inLocation() throws Exception {
        Office derry = new Office("Northland", "Derry, Northern Ireland", 19);
        Office belfast = new Office("At Lanyon Place", "Belfast", 1200);
        List<Office> offices = Arrays.asList(derry, belfast);


        final List<Office> actual = offices
                .stream()
                .filter(OfficePredicates.inLocation("Belfast"))
                .collect(Collectors.toList());
        Assert.assertThat(actual.size(), is(1));
    }
    @Test
    public void employeesGreaterThan() throws Exception {
        Office derry = new Office("Northland", "Derry, Northern Ireland", 11);
        Office belfast = new Office("At Lanyon Place", "Belfast", 9);
        List<Office> offices = Arrays.asList(derry, belfast);


        final List<Office> actual = offices
                .stream()
                .filter(OfficePredicates.employeesGreaterThan(10))
                .collect(Collectors.toList());

        Assert.assertThat(actual.size(), is(1));
    }
    @Test
    public void inLocationAndEmployeeNumbersGreaterThanTen(){
        Office derry = new Office("Northland", "Derry, Northern Ireland", 12);
        Office belfast = new Office("At Lanyon Place", "Belfast", 9);
        List<Office> offices = Arrays.asList(derry, belfast);

        final List<Office> actual = offices
                .stream()
                .filter(OfficePredicates.inLocation("Belfast")
                        .or(OfficePredicates.employeesGreaterThan(10))
                )
                .collect(Collectors.toList());
        Assert.assertThat(actual.size(), is(2));
    }

    @Test
    public void locationInitialLetterCheck(){
        Office derry = new Office("Northland", "Derry", 12);
        Office belfast = new Office("At Lanyon Place", "Belfast", 9);
        List<Office> offices = Arrays.asList(derry, belfast);

        final List<Office> actual = offices
                .stream()
                .filter(OfficePredicates.nameInitialLetterCheck("a", "k"))
        .collect(Collectors.toList());
        Assert.assertThat(actual.size(), is(1));
        Assert.assertThat(actual.get(0).getLocation(), is("Belfast"));

        final List<Office> actualN = offices
                .stream()
                .filter(OfficePredicates.nameInitialLetterCheck("a", "k").negate())
                .collect(Collectors.toList());
        Assert.assertThat(actualN.size(), is(1));
        Assert.assertThat(actualN.get(0).getLocation(), is("Derry"));

        final List<Office> actualA = offices
                .stream()
                .filter(OfficePredicates.nameInitialLetterCheck("a", "n"))
                .collect(Collectors.toList());
        Assert.assertThat(actualA.size(), is(2));

        final List<Office> actualB = offices
                .stream()
                .filter(OfficePredicates.nameInitialLetterCheck("k", "z"))
                .collect(Collectors.toList());
        Assert.assertThat(actual.size(), is(1));

    }
}
