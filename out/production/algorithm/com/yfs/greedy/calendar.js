import _lunarJson from './yi-ji'


//日期资料


var lunarInfo = new Array(
  0x4bd8, 0x4ae0, 0xa570, 0x54d5, 0xd260, 0xd950, 0x5554, 0x56af, 0x9ad0, 0x55d2,
  0x4ae0, 0xa5b6, 0xa4d0, 0xd250, 0xd295, 0xb54f, 0xd6a0, 0xada2, 0x95b0, 0x4977,
  0x497f, 0xa4b0, 0xb4b5, 0x6a50, 0x6d40, 0xab54, 0x2b6f, 0x9570, 0x52f2, 0x4970,
  0x6566, 0xd4a0, 0xea50, 0x6a95, 0x5adf, 0x2b60, 0x86e3, 0x92ef, 0xc8d7, 0xc95f,
  0xd4a0, 0xd8a6, 0xb55f, 0x56a0, 0xa5b4, 0x25df, 0x92d0, 0xd2b2, 0xa950, 0xb557,
  0x6ca0, 0xb550, 0x5355, 0x4daf, 0xa5b0, 0x4573, 0x52bf, 0xa9a8, 0xe950, 0x6aa0,
  0xaea6, 0xab50, 0x4b60, 0xaae4, 0xa570, 0x5260, 0xf263, 0xd950, 0x5b57, 0x56a0,
  0x96d0, 0x4dd5, 0x4ad0, 0xa4d0, 0xd4d4, 0xd250, 0xd558, 0xb540, 0xb6a0, 0x95a6,
  0x95bf, 0x49b0, 0xa974, 0xa4b0, 0xb27a, 0x6a50, 0x6d40, 0xaf46, 0xab60, 0x9570,
  0x4af5, 0x4970, 0x64b0, 0x74a3, 0xea50, 0x6b58, 0x5ac0, 0xab60, 0x96d5, 0x92e0,
  0xc960, 0xd954, 0xd4a0, 0xda50, 0x7552, 0x56a0, 0xabb7, 0x25d0, 0x92d0, 0xcab5,
  0xa950, 0xb4a0, 0xbaa4, 0xad50, 0x55d9, 0x4ba0, 0xa5b0, 0x5176, 0x52bf, 0xa930,
  0x7954, 0x6aa0, 0xad50, 0x5b52, 0x4b60, 0xa6e6, 0xa4e0, 0xd260, 0xea65, 0xd530,
  0x5aa0, 0x76a3, 0x96d0, 0x4afb, 0x4ad0, 0xa4d0, 0xd0b6, 0xd25f, 0xd520, 0xdd45,
  0xb5a0, 0x56d0, 0x55b2, 0x49b0, 0xa577, 0xa4b0, 0xaa50, 0xb255, 0x6d2f, 0xada0,
  0x4b63, 0x937f, 0x49f8, 0x4970, 0x64b0, 0x68a6, 0xea5f, 0x6b20, 0xa6c4, 0xaaef,
  0x92e0, 0xd2e3, 0xc960, 0xd557, 0xd4a0, 0xda50, 0x5d55, 0x56a0, 0xa6d0, 0x55d4,
  0x52d0, 0xa9b8, 0xa950, 0xb4a0, 0xb6a6, 0xad50, 0x55a0, 0xaba4, 0xa5b0, 0x52b0,
  0xb273, 0x6930, 0x7337, 0x6aa0, 0xad50, 0x4b55, 0x4b6f, 0xa570, 0x54e4, 0xd260,
  0xe968, 0xd520, 0xdaa0, 0x6aa6, 0x56df, 0x4ae0, 0xa9d4, 0xa4d0, 0xd150, 0xf252,
  0xd520);

var solarMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
var Gan = new Array("甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸");
var Zhi = new Array("子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥");
var Animals = new Array("鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪");
var solarTerm = new Array("小寒", "大寒", "立春", "雨水", "惊蛰", "春分", "清明", "谷雨", "立夏", "小满", "芒种", "夏至", "小暑", "大暑", "立秋", "处暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至");
var sTermInfo = new Array(0, 21208, 42467, 63836, 85337, 107014, 128867, 150921, 173149, 195551, 218072, 240693, 263343, 285989, 308563, 331033, 353350, 375494, 397447, 419210, 440795, 462224, 483532, 504758);
var nStr1 = new Array('日', '一', '二', '三', '四', '五', '六', '七', '八', '九', '十', '十一', '十二');
var nStr2 = new Array('初', '十', '廿', '卅', '□');
var monthName = new Array("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC");
var cmonthName = new Array('正', '二', '三', '四', '五', '六', '七', '八', '九', '十', '十一', '腊');

//公历节日 *表示放假日
var sFtv = new Array(
  "0101 元旦",
  "0210 气象节",
  "0214 情人节",
  "0308 妇女节",
  "0312 植树节",
  "0315 消费者日",
  "0323 世界气象",
  "0401 愚人节",
  "0501 劳动节",
  "0504 青年节",
  "0531 无烟日",
  "0601 儿童节",
  "0605 世界环境",
  "0626 反毒品日",
  "0701 建党日",
  "0707 七七事变",
  "0801 建军节",
  "0815 日本投降",
  "0903 抗战胜利",
  "0910 教师节",
  "0918 九·一八",
  "0930 烈士纪念",
  "1001 国庆节",
  "1031 万圣节",
  "1111 光棍节",
  "1117 大学生节",
  "1201 艾滋病日",
  "1210 世界人权",
  "1213 国家公祭",
  "1220 澳门回归",
  "1224 平安夜",
  "1225 圣诞节");
//某月的第几个星期几。 5,6,7,8 表示到数第 1,2,3,4 个星期几
var wFtv = new Array(
  //一月的最后一个星期日（月倒数第一个星期日）
  "0520 母亲节",
  "0630 父亲节",
  "1144 感恩节");

//农历节日
var lFtv = new Array(
  "0101 春节",
  "0115 元宵节",
  "0202 龙抬头",
  "0505 端午节",
  "0707 七夕",
  "0715 中元节",
  "0815 中秋节",
  "0909 重阳节",
  "1208 腊八节",
  "1223 北方小年",
  "1224 南方小年",
  "0100 除夕");

/*****************************************************************************
                                      日期计算
*****************************************************************************/

//====================================== 返回农历 y年的总天数
function lYearDays(y) {
  var i, sum = 348;
  for (i = 0x8000; i > 0x8; i >>= 1) sum += (lunarInfo[y - 1900] & i) ? 1 : 0;
  return (sum + leapDays(y));
}

//====================================== 返回农历 y年闰月的天数
function leapDays(y) {
  if (leapMonth(y)) return ((lunarInfo[y - 1899] & 0xf) == 0xf ? 30 : 29);
  else return (0);
}

//====================================== 返回农历 y年闰哪个月 1-12 , 没闰返回 0
function leapMonth(y) {
  var lm = lunarInfo[y - 1900] & 0xf;
  return (lm == 0xf ? 0 : lm);
}

//====================================== 返回农历 y年m月的总天数
function monthDays(y, m) {
  return ((lunarInfo[y - 1900] & (0x10000 >> m)) ? 30 : 29);
}



