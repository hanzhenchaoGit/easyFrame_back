package com.frank.boot.domain.system;

import com.frank.boot.domain.base.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-03-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysInfobaseType extends PageInfo {

    private static final long serialVersionUID = 1L;

    private String typeCode;

    private String typeName;


}
