webpackJsonp([42],{"Q+ZN":function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l=o("woOf"),r=o.n(l),s=o("vLgD"),a=o("zL8q"),i={computed:{sqlFieldCount:function(){if(this.exoport.sqlField instanceof Array)return this.exoport.sqlField.length}},data:function(){return{select:{istemOptions:[{value:"Y",name:"无"},{value:"C",name:"代码"},{value:"E",name:"excel模板"}],templatesUrl:"file/templates"},upload:{url:"http://10.19.1.138:9999/file/upload",template:[]},addWindow:!1,isAdd:!0,exoport:{},url:"/system/getSysExportConfigByPager",formOptions:{inline:!0,showSearchBtn:!0,showResetBtn:!0,submitBtnText:"查询",resetBtnText:"重置",forms:[{prop:"sheet_name",label:"导出名"}]},columns:[{prop:"id",label:"id",width:50},{prop:"uuid",label:"导出配置唯一标识",width:270},{prop:"urlPath",label:"导出请求路径",width:200,showOverflowTooltip:!0},{prop:"requestType",label:"请求类型"},{prop:"sheetName",label:"导出文件名",width:150,showOverflowTooltip:!0},{prop:"istem",label:"是否使用模板"},{prop:"template",label:"模板名称",width:150,showOverflowTooltip:!0},{prop:"sqlField",label:"数据字段名",showOverflowTooltip:!0},{prop:"colNames",label:"excel表头",showOverflowTooltip:!0},{label:"操作",slotName:"edit",width:200}]}},methods:{handleAdd:function(e,t){this.isAdd=!0,void 0!==this.$refs[e]&&this.$refs[e].resetFields(),this[t]=!0},save:function(){var e=this;this.$refs.form.validate(function(t){var o=r()({},e.exoport);if("N"===e.exoport.istem?(o.sqlField=o.sqlField.toString(),o.colNames=o.colNames.toString()):(o.sqlField="",o.colNames=""),!t)return!1;Object(s.a)({url:"/system/addSysExportConfig",method:"post",data:o}).then(function(t){t.success?Object(a.Message)({message:"保存成功",type:"info",duration:5e3}):Object(a.Message)({message:"保存失败:"+t.msg,type:"error",duration:5e3}),e.exoport.uuid=t.data,e.$refs.table.fetchHandler()})})},handleEdit:function(e,t){this.exoport=r()({},t),this.exoport.sqlField=this.exoport.sqlField.split(","),this.exoport.colNames=this.exoport.colNames.split(","),this.addWindow=!0},hanleDel:function(e){var t=this;Object(s.a)({url:"/system/delSysExportConfig",params:{id:e.id}}).then(function(e){Object(a.Message)({message:"删除成功",type:"info",duration:5e3}),t.$refs.table.fetchHandler()})}}},p={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",[o("el-card",[o("el-dialog",{attrs:{visible:e.addWindow,width:"56%","close-on-click-modal":"","close-on-press-escape":""},on:{"update:visible":function(t){e.addWindow=t}}},[o("el-form",{ref:"form",attrs:{inline:"",model:e.exoport,"label-width":"120px","label-position":"left"}},[o("el-row",[o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{prop:"uuid",label:"唯一标识"}},[o("el-input",{staticStyle:{width:"100%"},attrs:{disabled:""},model:{value:e.exoport.uuid,callback:function(t){e.$set(e.exoport,"uuid",t)},expression:"exoport.uuid"}})],1)],1)],1),e._v(" "),o("el-form-item",{attrs:{prop:"urlPath",label:"请求url",required:""}},[o("el-input",{staticStyle:{width:"470px"},model:{value:e.exoport.urlPath,callback:function(t){e.$set(e.exoport,"urlPath",t)},expression:"exoport.urlPath"}})],1),e._v(" "),o("el-form-item",{attrs:{prop:"requestType",label:"请求类型",required:""}},[o("el-tooltip",{attrs:{placement:"top"}},[o("div",{attrs:{slot:"content"},slot:"content"},[e._v("\n              代理请求:在[开发模块代理请求维护中添加的请求] 如:http://localhost:9999/system/proxyExcute?uuid=069a2a90-de27-40b9-9fed-17027eae7531 "),o("br"),e._v("\n              普通请求:正常代码开发模式controller-service-dao的形式 如:http://localhost:9999/system/getSysExportConfigByPager"),o("br")]),e._v(" "),o("el-select",{model:{value:e.exoport.requestType,callback:function(t){e.$set(e.exoport,"requestType",t)},expression:"exoport.requestType"}},[o("el-option",{key:"pt",attrs:{label:"普通请求",value:"pt"}}),e._v(" "),o("el-option",{key:"pr",attrs:{label:"代理请求",value:"pr"}})],1)],1)],1),e._v(" "),o("el-form-item",{attrs:{prop:"istem",label:"导出方式",required:""}},[o("common-select",{attrs:{data:e.select.istemOptions},model:{value:e.exoport.istem,callback:function(t){e.$set(e.exoport,"istem",t)},expression:"exoport.istem"}})],1),e._v(" "),"E"===e.exoport.istem?o("el-form-item",{attrs:{prop:"template",label:"上传模板"}},[o("el-upload",{staticClass:"upload-demo",staticStyle:{width:"470px"},attrs:{action:e.upload.url,limit:1,"with-credentials":"","file-list":e.upload.template}},[o("common-button",{attrs:{size:"small",type:"primary"}},[e._v("选择模板上传")]),e._v(" "),o("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[e._v("只能上传excel文件(.xlsx)，且不超过500kb")])],1)],1):e._e(),e._v(" "),"E"===e.exoport.istem?o("el-form-item",{attrs:{prop:"template",label:"模板文件",required:""}},[o("common-select",{attrs:{url:e.select.templatesUrl},model:{value:e.exoport.template,callback:function(t){e.$set(e.exoport,"template",t)},expression:"exoport.template"}})],1):e._e(),e._v(" "),"E"===e.exoport.istem?o("el-form-item",{attrs:{label:"起始行",prop:"startrow",required:""}},[o("el-input-number",{model:{value:e.exoport.startrow,callback:function(t){e.$set(e.exoport,"startrow",t)},expression:"exoport.startrow"}})],1):e._e(),e._v(" "),o("el-form-item",{attrs:{prop:"sheetName",label:"文件名",required:""}},[o("el-input",{model:{value:e.exoport.sheetName,callback:function(t){e.$set(e.exoport,"sheetName",t)},expression:"exoport.sheetName"}})],1),e._v(" "),"N"===e.exoport.istem?o("el-form-item",{attrs:{prop:"sqlField",label:"数据字段",required:""}},[o("el-select",{attrs:{multiple:"",filterable:"","allow-create":"","default-first-option":""},model:{value:e.exoport.sqlField,callback:function(t){e.$set(e.exoport,"sqlField",t)},expression:"exoport.sqlField"}})],1):e._e(),e._v(" "),"N"===e.exoport.istem?o("el-form-item",{attrs:{prop:"colNames",label:"导出表头",required:""}},[o("el-select",{attrs:{multiple:"",filterable:"","allow-create":"","default-first-option":""},model:{value:e.exoport.colNames,callback:function(t){e.$set(e.exoport,"colNames",t)},expression:"exoport.colNames"}})],1):e._e(),e._v(" "),o("el-form-item",[o("span",{staticStyle:{color:"red"}},[e._v("*")]),e._v(" "),o("span",{staticStyle:{"font-size":"10px",color:"black","font-weight":"500"}},[e._v('添加完成后 如果是普通请求 需要在请求的controller上添加@Export("069a2a90-de27-40b9-9fed-17027eae7531")导出配置才能生效;另外导出暂时只支持get请求')])]),e._v(" "),o("el-form-item",[o("common-button",{attrs:{type:"primary"},on:{click:function(t){e.save()}}},[e._v("保存")]),e._v(" "),o("common-button",{attrs:{type:"primary"},on:{click:function(t){e.addWindow=!1}}},[e._v("取消")])],1)],1)],1),e._v(" "),o("common-table",{ref:"table",attrs:{url:e.url,height:"58vh",columns:e.columns,fit:"",autoLoad:"",formOptions:e.formOptions},scopedSlots:e._u([{key:"edit",fn:function(t){return[o("common-button",{on:{click:function(o){e.handleEdit(t.$index,t.row)}}},[e._v("编辑")]),e._v(" "),o("common-button",{attrs:{type:"danger"},on:{click:function(o){e.hanleDel(t.row)}}},[e._v("删除")])]}},{key:"topbutton",fn:function(t){return[o("common-button",{attrs:{type:"primary"},on:{click:[function(t){e.handleAdd("form","addWindow")},function(e){e.stopPropagation()}]}},[e._v("新增")])]}}])})],1)],1)},staticRenderFns:[]},n=o("VU/8")(i,p,!1,null,null,null);t.default=n.exports}});