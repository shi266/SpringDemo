
// Ext.define('Inv.store.GoodsStore',{
//     extend:'Ext.data.Store',
//     requires:['Inv.model.GoodsModel'],
//     constructor:function (cfg){
//         var me = this;
//         cfg=cfg || {};
//         me.callParent([Ext.apply({
//             model:'Inv.model.GoodsModel',
//             storedId:'GoodsStore',
//             data:[
//                 {
//                     id:'101',
//                     username:'张三',
//                     password:'zhangsan',
//                     address:'深圳'
//                 },
//                 {
//                     id:'102',
//                     username:'里斯',
//                     password:'lisi',
//                     address:'上海'
//                 }
//             ]
//         },cfg)]);
//     }
//
// });

Ext.define('Inv.store.GoodsStore',{
    extend:'Ext.data.Store',
    requires:[
        'Inv.model.GoodsModel'
    ],
    constructor:function (cfg){
        var me = this;
        cfg=cfg || {};
        me.callParent([Ext.apply({
            model:'Inv.model.GoodsModel',
            storedId:'GoodsStore',
            autoLoad:true,
            proxy:{
                type:'ajax',
                url:'/getGoodsModels',
                reader:{
                    type: 'json',
                    root:'data',
                    totalProperty:'totalProperty',
                },
            },
        },cfg)]);
    }
});
