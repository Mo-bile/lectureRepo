Vue
.createApp({ //이거는 객체야 함수나 속성이 들어가! //mount를 조작할거야

    data(){

        let x = 20;
        let y = 30;
        let z = 0;

        return{x,y,z}; //이게 모델이야
    }, //객체는 함수 담을 때 쉼표만 추가하면 돼
    
    methods : {
        calcHandler(e){
            // this.z = parseInt( this.x) + parseInt( this.y);   
            this.z = parseInt( this.x) +  this.y;   
            // console.log(z);
            console.log("hello");
        },
        resetHandler(e){
            console.log("reset");
        }

    }
    

})
.mount("#calc"); // 뷰 영역을 의미해
