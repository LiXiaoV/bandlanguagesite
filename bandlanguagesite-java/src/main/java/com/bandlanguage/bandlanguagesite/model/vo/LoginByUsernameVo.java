package com.bandlanguage.bandlanguagesite.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author xiaov
 * @since 2021-05-24 17:13
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class LoginByUsernameVo {

    private String username;
    private String password;
}
