package com.dliyun.fort.gateway.core.typehandler;

import com.dliyun.fort.gateway.core.enums.AuthType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author jtoms.shen
 * @version 1.0
 * @date 2019/3/21 20:36
 */
public class AuthTypeHandler extends BaseTypeHandler<AuthType> {

    @Override
    public AuthType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
        int i = rs.getInt(columnName);

        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的code值，定位CardLogStatus子类
            return locate(i);
        }
    }

    @Override
    public AuthType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
        int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的code值，定位CardLogStatus子类
            return locate(i);
        }
    }

    @Override
    public AuthType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放INT类型
        int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的code值，定位CardLogStatus子类
            return locate(i);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, AuthType parameter, JdbcType jdbcType) throws SQLException {
        // baseTypeHandler已经帮我们做了parameter的null判断
        ps.setInt(i, parameter.getCode());

    }

    /**
     * 枚举类型转换，由于构造函数获取了枚举的子类enums，让遍历更加高效快捷
     *
     * @param code 数据库中存储的自定义code属性
     * @return code对应的枚举类
     */
    private AuthType locate(int code) {
        return AuthType.valueOf(code);
    }
}