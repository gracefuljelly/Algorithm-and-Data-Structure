package DataStructure;

import java.util.HashMap;
import java.util.Map;


public  class HashMapWithTimeToLive<K, V> {

    Map<K,dataWithExpiration> map;

    public  HashMapWithTimeToLive() {
       map= new HashMap<K,dataWithExpiration>();
    }

      class dataWithExpiration{
        V value;
        long expire;

        dataWithExpiration(V value,int lifespan){
            this.value=value;
            this.expire=lifespan*6000+System.currentTimeMillis();
        }
    }

    public void put(K key, V value, int lifeSpan){
        dataWithExpiration data= new dataWithExpiration(value,lifeSpan);
        map.put(key,data);
    }

    public V get(K key){
        dataWithExpiration data= map.get(key);
        if(data==null){
            System.out.println("no such element");
            return null;
        }else if(data.expire<System.currentTimeMillis()){
            System.out.println("data expired at "+data.expire);
            map.remove(key,data);
            return null;
        }else{
            System.out.println("data valid until "+data.expire);
            return data.value;
        }
    }


    public static void main(String[] args) {
        HashMapWithTimeToLive myMap = new HashMapWithTimeToLive<>();
        myMap.put("abc","1,2,3",1);
        myMap.put("def","4,5,6",2);
        System.out.println(System.currentTimeMillis());
        myMap.get("abc");
        myMap.get("def");
    }
}

