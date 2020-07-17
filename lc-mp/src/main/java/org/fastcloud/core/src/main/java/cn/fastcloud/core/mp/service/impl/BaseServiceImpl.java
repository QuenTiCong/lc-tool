package org.fastcloud.core.mp.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fastcloud.core.mp.entity.BaseEntity;
import org.fastcloud.core.mp.service.BaseService;
import org.fastcloud.core.mp.util.MyServletUtil;
import org.springframework.validation.annotation.Validated;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Validated
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {
    private Class<T> modelClass;

    public BaseServiceImpl() {
        Type type = this.getClass().getGenericSuperclass();
        this.modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
    }

    public boolean save(T entity) {
        entity.setCreateBy(MyServletUtil.getLoginUserId());
        return super.save(entity);
    }

    public boolean updateById(T entity) {
        entity.setUpdateBy(MyServletUtil.getLoginUserId());
        return super.save(entity);
    }
}
