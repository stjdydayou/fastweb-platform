package com.dliyun.platform.core.service;

import com.dliyun.platform.common.exception.ServiceException;
import com.dliyun.platform.common.paginator.domain.PageBounds;
import com.dliyun.platform.common.paginator.domain.PageResult;
import com.dliyun.platform.core.model.SystemOauthUserBaseInfo;
import com.dliyun.platform.core.model.SystemOauthUserLoginAccount;
import com.dliyun.platform.core.model.SystemOauthUserLoginLog;
import com.dliyun.platform.core.model.SystemOauthUserPassword;
import com.dliyun.platform.core.vo.SystemOauthUserInfoVO;

import java.util.List;

/**
 * @author Administrator
 * @date 2017-6-5
 */
public interface SystemOauthUserInfoService {

    /**
     * 分页查询用户列表
     *
     * @param bounds
     * @param vo
     * @return
     */
    PageResult<SystemOauthUserBaseInfo> findPage(PageBounds bounds, SystemOauthUserInfoVO vo);


    /**
     * 查询用户单个的登录账号
     *
     * @param loginAccount
     * @param accountType
     * @return
     */
    SystemOauthUserLoginAccount findLoginAccount(String loginAccount, SystemOauthUserLoginAccount.AccountType accountType);

    /**
     * 查询用户所有登录账号
     *
     * @param uid
     * @return
     */
    List<SystemOauthUserLoginAccount> findLoginAccountsByUid(Long uid);

    /**
     * 查询用户基本信息
     *
     * @param id
     * @return
     */
    SystemOauthUserBaseInfo findUserBaseInfoById(Long id);

    /**
     * 查询用户登录密码
     *
     * @param uid
     * @param type
     * @return
     */
    SystemOauthUserPassword findUserPasswd(Long uid, SystemOauthUserPassword.UserPasswordType type);

    /**
     * 插入一条登录记录
     *
     * @param uid
     * @param ip
     */
    void updateLoginInfo(Long uid, String ip);

    /**
     * 查询用户最后一次登录
     *
     * @param uid
     * @return
     */
    SystemOauthUserLoginLog findLastLogin(Long uid);


    /**
     * 查询用户所拥有的权限
     *
     * @param uid
     * @return
     */
    List<String> findAuthorities(Long uid);

    /**
     * 查询用户所有的角色
     *
     * @param uid
     * @return
     */
    List<Long> findRolesIdByUserId(Long uid);

    /**
     * 保存用户基本信息
     *
     * @param userBaseInfo
     */
    void updateBaseInfo(SystemOauthUserBaseInfo userBaseInfo);

    /**
     * 保存用户基本信息。带账号变更
     *
     * @param userBaseInfo
     * @param loginAccounts
     * @throws ServiceException
     */
    void updateBaseInfo(SystemOauthUserBaseInfo userBaseInfo, List<SystemOauthUserLoginAccount> loginAccounts) throws ServiceException;

    /**
     * 更新用户密码
     *
     * @param uid
     * @param passwd
     * @param salt
     * @param type
     */
    void insertOrUpdateUserPassword(Long uid, String passwd, String salt, SystemOauthUserPassword.UserPasswordType type);

    /**
     * 保存用户角色
     *
     * @param uid
     * @param roleIds
     * @throws ServiceException
     */
    void saveRoles(Long uid, Long[] roleIds) throws ServiceException;

    /**
     * 注册一个新的用户
     *
     * @param userInfo
     * @param loginPassword
     * @param salt
     * @param loginAccounts
     */
    void register(SystemOauthUserBaseInfo userInfo, String loginPassword, String salt, List<SystemOauthUserLoginAccount> loginAccounts) throws ServiceException;
}