//====================================== 算出农历, 传入日期控件, 返回农历日期控件
//                                       该控件属性有 .year .month .day .isLeap
function Lunar(objDate) {

  var i, leap = 0,
    temp = 0;
  var offset = (Date.UTC(objDate.getFullYear(), objDate.getMonth(), objDate.getDate()) - Date.UTC(1900, 0, 31)) / 86400000;

  for (i = 1900; i < 2100 && offset > 0; i++) {
    temp = lYearDays(i);
    offset -= temp;
  }

  if (offset < 0) {
    offset += temp;
    i--;
  }

  this.year = i;

  leap = leapMonth(i); //闰哪个月
  this.isLeap = false;

  for (i = 1; i < 13 && offset > 0; i++) {
    //闰月
    if (leap > 0 && i == (leap + 1) && this.isLeap == false) {
      --i;
      this.isLeap = true;
      temp = leapDays(this.year);
    } else {
      temp = monthDays(this.year, i);
    }

    //解除闰月
    if (this.isLeap == true && i == (leap + 1)) this.isLeap = false;

    offset -= temp;
  }

  if (offset == 0 && leap > 0 && i == leap + 1)
    if (this.isLeap) {
      this.isLeap = false;
    } else {
      this.isLeap = true;
      --i;
    }

  if (offset < 0) {
    offset += temp;
    --i;
  }

  this.month = i;
  this.day = offset + 1;
}

function getSolarDate(lyear, lmonth, lday, isLeap) {
  var offset = 0;

  // increment year
  for (var i = 1900; i < lyear; i++) {
    offset += lYearDays(i);
  }

  // increment month
  // add days in all months up to the current month
  for (var i = 1; i < lmonth; i++) {
    // add extra days for leap month
    if (i == leapMonth(lyear)) {
      offset += leapDays(lyear);
    }
    offset += monthDays(lyear, i);
  }
  // if current month is leap month, add days in normal month
  if (isLeap) {
    offset += monthDays(lyear, i);
  }

  // increment 
  offset += parseInt(lday) - 1;

  var baseDate = new Date(1900, 0, 31);
  var solarDate = new Date(baseDate.valueOf() + offset * 86400000);
  return solarDate;
}


//==============================返回公历 y年某m+1月的天数
function solarDays(y, m) {
  if (m == 1)
    return (((y % 4 == 0) && (y % 100 != 0) || (y % 400 == 0)) ? 29 : 28);
  else
    return (solarMonth[m]);
}

//============================== 传入 offset 返回干支, 0=甲子
function cyclical(num) {
  return (Gan[num % 10] + Zhi[num % 12]);
}


//============================== 阴历属性
function calElement(sYear, sMonth, sDay, week, lYear, lMonth, lDay, isLeap, cYear, cMonth, cDay, cMnum, cDnum) {

  this.isToday = false;
  //瓣句
  this.sYear = sYear; //公元年4位数字
  this.sMonth = sMonth; //公元月数字
  this.sDay = sDay; //公元日数字
  this.week = week; //星期, 1个中文
  //农历
  this.lYear = lYear; //公元年4位数字
  this.lMonth = lMonth; //农历月数字
  this.lDay = lDay; //农历日数字
  this.isLeap = isLeap; //是否为农历闰月?
  //八字
  this.cYear = cYear; //年柱, 2个中文
  this.cMonth = cMonth; //月柱, 2个中文
  this.cDay = cDay; //日柱, 2个中文

  this.color = '';

  this.lunarFestival = ''; //农历节日
  this.solarFestival = ''; //公历节日
  this.solarTerms = ''; //节气

  this.cMnumber = cMnum;
  this.cDnumber = cDnum;
}

//===== 某年的第n个节气为几日(从0小寒起算)
function sTerm(y, n) {
  if (!!jieqiJson["y" + y])
    return jieqiJson["y" + y][n];
  var offDate = new Date((31556925974.7 * (y - 1900) + sTermInfo[n] * 60000) + Date.UTC(1900, 0, 6, 2, 5));
  return (offDate.getDate());
}





