package org.fastcloud.core.mp.support;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@ApiModel(description = "查询条件")
@Data
public class AQuery {
    @ApiModelProperty("当前页")
    private Integer current;

    @ApiModelProperty("每页记录数")
    private Integer size;

    @ApiModelProperty("搜索文本")
    @TableField(exist = false)
    @JsonIgnore
    private String searchText;

    @ApiModelProperty("请求参数")
    @TableField(exist = false)
    @JsonIgnore
    private Map<String, Object> params;
}
