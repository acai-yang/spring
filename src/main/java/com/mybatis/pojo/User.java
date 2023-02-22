package com.mybatis.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * DESC
 *
 * @author YangMingCai
 * @date 2023年02月16日 9:23
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    private int id;
    private String name;
    private int age;
}
