import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Item25.Item25;
import Item25.Item25_2;


public class Item25Test {

    
    private static final int MAX_LEN = 1000000;
    private static List<Long> list = null;
    
    @Before
    public void setup(){
        long cnt=0;
//        list = new ArrayList<Integer>(MAX_LEN);
        list = new ArrayList<Long>(2);
        for(int i=0; i<MAX_LEN; ++i){
            list.add(++cnt);
        }
        
    }
    
    @Test
    public void testReduce(){
        
        Long initVal = 0L;
        long before = System.currentTimeMillis();
        System.out.println(Item25.reduce(list, new Item25(), initVal));
        System.out.println(System.currentTimeMillis() - before);
        
        before = System.currentTimeMillis();
        System.out.println(Item25.reduce2(list, new Item25(), initVal));
        System.out.println(System.currentTimeMillis() - before);
        
        before = System.currentTimeMillis();

        System.out.println(Item25_2.reduce(list, new Item25_2<Long>(), initVal));

        System.out.println(System.currentTimeMillis() - before);
    }
}
