<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    	<title>表单字段类型</title>
   		<c:import url="/admin/pages/common/headsource.jsp"/>	
   		<script type="text/javascript" src="jquery.edatagrid.js"></script>	
  	</head>
<body>
	<table id="datagrid-table" class="easyui-datagrid" title="表单字段类型"
		data-options="
			rownumbers		: true,
			singleSelect	: true,
			fitColumns		: true, 
			url				: adminActionPath + '/fieldmeta/findpage?tableName=form_field_type',
			toolbar			: '#toolbar',
			fit				: true,
			pagination		: true,
			pageSize		: 15,
			pageList        : [10,15,20,25,30],
			showFooter		: true,
			idField			: 'id'">
		<thead>			
			<tr>				
				<th data-options="field:'columnName',width:100,align:'left',formatter:complexCol" editor="{type:'textbox'}">列名</th>

				<th data-options="field:'columnType',width:100,align:'left',formatter:complexCol"
					editor="{type:'combobox',options:{valueField:'sqlType',textField:'sqlType',editable:false,panelHeight:'auto',
							dataFn:getSqlTypeJson,value:'varchar'}}">物理类型</th>
				<th data-options="field:'attrType',width:100,align:'left',formatter:complexCol,"
					editor="{type:'combobox',options:{valueField:'code',textField:'name',editable:false,panelHeight:'auto',
							codeClass:'java_type',value:'String'}}">javaType</th>
							
				<th data-options="field:'attrName',width:100,align:'left',formatter:complexCol" editor="{type:'textbox'}">字段名称</th>
				
				<th data-options="field:'isPk',width:100,align:'left',formatter:codeCol,codeClass:'yes_or_no'" >主键</th>				
				<th data-options="field:'notNull',width:100,align:'left',formatter:codeCol,codeClass:'yes_or_no'">非空</th>
				
				<th data-options="field:'comments',width:100,align:'left',formatter:complexCol" editor="{type:'textbox'}">注释</th>
				<th data-options="field:'columnLabel',width:100,align:'left',formatter:complexCol" editor="{type:'textbox'}">显示名称</th>
								
			</tr>
		</thead>
	</table>
	<div id="toolbar">	
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
        	onclick="javascript:$('#datagrid-table').edatagrid('addRow')">添加</a>  

        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
        	onclick="javascript:$('#datagrid-table').edatagrid('destroyRow')">删除</a>

	</div>
	
	<script type="text/javascript">
		$(function(){
			$('#datagrid-table').edatagrid({
			});
		});
		var ag_sqlTypeJson={};
		$.get(adminActionPath +'/typemapping/findlist',function(json){
			ag_sqlTypeJson=json.data;
		},'json')
		
		function getSqlTypeJson(){
			return ag_sqlTypeJson;
		}
		
	</script>
</body>
</html>
			