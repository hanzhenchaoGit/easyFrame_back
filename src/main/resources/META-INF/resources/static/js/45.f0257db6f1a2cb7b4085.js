webpackJsonp([45],{"3RtG":function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=n("woOf"),o=n.n(s),i={name:"kdAdminWH",mounted:function(){this.getXsTree()},data2:function(){"/system/proxyExcute?uuid=d1e2c0c0-d50f-4fc5-85b9-ea903493d4e6"},data:function(){return{save2:!0,save1:!0,show:!0,window:{uploadWindow:!1,selectXsWindow:!1},tree:{xsTree:[]},addWindow:!1,currentRow:[],compaddressForm:{},url:"/KDAdminInfo/findAllInfoByPage",select:{},columns:[{colType:"selection"},{prop:"id",label:"序号"},{prop:"adminName",label:"管理员名称"},{prop:"ksname",label:"所在科室"},{label:"操作",slotName:"edit",width:300}]}},methods:{handleCheckChange:function(e,t,n){return console.log(e,t,n),e},checkAble:function(e,t){return!0},deleteAdmin:function(e,t){var n=this;this.$request({url:"/KDAdminInfo/delKdadmininfo",method:"get",params:{id:t.id}}).then(function(e){e.data?n.$refs.table.fetchHandler():n.$message({showClose:!0,message:"删除失败",type:"warning"})})},selectRow:function(e,t){this.currentRow=o()([],e),this.currentRow=this.currentRow.map(function(e){return e.id})},getXsTree:function(){var e=this;this.$request({url:"/consult/getXsTree",method:"get"}).then(function(t){e.tree.xsTree=t.data})},add:function(){this.$refs.xsTree.setCheckedKeys([]),this.$refs.xsTree.setCheckedNodes([]),this.$set(this,"addWindow",!0),this.$set(this,"save2",!1),this.$set(this,"save1",!0)},batchDeleteAdmin:function(e,t){var n=this,s=this.currentRow;this.$request({url:"/KDAdminInfo/deleteAllAdmin",method:"post",data:s}).then(function(e){e.data?(console.log(22334),n.$refs.table.fetchHandler()):n.$message({showClose:!0,message:"查看失败",type:"warning"})})},setXsRy:function(){var e=this,t=this.$refs.xsTree.getCheckedKeys();this.window.selectXsWindow=!1,this.$request({url:"/KDAdminInfo/addKdadmininfo",method:"post",data:t}).then(function(t){t.data?(e.window.selectXsWindow=!1,e.$refs.table.fetchHandler()):e.$message({showClose:!0,message:"添加失败",type:"warning"})})}}},c={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("el-card",[n("el-dialog",{attrs:{title:"选择快递管理员",visible:e.window.selectXsWindow,width:"40%","close-on-click-modal":"","close-on-press-escape":""},on:{"update:visible":function(t){e.$set(e.window,"selectXsWindow",t)}}},[n("el-card",{staticClass:"cardcontainer",staticStyle:{height:"45vh"},attrs:{shadow:"always"}},[n("el-tree",{directives:[{name:"show",rawName:"v-show",value:e.show,expression:"show"}],ref:"xsTree",staticStyle:{"font-size":"14px"},attrs:{data:e.tree.xsTree,"node-key":"id","show-checkbox":"","highlight-current":"","expand-on-click-node":!1,"check-strictly":""},on:{"check-change":e.handleCheckChange}})],1),e._v(" "),n("div",{staticStyle:{"text-align":"right"}},[n("common-button",{on:{click:function(t){e.setXsRy()}}},[e._v("确定")]),e._v(" "),n("common-button",[e._v("取消")])],1)],1),e._v(" "),n("common-table",{ref:"table",attrs:{url:e.url,"highlight-current-row":"",checkboxFun:e.checkAble,columns:e.columns,fit:"",autoLoad:""},on:{select:e.selectRow},scopedSlots:e._u([{key:"buttons",fn:function(t){return[n("common-button",{on:{click:function(t){e.window.selectXsWindow=!0}}},[e._v("添加")]),e._v(" "),n("common-button",{on:{click:function(n){e.batchDeleteAdmin(t.$index,t.row)}}},[e._v("批量删除")])]}},{key:"edit",fn:function(t){return[n("common-button",{on:{click:function(n){e.deleteAdmin(t.$index,t.row)}}},[e._v("删除")])]}}])})],1)],1)},staticRenderFns:[]},a=n("VU/8")(i,c,!1,null,null,null);t.default=a.exports}});