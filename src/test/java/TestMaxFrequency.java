import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestMaxFrequency {
    @Test
    public void testMaxFrequencyAlphabet(){
        String name="AFGANISTTTTTTTTTTTTTTAN";
        Map<Character,Integer> map=new HashMap<>();
        char[] charName=name.toCharArray();
        for(char ch:charName){
            int count=0;
            if(map.get(ch)==null){
                map.put(ch,++count);
            }else{
                count=map.get(ch);
                map.put(ch,++count);
            }
        }
        System.out.println(map);
        int max=0;
        Character charWithMaxCount=null;
        for(Map.Entry e: map.entrySet()){
            Integer value=(Integer)e.getValue();
            if(value>max){
                max=value;
                charWithMaxCount=(Character)e.getKey();
            }
        }
        System.out.println(charWithMaxCount);
    }
    @Test
    public void testMaxFrequencyWord() throws IOException {
        Properties objRepo=new Properties();
        objRepo.load(new FileInputStream("OR.properties"));
        String text=objRepo.get("sentence").toString();
        System.out.println(text);
        String[] words=text.split(" ");
        Map<String,Integer> map=new HashMap();
        for(String s:words){
            int count=0;
            if(map.get(s)==null){
                map.put(s,++count);
            }else {
                count = map.get(s);
                map.put(s,++count);
            }
        }
        System.out.println(map);
        System.out.println(map.entrySet());
        int max=0;
        String maxWord=null;
        for (Map.Entry e:map.entrySet()){
          int value=(Integer)e.getValue();
          if(value>max){
              max=value;
              maxWord=e.getKey().toString();
          }
        }
        System.out.println(maxWord);
    }
}
