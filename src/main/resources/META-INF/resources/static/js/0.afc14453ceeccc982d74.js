webpackJsonp([0],{MdDg:function(n,t,e){(n.exports=e("FZ+f")(!1)).push([n.i,"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n",""])},eNY0:function(n,t,e){var s=e("MdDg");"string"==typeof s&&(s=[[n.i,s,""]]),s.locals&&(n.exports=s.locals);e("rjj0")("4b12daa4",s,!0)},p3JC:function(n,t,e){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=e("fZjL"),l=e.n(s),i=e("woOf"),o=e.n(i),a={name:"ConsultManager",watch:{editConsult:function(n,t){this.fillEditConsultData(n)},operate:function(n,t){this.changeFormDisabled(n)},show:function(n,t){console.log(n,t)}},props:{editConsult:{type:Object,default:function(){return{}}},operate:{type:String,default:"edit"},from:{type:String,default:""}},mounted:function(){this.$set(this.entity.consult,"kfrymc",this.$store.getters.name),this.$set(this.entity.consult,"kfry",this.$store.getters.user),this.getXsTree(),this.$set(this.state,"commitDone",!1),this.fillEditConsultData(this.editConsult),this.changeFormDisabled(this.operate)},data:function(){return{disabledForm:!1,loading:{saveConsultLoading:!1,getConsultLoading:!1,checkRepeatLoading:!1},state:{commitDone:!1},rules:{zxly:[{required:!0,message:"请选择咨询来源",trigger:"blur"}],zxlylx:[{required:!0,message:"请选择咨询类型",trigger:"blur"}],khlx:[{required:!0,message:"请选择客户类型",trigger:"blur"}],sj:[{required:!0,message:"请输入手机号",trigger:"blur"}],sf:[{required:!0,message:"请选择省份",trigger:"blur"}],jcxm:[{required:!0,message:"请填入咨询内容",trigger:"blur"}],fpks:[{required:!0,message:"请选择分配科室",trigger:"blur"}],cfpd:[{required:!0,message:"请确认是否重复判定",trigger:"blur"}],qymcxl:[{required:!0,message:"请选择是否留企业名称",trigger:"blur"}],qymc:[{required:!0,message:"请录入企业名称",trigger:"blur"}]},file:{uploadUrl:this.baseUrl+"/file/upload",fileremark:"",groupid:"",list:[],limitTypes:"xls,xlsx,pdf,docx,txt,jpg,jpeg,png"},window:{uploadWindow:!1,selectXsWindow:!1},entity:{consult:{}},other:{repeatConsults:[]},tree:{xsTree:[]},table:{consult:{url:"/consult/checkRepeatConsult",columns:[{prop:"id",label:"id"},{prop:"zxbh",label:"咨询编号"},{prop:"createtime",label:"咨询时间",width:140},{prop:"zxlyname",label:"咨询来源"},{prop:"zxlylxname",label:"咨询类型"},{prop:"qymc",label:"企业名称"},{prop:"jcxm",label:"咨询内容"},{prop:"kfrymc",label:"客服人员"},{prop:"fpksmc",label:"分配科室",width:200},{prop:"xsrymc",label:"销售人员"},{prop:"status",label:"咨询状态"}]}},select:{zxly:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=sources"},zxlylx:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=sourcesType"},khlx:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=khlx"},qymcxl:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=qymc"},sf:{url:"system/proxyExcute?uuid=1faf1d01-88ed-4e8e-8975-7eaa2c179135&level=1"},cs:{url:"system/proxyExcute?uuid=1faf1d01-88ed-4e8e-8975-7eaa2c179135&level=2"},cfpd:{url:"system/proxyExcute?uuid=5a20cceb-ce98-4377-b6c1-958c1a1c0ff3&type=isnot"},fpks:{url:"system/proxyExcute?uuid=343d1975-5604-4041-9c07-4431b6742658"},xsry:{url:"consult/getXsCombo",nameKey:"name",valueKey:"username",fields:["name","orgname"],filterable:!0}}}},methods:{changeFormDisabled:function(n){"watch"===n?this.$set(this,"disabledForm",!0):this.$set(this,"disabledForm",!1)},fillEditConsultData:function(n){this.$set(this.state,"commitDone",!1),n.id&&("1"===n.assigntype?n.assigntype=!0:n.assigntype=!1,this.$set(this.entity,"consult",n),this.$set(this.file,"groupid",n.fj),this.$set(this.file,"list",[]),this.getFileList(n.fj))},getCs:function(n,t){this.$set(this.entity.consult,"cs",""),this.$refs.cs.loadData("pid="+t)},deleteFile:function(n,t){var e=this;this.$request({url:"/file/deleteFileById",params:{id:n.fileid}}).then(function(n){return e.returnMsg(e,n),!0})},checkCs:function(){this.entity.consult.sf||(this.$set(this.entity.consult,"cs",""),this.$message({type:"warning",message:"请先选择省份"}))},saveConsult:function(n){var t=this;this.other.repeatConsults&&0!==this.other.repeatConsults.length||this.$set(this.entity.consult,"cfpd","1"),this.$refs.consult.validate(function(e){if(!e)return console.log("error submit!!"),!1;t.loading.saveConsultLoading=!0,t.entity.consult.fpksmc=t.$refs.fpks.selectData.name;var s=o()({},t.entity.consult);t.entity.consult.fj=t.file.groupid,t.entity.consult.assigntype?(s.assigntype="1",t.entity.consult.xsrymc=t.$refs.xscombo.selectData.name):s.assigntype="2","save"===n?t.$request({url:"consult/addXmxxZxxx",method:"post",data:s}).then(function(n){t.returnMsg(t,n),t.$set(t.entity.consult,"zxbh",n.data.zxbh),t.entity.consult.id=n.data.id,t.loading.saveConsultLoading=!1,t.closeTab()}):t.$request({url:"consult/commitXmxxZxxxSingle",method:"post",data:s}).then(function(n){t.returnMsg(t,n),t.$set(t.state,"commitDone",!0),t.loading.saveConsultLoading=!1,t.closeTab()})})},setXsName:function(n,t,e){this.$set(this.entity.consult,"xsrymc",e.name)},getTagView:function(){return this.$root.$children[0].$children[0].$refs.tagsView},closeTab:function(){"window"!==this.from&&this.$nextTick(function(){this.getTagView().closeSelectedTag(this.$route);this.$store.dispatch("addVisitedViews",{path:"/consult/ConsultList",name:"ConsultList",meta:{title:"咨询列表"}}),this.$router.push("/consult/ConsultList")}),this.$store.dispatch("setShowEditWindow",!1)},getZxbh:function(n,t,e){},checkRepeat:function(n){var t=this;this.checkRepeatLoading=!0;var e=this.entity.consult;"sj"===n&&this.entity.consult.sj&&this.$request({url:"/system/proxyExcute?uuid=e1c70974-4f8f-4cbf-a69d-2ef9846f5d53",params:{phonenum:this.entity.consult.sj}}).then(function(n){n.data&&1===n.data.length&&(t.$set(t.entity.consult,"sf",n.data[0].sf),t.$set(t.entity.consult,"cs",n.data[0].cs))});var s={};e.sj&&"/"!==e.sj&&(s.sj=e.sj),e.zj&&""!==e.zj&&(s.zj=e.zj),e.email&&""!==e.email&&(s.email=e.email),e.qq&&""!==e.qq&&(s.qq=e.qq),l()(s).length>0&&this.$request({url:"/consult/checkRepeatConsult",method:"get",params:s}).then(function(n){0===n.data.length?t.$set(t.entity.consult,"cfpd","1"):t.$set(t.entity.consult,"cfpd","0"),t.other.repeatConsults=n.data,t.checkRepeatLoading=!1}),e.zj||e.email||e.wechat||e.qq||(this.other.repeatConsults=[],this.checkRepeatLoading=!1)},fillConsult:function(n){this.fillEditConsultData(o()({},n)),delete this.entity.consult.id,delete this.entity.consult.entid,this.$set(this.entity.consult,"zxlylx",""),this.$set(this.entity.consult,"zxbh",""),this.$set(this.entity.consult,"kfrymc",this.$store.getters.name),this.$set(this.entity.consult,"kfry",this.$store.getters.user),n?this.$set(this.entity.consult,"cfpd","0"):this.$set(this.entity.consult,"cfpd","1")},getFileList:function(n){var t=this;n&&this.$request({url:"file/getFileList",params:{groupid:n}}).then(function(n){var e=n.data.map(function(n){return{name:"【"+n.fileremark+"】"+n.filename,url:n.fileurl,fileid:n.id}});t.$set(t.file,"list",e),t.$nextTick(function(){for(var n=t.$refs.upload.$el.children[2].children,e=0;e<n.length;e++)n[e].innerHTML=n[e].innerHTML.replace('<a class="el-upload-list__item-name">','<a class="el-upload-list__item-name" href="'+t.file.list[e].url+'" download="'+t.file.list[e].name+'">')})})},xsCheckBoxChange:function(n){n||(this.$set(this.entity.consult,"xsry",""),this.$set(this.entity.consult,"xsrymc",""))},getXsTree:function(){var n=this;this.$request({url:"/consult/getXsTree",method:"get"}).then(function(t){n.tree.xsTree=t.data})},setXsRy:function(){var n=this.$refs.xsTree.getCurrentNode();n.isxs?(this.$set(this.entity.consult,"xsrymc",n.label),this.$set(this.entity.consult,"xsry",n.id),this.window.selectXsWindow=!1):this.$message({type:"error",message:"请选择销售人员"})},selectFile:function(){this.$refs.selectFile.$el.click()},beforeUpload:function(n){var t=this,e=!1,s=n.name.substring(n.name.lastIndexOf(".")+1);return this.$refs.uploadForm.validate(function(l){e=l;var i=t.file.limitTypes.indexOf(s)>-1,o=n.size/1024/1024<50;i||t.$message({message:"上传文件只能是 "+t.file.limitTypes+"格式!",type:"warning"}),o||t.$message({message:"上传文件大小不能超过 5MB!",type:"warning"}),e=i&&o}),!!e},onSuccess:function(n,t,e){this.file.groupid=n.data.groupid,this.entity.consult.fj=n.data.groupid}}},c={render:function(){var n=this,t=n.$createElement,e=n._self._c||t;return e("div",[e("el-dialog",{attrs:{title:"选择销售人员","modal-append-to-body":!1,visible:n.window.selectXsWindow,width:"40%","close-on-click-modal":"","close-on-press-escape":""},on:{"update:visible":function(t){n.$set(n.window,"selectXsWindow",t)}}},[e("el-card",{staticClass:"cardcontainer",staticStyle:{height:"45vh"},attrs:{shadow:"always"}},[e("el-tree",{ref:"xsTree",staticStyle:{"font-size":"14px"},attrs:{data:n.tree.xsTree,"node-key":"id","highlight-current":"","expand-on-click-node":!1,"check-strictly":""}})],1),n._v(" "),e("div",{staticStyle:{"text-align":"right"}},[e("common-button",{on:{click:function(t){n.setXsRy()}}},[n._v("确定")]),n._v(" "),e("common-button",[n._v("取消")])],1)],1),n._v(" "),e("el-card",{directives:[{name:"loading",rawName:"v-loading",value:n.loading.getConsultLoading,expression:"loading.getConsultLoading"}],attrs:{shadow:"always"}},[e("div",{staticClass:"clearfix",staticStyle:{"text-align":"left"},attrs:{slot:"header"},slot:"header"},["edit"===n.operate?e("common-button",{attrs:{type:"primary",disabled:n.state.commitDone||"edit"!==n.operate,svgIcon:"save"},on:{click:function(t){n.saveConsult("save")}}},[n._v("保存")]):n._e(),n._v(" "),"edit"===n.operate?e("common-button",{attrs:{type:"primary",disabled:n.state.commitDone||"edit"!==n.operate,svgIcon:"commit"},on:{click:function(t){n.saveConsult("commit")}}},[n._v("提交")]):n._e()],1),n._v(" "),e("el-form",{ref:"consult",attrs:{model:n.entity.consult,rules:n.rules,"label-width":"90px",disabled:n.disabledForm}},[e("el-row",[e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"咨询来源",prop:"zxly",required:""}},[e("common-select",{ref:"zxlyname",attrs:{url:n.select.zxly.url,filterable:"",required:""},on:{change:n.getZxbh},model:{value:n.entity.consult.zxly,callback:function(t){n.$set(n.entity.consult,"zxly",t)},expression:"entity.consult.zxly"}})],1)],1),n._v(" "),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"咨询类型",prop:"zxlylx",required:""}},[e("common-select",{ref:"zxlylxname",attrs:{url:n.select.zxlylx.url,filterable:"",required:""},model:{value:n.entity.consult.zxlylx,callback:function(t){n.$set(n.entity.consult,"zxlylx",t)},expression:"entity.consult.zxlylx"}})],1)],1),n._v(" "),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"咨询编号"}},[e("el-input",{attrs:{disabled:""},model:{value:n.entity.consult.zxbh,callback:function(t){n.$set(n.entity.consult,"zxbh",t)},expression:"entity.consult.zxbh"}})],1)],1)],1),n._v(" "),e("el-row",[e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"客户类型",prop:"khlx",required:""}},[e("common-select",{attrs:{url:n.select.khlx.url,required:""},model:{value:n.entity.consult.khlx,callback:function(t){n.$set(n.entity.consult,"khlx",t)},expression:"entity.consult.khlx"}})],1)],1),n._v(" "),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"企业名称",required:""}},[e("el-form-item",{attrs:{prop:"qymc"}},[e("el-input",{model:{value:n.entity.consult.qymc,callback:function(t){n.$set(n.entity.consult,"qymc",t)},expression:"entity.consult.qymc"}})],1)],1)],1),n._v(" "),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"客户名称"}},[e("el-input",{model:{value:n.entity.consult.khxm,callback:function(t){n.$set(n.entity.consult,"khxm",t)},expression:"entity.consult.khxm"}})],1)],1)],1),n._v(" "),e("el-row",[e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"手机",prop:"sj",required:""}},[e("el-input",{on:{blur:function(t){n.checkRepeat("sj")}},model:{value:n.entity.consult.sj,callback:function(t){n.$set(n.entity.consult,"sj",t)},expression:"entity.consult.sj"}})],1)],1),n._v(" "),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"座机",prop:"zj"}},[e("el-input",{on:{blur:function(t){n.checkRepeat()}},model:{value:n.entity.consult.zj,callback:function(t){n.$set(n.entity.consult,"zj",t)},expression:"entity.consult.zj"}})],1)],1),n._v(" "),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"邮箱"}},[e("el-input",{on:{blur:function(t){n.checkRepeat()}},model:{value:n.entity.consult.email,callback:function(t){n.$set(n.entity.consult,"email",t)},expression:"entity.consult.email"}})],1)],1)],1),n._v(" "),e("el-row",[e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"微信"}},[e("el-input",{on:{blur:function(t){n.checkRepeat()}},model:{value:n.entity.consult.wechat,callback:function(t){n.$set(n.entity.consult,"wechat",t)},expression:"entity.consult.wechat"}})],1)],1),n._v(" "),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"QQ"}},[e("el-input",{on:{blur:function(t){n.checkRepeat()}},model:{value:n.entity.consult.qq,callback:function(t){n.$set(n.entity.consult,"qq",t)},expression:"entity.consult.qq"}})],1)],1),n._v(" "),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"客服人员"}},[e("el-input",{attrs:{disabled:""},model:{value:n.entity.consult.kfrymc,callback:function(t){n.$set(n.entity.consult,"kfrymc",t)},expression:"entity.consult.kfrymc"}})],1)],1)],1),n._v(" "),e("el-row",[e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"所在省份",prop:"sf",required:""}},[e("common-select",{attrs:{url:n.select.sf.url,required:""},on:{change:n.getCs},model:{value:n.entity.consult.sf,callback:function(t){n.$set(n.entity.consult,"sf",t)},expression:"entity.consult.sf"}})],1)],1),n._v(" "),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"城市"}},[e("common-select",{ref:"cs",attrs:{cascadingValue:n.entity.consult.sf,cascadingKey:"pid",url:n.select.cs.url,required:""},on:{change:n.checkCs},model:{value:n.entity.consult.cs,callback:function(t){n.$set(n.entity.consult,"cs",t)},expression:"entity.consult.cs"}})],1)],1),n._v(" "),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"重复判定",prop:"cfpd",required:""}},[e("common-select",{attrs:{url:n.select.cfpd.url,required:""},model:{value:n.entity.consult.cfpd,callback:function(t){n.$set(n.entity.consult,"cfpd",t)},expression:"entity.consult.cfpd"}})],1)],1)],1),n._v(" "),e("el-row",[e("el-col",{attrs:{span:24}},[e("el-form-item",{attrs:{label:"咨询内容",prop:"jcxm",required:""}},[e("el-input",{attrs:{type:"textarea",placeholder:""},model:{value:n.entity.consult.jcxm,callback:function(t){n.$set(n.entity.consult,"jcxm",t)},expression:"entity.consult.jcxm"}})],1)],1)],1),n._v(" "),e("el-row",[e("el-col",{attrs:{span:24}},[e("el-form-item",{attrs:{label:"备注"}},[e("el-input",{attrs:{type:"textarea",placeholder:""},model:{value:n.entity.consult.remarks,callback:function(t){n.$set(n.entity.consult,"remarks",t)},expression:"entity.consult.remarks"}})],1)],1)],1),n._v(" "),e("el-row",[e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"分配科室",prop:"fpks",required:""}},[e("common-select",{ref:"fpks",attrs:{filterable:"",url:n.select.fpks.url,required:""},model:{value:n.entity.consult.fpks,callback:function(t){n.$set(n.entity.consult,"fpks",t)},expression:"entity.consult.fpks"}})],1)],1),n._v(" "),e("el-col",{attrs:{span:8}},[e("el-form-item")],1),n._v(" "),e("el-col",{attrs:{span:8}},[e("el-form-item",{attrs:{label:"分配销售"}},[e("el-row",{attrs:{gutter:10}},[e("el-col",{attrs:{span:3}},[e("el-checkbox",{on:{change:n.xsCheckBoxChange},model:{value:n.entity.consult.assigntype,callback:function(t){n.$set(n.entity.consult,"assigntype",t)},expression:"entity.consult.assigntype"}})],1),n._v(" "),e("el-col",{attrs:{span:14}},[e("common-select",{ref:"xscombo",attrs:{disabled:!n.entity.consult.assigntype,url:n.select.xsry.url,nameKey:n.select.xsry.nameKey,valueKey:n.select.xsry.valueKey,fields:n.select.xsry.fields,filterable:n.select.xsry.filterable,placeholder:""},on:{change:n.setXsName},model:{value:n.entity.consult.xsry,callback:function(t){n.$set(n.entity.consult,"xsry",t)},expression:"entity.consult.xsry"}})],1)],1)],1)],1)],1),n._v(" "),e("el-row",[e("el-col",{attrs:{span:24}},[e("el-form-item",{attrs:{label:"上传附件"}},[e("el-dialog",{attrs:{title:"上传附件","modal-append-to-body":!1,visible:n.window.uploadWindow,width:"40%","close-on-click-modal":"","close-on-press-escape":""},on:{"update:visible":function(t){n.$set(n.window,"uploadWindow",t)}}},[e("el-form",{ref:"uploadForm",attrs:{model:n.file}},[e("el-form-item",{attrs:{prop:"fileremark",label:"文件描述",required:""}},[e("el-input",{attrs:{placeholder:"请输入文件描述"},model:{value:n.file.fileremark,callback:function(t){n.$set(n.file,"fileremark",t)},expression:"file.fileremark"}})],1),n._v(" "),e("common-button",{on:{click:function(t){n.selectFile()}}},[e("svg-icon",{attrs:{"icon-class":"upload"}}),n._v("选择附件")],1),n._v("\n                选择后自动上传\n              ")],1)],1),n._v(" "),e("el-upload",{ref:"upload",attrs:{action:n.file.uploadUrl,"on-remove":n.deleteFile,data:n.file,"with-credentials":"","before-upload":n.beforeUpload,"on-success":n.onSuccess,"file-list":n.file.list,disabled:n.state.commitDone||"edit"!==n.operate}},[e("common-button",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],ref:"selectFile"},[e("svg-icon",{attrs:{"icon-class":"upload"}})],1),n._v(" "),e("common-button",{on:{click:[function(n){n.stopPropagation()},function(t){n.window.uploadWindow=!0}]}},[e("svg-icon",{attrs:{"icon-class":"upload"}}),n._v("上传附件")],1),n._v(" "),e("div",{staticClass:"el-upload__tip",staticStyle:{color:"red"},attrs:{slot:"tip"},slot:"tip"},[n._v("文件格式限制"+n._s(n.file.limitTypes)+",文件大小不能超过5M")])],1)],1)],1)],1)],1),n._v(" "),"edit"===n.operate?e("el-table",{directives:[{name:"loading",rawName:"v-loading",value:n.loading.checkRepeatLoading,expression:"loading.checkRepeatLoading"}],attrs:{border:"",data:n.other.repeatConsults,height:"32vh"}},[e("el-table-column",{attrs:{label:"操作"},scopedSlots:n._u([{key:"default",fn:function(t){return[e("common-button",{staticStyle:{color:"blue"},on:{click:function(e){n.fillConsult(t.row)}}},[n._v("回填咨询")])]}}])}),n._v(" "),e("el-table-column",{attrs:{label:"咨询编号",prop:"zxbh",align:"center"}}),n._v(" "),e("el-table-column",{attrs:{label:"咨询时间",prop:"createtime",align:"center"}}),n._v(" "),e("el-table-column",{attrs:{label:"咨询来源",prop:"zxlyname",align:"center"}}),n._v(" "),e("el-table-column",{attrs:{label:"咨询类型",prop:"zxlylxname",align:"center"}}),n._v(" "),e("el-table-column",{attrs:{label:"企业名称",prop:"qymc",align:"center"}}),n._v(" "),e("el-table-column",{attrs:{label:"咨询内容",prop:"jcxm",align:"center"}}),n._v(" "),e("el-table-column",{attrs:{label:"客服人员",prop:"kfrymc",align:"center"}}),n._v(" "),e("el-table-column",{attrs:{label:"分配科室",prop:"fpksmc",align:"center"}}),n._v(" "),e("el-table-column",{attrs:{label:"销售人员",prop:"xsrymc",align:"center"}}),n._v(" "),e("el-table-column",{attrs:{label:"咨询状态",prop:"zxztname",align:"center"}})],1):n._e()],1)],1)},staticRenderFns:[]};var r=e("VU/8")(a,c,!1,function(n){e("eNY0")},"data-v-6cd908ab",null);t.default=r.exports},vHhr:function(n,t,e){"use strict";var s={name:"Sticky",props:{stickyTop:{type:Number,default:0},zIndex:{type:Number,default:1},className:{type:String}},data:function(){return{active:!1,position:"",currentTop:"",width:void 0,height:void 0,child:null,stickyHeight:0}},mounted:function(){this.height=this.$el.getBoundingClientRect().height,window.addEventListener("scroll",this.handleScroll)},activated:function(){this.handleScroll()},destroyed:function(){window.removeEventListener("scroll",this.handleScroll)},methods:{sticky:function(){this.active||(this.position="fixed",this.active=!0,this.width=this.width+"px")},reset:function(){this.active&&(this.position="",this.width="auto",this.active=!1)},handleScroll:function(){this.width=this.$el.getBoundingClientRect().width,this.$el.getBoundingClientRect().top<=this.stickyTop?this.sticky():this.reset()}}},l={render:function(){var n=this,t=n.$createElement,e=n._self._c||t;return e("div",{style:{height:n.height+"px",zIndex:n.zIndex}},[e("div",{class:n.className,style:{top:n.stickyTop+"px",zIndex:n.zIndex,position:n.position,width:n.width,height:n.height+"px"}},[n._t("default",[e("div",[n._v("sticky")])])],2)])},staticRenderFns:[]},i=e("VU/8")(s,l,!1,null,null,null);t.a=i.exports}});