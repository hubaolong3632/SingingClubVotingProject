package utio;


import jakarta.servlet.http.HttpServletRequest;
import utio.UtioClass.*;
import utio.model.IPRessModel;
import utio.model.JWTDatasModel;
import utio.model.JWTModel;

import java.util.UUID;

//所有的方便的代码
public class UtioY {

     /**转换成Json格式*/
    public static  String JSON(Object obj){
      return   JS.JSON(obj);
    }

    /**转换成Json格式 , 并且禁止传输过来的参数为自定义的*/
    public static String JSONNoDate(Object obj,String... data) { //如果带了参数 ,那么就禁止掉传输进啦ide参数
        return  JS.JSONNoDate(obj,data);
    }


    /**JSON转成一个类 (传入 json格式 和需要转换的类型)*/
    public static <T> T JSON_ObjectType(String json,Class<T> valueType){
        return  JS.JSON_ObjectType(json,valueType);
    }

    /**jwt的创建*/
    public static String JWT_Create(String subject, JWTModel jwtmodel){
        return JwtUtil.JWTCreate(subject,jwtmodel);
    }

    /**jwt的解析
     * 如果成功返回 :JWTDatasModel
     * 如果秘钥失败/过时返回 : null
     * */
    public static JWTDatasModel JWT_PAnalysis(String jwt) {
        return JwtUtil.JWTAnalysis(jwt);
    }


    /**获取ip地址*/
    public static String IP_getIp(HttpServletRequest request) {
       return IP.getClientIp(request);
    }


    /**获取ip地址对应的省份城市*/
    public static IPRessModel getIPRessModel(String userIp){
        return IP.getIPRessModel(userIp);
    }


    /**防止html代码嵌入*/
    public  static String HTML_replace(String html) {
        return  HTMLReplace.htmlEscape(html);
    }


    /**获取当前系统时间 格式为 yyyy-MM-dd HH:mm:ss*/
    public static String Date_getDate(){
       return DateUtio.dateDay();
    }







    /**生成20位随机数*/
    public static String Random_number20(){
        //生成随机数 20位
        return  UUID.randomUUID().toString().replaceAll("-", "").substring(0,20);
    }

    /***/


    /***/


    /***/


    /***/


    /***/


    /***/


    /***/


    /***/


    /***/




}
