webpackJsonp([12],{QxCm:function(n,t,e){var o=e("kOAW");"string"==typeof o&&(o=[[n.i,o,""]]),o.locals&&(n.exports=o.locals);e("rjj0")("0da7aadb",o,!0)},kOAW:function(n,t,e){(n.exports=e("FZ+f")(!1)).push([n.i,"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n",""])},lvJg:function(n,t,e){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o={name:"ConsultList",components:{consultManager:e("p3JC").default},data:function(){return{window:{addWindow:!1,watchFlow:!1},img:{baseFlowImgUrl:this.baseUrl+"/activiti/getFlowImage",watchFlowImg:""},data:{consult:{},operate:""},table:{consult:{formOptions:{formType:"simple",inline:!0,showResetBtn:!0,showSearchBtn:!0,submitBtnText:"查询",resetBtnText:"重置",forms:[{prop:"name",label:"Name"},{prop:"type",label:"请求类型",itemType:"select",options:[{value:"",label:"All"},{value:"sql",label:"sql"},{value:"class",label:"class"}]}]},url:"consult/getXsConsultByPager",columns:[{colType:"selection"},{prop:"zxbh",label:"咨询编号"},{prop:"createtime",label:"咨询时间",width:149},{prop:"zxlyname",label:"咨询来源"},{prop:"zxlylxname",label:"咨询类型"},{prop:"qymc",label:"企业名称"},{prop:"jcxm",label:"咨询内容"},{prop:"kfrymc",label:"客服人员"},{prop:"fpksmc",label:"分配科室",width:200},{prop:"xsrymc",label:"销售人员"},{prop:"zxztname",label:"咨询状态"},{slotName:"operate",width:280}]}}}},methods:{refreshTable:function(){this.$refs.table.searchHandler()},commit:function(n){this.$request({url:"consult/commitXmxxZxxx",method:"post",params:{id:n.id}}).then(function(n){})},edit:function(n,t){console.log(n,"editRow"),this.$set(this.data,"consult",n),this.$set(this.data,"operate",t),this.window.addWindow=!0},showWatchFlow:function(n){this.$set(this.img,"watchFlowImg",this.img.baseFlowImgUrl+"?id="+n.taskid+"&"+new Date),this.window.watchFlow=!0}}},l={render:function(){var n=this,t=n.$createElement,e=n._self._c||t;return e("div",[e("el-dialog",{attrs:{title:"咨询信息",fullscreen:"",visible:n.window.addWindow,width:"100%"},on:{"update:visible":function(t){n.$set(n.window,"addWindow",t)},close:function(t){n.refreshTable()}}},[e("consultManager",{attrs:{editConsult:n.data.consult,operate:n.data.operate}})],1),n._v(" "),e("el-dialog",{attrs:{title:"咨询流程",visible:n.window.watchFlow},on:{"update:visible":function(t){n.$set(n.window,"watchFlow",t)}}},[e("img",{staticStyle:{width:"100%"},attrs:{src:n.img.watchFlowImg}})]),n._v(" "),e("common-table",{ref:"table",attrs:{"show-overflow-tooltip":"",url:n.table.consult.url,formOptions:n.table.consult.formOptions,columns:n.table.consult.columns,fit:""},scopedSlots:n._u([{key:"operate",fn:function(t){return[e("common-button",{attrs:{type:"primary"}},[e("svg-icon",{attrs:{"icon-class":"claim"}}),n._v("认领")],1),n._v(" "),e("common-button",{attrs:{type:"danger"}},[e("svg-icon",{attrs:{"icon-class":"goback"}}),n._v("退回")],1),n._v(" "),e("common-button",{attrs:{type:"primary"}},[e("svg-icon",{attrs:{"icon-class":"transfer"}}),n._v("转移")],1)]}},{key:"watchFlow",fn:function(n){}}])})],1)},staticRenderFns:[]};var a=e("VU/8")(o,l,!1,function(n){e("QxCm")},"data-v-d112a588",null);t.default=a.exports}});