//============================== 返回阴历控件 (y年,m+1月)
/*
功能说明: 返回整个月的日期资料控件

使用方式: OBJ = new calendar(年,零起算月);

  OBJ.length      返回当月最大日
  OBJ.firstWeek   返回当月一日星期

  由 OBJ[日期].属性名称 即可取得各项值

  OBJ[日期].isToday  返回是否为今日 true 或 false

  其他 OBJ[日期] 属性参见 calElement() 中的注解
*/
function calendar(y, m) {

  var sDObj, lDObj, lY, lM, lD = 1,
    lL, lX = 0,
    tmp1, tmp2, tmp3;
  var cY, cM, cD; //年柱,月柱,日柱
  var lDPOS = new Array(3);
  var n = 0;
  var firstLM = 0;

  sDObj = new Date(y, m, 1, 0, 0, 0, 0); //当月一日日期

  this.length = solarDays(y, m); //公历当月天数
  this.firstWeek = sDObj.getDay(); //公历当月1日星期几

  ////////年柱 1900年立春后为庚子年(60进制36)
  if (m < 2) cY = cyclical(y - 1900 + 36 - 1); //当m为1时，应计算前一年的阴历
  else cY = cyclical(y - 1900 + 36);
  var term2 = sTerm(y, 2); //立春日期

  ////////月柱 1900年1月小寒以前为 丙子月(60进制12)
  var firstNode = sTerm(y, m * 2); //返回当月「节」为几日开始

  var cMnum = (y - 1900) * 12 + m + 12;

  cM = cyclical(cMnum);

  //当月一日与 1900/1/1 相差天数
  //1900/1/1与 1970/1/1 相差25567日, 1900/1/1 日柱为甲戌日(60进制10)
  var dayCyclical = Date.UTC(y, m, 1, 0, 0, 0, 0) / 86400000 + 25567 + 10;

  for (var i = 0; i < this.length; i++) {

    if (lD > lX) {
      sDObj = new Date(y, m, i + 1); //当月一日日期
      lDObj = new Lunar(sDObj); //农历
      lY = lDObj.year; //农历年
      lM = lDObj.month; //农历月
      lD = lDObj.day; //农历日
      lL = lDObj.isLeap; //农历是否闰月
      lX = lL ? leapDays(lY) : monthDays(lY, lM); //农历当月最后一天

      if (n == 0) firstLM = lM;
      lDPOS[n++] = i - lD + 1;
    }

    //依节气调整二月分的年柱, 以立春为界
    if (m == 1 && (i + 1) == term2) cY = cyclical(y - 1900 + 36);
    //依节气月柱, 以「节」为界
    if ((i + 1) == firstNode) cM = cyclical((y - 1900) * 12 + m + 13);
    //日柱
    var cDnum = dayCyclical + i;
    if ((i + 1) >= firstNode) {
      cMnum = (y - 1900) * 12 + m + 13;
    }
    cD = cyclical(cDnum);


    //sYear,sMonth,sDay,week,
    //lYear,lMonth,lDay,isLeap,
    //cYear,cMonth,cDay

    this[i] = new calElement(y, m + 1, i + 1, nStr1[(i + this.firstWeek) % 7],
      lY, lM, lD++, lL,
      cY, cM, cD, cMnum, cDnum);
  }

  //节气
  tmp1 = sTerm(y, m * 2) - 1;
  tmp2 = sTerm(y, m * 2 + 1) - 1;
  this[tmp1].solarTerms = solarTerm[m * 2];
  this[tmp2].solarTerms = solarTerm[m * 2 + 1];
  //if(m==3) this[tmp1].color = 'red'; //清明颜色

  //公历节日
  for (var i = 0; i < sFtv.length; i++) {
    if (sFtv[i].match(/^(\d{2})(\d{2})([\s\*])(.+)$/))
      if (Number(RegExp.$1) == (m + 1)) {
        this[Number(RegExp.$2) - 1].solarFestival += RegExp.$4 + ' ';
        if (RegExp.$3 == '*') this[Number(RegExp.$2) - 1].color = 'red';
      }
  }
  //月周节日
  for (var i = 0; i < wFtv.length; i++)
    if (wFtv[i].match(/^(\d{2})(\d)(\d)([\s\*])(.+)$/))
      if (Number(RegExp.$1) == (m + 1)) {
        tmp1 = Number(RegExp.$2);
        tmp2 = Number(RegExp.$3);
        if (tmp1 < 5)
          this[((this.firstWeek > tmp2) ? 7 : 0) + 7 * (tmp1 - 1) + tmp2 - this.firstWeek].solarFestival += RegExp.$5 + ' ';
        else {
          tmp1 -= 5;
          tmp3 = (this.firstWeek + this.length - 1) % 7; //当月最后一天星期?
          this[this.length - tmp3 - 7 * tmp1 + tmp2 - (tmp2 > tmp3 ? 7 : 0) - 1].solarFestival += RegExp.$5 + ' ';
        }
      }

  //农历节日
  for (var i = 0; i < lFtv.length; i++)
    if (lFtv[i].match(/^(\d{2})(.{2})([\s\*])(.+)$/)) {
      tmp1 = Number(RegExp.$1) - firstLM;
      if (tmp1 == -11) tmp1 = 1;
      if (tmp1 >= 0 && tmp1 < n) {
        tmp2 = lDPOS[tmp1] + Number(RegExp.$2) - 1;
        if (tmp2 >= 0 && tmp2 < this.length && this[tmp2].isLeap != true) {
          this[tmp2].lunarFestival += RegExp.$4 + ' ';
          if (RegExp.$3 == '*') this[tmp2].color = 'red';
        }
      }
    }


  //复活节只出现在3或4月
  //  if(m==2 || m==3) {
  //      var estDay = new easter(y);
  //      if(m == estDay.m)
  //         this[estDay.d-1].solarFestival = this[estDay.d-1].solarFestival+' 复活节 Easter Sunday';
  //   }

  //黑色星期五
  //	if((this.firstWeek+12)%7==5)
  //      this[12].solarFestival += '黑色星期五';

  //今日
  //if(y==g_tY && m==g_tM) {this[g_tD-1].isToday = true;}

}


