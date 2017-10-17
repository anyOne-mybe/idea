;(function($){
	function Pager(option){
		this.initPager = initPager;
		this.config = {
			currentPage : null,
			pageSize : null,
			total    : null,
			totalPages : null
		}
	};
	
	function initPager(option){
		var self = this;
		self.option = option;
		_initConfig(self,option);
		
		var pageDom = [];
		pageDom.push('<div class="pager_widget">');
			pageDom.push('<div class="widget_items">');
			pageDom.push('</div>');
			pageDom.push('<div class="page_select">');
			pageDom.push('<input class="page_in"></input>');
			pageDom.push('<span class="page_go">Go</span>');
			pageDom.push(_getSelectDom(option.optionValues,option.optionValue));
			pageDom.push('</div>');
		pageDom.push('</div>');
		
		var $target = option.target;
		$target.html(pageDom.join(''));
		$target.find('.widget_items').pagination(option);
		
		_bindPagerEvent(self,$target);
	};
	
	function _getSelectDom(optionValues,value){
		var selectDom = [],
			item = null;
		selectDom.push('<select>');
		
		for(var i = 0; i < optionValues.length; i++){
			item = optionValues[i];
			if(item === value){
				selectDom.push('<option value="'+item+'" selected="selected">'+item+'</option>');
			}else{
				selectDom.push('<option value="'+item+'">'+item+'</option>');
			}
		}
		selectDom.push('</select>');
		
		return selectDom.join('');
	};
	
	function _initConfig(self,option){
		
	};
	
	function _bindPagerEvent(self,$target){
		var option = self.option;
		$target.on('click','.page_go',function(){
			var $this = $(this);
			var option = self.option;
			var value = $target.find('.page_in').val();
			option.currentPage = Number(value);
			$target.find('.widget_items').pagination(option);
			
			var pageSize = $target.find('select').val();
			option.callback(value,pageSize);
		});
		
		$target.on('change','select',function(){
			var pageSize = $target.find('select').val();
			option.callback(1,pageSize);
		});
	};
	
	$.fn.Pager = Pager;
})(jQuery);