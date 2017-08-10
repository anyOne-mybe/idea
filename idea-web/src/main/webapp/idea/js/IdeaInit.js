;(function(){
	//初始化Idea上下文
	initIdeaContext();
	
	function initIdeaContext(){
		//1.获取基础信息，用户、权限、菜单
		_initWorkspaceVO();
	};
	
	function _initWorkspaceVO(){
		debugger
		Idea.Core.ajax({
			url  : "services/idea/base/workspace",
			type : 'GET',
			success : function(response){
				debugger;
			}
		});
	};
})();