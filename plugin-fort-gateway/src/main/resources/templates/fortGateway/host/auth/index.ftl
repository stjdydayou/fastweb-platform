
<div class="bjui-pageHeader">
    <div class="pull-right">
        <@s.oauth pluginKey="fortGateway" moduleKey="hostManager" authorities="auth.add">
            <a href="/fortGateway/auth/edit.htm"
               data-mask="true" data-width="600" data-toggle="dialog"
               class="btn btn-default" data-icon="plus" data-title="添加分组">
                添加
            </a>
        </@s.oauth>
        <@s.oauth pluginKey="fortGateway" moduleKey="hostManager" authorities="auth.delete">
            <a type="button" class="btn btn-default" href="/fortGateway/auth/delete.ajax" data-icon="remove"
               data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-idname="ids" data-group="ids">
                删除
            </a>
        </@s.oauth>
    </div>
</div>


<div class="bjui-pageContent tableContent">
    <table data-toggle="tablefixed" data-width="100%">
        <thead>
        <tr>
            <th width="26">
                <input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck">
            </th>
            <th width="30">编号</th>
            <th width="70">操作</th>
            <th>名称</th>
            <th>认证方式</th>
            <th>登录账号</th>
            <th>创建时间</th>
            <th>备注说明</th>

        </tr>
        </thead>
        <tbody>
        <#list listData as row>
        <tr target="row_id" rel="${row.id}">
            <td>
                <input type="checkbox" name="ids" data-toggle="icheck" value="${row.id}">
            </td>
            <td>${row.id}</td>
            <td>
                <@s.oauth pluginKey="fortGateway" moduleKey="hostManager" authorities="auth.edit">
                    <a href="/fortGateway/auth/edit.htm?id=${row.id}"
                       data-mask="true" data-width="600" data-toggle="dialog"
                       class="btn btn-default btn-sm" data-icon="edit" data-title="修改[${row.name}]">
                        修改
                    </a>
                </@s.oauth>
            </td>
            <td>${row.name}</td>
            <td>${row.authType.text}</td>
            <td>${row.userName}</td>
            <td>${row.createdTime?datetime}</td>
            <td>${row.remark!''}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>