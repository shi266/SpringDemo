Ext.define('Inv.controller.GoodsController',{
    extend:'Ext.app.Controller',

    models:['GoodsModel'],//指定模型

    stores:['GoodsStore'],//指定存储对象

    views:['GoodsGridPanel'],//指定视图
});