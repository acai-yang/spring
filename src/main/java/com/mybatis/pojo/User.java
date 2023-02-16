package com.mybatis.pojo;

import lombok.*;

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
public class User {
    private int id;
    private String name;
    private int age;
}
