webpackJsonp([27],{KFk7:function(n,t,e){var o=e("OQJ2");"string"==typeof o&&(o=[[n.i,o,""]]),o.locals&&(n.exports=o.locals);e("rjj0")("eb581538",o,!0)},OQJ2:function(n,t,e){(n.exports=e("FZ+f")(!1)).push([n.i,"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n",""])},lvJg:function(n,t,e){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=e("Dd8w"),s=e.n(o),l=e("p3JC"),r=e("NYxO"),a={components:{consultManager:l.default},data:function(){return{window:{addWindow:!1,watchFlow:!1},baseUrl:this.baseUrl+"/file/getFileById?id=",img:{baseFlowImgUrl:this.baseUrl+"/activiti/getFlowImage",watchFlowImg:""},zyconsult:{zyWindow:!1,form:{user:"",userUrl:"/system/proxyExcute?uuid=3fc740e8-ceeb-4f8e-88f5-759ed9a3a025"}},goback:{backReasonShow:!1,form:{reason:""}},data:{consult:{},operate:""},table:{consult:{formOptions:{formType:"simple",inline:!0,showResetBtn:!0,showSearchBtn:!0,submitBtnText:"查询",resetBtnText:"重置",forms:[{prop:"name",label:"Name"},{prop:"type",label:"请求类型",itemType:"select",options:[{value:"",label:"All"},{value:"sql",label:"sql"},{value:"class",label:"class"}]}]},url:"consult/getXsConsultByPager",columns:[{colType:"selection"},{prop:"zxbh",label:"咨询编号",width:180,showOverflowTooltip:!0},{prop:"fpksmc",label:"所属科室",width:200},{prop:"xsrymc",label:"归属销售",showOverflowTooltip:!0},{prop:"qymc",label:"单位名称"},{prop:"jcxm",label:"客服转出信息",width:200,showOverflowTooltip:!0},{prop:"createtime",label:"咨询时间",width:149},{prop:"zxlyname",label:"客户来源",width:140},{prop:"khlxname",label:"客户类型"},{prop:"area",label:"所在省市",width:140},{slotName:"fjFiles",label:"附件",width:140},{slotName:"operate",label:"操作",width:280}]}}}},computed:s()({},Object(r.b)(["group"])),methods:{refreshTable:function(){this.$refs.table.searchHandler()},commit:function(n){this.$request({url:"consult/commitXmxxZxxx",method:"post",params:{id:n.id}}).then(function(n){})},edit:function(n,t){this.$set(this.data,"consult",n),this.$set(this.data,"operate",t),this.window.addWindow=!0},showWatchFlow:function(n){this.$set(this.img,"watchFlowImg",this.img.baseFlowImgUrl+"?id="+n.insid+"&"+new Date),this.window.watchFlow=!0},claimConsult:function(n){var t=this;this.$request({url:"/consult/claimConsult",params:{insId:n.insid}}).then(function(n){t.returnMsg(t,n),t.$refs.table.searchHandler()})},goBackConsult:function(n){var t=this;this.$refs["reasonForm"+n.id].validate(function(e){e&&t.$request({url:"/consult/goBackConsult",params:{insId:n.insid,reason:n.thyy}}).then(function(n){t.returnMsg(t,n),t.$refs.table.searchHandler()})})},zyConsult:function(n){var t=this;this.$refs.zyForm.validate(function(e){e&&t.$request({url:"/consult/transferConsult",params:{insId:n.insid,username:n.xsry}}).then(function(n){t.returnMsg(t,n),t.$refs.table.searchHandler()})})},cancleZy:function(n,t){this.$set(n,"edit",!1)},showReasonWindow:function(n){n.backable=!0,this.$refs["reasonForm"+n.id].resetFields()},showZyWindow:function(n,t){n.edit=!0,this.$refs.zyForm.resetFields(),this.$refs[t].loadData("fpks="+n.fpks+"&expuser="+n.xsry)},canalGoback:function(){this.goback.backReasonShow=!1},cancleBack:function(n){this.$set(n,"backable",!1)}}},i={render:function(){var n=this,t=n.$createElement,e=n._self._c||t;return e("div",[e("el-dialog",{attrs:{title:"咨询信息",fullscreen:"",visible:n.window.addWindow,width:"100%"},on:{"update:visible":function(t){n.$set(n.window,"addWindow",t)},close:function(t){n.refreshTable()}}},[e("consultManager",{attrs:{editConsult:n.data.consult,operate:n.data.operate}})],1),n._v(" "),e("el-dialog",{attrs:{title:"咨询流程",visible:n.window.watchFlow},on:{"update:visible":function(t){n.$set(n.window,"watchFlow",t)}}},[e("img",{staticStyle:{width:"100%"},attrs:{src:n.img.watchFlowImg}})]),n._v(" "),e("common-table",{ref:"table",attrs:{autoLoad:"","show-overflow-tooltip":"",url:n.table.consult.url,formOptions:n.table.consult.formOptions,columns:n.table.consult.columns,fit:""},scopedSlots:n._u([{key:"watchFlow",fn:function(t){return[t.row.taskid?e("common-button",{attrs:{type:"primary"},on:{click:function(e){n.showWatchFlow(t.row)}}},[n._v("查看咨询进程")]):n._e()]}},{key:"operate",fn:function(t){return["A"===n.group||"7"!==t.row.zxzt&&"8"!==t.row.zxzt?n._e():e("common-button",{attrs:{type:"primary",svgIcon:"claim"},on:{click:function(e){n.claimConsult(t.row)}}},[n._v("认领")]),n._v(" "),e("el-popover",{attrs:{placement:"top",width:"460"},model:{value:t.row.backable,callback:function(e){n.$set(t.row,"backable",e)},expression:"scope.row.backable"}},[e("el-form",{ref:"reasonForm"+t.row.id,attrs:{model:t.row}},[e("el-form-item",{attrs:{label:"退回原因",prop:"thyy",required:""}},[e("el-input",{attrs:{placeholder:"请输入退回原因",type:"textarea"},model:{value:t.row.thyy,callback:function(e){n.$set(t.row,"thyy",e)},expression:"scope.row.thyy"}})],1)],1),n._v(" "),e("div",{staticStyle:{"text-align":"right",margin:"0"}},[e("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(e){n.cancleBack(t.row)}}},[n._v("取消")]),n._v(" "),e("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(e){n.goBackConsult(t.row)}}},[n._v("确定")])],1),n._v(" "),t.row.zxzt>=7&&"N"===t.row.isdone?e("common-button",{attrs:{slot:"reference",type:"danger",svgIcon:"goback"},on:{click:function(e){n.showReasonWindow(t.row)}},slot:"reference"},[n._v("退回")]):n._e()],1),n._v(" "),e("el-popover",{attrs:{placement:"top",width:"460"},model:{value:t.row.edit,callback:function(e){n.$set(t.row,"edit",e)},expression:"scope.row.edit"}},[e("el-form",{ref:"zyForm",attrs:{model:t.row}},[e("el-form-item",{attrs:{label:"销售人员",prop:"xsry",required:""}},[e("common-select",{ref:"xsuser"+t.$index,attrs:{url:n.zyconsult.form.userUrl,initLoad:!1,placeholder:"请选择销售"},model:{value:t.row.xsry,callback:function(e){n.$set(t.row,"xsry",e)},expression:"scope.row.xsry"}})],1)],1),n._v(" "),e("div",{staticStyle:{"text-align":"right",margin:"0"}},[e("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(e){n.cancleZy(t.row,t.$index)}}},[n._v("取消")]),n._v(" "),e("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(e){n.zyConsult(t.row)}}},[n._v("确定")])],1),n._v(" "),"A"!==n.group||"7"!==t.row.zxzt&&"8"!==t.row.zxzt?n._e():e("common-button",{attrs:{slot:"reference",type:"primary",svgIcon:"transfer"},on:{click:function(e){n.showZyWindow(t.row,"xsuser"+t.$index)}},slot:"reference"},[n._v("转移")])],1)]}},{key:"fjFiles",fn:function(t){return[null!=t.row.files&&""!=t.row.files?e("el-tooltip",{attrs:{placement:"top",effect:"light"}},[e("el-button",[n._v("指向查看附件")]),n._v(" "),e("div",{staticClass:"clearfix",attrs:{slot:"content"},slot:"content"},n._l(t.row.files.split(","),function(t){return e("ul",{key:t.split("||")[1]},[e("li",[e("a",{attrs:{href:n.baseUrl+t.split("||")[1]}},[n._v(n._s(t.split("||")[0]))])])])}))],1):n._e()]}}])})],1)},staticRenderFns:[]};var c=e("VU/8")(a,i,!1,function(n){e("KFk7")},"data-v-4a88467a",null);t.default=c.exports}});