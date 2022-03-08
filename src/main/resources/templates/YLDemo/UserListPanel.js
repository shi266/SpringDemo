    Ext.onReady(function (){
        Ext.QuickTips.init();
        var filterPanel = Ext.create('YLDemo.app.view.UserGridPanel', {
            // id:'datapanel',
            // region : 'center',
            // header:'表头文字',
            bodyPadding: 10,  // Don't want content to crunch against the borders
            width: '100%',
            height:700,
            title: '数据展示',
            // stripeRows: true,
            // enableColumnResize: false,
            forceFit: true,
            viewConfig: {
                enableTextSelection: true
            },
            flex: 1,
            frame: true,
            plugins:[
                {
                    ptype:'rowexpander',
                    rowBodyTpl:Ext.create('Ext.XTemplate','<div id="{username}"></div>'),
                },
            ],
            renderTo:Ext.getBody(),
        });
        // Ext.create('Ext.container.Viewport', {
        //     layout: 'border',
        //     items: [
        //         filterPanel
        //     ],
        // });
    });
