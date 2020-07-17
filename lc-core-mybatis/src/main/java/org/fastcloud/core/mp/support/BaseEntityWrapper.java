package org.fastcloud.core.mp.support;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public abstract class BaseEntityWrapper<E, V> {
    public abstract V entityVo(E entity);

    public List<V> listVO(List<E> list) {
        return list.stream().map(this::entityVo).collect(Collectors.toList());
    }

    public IPage<V> pageVO(IPage<E> iPage) {
        List<V> records = this.listVO(iPage.getRecords());
        IPage<V> pageVo = new Page(iPage.getCurrent(), iPage.getSize(), iPage.getTotal());
        pageVo.setRecords(records);
        return pageVo;
    }
}
