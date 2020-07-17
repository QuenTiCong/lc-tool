package org.fastcloud.core.mp.support;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Map;

@ApiModel(description = "条件构造器")
@NoArgsConstructor
public class ACondition {
    private static final String CURRENT = "current";
    private static final String SIZE = "size";

    public static <T> IPage<T> getPage(AQuery aQuery) {
        Page<T> page = new Page(aQuery.getCurrent(), aQuery.getSize(), 10);
        return page;
    }

    public static <T> QueryWrapper<T> getQueryWrapper(T entity) {
        return new QueryWrapper(entity);
    }

    public static <T> QueryWrapper<T> getQueryWrapper(Map<String, Object> query, Class<T> clazz) {
        query.remove(CURRENT);
        query.remove(SIZE);
        QueryWrapper<T> qw = new QueryWrapper();
        qw.setEntity(BeanUtils.instantiateClass(clazz));
        Sqlkeyword.buildCondition(query, qw);
        return qw;
    }
}
