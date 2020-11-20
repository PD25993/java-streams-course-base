package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

	final Predicate<Car> carPredicate = car -> car.getPrice() < 20000;
	final Function<Person,PersonDTO> personMapperToPersonDTOFunc= singlePeople -> new PersonDTO(singlePeople.getId(), singlePeople.getFirstName(), singlePeople.getAge());
	
  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    //Filter take prediacte
    //Option 1 
    List<Car> carsDetailUsingFilter = cars.stream()
    		.filter(car -> car.getPrice() < 20000)
    		.collect(Collectors.toList());
    
    carsDetailUsingFilter.forEach(System.out::println);
    System.out.println("carsDetailUsingFilter size : "+carsDetailUsingFilter.size());
    //option 2 
    List<Car> carsDetailUsingFilterOutsidePredicate = cars.stream()
    		.filter(carPredicate)
    		.collect(Collectors.toList());
    carsDetailUsingFilterOutsidePredicate.forEach(System.out::println);
    System.out.println("carsDetailUsingFilterOutsidePredicate size : "+carsDetailUsingFilterOutsidePredicate.size());

  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
	  //map take function
    List<Person> people = MockData.getPeople();
    //option 1
    List<PersonDTO> personDTOS = people.stream()
    		.map(singlePeople -> {
    			return new PersonDTO(singlePeople.getId(), singlePeople.getFirstName(), singlePeople.getAge());
    		})
    		.collect(Collectors.toList());
    personDTOS.forEach(System.out::println);
    System.out.println("personDTOS size : "+personDTOS.size());	
    assertThat(personDTOS).hasSize(people.size());
    
    //option 2
    List<PersonDTO> personDTOSUsingExternalFunc = people.stream()
    		.map(personMapperToPersonDTOFunc)
    		.collect(Collectors.toList());
    personDTOSUsingExternalFunc.forEach(System.out::println);
    System.out.println("personDTOSUsingExternalFunc size : "+personDTOSUsingExternalFunc.size());	
    assertThat(personDTOSUsingExternalFunc).hasSize(people.size());

  
  //option 3 
    List<PersonDTO> personDTOSUsingDTOMapFunc = people.stream()
    		.map(PersonDTO::map)
    		.collect(Collectors.toList());
    personDTOSUsingDTOMapFunc.forEach(System.out::println);
    System.out.println("personDTOSUsingDTOMapFunc size : "+personDTOSUsingDTOMapFunc.size());	
    assertThat(personDTOSUsingDTOMapFunc).hasSize(people.size());
  
  }
  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
	  ImmutableList<Car> cars = MockData.getCars();
	  Double avgCarPrice= cars.stream()
			  .mapToDouble(carPrice -> carPrice.getPrice())
			  .average()
			  .orElse(0);
	  System.out.println("avgCarPrice :"+avgCarPrice);
	  // option 2 
	  Double avgCarPriceMethodRef= cars.stream()
	  .mapToDouble(Car::getPrice)
	  .average()
	  .orElse(0);
	  System.out.println("avgCarPriceMethodRef :"+avgCarPriceMethodRef);
  }

  @Test
  public void test() throws Exception {

  }
}



