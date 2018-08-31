<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
</head>

<table class="easyui-datagrid" data-options="url:'../data/user.json'">
    <%--<thead>
    <tr>
        <th data-options="field:'id'">编号</th>
        <th data-options="field:'name'">姓名</th>
        <th data-options="field:'age'">年龄</th>
    </tr>
    </thead>--%>


    <table id="tb"></table>
    <script type="text/javascript">

        $("#tb").datagrid({
            url:'../data/user.json',
            columns:[[
                {field:'id',title:'编号',width:100},  //列属性
                {field:'name',title:'姓名',width:100},
                {field:'age',title:'年龄',width:100,align:'right'}
            ]],

            pagination:true,

            toolbar:[{
                iconCls: 'icon-edit',
                text:'修改',
                handler: function(){
                    alert('edit')
                }
            }, {
                iconCls: 'icon-help',
                text:'帮助',
                handler: function(){
                    alert('help')
                }
            }]

        })

    </script>


</table>



</html>