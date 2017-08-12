;$(function(){
	//初始化Idea上下文
	initIdeaContext();
	
	function initIdeaContext(){
		debugger;
		var hash = (location.hash || '').slice(2);
		if(hash){
			Idea.Page.forward(hash);
		}
		
		//1.获取基础信息，用户、权限、菜单
		_initWorkspaceVO();
	};
	
	function _initWorkspaceVO(){
		Idea.Core.ajax({
			url  : "idea/buildEnvironment",
			type : 'GET',
			success : function(response){
				_initIdeaEnvironment(response);
			}
		});
	};
	
	function _initIdeaEnvironment(response){
		_initMenues(response.menueNodes);
	};
	
	function _initMenues(menueNodes){
		var node = null,
			$menuedDoms = $('<div class="nva_container"></div>');
		
		for(var i = 0; i < menueNodes.length; i++){
			node = menueNodes[i];
			addMenue(node,$menuedDoms);
		}
		
		$('#idea_nav').append($menuedDoms);
		
		_bindMenueEvent($menuedDoms);
	};
	
	function addMenue(node,$menuedDoms){
		var $node = $('<div class="nav_item">'+node.name+'</div>');
		$node.data('value',node).appendTo($menuedDoms);
	};
	
	function _bindMenueEvent($menuedDoms){
		$menuedDoms.on('click','.nav_item',function(e){
			var $this = $(this);
			Idea.Page.forward($this.data('value').url);
		})
	};
	
	
	
	
});