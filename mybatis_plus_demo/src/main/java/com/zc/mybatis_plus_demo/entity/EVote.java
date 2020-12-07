package com.zc.mybatis_plus_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zc
 * @since 2020-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EVote对象", description="")
public class EVote implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增记录ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "投票标题")
    private String name;

    @ApiModelProperty(value = "0文字1图片")
    private Integer type;

    @ApiModelProperty(value = "0正常1超时2删除")
    private Integer status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ApiModelProperty(value = "逻辑删除字段")
    private Integer deleted;


}
