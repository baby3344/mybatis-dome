package cn.smbms.dao.provider;

import cn.smbms.pojo.Provider;

import java.util.List;

public interface ProviderMapper {
    /**
     * 查询供应商记录数
     * @return
     */
    int count();

    /**
     * 查询供应商
     * @return
     */
    List<Provider> list();
}
