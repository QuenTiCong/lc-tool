package org.fastcloud.core.mp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "服务商")
@Data
public class Provider extends BaseEntity {
    @ApiModelProperty("服务商编码")
    private String providerCode;
}
