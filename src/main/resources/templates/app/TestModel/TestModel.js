Ext.definine('Inv.model.TestModel',{
    extends:'Ext.data.Model',
    fields:[
        {name:'id',type:'int'},
        {name:'username',type:'string'},
        {name:'password',type:'string'},
        {name:'address',type:'string'},
    ],
    proxy:{
        type:'ajax',
        reader:{
            type:'json',
            root:'data',

        },

    },
});