Vue
.createApp({
	data(){
		return{
			test:"hello"
		};
	},

	//인스턴스의 행위
	methods:{
		//이름설정하고 핸들러 받기!
		 categoryClickHandler(e){
		// 	this.load(e.target.dataset.id, function(){
		// 		console.log("데이터 도착?");
		// 	});
		// console.log("click");
		// await this.load(e.target.dataset.id); //기다릴테니까 난 기다렸다가 할거야 -> 동기형으로
		// console.log("데이터가 도착 한 후에 할일");
		//데이터를 요청하고 그 요청이 도착하면 할 일이 여기있는거야
		// 그런데, 도착하기 전에 실행되는... 불상사

			this.load(2);
		},

//비동기식 promise 방법
		// async load(cid){
		// 	let response = await fetch("/menus");
		// 	let list = await response.json();
		// 	console.log(list);

		// //옛날에 쓰던 콜백방식을 한것
		// 	// return new Promise(resolve=>{
		// 	// 	// async load(cid){
		// 	// 	// load(cid, callback){
		// 	// 		//콜백함수를 사용하는 request객체의 send();
		// 	// 	setTimeout(() => {
		// 	// 		console.log("load");
		// 	// 		// callback();
		// 	// 	}, 3000);
		// 	// });
		// 	//XHR (XmlHttpRequest)
		// 	//-callback을 이용한 비동기처리

		// 	//Fetch API
		// 	//-promise 이용한 비동기처리
		// }

//동기식
//이방식은 단계별로 하는거야
		load(cid){
											//이 함수를 이렇게 하는건 불편해
											//따로 담을 그릇 만들겠다고
											//이게 promise야!
			// let promise = fetch("/menus", function(response) {console.log("도착?")});
			
			
			//콜백 주워담는걸 만들자 이게 promise의 또 다른 방식이야
			let promise = fetch("/menus99");
			promise //그래서 promise에다가 함수를 담아주자!
			.then(qq => {

				// console.log(qq.json());
				return qq.json();
				// console.log("도착했니?");
				// let promise = qq.json();
				// promise
				// .then(ww=>{
				// 	console.log(ww);
				// })
			})
			.then(ww =>{
				// console.log(ww);
				// console.log(ww[0]);
				return ww[0];
			})
			.then(ee =>{
				console.log(ee.name);
			})
			.catch(error=>{
				console.log("12345678987654321");
				console.log(error);
			})
			
			// , function() {console.log("도착?")});
		}
	}


})
.mount("#main-section");