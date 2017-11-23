;$(function(){
	// 初始化Idea上下文
	initIdeaContext();
	
	function initIdeaContext(){
		// 1.获取基础信息，用户、权限、菜单
		_initWorkspaceVO();
		
		_bindPageEvent();
	};
	
	function _bindPageEvent(){
		$('body').on('click','.nav.level1',function(){
			$('.nav_crumbs').empty();
			Idea.Page.forward('home.html');
			
			$('#menueTree>li').removeClass('active');
		})
	};
	
	function _initWorkspaceVO(){
		Idea.Core.ajax({
			url  : "idea/buildEnvironment",
			type : 'GET',
			success : function(response){
				window['workspaceVO'] = response;
				
				_forward();
				
				_initIdeaEnvironment(response);
			}
		});
	};
	
	function _forward(){
		var hash = (location.hash || '').slice(2);
		if(hash){
			Idea.Page.forward(hash);
		}else{
			Idea.Page.goHome('home.html');
		}
	};
	
	function _initIdeaEnvironment(response){
		_initLogo();
		
		_initMenues(response.menueNodes);
	};
	
	function _initLogo(){
		$('#idea_nav').append('<div class="idea_logo"></div>');
		$('#idea_nav').append('<div class="nva_container">多维组织数据平台</div>');
		
		$('body').on('click','.idea_logo',function(){
			Idea.Page.forward('home.html');
		});
	};
	
	function _initMenues(menueNodes){
		var node = null,
			$leftDoms = $('.idea_view_item.left');
		$leftDoms.append('<div id="menueTree" class="menue_container ztree"></div>');
		$menuedDoms = $leftDoms.find('.menue_container');
		
		var setting = _getMenueTreeSetting();
		var zNodes = menueNodes;
		$.fn.zTree.init($menuedDoms, setting, zNodes);
	};
	
	function _getMenueTreeSetting(){
		var setting = {
			view: {
				showLine: false,
				showIcon: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback : {
				onClick : _clickMenue
			}
		};
		
		return setting;
	};
	
	function _clickMenue(event, treeId, treeNode){
		Idea.Page.forward(treeNode.hash);
		
		_updateNavTitle(treeNode.name);
		
		var $currentLi = $('#'+treeNode.tId);
		$currentLi.addClass('active').siblings().removeClass('active');
	};
	
	function _updateNavTitle(name){
		document.title = '多维组织架构-' + name;
		
		var $nav = $('#idea_crumbs');
		var dom = [];
		dom.push('<div>');
		dom.push('<span class="nav level1">首页</span>');
		dom.push('<span class="nav">></span>');
		dom.push('<span class="nav level2 disable">'+name+'</span>');
		dom.push('</div>');
		
		$nav.html(dom.join(''))
	};
	
	function addMenue(node,$menuedDoms){
		var nodeDom = [];
		nodeDom.push('<div class="nav_item"><span class="nav_name" data_hash="'+node.url+'">'+node.name);
		nodeDom.push('</span>');
		var children = node.children || [],
		subNode = null;
		nodeDom.push('<div class="sub_menue_container">');
		for(var i = 0; i < children.length; i++){
			subNode = children[i];
			nodeDom.push('<div class="sub_item"><span class="nav_name" data_hash="'+subNode.url+'">'+subNode.name+'</span></div>');
		}
		nodeDom.push('</div>');
		
		nodeDom.push('</div>');
		
		var $node = $(nodeDom.join(''));
		$node.data('value',node).appendTo($menuedDoms);
	};
	
	function _bindMenueEvent($menuedDoms){
		$menuedDoms.on('click','.nav_name',function(e){
			var $this = $(this);
			$menuedDoms.find('.nav_name').removeClass('active');
			$this.addClass('active');
			var url = $this.attr('data_hash');
			if(url){
				Idea.Page.forward(url);
			}
		});
		
		$menuedDoms.on('mouseenter','.nav_item',function(e){
			var $this = $(this);
			var data = $this.data('value');
			// 展示子菜单
			_showSunMenues($this,data);
		});
	};
	
	function _showSunMenues($menue,node){
		var $target = $menue.find('.sub_menue_container');
		if(node.children && node.children.length > 0){
			var width = $target.outerWidth();
			$target.css({left:-(width/2) + $menue.outerWidth()/2})
		}else{
			$target.remove();
		}
	};
});