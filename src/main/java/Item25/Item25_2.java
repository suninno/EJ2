package Item25;

import java.util.ArrayList;
import java.util.List;

interface IFunction2<T> {
    <T extends Number> T apply(T arg1, T arg2);
}


public class Item25_2<T extends Number> implements IFunction2<T>{
    

    public static <T extends Number> T reduce(List<T> list, IFunction2<T> f, T initVal){
        List<T> snapshot;
        synchronized(list){
            snapshot = new ArrayList<T>(list);//deep copy
        }
        
        T result = initVal;
        for(T e : snapshot)
            result = f.apply(result, e);
        
        return result;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <T extends Number> T apply(T arg1, T arg2) {
        if (arg1 instanceof Long && arg2 instanceof Long){
            return (T)Long.valueOf((Long)arg1 + (Long)arg2);
        }
        return null;
    }


}
