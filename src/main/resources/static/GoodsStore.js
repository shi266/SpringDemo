
// var userStore  = Ext.create('Ext.data.Store',{
//     model:'GoodsModel',
//
// });
// var userProxy = new Ext.data.proxy.LocalStorage({
//     id:'User_LocalStoreage',
//     model: 'GoodsModel',
// });
// userStore.setProxy(userProxy);
// userStore.add({id:101,username:'张三',password:'zhangsna',address:'安阳'});
// userStore.sync();
//
// userStore.load();
// var msg = [];
// userStore.each(function (GoodsModel){
//     msg.push(GoodsModel.get('id'))+' '+GoodsModel.get('username')+' '
//     +GoodsModel.get('password')+' '+GoodsModel.get('address');
// });
// Ext.Msg.alert('提示',msg.join('<br/>'));

Ext.define('Inv.store.GoodsStore',{
    extend:'Ext.data.Store',
    requires:[
        'Inv.model.GoodsMoel'
    ],
    constructor:function (cfg){
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'Inv.model.GoodsMoel',
            stored: 'GoodsStore',
            proxy: {
                type: 'json',
                root: '',
                totalProperty: 'totalProperty'
            }

        },cfg)]);
    },
    autoLoad:true
});