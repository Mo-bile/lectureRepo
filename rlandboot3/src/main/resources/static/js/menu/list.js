window.addEventListener("load",function(){
	
	let ul = document.querySelector(".menu-category>ul");

	ul.onclick = function(e){
		e.preventDefault();
	// addeventList 이거는 누적할 때 쓰는거야!
	// 람다 쓰는게 아냐 왜냐하면 지역화를 못해 
		//일부로 지역변수 쓰고싶지않을 때쓴다
		
		let tagName = e.target.tagName;
		
		console.log(tagName);
	
		
//		if(!(tagName == 'LI' || tagName == 'A'))
		if(tagName != 'LI' && tagName != 'A') //li 가 아니면 return;
			return; //두가지 조건 만족시 본 함수에서 나가게해서 못쓰게 해
		
		let el = (tagName === 'LI')? e.target : e.target.parentNode;
		console.log(el);
		
//		let queryString = "";	
			
//		console.log("clicked"); //return 안되면 본 내용 이해하게끔
		
		
		let categoryId = el.dataset.cid;
		
		const request = new XMLHttpRequest();
		
		request.onload = function(){
			let menus = JSON.parse(request.responseText)
			
			console.log(menus[0]);
		}
		request.open("GET", `http://localhost:8080/menus?c=${categoryId}`,true); //브라우저에서 url을 입력하는것과 같은 요
		request.send(); //
	};
	
})