//====================== 中文日期//农历日期
function cDay(d) {
  var s;
  switch (d) {
    case 10:
      s = '初十';
      break;
    case 20:
      s = '二十';
      break;
    case 30:
      s = '三十';
      break;
    default:
      s = nStr2[Math.floor(d / 10)];
      s += nStr1[d % 10];
  }
  return (s);
}


var jieqiJson = {}
jieqiJson.y2016 = [6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 7, 22, 7, 23, 7, 22, 8, 23, 7, 22, 7, 21];
jieqiJson.y2015 = [6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22];
jieqiJson.y2014 = [5, 20, 4, 19, 6, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22];
jieqiJson.y2013 = [5, 20, 4, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22];

var templates = {
  month_day: function (date) {
    var d = date || new Date();
    return d.getDate();
  },
  lunar_Info: function (date) {
    var cld = cacheMgr.getCld(date.getFullYear(), date.getMonth());
    var day = date.getDate();
    var cld_day = cld[day - 1];
    var lunar_detail = {
      l_day: "",
      l_month: "",
      l_day_full: ""
    };
    lunar_detail.l_day = cDay(cld_day.lDay);
    lunar_detail.l_month = cld_day.lMonth;
    lunar_detail.color = "";
    return lunar_detail;
  },
  lunar_Info_detail: function (calendar, date) {
    var cld = calendar;
    //var year = date.getFullYear();
    var day = date.getDate();
    var cld_day = cld[day - 1];
    //var festival=[];
    var info = {
      lunar: "",
      y_Info: "",
      huangliY: "无",
      huangliJ: "无"
    };
    info.lunar = '农历' + (cld_day.isLeap ? '闰 ' : '') + templates.getChinaNum(cld_day.lMonth) + "月" + cDay(cld_day.lDay);
    info.y_Info = cld_day.cYear + '年【' + this.lunar_year(date) + "】 " + cld_day.cMonth + '月' + cld_day.cDay + '日';
    try {
      var cM = cld_day.cMnumber;
      var cD = cld_day.cDnumber;

      var month = (cM - 2) % 12;
      var jianxing = (cD - month) % 12;
      var jiazi = cD % 60;

      if (jianxing.toString().length == 1) {
        jianxing = "0" + jianxing;
      }
      if (jiazi.toString().length == 1) {
        jiazi = "0" + jiazi;
      }
      var YJArray = _lunarJson[jianxing + "" + jiazi];

      info.huangliY = YJArray.Y;
      info.huangliJ = YJArray.J;

    } catch (e) {

    }
    return info;
  },
  lunar_year: function (date) {

    var l_year = Animals[(date.getFullYear() - 4) % 12] + '年';
    return l_year;
  },
  getChinaNum: function (Num) {
    var monthEn = '';
    switch (Num) {
      case 1:
        monthEn = "一";
        break;
      case 2:
        monthEn = "二";
        break;
      case 3:
        monthEn = "三";
        break;
      case 4:
        monthEn = "四";
        break;
      case 5:
        monthEn = "五";
        break;
      case 6:
        monthEn = "六";
        break;
      case 7:
        monthEn = "七";
        break;
      case 8:
        monthEn = "八";
        break;
      case 9:
        monthEn = "九";
        break;
      case 10:
        monthEn = "十";
        break;
      case 11:
        monthEn = "十一";
        break;
      case 12:
        monthEn = "腊";
        break;
    }
    return monthEn;
  },
};

