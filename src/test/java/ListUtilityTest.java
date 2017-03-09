import com.test.common.Utility.ListUtility;
import com.test.common.Utility.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by PANI01861 on 08/03/2017.
 */
@RunWith(JUnit4.class)
public class ListUtilityTest {

    @Test
    public void partitionsTest() {
        List<Person> intList = Arrays.asList(new Person("AHMED", "NOURI"), new Person("AHMED1", "NOURI1"), new Person("AHMED2", "NOURI2"));
        List<List<Person>> subLists = ListUtility.partitions(intList, 2);
        List<Person> lastPartition = subLists.get(1);
        List<Person> expectedLastPartition = Arrays.asList(new Person("AHMED2", "NOURI2"));
        assertThat(subLists.size(), equalTo(2));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }
    @Test
    public void partitionsJava8Test() {
        List<String> intList = Arrays.asList("Salut", "un", "test", "java", "pour", "toi", "enjoy", "it");
        List<List<String>> subLists = ListUtility.partitionsJava8(intList, 3);
        List<String> lastPartition = subLists.get(2);
        List<String> expectedLastPartition = Arrays.asList("enjoy", "it");
        assertThat(subLists.size(), equalTo(3));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }

    @Test
    public void partitionsGuavaTest() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subLists = ListUtility.partitionsGuava(intList, 3);
        List<Integer> lastPartition = subLists.get(2);
        List<Integer> expectedLastPartition = Arrays.asList(7, 8);
        assertThat(subLists.size(), equalTo(3));
        assertThat(lastPartition, equalTo(expectedLastPartition));
    }

}
