
Ext.onReady(function (){
   var store = Ext.create('Ext.data.TreeStore', {
       root: {
           expanded: true,
           children: [          //Tree数据结构
                            {text:"Amazon平台管理",expanded: false, children:[
                                    {text: "AmazonASIN管理",leaf:true},
                                    {text: "AmazonSKU查询",leaf:true},
                                ],},
           ],
       }
   });

   //创建TreePanel
    var tree = Ext.create('Ext.tree.Panel',{
        title:'功能菜单',
        width:200,
        height:500,
        useArrows:true, //树节点使用箭头
        border: true,  //边框
        store:store,
        rootVisible:false,
        renderTo:Ext.getBody(),

    });
    tree.expandAll(); //展开所有节点
   //  var store = Ext.create('Ext.data.TreeStore', {
   //      root: {
   //          expanded: true,
   //          children: [
   //              { text: "detention", leaf: true },
   //              { text: "homework", expanded: true, children: [
   //                      { text: "book report", leaf: true },
   //                      { text: "alegrbra", leaf: true}
   //                  ] },
   //              { text: "buy lottery tickets", leaf: true }
   //          ]
   //      }
   //  });
   //
   //  Ext.create('Ext.tree.Panel', {
   //      title: 'Simple Tree',
   //      width: 200,
   //      height: 150,
   //      store: store,
   //      rootVisible: false,
   //      renderTo: Ext.getBody()
   //  });
});

