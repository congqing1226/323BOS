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
<body id="addWindow" class="easyui-window" style="width: 600px;height: 400px" title="用户新增窗口" data-options="collapsible:false,minimizable:false">

    <form id="userForm" action="user_Action.action" method="post">

        用户名：<input type="text" name="username" class="easyui-validatebox" data-options="required:true,validType:'email'">
        年龄： <input type="text" name="age" class="easyui-numberbox" data-options="required:true,validType:'length[1,3]'" > <br>
        <input type="button" value="保存" id="saveBtn">

        <script type="text/javascript">

            $("#saveBtn").click(function () {

                var r =  $("#userForm").form("validate");
                if(r){
                    $("#userForm").submit();
                }

            })

        </script>



    </form>


</body>



</html>