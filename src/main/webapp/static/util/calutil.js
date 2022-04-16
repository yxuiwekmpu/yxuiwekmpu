Date.prototype.format = function(format) {
	/*
	 * eg:format="YYYY-MM-dd hh:mm:ss"; format1="YYYY/MM/dd hh:mm:ss"
	 * format2="YYYY-MM-dd"
	 */
	var o = {
		"M+" : this.getMonth() + 1, // month
		"d+" : this.getDate(), // day
		"h+" : this.getHours(), // hour
		"m+" : this.getMinutes(), // minute
		"s+" : this.getSeconds(), // second
		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
		"S" : this.getMilliseconds()
	// millisecond
	};

	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}

	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
};

var calUtil = {
	//------------------时间格式化--------------------
	
	formatDate:function(date){
		return date.format("yyyy-MM-dd");	
	},
	formatDateTime:function(date){
		var date = new Date();
		return date.format("yyyy-MM-dd hh:mm:ss");
	},
	formatDateByNum : function(year, month, day) {
		var date = new Date(year, month-1, day);
		return date.format("yyyy-MM-dd");
	},
	formatDateByEN : function(date) {
		var info = date.toString().split(" ");
		return info[1] + " " + info[2] + ", " + info[3];
	},
	formatDateByCN : function(date) {
		var syear = date.getFullYear(), smonth = date.getMonth() + 1, sday = date.getDate();
		return syear + "年" + smonth + "月" + sday + "日";
	},
	
	//------------------时间解析--------------------
	
	parseDate : function(strDate) {
		var date = eval('new Date(' + strDate.replace(/\d+(?=-[^-]+$)/, function(a) {
			return parseInt(a, 10) - 1;
		}).match(/\d+/g) + ')');
		return date;
	},
	
	getWeekDateArr : function(theDate) {
		var firstDateOfWeek = calUtil.getFirstDateOfWeek(theDate);
		var dateArr = new Array();
		for ( var i = 0; i < 7; i++) {
			var tempDate = new Date(theDate);
			tempDate.setDate(firstDateOfWeek.getDate() + i);
			dateArr.push(new Date(tempDate));
		}
		return dateArr;
	},
	// 得到每周的第一天(周日)
	getFirstDateOfWeek : function(theDate) {
		var firstDateOfWeek;
		theDate.setDate(theDate.getDate() - theDate.getDay()); //	 
		firstDateOfWeek = theDate;
		return firstDateOfWeek;
	},
	// 得到每周的最后一天(周六)
	getLastDateOfWeek : function(theDate) {
		var lastDateOfWeek;
		theDate.setDate(theDate.getDate() + 6 - theDate.getDay()); //	 
		lastDateOfWeek = theDate;
		return lastDateOfWeek;
	},

	getNextdayDate : function() {
		var today = new Date();
		var targetday_milliseconds = today.getTime() + 1000 * 60 * 60 * 24 * 1;
		today.setTime(targetday_milliseconds); // 注意，这行是关键代码
		return today;
	},
	getNextdayDateStr : function() {
		return calUtil.getNextdayDate().format("yyyy-MM-dd");
	},
	getCNDayOfWeek : function(objDate) {
		var aryDay = new Array("日","一","二","三","四","五","六");  
		return aryDay[objDate.getDay()];
	},
	getDaysInmonth : function(iMonth, iYear) {
		var dPrevDate = new Date(iYear, iMonth, 0);
		return dPrevDate.getDate();
	},

	bulidCal : function(iYear, iMonth) {
		var aMonth = new Array();
		aMonth[0] = new Array(7);
		aMonth[1] = new Array(7);
		aMonth[2] = new Array(7);
		aMonth[3] = new Array(7);
		aMonth[4] = new Array(7);
		aMonth[5] = new Array(7);
		aMonth[6] = new Array(7);
		var dCalDate = new Date(iYear, iMonth - 1, 1);
		var iDayOfFirst = dCalDate.getDay();
		var iDaysInMonth = calUtil.getDaysInmonth(iMonth, iYear);
		var iVarDate = 1;
		var d, w;
		aMonth[0][0] = "日";
		aMonth[0][1] = "一";
		aMonth[0][2] = "二";
		aMonth[0][3] = "三";
		aMonth[0][4] = "四";
		aMonth[0][5] = "五";
		aMonth[0][6] = "六";
		for (d = iDayOfFirst; d < 7; d++) {
			aMonth[1][d] = iVarDate;
			iVarDate++;
		}
		for (w = 2; w < 7; w++) {
			for (d = 0; d < 7; d++) {
				if (iVarDate <= iDaysInMonth) {
					aMonth[w][d] = iVarDate;
					iVarDate++;
				}
			}
		}
		return aMonth;
	}
};

