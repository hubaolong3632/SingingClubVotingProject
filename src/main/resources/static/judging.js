import ajax1 from './ajax.js'

let MBRl = {//MagicBoardReplacement  MBRL  魔板替换
    //在这里写html代码
    html: `

<style>

    body {
        background-image: url("images/xcc.png");
        background-size: cover;
        font-family: Arial, sans-serif;
        /*font-family: "Simsun", Arial, sans-serif;*/
        padding: 20px;
    }
body{
background-color: gray;
}
.index{
margin: auto;
width:950px;
background-color: white;
/*box-shadow:10px 10px 15px black;*/
/*margin-top:500px;*/
}
h1{
color:orange;
padding-top:30px;
text-align:center;
}
form{
padding-left: 100px;
line-height:180%;
}
input{
border-color: black;
border-top-width:0px;
border-right-width:0px;
border-bottom-width:2px;
border-left-width:0px;
}
#btn{
background-color: #FFA500;
color:white;
padding:10px 15px;
margin-left:380px;
margin-top:30px;
margin-bottom: 20px;
font-size: 30px;
text-align: center;
}
#aa{
margin-left: 70px;
}
*{
font-size: 20px;
}
#bb{
font-size: 30px;
font-family: Arial, sans-serif;
}
#name{
font-size:30px;
}
#dd{
text-align: center;
}
#jiemuming{
font-size: 30px;
/*font-family: Georgia;*/
}
#bb{
margin-left: 70px;

}

</style>
<div class="index" style="margin-top: 12%;border-radius: 15px;opacity: 0.7">
<!-- 接口 -->
<h1 id="jiemuming">节目1</h1>
<hr color="orange" width="700px" />
<!--<form method="post" action="URL">-->
                <b id="bb">一、评分规则</b>
    <ol id="aa">
        <li>班主任或任课老师参与表演或指挥。<b>(1分)</b></li>
<!--                        <br />-->
        <li>要求歌曲内容紧扣主题、积极向上，集教育性和艺术性于一体。<b>(2分)</b></li>
<!--                        <br />-->
        <li>声音统一自然，音色优美，吐字清晰，声情并茂、表演完整。<b>(2分)</b></li>
<!--                         <br />-->
        <li>节奏准确,对歌曲有较好的理解，作品处理得当，演唱与指挥、伴奏配合默契。<b>(3分)</b></li>
<!--                         <br />-->
        <li>精神饱满，仪态大方，服装整齐，上场安静有序。<b>(1分)</b></li>
<!--                         <br />-->
        <li>作品编排新颖独特，富有舞台表现力和感染力。<b>(1分)</b></li>
    </ol><br>
<b id="bb">请输入您的打分成绩:</b>&nbsp;&nbsp;<input type="text" id="name" name="username"/>
<!--<input type="text" id="myInput" name="myInput" placeholder="Enter your name" maxlength="20">-->
<br>

<button id="btn" class="tj" onclick="submit()" style="border: none; border-radius: 10px">提交成绩</button>
<b id="message" style="text-align: center; color: red;"></b>
<br />
<!-- <div>
    <h2 id="dd">江苏省无锡技师学院学生工处主办</h2>   <h2>信息工程系承办</h2>
</div> -->



<!--</form>-->
</div>

<p id="userName"></p>

     `,

    //在这里进行操作
    htmlMagic: async function (document1, promise) {
        // console.log(promise)
        document1.getElementById("indexHtml1").innerHTML = this.html; //需要跳转的地址
        document1.getElementById("userName").innerText=promise.data.userName;
        for(let data of promise.data.data){
            // console.log("输出:"+data.id+"   "+promise.data.seiect+"    "+data.id==promise.data.seiect)
            if(data.id===promise.data.seiect){
                document1.getElementById("jiemuming").innerText=data.id+"."+data.name;
            }
        }


        window.submit=function (){
          let sum=parseFloat(document1.getElementById("name").value); //拿到成绩

            if (isNaN(sum)) {
                document1.getElementById("message").innerText="请输入数字！"
                return;
            }
           else if (sum<8.0) {
                document1.getElementById("message").innerText="分数过低,请给予8.0以上的评分"
                return;
            }
           else if (sum>10.0) {
                document1.getElementById("message").innerText="分数过高,请给予10.0分以内的评分"
                return;
            }

            document1.getElementById("message").innerText=""
            let param={
               data:{
                    "grade":sum
               }
            }

            let promise1 = ajax1.ajaxPromise("song/add","get",param,$); //投票成功





        }

    }


};


export default MBRl;
