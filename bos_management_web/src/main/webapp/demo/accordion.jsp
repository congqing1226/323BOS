<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
</head>

<body class="easyui-layout">
<div style="height:100px;" data-options="region:'north'">北部区域</div>
<div style="width:150px;" data-options="region:'west'">
    <!-- 制作折叠面板（手风琴面板） -->
    <div id="aa" class="easyui-accordion" data-options="fit:true" style="width:300px;height:200px;">
        <div title="基本菜单" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
            基本菜單內容
        </div>
        <div title="系統菜单" data-options="iconCls:'icon-reload'" style="padding:10px;">

        </div>
        <%--<div title="财务报表" data-options="iconCls:'icon-reload'" style="padding:10px;"></div>--%>
    </div>
</div>
<div  data-options="region:'center'">中部区域</div>
<div style="width:100px;" data-options="region:'east'">东部区域</div>
<div style="height:100px;" data-options="region:'south'">南部区域</div>
</body>

</html>