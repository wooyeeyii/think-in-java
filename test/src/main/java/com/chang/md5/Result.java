package com.chang.md5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Integer number;

    private Long id;

    private String name;

    private List<PackageData> packageDataList;

    private PackageData packageData;

    private List<String> list;


}
