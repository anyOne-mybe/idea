(function($, window, document, undefined) {
	//定义分页类
	function Paging(element, options) {
		this.element = element;
		//传入形参
		this.options = {
			pageNo: options.pageNo||1,
			totalPage: options.totalPage,
			totalSize:options.totalSize,
			pageSize : options.pageSize,
			callback:options.callback
		};
		//根据形参初始化分页html和css代码
		this.init();
	}
	//对Paging的实例对象添加公共的属性和方法
	Paging.prototype = {
		constructor: Paging,
		init: function() {
			this.creatHtml();
			this.bindEvent();
		},
		creatHtml: function() {
			var me = this;
			var content = "";
			var current = me.options.pageNo;
			var total = me.options.totalPage;
			var totalNum = me.options.totalSize;
			//content += "<a id=\"firstPage\">首页</a><a id='prePage'><</a>";
			content += '<div class="idea_page"><a id="prePage"><</a>';
			//总页数大于6时候
			if(total > 6) {
				//当前页数小于5时显示省略号
				if(current < 5) {
					for(var i = 1; i < 6; i++) {
						if(current == i) {
							content += "<a class='current'>" + i + "</a>";
						} else {
							content += "<a>" + i + "</a>";
						}
					}
					content += ". . .";
					content += "<a>"+total+"</a>";
				} else {
					 //判断页码在末尾的时候
					if(current < total - 3) {
						for(var i = current - 2; i < current + 3; i++) {
							if(current == i) {
								content += "<a class='current'>" + i + "</a>";
							} else {
								content += "<a>" + i + "</a>";
							}
						}
						content += ". . .";
						content += "<a>"+total+"</a>";
					//页码在中间部分时候	
					} else {
						content += "<a>1</a>";
						content += ". . .";
						for(var i = total - 4; i < total + 1; i++) {
							if(current == i) {
								content += "<a class='current'>" + i + "</a>";
							} else {
								content += "<a>" + i + "</a>";
							}
						}
					}
				}
				//页面总数小于6的时候
			} else {
				for(var i = 1; i < total + 1; i++) {
					if(current == i) {
						content += "<a class='current'>" + i + "</a>";
					} else {
						content += "<a>" + i + "</a>";
					}
				}
			}
			content += "<a id='nextPage'>></a>";
			//content += "<a id=\"lastPage\">尾页</a>";

			//页码选择
			content += _createPageSelect(me);

			content += "<span class='totalPages'><span>"+total+"</span>页 </span>";
			content += "<span class='totalSize'><span>"+totalNum+"</span>条记录 </span></div>";
			me.element.html(content);
		},
		//添加页面操作事件
		bindEvent: function() {
			var me = this;
			me.element.off('click', 'a');
			me.element.on('click', 'a', function() {
				var num = $(this).html();
				var id=$(this).attr("id");
				if(id == "prePage") {
					if(me.options.pageNo == 1) {
						me.options.pageNo = 1;
					} else {
						me.options.pageNo = +me.options.pageNo - 1;
					}
				} else if(id == "nextPage") {
					if(me.options.pageNo == me.options.totalPage) {
						me.options.pageNo = me.options.totalPage
					} else {
						me.options.pageNo = +me.options.pageNo + 1;
					}

				} else if(id =="firstPage") {
					me.options.pageNo = 1;
				} else if(id =="lastPage") {
					me.options.pageNo = me.options.totalPage;
				}else{
					me.options.pageNo = +num;
				}
				me.creatHtml();
				if(me.options.callback) {
					me.options.callback(me.options.pageNo,me.options.pageSize);
				}
			});

			me.element.on('change','.page_select_box select',function(){
				var pageSize = $(this).val();
				me.options.pageNo = 1;
				me.options.pageSize = parseInt(pageSize);
				me.creatHtml();
				if(me.options.callback) {
					me.options.callback(me.options.pageNo,me.options.pageSize);
				}
			});

			me.element.on('click','.go_page',function(){
				debugger;
				var pageNum = $(this).parent().find('.go_in').val().trim();
				if(pageNum.length <=0 || isNaN(pageNum)){
					$(this).parent().find('.go_in').val('');
					return;
				}
				pageNum = parseInt(pageNum);

				if(pageNum <= 1){
					pageNum = 1;
				}
				if(pageNum >= me.options.totalPage){
					pageNum = me.options.totalPage;
				}

				me.options.pageNo = pageNum;
				me.creatHtml();
				if(me.options.callback) {
					me.options.callback(me.options.pageNo,me.options.pageSize);
				}
			});
		},
		setPageInfo(totalPage,totalNum){
			var me = this;
			me.element.find('.totalPages>span').html(totalPage);
			me.element.find('.totalSize>span').html(totalNum);
		}
	};

	function _createPageSelect(me){
		debugger;
		var options = me.options,
			selects = options.selects || [5,10,20,50,100],
			value = options.pageSize || 20,
			item = null;
		var dom = [];
		dom.push('<div class="page_op_container">');

		dom.push('<div class="page_select_box">')
		dom.push('<select>');
		for(var i = 0; i < selects.length; i++){
			item = selects[i];
			if(value === item){
				dom.push('<option value="'+item+'" selected="selected">'+item+'</option>');
			}else{
				dom.push('<option value="'+item+'">'+item+'</option>');
			}
		}
		dom.push('</select>');
		dom.push('</div>');

		dom.push('<div class="page_input_box">');
		dom.push('<input class="go_in"/>');
		dom.push('<span class="go_page">go</span>');
		dom.push('</div>');

		dom.push('</div>');

		return dom.join('');
	};
	//通过jQuery对象初始化分页对象
	$.fn.paging = function(options) {
		return new Paging($(this), options);
	}
})(jQuery, window, document);