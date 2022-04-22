<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<c:import url="/admin/pages/common/headsource.jsp"/> 		

<title>Insert title here</title>
</head>
<body class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north'" style="height:70px"> <h1>easyui - layout</h1></div>
		<div data-options="region:'south',split:true" style="height:50px;"></div>
		<div data-options="region:'west',split:true" title="菜单" style="width:220px;">
			<ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,onClick:treeClick,onSelect:treeSelect"></ul>
		</div>
		<div data-options="region:'center',iconCls:'icon-ok'">
			<div class="easyui-tabs" id="tt" data-options="fit:true,border:false,plain:true,enableConextMenu:true,contextMenu:tab_menu">
				<div title="About" data-options="href:'_content.html'" style="padding:10px"></div>
				<div title="DataGrid" style="padding:5px">
					<table class="easyui-datagrid"
							data-options="url:'datagrid_data1.json',method:'get',singleSelect:true,fit:true,fitColumns:true">
						<thead>
							<tr>
								<th data-options="field:'itemid'" width="80">Item ID</th>
								<th data-options="field:'productid'" width="100">Product ID</th>
								<th data-options="field:'listprice',align:'right'" width="80">List Price</th>
								<th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
								<th data-options="field:'attr1'" width="150">Attribute</th>
								<th data-options="field:'status',align:'center'" width="50">Status</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
</body>

<script src="http://www.easyui-extlib.com/Scripts/jquery-extensions/jquery.jdirk.js"></script>
<script src="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/panel/jeasyui.extensions.panel.iframe.js"></script>
<script src="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/menu/jeasyui.extensions.menu.js"></script>
<script src="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/tabs/jeasyui.extensions.tabs.getTabs.js"></script>
<script src="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/tabs/jeasyui.extensions.tabs.closeTabs.js"></script>
<script src="http://www.easyui-extlib.com/Scripts/jquery-easyui-extensions/tabs/jeasyui.extensions.tabs.contextMenu.js"></script>
<script>
		//tab右键刷新菜单
		var tab_menu=[{id:'refresh',text:'刷新',hideOnClick:true,handler:function(e, menuItem, menu, target, title, index){
			 var tab = $(target).tabs('getSelected');  // 获取选择的面板
			 tab.panel('refresh');
		}}]

		// 打开一个tab iframe
		function addTab(option){
			if ($('#tt').tabs('exists', option.title)){
				$('#tt').tabs('select', option.title);
			} else {
				$('#tt').tabs('add',option);
			}
		}
		//tree 的点击事件，新打开一个tab iframe
		function treeClick(node)
		{
			var title = node.text;	
			if(node.url){
				var url = node.url;
				var icon= node.iconCls;

				if(url.charAt(0) == '/')
					url = "${pageContext.request.contextPath}" + url;
				else
					url =  url;	
				addTab({
					title:title,
					closable:true,
					href:url,
					iniframe:true
				});		
			}
		}
		//tree的 select事件，打开或关闭节点的触发器，target参数是一个节点DOM对象。
		function treeSelect(node){
			$(this).tree('toggle',node.target);   
		}

</script>
</html>