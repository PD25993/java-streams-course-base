package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Integer min = numbers.stream()
    					.min((val1,val2) -> val1 > val2 ? 1 : -1)
    					.get();
    //or
    Integer minUsingNaturalOrders = numbers.stream()
			.min(Comparator.naturalOrder())
			.get();
    assertThat(min).isEqualTo(1);
    System.out.println("min : "+min);
    System.out.println("minUsingNaturalOrders : "+minUsingNaturalOrders);
  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Integer max = numbers.stream()
    				.max((value1 , value2) -> value1 < value2 ? -1 : 1)
    				.get();
    assertThat(max).isEqualTo(100);
    System.out.println("max : "+max);
    Integer maxUsingNaturalOrders= numbers.stream()
    								.max(Comparator.naturalOrder())
    								.get();
    System.out.println("minUsingNaturalOrders : "+maxUsingNaturalOrders);
  }
}
