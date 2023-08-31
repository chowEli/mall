package com.zyl.mall.product.service.impl;

import com.zyl.mall.product.service.CategoryBrandRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyl.common.utils.PageUtils;
import com.zyl.common.utils.Query;

import com.zyl.mall.product.dao.CategoryDao;
import com.zyl.mall.product.entity.CategoryEntity;
import com.zyl.mall.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    //这里不需要导入了，因为使用mybatis-plus继承的ServiceImpl里面的baseMapper就是当前所表示的dao
//    @Autowired
//    CategoryDao categoryDao;

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1、先查出所有的分类数据
        List<CategoryEntity> all = baseMapper.selectList(null);
        //2、再组装分类的树形父子结构
        //2.1、过滤出所有的一级分类
        List<CategoryEntity> level1 = all.stream().filter(
                categoryEntity -> categoryEntity.getParentCid() == 0
        ).map((menu) -> {
            //2.2、使用递归的方式，查出每一个分类的子分类并组装到childrens属性中
            menu.setChildren(getChildren(menu, all));
            return menu;
        }).sorted((menu1,menu2) -> {
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());


        return level1;
    }

    /**
     * 删除菜单
     * @param catIds
     */
    @Override
    public void removeMenuByIds(List<Long> catIds) {
        //TODO 1、检查当前删除的菜单，是否在别处被引用
        //这里使用mybatis-plus的逻辑删除，需要在实体类中对逻辑删除的字段注解@TableLogic
        baseMapper.deleteBatchIds(catIds);

    }

    /**
     * 查询菜单路径
     * @param catelogId
     * @return
     *
     * [255,25,2]
     */
    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        List<Long> prentPath = findPrentPath(catelogId, paths);
        Collections.reverse(prentPath);
        return paths.toArray(new Long[prentPath.size()]);
    }

    /**
     * 级联更新所有的数据
     * @param category
     */
    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        //1、先更新自己
        this.updateById(category);
        //2、更新关联表
        categoryBrandRelationService.updateCategory(category.getCatId(),category.getName());


    }

    private List<Long> findPrentPath(Long catelogId,List<Long> paths){
        paths.add(catelogId);
        CategoryEntity category = this.getById(catelogId);
        if (category.getParentCid() != 0){
            findPrentPath(category.getParentCid(),paths);
        }
        return paths;
    }

    //递归查找所有的子菜单
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> childrens = all.stream().filter(
                categoryEntity -> categoryEntity.getParentCid() == root.getCatId()
        ).map(
         categoryEntity -> {
             //1、找到子菜单
             categoryEntity.setChildren(getChildren(categoryEntity, all));
             return categoryEntity;
        }).sorted((menu1,menu2) -> {
            //2、菜单的排序
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

        return childrens;
    }

}