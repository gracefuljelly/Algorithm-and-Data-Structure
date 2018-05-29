package HashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyURL {
    /*
    * The range of URLs that can be decoded is limited by the range of \text{int}int.

If excessively large number of URLs have to be encoded, after the range of \text{int}int is exceeded, integer overflow could lead to overwriting the previous URLs' encodings, leading to the performance degradation.

The length of the URL isn't necessarily shorter than the incoming \text{longURL}longURL. It is only dependent on the relative order in which the URLs are encoded.

One problem with this method is that it is very easy to predict the next code generated, since the pattern can be detected by generating a few encoded URLs.
    * */
    Map<Integer, String> map_one = new HashMap<>();
    int i=0;

    public String encode_one(String longUrl){
        map_one.put(i, longUrl);
        return  "http://tinyurl.com/" + i++;
    }

    public String decode_one(String shortUrl) {
        return map_one.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
/*
* Performance Analysis

The number of URLs that can be encoded is quite large in this case, nearly of the order (10+26*2)^6

The length of the encoded URLs is fixed to 6 units, which is a significant reduction for very large URLs.

The performance of this scheme is quite good, due to a very less probability of repeated same codes generated.

We can increase the number of encodings possible as well, by increasing the length of the encoded strings. Thus, there exists a tradeoff between the length of the code and the number of encodings possible.

Predicting the encoding isn't possible in this scheme since random numbers are used.
* */


    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    Random rand = new Random();
    String key = getRand();

    public String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = getRand();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }


}
