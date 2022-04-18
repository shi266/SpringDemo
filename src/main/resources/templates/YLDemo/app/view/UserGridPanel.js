Ext.define('YLDemo.app.view.UserGridPanel', {
    extend: 'Ext.grid.GridPanel',
    initComponent: function () {
        // this.createSelectionModel();
        this.createStore();
        this.createTbar();
        this.createBbar();
        // this.createSelectionModel2();
        this.createColumns();
        this.createPlugins();
        this.callParent(arguments);
        },

    createPlugins:function(){
        var gridPanel=this;
        this.plugins=[
            {
                ptype:'rowexpander',
                rowBodyTpl:Ext.create('Ext.XTemplate'),
            },
            Ext.create('Ext.grid.plugin.CellEditing', {
                clicksToEdit:1,
                pluginId:'cellplugin',
                listeners:{
                    edit:function(editor,e){
                        if (e.originalValue!=e.value){
                            alert("改变了")
                        }
                    },
                },
            })
        ];
    },

    createSelectionModel:function(){
        this.selModel=Ext.create('Ext.selection.RowModel',{
            listeners:{
                select:function(){
                    this.deselectAll();
                },
            },
        });
    },


    listeners: {
            afterrender:function(grid){
                grid.view.on('expandbody',function(rowNode, record, expandRow){
                    var innerGridPanel=Ext.create('YLDemo.app.view.UserGridPanelZi',{

                        renderTo:record.get('username'),
                        username:record.get('username'),
                        password:record.get('password'),
                        height:200,
                        forceFit:true,
                        viewConfig:{
                            enableTextSelection:true
                        },
                    });
                    innerGridPanel.getEl().swallowEvent(['mousedown','click','mouseout','dblclick']);
                });
                grid.view.on('collapsebody',function(rowNode, record, expandRow){
                    var parent = document.getElementById(record.get('username'));
                    // alert(parent)
                    var child = parent.firstChild;
                    // alert("chiild状态："+child)
                    while (child) {
                        child.parentNode.removeChild(child);
                        child = child.nextSibling;
                    }
                });
            },

        },


        deleteUser: function (grid, rowIndex, colIndex, item, e, record) {
            var id = record.get('id');
            alert(id)
            Ext.Msg.confirm('Delete Alert!', '你确定要删除吗？', function (btn) {
                if (btn == 'yes') {
                    Ext.Ajax.request({
                        url: '/deleteUser',
                        params: {
                            id: id,
                        },
                        success: function (response) {
                            var res = Ext.decode(response.responseText);
                            if (res.success) {
                                Ext.Msg.alert('Status', res.data);
                                grid.getStore().reload();
                            } else {
                                Ext.Msg.alert('ERROR', res.data);
                            }
                        },
                        failure: function () {
                            Ext.Msg.alert('ERROR', '通讯失败!检查是否已经连接上互联网');
                        },

                    });
                }
            });
        },

        createColumns: function () {
            var gridPanel = this;
            this.columns = [


                {
                    text: '编号', dataIndex: 'id',  width: 50,
                    editor: {
                        xtype:'combo',
                        store:Ext.create('Ext.data.Store',{
                            fields:['name','value'],
                            data:[
                                {'name':'海运','value':'海运'},
                                {'name':'空派','value':'空派'},
                                {'name':'快递','value':'快递'},
                            ],
                        }),
                        displayField:'name',
                        valueField:'value',
                        queryMode:'local',
                        width:150,
                        editable:false,
                        forceSelection:true,
                        listConfig:{
                            minWidth:120,
                        },
                        value:''
                    },
                    renderer:function(value){
                        if(value==101) {
                            return '<span style="color: red">'+value+'</span>';
                        }
                        return value;
                    },
                },
                {
                    text: '用户名', dataIndex: 'username', sortable: false, width: 120,
                    renderer:function(value,metaData,record) {

                        return '<span title="'+value+'测试">'+value+'</span>';
                    }
                },
                {
                    text: '密码', dataIndex: 'password', sortable: true, width: 80, flex: 1, clicksToEdit: 2,
                    listeners: {
                            click:function(grid,td,rowIndex,cellIndex,element,rec,tr){
                                //grid 即当前grid
                                //td  即单击的td元素
                                //rowIndex 行索引
                                //cellIndex  列索引
                                //element dom元素
                                //rec    被选中的记录
                                //tr    tr元素
                                var showPanel = Ext.create('Ext.form.Panel',{
                                    labelWidth: 50,
                                    buttonAlign: 'center',
                                    labelAlign: 'right',
                                    defaultType: 'textfield',
                                    items: [
                                        {
                                            xtype: 'textarea',
                                            width:400,
                                            height:400,
                                            value: rec.get('password')+'ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ'
                                        },
                                        ]
                                });
                                Ext.create('Ext.window.Window', {
                                    title: rec.get('id'),
                                    width: 410,
                                    height: 410,
                                    items: showPanel,
                                    modal: true,
                                }).show();
                            }
                    }

                },
                {
                    text: '地址', dataIndex: 'address', sortable: true, width: 80, flex: 1,
                },
                {
                    xtype: 'actioncolumn', text: '操作', flex: 1, sortable: false,
                    items: [
                        {
                            tooltip: 'sdsd',
                            iconCls: 'x-tbar-delete',
                            text: 'delete',
                            handler: gridPanel.deleteUser,
                        },
                        '-',
                        {
                            tooltip: 'sdsd',
                            iconCls: 'x-tbar-add',
                            border: '20 10 10 20',
                            text: 'add',
                            handler: gridPanel.adduser,
                        },
                        '-',
                        {
                            tooltip: '设置状态',
                            iconCls: 'x-tbar-add',
                            border: '20 10 10 20',
                            text: 'add',
                            handler: gridPanel.adduser,
                        },
                    ]
                },
                {
                    text: '备注', dataIndex: 'commit', sortable: false, width: 80, flex: 1,
                },
               /* {
                    text: 'image', dataIndex: 'image', sortable: false, width: 80, flex: 1,
                    renderer:function(value){

                        return "<img src='"+value+"'>";
                    },
                },*/


            ];


    },

    adduser:function(view,rowIndex,colIndex,item,e,record) {
       var form =  Ext.create('Ext.form.Panel',{
           labelWidth:50,
           buttonAlign:'center',
           labelAlign:'right',
           defaultType:'textfield',
           items:[
               {
                   fieldLabel:'ASIN',
                   name:'asin',
                   value:record.get('username'),
               },
               {    xtype:'textarea',
                   fieldLabel:'备注',
                   name:'commit',
               },
           ],
           buttons:[
               {
                   text:'submit',
                   handler:function (){
                       alelrt("向后台提交")
                   },
               },
               {
                   text: 'reset',
                   handler: function () {
                       form.getForm().reset();
                   }
               }
           ],
        });
        Ext.create('Ext.window.Window',{
            title:'添加产品备注',
            width:400,
            height:300,
            items:form,
            modal:true,
        }).show();
    },
    createBbar:function(){
        this.bbar=Ext.create('Ext.toolbar.Paging',
            {
                displayInfo:true,
                displayMsg:'第{0} 到 {1} 条数据 共{2}条',
                emptyMsg:"没有数据",
                store:this.store,
                items: [
                    {
                        fieldLabel:'重发总费用',
                        xtype:'textfield',
                        labelWidth:65,
                        labelPad:0,
                        width:140,
                        readOnly:true,
                        value:0,
                        id:'totalFulfillmentFee',
                    },
                    {
                        text:'<font color=\'red\'>*鼠标悬停提示*</font>',
                        width:140,
                        height:20,
                        tooltip:'' +
                            '一天内未处理/ ' +
                            '超过一天未处理/ ' +
                            '处理中 /' +
                            '<br>' +
                            '换行测试' +
                            '<br>' +
                            '未处理',
                    },
                ],
            });
    },
    createStore:function(){
        var gridPanel=this;
        this.store =Ext.create('Ext.data.Store',{
            fields:['id', 'username', 'password', 'address','active','commit','image'],
            pageSize:25,
       /*     remoteSort:true,*/
            proxy:{
                type:'ajax',
                url:'/getUsersall',
                simpleSortMode:true,
                reader:{
                    type:'json',
                    root:'data',
                    totalProperty:'totalRows',
                }
            },
            listeners:{
                beforeload:function(){
                    gridPanel.getTotalFulfillmentFee();
                    var name=Ext.getCmp('name').getValue();
                    var address=Ext.getCmp('address').getValue();
                    gridPanel.name=name;
                    gridPanel.address=address;
                    Ext.apply(
                        this.proxy.extraParams,
                        {'username':name,
                            'address':address,
                        });
                },
            },

            autoLoad:true,
        });
    },
    createTbar:function(){
        var gridPanel = this;

        this.tbar=[
            {
                fieldLabel:'用户名',
                frame:true,
                // editable:false,//不允许文本输入，比如通过combo选值
                forceSelection:false,
                xtype:'combo',
                labelWidth:80,
                autoload: true,
                queryMode:'remote',
                emptyText:'选择或输入',
                labelPad:0,
                triggerAction: 'all',
                displayField: 'username',
                valueField: 'username',
                store : Ext.create('Ext.data.Store',{
                    fields:['id', 'username', 'password', 'address','active'],
                    pageSize:25,
                    proxy:{
                        type:'ajax',
                        url:'/getUserName',
                        reader:{
                            type:'json',
                            root:'data',
                            totalProperty:'totalRows',
                        }

                    },

                    }),
                value:'',
                id:'name',
                liscens:{

                }
            },

            {
                fieldLabel:'地址',
                xtype:'textfield',
                labelWidth:40,
                labelPad:0,
                forceSelection:true,
                id:'address',
            },
            {

                xtype:'button',
                text:'查询XX',
                id:'downSelectBtn',
                iconCls:'x-tbar-search',

                handler:function(button){
                    gridPanel.getStore().reload();
                    // button.up('gridpanel').getStore().loadPage(1);
                    // gridPanel.getTotalFulfillmentFee();
                    /*var sto =Ext.create('Ext.data.Store',{
                        fields:['id', 'username', 'password', 'address','active','commit'],
                        pageSize:25,
                        proxy:{
                            type:'ajax',
                            url:'/getUsersall',
                            reader:{
                                type:'json',
                                root:'data',
                                totalProperty:'totalRows',
                            }
                        },
                        listeners:{
                            beforeload:function(){
                                var name=Ext.getCmp('name').getValue();
                                var address=Ext.getCmp('address').getValue();
                                gridPanel.name=name;
                                gridPanel.address=address;
                                Ext.apply(
                                    this.proxy.extraParams,
                                    {'username':name,
                                        'address':address,
                                    });
                            },
                        },
                        autoLoad:true,
                    });*/
                }
            },
            {
                itemId:'createBtn',
                text: '添加',
                iconCls: 'x-tbar-add',
                handler:this.showCreateWindow,


            },
            {
                xtype:'button',
                text: '修改',
                iconCls: 'x-tbar-update',
                handler:this.showUpdateWindow,


            },
            {
                xtype:'button',
                itemId:'delBtn',
                text: '删除',
                iconCls: 'x-tbar-delete',
                handler:this.showdeleteWindow,
            },
            {
                type: "button",
                text: '导入Excel',
                iconCls: 'x-tbar-upload',
                handler: function (view,rowIndex,colIndex,item,e,record){
                    var importExcelPanel = Ext.create('Ext.form.Panel', {
                        items: [
                            //重发ID
                            {
                                xtype: 'filefield',
                                name: 'excelFile',
                                fieldLabel: 'Excel文件',
                                buttonText: '选择文件',
                                labelPad:0,
                                labelWidth:60,
                                width:300,
                                readOnly:true,
                                allowBlank:false,
                            },
                        ],
                        buttons:[
                            {
                                text: 'submit',
                                handler: function () {
                                    if(importExcelPanel.isValid()){
                                        importExcelPanel.getForm().submit({
                                            url:'/sanqi/uploadExcel',
                                            method:'post',
                                            waitMsg: '正在上传...',
                                            success:function(basicForm,action){
                                                if(action.result.success){
                                                    Ext.Msg.alert('Status',action.result.data);
                                                    importExcelPanel.up('window').close();
                                                }
                                            },
                                            failure:function(basicForm,action){
                                                switch (action.failureType) {
                                                    case Ext.form.action.Action.SERVER_INVALID:
                                                        Ext.Msg.alert('ERROR', action.result.data);
                                                        break;
                                                    default:Ext.Msg.alert('ERROR','通讯失败!稍后再试');
                                                }

                                            },
                                        });
                                       /* importExcelPanel.getForm().submit({
                                            url:'/sanqi/uploadExcel',
                                            method:'post',
                                            waitMsg: '正在上传...',
                                            success:function(basicForm,action){
                                                Ext.Msg.alert('basicForm', JSON.stringify(basicForm));
                                                Ext.Msg.alert('action', JSON.stringify(action));
                                                Ext.Msg.alert('return', JSON.stringify(action.result));
                                            },
                                            failure:function(basicForm,action){
                                                switch (action.failureType) {
                                                    case Ext.form.action.Action.SERVER_INVALID:
                                                        Ext.Msg.alert('ERROR', JSON.stringify(action.result));
                                                        break;
                                                    default:
                                                        Ext.Msg.alert('ERROR','通讯失败!检查是否已经连接上互联网');
                                                }
                                                importExcelPanel.up('window').close();
                                            },
                                        });*/
                                    }

                                }
                            },
                            {
                                text:'close',
                                handler:function(){
                                    importExcelPanel.up('window').close();
                                }
                            },
                        ]

                    });
                    Ext.create('Ext.window.Window',{
                        items:importExcelPanel,
                        title:'上传Excel批量更新',
                        width:400,
                        height:100,
                        modal:true,
                        resizable: false,
                        overflowY:'auto',
                    }).show();
                }
            },
            {
                xtype:'button',
                itemId:'delBtn',
                text: '查看选中',
                iconCls: 'x-tbar-delete',
                handler:this.showCheck,
            },
            '->',
            {

                xtype:'button',
                text: '导出订单',
                iconCls: 'x-tbar-delete',
                handler: function (){
                    var name=gridPanel.name;
                    var address=gridPanel.address;
                    window.open('getExcel?' +
                        'username='+name+
                        '&address='+address,'newwindow',
                        'height=100, width=400, top=0,' +
                        ' left=0, toolbar=no, menubar=no, scrollbars=no,' +
                        ' resizable=no,location=n o, status=no','_blank')
                }
            },
            {

                xtype:'button',
                text: '导出订单x2',
                iconCls: 'x-tbar-delete',
                handler: function (){
                    var name=gridPanel.name;
                    var address=gridPanel.address;
                    window.open('getTemplateExcel')
                }
            },
            {

                xtype:'button',
                text: '退出登录',
                iconCls: 'x-tbar-delete',
                handler: function (){
                    Ext.Ajax.request({
                        url: '/exit',
                        success: function(response){
                            var text = response.responseText;
                            window.location.href='http://localhost:8080/tologin';
                        }
                    });
                }
            },

        ];
    },
    showCheck:function (button){
        var gridPanel = button.up('gridpanel');
        var selectModels=gridPanel.getSelectionModel().getSelection();
        if(selectModels.length>0){
            var ids=[];
            for (var i = 0; i <selectModels.length ; i++) {
                ids.push(selectModels[i].get("id"))
            }
            alert(ids)
        }else {
            alert("请选择数据")
        }

    },

    showCreateWindow:function (button){
            var gridpanel=button.up('gridpanel');
        var form=Ext.create('Ext.form.Panel',{
            labelWidth:50,
            buttonAlign:'center',
          /*  labelAlign:'center',
            defaultType:'textfield',*/
            labelAlign: "center",
            id:'form',

            items:[{
                    autoHeight: true,
                    layout: "column",
                    items:[
                        {
                            columnWidth:.50,
                            xtype: "fieldset",
                            title: "个人信息",
                            layout: "form",
                            style: "margin-left: 2px;padding-left:5px",
                            items: [
                                { fieldLabel: "姓  名", id:"userName", allowBlank: false,xtype:"textfield" },
                                { fieldLabel: "通信地址", id: "userAddress", allowBlank: false,xtype:"textfield" },
                                { fieldLabel: "Email", id: "userEmail", vtype: "email", allowBlank: false,xtype:"textfield" },
                                { fieldLabel: "年  龄", id: "userAge", xtype: "numberfield", maxValue: 100, minValue: 0, allowBlank: false }
                            ]
                        },
                        {
                            columnWidth:.50,
                            xtype: "fieldset",
                            title:"企业信息",
                            layout: "form",
                            style: "margin-left: 5px;padding-left:5px",
                            items: [
                                  {
                                   fieldLabel: '用户名',
                                   name: 'username',
                                   allowBlank: false,
                                      xtype:"textfield"
                                  },
                                   {
                                       fieldLabel: '密码',
                                       name: 'password',
                                       allowBlank: false,
                                       xtype:"textfield",
                                   },

                            ],
                        },

                    ],
               /*     */
                }],

    /*        items:[
                {
                    xtype: 'filefield',
                    name: 'pictures',
                    fieldLabel: '图片',
                    labelWidth: 80,
                    labelPad: 0,
                    width: 230,
                    msgTarget: 'side',
                    allowBlank: true,
                    anchor: '100%',
                    buttonText: '选择图片',
                },

            ],*/
            buttons:[
                {
                    text:'submit',
                    handler:function(){
                        if(form.isValid()){
                            form.getForm().submit({
                                url:'/addUSer', //新建品牌的ul
                                type:'Get',
                                success:function(basicForm,action){
                                    if(action.result.success){
                                        Ext.Msg.alert('Status',action.result.data);
                                        gridpanel.getStore().reload();
                                    }
                                    form.up('window').hide();

                                },
                                failure:function(basicForm,action){
                                    switch (action.failureType) {
                                        case Ext.form.action.Action.SERVER_INVALID:
                                            Ext.Msg.alert('ERROR', action.result.data);break;
                                        default:Ext.Msg.alert('ERROR','通讯失败!检查是否已经连接上互联网');

                                    }

                                    form.up('window').hide();
                                },
                            });
                        }

                    }
                },
                {
                    text:'reset',
                    handler:function(){
                        form.getForm().reset();
                    }
                }
            ],

        });
        Ext.create('Ext.window.Window',{
                title:'产品品牌',
                width:900,
                height:600,
                items:form,
                modal:true,
            }).show();

    },
    showUpdateWindow:function(button) {
        var gridpanel = button.up('gridpanel');
        var record = gridpanel.getSelectionModel().getSelection()[0];
        if(record.get('username')=='张三'){
            alert("就是你")
        }
        try{
            var form = Ext.create('Ext.form.Panel', {
                labelWidth: 50,
                buttonAlign: 'center',
                labelAlign: 'right',
                defaultType: 'textfield',
                items: [
                    {
                        fieldLabel: '编号',
                        name: 'id',
                        allowBlank: false,
                        value: record.get('id')
                    },
                    {
                        fieldLabel: '用户名',
                        name: 'username',
                        allowBlank: false,
                        value: record.get('username')
                    },
                    {
                        fieldLabel: '密码',
                        name: 'password',
                        allowBlank: false,
                        value: record.get('password')
                    },
                    {
                        fieldLabel: '地址',
                        name: 'address',
                        allowBlank: false,
                        value: record.get('address')
                    },
                    {
                        fieldLabel: '主图',
                        name: 'pictures',
                        xtype: 'filefield',
                        labelWidth: 80,
                        labelPad: 0,
                        width: 250,
                        msgTarget: 'side',
                        allowBlank: true,
                        anchor: '100%',
                        buttonText: '选择图片',
                        regex: new RegExp("^.*\.(?:jpg)$"),
                        regexText: '必须是jpg文件',
                        value: "",
                        listeners: {
                            change: function (filefield, value) {
                                if (!filefield.isValid()) {
                                    filefield.reset();
                                    Ext.Msg.alert("提示", '必须是jpg文件');
                                }
                            }
                        }
                    }
                ],
                buttons: [
                    {
                        text: 'submit',
                        handler: function () {
                            if (form.isValid()) {
                                form.getForm().submit({
                                    url: '/updateUser', //更新品牌的url
                                    success: function (basicForm, action) {
                                        if (action.result.success) {
                                            Ext.Msg.alert('Status', action.result.data);
                                            gridpanel.getStore().reload();
                                        }
                                        form.up('window').hide();

                                    },
                                    failure: function (basicForm, action) {
                                        switch (action.failureType) {
                                            case Ext.form.action.Action.SERVER_INVALID:
                                                Ext.Msg.alert('ERROR', action.result.data);
                                                break;
                                            default:
                                                Ext.Msg.alert('ERROR', '通讯失败!检查是否已经连接上互联网');

                                        }

                                        form.up('window').hide();
                                    },


                                });
                            }

                        }
                    },
                    {
                        text: 'reset',
                        handler: function () {
                            form.getForm().reset();
                        }
                    }
                ],

            });
        Ext.create('Ext.window.Window', {
            title: '更新产品',
            width: 400,
            height: 400,
            items: form,
            modal: true,
        }).show();
    }catch (e) {
            // alert("再见"+e)
            Ext.Msg.alert('提示','请先选择要修改的数据');
        }
    },
    showdeleteWindow:function (button){
        var gridpanel=button.up('gridpanel');
        try{
        Ext.Msg.confirm('Delete Alert!','你确定要删除吗？',function(btn){
            if(btn=='yes'){
                var delBrand=gridpanel.getSelectionModel().getSelection()[0];
                Ext.Ajax.request({
                    url:'/deleteUser',//删除品牌的url
                    params:{
                        id:delBrand.get('id'),
                    },
                    success:function(response){
                        var res=Ext.decode(response.responseText);
                        if(res.success){
                            Ext.Msg.alert('Status',res.data);
                            gridpanel.getStore().reload();
                        }else {
                            Ext.Msg.alert('ERROR',res.data);
                        }
                    },
                    failure:function(){
                        Ext.Msg.alert('ERROR','通讯失败!检查是否已经连接上互联网');
                    },


                });
            }


        });
        }catch (e) {
            Ext.Msg.alert('提示','请先选择要删除的数据');
        }
    },
    getTotalFulfillmentFee:function(){
        var gridPanel = this;
        Ext.Ajax.request({
            url:'/getFee',
            method:'Get',
            params: {
                username: gridPanel.name,
                address: gridPanel.address,
            },
            success:function(response){
                var totalFulfillmentFee = Ext.decode(response.responseText).data;
                Ext.getCmp('totalFulfillmentFee').setValue(totalFulfillmentFee);//将获取到的费用填充到页面
            },
            failure:function(basicForm,action){
                switch (action.failureType) {
                    case Ext.form.action.Action.SERVER_INVALID:
                        Ext.Msg.alert('ERROR', action.result.data);break;
                    default:Ext.Msg.alert('ERROR','通讯失败!稍后再试');
                }
            },
        });

    }
});

