webpackJsonp([11],{WhfA:function(e,n,t){var r=t("dzo5");"string"==typeof r&&(r=[[e.i,r,""]]),r.locals&&(e.exports=r.locals);t("rjj0")("2eb66860",r,!0)},dzo5:function(e,n,t){(e.exports=t("FZ+f")(!1)).push([e.i,"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n",""])},sxVZ:function(e,n,t){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var r=t("Dd8w"),l=t.n(r),o=t("NYxO"),a={name:"ConsultList",components:{consultManager:t("p3JC").default},data:function(){return{window:{addWindow:!1,watchFlow:!1,moreSearch:!1},img:{baseFlowImgUrl:this.baseUrl+"/activiti/getFlowImage",watchFlowImg:""},data:{consult:{},operate:"",selectedIds:""},select:{zxly:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=sources"},zxlylx:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=sourcesType"},khlx:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=khlx"},sf:{url:"system/proxyExcute?uuid=1faf1d01-88ed-4e8e-8975-7eaa2c179135&level=1"},cs:{url:"system/proxyExcute?uuid=1faf1d01-88ed-4e8e-8975-7eaa2c179135&level=2"},fpks:{url:"system/proxyExcute?uuid=343d1975-5604-4041-9c07-4431b6742658"}},moreSearch:{},table:{consult:{formOptions:{formType:"simple",inline:!0,showResetBtn:!0,showSearchBtn:!0,submitBtnText:"查询",resetBtnText:"重置",forms:[{label:"咨询时间",itemType:"daterange",prop:["starttime","endtime"]},{prop:"qymc",label:"企业名称"},{prop:"sj",label:"手机"}]},url:"consult/getMyConsultByPager",columns:[{colType:"selection"},{prop:"zxbh",label:"咨询编号",width:170,showOverflowTooltip:!0},{prop:"createtime",label:"咨询时间",width:140},{prop:"zxlyname",label:"咨询来源"},{prop:"zxlylxname",label:"咨询类型"},{prop:"qymc",label:"企业名称"},{prop:"jcxm",label:"咨询内容"},{prop:"kfrymc",label:"客服人员"},{prop:"fpksmc",label:"分配科室",width:200},{prop:"xsrymc",label:"销售人员"},{prop:"zxztname",slotName:"zxzt",label:"咨询状态"},{prop:"thyy",label:"退回原因",showOverflowTooltip:!0},{slotName:"operate",width:250}]}}}},computed:l()({},Object(o.b)(["consultEditWindowShow"])),methods:{refreshTable:function(){this.setWindowStatus(!1),this.$refs.table.searchHandler()},pushSelected:function(e,n){this.$set(this.data,"selectedIds",e.map(function(e){return e.id}))},checkboxFun:function(e,n){return"1"!==e.istj},commitSelected:function(){var e=this;this.data.selectedIds?this.$request({url:"consult/commitXmxxZxxx",method:"post",params:{ids:this.data.selectedIds.toString()}}).then(function(n){e.returnMsg(e,n),e.$refs.table.searchHandler()}):this.$message({message:"请选择要提交的咨询",type:"error"})},edit:function(e,n){this.$set(this.data,"consult",e),this.$set(this.data,"operate",n),this.setWindowStatus(!0)},setWindowStatus:function(e){this.$store.dispatch("setShowEditWindow",e)},showWatchFlow:function(e){this.$set(this.img,"watchFlowImg",this.img.baseFlowImgUrl+"?id="+e.insid+"&"+new Date),this.window.watchFlow=!0},getCs:function(e,n){this.$set(this.moreSearch,"cs",""),this.$refs.cs.loadData("pid="+n)},doSearch:function(){this.$refs.table.fetchHandler(this.moreSearch)},resetSearch:function(){this.moreSearch={},this.$refs.consult.resetFields()}}},s={render:function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("div",[t("el-dialog",{attrs:{title:"咨询信息",fullscreen:"",visible:e.consultEditWindowShow,width:"100%"},on:{"update:visible":function(n){e.consultEditWindowShow=n},close:function(n){e.refreshTable()}}},[t("consultManager",{attrs:{editConsult:e.data.consult,from:"window",operate:e.data.operate}})],1),e._v(" "),t("el-dialog",{attrs:{title:"咨询流程",visible:e.window.watchFlow},on:{"update:visible":function(n){e.$set(e.window,"watchFlow",n)}}},[t("img",{staticStyle:{width:"100%"},attrs:{src:e.img.watchFlowImg}})]),e._v(" "),t("el-dialog",{attrs:{title:"更多查询",visible:e.window.moreSearch},on:{"update:visible":function(n){e.$set(e.window,"moreSearch",n)}}},[t("el-form",{ref:"consult",attrs:{model:e.moreSearch,"label-width":"90px"}},[t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"咨询来源",prop:"zxly"}},[t("common-select",{ref:"zxlyname",attrs:{url:e.select.zxly.url,filterable:""},model:{value:e.moreSearch.zxly,callback:function(n){e.$set(e.moreSearch,"zxly",n)},expression:"moreSearch.zxly"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{ref:"zxlylx",attrs:{label:"咨询类型",prop:"zxlylx"}},[t("common-select",{ref:"zxlylxname",attrs:{url:e.select.zxlylx.url,filterable:""},model:{value:e.moreSearch.zxlylx,callback:function(n){e.$set(e.moreSearch,"zxlylx",n)},expression:"moreSearch.zxlylx"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"客户类型",prop:"khlx"}},[t("common-select",{attrs:{url:e.select.khlx.url,filterable:""},model:{value:e.moreSearch.khlx,callback:function(n){e.$set(e.moreSearch,"khlx",n)},expression:"moreSearch.khlx"}})],1)],1)],1),e._v(" "),t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"所在省份",prop:"sf"}},[t("common-select",{attrs:{url:e.select.sf.url},on:{change:e.getCs},model:{value:e.moreSearch.sf,callback:function(n){e.$set(e.moreSearch,"sf",n)},expression:"moreSearch.sf"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"城市",prop:"cs"}},[t("common-select",{ref:"cs",attrs:{cascadingValue:e.moreSearch.sf,cascadingKey:"pid",url:e.select.cs.url},model:{value:e.moreSearch.cs,callback:function(n){e.$set(e.moreSearch,"cs",n)},expression:"moreSearch.cs"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"分配科室",prop:"fpks"}},[t("common-select",{ref:"fpks",attrs:{filterable:"",url:e.select.fpks.url},model:{value:e.moreSearch.fpks,callback:function(n){e.$set(e.moreSearch,"fpks",n)},expression:"moreSearch.fpks"}})],1)],1)],1),e._v(" "),t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"咨询编号",prop:"zxbh"}},[t("el-input",{attrs:{placeholder:""},model:{value:e.moreSearch.zxbh,callback:function(n){e.$set(e.moreSearch,"zxbh",n)},expression:"moreSearch.zxbh"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{ref:"zxlylx",attrs:{label:"企业名称",prop:"qymc"}},[t("el-input",{attrs:{placeholder:""},model:{value:e.moreSearch.qymc,callback:function(n){e.$set(e.moreSearch,"qymc",n)},expression:"moreSearch.qymc"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"客户名称",prop:"khmc"}},[t("el-input",{attrs:{placeholder:""},model:{value:e.moreSearch.khmc,callback:function(n){e.$set(e.moreSearch,"khmc",n)},expression:"moreSearch.khmc"}})],1)],1)],1),e._v(" "),t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"手机",prop:"sj"}},[t("el-input",{attrs:{placeholder:""},model:{value:e.moreSearch.sj,callback:function(n){e.$set(e.moreSearch,"sj",n)},expression:"moreSearch.sj"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"座机",prop:"zj"}},[t("el-input",{attrs:{placeholder:""},model:{value:e.moreSearch.zj,callback:function(n){e.$set(e.moreSearch,"zj",n)},expression:"moreSearch.zj"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"邮箱",prop:"email"}},[t("el-input",{attrs:{placeholder:""},model:{value:e.moreSearch.email,callback:function(n){e.$set(e.moreSearch,"email",n)},expression:"moreSearch.email"}})],1)],1)],1),e._v(" "),t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"QQ",prop:"qq"}},[t("el-input",{attrs:{placeholder:""},model:{value:e.moreSearch.qq,callback:function(n){e.$set(e.moreSearch,"qq",n)},expression:"moreSearch.qq"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"微信",prop:"wechat"}},[t("el-input",{attrs:{placeholder:""},model:{value:e.moreSearch.wechat,callback:function(n){e.$set(e.moreSearch,"wechat",n)},expression:"moreSearch.wechat"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"备注",prop:"remark"}},[t("el-input",{attrs:{placeholder:""},model:{value:e.moreSearch.remark,callback:function(n){e.$set(e.moreSearch,"remark",n)},expression:"moreSearch.remark"}})],1)],1)],1),e._v(" "),t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"样品名称",prop:"ypname"}},[t("el-input",{attrs:{placeholder:""},model:{value:e.moreSearch.ypname,callback:function(n){e.$set(e.moreSearch,"ypname",n)},expression:"moreSearch.ypname"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"检测项目",prop:"jcxm"}},[t("el-input",{attrs:{placeholder:""},model:{value:e.moreSearch.jcxm,callback:function(n){e.$set(e.moreSearch,"jcxm",n)},expression:"moreSearch.jcxm"}})],1)],1)],1),e._v(" "),t("el-row",[t("el-col",{staticStyle:{"text-align":"right"}},[t("common-button",{attrs:{svgIcon:"search",type:"primary"},on:{click:e.doSearch}},[e._v("查询")]),e._v(" "),t("common-button",{attrs:{svgIcon:"reset",type:"primary"},on:{click:e.resetSearch}},[e._v("重置")])],1)],1)],1)],1),e._v(" "),t("common-table",{ref:"table",attrs:{autoLoad:"","show-overflow-tooltip":"",url:e.table.consult.url,formOptions:e.table.consult.formOptions,columns:e.table.consult.columns,checkboxFun:e.checkboxFun,fit:""},on:{select:e.pushSelected},scopedSlots:e._u([{key:"topbutton",fn:function(n){return[t("common-button",{attrs:{svgIcon:"more",type:"primary",plain:""},on:{click:function(n){e.window.moreSearch=!0}}},[e._v("更多查询条件")])]}},{key:"buttons",fn:function(n){return[t("common-button",{attrs:{svgIcon:"commit",type:"primary",plain:""},on:{click:e.commitSelected}},[e._v("提交")])]}},{key:"zxzt",fn:function(n){return[t("span",{style:{color:"8"===n.row.zxzt?"red":""}},[e._v(e._s(n.row.zxztname))])]}},{key:"operate",fn:function(n){return[n.row.insid?t("common-button",{attrs:{type:"primary"},on:{click:function(t){e.showWatchFlow(n.row)}}},[e._v("查看咨询进程")]):e._e(),e._v(" "),""===n.row.istj||null===n.row.istj||"2"===n.row.zxzt?t("common-button",{attrs:{type:"primary"},on:{click:function(t){e.edit(n.row,"edit")}}},[e._v("编辑")]):t("common-button",{attrs:{type:"primary"},on:{click:function(t){e.edit(n.row,"watch")}}},[e._v("查看")])]}}])})],1)},staticRenderFns:[]};var c=t("VU/8")(a,s,!1,function(e){t("WhfA")},"data-v-c05ab724",null);n.default=c.exports}});