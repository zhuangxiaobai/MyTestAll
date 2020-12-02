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
 * @since 2020-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ELog对象", description="")
public class ELog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增记录ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "投票id")
    private Integer vid;

    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "选项id")
    private Integer oid;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
