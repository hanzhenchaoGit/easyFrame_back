webpackJsonp([37],{fXhu:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=r("woOf"),i=r.n(o),n=r("vLgD"),a=r("vHhr"),s=r("HHBG"),l={components:{Sticky:a.a,commonSelect:s.a},data:function(){return{loading:{userFormLoading:!1,orgLoading:!1},window:!1,organization:{},addWindow:!1,departWindow:!1,isAdd:!0,inputwidth:"150px",rolesWindow:!1,editUserId:"",currentOrg:"",userRoles:[],operusers:[],userForm:{},dutys:[{name:"员工",value:"1"},{name:"部门管理",value:"2"},{name:"公司管理",value:"3"}],groups:[{name:"A组",value:"A"},{name:"B组",value:"B"},{name:"C组",value:"C"}],simpleFields:["name"],roles:[],url:"/user/getSysUserByOrgPager",columns:[{colType:"selection"},{prop:"userName",label:"用户名",width:130},{prop:"name",label:"姓名",width:100},{prop:"dutyName",label:"职务",width:120},{prop:"group",label:"业务组",width:100},{prop:"mobile",label:"手机",width:140},{prop:"userEnable",label:"是否可用"},{label:"操作",slotName:"edit",width:200}],checkNodes:[],data:[{id:0,label:"联盟创新检测服务平台",name:"root",children:[]}]}},mounted:function(){this.getRoles(),this.getData()},methods:{getData:function(){var e=this;this.loading.orgLoading=!0,Object(n.a)({url:"/system/getAllOrgs"}).then(function(t){e.data[0].children=t.data,e.loading.orgLoading=!1})},getRoles:function(){var e=this;Object(n.a)({url:"/user/getSysRoleList",method:"get"}).then(function(t){e.roles=t.data})},handleAdd:function(e,t){this.isAdd=!0,this.resetFormAndShow(this,e,t,"userForm")},handleDel:function(e){var t=this;Object(n.a)({url:"/user/delSysUser",method:"get",params:{id:e.id}}).then(function(e){t.roles=e.data})},saveOrg:function(){var e=this;this.$refs.organization.validate(function(t){var r=e.organization;if(!t)return!1;Object(n.a)({url:"/system/addSysOrganizational",method:"post",data:r}).then(function(t){e.returnMsg(e,t),e.getData()})})},saveuser:function(){var e=this;this.$refs.form.validate(function(t){var r=i()({},e.userForm);if(!t)return!1;e.loading.userFormLoading=!0,Object(n.a)({url:"/user/addSysUser",method:"post",data:r}).then(function(t){e.loading.userFormLoading=!1,e.returnMsg(e,t),e.$refs.table.fetchHandler()})})},handleEdit:function(e,t){var r=this;this.addWindow=!0,setTimeout(function(){r.$refs.form.resetFields(),r.userForm={},r.userForm=i()({},t),r.userForm.roleIds=r.userForm.roles.map(function(e){return e.id})},1)},handleEditUserRole:function(e){this.rolesWindow=!0,this.editUserId=e.id,console.log(this.editUserId,"userid"),this.userRoles=e.roles.map(function(e){return e.id})},saveUserRoles:function(e){var t=this;if(0!==this.userRoles.length){var r=[];this.userRoles.forEach(function(e){return r.push({userId:t.editUserId,roleId:e})}),Object(n.a)({url:"/user/addSysUserRoles",method:"post",data:r}).then(function(e){t.returnMsg(t,e),t.$refs.table.fetchHandler()})}},treeNodeClick:function(e,t,r){this.currentOrg=t.data.id,this.$refs.table.fetchHandler({organization:t.data.id})},del:function(e){var t=this;Object(n.a)({url:"/system/delSysOrganizational",params:{id:e.id}}).then(function(e){t.getData()})},handlerCheck:function(e,t){this.operusers=i()([],e)},disableUsers:function(){var e=this;0===this.operusers.length?this.$Message({message:"请先勾选要禁用的用户",type:"warning"}):Object(n.a)({url:"/user/operate/disable",params:{userids:this.operusers.map(function(e){return e.id}).toString()}}).then(function(t){e.returnMsg(e,t)})},resetPassword:function(){var e=this;0===this.operusers.length?this.$Message({message:"请先勾选要重置的用户",type:"warning"}):Object(n.a)({url:"/user/operate/resetpwd",params:{userids:this.operusers.map(function(e){return e.id}).toString()}}).then(function(t){e.returnMsg(e,t)})},edit:function(e,t){this.organization=i()({},t),this.setPid("edit",e,t),this.window=!0},setPid:function(e,t,r){0!==r.id&&"add"===e?this.organization.pid=r.id:0!==r.id&&"edit"===e?this.organization.pid=t.parent.data.id:0===r.id&&"add"===e&&(this.organization.pid=0)},add:function(e,t){var r=this;this.window=!0,setTimeout(function(){r.$refs.organization.resetFields(),r.organization={},r.setPid("add",e,t)},1)},addDepart:function(){var e=this;this.departWindow=!0,setTimeout(function(){e.$refs.departTree.setCheckedKeys(""!==e.userForm.organization?e.userForm.organization.split(",").map(Number):[])},1)},saveUserDepart:function(){var e=this.$refs.departTree.getCheckedNodes(),t=!1,r=[],o=[];e.length>0&&(e.forEach(function(e){0===e.children.length&&(t=!0,console.log(e,"depart"),r.push(e.id),o.push(e.label))}),this.userForm.organization=r.toString(),this.userForm.organizationNames=o.toString(),this.departWindow=!1),0!==e.length&&t||this.$Message({message:"请选择部门,并且请选择最后一级",type:"warning"})},renderContent:function(e,t){var r=this,o=t.node,i=t.data;t.store;return 0===i.id?e("span",{class:"custom-tree-node"},[e("span",null,[e("svg-icon",{attrs:{"icon-class":"folder"}},[]),e("span",null,[o.label])])]):e("span",{class:"custom-tree-node"},[e("span",null,[i.children.length>0?e("svg-icon",{attrs:{"icon-class":"folder"}},[]):e("svg-icon",{attrs:{"icon-class":"file"}},[]),e("span",null,[o.label]),this.$store.getters.roles.map(function(e){return e.roleKey}).indexOf("admin")>-1?e("span",null,[e("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(){return r.add(o,i)}}},["添加"]),e("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(){return r.del(i)}}},["删除"])]):""])])}}},d={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-dialog",{attrs:{visible:e.window,width:"36%","close-on-click-modal":"","close-on-press-escape":""},on:{"update:visible":function(t){e.window=t}}},[r("el-form",{ref:"organization",attrs:{inline:"",model:e.organization,"label-width":"120px","label-position":"left"}},[r("el-form-item",{attrs:{prop:"id",label:"id"}},[r("el-input",{attrs:{disabled:""},model:{value:e.organization.id,callback:function(t){e.$set(e.organization,"id",t)},expression:"organization.id"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"pid",label:"上级部门",required:""}},[r("el-input",{attrs:{disabled:""},model:{value:e.organization.pid,callback:function(t){e.$set(e.organization,"pid",t)},expression:"organization.pid"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"label",label:"部门名称",required:""}},[r("el-input",{model:{value:e.organization.label,callback:function(t){e.$set(e.organization,"label",t)},expression:"organization.label"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"note",label:"部门说明",required:""}},[r("el-input",{model:{value:e.organization.note,callback:function(t){e.$set(e.organization,"note",t)},expression:"organization.note"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"order",label:"顺序"}},[r("el-input",{model:{value:e.organization.order,callback:function(t){e.$set(e.organization,"order",t)},expression:"organization.order"}})],1),e._v(" "),r("el-form-item",[r("common-button",{attrs:{type:"primary"},on:{click:function(t){e.saveOrg()}}},[e._v("保存")]),e._v(" "),r("common-button",{on:{click:function(t){e.window=!1}}},[e._v("取消")])],1)],1)],1),e._v(" "),r("el-dialog",{attrs:{visible:e.addWindow,width:"45%","close-on-click-modal":"","close-on-press-escape":""},on:{"update:visible":function(t){e.addWindow=t}}},[r("el-form",{directives:[{name:"loading",rawName:"v-loading",value:e.loading.userFormLoading,expression:"loading.userFormLoading"}],ref:"form",attrs:{inline:"",model:e.userForm,"label-width":"90px","label-position":"right"}},[r("el-form-item",{attrs:{prop:"id",label:"id"}},[r("el-input",{style:{width:e.inputwidth},attrs:{disabled:""},model:{value:e.userForm.id,callback:function(t){e.$set(e.userForm,"id",t)},expression:"userForm.id"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"userName",label:"用户名",required:""}},[r("el-input",{style:{width:e.inputwidth},model:{value:e.userForm.userName,callback:function(t){e.$set(e.userForm,"userName",t)},expression:"userForm.userName"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"name",label:"姓名",required:""}},[r("el-input",{style:{width:e.inputwidth},model:{value:e.userForm.name,callback:function(t){e.$set(e.userForm,"name",t)},expression:"userForm.name"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"organizationNames",label:"部门",required:""}},[r("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:e.userForm.organizationNames,placement:"top-start"}},[r("el-input",{style:{width:e.inputwidth},model:{value:e.userForm.organizationNames,callback:function(t){e.$set(e.userForm,"organizationNames",t)},expression:"userForm.organizationNames"}})],1),e._v(" "),r("common-button",{attrs:{type:"primary"},on:{click:function(t){e.addDepart()}}},[e._v("选择部门")])],1),e._v(" "),r("el-form-item",{attrs:{prop:"duty",label:"职务",required:""}},[r("commonSelect",{style:{width:e.inputwidth},attrs:{data:e.dutys},model:{value:e.userForm.duty,callback:function(t){e.$set(e.userForm,"duty",t)},expression:"userForm.duty"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"group",label:"业务组"}},[r("commonSelect",{style:{width:e.inputwidth},attrs:{data:e.groups},model:{value:e.userForm.group,callback:function(t){e.$set(e.userForm,"group",t)},expression:"userForm.group"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"mobile",label:"手机"}},[r("el-input",{style:{width:e.inputwidth},model:{value:e.userForm.mobile,callback:function(t){e.$set(e.userForm,"mobile",t)},expression:"userForm.mobile"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"phone",label:"座机"}},[r("el-input",{style:{width:e.inputwidth},model:{value:e.userForm.phone,callback:function(t){e.$set(e.userForm,"phone",t)},expression:"userForm.phone"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"fax",label:"传真"}},[r("el-input",{style:{width:e.inputwidth},model:{value:e.userForm.fax,callback:function(t){e.$set(e.userForm,"fax",t)},expression:"userForm.fax"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"qq",label:"qq"}},[r("el-input",{style:{width:e.inputwidth},model:{value:e.userForm.qq,callback:function(t){e.$set(e.userForm,"qq",t)},expression:"userForm.qq"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"msn",label:"msn"}},[r("el-input",{style:{width:e.inputwidth},model:{value:e.userForm.msn,callback:function(t){e.$set(e.userForm,"msn",t)},expression:"userForm.msn"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"birthdate",label:"生日"}},[r("el-date-picker",{style:{width:e.inputwidth},attrs:{type:"date",placeholder:"选择日期"},model:{value:e.userForm.birthdate,callback:function(t){e.$set(e.userForm,"birthdate",t)},expression:"userForm.birthdate"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"userEnable",label:"是否可用",required:""}},[r("el-select",{style:{width:e.inputwidth},model:{value:e.userForm.userEnable,callback:function(t){e.$set(e.userForm,"userEnable",t)},expression:"userForm.userEnable"}},[r("el-option",{key:"Y",attrs:{label:"是",value:"1"}}),e._v(" "),r("el-option",{key:"N",attrs:{label:"否",value:"2"}})],1)],1),e._v(" "),r("el-form-item",[r("common-button",{attrs:{type:"primary"},on:{click:function(t){e.saveuser()}}},[e._v("保存")]),e._v(" "),r("common-button",{attrs:{type:"primary"},on:{click:function(t){e.addWindow=!1}}},[e._v("取消")])],1)],1)],1),e._v(" "),r("el-dialog",{attrs:{visible:e.departWindow,width:"45%","close-on-click-modal":"","close-on-press-escape":""},on:{"update:visible":function(t){e.departWindow=t}}},[r("el-card",{staticClass:"cardcontainer",staticStyle:{height:"45vh"},attrs:{shadow:"always"}},[r("el-tree",{ref:"departTree",staticStyle:{"font-size":"14px"},attrs:{data:e.data,"show-checkbox":"","node-key":"id","highlight-current":"","expand-on-click-node":!1}})],1),e._v(" "),r("div",{attrs:{slot:"footer"},slot:"footer"},[r("common-button",{attrs:{type:"primary"},on:{click:e.saveUserDepart}},[e._v("保存")]),e._v(" "),r("common-button",{on:{click:function(t){e.departWindow=!1}}},[e._v("取消")])],1)],1),e._v(" "),r("el-dialog",{attrs:{title:"用户角色",visible:e.rolesWindow,width:"66%","close-on-click-modal":"","close-on-press-escape":""},on:{"update:visible":function(t){e.rolesWindow=t}}},[r("el-checkbox-group",{model:{value:e.userRoles,callback:function(t){e.userRoles=t},expression:"userRoles"}},e._l(e.roles,function(t){return r("el-checkbox",{key:t.id,attrs:{label:t.id}},[e._v(e._s(t.roleName))])})),e._v(" "),r("div",{attrs:{slot:"footer"},slot:"footer"},[r("common-button",{attrs:{type:"primary"},on:{click:e.saveUserRoles}},[e._v("保存")]),e._v(" "),r("common-button",{on:{click:function(t){e.rolesWindow=!1}}},[e._v("取消")])],1)],1),e._v(" "),r("el-row",{attrs:{gutter:8}},[r("el-col",{attrs:{span:8}},[r("el-card",{directives:[{name:"loading",rawName:"v-loading",value:e.loading.orgLoading,expression:"loading.orgLoading"}],staticClass:"cardcontainer",attrs:{shadow:"always"}},[r("el-tree",{ref:"tree",staticStyle:{"font-size":"14px"},attrs:{data:e.data,"node-key":"id","highlight-currentight-current":"","expand-on-click-node":!1,"check-strictly":"","render-content":e.renderContent},on:{"node-click":e.treeNodeClick}})],1)],1),e._v(" "),r("el-col",{attrs:{span:16}},[r("common-table",{ref:"table",attrs:{height:"72vh",url:e.url,columns:e.columns,fit:""},on:{"select-all":e.handlerCheck,select:e.handlerCheck},scopedSlots:e._u([{key:"topbutton",fn:function(t){return[r("common-button",{directives:[{name:"has",rawName:"v-has"}],attrs:{type:"primary",permission:"add"},on:{click:function(t){e.handleAdd("form","addWindow")}}},[e._v("添加用户")]),e._v(" "),r("common-button",{directives:[{name:"has",rawName:"v-has"}],attrs:{type:"primary",permission:"disableuser"},on:{click:e.disableUsers}},[e._v("禁用用户")]),e._v(" "),r("common-button",{directives:[{name:"has",rawName:"v-has"}],attrs:{type:"primary",permission:"resetpwd"},on:{click:e.resetPassword}},[e._v("重置密码")])]}},{key:"edit",fn:function(t){return[r("common-button",{directives:[{name:"has",rawName:"v-has"}],attrs:{permission:"edit"},on:{click:function(r){e.handleEdit(t.$index,t.row)}}},[e._v("修改")]),e._v(" "),r("common-button",{directives:[{name:"has",rawName:"v-has"}],attrs:{slot:"reference",type:"danger",permission:"editrole"},on:{click:function(r){e.handleEditUserRole(t.row)}},slot:"reference"},[e._v("角色分配")])]}},{key:"roleName",fn:function(t){return e._l(t.row.roles,function(t){return r("el-tag",{key:t.id},[e._v(e._s(t.roleName))])})}}])})],1)],1)],1)},staticRenderFns:[]},u=r("VU/8")(l,d,!1,null,null,null);t.default=u.exports}});