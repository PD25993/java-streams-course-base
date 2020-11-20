package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;

import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
	  
	  List<Person> persons = MockData.getPeople();
	  long totalNoOfFemaleCount = persons.stream()
			  .filter(person -> person.getGender().equalsIgnoreCase("female"))
			  .count();
	  System.out.println("totalNoOfFemaleCount : " +totalNoOfFemaleCount);

  }

  @Test
  public void min() throws Exception {

	  Double carMinPrice = MockData.getCars().stream()
			  .filter(car -> car.getColor().equalsIgnoreCase("Yellow"))
			  .mapToDouble(Car::getPrice)
			  .min()
			  .getAsDouble();
	  System.out.println("carMinPrice :"+carMinPrice);
  }

  @Test
  public void max() throws Exception {

	  Double carMaxPrice = MockData.getCars().stream()
			  .filter(car -> car.getColor().equalsIgnoreCase("Yellow"))
			  .mapToDouble(Car::getPrice)
			  .max()
			  .getAsDouble();
	  System.out.println("carMaxPrice :"+carMaxPrice);
  }


  @Test
  public void average() throws Exception {
    //List<Car> cars = MockData.getCars();
    ImmutableList<Car> cars = ImmutableList.of();
    Double carAvgPrice = cars.stream()
    		.mapToDouble(Car::getPrice)
    		.average()
    		.orElse(0);
    System.out.println("carAvgPrice : "+carAvgPrice);
  }

  @Test
  public void sum() throws Exception {
    
	  Double sumOfAllCarPrice = MockData.getCars().stream()
			  .mapToDouble(Car::getPrice)
			  .sum();
	  BigDecimal sumOfAllCarPriceInBigDecimal = BigDecimal.valueOf(sumOfAllCarPrice); 
	  System.out.println("sumOfAllCarPrice : "+sumOfAllCarPrice);
	  System.out.println("sumOfAllCarPriceInBigDecimal : "+sumOfAllCarPriceInBigDecimal);
  }

  @Test
  public void statistics() throws Exception {
    DoubleSummaryStatistics statisticsForCar = MockData.getCars().stream()
    		.mapToDouble(Car::getPrice)
    		.summaryStatistics();
    System.out.println("statisticsForCar : "+statisticsForCar);
    System.out.println("statisticsForCar.getAverage() : "+statisticsForCar.getAverage());
    System.out.println("statisticsForCar.getCount() : "+statisticsForCar.getCount());
    System.out.println("statisticsForCar.getMax() : "+statisticsForCar.getMax());
    System.out.println("statisticsForCar.getMin() : "+statisticsForCar.getMin());
    System.out.println("statisticsForCar.getSum() : "+ BigDecimal.valueOf(statisticsForCar.getSum()));
    
  }

}