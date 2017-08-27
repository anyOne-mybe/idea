Idea.Model.define('Idea.systemManage.menue',function(page){
	page.ready = _ready;
	
	page.exit = _exit;
	
	function _ready(){
		_initMenuePage();
	};
	
	function _initMenuePage(){
		var $page = $('#menue_page');
		
		_initMenueTree($page);
	};
	
	function _initMenueTree($page){
		var treeOption = {
			columns : [
				{id: 'id1',display:'栏目',name:'name'},
				{display:'URL',name:'url'},
				{display:'排序',name:'sort'}
			],
			data : {Rows:_getMenueTreeOption()},
			tree: { columnId: 'id1' },
			enabledEdit :true,
		};
		
		$page.find('.body').ligerGrid(treeOption);
	};
	
	function _getMenueTreeOption(){
		var menueNodes = workspaceVO.menueNodes || [],
			node = null,
			treeNodes = [];
		for(var i = 0; i < menueNodes.length; i++){
			node = menueNodes[i];
			if(node.parentId === undefined){
				treeNodes.push(node);
			}
		}
		
		return treeNodes;
	};
	
	function _getLevel1Menues(){
		
	};
	
	
	function _exit(){
		
	};
});