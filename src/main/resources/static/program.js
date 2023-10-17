import ajax1 from './ajax.js'
//主页右侧替换(流量界面)
let MBRl = {//MagicBoardReplacement  MBRL  魔板替换
    //在这里写html代码
    html: `
<style>
    body {
        background-image: url("images/节目单.jpg");
        background-size: cover;
        font-family: Arial, sans-serif;
        padding: 20px;
        background-size:100% 100%;
        margin: 0 auto;
        width:100vh;
        height:100vh;
    }
    li{
      list-style: none;
      font-size:35px;
      font-family: LiSu;
      line-height:80px;
      color: #1f4e79;
    }
    .a1{
      position:absolute;
      left:120px;
      top: 150px;
    }
    .b1{
      position:absolute;
      left:650px;
      top: 150px;
    }
  </style>
</head>
<body class="page-body">
  <div class="main-content" id="indexHtml1">


  </div>
  <div class="a1" >
    <ul id="a1">
<!--      <li class="fenshu">一、当那一天来临<span value="" ></span></li>-->
<!--      <li class="fenshu">二、歌唱祖国<span value="总分:" ></span></li>-->
<!--      <li class="fenshu">三、强军战歌<span value="总分:" ></span></li>-->
<!--      <li class="fenshu">四、少年<span value="总分:" ></span></li>-->
<!--      <li class="fenshu">五、琵琶行<span value="总分:" ></span></li>-->
    </ul>
  </div>
  <div class="b1" >
    <ul id="b1">
<!--      <li name="fenshu">六、如果我们不曾相遇<span value="总分:" ></span></li>-->
<!--      <li name="fenshu">七、看得最远的地方<span value="总分:" ></span></li>-->
<!--      <li name="fenshu">八、巡光<span value="总分:" ></span></li>-->
<!--      <li name="fenshu">九、逆风生长<span value="总分:" ></span></li>-->
<!--      <li name="fenshu">十、少年中国说<span value="总分:" ></span></li>-->
    </ul>
  </div>
</body>
     `,

    //在这里进行操作
    htmlMagic: async function (document1,promise) {
        document1.getElementById("indexHtml1").innerHTML = this.html; //需要跳转的地址

        console.log(promise)
        if(promise==undefined){
            return;
        }
        console.log(promise.data.seiect)

        let cs=["一","二","三","四","五","六","七","八","九","十"];
           let a1= document.getElementById("a1");
          let b1=  document.getElementById("b1");
            a1.innerHTML="";
            b1.innerHTML="";
          // for(let i=0;i<5;i++){
          //     let sum;
          //     if(!promise.data.data[i].aBoolean){
          //         sum="";
          //     }else{
          //         sum=promise.data.data[i].grade.toFixed(2);
          //     }
          //     a1.innerHTML+=`<li class="fenshu">${cs[i]}、${promise.data.data[i].name}<span style="margin-left: 50px;color: red;" >${sum}</span></li>`;
          // }
          //
          // for(let i=5;i<10;i++){
          //     let sum;
          //     if(!promise.data.data[i].aBoolean){
          //         sum="";
          //     }else{
          //         sum=promise.data.data[i].grade.toFixed(2);
          //     }
          //     b1.innerHTML+=`<li class="fenshu" >${cs[i]}、${promise.data.data[i].name}<span style="margin-left: 50px;color: red;" >${sum}</span></li>`;
          // }
        for(let i=0;i<10;i++){
            let sum;
            let st="";
            if(!promise.data.data[i].aBoolean){
                sum="";
            }else{
                sum=promise.data.data[i].grade.toFixed(2);
            }
            if((promise.data.seiect-1)===i){
                st="font-weight: bold;color: red"
            }



            if(i<5){
                a1.innerHTML+=`<li class="fenshu" style="${st}">${cs[i]}、${promise.data.data[i].name}<span style="margin-left: 50px;color: red;" >${sum}</span></li>`;
            }else{
                b1.innerHTML+=`<li class="fenshu" style="${st}">${cs[i]}、${promise.data.data[i].name}<span style="margin-left: 50px;color: red;" >${sum}</span></li>`;
            }

        }

        // style="color: red"
        // console.log(a1.getElementsByClassName("fenshu")[0])
        // console.log(a1)



        // let  programList= document1.getElementById("programList")
        // programList.innerHTML="";
        // console.log("11")
        // document1.getElementById("userName").innerText=promise.data.userName;

        // .program-list li:hover {
        //         background-color: rgb(233, 159, 112);
        //     }
        // for (let program of promise.data.data){
        //     if(program.aBoolean===false){
        //         // console.log(promise.data.seiect+"    "+program.id+"    "+promise.data.seiect==program.id)
        //
        //         // console.log("当前:"+promise)
        //         // console.log(promise)
        //         // console.log(promise.data.data)
        //         //
        //         if(promise.data.seiect===program.id){
        //             console.log("是")
        //             programList.innerHTML+=`
        //                  <ul class="program-list"  id="programList" style="background-color:red">
        //                     <li class="active" style="background-color:rgb(233, 159, 112)">
        //                         <span id=""  class="program-name">${program.id}. ${program.name}</span>
        //                     </li>
        //                  </ul>`;
        //         }else{
        //             programList.innerHTML+=`
        //              <ul class="program-list" id="programList">
        //                 <li class="active">
        //                     <span id="" class="program-name">${program.id}. ${program.name}</span>
        //                 </li>
        //              </ul>`;
        //
        //         }
        //
        //     }else{
        //         programList.innerHTML+=`
        //          <ul class="program-list" id="programList">
        //             <li class="active">
        //                 <span id="" class="program-name">${program.id}. ${program.name}<span style="float: right">评分:${program.grade.toFixed(2)}</span></span>
        //             </li>
        //          </ul>`;
        //     }
        //
        // }
        console.log(promise)
        // let promise = await ajax1.ajaxPromise("song/timerFrom", "get", "",$);
        // console.log(promise)
    }


};


export default MBRl;
