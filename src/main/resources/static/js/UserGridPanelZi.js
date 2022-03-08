Ext.define('YLDemo.app.view.UserGridPanelZi', {
    extend: 'Ext.grid.GridPanel',
    initComponent: function () {
        this.createStore();
        this.createColumns();
        this.callParent(arguments);

    },

    createColumns: function () {
        this.columns = [
            {text: '编号', dataIndex: 'id', sortable: false,  flex: 1,},
            {text: '用户名', dataIndex: 'username', sortable: false,  flex: 1,},
            {text: '密码', dataIndex: 'password', sortable: true,  flex: 1,},
            {text: '地址', dataIndex: 'address', sortable: true,  flex: 1,},

        ];


    },
    createStore:function(){
        var gridPanel=this;
        this.store =Ext.create('Ext.data.Store',{
            fields:['id', 'username', 'password', 'address'],
            pageSize:25,
            proxy:{
                type:'ajax',
                url:'/checktest',
                reader:{
                    type:'json',
                    root:'data',
                    totalProperty:'totalRows',
                }
            },
            listeners:{
                beforeload:function(){
                    var id = gridPanel.id;
                    var username = gridPanel.username;
                    var password = gridPanel.password ;
                    Ext.apply(
                        this.proxy.extraParams,
                        {
                            'id':id,
                            'username':username,
                            'password':password,
                        });
                },
            },
            autoLoad:true,
        });
    },

})