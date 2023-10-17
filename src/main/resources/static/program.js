import ajax1 from './ajax.js'
//主页右侧替换(流量界面)
let MBRl = {//MagicBoardReplacement  MBRL  魔板替换
    //在这里写html代码
    html: `
<style>
    body {
        background-image: url("节目单.jpg");
        background-size: cover;
        font-family: Arial, sans-serif;
        padding: 20px;
    }

    .container {
        max-width: 700px;
        margin: 0 auto;
    }

    h1 {
        text-align: center;
        font-size: 36px;
        margin-bottom: 30px;
        color: #333;
    }

    .program-list {
        list-style: none;
        padding: 0;
        margin: 0;

    }

    .program-list li {
        /* display: flex; */
        align-items: center;
        justify-content: flex-start;
        /* background-color: #ffffffcc; */
        border-radius: 5px;
        padding: 10px 20px;
        margin-bottom: 10px;
        margin-top: 20px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        /* transition: background-color 0.3s ease; */
    }
    
    .program-list li:hover {
        background-color: rgb(233, 159, 112);
    }
    
        .program-list li:hover {
        background-color: rgb(233, 159, 112);
    }

    .program-list li span {
        font-weight: bold;
    }

    .program-list li .program-index {
        margin-right: 10px;
        width: 30px;
        text-align: center;
        color: #555;
    }

    .program-list li .program-name {
        color: #333;
    }
    /* ul{
        list-style: none;
        margin: 0;
        padding: 0;
        color: white;
    } */
    .active{
        background-color: white;
        color: pink;
    }
    h1{
        font-size: 50px;
        font-family:Georgia, 'Times New Roman', Times, serif;
    }
    .dd{
        /* padding-left: 450px; */
        text-align: center;
        margin-top: 50px;
    }
</style>
    <h1>“同心筑梦   踏歌而行”  节目单</h1>
    <div class="container" id="time">

        <ul class="program-list" id="programList">
            <li class="active">
                <span id="" class="program-name">1.&nbsp;&nbsp;&nbsp;&nbsp;节目名称</span>
            </li>
        </ul>

    </div>
    <div class="dd">
        <h2>江苏省无锡技师学院学生工处主办      信息工程系承办</h2>
        <h3 id="userName"></h3>
        <!-- <h2> </h2> -->
    </div>
     `,

    //在这里进行操作
    htmlMagic: async function (document1,promise) {
        document1.getElementById("indexHtml1").innerHTML = this.html; //需要跳转的地址
      let  programList= document1.getElementById("programList")
        programList.innerHTML="";
        console.log("11")
        document1.getElementById("userName").innerText=promise.data.userName;

        // .program-list li:hover {
        //         background-color: rgb(233, 159, 112);
        //     }
        for (let program of promise.data.data){
            if(program.aBoolean===false){
                // console.log(promise.data.seiect+"    "+program.id+"    "+promise.data.seiect==program.id)

                // console.log("当前:"+promise)
                // console.log(promise)
                // console.log(promise.data.data)
                //
                if(promise.data.seiect===program.id){
                    console.log("是")
                    programList.innerHTML+=`
                         <ul class="program-list"  id="programList" style="background-color:red">
                            <li class="active" style="background-color:rgb(233, 159, 112)">
                                <span id=""  class="program-name">${program.id}. ${program.name}</span>
                            </li>
                         </ul>`;
                }else{
                    programList.innerHTML+=`
                     <ul class="program-list" id="programList">
                        <li class="active">
                            <span id="" class="program-name">${program.id}. ${program.name}</span>
                        </li>
                     </ul>`;

                }

            }else{
                programList.innerHTML+=`
                 <ul class="program-list" id="programList">
                    <li class="active">
                        <span id="" class="program-name">${program.id}. ${program.name}<span style="float: right">分数${program.grade}</span></span>
                    </li>
                 </ul>`;
            }

        }
        console.log(promise)
        // let promise = await ajax1.ajaxPromise("song/timerFrom", "get", "",$);
        // console.log(promise)
    }


};


export default MBRl;