//////////////////////////   以下是自己增加的   ////////////////////////////

const nStr3 = ['〇', '一', '二', '三', '四', '五', '六', '七', '八', '九']
const holidayWorkday = {
  20190101: 'holiday',
  20190202: 'workday',
  20190203: 'workday',
  20190204: 'holiday',
  20190205: 'holiday',
  20190206: 'holiday',
  20190207: 'holiday',
  20190208: 'holiday',
  20190209: 'holiday',
  20190210: 'holiday',
  20190405: 'holiday',
  20190406: 'holiday',
  20190407: 'holiday',
  20190428: 'workday',
  20190501: 'holiday',
  20190502: 'holiday',
  20190503: 'holiday',
  20190505: 'workday',
  20190607: 'holiday',
  20190608: 'holiday',
  20190609: 'holiday',
  20190913: 'holiday',
  20190914: 'holiday',
  20190915: 'holiday',
  20190929: 'workday',
  20191001: 'holiday',
  20191002: 'holiday',
  20191003: 'holiday',
  20191004: 'holiday',
  20191005: 'holiday',
  20191006: 'holiday',
  20191007: 'holiday',
  20191012: 'workday',
}

function isHolidayInLaw(year, month, day) {
  return holidayWorkday[year * 10000 + month * 100 + day] === 'holiday'
}

function isWorkdayInLaw(year, month, day) {
  return holidayWorkday[year * 10000 + month * 100 + day] === 'workday'
}

function totalDaysOfMonth(year, month) {
  return month === 2 
    ? ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) ? 29 : 28)
    : solarMonth[month - 1]
}

function indexOfYear(year, month, day) {
  let total = day
  for (let i = 1; i < month; ++i) {
    total += totalDaysOfMonth(year, i)
  }
  return total
}

function lYear(year) {
  let y = '年'
  while (year > 0) {
    let t = year % 10
    year = Math.floor(year / 10)
    y = nStr3[t] + y
  }
  return y
}

function lMonth(month, isLeap) {
  return (isLeap ? '闰' : '') + cmonthName[month - 1] + '月'
}

function lDay(day) {
  return cDay(day)
}

function lAnimalIndex(sYear, sMonth, lMonth) {
  if (sMonth > 3 || lMonth < 10) {
    return (sYear - 4) % 12 + 1
  } else {
    return (sYear - 4 - 1) % 12 + 1
  }
}

