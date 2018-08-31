<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/js/ztree/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/js/ztree/jquery.ztree.all-3.5.js"></script>
</head>
<body>
//1.在页面中提供UL元素,设置样式 class="ztree",给出ID方便找到元素<br/>
//2.通过变量setting 设置属性<<br/>
//3.构建ztree需要的数据 （标准 简单）<br/>
//4.调用ztree对象初始化 创建树<br/>

<%--<ul id="zTree01" class="ztree"></ul>--%>
<%--<script type="text/javascript">--%>

    <%--//设置属性,使用 默认--%>
    <%--var setting1={};--%>

    <%--//创建节点--%>
    <%--var nodes1 = [--%>
        <%--{"id":1,"name":"节点一",children:[{"id":101,"name":"节点二",children:[{"id":201,"name":"节点三"}]}]}--%>
    <%--]--%>

    <%--$.fn.zTree.init($("#zTree01"),setting1,nodes1)--%>
<%--</script>--%>

//使用zTree
<ul id="ztree2" class="ztree"></ul>
<script type="text/javascript">
    var setting2 = {
        data:{
            simpleData: {
                enable: true,   //开启简单数据模式
                idKey: "id",    //通过id属性指定节点标识
                pIdKey: "pId",  //通过pId属性指定上级节点
                rootPId: 0,     //根节点（顶级节点）上级ID为0
            }
        }
    }

    var nodes2 = [{"id":1,"name":"节点3","pId":101},
                  {"id":101,"name":"节点2","pId":103},
        {"id":103,"name":"节点1","pId":0}
    ]

    $.fn.zTree.init($("#ztree2"), setting2, nodes2);
</script>


</body>
</html>