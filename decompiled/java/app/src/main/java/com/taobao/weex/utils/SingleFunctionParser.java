package com.taobao.weex.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class SingleFunctionParser<V> extends FunctionParser<String, List<V>> {

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface FlatMapper<V> {
        V map(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface NonUniformMapper<V> {
        List<V> map(List<String> list);
    }

    public SingleFunctionParser(String str, final FlatMapper<V> flatMapper) {
        super(str, new FunctionParser.Mapper<String, List<V>>() { // from class: com.taobao.weex.utils.SingleFunctionParser.1
            @Override // com.taobao.weex.utils.FunctionParser.Mapper
            public Map<String, List<V>> map(String str2, List<String> list) {
                HashMap map = new HashMap();
                LinkedList linkedList = new LinkedList();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    linkedList.add(flatMapper.map(it.next()));
                }
                map.put(str2, linkedList);
                return map;
            }
        });
    }

    public List<V> parse(String str) {
        LinkedHashMap<String, V> linkedHashMap = parse();
        if (linkedHashMap.containsKey(str)) {
            return (List) linkedHashMap.get(str);
        }
        return null;
    }

    public SingleFunctionParser(String str, final NonUniformMapper<V> nonUniformMapper) {
        super(str, new FunctionParser.Mapper<String, List<V>>() { // from class: com.taobao.weex.utils.SingleFunctionParser.2
            @Override // com.taobao.weex.utils.FunctionParser.Mapper
            public Map<String, List<V>> map(String str2, List<String> list) {
                HashMap map = new HashMap();
                map.put(str2, nonUniformMapper.map(list));
                return map;
            }
        });
    }
}
