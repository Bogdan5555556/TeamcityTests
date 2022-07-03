package com.apitest.dataModel;

import lombok.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Agent {
    private long id;
    private String name;
    private int typeId;
    private String href;
    private String webUrl;
}
