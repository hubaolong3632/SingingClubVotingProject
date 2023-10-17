package com.example.singingclubvotingproject.model;

import lombok.Data;

//操作返回的
@Data
public class OperateModel {
    private Integer techweb; //当前选择的界面
    private Object data; //传输的内容
    private Integer seiect; //当前选中的值
    private String userName; //当前选中的值


}
