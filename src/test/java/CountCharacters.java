import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountCharacters {

    @Test
    public void countCharactersDemo() {
        String s = "MALAYALAM";
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ch) {
            int count = 0;
            if (map.get(c) == null) {
                map.put(c, ++count);
            } else {
                count = map.get(c);
                map.put(c, ++count);
            }
        }
        System.out.println(map);

        int max = 0;
        Character maxNumber = null;
        for (Map.Entry e:map.entrySet()){
            Integer value=(Integer)e.getValue();
            if(value>max){
                max=value;
                maxNumber=(Character)e.getKey();
            }
        }
        System.out.println(maxNumber);
    }
    @Test
    public void countWordsInAString(){

    }
}
