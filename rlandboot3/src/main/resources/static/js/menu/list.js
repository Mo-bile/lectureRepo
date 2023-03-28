window.addEventListener("load",function(){
	
	const menuList = document.querySelector(".menu-list");
	let ul = document.querySelector(".menu-category>ul");
	const form = document.querySelector(".search-header form");
	const findbutton = form.querySelector(".icon-find");

	console.log(form);

	findbutton.onclick = function(e){
		e.preventDefault();

		const queryInput = form.querySelector("input[name=q]");
		console.log(queryInput.value);
		let query = queryInput.value;

		const request = new XMLHttpRequest();
		request.onload = function(){
			let menus = JSON.parse(request.responseText)
			console.log(menus);
			bind(menus);
		}
		request.open("GET", `http://localhost:8080/menus?q=${query}`,true); //브라우저에서 url을 입력하는것과 같은 요
		request.send(); //
	}

	ul.onclick = function(e){
		e.preventDefault();
	// addeventList 이거는 누적할 때 쓰는거야!
	// 람다 쓰는게 아냐 왜냐하면 지역화를 못해 
		//일부로 지역변수 쓰고싶지않을 때쓴다
		
		let tagName = e.target.tagName;
		
		//console.log(tagName);
	
		
//		if(!(tagName == 'LI' || tagName == 'A'))
		if(tagName != 'LI' && tagName != 'A') //li 가 아니면 return;
			return; //두가지 조건 만족시 본 함수에서 나가게해서 못쓰게 해
		
		let el = (tagName === 'LI')? e.target : e.target.parentNode;
		
		let curLi = ul.querySelector("li.menu-selected");
		if(curLi === el){
			return;
		}
		curLi.classList.remove("menu-selected");
		el.classList.add("menu-selected");

		console.log(el.dataset.cid);
		
//		let queryString = "";	
		
//		console.log("clicked"); //return 안되면 본 내용 이해하게끔
		let categoryId = el.dataset.cid;
		
		const request = new XMLHttpRequest();
		request.onload = function(){
			let menus = JSON.parse(request.responseText)
			console.log(menus);
			bind(menus);
		
		};
		request.open("GET", `http://localhost:8080/menus?c=${categoryId}`,true); //브라우저에서 url을 입력하는것과 같은 요
		request.send(); //
	};
	

	//bind를 추가해주는거야!
	// list를 받아서 출력해주는 함수
	function bind(menus){

			//기존 목록을 모두 지우고
			//menuList.children[0].remove;
			
			//기존목록을 지우고 목록을 지우는 방법1
			//while(menuList.removeChild(menuList.firstElementChild)){
			//menuList.removeChild(menuList.firstElementChild);
			//}
			//menuList.replaceChildren();
			
			//기존목록을 지우고 목록을 지우는 방법2
			//menuList.textContent = "<span style ='color:blue'>test hello</span>";
			//menuList.innerText = "<span style ='color:blue'>test hello</span>";
			//menuList.innerHTML = "<span style ='color:blue'>test hello</span>";
			menuList.innerHTML = "";
			
			//목록을 만들어 채우기
			//방법1 : DOM객체를 직접 생성해서 채우기
			
	            
//			let menuSection = document.createElement("section");
//			menuList.className = "menu";
//			
//			let form = document.createElement("from");
//			form.className = ""; //왜 ""?
//			
////			menuSection.appendChild(form); //노드 인터페스 이용한 방법
//			menuSection.append(form);// 엘레먼트 인터페이스 이용방법
//			menuList.append(menuSection);
			
			//방법2 : 문자열을 이용한 객체생성 
			
			for(let menu of menus){
			
			let template =`
	            <section class="menu">
		                <form class="">
		                    <h1>${menu.name}/<span>(${menu.categoryName})</span></h1> 
		                    <div class="menu-img-box">
		                        <a href="detail"><img class="menu-img" src="/image/product/${menu.img}"></a>
		                    </div>    
		                    <div class="menu-price">${menu.price}</div>
		                    <div class="menu-option-list">
		                        <span class="menu-option">
		                            <input class="menu-option-input" type="checkbox">
		                            <label>ICED</label>
		                        </span>            
		                        <span class="menu-option ml-2">
		                            <input class="menu-option-input" type="checkbox">
		                            <label>Large</label>
		                        </span>
		                    </div>
		                    <div class="menu-button-list">
		                        <input class="btn btn-fill btn-size-1 btn-size-1-lg" type="submit" value="담기">
		                        <input class="btn btn-line btn-size-1 btn-size-1-lg ml-1" type="submit" value="주문하기">
		                    </div>
		                </form>
		            </section>`;
            // menuList.innerHTML += template;
			menuList.insertAdjacentHTML("beforeend",template);
			}
	}
})