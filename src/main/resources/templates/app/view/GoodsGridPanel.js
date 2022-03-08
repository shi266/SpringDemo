Ext.define('Inv.view.GoodsGridPanel',{
    extend:'Ext.grid.Panel',//继承自grid.Panel
    title:'商品列表w',//商品列表名称

    store:'GoodsStore',//存储对象，指定商品列表的数据来源

    //列表组件初始化，本视图被加载的时候自动调用
    initComponent:function (){
        var me = this;
        //向自定义的gridPanel中注册子组件，也就是商品列表的显列
        Ext.applyIf(me,{
            columns:[
                {
                    xtype:'gridcolumn',
                    height:50,
                    dataIndex:'id',
                    text:'编号'
                },
                {
                    xtype:'gridcolumn',
                    height:50,
                    dataIndex:'username',
                    text:'用户名'
                }, {
                    xtype:'gridcolumn',
                    height:50,
                    dataIndex:'password',
                    text:'密码'
                },
                {
                    xtype:'gridcolumn',
                    height:50,
                    dataIndex: 'address',
                    text: '地址'
                }
            ]
        });
        //激活父组件渲染到页面
        me.callParent(arguments);

    }


});