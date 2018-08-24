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
<div id="aa" class="easyui-accordion" data-options="fit:true" style="width:300px;height:200px;">
    <div title="基本菜单" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
        <input type="button" value="点我" id="myBtn">
        <script type="text/javascript">
            $("#myBtn").click(function () {
                var r = $("#myTab").tabs("exists","系统管理");
                if(r){
                    $("#myTab").tabs("select","系统管理");
                }else{
                    //添加新的选项卡
                    $("#myTab").tabs("add",{
                        title:"系统管理",
                        iconCls:'icon-edit',
                        closable:true,
                        content:'<iframe frameborder="0" width="100%" height="100%" src="../pages/base/area.jsp"></iframe>'
                    })

                }

            })
        </script>
        <div title="系統菜单" data-options="iconCls:'icon-reload'" style="padding:10px;"></div>


    </div>
</div>
</div>
<div data-options="region:'center'">
    <div id="myTab" class="easyui-tabs" data-options="fit:true" style="width:300px;height:200px;">
        <%--<div title="基本管理" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">--%>
            <%--基本菜单内容--%>
        <%--</div>--%>
    </div>
</div>

<div style="width:100px;" data-options="region:'east'">东部区域</div>
<div style="height:100px;" data-options="region:'south'">南部区域</div>

</body>
</html>