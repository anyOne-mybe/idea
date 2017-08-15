;$(function(){
	//初始化Idea上下文
	initIdeaContext();
	
	function initIdeaContext(){
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
		var nodeDom = [];
		nodeDom.push('<div class="nav_item"><span class="nav_name">'+node.name);
		nodeDom.push('</span></div>');
		
		var $node = $(nodeDom.join(''));
		$node.data('value',node).appendTo($menuedDoms);
	};
	
	function _bindMenueEvent($menuedDoms){
		$menuedDoms.on('click','.nav_item',function(e){
			var $this = $(this);
			Idea.Page.forward($this.data('value').url);
		});
		
		$menuedDoms.on('mouseenter','.nav_item',function(e){
			debugger;
			var $this = $(this);
			var data = $this.data('value');
			//展示子菜单
			_showSunMenues($this,data);
			
//			Idea.Page.forward($this.data('value').url);
		});
		
		$menuedDoms.on('mouseleave','.nav_item',function(e){
			debugger;
			var $this = $(this);
			var data = $this.data('value');
			//展示子菜单
			_hideSunMenues($this,data);
			
//			Idea.Page.forward($this.data('value').url);
		});
	};
	
	function _showSunMenues($menue,node){
		if($menue.find('.sub_menue_container').length <= 0){
			var subDom = [],
			children = node.children || [],
			subNode = null;
			subDom.push('<div class="sub_menue_container">');
			for(var i = 0; i < children.length; i++){
				subNode = children[i];
				subDom.push('<div class="sub_item">'+subNode.name+'</div>');
			}
			subDom.push('</div>');
			
			$menue.append(subDom.join(''));
		}else{
			$menue.find('.sub_menue_container').removeClass('idra_hide');
		}
	};
	
	function _hideSunMenues($menue,node){
		$menue.find('.sub_menue_container').addClass('idra_hide');
	};
	
	
	
	
});