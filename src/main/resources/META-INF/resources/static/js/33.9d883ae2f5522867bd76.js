webpackJsonp([33],{I2B9:function(e,s,n){(e.exports=n("FZ+f")(!1)).push([e.i,"\n.custom-tree-node {\n  -webkit-box-flex: 1;\n      -ms-flex: 1;\n          flex: 1;\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n  -webkit-box-pack: justify;\n      -ms-flex-pack: justify;\n          justify-content: space-between;\n  font-size: 14px;\n  padding-right: 8px;\n}\n",""])},UCOU:function(e,s,n){var i=n("I2B9");"string"==typeof i&&(i=[[e.i,i,""]]),i.locals&&(e.exports=i.locals);n("rjj0")("56976d48",i,!0)},hoEz:function(e,s,n){"use strict";Object.defineProperty(s,"__esModule",{value:!0});var i=n("woOf"),t=n.n(i),o=n("vLgD"),r={data:function(){return{permissions:[],window:!1,permissionWindow:!1,permission:{id:null,pkey:"",pname:""},rolepermissions:{},permissionsvaluekey:"pkey",permissionsnameKey:"pname",permissionsfield:["pname"],showPermissions:!1,menu:{id:null,pid:"",name:"",label:"",icon:"",path:"",component:"",permissions:[]},roles:[],role:"",roleMenuId:null,checkNodes:[],data:[{id:0,label:"根路由",name:"root",children:[]}]}},mounted:function(){this.getData(),this.getRoles(),this.getPermissions()},methods:{test:function(e,s,n){console.log(e,s,n,"----------")},getPermissions:function(){var e=this;Object(o.a)({url:"/user/getSysPermissionList"}).then(function(s){e.permissions=s.data})},getRoles:function(){var e=this;Object(o.a)({url:"/user/getSysRoleList"}).then(function(s){e.roles=s.data})},changeRole:function(e){var s=this,n=this.getCurrentRole(e);this.$refs.tree.setCheckedKeys(this.getCurrentRole(e).menuids.split(","));var i=this.$refs.tree.getCheckedNodes(),t=n.permissions;this.rolepermissions={},i.forEach(function(e){0===e.children.length&&(s.$set(s.rolepermissions,e.path,[]),""!==t&&t.split("::").forEach(function(n){e.path===n.split(":")[0]&&(s.rolepermissions[e.path]=n.split(":")[1].split(","))}))})},getData:function(){var e=this;Object(o.a)({url:"/system/getSysMenusList"}).then(function(s){e.data[0].children=s.data})},add:function(e,s){this.$refs.menu&&this.$refs.menu.resetFields(),this.setPermissionShow(e),this.setPid("add",e,s),this.window=!0},setPermissionShow:function(e){e.isLeaf?this.showPermissions=!0:this.showPermissions=!1},showAddPermission:function(e,s,n){this.showWindow(this,e,s,n)},savePermission:function(){var e=this;this.$refs.permission.validate(function(s){if(s){var n=t()({},e.permission);Object(o.a)({url:"/user/addSysPermission",method:"post",data:n}).then(function(s){e.returnMsg(e,s),e.getPermissions()})}})},getCurrentRole:function(e){return this.roles.find(function(s){if(s.id===e)return s})},saveRoleMenu:function(){var e=this;if(""===this.role)this.$Message({message:"请先选择需要修改权限的角色",type:"error",duration:5e3});else{var s="";for(var n in this.rolepermissions)this.rolepermissions[n].length>0&&(s+=n+":"+this.rolepermissions[n].toString()+"::");var i={id:this.role,menuids:this.$refs.tree.getCheckedKeys().toString(),permissions:s};Object(o.a)({url:"/user/addSysRole",method:"post",data:i}).then(function(s){e.returnMsg(e,s),e.getRoles()})}},resetForm:function(e){this.$refs[e]&&this.$refs[e].resetFields()},save:function(){var e=this;console.log("save"),this.$refs.menu.validate(function(s){if(console.log(s,"va"),s){var n=t()({},e.menu);console.log(e.menu.permissions,e.menu,"me"),e.menu.permissions.length>0?n.permissions=n.permissions.toString():n.permissions="",n.pid=n.pid.split("-")[0],console.log(n),Object(o.a)({url:"/system/addSysMenus",method:"post",data:n}).then(function(s){e.returnMsg(e,s),e.getData()})}else console.log("error submit!!")})},setPid:function(e,s,n){0!==n.id&&"add"===e?this.menu.pid=n.id+"-"+n.label:0!==n.id&&"edit"===e?this.menu.pid=s.parent.data.id+"-"+s.parent.data.label:0===n.id&&"add"===e&&(this.menu.pid=0)},edit:function(e,s){var n=this;this.setPermissionShow(e),this.window=!0,setTimeout(function(){if(n.$refs.menu.resetFields(),n.menu=t()({},s),n.menu.permissions&&0!==n.menu.permissions.length){var i=n.menu.permissions.split(",");""!==n.menu.permissions?n.menu.permissions=i:n.menu.permissions=[]}n.setPid("edit",e,s)},1)},del:function(e){var s=this;this.$confirm("真的要删除这个菜单吗, 是否继续?","提示",{confirmButtonText:"是",cancelButtonText:"否",type:"warning"}).then(function(){Object(o.a)({url:"/system/delSysMenus",params:{id:e.id}}).then(function(e){s.getData(),s.returnMsg(s,e)})}).catch(function(){s.$message({type:"info",message:"已取消删除"})})}}},a={render:function(){var e=this,s=e.$createElement,n=e._self._c||s;return n("div",[n("el-dialog",{attrs:{visible:e.window,width:"56%","close-on-click-modal":"","close-on-press-escape":""},on:{"update:visible":function(s){e.window=s}}},[n("el-form",{ref:"menu",attrs:{inline:"",model:e.menu,"label-width":"120px","label-position":"left"}},[n("el-form-item",{attrs:{prop:"id",label:"id"}},[n("el-input",{attrs:{disabled:""},model:{value:e.menu.id,callback:function(s){e.$set(e.menu,"id",s)},expression:"menu.id"}})],1),e._v(" "),n("el-form-item",{attrs:{prop:"pid",label:"上级",required:""}},[n("el-input",{attrs:{disabled:""},model:{value:e.menu.pid,callback:function(s){e.$set(e.menu,"pid",s)},expression:"menu.pid"}})],1),e._v(" "),n("el-form-item",{attrs:{prop:"name",label:"路由名称",required:""}},[n("el-input",{model:{value:e.menu.name,callback:function(s){e.$set(e.menu,"name",s)},expression:"menu.name"}})],1),e._v(" "),n("el-form-item",{attrs:{prop:"label",label:"路由显示标题",required:""}},[n("el-input",{model:{value:e.menu.label,callback:function(s){e.$set(e.menu,"label",s)},expression:"menu.label"}})],1),e._v(" "),n("el-form-item",{attrs:{prop:"icon",label:"图标"}},[n("el-input",{model:{value:e.menu.icon,callback:function(s){e.$set(e.menu,"icon",s)},expression:"menu.icon"}})],1),e._v(" "),n("el-form-item",{attrs:{prop:"path",label:"路由路径",required:""}},[n("el-input",{model:{value:e.menu.path,callback:function(s){e.$set(e.menu,"path",s)},expression:"menu.path"}})],1),e._v(" "),n("el-form-item",{attrs:{prop:"component",label:"组件路径",required:""}},[n("el-input",{model:{value:e.menu.component,callback:function(s){e.$set(e.menu,"component",s)},expression:"menu.component"}})],1),e._v(" "),e.showPermissions?n("el-form-item",{attrs:{prop:"permissions",label:"页面权限"}},[n("common-select",{attrs:{data:e.permissions,multiple:"",keyKey:e.permissionsvaluekey,nameKey:e.permissionsnameKey,valueKey:e.permissionsvaluekey,fields:e.permissionsfield},model:{value:e.menu.permissions,callback:function(s){e.$set(e.menu,"permissions",s)},expression:"menu.permissions"}})],1):e._e(),e._v(" "),n("el-form-item",[n("common-button",{directives:[{name:"waves",rawName:"v-waves"}],attrs:{type:"primary"},on:{click:function(s){e.save()}}},[e._v("保存")]),e._v(" "),n("common-button",{directives:[{name:"waves",rawName:"v-waves"}],on:{click:function(s){e.window=!1}}},[e._v("取消")])],1)],1)],1),e._v(" "),n("el-dialog",{attrs:{visible:e.permissionWindow,width:"30%","close-on-click-modal":"","close-on-press-escape":""},on:{"update:visible":function(s){e.permissionWindow=s}}},[n("el-form",{ref:"permission",attrs:{model:e.permission,"label-width":"120px","label-position":"right"}},[n("el-form-item",{attrs:{label:"当前按钮权限"}},e._l(e.permissions,function(s){return n("el-tag",{key:s.pkey,attrs:{"disable-transitions":!1}},[e._v("\n                ["+e._s(s.pkey)+"]"+e._s(s.pname)+"\n              ")])})),e._v(" "),n("el-form-item",{attrs:{prop:"pkey",label:"权限英文Key",required:""}},[n("el-input",{model:{value:e.permission.pkey,callback:function(s){e.$set(e.permission,"pkey",s)},expression:"permission.pkey"}})],1),e._v(" "),n("el-form-item",{attrs:{prop:"pname",label:"权限名称",required:""}},[n("el-input",{model:{value:e.permission.pname,callback:function(s){e.$set(e.permission,"pname",s)},expression:"permission.pname"}})],1),e._v(" "),n("el-form-item",[n("common-button",{directives:[{name:"waves",rawName:"v-waves"}],attrs:{type:"primary"},on:{click:function(s){e.savePermission()}}},[e._v("保存")]),e._v(" "),n("common-button",{directives:[{name:"waves",rawName:"v-waves"}],on:{click:function(s){e.window=!1}}},[e._v("取消")])],1)],1)],1),e._v(" "),n("el-card",{staticClass:"cardcontainer"},[n("el-select",{attrs:{placeholder:"请选择系统角色"},on:{change:e.changeRole},model:{value:e.role,callback:function(s){e.role=s},expression:"role"}},e._l(e.roles,function(e){return n("el-option",{key:e.id,attrs:{label:e.roleName,value:e.id}})})),e._v(" "),n("common-button",{directives:[{name:"waves",rawName:"v-waves"},{name:"has",rawName:"v-has"}],attrs:{type:"primary",permission:"add"},on:{click:function(s){e.showAddPermission("permission","permissionWindow","permission")}}},[e._v("添加按钮权限字典")]),e._v(" "),n("el-tree",{ref:"tree",staticStyle:{"font-size":"13px"},attrs:{data:e.data,"show-checkbox":"","node-key":"id","default-expand-all":"","expand-on-click-node":!1,"check-strictly":""},scopedSlots:e._u([{key:"default",fn:function(s){var i=s.node,t=s.data;return n("span",{staticStyle:{width:"100%","font-size":"13px","line-height":"24px"}},[0===t.id?n("el-row",[n("el-col",{attrs:{span:4}},[n("svg-icon",{attrs:{"icon-class":"folder"}}),e._v(" "),n("span",[e._v(e._s(i.label))])],1),e._v(" "),n("el-col",{attrs:{span:4}},[n("common-button",{directives:[{name:"waves",rawName:"v-waves"}],attrs:{size:"mini",type:"text"},on:{click:function(){return e.add(i,t)}}},[e._v("新增")])],1)],1):n("el-row",[n("el-col",{attrs:{span:4}},[t.children.length>0?n("svg-icon",{attrs:{"icon-class":"folder"}}):n("svg-icon",{attrs:{"icon-class":"file"}}),e._v(" "),n("span",[e._v(e._s(i.label))])],1),e._v(" "),n("el-col",{attrs:{span:4}},[n("common-button",{directives:[{name:"waves",rawName:"v-waves"}],attrs:{size:"mini",type:"text"},on:{click:function(){return e.add(i,t)}}},[e._v("新增")]),e._v(" "),n("common-button",{directives:[{name:"waves",rawName:"v-waves"}],attrs:{size:"mini",type:"text"},on:{click:function(){return e.edit(i,t)}}},[e._v("编辑")]),e._v(" "),n("common-button",{directives:[{name:"waves",rawName:"v-waves"}],attrs:{size:"mini",type:"text"},on:{click:function(){return e.del(t)}}},[e._v("删除")])],1),e._v(" "),n("el-col",{attrs:{span:11}},[n("el-checkbox-group",{model:{value:e.rolepermissions[t.path],callback:function(s){e.$set(e.rolepermissions,t.path,s)},expression:"rolepermissions[data.path]"}},e._l(t.permissionsArray,function(s){return n("el-checkbox",{key:s.pkey,attrs:{label:s.pkey}},[e._v(e._s(s.pname))])}))],1)],1)],1)}}])}),e._v(" "),n("common-button",{directives:[{name:"waves",rawName:"v-waves"}],attrs:{type:"primary"},on:{click:e.saveRoleMenu}},[e._v("保存权限路由")])],1)],1)},staticRenderFns:[]};var l=n("VU/8")(r,a,!1,function(e){n("UCOU")},null,null);s.default=l.exports}});