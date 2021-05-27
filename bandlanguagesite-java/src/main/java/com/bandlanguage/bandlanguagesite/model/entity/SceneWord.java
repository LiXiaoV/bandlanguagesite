package com.bandlanguage.bandlanguagesite.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xiaov
 * @since 2021-05-22 17:07
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("bls_dept_word")
public class SceneWord implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "dept_id")
    private Long sceneId;

    @TableField(value = "word_id")
    private Long wordId;
}
