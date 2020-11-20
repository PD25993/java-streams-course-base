package lectures;

import beans.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {
  @Test
  public void understandingCollect() throws Exception {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(()-> new ArrayList<>(), 
        		(list,consumer) -> list.add(consumer), 
        		(list1,list2) -> list1.addAll(list2)
        		);
    //or
    List<String> emails1 = MockData.getPeople()
            .stream()
            .map(Person::getEmail)
            .collect(ArrayList::new, 
            		ArrayList::add, 
            		ArrayList::addAll
            		);
  //or
    List<String> emails2 = MockData.getPeople()
            .stream()
            .map(Person::getEmail)
            .collect(Collectors.toList());

    //emails.forEach(System.out::println);
    emails1.forEach(System.out::println);
    //emails2.forEach(System.out::println);
  }
  
  @Test
  public void provideMatchumberResultTeam() {
	  int matchNo=6;
	  int possiableOP1, possiableOP2, sqrtCal;
	  sqrtCal = (int)Math.sqrt(1+(8*matchNo));
	  possiableOP1 = (1+sqrtCal)/2;
	  possiableOP2 = (1-sqrtCal)/2;
	  if(possiableOP1 > 0)
		  System.out.println("Team : "+possiableOP1);
	  else
		  System.out.println("Team : "+possiableOP2);
		  
  }
  
  @Test
  public void provideTeamNumberResultMatchNumber() {
	  int teamNo=4;
	  int intermidiateVal=teamNo-1;
	  int matchNumber=(teamNo*intermidiateVal)/2;
	  System.out.println("MatchNumber : "+matchNumber);
		  
  }
}
