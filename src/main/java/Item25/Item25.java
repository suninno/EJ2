package Item25;
import java.util.ArrayList;
import java.util.List;


interface IFunction {
    Object apply(Object arg1, Object arg2);
}


public class Item25 implements IFunction {
    
    @Override
    public Object apply(Object arg1, Object arg2) {
        if (arg1 instanceof Long && arg2 instanceof Long){
            return (Long)arg1 + (Long)arg2;
        }
        return null;
    }

    
    //with concurrency flaw
    public static Object reduce(List list, IFunction f, Object initVal){
        Object result = initVal;
        synchronized(list){//lock
            for(Object o : list){
                result = f.apply((Long)result, (Long)o);
            }
        }
        return result;
 
    }
    
    
    //without concurrecny flaw
    public static Object reduce2(List list, IFunction f, Object initVal){
        
        Object[] snapshot = list.toArray();//deep copy
        Object result = initVal;
        for(Object o : snapshot){
            result = f.apply(result, o);
        }
        
        return result;
    }



}


