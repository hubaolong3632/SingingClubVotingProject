package utio.UtioClass;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

//JSON格式的操作指南
public class JS {
    public static String JSON(Object obj) { //传输json格式
        String json = JSON.toJSONString(obj); //序列化
        return json;
    }

    public static <T> T JSON_ObjectType(String json,Class<T> valueType){
        try{
            //如果遇到没有不填充值  和@JsonIgnoreProperties(ignoreUnknown = true) 一样
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(json, valueType);

//            ObjectMapper objectMapper = new ObjectMapper();
//            return  objectMapper.readValue(json, valueType);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }

    }



    public static String JSONNoDate(Object obj) { //传输json格式 并且不带时间的格式
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getExcludes().add("date"); // 过滤参数
        filter.getExcludes().add("text"); // 过滤参数
//        filter.getExcludes().add("sum"); // 过滤参数

        String json = JSON.toJSONString(obj,filter); //序列化
        return json;
    }

    public static String JSONNoDate(Object obj,String[] data) { //如果带了参数 ,那么就禁止掉传输进啦ide参数
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();

        for (String datum : data) {
            filter.getExcludes().add(datum); // 过滤参数
        }
        String json = JSON.toJSONString(obj,filter); //序列化
        return json;
    }
}