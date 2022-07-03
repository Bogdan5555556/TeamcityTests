package com.apitest.dataModel;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private String name;
    private boolean copyAllAssociatedSettings;
    private String id;
    private ParentProject parentProject;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ParentProject{
        public static final String ROOT = "_Root";
        private String locator;
    }
}
