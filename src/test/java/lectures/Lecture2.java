package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

	@Test
	public void range() throws Exception {
		System.out.println("for i");

		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}

		System.out.println("exclusive");

		IntStream.range(0, 10).forEach(System.out::println);

		System.out.println("inclusive");

		IntStream.rangeClosed(0, 10).forEach(System.out::println);
	}

	@Test
	public void rangeIteratingLists() throws Exception {
		List<Person> people = MockData.getPeople();
		IntStream.range(0, people.size()).forEach(index -> {
			Person p1 = people.get(index);
			System.out.println("Person Details : " + p1);
		});
	}

	@Test
	public void intStreamIterate() throws Exception {

		IntStream.iterate(0, index -> index + 1)
			.limit(20)
			.filter(index -> index%2 ==0)
			.forEach(System.out::println);
	}

}