function trim(s) {
  if (s === undefined) {
    return s
  } else {
    return s.trim()
  }
}

class Day {
  /**
   * @param {boolean} isToday 是否今日 
   * @param {boolean} isWorkdayInLaw 法定工作日（如果正好是工作日，不算法定工作日）
   * @param {boolean} isHolidayInLaw 法定节休（如果正好是周末，不算法定节休）
   * @param {boolean} isRestDay 是否休息
   * @param {number} sYear 阳历年
   * @param {number} sMonth 阳历月
   * @param {number} sDay 阳历日
   * @param {string} sWeek 阳历星期，星期X 字符串格式
   * @param {number} sWeekday 阳历星期几，0-based 0表示周日
   * @param {number} sWeekOfYear 阳历当年的第几周 1-based
   * @param {string} sTerm 节气
   * @param {string} sFestival 阳历节日
   * @param {string} lYear 阴历年
   * @param {string} lMonth 阴历月
   * @param {string} lDay 阴历日
   * @param {string} lFestival 阴历节日
   * @param {boolean} lIsLeap 是否阴历闰月
   * @param {number} lAnimalIndex 生肖序号 1-based
   * @param {string[]} yi 宜
   * @param {string[]} ji 忌
   * @param {string} cYear 八字年柱
   * @param {string} cMonth 八字月柱
   * @param {string} cDay 八字日柱
   */
  constructor({
    isToday,
    isWorkdayInLaw,
    isHolidayInLaw,
    sYear,
    sMonth,
    sDay,
    sWeekday,
    sWeekOfYear,
    sTerm,
    sFestival,
    lYear,
    lMonth,
    lDay,
    lFestival,
    lIsLeap,
    lAnimalIndex,
    yi,
    ji,
    cYear,
    cMonth,
    cDay
  }) {
    this.isToday = isToday
    this.isWorkdayInLaw = isWorkdayInLaw
    this.isHolidayInLaw = isHolidayInLaw
    this.sYear = sYear
    this.sMonth = sMonth
    this.sDay = sDay
    this.sWeekday = sWeekday,
    this.sWeekOfYear = sWeekOfYear
    this.sTerm = sTerm
    this.sFestival = sFestival
    this.lYear = lYear
    this.lMonth = lMonth
    this.lDay = lDay
    this.lFestival = lFestival
    this.lIsLeap = lIsLeap
    this.lAnimalIndex = lAnimalIndex
    this.yi = yi
    this.ji = ji
    this.cYear = cYear
    this.cMonth = cMonth
    this.cDay = cDay

    this.isRestDay = this.isHolidayInLaw || (this.sWeekday === 0 || this.sWeekday === 6) && !this.isWorkdayInLaw
    this.sWeek = '星期' + nStr1[this.sWeekday]
    this.lAnimal = Animals[lAnimalIndex - 1]
  }
}

class Month {
  /**
   * @param {Day[]} days 每天
   */
  constructor(days) {
    this.days = days
  }
}

class ExtMonth {
  /**
   * @param {Day[]} days 每天
   * @param {number} prevYear 上个月的年份
   * @param {number} prevMonth 上个月的月份
   * @param {Day[]} prevDays 补齐第一周, 周日为一周第一天
   * @param {number} nextYear 下个月的年份
   * @param {number} nextMonth 下个月的月份
   * @param {Day[]} nextDays 补齐最后一周，周日为一周第一天
   */
  constructor({
    days,
    prevYear,
    prevMonth,
    prevDays,
    nextYear,
    nextMonth,
    nextDays
  }) {
    this.days = days
    this.prevYear = prevYear
    this.prevMonth = prevMonth
    this.prevDays = prevDays
    this.nextYear = nextYear
    this.nextMonth = nextMonth
    this.nextDays = nextDays
  }
}

const cache = {}

/**
 * 
 * @param {number} year 
 * @param {number} month 1-based
 * @returns {Month}
 */
