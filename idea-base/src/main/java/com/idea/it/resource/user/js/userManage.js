Idea.Model.define('Idea.systemManage.user',function(page){
	
	page.ready = _ready;
	
	page.config = {
	};
	
	page.exit = _exit;
	
	function _ready(){
		console.log('user ready');
		_initUserPage();
	};

	function _initUserPage(){
		var $page = $('#user_page');
		_initUserHeader($page);
		
		_bindUserHeaderEvent($page);
		
		_initUserBody($page);
		
		_bindUserBodyEvent($page);
	};

	function _initUserHeader($page){
		var headerDom = [];
		headerDom.push('<ul>');
		
		headerDom.push('<li class="row_item">');
		headerDom.push('<span class="user_name">用户名:</span>');
		headerDom.push('<input></input>');
		headerDom.push('<span class="user_dep">部门:</span>');
		headerDom.push('<input></input>');
		headerDom.push('<span>角色:</span>');
		headerDom.push('<input></input>');
		headerDom.push('<span>是否有效:</span>');
		headerDom.push('<input></input>');
		
		headerDom.push('<div class="btn_box">');
		headerDom.push('<span class="btn search">搜索</span>');
		headerDom.push('<span class="btn reset">重置</span>');
		headerDom.push('<span class="btn switch fa fa-angle-down"></span>');
		headerDom.push('</div>');
		headerDom.push('<li>');
		
		headerDom.push('<li class="row_item">');
		headerDom.push('<span>入职日期:</span>');
		headerDom.push('<input></input>');
		headerDom.push('<span>离职日期:</span>');
		headerDom.push('<input></input>');
		headerDom.push('<span>性别:</span>');
		headerDom.push('<div class="user_sex_box">');
			headerDom.push('<div class="active"><span class="radio_icon fa fa-dot-circle-o"></span><span class="radio_text">All</span></div>');
			headerDom.push('<div><span class="radio_icon fa fa-circle-o"></span><span class="radio_text">男</span></div>');
			headerDom.push('<div><span class="radio_icon fa fa-circle-o"></span><span class="radio_text">女</span></div>');
		headerDom.push('</div>')		
		headerDom.push('<li>');
		
		headerDom.push('</ul>');

		$page.find('.header').html(headerDom.join(''));
	};
	
	function _bindUserHeaderEvent($page){
		$page.on('click','.radio_icon',function(){
			var $this = $(this);
			var $parent = $this.parent();
			if(!$parent.hasClass('js-active')){
				$parent.addClass('active');
				$this.removeClass('fa-circle-o').addClass('fa-dot-circle-o');
				$parent.siblings().removeClass('active').find('.radio_icon').removeClass('fa-dot-circle-o').addClass('fa-circle-o');
			}
		});
	};
	
	function _initUserBody($page){
//		var bodyDom = [];
//		bodyDom.push('<div class="grid_title">');
//			bodyDom.push('<div><span>用户名</span></div>');
//			bodyDom.push('<div><span>姓名</span></div>');
//			bodyDom.push('<div><span>部门</span></div>');
//			bodyDom.push('<div><span>角色</span></div>');
//			bodyDom.push('<div><span>注册时间</span></div>');
//			bodyDom.push('<div><span>注销时间</span></div>');
//			bodyDom.push('<div><span>是否有效</span></div>');
//			bodyDom.push('<div><span>操作</span></div>');
//		bodyDom.push('</div>');
		
		
		
//		$page.find('.body').html(bodyDom.join(''));
		
		var gridOption = {
				columns: [
	                { display: '主键', name: 'id', width: 50,type:'int' },
	                { display: '用户名', name: 'name', width: 150 ,editor: { type: 'text' }},
	                { display: '账号', name: 'account', width: 150 ,editor: { type: 'text' }},
	                { display: '部门', name: 'depart', width: 250,editor: { type: 'text' } },
	                { display: '角色', name: 'role', width: 250,editor: { type: 'text' } },
	                { display: '操作', isSort: false, width: 120, render: function (rowdata, rowindex, value)
	                    {
	                        var h = "";
	                        if (!rowdata._editing)
	                        {
	                            h += '<span data_index="'+rowindex+'" class="row_operate row_edit">修改</span>';
	                            h += '<span data_index="'+rowindex+'" class="row_operate row_del">删除</span>';
	                        }
	                        else
	                        {
	                            h += "<a href='javascript:endEdit(" + rowindex + ")'>提交</a> ";
	                            h += "<a href='javascript:cancelEdit(" + rowindex + ")'>取消</a> "; 
	                        }
	                        return h;
	                    }
	                 }
	                
	                
	                ],
	            data : {
	            	Rows  : [
	            		{id:1,name:'张三',account:'test001',depart:'行政部门',role:'系统管理员'},
	            		{id:2,name:'李四',account:'test002',depart:'行政部门',role:'普通用户'},
	            		{id:3,name:'王二',account:'test003',depart:'行政部门',role:'普通用户'},
	            		{id:4,name:'麻子',account:'test004',depart:'行政部门',role:'普通用户'},
	            		{id:5,name:'张三',account:'test001',depart:'行政部门',role:'系统管理员'},
	            		{id:6,name:'李四',account:'test002',depart:'行政部门',role:'普通用户'},
	            		{id:7,name:'王二',account:'test003',depart:'行政部门',role:'普通用户'},
	            		{id:8,name:'麻子',account:'test004',depart:'行政部门',role:'普通用户'},
	            		{id:9,name:'张三',account:'test001',depart:'行政部门',role:'系统管理员'},
	            		{id:10,name:'李四',account:'test002',depart:'行政部门',role:'普通用户'},
	            		{id:11,name:'王二',account:'test003',depart:'行政部门',role:'普通用户'},
	            		{id:12,name:'麻子',account:'test004',depart:'行政部门',role:'普通用户'},
	            		{id:13,name:'张三',account:'test001',depart:'行政部门',role:'系统管理员'},
	            		{id:14,name:'李四',account:'test002',depart:'行政部门',role:'普通用户'},
	            		{id:15,name:'王二',account:'test003',depart:'行政部门',role:'普通用户'},
	            		{id:16,name:'麻子',account:'test004',depart:'行政部门',role:'普通用户'}
	            		],
	            	Total :400
	            },
	            usePager : true,
	            enabledEdit :true,
	            onSelectRow: function (rowdata, rowindex){
	                   $("#txtrowindex").val(rowindex);
	            },
	            rownumbers:true,
	            page:3,
	            pageSize:5,
	            pageSizeOptions :[5,10,25,50,100]
		};
		
		var gridManager = $("#demo").ligerGrid(gridOption);
		gridManager = $("#demo").ligerGrid(gridOption)
		page.config.gridManager = gridManager;
	};
	
	function _bindUserBodyEvent($page){
		$page.on('click','.row_edit',function(){
			var $this = $(this);
			debugger;
			page.config.gridManager.beginEdit(0);
		})
	};
	
	function _exit(){
		
	};
	
});