<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:set var="root" value="${pageContext.request.contextPath}" scope="application"></c:set>
	<c:set var="nowDate" scope="request" value="<%=new java.util.Date()%>"></c:set>
	<c:set var="easyuiVersion" value="jquery-easyui-1.5.3"></c:set>
	<c:set var="easyuiThemeName" value="material"></c:set>
	
	<script type="text/javascript"> 
		var basePath = "${root}"; 
		var adminPath=basePath+"/admin"
	</script>
	
	<link id="easyuiTheme" rel="stylesheet" type="text/css" href="${root}/static/${easyuiVersion}/themes/${easyuiThemeName }/easyui.css"/>  
    <link rel="stylesheet" type="text/css" href="${root}/static/${easyuiVersion}/themes/icon.css"/>  
    <link rel="stylesheet" type="text/css" href="${root}/static/css/form.css"/>
    <script type="text/javascript" src="${root}/static/${easyuiVersion}/jquery.min.js"></script>  
    <script type="text/javascript" src="${root}/static/${easyuiVersion}/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${root}/static/${easyuiVersion}/locale/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript" src="${root}/static/jslib/calutil.js"></script>
	<script type="text/javascript" src="${root}/static/jslib/klg.util.js"></script>
	<script type="text/javascript" src="${root}/static/jslib/dataTable.js"></script>
	<script type="text/javascript" src="${root}/static/jslib/common.js"></script>
	
	<script type="text/javascript" src="${root}/static/js/jeasyuiex.js"></script>
	<script type="text/javascript" src="${root}/static/js/datagridex.js"></script>
			
	<script type="text/javascript" src="${root}/static/js/util.js"></script>  

	<script type="text/javascript" src="${root}/static/jslib/dictData.js?t=${nowDate.time}"></script>
	<script type="text/javascript" src="${root}/static/jslib/sysData.js?t=${nowDate.time}"></script>

	<script type="text/javascript" src="${root}/static/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${root}/static/js/validate.js"></script>
	<script type="text/javascript" src="${root}/static/js/jquery.tips.js"></script>	
