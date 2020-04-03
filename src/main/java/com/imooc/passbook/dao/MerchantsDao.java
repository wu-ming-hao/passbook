package com.imooc.passbook.dao;

import com.imooc.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <h1>Merchants Dao 接口</h1>
 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer>  {

    /** 通过id获取商户对象
     * @param id 商户 id
     * @return {@link Merchants}
     */
    Merchants findAllById(Integer id);

    /**
     * <h2>根据商户名称获取商户对象</h2>
     * @param name 商户 name
     * @return {@link Merchants}
     */
    Merchants findAllByName(String name);

    /**
     * <h2>根据商户 ids 获取商户对象</h2>
     * @param ids 商户 ids
     * @return {@link Merchants}
     */
    List<Merchants> findAllByIn(List<Integer> ids);
}
