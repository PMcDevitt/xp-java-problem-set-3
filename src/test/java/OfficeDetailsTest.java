import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by localadmin on 14/06/2016.
 */
public class OfficeDetailsTest {

    @Test
    public void getBelfastOfficeReturnsAnEmptyListWhenGivenAnEmptyList() {
        List<Office> officeList = OfficeDetails.getBelfastOffice(Collections.emptyList());

        assertThat(officeList, is(Collections.emptyList()));
    }

    @Test
    public void getBelfastOfficeReturnsAListOfOfficesWithLocationOfBelfast(){
        Office derry = new Office("Northland", "Derry, Northern Ireland", 12);
        Office belfast = new Office("Lanyon Place", "Belfast, Northern Ireland", 1200);
        List<Office> officeList = OfficeDetails.getBelfastOffice(Arrays.asList(derry, belfast));

        assertThat(officeList.get(0).getLocation(), is("Belfast, Northern Ireland"));
    }

    @Test
    public void smallOfficesReturnsAnEmptyListWhenEmptyListIsProvided(){
        List<Office> officeList = OfficeDetails.smallOffices(Collections.emptyList());

        assertThat(officeList, is(Collections.emptyList()));
    }

    @Test
    public void smallOfficesReturnsAnEmptyListWhenAllOfficesContainMoreThanTenPeople(){
        Office derry = new Office("Northland", "Derry, Northern Ireland", 12);
        Office belfast = new Office("Lanyon Place", "Belfast, Northern Ireland", 1200);
        List<Office> officeList = OfficeDetails.smallOffices(Arrays.asList(derry, belfast));

        assertThat(officeList, is(Collections.emptyList()));
    }

    @Test
    public void smallOfficesReturnsAnOfficeWhenOneOfficeHasLessThanTenEmployees(){
        Office derry = new Office("Northland", "Derry, Northern Ireland", 1);
        Office belfast = new Office("Lanyon Place", "Belfast, Northern Ireland", 1200);
        List<Office> officeList = OfficeDetails.smallOffices(Arrays.asList(derry, belfast));

        assertThat(officeList, is(Arrays.asList(derry)));
    }

    @Test
    public void largeOfficesReturnsAnEmptyListWhenEmptyListIsProvided(){
        List<Office> officeList = OfficeDetails.largeOffices(Collections.emptyList());

        assertThat(officeList, is(Collections.emptyList()));
    }

    @Test
    public void largeOfficesReturnsAnEmptyListWhenAllOfficesContainLessThanOneHundredPeople(){
        Office derry = new Office("Northland", "Derry, Northern Ireland", 12);
        Office belfast = new Office("Lanyon Place", "Belfast, Northern Ireland", 99);
        List<Office> officeList = OfficeDetails.largeOffices(Arrays.asList(derry, belfast));

        assertThat(officeList, is(Collections.emptyList()));
    }

    @Test
    public void largeOfficesReturnsAnOfficeWhenOneOfficeHasMoreThanOneHundredPeople(){
        Office derry = new Office("Northland", "Derry, Northern Ireland", 12);
        Office belfast = new Office("Lanyon Place", "Belfast, Northern Ireland", 1200);
        List<Office> officeList = OfficeDetails.largeOffices(Arrays.asList(derry, belfast));

        assertThat(officeList, is(Arrays.asList(belfast)));
    }

    @Test
    public void nameOfNorthlandReturnsAnEmptyListWhenEmptyListIsProvided(){
        List<Office> officeList = OfficeDetails.nameOfNorthland(Collections.emptyList());

        assertThat(officeList, is(Collections.emptyList()));
    }

    @Test
    public void nameOfNorthlandReturnsAListWhithOneOfficeWhenAMixIsProvided(){
        Office derry = new Office("Northland", "Derry, Northern Ireland", 12);
        Office belfast = new Office("Lanyon Place", "Belfast, Northern Ireland", 1200);
        List<Office> officeList = OfficeDetails.nameOfNorthland(Arrays.asList(belfast, derry));

        assertThat(officeList.get(0).getName(), is("Northland"));
    }

    @Test
    public void beginsWithALetterFromAThruKReturnsAnEmptyListWhenEmptyListIsProvided(){
        List<Office> officeList = OfficeDetails.beginsWithALetterFromAThruK(Collections.emptyList());

        assertThat(officeList, is(Collections.emptyList()));
    }

    @Test
    public void beginsWithALetterFromAThruKReturnsAnEmptyListWhenNameBeginsWithALetterAfterK(){
        Office derry = new Office("Northland", "Derry, Northern Ireland", 12);
        List<Office> officeList = OfficeDetails.beginsWithALetterFromAThruK(Arrays.asList(derry));

        assertThat(officeList, is(Collections.emptyList()));
    }
    @Test
    public void beginsWithALetterFromAThruKReturnsAnEmptyListWhenNameBeginsWithAMixOfLettersBeforeAndAfterK(){
        Office derry = new Office("Northland", "Derry, Northern Ireland", 12);
        Office belfast = new Office("At Lanyon Place", "Belfast, Northern Ireland", 1200);
        List<Office> officeList = OfficeDetails.beginsWithALetterFromAThruK(Arrays.asList(derry, belfast));

        assertThat(officeList, is(Arrays.asList(belfast)));
    }
}