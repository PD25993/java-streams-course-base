package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.junit.Test;

public class Lecture4 {

  @Test
  public void distinct() throws Exception {
    final List<Integer> numbers = ImmutableList.of(9, 9, 9, 9, 9,1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8);
    List<Integer> distinctList = numbers.stream()
    								.distinct()
    								.collect(Collectors.toList());
    assertThat(distinctList).hasSize(9);
    System.out.println("distinctList : "+distinctList);
  }

  @Test
  public void distinctWithSet() throws Exception {
    final List<Integer> numbers = ImmutableList.of(9, 9, 9, 9, 9, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8);
    Set<Integer> distinctSet = numbers.stream()
    		.collect(Collectors.toSet());
    LinkedHashSet<Integer> distinctTreeSet = numbers.stream()
    		.collect(Collectors.toCollection(LinkedHashSet::new));
    assertThat(distinctSet).hasSize(9);
    System.out.println("distinctSet : "+distinctSet);
    System.out.println("distinctTreeSet : "+distinctTreeSet);
  }
}
