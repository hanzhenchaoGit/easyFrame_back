webpackJsonp([11],{RaAC:function(n,e,o){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r={render:function(){var n=this.$createElement,e=this._self._c||n;return e("div",[e("common-table",{attrs:{url:this.url,"row-style":this.setCountStyle,showPagination:!1,align:"left",columns:this.columns,height:"80vh",formOptions:this.searchForm,autoLoad:""}})],1)},staticRenderFns:[]};var t=o("VU/8")({name:"XsCurrentMonthSybReport",data:function(){return{searchForm:{inline:!0,formType:"simple",showSearchBtn:!0,forms:[{label:"月份",required:!0,itemType:"date",type:"month",prop:"month"}]},url:"/report/xscurrentmonbysyb",columns:[{label:"人员",prop:"username",width:200},{label:"竞价咨询总数",prop:"zxsl"},{label:"咨询新客户成单数",prop:"zxcdcount"},{label:"咨询客户成单率",prop:"zxcdlv"},{label:"本月新客户到款",prop:"newcusdk"},{label:"本月老客户到款",prop:"oldcusdk"},{label:"本月老客户目标",prop:"oldcusmb"},{label:"本月老客户完成度",prop:"olddosche"},{label:"本月实到款",prop:"received"},{label:"本月目标额",prop:"monthmb"},{label:"本月完成度",prop:"dosche"}]}},methods:{setCountStyle:function(n){if(n.row.username.indexOf("合计")>-1)return"集团事业群合计"===n.row.username?"background-color:#CDAD00":"background-color:#EECFA1"}}},r,!1,function(n){o("jw5e")},"data-v-ab9c6cba",null);e.default=t.exports},cHd3:function(n,e,o){(n.exports=o("FZ+f")(!1)).push([n.i,"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n",""])},jw5e:function(n,e,o){var r=o("cHd3");"string"==typeof r&&(r=[[n.i,r,""]]),r.locals&&(n.exports=r.locals);o("rjj0")("bd7355d6",r,!0)}});