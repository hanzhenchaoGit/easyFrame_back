webpackJsonp([0],{AtZs:function(n,e,t){(n.exports=t("FZ+f")(!1)).push([n.i,"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n",""])},p3JC:function(n,e,t){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s=t("woOf"),l=t.n(s),i={name:"ConsultManager",watch:{editConsult:function(n,e){this.fillEditConsultData(n)},operate:function(n,e){this.changeFormDisabled(n)},show:function(n,e){console.log(n,e)}},props:{editConsult:{type:Object,default:function(){return{}}},operate:{type:String,default:"edit"},from:{type:String,default:""}},mounted:function(){this.$set(this.entity.consult,"kfrymc",this.$store.getters.name),this.$set(this.entity.consult,"kfry",this.$store.getters.user),this.getXsTree(),this.$set(this.state,"commitDone",!1),this.fillEditConsultData(this.editConsult),this.changeFormDisabled(this.operate)},data:function(){return{disabledForm:!1,loading:{saveConsultLoading:!1,getConsultLoading:!1,checkRepeatLoading:!1},state:{commitDone:!1},rules:{zxly:[{required:!0,message:"请选择咨询来源",trigger:"blur"}],zxlylx:[{required:!0,message:"请选择咨询类型",trigger:"blur"}],khlx:[{required:!0,message:"请选择客户类型",trigger:"blur"}],sj:[{required:!0,message:"请输入手机号",trigger:"blur"}],sf:[{required:!0,message:"请选择省份",trigger:"blur"}],jcxm:[{required:!0,message:"请填入咨询内容",trigger:"blur"}],fpks:[{required:!0,message:"请选择分配科室",trigger:"blur"}],cfpd:[{required:!0,message:"请确认是否重复判定",trigger:"blur"}],qymcxl:[{required:!0,message:"请选择是否留企业名称",trigger:"blur"}],qymc:[{required:!0,message:"请录入企业名称",trigger:"blur"}]},file:{uploadUrl:"http://10.19.1.138:9999/file/upload",fileremark:"",groupid:"",list:[],limitTypes:"xls,xlsx,pdf,docx,txt,jpg,jpeg,png"},window:{uploadWindow:!1,selectXsWindow:!1},entity:{consult:{}},other:{repeatConsults:[]},tree:{xsTree:[]},table:{consult:{url:"/consult/checkRepeatConsult",columns:[{prop:"id",label:"id"},{prop:"zxbh",label:"咨询编号"},{prop:"createtime",label:"咨询时间",width:140},{prop:"zxlyname",label:"咨询来源"},{prop:"zxlylxname",label:"咨询类型"},{prop:"qymc",label:"企业名称"},{prop:"jcxm",label:"咨询内容"},{prop:"kfrymc",label:"客服人员"},{prop:"fpksmc",label:"分配科室",width:200},{prop:"xsrymc",label:"销售人员"},{prop:"status",label:"咨询状态"}]}},select:{zxly:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=sources"},zxlylx:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=sourcesType"},khlx:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=khlx"},qymcxl:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=qymc"},sf:{url:"system/proxyExcute?uuid=1faf1d01-88ed-4e8e-8975-7eaa2c179135&level=1"},cs:{url:"system/proxyExcute?uuid=1faf1d01-88ed-4e8e-8975-7eaa2c179135&level=2"},cfpd:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=isnot"},fpks:{url:"system/proxyExcute?uuid=343d1975-5604-4041-9c07-4431b6742658"},xsry:{url:"consult/getXsCombo",nameKey:"name",valueKey:"username",fields:["name","orgname"],filterable:!0}}}},methods:{changeFormDisabled:function(n){"watch"===n?this.$set(this,"disabledForm",!0):this.$set(this,"disabledForm",!1)},fillEditConsultData:function(n){this.$set(this.state,"commitDone",!1),n.id&&("1"===n.assigntype?n.assigntype=!0:n.assigntype=!1,this.$set(this.entity,"consult",n),this.$set(this.file,"groupid",n.fj),this.$set(this.file,"list",[]),this.getFileList(n.fj))},getCs:function(n,e){this.$set(this.entity.consult,"cs",""),this.$refs.cs.loadData("pid="+e)},deleteFile:function(n,e){var t=this;this.$request({url:"/file/deleteFileById",params:{id:n.fileid}}).then(function(n){return t.returnMsg(t,n),!0})},checkCs:function(){this.entity.consult.sf||(this.$set(this.entity.consult,"cs",""),this.$message({type:"warning",message:"请先选择省份"}))},saveConsult:function(n){var e=this;this.other.repeatConsults&&0!==this.other.repeatConsults.length||this.$set(this.entity.consult,"cfpd","1"),this.$refs.consult.validate(function(t){if(!t)return console.log("error submit!!"),!1;e.loading.saveConsultLoading=!0,e.entity.consult.fpksmc=e.$refs.fpks.selectData.name;var s=l()({},e.entity.consult);e.entity.consult.fj=e.file.groupid,e.entity.consult.assigntype?(s.assigntype="1",e.entity.consult.xsrymc=e.$refs.xscombo.selectData.name):s.assigntype="2","save"===n?e.$request({url:"consult/addXmxxZxxx",method:"post",data:s}).then(function(n){e.returnMsg(e,n),e.$set(e.entity.consult,"zxbh",n.data.zxbh),e.entity.consult.id=n.data.id,e.loading.saveConsultLoading=!1,e.closeTab()}):e.$request({url:"consult/commitXmxxZxxxSingle",method:"post",data:s}).then(function(n){e.returnMsg(e,n),e.$set(e.state,"commitDone",!0),e.loading.saveConsultLoading=!1,e.closeTab()})})},setXsName:function(n,e,t){this.$set(this.entity.consult,"xsrymc",t.name)},getTagView:function(){return this.$root.$children[0].$children[0].$refs.tagsView},closeTab:function(){"window"!==this.from&&this.$nextTick(function(){this.getTagView().closeSelectedTag(this.$route);this.$store.dispatch("addVisitedViews",{path:"/consult/ConsultList",name:"ConsultList",meta:{title:"咨询列表"}}),this.$router.push("/consult/ConsultList")}),this.$store.dispatch("setShowEditWindow",!1)},getZxbh:function(n,e,t){},checkRepeat:function(n){var e=this;this.checkRepeatLoading=!0;var t=this.entity.consult;"sj"===n&&this.entity.consult.sj&&this.$request({url:"/system/proxyExcute?uuid=e1c70974-4f8f-4cbf-a69d-2ef9846f5d53",params:{phonenum:this.entity.consult.sj}}).then(function(n){n.data&&1===n.data.length&&(e.$set(e.entity.consult,"sf",n.data[0].sf),e.$set(e.entity.consult,"cs",n.data[0].cs))}),t.sj&&"/"!==t.sj||t.zj||t.email||t.wechat?this.$request({url:"/consult/checkRepeatConsult",method:"get",params:{sj:t.sj,zj:t.zj,email:t.email,wechat:t.wechat}}).then(function(n){0===n.data.length?e.$set(e.entity.consult,"cfpd","1"):e.$set(e.entity.consult,"cfpd","0"),e.other.repeatConsults=n.data,e.checkRepeatLoading=!1}):t.zj||t.email||t.wechat||(this.other.repeatConsults=[],this.checkRepeatLoading=!1)},fillConsult:function(n){this.fillEditConsultData(l()({},n)),delete this.entity.consult.id,delete this.entity.consult.entid,this.$set(this.entity.consult,"zxlylx",""),this.$set(this.entity.consult,"zxbh",""),n?this.$set(this.entity.consult,"cfpd","0"):this.$set(this.entity.consult,"cfpd","1")},getFileList:function(n){var e=this;n&&this.$request({url:"file/getFileList",params:{groupid:n}}).then(function(n){var t=n.data.map(function(n){return{name:"【"+n.fileremark+"】"+n.filename,url:n.fileurl,fileid:n.id}});e.$set(e.file,"list",t),e.$nextTick(function(){for(var n=e.$refs.upload.$el.children[2].children,t=0;t<n.length;t++)n[t].innerHTML=n[t].innerHTML.replace('<a class="el-upload-list__item-name">','<a class="el-upload-list__item-name" href="'+e.file.list[t].url+'" download="'+e.file.list[t].name+'">')})})},xsCheckBoxChange:function(n){n||(this.$set(this.entity.consult,"xsry",""),this.$set(this.entity.consult,"xsrymc",""))},getXsTree:function(){var n=this;this.$request({url:"/consult/getXsTree",method:"get"}).then(function(e){n.tree.xsTree=e.data})},setXsRy:function(){var n=this.$refs.xsTree.getCurrentNode();n.isxs?(this.$set(this.entity.consult,"xsrymc",n.label),this.$set(this.entity.consult,"xsry",n.id),this.window.selectXsWindow=!1):this.$message({type:"error",message:"请选择销售人员"})},selectFile:function(){this.$refs.selectFile.$el.click()},beforeUpload:function(n){var e=this,t=!1,s=n.name.substring(n.name.lastIndexOf(".")+1);return this.$refs.uploadForm.validate(function(l){t=l;var i=e.file.limitTypes.indexOf(s)>-1,o=n.size/1024/1024<50;i||e.$message({message:"上传文件只能是 "+e.file.limitTypes+"格式!",type:"warning"}),o||e.$message({message:"上传文件大小不能超过 5MB!",type:"warning"}),t=i&&o}),!!t},onSuccess:function(n,e,t){this.file.groupid=n.data.groupid,this.entity.consult.fj=n.data.groupid}}},o={render:function(){var n=this,e=n.$createElement,t=n._self._c||e;return t("div",[t("el-dialog",{attrs:{title:"选择销售人员","modal-append-to-body":!1,visible:n.window.selectXsWindow,width:"40%","close-on-click-modal":"","close-on-press-escape":""},on:{"update:visible":function(e){n.$set(n.window,"selectXsWindow",e)}}},[t("el-card",{staticClass:"cardcontainer",staticStyle:{height:"45vh"},attrs:{shadow:"always"}},[t("el-tree",{ref:"xsTree",staticStyle:{"font-size":"14px"},attrs:{data:n.tree.xsTree,"node-key":"id","highlight-current":"","expand-on-click-node":!1,"check-strictly":""}})],1),n._v(" "),t("div",{staticStyle:{"text-align":"right"}},[t("common-button",{on:{click:function(e){n.setXsRy()}}},[n._v("确定")]),n._v(" "),t("common-button",[n._v("取消")])],1)],1),n._v(" "),t("el-card",{directives:[{name:"loading",rawName:"v-loading",value:n.loading.getConsultLoading,expression:"loading.getConsultLoading"}],attrs:{shadow:"always"}},[t("div",{staticClass:"clearfix",staticStyle:{"text-align":"left"},attrs:{slot:"header"},slot:"header"},["edit"===n.operate?t("common-button",{attrs:{type:"primary",disabled:n.state.commitDone||"edit"!==n.operate,svgIcon:"save"},on:{click:function(e){n.saveConsult("save")}}},[n._v("保存")]):n._e(),n._v(" "),"edit"===n.operate?t("common-button",{attrs:{type:"primary",disabled:n.state.commitDone||"edit"!==n.operate,svgIcon:"commit"},on:{click:function(e){n.saveConsult("commit")}}},[n._v("提交")]):n._e()],1),n._v(" "),t("el-form",{ref:"consult",attrs:{model:n.entity.consult,rules:n.rules,"label-width":"90px",disabled:n.disabledForm}},[t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"咨询来源",prop:"zxly",required:""}},[t("common-select",{ref:"zxlyname",attrs:{url:n.select.zxly.url,filterable:"",required:""},on:{change:n.getZxbh},model:{value:n.entity.consult.zxly,callback:function(e){n.$set(n.entity.consult,"zxly",e)},expression:"entity.consult.zxly"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"咨询类型",prop:"zxlylx",required:""}},[t("common-select",{ref:"zxlylxname",attrs:{url:n.select.zxlylx.url,filterable:"",required:""},model:{value:n.entity.consult.zxlylx,callback:function(e){n.$set(n.entity.consult,"zxlylx",e)},expression:"entity.consult.zxlylx"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"咨询编号"}},[t("el-input",{attrs:{disabled:""},model:{value:n.entity.consult.zxbh,callback:function(e){n.$set(n.entity.consult,"zxbh",e)},expression:"entity.consult.zxbh"}})],1)],1)],1),n._v(" "),t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"客户类型",prop:"khlx",required:""}},[t("common-select",{attrs:{url:n.select.khlx.url,required:""},model:{value:n.entity.consult.khlx,callback:function(e){n.$set(n.entity.consult,"khlx",e)},expression:"entity.consult.khlx"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"企业名称",required:""}},[t("el-form-item",{attrs:{prop:"qymc"}},[t("el-input",{model:{value:n.entity.consult.qymc,callback:function(e){n.$set(n.entity.consult,"qymc",e)},expression:"entity.consult.qymc"}})],1)],1)],1),n._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"客户名称"}},[t("el-input",{model:{value:n.entity.consult.khxm,callback:function(e){n.$set(n.entity.consult,"khxm",e)},expression:"entity.consult.khxm"}})],1)],1)],1),n._v(" "),t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"手机",prop:"sj",required:""}},[t("el-input",{on:{blur:function(e){n.checkRepeat("sj")}},model:{value:n.entity.consult.sj,callback:function(e){n.$set(n.entity.consult,"sj",e)},expression:"entity.consult.sj"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"座机",prop:"zj"}},[t("el-input",{on:{blur:function(e){n.checkRepeat()}},model:{value:n.entity.consult.zj,callback:function(e){n.$set(n.entity.consult,"zj",e)},expression:"entity.consult.zj"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"邮箱"}},[t("el-input",{on:{blur:function(e){n.checkRepeat()}},model:{value:n.entity.consult.email,callback:function(e){n.$set(n.entity.consult,"email",e)},expression:"entity.consult.email"}})],1)],1)],1),n._v(" "),t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"微信"}},[t("el-input",{on:{blur:function(e){n.checkRepeat()}},model:{value:n.entity.consult.wechat,callback:function(e){n.$set(n.entity.consult,"wechat",e)},expression:"entity.consult.wechat"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"QQ"}},[t("el-input",{on:{blur:function(e){n.checkRepeat()}},model:{value:n.entity.consult.qq,callback:function(e){n.$set(n.entity.consult,"qq",e)},expression:"entity.consult.qq"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"客服人员"}},[t("el-input",{attrs:{disabled:""},model:{value:n.entity.consult.kfrymc,callback:function(e){n.$set(n.entity.consult,"kfrymc",e)},expression:"entity.consult.kfrymc"}})],1)],1)],1),n._v(" "),t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"所在省份",prop:"sf",required:""}},[t("common-select",{attrs:{url:n.select.sf.url,required:""},on:{change:n.getCs},model:{value:n.entity.consult.sf,callback:function(e){n.$set(n.entity.consult,"sf",e)},expression:"entity.consult.sf"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"城市"}},[t("common-select",{ref:"cs",attrs:{cascadingValue:n.entity.consult.sf,cascadingKey:"pid",url:n.select.cs.url,required:""},on:{change:n.checkCs},model:{value:n.entity.consult.cs,callback:function(e){n.$set(n.entity.consult,"cs",e)},expression:"entity.consult.cs"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"重复判定",prop:"cfpd",required:""}},[t("common-select",{attrs:{url:n.select.cfpd.url,required:""},model:{value:n.entity.consult.cfpd,callback:function(e){n.$set(n.entity.consult,"cfpd",e)},expression:"entity.consult.cfpd"}})],1)],1)],1),n._v(" "),t("el-row",[t("el-col",{attrs:{span:24}},[t("el-form-item",{attrs:{label:"咨询内容",prop:"jcxm",required:""}},[t("el-input",{attrs:{type:"textarea",placeholder:""},model:{value:n.entity.consult.jcxm,callback:function(e){n.$set(n.entity.consult,"jcxm",e)},expression:"entity.consult.jcxm"}})],1)],1)],1),n._v(" "),t("el-row",[t("el-col",{attrs:{span:24}},[t("el-form-item",{attrs:{label:"备注"}},[t("el-input",{attrs:{type:"textarea",placeholder:""},model:{value:n.entity.consult.remarks,callback:function(e){n.$set(n.entity.consult,"remarks",e)},expression:"entity.consult.remarks"}})],1)],1)],1),n._v(" "),t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"分配科室",prop:"fpks",required:""}},[t("common-select",{ref:"fpks",attrs:{filterable:"",url:n.select.fpks.url,required:""},model:{value:n.entity.consult.fpks,callback:function(e){n.$set(n.entity.consult,"fpks",e)},expression:"entity.consult.fpks"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item")],1),n._v(" "),t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{label:"分配销售"}},[t("el-row",{attrs:{gutter:10}},[t("el-col",{attrs:{span:3}},[t("el-checkbox",{on:{change:n.xsCheckBoxChange},model:{value:n.entity.consult.assigntype,callback:function(e){n.$set(n.entity.consult,"assigntype",e)},expression:"entity.consult.assigntype"}})],1),n._v(" "),t("el-col",{attrs:{span:14}},[t("common-select",{ref:"xscombo",attrs:{disabled:!n.entity.consult.assigntype,url:n.select.xsry.url,nameKey:n.select.xsry.nameKey,valueKey:n.select.xsry.valueKey,fields:n.select.xsry.fields,filterable:n.select.xsry.filterable,placeholder:""},on:{change:n.setXsName},model:{value:n.entity.consult.xsry,callback:function(e){n.$set(n.entity.consult,"xsry",e)},expression:"entity.consult.xsry"}})],1)],1)],1)],1)],1),n._v(" "),t("el-row",[t("el-col",{attrs:{span:24}},[t("el-form-item",{attrs:{label:"上传附件"}},[t("el-dialog",{attrs:{title:"上传附件","modal-append-to-body":!1,visible:n.window.uploadWindow,width:"40%","close-on-click-modal":"","close-on-press-escape":""},on:{"update:visible":function(e){n.$set(n.window,"uploadWindow",e)}}},[t("el-form",{ref:"uploadForm",attrs:{model:n.file}},[t("el-form-item",{attrs:{prop:"fileremark",label:"文件描述",required:""}},[t("el-input",{attrs:{placeholder:"请输入文件描述"},model:{value:n.file.fileremark,callback:function(e){n.$set(n.file,"fileremark",e)},expression:"file.fileremark"}})],1),n._v(" "),t("common-button",{on:{click:function(e){n.selectFile()}}},[t("svg-icon",{attrs:{"icon-class":"upload"}}),n._v("选择附件")],1),n._v("\n                选择后自动上传\n              ")],1)],1),n._v(" "),t("el-upload",{ref:"upload",attrs:{action:n.file.uploadUrl,"on-remove":n.deleteFile,data:n.file,"with-credentials":"","before-upload":n.beforeUpload,"on-success":n.onSuccess,"file-list":n.file.list,disabled:n.state.commitDone||"edit"!==n.operate}},[t("common-button",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],ref:"selectFile"},[t("svg-icon",{attrs:{"icon-class":"upload"}})],1),n._v(" "),t("common-button",{on:{click:[function(n){n.stopPropagation()},function(e){n.window.uploadWindow=!0}]}},[t("svg-icon",{attrs:{"icon-class":"upload"}}),n._v("上传附件")],1),n._v(" "),t("div",{staticClass:"el-upload__tip",staticStyle:{color:"red"},attrs:{slot:"tip"},slot:"tip"},[n._v("文件格式限制"+n._s(n.file.limitTypes)+",文件大小不能超过5M")])],1)],1)],1)],1)],1),n._v(" "),"edit"===n.operate?t("el-table",{directives:[{name:"loading",rawName:"v-loading",value:n.loading.checkRepeatLoading,expression:"loading.checkRepeatLoading"}],attrs:{border:"",data:n.other.repeatConsults,height:"32vh"}},[t("el-table-column",{attrs:{label:"操作"},scopedSlots:n._u([{key:"default",fn:function(e){return[t("common-button",{staticStyle:{color:"blue"},on:{click:function(t){n.fillConsult(e.row)}}},[n._v("回填咨询")])]}}])}),n._v(" "),t("el-table-column",{attrs:{label:"咨询编号",prop:"zxbh",align:"center"}}),n._v(" "),t("el-table-column",{attrs:{label:"咨询时间",prop:"createtime",align:"center"}}),n._v(" "),t("el-table-column",{attrs:{label:"咨询来源",prop:"zxlyname",align:"center"}}),n._v(" "),t("el-table-column",{attrs:{label:"咨询类型",prop:"zxlylxname",align:"center"}}),n._v(" "),t("el-table-column",{attrs:{label:"企业名称",prop:"qymc",align:"center"}}),n._v(" "),t("el-table-column",{attrs:{label:"咨询内容",prop:"jcxm",align:"center"}}),n._v(" "),t("el-table-column",{attrs:{label:"客服人员",prop:"kfrymc",align:"center"}}),n._v(" "),t("el-table-column",{attrs:{label:"分配科室",prop:"fpksmc",align:"center"}}),n._v(" "),t("el-table-column",{attrs:{label:"销售人员",prop:"xsrymc",align:"center"}}),n._v(" "),t("el-table-column",{attrs:{label:"咨询状态",prop:"zxztname",align:"center"}})],1):n._e()],1)],1)},staticRenderFns:[]};var a=t("VU/8")(i,o,!1,function(n){t("wIb4")},"data-v-017818d4",null);e.default=a.exports},wIb4:function(n,e,t){var s=t("AtZs");"string"==typeof s&&(s=[[n.i,s,""]]),s.locals&&(n.exports=s.locals);t("rjj0")("4ba2d45c",s,!0)}});