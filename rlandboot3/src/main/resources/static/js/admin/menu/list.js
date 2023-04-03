Vue
.createApp({
	data(){
		return{
			test:"hello",
			//모델을 준비해
			list: [
				{id:1,
				name:"아메리카노",
				price:5000
				},
				{id:2,
				name:"카페라떼",
				price:5500
				},
				// {id:3,
				// name:"카페모카",
				// price:5500
				// },
			],
			isShowRegForm:true,
			menu:{name:"우좌진", price:9900},
		};
	},

	//인스턴스의 행위
	methods:{
		//이름설정하고 핸들러 받기!
		 categoryClickHandler(e){
			this.list.push({id:4, name:"디카 아메", price:5000})
		},

		load(cid){
			let promise = fetch("/menus");
			promise //그래서 promise에다가 함수를 담아주자!
			.then(qq => {

				return qq.json();
			})
			.then(list =>{
				// return ww[0];
				console.log("list 넣는 시점")
				this.list = list;
			})
			// .then(ee =>{
			// 	console.log(ee.name);
			// })
			.catch(error=>{
				console.log("12345678987654321");
				console.log(error);
			})
			
		},

		menuAddHandler(e){
			// this.list.push({id:4, name:"디카 아메", price:5000})
			// this.isShowRegForm = (this.isShowRegForm == true)? false : true;
			this.isShowRegForm = !this.isShowRegForm;
			console.log("메뉴 show");
			
		},

		menuSaveHandler(e){
			var myHeaders = new Headers();
			myHeaders.append("Content-Type", "application/json");

			var raw = JSON.stringify(this.menu)

			var requestOptions = {
			method: 'POST',
			headers: myHeaders,
			body: raw,
			redirect: 'follow'
			};

			fetch("http://localhost:8080/menus?", requestOptions)
			.then(response => response.text())
			.then(result => {
				if(result ==="OK")
					this.load();
				// console.log(result);
				// result;
				})
			.catch(error => console.log('error', error));
			
		}


	},

	//위 옵션들과 동급이여서 여기에 두는거야!
	beforeCreate(){console.log("beforeCreate")},
    created(){console.log("created")},
    beforeMount(){console.log("beforeMount")},
    mounted(){
	
		this.load();
		console.log("mounted")
	},
    beforeUpdate(){console.log("beforeUpdate")},
    updated(){console.log("updated")},
    beforeUnmount(){console.log("beforeUnmount")},
    unmounted(){console.log("unmounted")}

})
.mount("#main-section");