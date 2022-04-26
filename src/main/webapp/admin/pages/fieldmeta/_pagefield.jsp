<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<table id="pagefield-table" class="easyui-datagrid"
		data-options="
			rownumbers		: true,
			singleSelect	: true,
			fitColumns		: true, 
			url				: adminActionPath + '/pagefield/findlist',
			fit				: true,
			showFooter		: true, 
			onLoadSuccess	: editAllCol_page,
			idField			: 'id',
			loadFilter		: function(json){return json.data;},
			onClickRow		: function (rowIndex, rowData) {
				ag_$pagefield_table.datagrid('unselectRow', rowIndex);
				ag_checked_index = -1;
			},
			onCheck			: set_ag_checked_index">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'entityField.columnName',width:80,align:'left',formatter:complexCol">列名</th>
				<th data-options="field:'fieldTitle',width:100,align:'left',formatter:complexCol">显示名称</th>					
				<th data-options="field:'entityField.attrName',width:100,align:'left',formatter:complexCol">java字段</th>
				
				<th data-options="field:'canList',width:30,align:'left',
					formatter:checkboxCol,editor:ag_checkbox_editor">列表</th>
				
				<th data-options="field:'canQuery',width:30,align:'left',
					formatter:checkboxCol,editor:ag_checkbox_editor">查询</th>
				
				<th data-options="field:'queryType',width:50,align:'left',formatter:complexCol"
					editor="{type:'combobox',options:{valueField:'code',textField:'name',editable:false,panelHeight:'auto',
							codeClass:'query_type'}}">查询方式</th>
							
				<th data-options="field:'canEdit',width:30,align:'left',
					formatter:checkboxCol,editor:ag_checkbox_editor">编辑</th>				
				<th data-options="field:'required',width:30,align:'left',
					formatter:checkboxCol,editor:ag_checkbox_editor">必填</th>
				
				<th data-options="field:'gridRowCol',width:50,align:'left',formatter:complexCol"
					editor="{type:'combobox',options:{valueField:'code',textField:'name',editable:false,panelHeight:'auto',
							codeClass:'grid_row_col'}}">栅格</th>				

				<th data-options="field:'needNewLine',width:30,align:'left',
					formatter:checkboxCol,editor:ag_checkbox_editor">新行</th>

				<th data-options="field:'codeClass',width:80,align:'left',formatter:complexCol" 
					editor="{type:'textbox',options:{validType:'word'}}">字典</th>
				
				<th data-options="field:'fieldValid',width:50,align:'left',formatter:complexCol"
					editor="{type:'combobox',options:{valueField:'code',textField:'name',editable:false,panelHeight:'auto',
							dataFn:getFieldValidJson}}">字段校验</th>
																										
			</tr>
		</thead>
	</table>
<script type="text/javascript">

	//全局变量
	var ag_fieldValidJson={};
	var ag_$pagefield_table=$("#pagefield-table");
	
	$.get(adminActionPath +'/validation/findlist',function(json){
		ag_fieldValidJson=json.data;
	},'json')
	
	function getFieldValidJson(){
		return ag_fieldValidJson;
	}
	
	//$('#pagefield-table').edatagrid({});
	
	function editAllCol_page(data){
		var rows=data.rows;		
		for(var i = 0; i < rows.length; i++){
			ag_$pagefield_table.datagrid('beginEdit',i);
		}
	}

</script>