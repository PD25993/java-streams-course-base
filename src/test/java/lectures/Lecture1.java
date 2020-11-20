package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class Lecture1 {

	@Test
	public void imperativeApproach() throws IOException {
		List<Person> people = MockData.getPeople();
		// 1. Find people aged less or equal 18
		// 2. Then change implementation to find first 10 people
		// people.forEach(i -> System.out.println("Value : "+i));
		List<Person> ageList18Limit10 = new ArrayList<>();
		final int limit = 10;
		AtomicInteger counter = new AtomicInteger(0);
		try {
			people.forEach(i -> {
				if (i.getAge() <= 18) {
					ageList18Limit10.add(i);
					counter.incrementAndGet();
					if (counter.get() == limit) {
						ageList18Limit10.forEach(line -> System.out.println("Data : " + line));
						throw new RuntimeException();
					}
				}
			});
		} catch (RuntimeException e) {
			System.out.println("Reach counter");
		}
	}

	@Test
	public void declarativeApproachUsingStreams() throws Exception {
		/*ImmutableList<Person> people = MockData.getPeople();
		List<Person> ageList18Limit10 = people.stream()
										.filter(ageVar ->ageVar.getAge() <= 18)
										.limit(10)
										.collect(Collectors.toList());
		ageList18Limit10.forEach(System.out::println);*/
		//Or
		MockData.getPeople().stream()
			.filter(people -> people.getAge() <= 18)
			.limit(10)
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}
}
