package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String result = "";
    for(String name : names)
    {
    	result += name;
    	
    	if(names.indexOf(name) < names.size()-1) {
    		result += ", ";
    	}
    }
    System.out.println(result);

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    
    String resultJoiningStringsWithStream = names.stream()
    		.map(String::toUpperCase)
    		.collect(Collectors.joining(", "));
    System.out.println(resultJoiningStringsWithStream);
  }
}
