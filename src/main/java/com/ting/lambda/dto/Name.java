package com.ting.lambda.dto;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 *
 * @author ting
 * @version 1.0
 * @date 2021/04/13
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Name {
    public String name;

    public static void name(List<Name> list) {
        list.addAll(new ArrayList<Name>() {{
            add(new Name().setName("lisi"));
            add(new Name().setName("lisi"));
        }});
    }

    public static void main(String[] args) {
        List<Name> nameList = new ArrayList<>();
        name(nameList);
        System.out.println(JSON.toJSON(nameList));
    }
}
