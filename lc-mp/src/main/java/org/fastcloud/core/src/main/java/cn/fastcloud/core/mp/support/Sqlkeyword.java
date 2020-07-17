package org.fastcloud.core.mp.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class Sqlkeyword {
    private static final String EQUAL = "_equal";
    private static final String NOT_EQUAL = "_notequal";
    private static final String LIKE = "_like";
    private static final String DATE_GE = "_dategt";
    private static final String DATE_LE = "_datelt";
    private static final String IGNORE = "_ignore";

    public static <T> void buildCondition(T data, QueryWrapper<?> qw) {
        if (ObjectUtil.isNotNull(data)) {
            Map<String, Object> map = BeanUtil.beanToMap(data);
            map.forEach((k, v) -> {
                if (ArrayUtil.isAllNotEmpty(new Object[]{k, v}) && !k.endsWith(IGNORE)) {
                    if (k.endsWith(EQUAL)) {
                        qw.eq(getColumn(k, EQUAL), v);
                    } else if (k.endsWith(NOT_EQUAL)) {
                        qw.eq(getColumn(k, NOT_EQUAL), v);
                    } else if (k.endsWith(DATE_GE)) {
                        qw.ge(getColumn(k, DATE_GE), v);
                    } else if (k.endsWith(DATE_LE)) {
                        qw.le(getColumn(k, DATE_LE), v);
                    } else {
                        qw.like(getColumn(k, LIKE), v);
                    }
                }
            });
        }
    }

    private static String getColumn(String column, String keyWord) {
        return StrUtil.removeSuffix(column, keyWord);
    }
}
