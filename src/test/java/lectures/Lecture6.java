package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

public class Lecture6 {
	
	//findAny Nondeterministic but findFirst is deterministic(always give same result)

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

  @Test
  /*
  * <p>The behavior of this operation is explicitly nondeterministic; it is
  * free to select any element in the stream.  This is to allow for maximal
  * performance in parallel operations; the cost is that multiple invocations
  * on the same source may not return the same result.  (If a stable result
  * is desired, use {@link #findFirst()} instead.)*/
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    
    //take array as stream : Arrays.stream(numbers)
    int findAnyNum = Arrays.stream(numbers)
    		.filter(num ->  num > 5 && num < 10)
    		.findAny()
    		.get();
    System.out.println("findAnyNum : "+findAnyNum);
    //or
    int findAnyNumUsingPredicate = Arrays.stream(numbers)
    		.filter(numbersLessThan10)
    		.findAny()
    		.get();
    System.out.println("findAnyNumUsingPredicate : "+findAnyNumUsingPredicate);
  }

  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int findFirstNumUsingPredicate = Arrays.stream(numbers)
    		.filter(numbersLessThan10)
    		.findFirst()
    		.get();
    System.out.println("findFirstNumUsingPredicate : "+findFirstNumUsingPredicate);

  }
}

