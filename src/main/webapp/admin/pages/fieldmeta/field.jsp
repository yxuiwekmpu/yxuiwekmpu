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
							dataFn:getSqlTypeJson,value:'varchar',onSelect:sqlTypeOnSelect}}">物理类型</th>
				<th data-options="field:'attrType',width:100,align:'left',formatter:complexCol,"
					editor="{type:'combobox',options:{valueField:'code',textField:'name',editable:false,panelHeight:'auto',
							codeClass:'java_type',value:'String'}}">javaType</th>
							
				<th data-options="field:'attrName',width:100,align:'left',formatter:complexCol" editor="{type:'textbox'}">字段名称</th>
				
				<th data-options="field:'isPk',align:'center',width:15,align:'left',
					formatter:checkboxCol,editor:ag_checkbox_editor">主键</th>				
				<th data-options="field:'notNull',align:'center',width:15,align:'left',
					formatter:checkboxCol,editor:ag_checkbox_editor">非空</th>
				
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
		var ag_$dg=$("#datagrid-table");

		
		$.get(adminActionPath +'/typemapping/findlist',function(json){
			ag_sqlTypeJson=json.data;
		},'json')
		
		function getSqlTypeJson(){
			return ag_sqlTypeJson;
		}
		function sqlTypeOnSelect(record){
            var row = ag_$dg.datagrid('getSelected');  
            var rindex = ag_$dg.datagrid('getRowIndex', row);  
            var editor = ag_$dg.datagrid('getEditor', {  
                    index : rindex,  
                    field : 'attrType'  
                }); 
            if(editor && editor.target)
            	$(editor.target).combobox("setValue",record.javaType);
		}

		//----------------checkbox_editor--------------------------
		
		var ag_checkbox_editor={  
		        type:'checkboxCell',  
		        options:{  
		            on: "yes",  
		            off: "no"  
		        }  
		    }; 
		
		function checkboxCol(value, row, index){
			if(value == "yes"){
				return "<input style='width:15px;height:18px' type='checkbox' checked=true >";
			}else{
				return '<input style="width:15px;height:18px" type="checkbox">';
			}
		}
		
		$.extend($.fn.datagrid.defaults.editors, {
			checkboxCell: {
				init: function(container, options){
					var input = $('<input style="width:15px;height:18px" type="checkbox">').appendTo(container);
					input.val(options.on);
					input.attr('offval', options.off);
					return input;
				},
				getValue: function(target){
					if ($(target).is(':checked')){
						return $(target).val();
					} else {
						return $(target).attr('offval');
					}
				},
				setValue: function(target, value){
					var checked = false;
					if ($(target).val() == value){
						checked = true;
					}
					$(target)._propAttr('checked', checked);
				}
			}
		});		
	</script>
</body>
</html>
			