webpackJsonp([46],{kAHd:function(e,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l=s("7+uW"),n=s("vHhr"),o=s("HHBG"),a={components:{Sticky:n.a,commonSelect:o.a},name:"PostKD",mounted:function(){console.log(this.$store.getters.phone,this.$store.getters.phone),l.default.set(this.entity.consult,"postperson",this.$store.getters.name),l.default.set(this.entity.consult,"contactphone",this.$store.getters.phone)},data:function(){return{radio:"1",isShow:!1,isShowKDPageLabel:!1,isShowKDPage:!1,KDPage:"",filterable:!0,form:[],xldata:{kdtype:[{name:"文件类",value:"文件类"},{name:"样品类",value:"样品类"},{name:"其他类",value:"其他类"}],foldernotype:[{name:"委托单号",value:"委托单号"},{name:"咨询编号(未下单)",value:"咨询编号(未下单)"},{name:"非客户相关的快递",value:"非客户相关的快递"}],posttype:[{name:"顺丰特惠",value:"顺丰特惠"},{name:"顺丰标快",value:"顺丰标快"},{name:"顺丰次晨",value:"顺丰次晨"},{name:"顺丰即日",value:"顺丰即日"}]},select:{postcompname:{url:"system/proxyExcute?uuid=1296816f-00b6-4103-8122-9eda1bc3d084"},receiveprovince:{url:"system/proxyExcute?uuid=1faf1d01-88ed-4e8e-8975-7eaa2c179135&level=1"},receivecity:{url:"system/proxyExcute?uuid=1faf1d01-88ed-4e8e-8975-7eaa2c179135&level=2"},postaddress:{url:"system/proxyExcute?uuid=284219ff-ce8f-45c3-81a4-7b8de1a754fa"},kdAdmin:{url:"system/proxyExcute?uuid=1c7cdd05-1ab5-403b-addd-aab8f2456d00"},default:{url:"system/proxyExcute?uuid=1c7cdd05-1ab5-403b-addd-aab8f2456d00"}},rules:{postcompname:[{required:!0,message:"请选择寄件公司名称"},{trigger:"blur"}],postaddress:[{required:!0,message:"请选择寄件地址"},{trigger:"blur"}],receiveprovince:[{required:!0,message:"请选择收件省份"},{trigger:"blur"}],folderno:[{required:!0,message:"请输入单号"},{trigger:"blur"}],foldernotype:[{required:!0,message:"请选择单号类型"},{trigger:"blur"}],kdadminid:[{required:!0,message:"请选择快递管理员"},{trigger:"blur"}],posttype:[{required:!0,message:"请选择邮寄方式"},{trigger:"blur"}],receivecity:[{required:!0,message:"请选择收件省份"},{trigger:"blur"}],paytype:[{required:!0,message:"请选择付款方式"},{trigger:"blur"}],kddetail:[{required:!0,message:"请输入快递详情"},{min:1,max:200,message:"长度在 1 到 200 个字符",trigger:"blur"}],receivecompname:[{required:!0,message:"请输入收件公司名称"},{min:1,max:50,message:"长度在 1 到 50 个字符",trigger:"blur"}],receiveperson:[{required:!0,message:"请输入收件人名称"},{min:1,max:50,message:"长度在 1 到 50 个字符",trigger:"blur"}],receivephone:[{required:!0,message:"请输入收件人电话"},{min:1,max:20,message:"长度在 1 到 20 个字符",trigger:"blur"}],receiveaddress:[{required:!0,message:"请输入详细地址"},{min:1,max:200,message:"长度在 1 到 200 个字符",trigger:"blur"}]},entity:{consult:{},consult1:{}}}},methods:{save:function(){var e=this;this.$refs.form.validate(function(t){if(console.log(t),t){var s=e.entity.consult;e.$request({url:"/KDInfo/addKdinfo",method:"post",data:s}).then(function(t){e.returnMsg(e,t),setTimeout(function(){e.$refs.form.resetFields(),e.entity.consult={},e.$set(e.entity.consult,"postperson",e.$store.getters.name)},1),e.$router.push("MyKD")})}})},getCs:function(e,t){l.default.set(this.entity.consult,"receivecity",""),this.$refs.receivecity.loadData("pid="+t)},checkCs:function(){this.entity.consult.receiveprovince||(l.default.set(this.entity.consult,"receivecity",""),this.$message({type:"warning",message:"请先选择省份"}))},choseAddress:function(e,t){console.log(e),console.log(t),l.default.set(this.entity.consult,"postaddress",""),this.$refs.postaddress.loadData("pid="+t)},choseKDType:function(e){this.selVal=e,console.log(e),this.$set(this,"isShowKDPage",!0),this.$set(this,"KDPage",10),this.$set(this.entity.consult,"postage",10),"1"===e&&console.log("成功")},findLastInfo:function(){var e=this,t=this.entity.consult.folderno;this.$request({url:"/KDInfo/findLastInfo",method:"get",params:{folderno:t}}).then(function(t){t.data?(e.$set(e,"isShow",!0),l.default.set(e.entity,"consult1",t.data),l.default.set(e.entity.consult,"kdadminid",t.data),console.log(t.data)):e.$set(e,"isShow",!1)})},changeMonth:function(){this.$set(this,"isShowKDPage",!0),this.$set(this,"isShowKDPageLabel",!0),this.$set(this,"KDPage",10),this.$set(this.entity.consult,"postage",10)},changeArrive:function(){this.$set(this,"isShowKDPage",!1),this.$set(this,"isShowKDPageLabel",!1)}}},i={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{attrs:{id:"app"}},[s("el-card",[s("label",[e._v("寄件信息")])]),e._v(" "),s("el-form",{ref:"form",attrs:{model:e.entity.consult,"label-width":"80px",rules:e.rules}},[s("el-card",[s("el-row",[s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"postcompname",label:"寄件公司","label-width":"100px",required:""}},[s("common-select",{attrs:{filterable:e.filterable,url:e.select.postcompname.url},on:{change:e.choseAddress},model:{value:e.entity.consult.postcompname,callback:function(t){e.$set(e.entity.consult,"postcompname",t)},expression:"entity.consult.postcompname"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{label:"联系人","label-width":"100px"}},[s("el-input",{attrs:{disabled:""},model:{value:e.entity.consult.postperson,callback:function(t){e.$set(e.entity.consult,"postperson",t)},expression:"entity.consult.postperson"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"postaddress",label:"邮寄地址","label-width":"100px",required:""}},[s("common-select",{ref:"postaddress",attrs:{cascadingValue:e.entity.consult.postcompname,cascadingKey:"pid",url:e.select.postaddress.url},model:{value:e.entity.consult.postaddress,callback:function(t){e.$set(e.entity.consult,"postaddress",t)},expression:"entity.consult.postaddress"}})],1)],1)],1),e._v(" "),s("el-row",[s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{label:"联系电话","label-width":"100px"}},[s("el-input",{attrs:{disabled:""},model:{value:e.entity.consult.contactphone,callback:function(t){e.$set(e.entity.consult,"contactphone",t)},expression:"entity.consult.contactphone"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{label:"托寄物类型","label-width":"100px"}},[s("commonSelect",{attrs:{data:e.xldata.kdtype},model:{value:e.entity.consult.kdtype,callback:function(t){e.$set(e.entity.consult,"kdtype",t)},expression:"entity.consult.kdtype"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"kddetail",label:"托寄物详情","label-width":"100px"}},[s("el-input",{model:{value:e.entity.consult.kddetail,callback:function(t){e.$set(e.entity.consult,"kddetail",t)},expression:"entity.consult.kddetail"}})],1)],1)],1),e._v(" "),s("el-row",[s("el-col",{attrs:{span:4}},[s("el-form-item",{attrs:{prop:"foldernotype"}},[s("commonSelect",{staticStyle:{left:"20px"},attrs:{data:e.xldata.foldernotype},model:{value:e.entity.consult.foldernotype,callback:function(t){e.$set(e.entity.consult,"foldernotype",t)},expression:"entity.consult.foldernotype"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"folderno"}},[s("el-input",{attrs:{placeholder:"如果未产生委托单号的客户，请选择客户编号"},on:{blur:function(t){e.findLastInfo()}},model:{value:e.entity.consult.folderno,callback:function(t){e.$set(e.entity.consult,"folderno",t)},expression:"entity.consult.folderno"}})],1)],1)],1)],1),e._v(" "),e.isShow?s("el-card",[s("span",[e._v("上次邮寄信息:收件人 : "+e._s(e.entity.consult1.receiveperson)+",托寄物详情  : "+e._s(e.entity.consult1.kddetail)+",邮寄时间 : "+e._s(e.entity.consult1.postdate)+",\n                邮寄人 : "+e._s(e.entity.consult1.postperson)+",收件地址 : "+e._s(e.entity.consult1.receiveaddress))])]):e._e(),e._v(" "),s("el-card",[s("label",[e._v("收件信息")])]),e._v(" "),s("el-card",[s("el-row",[s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"receivecompname",label:"公司名称","label-width":"100px"}},[s("el-input",{model:{value:e.entity.consult.receivecompname,callback:function(t){e.$set(e.entity.consult,"receivecompname",t)},expression:"entity.consult.receivecompname"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"receiveperson",label:"联系人","label-width":"100px"}},[s("el-input",{model:{value:e.entity.consult.receiveperson,callback:function(t){e.$set(e.entity.consult,"receiveperson",t)},expression:"entity.consult.receiveperson"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"receivephone",label:"联系电话","label-width":"100px"}},[s("el-input",{model:{value:e.entity.consult.receivephone,callback:function(t){e.$set(e.entity.consult,"receivephone",t)},expression:"entity.consult.receivephone"}})],1)],1)],1),e._v(" "),s("el-row",[s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"receiveprovince",label:"收货地址(省)","label-width":"120px"}},[s("common-select",{attrs:{url:e.select.receiveprovince.url},on:{change:e.getCs},model:{value:e.entity.consult.receiveprovince,callback:function(t){e.$set(e.entity.consult,"receiveprovince",t)},expression:"entity.consult.receiveprovince"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"receivecity",label:"收货地址(市)","label-width":"120px"}},[s("common-select",{ref:"receivecity",attrs:{cascadingValue:e.entity.consult.receiveprovince,cascadingKey:"pid",url:e.select.receivecity.url},on:{change:e.checkCs},model:{value:e.entity.consult.receivecity,callback:function(t){e.$set(e.entity.consult,"receivecity",t)},expression:"entity.consult.receivecity"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"receiveaddress",label:"详细地址","label-width":"100px",required:""}},[s("el-input",{model:{value:e.entity.consult.receiveaddress,callback:function(t){e.$set(e.entity.consult,"receiveaddress",t)},expression:"entity.consult.receiveaddress"}})],1)],1)],1),e._v(" "),s("el-row",[s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"paytype",label:"付款方式","label-width":"100px"}},[s("el-radio",{attrs:{label:"月结"},on:{change:function(t){e.changeMonth()}},model:{value:e.entity.consult.paytype,callback:function(t){e.$set(e.entity.consult,"paytype",t)},expression:"entity.consult.paytype"}},[e._v("月结")]),e._v(" "),s("el-radio",{attrs:{label:"到付"},on:{change:function(t){e.changeArrive()}},model:{value:e.entity.consult.paytype,callback:function(t){e.$set(e.entity.consult,"paytype",t)},expression:"entity.consult.paytype"}},[e._v("到付")])],1)],1),e._v(" "),s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"posttype",label:"邮寄方式","label-width":"100px"}},[s("commonSelect",{attrs:{data:e.xldata.posttype},model:{value:e.entity.consult.posttype,callback:function(t){e.$set(e.entity.consult,"posttype",t)},expression:"entity.consult.posttype"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:8}},[e.isShowKDPageLabel?s("el-form-item",{attrs:{label:"快递费","label-width":"100px"}},[e.isShowKDPage?s("span",[e._v(e._s(e.KDPage))]):e._e(),e._v(" "),e.isShowKDPage?s("el-input",{attrs:{type:"hidden"},model:{value:e.entity.consult.postage,callback:function(t){e.$set(e.entity.consult,"postage",t)},expression:"entity.consult.postage"}}):e._e()],1):e._e()],1)],1),e._v(" "),s("el-row",[s("el-col",{attrs:{span:8}},[s("el-form-item",{attrs:{prop:"kdadminid",label:"选择快递管理员","label-width":"120px",required:""}},[s("common-select",{attrs:{filterable:e.filterable,url:e.select.kdAdmin.url},model:{value:e.entity.consult.kdadminid,callback:function(t){e.$set(e.entity.consult,"kdadminid",t)},expression:"entity.consult.kdadminid"}})],1)],1)],1)],1),e._v(" "),s("el-card",[s("el-form-item",[s("common-button",{attrs:{type:"primary"},on:{click:function(t){e.save()}}},[e._v("保存")]),e._v(" "),s("common-button",{attrs:{type:"primary"},on:{click:function(t){e.addWindow=!1}}},[e._v("取消")])],1)],1)],1)],1)},staticRenderFns:[]},r=s("VU/8")(a,i,!1,null,null,null);t.default=r.exports}});