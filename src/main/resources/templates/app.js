//覆盖父级包设置
Ext.Loader.setConfig({
    enable:true
});
// Ext.onReady(function (){
//     Ext.Msg.alert('提示','测试application')
// })
// Ext.require(['Ext.tree.Panel','Ext.panel.Panel','Ext.tab.Panel']);
Ext.application({
    name: 'Inv',     //指定应用命名空间
    autoCreateViewport: true,
    controllers: [
        'GoodsController'//指定应用的控制器
    ],
});