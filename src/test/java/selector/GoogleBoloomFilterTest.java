package selector;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import com.google.common.hash.PrimitiveSink;
import org.junit.Test;


import java.nio.charset.Charset;

import static java.nio.charset.Charset.*;


/**
 * Created by Administrator on 2017/10/18.
 */
public class GoogleBoloomFilterTest {

    @Test
    public void testContains(){
        BloomFilter<String> bloomFilter = BloomFilter.create(new Funnel<String>() {
            public void funnel(String s, PrimitiveSink primitiveSink) {
                primitiveSink.putString(s, Charsets.UTF_8);
            }
        }, 60, 0.91);
        for(int i = 0; i < 100; i++){
//            if (i == 30) continue;
            bloomFilter.put("数字" + i);
        }
        for(int i = 100; i < 120; i++){
            boolean b = bloomFilter.mightContain("数字" + i);
            System.out.println("数字" + i + "是否存在:" + b);
        }
    }
}
