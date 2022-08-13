package com.mugencai.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private int id;
    private String name;
    private List<Article> articles;

}