function getMonth(year, month) {
  const key = year * 100 + month
  const now = new Date()
  if (!(key in cache)) {
    const c = new calendar(year, month - 1)
    const days = []
    for (let i = 1; i <= c.length; ++i) {
      let ce = c[i - 1]
      let yj = templates.lunar_Info_detail(c, new Date(year, month - 1, i))
      let yi = (trim(yj.huangliY) || '').split('.').filter(x => x)
      if (!yi || !yi.length) {
        yi = ['无']
      }
      let ji = (trim(yj.huangliJ) || '').split('.').filter(x => x)
      if (!ji || !ji.length) {
        ji = ['无']
      }
      days[i - 1] = new Day({
        isToday: now.getFullYear() === year && now.getMonth() === month - 1 && now.getDate() === i,
        isWorkdayInLaw: isWorkdayInLaw(ce.sYear, ce.sMonth, ce.sDay),
        isHolidayInLaw: isHolidayInLaw(ce.sYear, ce.sMonth, ce.sDay),
        sYear: ce.sYear,
        sMonth: ce.sMonth,
        sDay: ce.sDay,
        sWeekday: nStr1.indexOf(ce.week),
        sWeekOfYear: Math.ceil((indexOfYear(year, month, i) - nStr1.indexOf(ce.week) - 1) / 7) + 1,
        sTerm: trim(ce.solarTerms),
        sFestival: trim(ce.solarFestival),
        lYear: lYear(ce.lYear),
        lMonth: lMonth(ce.lMonth, ce.isLeap),
        lDay: lDay(ce.lDay),
        lFestival: trim(ce.lunarFestival),
        lIsLeap: ce.isLeap,
        lAnimalIndex: lAnimalIndex(ce.sYear, ce.sMonth, ce.lMonth),
        yi,
        ji,
        cYear: ce.cYear,
        cMonth: ce.cMonth,
        cDay: ce.cDay,
      })
    }

    cache[key] = new Month(days)
  }

  return cache[key]
}

/**
 * 获取补齐第一周和最后一周的月数据
 * @param {number} year 
 * @param {month} month 1-based
 * @returns {ExtMonth}
 */
function getExtMonth(year, month) {
  const days = [...getMonth(year, month).days]
  
  const firstDayWeekday = days[0].sWeekday
  const prevYear = month === 1 ? year - 1 : year
  const prevMonth = month === 1 ? 12 : month - 1
  let prevDays = []
  if (firstDayWeekday > 0) {
    const prevMonthDays = getMonth(prevYear, prevMonth).days
    prevDays = prevMonthDays.slice(-firstDayWeekday)
  }

  const lastDayWeekday = days[days.length - 1].sWeekday
  const nextYear = month === 12 ? year + 1 : year
  const nextMonth = month === 12 ? 1 : month + 1
  let nextDays = []
  if (lastDayWeekday < 6) {
    const nextMonthDays = getMonth(nextYear, nextMonth).days
    nextDays = nextMonthDays.slice(0, 6 - lastDayWeekday)
  }

  return new ExtMonth({
    days,
    prevYear,
    prevMonth,
    prevDays,
    nextYear,
    nextMonth,
    nextDays
  })
}

/**
 * 
 * @param {*} year 
 * @param {*} month 1-based
 * @param {*} day 
 * @returns {Day}
 */
function getDay(year, month, day) {
  return getMonth(year, month).days[day - 1]
}

/**
 * 得到 一月大、二月平 这些文字
 * @param {*} year 
 * @param {*} month 1-based
 */
function getMonthTitle1(year, month) {
  return nStr1[month] + '月' + (month === 2 ? ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) ? '闰' : '平') : solarMonth[month - 1] === 31 ? '大' : '小')
}

export {
  Month,
  Day
}

export default {
  getMonth,
  getExtMonth,
  getDay,
  getMonthTitle1
}
