//-------------  easyui col format ------------------------

function complexCol(value, row, index) {
	if (this.field.indexOf('.') == -1)
		return value;
	var fields = this.field.split('.');
	var currentRef = row;
	for (var i = 0; i < fields.length; i++) {
		currentRef = currentRef[fields[i]];
		if (currentRef == null)
			break;
	}

	// value = eval("row['"+field.replace(/\./g,"']['")+"']");
	// alert(tmp);
	return currentRef;
}


function EasyUiDateTime(value, row, index){
	if (this.field.indexOf('.') == -1)
		return calUtil.formatDateTime(value);
	var fields = this.field.split('.');
	var currentRef = row;
	for (var i = 0; i < fields.length; i++) {
		currentRef = currentRef[fields[i]];
		if (currentRef == null)
			break;
	}
	return calUtil.formatDateTime(currentRef);
}

function EasyUiDate(value, row, index){
	if (this.field.indexOf('.') == -1)
		return calUtil.formatDate(value);
	var fields = this.field.split('.');
	var currentRef = row;
	for (var i = 0; i < fields.length; i++) {
		currentRef = currentRef[fields[i]];
		if (currentRef == null)
			break;
	}
	return calUtil.formatDate(currentRef);
}

//<th data-options="field:'depotid',width:140,align:'left',formatter:codeCol,codeClass:'57'">仓库</th>
function codeCol(value, row, index){
	//获取配置在field options中codeClass，this是字段field options
	var codeClass=this.codeClass;
	if (this.field.indexOf('.') == -1)
		return $.dictManager.getCodeValue(codeClass,value);
	var fields = this.field.split('.');
	var currentRef = row;
	for (var i = 0; i < fields.length; i++) {
		currentRef = currentRef[fields[i]];
		if (currentRef == null)
			break;
	}
	return $.dictManager.getCodeValue(codeClass,currentRef);
}



function resetForm(form_id,callback){
	$("#"+form_id).form("reset");
	if(callback)
		callback();
}

//在导出excel时有用到
function postParams(URL, PARAMS) {      
    var temp = document.createElement("form");      
    temp.action = URL;      
    temp.method = "post";      
    temp.style.display = "none";      
    for (var x in PARAMS) {      
        var opt = document.createElement("textarea");
        opt.name = x;      
        opt.value = PARAMS[x];      
        // alert(opt.name)      
        temp.appendChild(opt);      
    }      
    document.body.appendChild(temp);      
    temp.submit();      
    return temp;      
}