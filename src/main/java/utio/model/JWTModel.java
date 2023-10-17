package utio.model;


//import lombok.Data;

//import lombok.Data;

import lombok.Data;

@Data
/**用来放入jwt里面的参数  可以进行自定义*/
public class JWTModel {
    private String nickname; //姓名
    private String type; //登入方式
    private Integer uid; //唯一值UID

    public JWTModel() {


    }



}
