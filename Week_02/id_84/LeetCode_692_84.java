import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
public class solution {

        public List<String> topKFrequent(String[] words, int k) {
            Map<String,Integer> StringHashMap = new HashMap<String, Integer>();
            for (int i = 0; i < words.length; i++) {
                if (StringHashMap.get(words[i]) == null) {
                    StringHashMap.put(words[i], 1);
                }
                else {
                    int count = StringHashMap.get(words[i]);
                    StringHashMap.put(words[i], ++count);
                }

            }

            List<String> result = new ArrayList<>();
            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(StringHashMap.entrySet());
            //Collections.max(map.values());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o1.getValue() < o2.getValue()) {
                        return 1;
                    } else if (o1.getValue() > o2.getValue()) {
                        return -1;
                    }
                    else{
                        return o1.getKey().compareTo(o2.getKey());
                    }
                }
            });
            //sortByKey(StringHashMap);
            int count = 1;
            Iterator iter = list.iterator();
            while (count <= k && iter.hasNext()) {


                    Map.Entry entry = (Map.Entry)iter.next();
                    // 获取key
                    result.add((String)entry.getKey());
                    ++count;
                }

            return result;
        }
        }




